package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;

import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractNamespace;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLPackage extends AbstractNamespace implements Namespace {
	private FUMLAdapterFactory factory;
	private Set<Package> mergedPackages = new HashSet<Package>();
	private Namespace nestingNamespace;

	public FUMLPackage(Package dslPackage, Namespace nestingNamespace, FUMLAdapterFactory factory) {
		mergedPackages.add(dslPackage);
		this.nestingNamespace = nestingNamespace;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return mergedPackages.iterator().next().getName();
	}

	@Override
	public Namespace getNestingNamespace() {
		return nestingNamespace;
	}

	@Override
	public List<Type> getOwnedType() {
		List<Type> result = new BasicEList<Type>();
		for (Package mergedPackage : mergedPackages) {
			for (org.modelexecution.fuml.Syntax.Classes.Kernel.Type containedType : mergedPackage.getOwnedType()) {
				Type type = factory.createType(containedType);
				if (type != null) {
					result.add(type);
				}
			}
		}
		return result;
	}

	@Override
	protected List<Namespace> getNestedNamespaceImpl() {
		List<Namespace> result = new ArrayList<Namespace>();
		for (Package mergedPackage : mergedPackages) {
			for (Package nestedDslNamespace : mergedPackage.getNestedPackage()) {
				result.add(factory.createNamespace(nestedDslNamespace, this));
			}
		}
		return result;
	}

	protected void mergePackage(Package fumlPackage) {
		if (!mergedPackages.contains(fumlPackage)) {
			if (mergedPackages.iterator().next().getQualifiedName().equals(fumlPackage.getQualifiedName())) {
				mergedPackages.add(fumlPackage);
			} else {
				throw new IllegalArgumentException("Cannot merge package " + fumlPackage.getQualifiedName()
						+ " to package " + mergedPackages.iterator().next().getQualifiedName() + ".");
			}
		}
	}
}