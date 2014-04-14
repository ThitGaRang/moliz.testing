/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import org.modelexecution.fumltesting.results.AssertionResult;
import org.modelexecution.fumltesting.results.OrderAssertionResult;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.trace.TraceUtil;

/**
 * Composition class for delegating assertion validation to specific classes.
 * 
 * @author Stefan Mijatov
 * 
 */
public class AssertionValidator {

	private OrderAssertionValidator orderValidator;
	private StateAssertionValidator stateValidator;
	private TraceUtil traceUtil;

	public AssertionValidator(int activityExecutionID) {
		traceUtil = new TraceUtil(activityExecutionID);
		stateValidator = new StateAssertionValidator(traceUtil);
		orderValidator = new OrderAssertionValidator();
	}

	public AssertionResult check(Assertion assertion) {
		if (assertion instanceof OrderAssertion) {
			OrderAssertionResult result = orderValidator.checkOrder((OrderAssertion) assertion, traceUtil);
			if (result.getAssertionValidationResult())
				System.out.println("Assertion success!");
			else
				System.out.println("Assertion failed!");
			return result;
		}
		if (assertion instanceof StateAssertion) {
			return stateValidator.check((StateAssertion) assertion);
		}
		if (assertion instanceof FinallyStateAssertion) {
			return stateValidator.check((FinallyStateAssertion) assertion);
		}
		return null;
	}
}