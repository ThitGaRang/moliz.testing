/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stefan Mijatov
 * 
 */
public class TestSuite {
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
	private ArrayList<TestCase> testCases = new ArrayList<TestCase>();

	public void addScenario(Scenario scenario) {
		scenario.setContainer(this);
		scenarios.add(scenario);
	}

	public List<Scenario> getAllScenarios() {
		return Collections.unmodifiableList(this.scenarios);
	}

	public void addTestCase(TestCase testCase) {
		testCase.setContainer(this);
		testCases.add(testCase);
	}

	public List<TestCase> getAllTestCases() {
		return Collections.unmodifiableList(this.testCases);
	}
}