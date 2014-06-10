/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.xtext;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class UmlQualifiedNameProvider extends XbaseQualifiedNameProvider {
	protected QualifiedName qualifiedName(Property property) {
		NamedElement owner = (NamedElement) property.getOwner();
		return QualifiedName.create(owner.getName(), property.getName());
	}

	protected QualifiedName qualifiedName(Action action) {
		NamedElement owner = (NamedElement) action.getOwner();
		return QualifiedName.create(owner.getName(), action.getName());
	}

	protected QualifiedName qualifiedName(InitialNode node) {
		NamedElement owner = (NamedElement) node.getOwner();
		return QualifiedName.create(owner.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ActivityFinalNode node) {
		NamedElement owner = (NamedElement) node.getOwner();
		return QualifiedName.create(owner.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ActivityParameterNode node) {
		return QualifiedName.create(node.getActivity().getName(), node.getName());
	}

	protected QualifiedName qualifiedName(Pin node) {
		Activity activity = (Activity) node.eContainer().eContainer();
		Action action = (Action) node.eContainer();
		return QualifiedName.create(activity.getName(), action.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ObjectNode node) {
		NamedElement owner = (NamedElement) node.getOwner();
		return QualifiedName.create(owner.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(Activity activity) {
		Class owner = (Class) activity.getOwner();
		return QualifiedName.create(owner.getName(), activity.getName());
	}
}