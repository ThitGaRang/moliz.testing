package org.modelexecution.fumltesting.ocl.internal.model;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Classifier;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Element;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;
import org.modelexecution.fumltesting.ocl.internal.FUMLMetamodelPlugin;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.model.base.AbstractModel;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModel extends AbstractModel implements IModel {

	private Namespace rootNamespace;
	private FUMLAdapterFactory factory;
	private Package rootPackage;

	public FUMLModel(Package rootPackage) {
		super("", ModelBusPlugin.getMetamodelRegistry().getMetamodel(FUMLMetamodelPlugin.ID));
		this.rootPackage = rootPackage;
		try {
			this.rootNamespace = getRootNamespace();
		} catch (ModelAccessException e) {
		}
		factory = new FUMLAdapterFactory(rootNamespace);
	}

	public Namespace getRootNamespace() throws ModelAccessException {
		if (rootNamespace == null) {
			rootNamespace = createRootNamespace(rootPackage);
		}
		return rootNamespace;
	}

	private void addNamespacesForReferencedPackages() {
		for (Element element : rootPackage.getOwnedElement()) {
			if (element instanceof Classifier) {
				Classifier classifier = (Classifier) element;
				Package containerPackage = classifier.getPackage();
				if (containerPackage == null || containerPackage instanceof Package) {
					Type importedType = factory.createType(classifier);
					if (!rootNamespace.getOwnedType().contains(importedType)) {
						if (importedType != null)
							rootNamespace.addType(importedType);
					}
				} else {
					while (containerPackage.getNestingPackage() != null && !(containerPackage.getNestingPackage() instanceof Package)) {
						containerPackage = containerPackage.getNestingPackage();
					}
					Namespace importedNamespace = factory.createNamespace(containerPackage, rootNamespace);
					if (!rootNamespace.getNestedNamespace().contains(importedNamespace)) {
						rootNamespace.addNestedNamespace(importedNamespace);
					}
				}
			} else if (element instanceof Package) {
				for (Package fumlPackage : ((Package) element).getNestedPackage()) {
					Namespace adaptedNamespace = factory.createNamespace(fumlPackage, rootNamespace);
					if (adaptedNamespace != null && !rootNamespace.equals(adaptedNamespace)
							&& !rootNamespace.getNestedNamespace().contains(adaptedNamespace)) {
						rootNamespace.addNestedNamespace(adaptedNamespace);
					}
				}
				for (org.modelexecution.fuml.Syntax.Classes.Kernel.Type fumlType : ((Package) element).getOwnedType()) {
					Type adaptedType = factory.createType(fumlType);
					if (adaptedType != null && !rootNamespace.getOwnedType().contains(adaptedType)) {
						rootNamespace.addType(adaptedType);
					}
				}
				Package importedPackage = (Package) element;
				if (importedPackage.getNestingPackage() == null || !(importedPackage.getNestingPackage() instanceof Package)) {
					Namespace importedNamespace = factory.createNamespace(importedPackage, rootNamespace);
					if (!rootNamespace.getNestedNamespace().contains(importedNamespace)) {
						rootNamespace.addNestedNamespace(importedNamespace);
					}
				}
			}
		}
	}

	protected Namespace createRootNamespace(Package rootPackage) throws ModelAccessException {
		if (rootNamespace == null) {
			rootNamespace = PivotModelFactory.eINSTANCE.createNamespace();
			rootNamespace.setName(rootPackage.getName());

			factory = new FUMLAdapterFactory(rootNamespace);

			for (Object object : rootPackage.getOwnedElement()) {
				if (object instanceof Package) {
					Namespace adaptedNamespace = factory.createNamespace((Package) object, rootNamespace);
					if (adaptedNamespace != null) {
						rootNamespace.addNestedNamespace(adaptedNamespace);
					}
				} else if (object instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Type) {
					Type adaptedType = factory.createType((org.modelexecution.fuml.Syntax.Classes.Kernel.Type) object);
					if (adaptedType != null) {
						rootNamespace.addType(adaptedType);
					}
				}
			}
			addNamespacesForReferencedPackages();
		}

		return rootNamespace;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FUMLModel) {
			return rootPackage == obj;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return rootPackage.hashCode();
	}

	@Override
	public String toString() {
		return rootPackage.toString();
	}

	@Override
	public void dispose() {
	}
}