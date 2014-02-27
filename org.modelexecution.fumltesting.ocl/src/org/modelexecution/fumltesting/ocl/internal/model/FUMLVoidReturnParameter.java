/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Operation;

import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.ParameterDirectionKind;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractParameter;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLVoidReturnParameter extends AbstractParameter implements Parameter {
	private Operation dslOperation;
	private FUMLAdapterFactory factory;

	public FUMLVoidReturnParameter(Operation dslOperation, FUMLAdapterFactory factory) {
		this.dslOperation = dslOperation;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return getKind().getName();
	}

	@Override
	public tudresden.ocl20.pivot.pivotmodel.Operation getOperation() {
		return factory.createOperation(dslOperation);
	}

	@Override
	public Type getType() {
		return factory.createPrimitiveType(null);
	}

	@Override
	public ParameterDirectionKind getKind() {
		return ParameterDirectionKind.RETURN;
	}
}