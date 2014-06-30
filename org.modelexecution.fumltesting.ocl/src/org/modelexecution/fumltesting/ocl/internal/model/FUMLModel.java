/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.dresdenocl.model.IModel;
import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.model.base.AbstractModel;
import org.dresdenocl.modelbus.ModelBusPlugin;
import org.dresdenocl.pivotmodel.Namespace;
import org.dresdenocl.pivotmodel.PivotModelFactory;
import org.dresdenocl.pivotmodel.Type;
import org.modelexecution.fumltesting.ocl.internal.FUMLMetamodelPlugin;

import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.Element;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLModel extends AbstractModel implements IModel {

	private Namespace rootNamespace;
	private FUMLAdapterFactory factory;
	private fUML.Syntax.Classes.Kernel.Package rootPackage;

	public FUMLModel(fUML.Syntax.Classes.Kernel.Package rootPackage) {
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
		for (Element element : rootPackage.ownedElement) {
			if (element instanceof Classifier) {
				Classifier classifier = (Classifier) element;
				fUML.Syntax.Classes.Kernel.Package containerPackage = classifier.package_;
				if (containerPackage == null || containerPackage instanceof fUML.Syntax.Classes.Kernel.Package) {
					Type importedType = factory.createType(classifier);
					if (!rootNamespace.getOwnedType().contains(importedType)) {
						if (importedType != null)
							rootNamespace.addType(importedType);
					}
				} else {
					while (containerPackage.nestingPackage != null && !(containerPackage.nestingPackage instanceof fUML.Syntax.Classes.Kernel.Package)) {
						containerPackage = containerPackage.nestingPackage;
					}
					Namespace importedNamespace = factory.createNamespace(containerPackage, rootNamespace);
					if (!rootNamespace.getNestedNamespace().contains(importedNamespace)) {
						rootNamespace.addNestedNamespace(importedNamespace);
					}
				}
			} else if (element instanceof fUML.Syntax.Classes.Kernel.Package) {
				for (fUML.Syntax.Classes.Kernel.Package fumlPackage : ((fUML.Syntax.Classes.Kernel.Package) element).nestedPackage) {
					Namespace adaptedNamespace = factory.createNamespace(fumlPackage, rootNamespace);
					if (adaptedNamespace != null && !rootNamespace.equals(adaptedNamespace) && !rootNamespace.getNestedNamespace().contains(adaptedNamespace)) {
						rootNamespace.addNestedNamespace(adaptedNamespace);
					}
				}
				for (fUML.Syntax.Classes.Kernel.Type fumlType : ((fUML.Syntax.Classes.Kernel.Package) element).ownedType) {
					Type adaptedType = factory.createType(fumlType);
					if (adaptedType != null && !rootNamespace.getOwnedType().contains(adaptedType)) {
						rootNamespace.addType(adaptedType);
					}
				}
				fUML.Syntax.Classes.Kernel.Package importedPackage = (fUML.Syntax.Classes.Kernel.Package) element;
				if (importedPackage.nestingPackage == null || !(importedPackage.nestingPackage instanceof fUML.Syntax.Classes.Kernel.Package)) {
					Namespace importedNamespace = factory.createNamespace(importedPackage, rootNamespace);
					if (!rootNamespace.getNestedNamespace().contains(importedNamespace)) {
						rootNamespace.addNestedNamespace(importedNamespace);
					}
				}
			}
		}
	}

	protected Namespace createRootNamespace(fUML.Syntax.Classes.Kernel.Package rootPackage) throws ModelAccessException {
		if (rootNamespace == null) {
			rootNamespace = PivotModelFactory.eINSTANCE.createNamespace();
			rootNamespace.setName(rootPackage.name);

			factory = new FUMLAdapterFactory(rootNamespace);

			for (Object object : rootPackage.ownedElement) {
				if (object instanceof fUML.Syntax.Classes.Kernel.Package) {
					Namespace adaptedNamespace = factory.createNamespace((fUML.Syntax.Classes.Kernel.Package) object, rootNamespace);
					if (adaptedNamespace != null) {
						rootNamespace.addNestedNamespace(adaptedNamespace);
					}
				} else if (object instanceof fUML.Syntax.Classes.Kernel.Type) {
					Type adaptedType = factory.createType((fUML.Syntax.Classes.Kernel.Type) object);
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