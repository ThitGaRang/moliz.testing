/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import java.util.ArrayList;
import java.util.HashMap;

import org.modelexecution.fumltesting.core.sequence.State;

/**
 * @author Stefan Mijatov
 * 
 */
public class ConstraintResult {
	private String constraintName;
	private HashMap<State, Boolean> stateResults;
	private boolean result;

	public ConstraintResult(String constraintName) {
		this.constraintName = constraintName;
		this.stateResults = new HashMap<State, Boolean>();
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean getResult() {
		return result;
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