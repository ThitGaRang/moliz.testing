/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.results;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class PathCheckResult {
	private ArrayList<ActivityNodeExecution> path;
	private boolean validationResult;

	public PathCheckResult(ArrayList<ActivityNodeExecution> path) {
		this.path = path;
	}

	public ArrayList<ActivityNodeExecution> getPath() {
		return path;
	}

	public void setValidationResult(boolean validationResult) {
		this.validationResult = validationResult;
	}

	public boolean getValidationResult() {
		return validationResult;
	}
}