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
public class TestSuiteResult {
	private ArrayList<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();

	public void addTestCaseResult(TestCaseResult result) {
		testCaseResults.add(result);
	}

	public ArrayList<TestCaseResult> getTestCaseResults() {
		return testCaseResults;
	}
}