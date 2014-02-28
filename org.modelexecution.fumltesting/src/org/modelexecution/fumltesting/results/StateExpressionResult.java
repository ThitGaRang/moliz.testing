/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import org.modelexecution.fumltesting.testLang.StateExpression;

/**
 * @author Stefan Mijatov
 * 
 */
public class StateExpressionResult {
	private StateExpression expression;
	private boolean validationResult;
	private String error;

	public StateExpressionResult(StateExpression expression) {
		this.expression = expression;
	}

	public void setValidationResult(boolean validationResult) {
		this.validationResult = validationResult;
	}

	public boolean getValidationResult() {
		return validationResult;
	}

	public StateExpression getStateExpression() {
		return expression;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
}