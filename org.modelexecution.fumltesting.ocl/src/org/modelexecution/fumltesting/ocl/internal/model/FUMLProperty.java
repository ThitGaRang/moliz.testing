/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.eclipse.emf.common.util.EList;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Association;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Element;
import org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType;
import org.modelexecution.fuml.Syntax.Classes.Kernel.TypedElement;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLProperty extends AbstractProperty implements Property {

	protected org.modelexecution.fuml.Syntax.Classes.Kernel.Property dslProperty;
	protected FUMLAdapterFactory factory;

	public FUMLProperty(org.modelexecution.fuml.Syntax.Classes.Kernel.Property dslProperty, FUMLAdapterFactory factory) {
		this.dslProperty = dslProperty;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslProperty.getName();
	}

	@Override
	public Type getOwningType() {
		Type result = null;
		Element owner = dslProperty.getOwner();
		if (owner instanceof PrimitiveType) {
			PrimitiveType primitiveType = (PrimitiveType) owner;
			result = factory.createPrimitiveType(primitiveType);
		} else if (owner instanceof TypedElement) {
			TypedElement typedElement = (TypedElement) owner;
			result = factory.createType(typedElement.getType());
		} else if (owner instanceof Class) {
			Class clazz = (Class) owner;
			result = factory.createClass(clazz);
		} else if (owner instanceof Association) {
			Association association = (Association) owner;
			EList<org.modelexecution.fuml.Syntax.Classes.Kernel.Property> associationEnds = association.getOwnedEnd();
			for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property end : associationEnds) {
				if (!end.equals(dslProperty)) {
					result = factory.createType(end.getType());
					break;
				}
			}
		}
		return result;
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslProperty.getType());
		if (dslProperty.getUpper() > 1) {
			if (dslProperty.isOrdered()) {
				if (dslProperty.isUnique()) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslProperty.isUnique()) {
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

	public boolean isMultiple() {
		return dslProperty.getUpper() > 1;
	}

	public boolean isOrdered() {
		return dslProperty.isOrdered();
	}

	public boolean isUnique() {
		return dslProperty.isUnique();
	}

	public boolean isStatic() {
		return dslProperty.isStatic();
	}
}