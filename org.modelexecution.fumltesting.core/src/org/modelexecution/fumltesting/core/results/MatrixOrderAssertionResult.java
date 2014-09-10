package org.modelexecution.fumltesting.core.results;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumltesting.core.testlang.NodeSpecification;

public class MatrixOrderAssertionResult extends AssertionResult {
	private boolean result;
	private List<NodeSpecification> orderSpecification;
	private ArrayList<MatrixOrderAssertionResult> subOrderAssertionResults;

	public MatrixOrderAssertionResult(List<NodeSpecification> orderSpecification) {
		this.orderSpecification = orderSpecification;
		subOrderAssertionResults = new ArrayList<MatrixOrderAssertionResult>();
	}

	public List<NodeSpecification> getOrderSpecification() {
		return orderSpecification;
	}

	public void addSubOrderAssertionResult(MatrixOrderAssertionResult result) {
		subOrderAssertionResults.add(result);
	}

	public ArrayList<MatrixOrderAssertionResult> getSubOrderAssertionResults() {
		return subOrderAssertionResults;
	}

	public ArrayList<MatrixOrderAssertionResult> getFailedSubOrderResults() {
		ArrayList<MatrixOrderAssertionResult> failedSubOrderResults = new ArrayList<MatrixOrderAssertionResult>();
		for (MatrixOrderAssertionResult result : subOrderAssertionResults) {
			if (!result.result)
				failedSubOrderResults.add(result);
		}
		return failedSubOrderResults;
	}

	public void setAssertionValidationResult(boolean result) {
		this.result = result;
	}

	@Override
	public boolean getAssertionValidationResult() {
		return result;
	}
}