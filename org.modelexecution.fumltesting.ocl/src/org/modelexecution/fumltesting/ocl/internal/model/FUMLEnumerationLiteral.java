/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import tudresden.ocl20.pivot.pivotmodel.Enumeration;
import tudresden.ocl20.pivot.pivotmodel.EnumerationLiteral;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractEnumerationLiteral;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLEnumerationLiteral extends AbstractEnumerationLiteral implements EnumerationLiteral {
	private org.modelexecution.fuml.Syntax.Classes.Kernel.EnumerationLiteral dslEnumerationLiteral;
	private FUMLAdapterFactory factory;

	public FUMLEnumerationLiteral(org.modelexecution.fuml.Syntax.Classes.Kernel.EnumerationLiteral dslEnumerationLiteral, FUMLAdapterFactory factory) {
		this.dslEnumerationLiteral = dslEnumerationLiteral;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslEnumerationLiteral.getName();
	}

	@Override
	public Enumeration getEnumeration() {
		return factory.createEnumeration(dslEnumerationLiteral.getEnumeration());
	}
}