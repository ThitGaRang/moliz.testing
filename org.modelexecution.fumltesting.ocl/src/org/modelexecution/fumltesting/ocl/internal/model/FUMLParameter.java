/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Parameter;
import org.dresdenocl.pivotmodel.ParameterDirectionKind;
import org.dresdenocl.pivotmodel.Type;
import org.dresdenocl.pivotmodel.base.AbstractParameter;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLParameter extends AbstractParameter implements Parameter {
	private fUML.Syntax.Classes.Kernel.Parameter dslParameter;
	private FUMLAdapterFactory factory;

	public FUMLParameter(fUML.Syntax.Classes.Kernel.Parameter dslParameter, FUMLAdapterFactory factory) {
		this.dslParameter = dslParameter;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslParameter.name;
	}

	@Override
	public Operation getOperation() {
		return factory.createOperation((fUML.Syntax.Classes.Kernel.Operation) dslParameter.owner);
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslParameter.type);
		if (dslParameter.multiplicityElement.upper.naturalValue > 1) {
			if (dslParameter.multiplicityElement.isOrdered) {
				if (dslParameter.multiplicityElement.isUnique) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslParameter.multiplicityElement.isUnique) {
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
		fUML.Syntax.Classes.Kernel.ParameterDirectionKind dslKind = dslParameter.direction;
		if (dslKind == fUML.Syntax.Classes.Kernel.ParameterDirectionKind.in) {
			kind = ParameterDirectionKind.IN;
		} else if (dslKind == fUML.Syntax.Classes.Kernel.ParameterDirectionKind.out) {
			kind = ParameterDirectionKind.OUT;
		} else if (dslKind == fUML.Syntax.Classes.Kernel.ParameterDirectionKind.inout) {
			kind = ParameterDirectionKind.INOUT;
		} else if (dslKind == fUML.Syntax.Classes.Kernel.ParameterDirectionKind.return_) {
			kind = ParameterDirectionKind.RETURN;
		}
		return kind;
	}

	public boolean isMultiple() {
		return dslParameter.multiplicityElement.upper.naturalValue > 1;
	}

	public boolean isOrdered() {
		return dslParameter.multiplicityElement.isOrdered;
	}

	public boolean isUnique() {
		return dslParameter.multiplicityElement.isUnique;
	}
}