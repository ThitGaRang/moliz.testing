/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import java.util.ArrayList;
import java.util.HashMap;

import org.modelexecution.fumltesting.sequence.State;

/**
 * @author Stefan Mijatov
 * 
 */
public class ConstraintResult {
	private String constraint;
	private Object assertion;
	private HashMap<State, Boolean> stateResults;
	private boolean validationResult;

	public ConstraintResult(String constraint, Object assertion) {
		this.constraint = constraint;
		this.assertion = assertion;
		this.stateResults = new HashMap<State, Boolean>();
	}

	public String getConstraint() {
		return constraint;
	}

	public Object getAssertion() {
		return assertion;
	}

	public void setValidationResult(boolean validationResult) {
		this.validationResult = validationResult;
	}

	public boolean getValidationResult() {
		return validationResult;
	}

	public void putStateResult(State state, Boolean result) {
		stateResults.put(state, result);
	}

	public ArrayList<State> getFailedStates() {
		ArrayList<State> states = new ArrayList<State>();
		for (State state : stateResults.keySet()) {
			if (stateResults.get(state) == false)
				states.add(state);
		}
		return states;
	}
}