package org.modelexecution.fumltesting.ocl.internal.model;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Association;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Element;
import org.modelexecution.fuml.Syntax.Classes.Kernel.TypedElement;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty;

/**
 * 
 * @author Stefan
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
		return dslAssociation.getName();
	}

	@Override
	public Type getType() {
		Type result = null;
		Type elementType = factory.createType(dslAssociation.getEndType().get(0));
		if (dslAssociation.getMemberEnd().get(0).getUpper() > 0) {
			if (dslAssociation.getMemberEnd().get(0).isOrdered()) {
				if (dslAssociation.getMemberEnd().get(0).isUnique()) {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOrderedSetType(elementType);
				} else {
					result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getSequenceType(elementType);
				}
			} else {
				if (dslAssociation.getMemberEnd().get(0).isUnique()) {
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
		Element owner = dslAssociation.getOwner();
		if (owner instanceof TypedElement) {
			TypedElement typedElement = (TypedElement) owner;
			result = factory.createType(typedElement.getType());
		} else if (owner instanceof Class) {
			Class clazz = (Class) owner;
			result = factory.createClass(clazz);
		}
		return result;
	}
}