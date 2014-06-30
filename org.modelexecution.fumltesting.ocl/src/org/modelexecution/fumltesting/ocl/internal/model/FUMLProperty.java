/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.List;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.pivotmodel.Property;
import org.dresdenocl.pivotmodel.Type;
import org.dresdenocl.pivotmodel.base.AbstractProperty;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.PrimitiveType;
import fUML.Syntax.Classes.Kernel.TypedElement;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLProperty extends AbstractProperty implements Property {

	protected fUML.Syntax.Classes.Kernel.Property dslProperty;
	protected FUMLAdapterFactory factory;

	public FUMLProperty(fUML.Syntax.Classes.Kernel.Property dslProperty, FUMLAdapterFactory factory) {
		this.dslProperty = dslProperty;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslProperty.name;
	}

	@Override
	public Type getOwningType() {
		Type result = null;
		Element owner = dslProperty.owner;
		if (owner instanceof PrimitiveType) {
			PrimitiveType primitiveType = (PrimitiveType) owner;
			result = factory.createPrimitiveType(primitiveType);
		} else if (owner instanceof TypedElement) {
			TypedElement typedElement = (TypedElement) owner;
			result = factory.createType(typedElement.type);
		} else if (owner instanceof Class_) {
			Class_ clazz = (Class_) owner;
			result = factory.createClass(clazz);
		} else if (owner instanceof Association) {
			Association association = (Association) owner;
			List<fUML.Syntax.Classes.Kernel.Property> associationEnds = association.ownedEnd;
			for (fUML.Syntax.Classes.Kernel.Property end : associationEnds) {
				if (!end.equals(dslProperty)) {
					result = factory.createType(end.typedElement.type);
					setOwningType(result);
					break;
				}
			}
		}
		return result;
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslProperty.typedElement.type);
		if (dslProperty.multiplicityElement.upper.naturalValue > 1) {
			if (dslProperty.multiplicityElement.isOrdered) {
				if (dslProperty.multiplicityElement.isUnique) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslProperty.multiplicityElement.isUnique) {
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
		return dslProperty.multiplicityElement.upper.naturalValue > 1;
	}

	public boolean isOrdered() {
		return dslProperty.multiplicityElement.isOrdered;
	}

	public boolean isUnique() {
		return dslProperty.multiplicityElement.isUnique;
	}

	public boolean isStatic() {
		return dslProperty.isStatic;
	}

	public fUML.Syntax.Classes.Kernel.Property getDslProperty() {
		return dslProperty;
	}
}