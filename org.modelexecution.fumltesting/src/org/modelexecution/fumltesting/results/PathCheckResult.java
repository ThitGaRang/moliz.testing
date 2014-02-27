package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

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