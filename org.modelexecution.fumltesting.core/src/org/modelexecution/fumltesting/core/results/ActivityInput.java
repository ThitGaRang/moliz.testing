/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import org.modelexecution.fumltesting.core.testlang.Value;

import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class ActivityInput {
	private ActivityParameterNode parameter;
	private Value value;

	public ActivityInput(ActivityParameterNode parameter, Value value) {
		this.parameter = parameter;
		this.value = value;
	}

	public ActivityParameterNode getParameter() {
		return parameter;
	}

	public Value getValue() {
		return value;
	}
}