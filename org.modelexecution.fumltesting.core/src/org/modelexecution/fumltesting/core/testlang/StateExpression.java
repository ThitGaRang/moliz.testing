/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;

/**
 * @author Stefan Mijatov
 * 
 */
public class StateExpression extends Check {
	private ObjectNode pin;
	private ArithmeticOperator operator;
	private Value value;

	public ObjectNode getPin() {
		return this.pin;
	}

	public void setPin(ObjectNode pin) {
		this.pin = pin;
	}

	public ArithmeticOperator getOperator() {
		return this.operator;
	}

	public void setOperator(ArithmeticOperator operator) {
		this.operator = operator;
	}

	public Value getValue() {
		return this.value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}