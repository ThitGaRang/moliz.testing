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

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLOperation extends AbstractOperation implements Operation {

	private org.modelexecution.fuml.Syntax.Classes.Kernel.Operation dslOperation;
	private FUMLAdapterFactory factory;

	public FUMLOperation(org.modelexecution.fuml.Syntax.Classes.Kernel.Operation dslOperation, FUMLAdapterFactory factory) {
		this.dslOperation = dslOperation;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslOperation.getName();
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslOperation.getType());
		if (dslOperation.getUpper() > 1) {
			if (dslOperation.isOrdered()) {
				if (dslOperation.isUnique()) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslOperation.isUnique()) {
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
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Parameter parameter : dslOperation.getOwnedParameter()) {
			result.add(factory.createParameter(parameter));
		}
		if (dslOperation.getType() == null) {
			result.add(getReturnParameter());
		}
		return result;
	}

	@Override
	public Type getOwningType() {
		Type result = null;
		if (dslOperation.getOwner() instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Type) {
			result = factory.createType((org.modelexecution.fuml.Syntax.Classes.Kernel.Class) dslOperation.getOwner());
		}
		return result;
	}

	public boolean isMultiple() {
		return dslOperation.getUpper() > 1;
	}

	public boolean isOrdered() {
		return dslOperation.isOrdered();
	}

	public boolean isUnique() {
		return dslOperation.isUnique();
	}
}