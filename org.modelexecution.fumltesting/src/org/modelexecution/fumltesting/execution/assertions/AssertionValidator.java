/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.results.AssertionResult;
import org.modelexecution.fumltesting.results.OrderAssertionResult;
import org.modelexecution.fumltesting.results.PathCheckResult;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;

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
			OrderAssertionResult result = new OrderAssertionResult(((OrderAssertion) assertion).getOrder());
			result.setAssertion(assertion);

			String parentNodeName = ((TestCase) assertion.eContainer()).getActivityUnderTest().getName();
			List<NodeSpecification> nodeOrder = ((OrderAssertion) assertion).getOrder().getNodes();
			AssertionPrinter.printOrderSpecification(nodeOrder);
			System.out.println("Checking order assertion against " + traceUtil.getAllPaths().size() + " generated paths..");
			for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
				PathCheckResult pathCheckResult = new PathCheckResult(path);
				boolean validationResult = orderValidator.checkOrder(parentNodeName, nodeOrder, path);
				pathCheckResult.setValidationResult(validationResult);
				result.addPathCheckResult(pathCheckResult);
			}
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