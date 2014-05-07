/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class ActivityInput {
	private Object parameter;
	private Object value;

	public ActivityInput(Object parameter, Object value) {
		this.parameter = parameter;
		this.value = value;
	}

	public Object getParameter() {
		return parameter;
	}

	public Object getValue() {
		return value;
	}
}