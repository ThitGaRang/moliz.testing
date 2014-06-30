/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestCaseResult {
	private String name = null;
	private ActivityExecution activityUT = null;
	private Object context = null;
	private ArrayList<ActivityInput> inputValues = new ArrayList<ActivityInput>();
	private ArrayList<AssertionResult> assertionResults = new ArrayList<AssertionResult>();

	public TestCaseResult(String name, ActivityExecution activityUT) {
		this.name = name;
		this.activityUT = activityUT;
	}

	public String getTestCaseName() {
		return name;
	}

	public ActivityExecution getActivityUnderTest() {
		return activityUT;
	}

	public void addActivityInputValue(ActivityInput activityInput) {
		inputValues.add(activityInput);
	}

	public ArrayList<ActivityInput> getActivityInputValues() {
		return inputValues;
	}

	public void setActivityContextObject(Object context) {
		this.context = context;
	}

	public Object getActivityContextObject() {
		return context;
	}

	public void addAssertionResult(AssertionResult assertionResult) {
		assertionResults.add(assertionResult);
	}

	public ArrayList<AssertionResult> getAssertionResults() {
		return assertionResults;
	}

	public boolean getTestCaseValidationResult() {
		for (AssertionResult result : assertionResults) {
			if (!result.getAssertionValidationResult())
				return false;
		}
		return true;
	}
}