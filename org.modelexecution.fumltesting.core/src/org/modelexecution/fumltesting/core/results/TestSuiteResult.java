/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestSuiteResult {
	private long setupTime;
	private SimpleDateFormat executedOn = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private ArrayList<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();

	public void setSetupTime(long setupTime) {
		this.setupTime = setupTime;
	}

	public long getSetupTime() {
		return setupTime;
	}

	public void addTestCaseResult(TestCaseResult result) {
		testCaseResults.add(result);
	}

	public ArrayList<TestCaseResult> getTestCaseResults() {
		return testCaseResults;
	}

	public String executedOn() {
		return executedOn.format(new Date());
	}
}