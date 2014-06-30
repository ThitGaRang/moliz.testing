/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.dresdenocl.pivotmodel.Enumeration;
import org.dresdenocl.pivotmodel.EnumerationLiteral;
import org.dresdenocl.pivotmodel.Namespace;
import org.dresdenocl.pivotmodel.base.AbstractEnumeration;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLEnumeration extends AbstractEnumeration implements Enumeration {
	private fUML.Syntax.Classes.Kernel.Enumeration dslEnumeration;
	private FUMLAdapterFactory factory;

	public FUMLEnumeration(fUML.Syntax.Classes.Kernel.Enumeration dslEnumeration, FUMLAdapterFactory factory) {
		this.dslEnumeration = dslEnumeration;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslEnumeration.name;
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslEnumeration.package_);
	}

	@Override
	public List<EnumerationLiteral> getOwnedLiteral() {
		List<EnumerationLiteral> result = new ArrayList<EnumerationLiteral>();
		for (fUML.Syntax.Classes.Kernel.EnumerationLiteral enumerationLiteral : dslEnumeration.ownedLiteral) {
			result.add(factory.createEnumerationLiteral(enumerationLiteral));
		}
		return result;
	}
}