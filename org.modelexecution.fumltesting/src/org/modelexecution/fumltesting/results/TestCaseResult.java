package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Activity;

public class TestCaseResult {
	private String testCaseName = null;
	private Activity activityUnderTest = null;
	private Object activityContextObject = null;
	private ArrayList<ActivityInput> activityInputValues = new ArrayList<ActivityInput>();		
	private ArrayList<AssertionResult> assertionResults = new ArrayList<AssertionResult>();

	public TestCaseResult(String testCaseName, Activity activityUnderTest) {
		this.testCaseName = testCaseName;
		this.activityUnderTest = activityUnderTest;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public Activity getActivityUnderTest() {
		return activityUnderTest;
	}

	public void addActivityInputValue(ActivityInput activityInput) {
		activityInputValues.add(activityInput);
	}

	public ArrayList<ActivityInput> getActivityInputValues() {
		return activityInputValues;
	}

	public void setActivityContextObject(Object activityContextObject) {
		this.activityContextObject = activityContextObject;
	}

	public Object getActivityContextObject() {
		return activityContextObject;
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