/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * @author Stefan Mijatov
 * 
 */
public class Link {
	private Association association;
	private Property sourceProperty;
	private Property targetProperty;
	private ObjectSpecification sourceValue;
	private ObjectSpecification targetValue;
	private Scenario container;

	public Association getAssociation() {
		return this.association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public Property getSourceProperty() {
		return this.sourceProperty;
	}

	public void setSourceProperty(Property sourceProperty) {
		this.sourceProperty = sourceProperty;
	}

	public ObjectSpecification getSourceValue() {
		return this.sourceValue;
	}

	public void setSourceValue(ObjectSpecification sourceValue) {
		this.sourceValue = sourceValue;
	}

	public Property getTargetProperty() {
		return this.targetProperty;
	}

	public void setTargetProperty(Property targetProperty) {
		this.targetProperty = targetProperty;
	}

	public ObjectSpecification getTargetValue() {
		return this.targetValue;
	}

	public void setTargetValue(ObjectSpecification targetValue) {
		this.targetValue = targetValue;
	}

	public Scenario getContainer() {
		return this.container;
	}

	public void setContainer(Scenario container) {
		this.container = container;
	}
}