package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

public class TestSuiteResult {
	private ArrayList<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();
	
	public void addTestCaseResult(TestCaseResult result){
		testCaseResults.add(result);
	}
	
	public ArrayList<TestCaseResult> getTestCaseResults(){
		return testCaseResults;
	}
}