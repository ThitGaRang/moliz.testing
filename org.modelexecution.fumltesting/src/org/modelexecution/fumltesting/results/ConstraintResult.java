/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import org.modelexecution.fumltesting.testLang.StateAssertion;

/**
 * @author Stefan Mijatov
 * 
 */
public class ConstraintResult {
	private String constraint;
	private StateAssertion assertion;
	private boolean validationResult;

	public ConstraintResult(String constraint, StateAssertion assertion) {
		this.constraint = constraint;
		this.assertion = assertion;
	}

	public String getConstraint() {
		return constraint;
	}

	public StateAssertion getAssertion() {
		return assertion;
	}

	public void setValidationResult(boolean validationResult) {
		this.validationResult = validationResult;
	}

	public boolean getValidationResult() {
		return validationResult;
	}
}