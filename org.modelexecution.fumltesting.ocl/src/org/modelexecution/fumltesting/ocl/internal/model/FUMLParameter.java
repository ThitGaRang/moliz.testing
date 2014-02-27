/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.ParameterDirectionKind;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractParameter;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLParameter extends AbstractParameter implements Parameter {
	private org.modelexecution.fuml.Syntax.Classes.Kernel.Parameter dslParameter;
	private FUMLAdapterFactory factory;

	public FUMLParameter(org.modelexecution.fuml.Syntax.Classes.Kernel.Parameter dslParameter, FUMLAdapterFactory factory) {
		this.dslParameter = dslParameter;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslParameter.getName();
	}

	@Override
	public Operation getOperation() {
		return factory.createOperation((org.modelexecution.fuml.Syntax.Classes.Kernel.Operation) dslParameter.getOwner());
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslParameter.getType());
		if (dslParameter.getUpper() > 1) {
			if (dslParameter.isOrdered()) {
				if (dslParameter.isUnique()) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslParameter.isUnique()) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getBagType(elementType);
				}
			}
		} else {
			result = elementType;
		}
		return result;
	}

	public ParameterDirectionKind getKind() {
		org.modelexecution.fuml.Syntax.Classes.Kernel.ParameterDirectionKind dslKind = dslParameter.getDirection();
		if (dslKind.getValue() == org.modelexecution.fuml.Syntax.Classes.Kernel.ParameterDirectionKind.IN_VALUE) {
			kind = ParameterDirectionKind.IN;
		} else if (dslKind.getValue() == org.modelexecution.fuml.Syntax.Classes.Kernel.ParameterDirectionKind.OUT_VALUE) {
			kind = ParameterDirectionKind.OUT;
		} else if (dslKind.getValue() == org.modelexecution.fuml.Syntax.Classes.Kernel.ParameterDirectionKind.INOUT_VALUE) {
			kind = ParameterDirectionKind.INOUT;
		} else if (dslKind.getValue() == org.modelexecution.fuml.Syntax.Classes.Kernel.ParameterDirectionKind.RETURN_VALUE) {
			kind = ParameterDirectionKind.RETURN;
		}
		return kind;
	}

	public boolean isMultiple() {
		return dslParameter.getUpper() > 1;
	}

	public boolean isOrdered() {
		return dslParameter.isOrdered();
	}

	public boolean isUnique() {
		return dslParameter.isUnique();
	}
}