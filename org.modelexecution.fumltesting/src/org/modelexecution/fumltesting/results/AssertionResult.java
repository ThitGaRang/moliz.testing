package org.modelexecution.fumltesting.results;

import org.modelexecution.fumltesting.testLang.Assertion;

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