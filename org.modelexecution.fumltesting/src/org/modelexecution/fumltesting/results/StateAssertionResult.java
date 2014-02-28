/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

import org.modelexecution.fumltesting.testLang.StateAssertion;

/**
 * @author Stefan Mijatov
 * 
 */
public class StateAssertionResult extends AssertionResult {
	private ArrayList<StateExpressionResult> expressionResults = new ArrayList<StateExpressionResult>();
	private ArrayList<ConstraintResult> constraintResults = new ArrayList<ConstraintResult>();

	public StateAssertionResult(StateAssertion assertion) {
		setAssertion(assertion);
	}

	public void addExpressionResult(StateExpressionResult result) {
		expressionResults.add(result);
	}

	public void addConstraintResult(ConstraintResult result) {
		constraintResults.add(result);
	}

	public ArrayList<StateExpressionResult> getFailedStateExpressions() {
		ArrayList<StateExpressionResult> failedStateExpressionResults = new ArrayList<StateExpressionResult>();
		for (StateExpressionResult result : expressionResults) {
			if (result.getValidationResult() == false)
				failedStateExpressionResults.add(result);
		}
		return failedStateExpressionResults;
	}

	public int numberOfConstraintsChecked(){
		return constraintResults.size();
	}
	
	public ArrayList<ConstraintResult> getFailedConstraints() {
		ArrayList<ConstraintResult> failedConstraintResults = new ArrayList<ConstraintResult>();
		for (ConstraintResult result : constraintResults) {
			if (result.getValidationResult() == false)
				failedConstraintResults.add(result);
		}
		return failedConstraintResults;
	}

	@Override
	public boolean getAssertionValidationResult() {
		for (StateExpressionResult result : expressionResults) {
			if (result.getValidationResult() == false)
				return false;
		}
		for(ConstraintResult result: constraintResults){
			if(result.getValidationResult() == false){
				return false;
			}
		}
		return true;
	}
}