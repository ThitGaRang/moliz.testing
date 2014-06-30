/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.pivotmodel.Property;
import org.dresdenocl.pivotmodel.Type;
import org.dresdenocl.pivotmodel.base.AbstractProperty;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.TypedElement;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLAssociation extends AbstractProperty implements Property {
	private Association dslAssociation;
	private FUMLAdapterFactory factory;

	public FUMLAssociation(Association dslAssociation, FUMLAdapterFactory factory) {
		this.dslAssociation = dslAssociation;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslAssociation.name;
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslAssociation.endType.get(0));
		if (dslAssociation.memberEnd.get(0).multiplicityElement.upper.naturalValue > 0) {
			if (dslAssociation.memberEnd.get(0).multiplicityElement.isOrdered) {
				if (dslAssociation.memberEnd.get(0).multiplicityElement.isUnique) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslAssociation.memberEnd.get(0).multiplicityElement.isUnique) {
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
	public Type getOwningType() {
		Type result = null;
		Element owner = dslAssociation.owner;
		if (owner instanceof TypedElement) {
			TypedElement typedElement = (TypedElement) owner;
			result = factory.createType(typedElement.type);
		} else if (owner instanceof Class_) {
			Class_ clazz = (Class_) owner;
			result = factory.createClass(clazz);
		}
		return result;
	}
}