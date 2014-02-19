package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import tudresden.ocl20.pivot.pivotmodel.Enumeration;
import tudresden.ocl20.pivot.pivotmodel.EnumerationLiteral;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractEnumeration;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLEnumeration extends AbstractEnumeration implements Enumeration {
	private org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration dslEnumeration;
	private FUMLAdapterFactory factory;

	public FUMLEnumeration(org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration dslEnumeration,
			FUMLAdapterFactory factory) {
		this.dslEnumeration = dslEnumeration;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslEnumeration.getName();
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslEnumeration.getPackage());
	}

	@Override
	public List<EnumerationLiteral> getOwnedLiteral() {
		List<EnumerationLiteral> result = new ArrayList<EnumerationLiteral>();
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.EnumerationLiteral enumerationLiteral : dslEnumeration
				.getOwnedLiteral()) {
			result.add(factory.createEnumerationLiteral(enumerationLiteral));
		}
		return result;
	}
}