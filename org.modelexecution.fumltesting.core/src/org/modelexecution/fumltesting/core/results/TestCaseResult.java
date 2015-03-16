/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumltesting.core.testlang.ObjectSpecification;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestCaseResult {
	private String name = null;
	private ActivityExecution activityUT = null;
	private ObjectSpecification context = null;
	private ArrayList<ActivityInput> inputValues = new ArrayList<ActivityInput>();
	private ArrayList<AssertionResult> assertionResults = new ArrayList<AssertionResult>();
	private boolean hasError = false;
	private String error = "";
	private long runningTime;

	public TestCaseResult(String name, ActivityExecution activityUT, boolean hasError) {
		this.name = name;
		this.activityUT = activityUT;
		this.hasError = hasError;
	}

	public boolean hasError() {
		return hasError;
	}

	public String getError() {
		if (error.equals("")) {
			return "There were no errors!";
		} else {
			return error;
		}
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTestCaseName() {
		return name;
	}

	public void setRunningTime(long runningTime) {
		this.runningTime = runningTime;
	}

	public long getRunningTime() {
		return runningTime;
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

	public void setActivityContextObject(ObjectSpecification context) {
		this.context = context;
	}

	public ObjectSpecification getActivityContextObject() {
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
			if (!result.getResult())
				return false;
		}
		return true;
	}
}