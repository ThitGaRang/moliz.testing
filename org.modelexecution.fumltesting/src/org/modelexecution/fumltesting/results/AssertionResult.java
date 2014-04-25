/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import org.modelexecution.fumltesting.testLang.Assertion;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public abstract class AssertionResult {
	private Assertion assertion;
	private String error;
	private boolean hasError = false;

	public void setAssertion(Assertion assertion) {
		this.assertion = assertion;
	}

	public Assertion getAssertion() {
		return assertion;
	}

	public void setError(String error) {
		this.error = error;
		this.hasError = true;
	}

	public String getError() {
		return error;
	}

	public boolean hasError() {
		return this.hasError;
	}

	public abstract boolean getAssertionValidationResult();
}