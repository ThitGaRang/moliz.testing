/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Parameter;
import org.dresdenocl.pivotmodel.Type;
import org.dresdenocl.pivotmodel.base.AbstractOperation;

import fUML.Syntax.Classes.Kernel.Class_;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLOperation extends AbstractOperation implements Operation {

	private fUML.Syntax.Classes.Kernel.Operation dslOperation;
	private FUMLAdapterFactory factory;

	public FUMLOperation(fUML.Syntax.Classes.Kernel.Operation dslOperation, FUMLAdapterFactory factory) {
		this.dslOperation = dslOperation;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslOperation.name;
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslOperation.type);
		if (dslOperation.upper.naturalValue > 1) {
			if (dslOperation.isOrdered) {
				if (dslOperation.isUnique) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslOperation.isUnique) {
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

	@Override
	public List<Parameter> getOwnedParameter() {
		List<Parameter> result = new ArrayList<Parameter>();
		for (fUML.Syntax.Classes.Kernel.Parameter parameter : dslOperation.ownedParameter) {
			result.add(factory.createParameter(parameter));
		}
		if (dslOperation.type == null) {
			result.add(getReturnParameter());
		}
		return result;
	}

	@Override
	public Type getOwningType() {
		Type result = null;
		if (dslOperation.owner instanceof fUML.Syntax.Classes.Kernel.Type) {
			result = factory.createType((Class_) dslOperation.owner);
		}
		return result;
	}

	public boolean isMultiple() {
		return dslOperation.upper.naturalValue > 1;
	}

	public boolean isOrdered() {
		return dslOperation.isOrdered;
	}

	public boolean isUnique() {
		return dslOperation.isUnique;
	}
}