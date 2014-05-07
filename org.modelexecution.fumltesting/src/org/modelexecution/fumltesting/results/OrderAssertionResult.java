/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class OrderAssertionResult extends AssertionResult {

	private Object nodeOrderSpecification;
	private ArrayList<PathCheckResult> pathCheckResults;
	private ArrayList<OrderAssertionResult> subOrderAssertionResults;

	public OrderAssertionResult(Object nodeOrderSpecification) {
		this.nodeOrderSpecification = nodeOrderSpecification;
		pathCheckResults = new ArrayList<PathCheckResult>();
		subOrderAssertionResults = new ArrayList<OrderAssertionResult>();
	}

	public Object getNodeOrderSpecification() {
		return nodeOrderSpecification;
	}

	public void addPathCheckResult(PathCheckResult result) {
		pathCheckResults.add(result);
	}

	public void addSubOrderAssertionResult(OrderAssertionResult result) {
		subOrderAssertionResults.add(result);
	}

	public ArrayList<PathCheckResult> getFailedPathCheckResults() {
		ArrayList<PathCheckResult> failedPathCheckResults = new ArrayList<PathCheckResult>();
		for (PathCheckResult result : pathCheckResults) {
			if (result.getValidationResult() == false)
				failedPathCheckResults.add(result);
		}
		return failedPathCheckResults;
	}

	public ArrayList<OrderAssertionResult> getSubOrderResults() {
		return subOrderAssertionResults;
	}

	public ArrayList<OrderAssertionResult> getFailedSubOrderResults() {
		ArrayList<OrderAssertionResult> failedSubOrderResults = new ArrayList<OrderAssertionResult>();
		for (OrderAssertionResult result : subOrderAssertionResults) {
			if (result.getAssertionValidationResult() == false)
				failedSubOrderResults.add(result);
		}
		return failedSubOrderResults;
	}

	public int numberOfPathsChecked() {
		return pathCheckResults.size();
	}

	@Override
	public boolean getAssertionValidationResult() {
		for (PathCheckResult result : pathCheckResults) {
			if (result.getValidationResult() == false)
				return false;
		}
		for (OrderAssertionResult subResult : subOrderAssertionResults) {
			if (subResult.getAssertionValidationResult() == false)
				return false;
		}
		return true;
	}
}