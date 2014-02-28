/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

import org.modelexecution.fumltesting.testLang.NodeOrder;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class OrderAssertionResult extends AssertionResult {

	private NodeOrder nodeOrderSpecification;
	private ArrayList<PathCheckResult> pathCheckResults;

	public OrderAssertionResult(NodeOrder nodeOrderSpecification) {
		this.nodeOrderSpecification = nodeOrderSpecification;
		pathCheckResults = new ArrayList<PathCheckResult>();
	}

	public NodeOrder getNodeOrderSpecification() {
		return nodeOrderSpecification;
	}

	public void addPathCheckResult(PathCheckResult result) {
		pathCheckResults.add(result);
	}

	public ArrayList<PathCheckResult> getFailedPathCheckResults() {
		ArrayList<PathCheckResult> failedPathCheckResults = new ArrayList<PathCheckResult>();
		for (PathCheckResult result : pathCheckResults) {
			if (result.getValidationResult() == false)
				failedPathCheckResults.add(result);
		}
		return failedPathCheckResults;
	}

	public int numberOfPathsChecked() {
		return pathCheckResults.size();
	}

	@Override
	public boolean getAssertionValidationResult() {
		for (PathCheckResult result : pathCheckResults) {
			if (result.getValidationResult() == false)
				return false;
		}
		return true;
	}
}