/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.xtext;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ControlNode;
import org.eclipse.uml2.uml.ObjectNode;
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
		Class class_ = (Class) property.getOwner();
		return QualifiedName.create(class_.getName(), property.getName());
	}

	protected QualifiedName qualifiedName(Action action) {
		Activity activity = (Activity) action.getOwner();
		Class class_ = (Class) activity.getOwner();
		return QualifiedName.create(class_.getName(), activity.getName(), action.getName());
	}

	protected QualifiedName qualifiedName(ControlNode node) {
		Activity activity = (Activity) node.getOwner();
		Class class_ = (Class) activity.getOwner();
		return QualifiedName.create(class_.getName(), activity.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ActivityParameterNode node) {
		Activity activity = (Activity) node.getOwner();
		Class class_ = (Class) activity.getOwner();
		return QualifiedName.create(class_.getName(), activity.getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ObjectNode node) {
		if (node.getOwner() instanceof Activity) {
			Activity activity = (Activity) node.getOwner();
			Class class_ = (Class) activity.getOwner();
			return QualifiedName.create(class_.getName(), activity.getName(), node.getName());
		}
		if (node.getOwner() instanceof Action) {
			Action action = (Action) node.getOwner();
			Activity activity = (Activity) action.getOwner();
			Class class_ = (Class) activity.getOwner();
			return QualifiedName.create(class_.getName(), activity.getName(), action.getName(), node.getName());
		}
		return null;
	}

	protected QualifiedName qualifiedName(Activity activity) {
		Class owner = (Class) activity.getOwner();
		return QualifiedName.create(owner.getName(), activity.getName());
	}

	protected QualifiedName qualifiedName(Association association) {
		return QualifiedName.create(association.getName());
	}
}