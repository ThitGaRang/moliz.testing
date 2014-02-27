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

	protected void setAssertion(Assertion assertion) {
		this.assertion = assertion;
	}

	protected Assertion getAssertion() {
		return assertion;
	}

	public abstract boolean getAssertionValidationResult();
}