package org.modelexecution.fumltesting.results;

import java.util.ArrayList;

import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.OrderAssertion;

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

	public void setOrderAssertion(OrderAssertion assertion){
		super.setAssertion(assertion);
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