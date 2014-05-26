/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.eclipse.xtext.uml;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
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
		return QualifiedName.create(property.getName());
	}

	protected QualifiedName qualifiedName(Action action) {
		return QualifiedName.create(((NamedElement) action.eContainer()).getName(), action.getName());
	}

	protected QualifiedName qualifiedName(InitialNode node) {
		return QualifiedName.create(((NamedElement) node.eContainer()).getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ActivityFinalNode node) {
		return QualifiedName.create(((NamedElement) node.eContainer()).getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ActivityParameterNode node) {
		return QualifiedName.create(node.getName());
	}

	protected QualifiedName qualifiedName(Pin node) {
		return QualifiedName.create(((NamedElement) node.eContainer()).getName(), node.getName());
	}

	protected QualifiedName qualifiedName(ObjectNode node) {
		return QualifiedName.create(((NamedElement) node.eContainer()).getName(), node.getName());
	}
}