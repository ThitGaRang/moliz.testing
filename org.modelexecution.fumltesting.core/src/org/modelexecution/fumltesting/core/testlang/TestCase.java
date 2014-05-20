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

import fUML.Syntax.Activities.IntermediateActivities.Activity;

/**
 * @author Stefan Mijatov
 * 
 */
public class TestCase {
	private String name;
	private TestSuite container;
	private Activity activityUnderTest;
	private ObjectSpecification contextObject;

	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

	private ArrayList<ActivityInput> inputs = new ArrayList<ActivityInput>();
	private ArrayList<Assertion> assertions = new ArrayList<Assertion>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestSuite getContainer() {
		return this.container;
	}

	public void setContainer(TestSuite container) {
		this.container = container;
	}

	public Activity getActivityUnderTest() {
		return this.activityUnderTest;
	}

	public void setActivityUnderTest(Activity activityUnderTest) {
		this.activityUnderTest = activityUnderTest;
	}

	public ObjectSpecification getContextObject() {
		return contextObject;
	}

	public void setContextObject(ObjectSpecification contextObject) {
		this.contextObject = contextObject;
	}

	public ArrayList<Scenario> getScenarios() {
		return this.scenarios;
	}

	public void addInput(ActivityInput activityInput) {
		this.inputs.add(activityInput);
	}

	public List<ActivityInput> getAllInputs() {
		return Collections.unmodifiableList(this.inputs);
	}

	public void addAssertion(Assertion assertion) {
		assertion.setContainer(this);
		this.assertions.add(assertion);
	}

	public void removeAssertion(Assertion assertion) {
		this.assertions.remove(assertion);
	}

	public List<Assertion> getAllAssertions() {
		return Collections.unmodifiableList(this.assertions);
	}
}