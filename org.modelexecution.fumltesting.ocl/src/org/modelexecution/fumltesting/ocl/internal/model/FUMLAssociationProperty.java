package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.LinkedList;
import java.util.List;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Property;
import tudresden.ocl20.pivot.pivotmodel.AssociationProperty;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLAssociationProperty extends FUMLProperty implements AssociationProperty {
	private List<AssociationProperty> inverseAssociationProperties;

	public FUMLAssociationProperty(Property dslProperty, FUMLAdapterFactory factory) {
		super(dslProperty, factory);
	}

	@Override
	public void addAssociation(AssociationProperty property) {
		if (!isInverseAssociation(property) && property != this && property != null)
			getInverseAssociationProperties().add(property);
	}

	@Override
	public AssociationProperty getAssociation(String propertyName) {
		AssociationProperty property = null;
		for (AssociationProperty aProperty : getInverseAssociationProperties()) {
			if (aProperty.getName().equals(propertyName)) {
				property = aProperty;
				break;
			}
		}
		return property;
	}

	@Override
	public void removeAssociation(AssociationProperty property) {
		getInverseAssociationProperties().remove(property);
	}

	@Override
	public List<AssociationProperty> getInverseAssociationProperties() {
		if (inverseAssociationProperties == null) {
			inverseAssociationProperties = new LinkedList<AssociationProperty>();
		}
		return inverseAssociationProperties;
	}

	@Override
	public boolean isInverseAssociation(AssociationProperty property) {
		return getInverseAssociationProperties().contains(property);
	}

	@Override
	public void addAssociations(List<AssociationProperty> properties) {
		for (AssociationProperty property : properties) {
			addAssociation(property);
		}
	}

	public boolean isNavigable() {
		return dslProperty.getAssociation().getNavigableOwnedEnd().contains(dslProperty);
	}
}