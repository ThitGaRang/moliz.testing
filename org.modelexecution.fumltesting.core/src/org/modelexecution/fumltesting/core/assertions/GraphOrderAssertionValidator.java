/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.results.PathCheckResult;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

/**
 * Utility class for validation of order execution assertion.
 * 
 * @author Stefan Mijatov
 * 
 */
public class GraphOrderAssertionValidator extends OrderAssertionValidator {

	private List<ActivityNodeExecution> currentPathUnderEvaluation;

	public GraphOrderAssertionValidator(TraceUtil traceUtil) {
		super(traceUtil);
	}

	public OrderAssertionResult checkOrder(OrderAssertion assertion) {
		OrderAssertionResult result = prepareResult(assertion.getOrder().getAllNodes(), OrderAssertionValidationType.GRAPH);
		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = assertion.getOrder().getAllNodes();
		Activity main = assertion.getContainer().getActivityUnderTest();

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);

			currentPathUnderEvaluation = orderUtil.getTopNodes(main, path);
			boolean validationResult = validate(nodeOrder);

			pathCheckResult.setResult(validationResult);
			result.addPathCheckResult(pathCheckResult);
		}

		for (NodeSpecification nodeSpecification : nodeOrder) {
			if (nodeSpecification.getSubOrder() != null) {
				Activity parent = null;
				ActivityNode node = nodeSpecification.getNode();

				if (node instanceof CallBehaviorAction) {
					parent = (Activity) ((CallBehaviorAction) node).behavior;
				}
				if (node instanceof CallOperationAction) {
					parent = (Activity) ((CallOperationAction) node).operation.method.get(0);
				}

				int activityExecutionID = traceUtil.getActivityExecutionID(parent.name);

				OrderAssertionResult subOrderResult = prepareResult(nodeSpecification.getSubOrder().getAllNodes(), OrderAssertionValidationType.GRAPH);
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);

				for (ArrayList<ActivityNodeExecution> path : subTraceUtil.getAllPaths()) {
					PathCheckResult pathCheckResult = new PathCheckResult(path);
					currentPathUnderEvaluation = orderUtil.getTopNodes(parent, path);
					boolean validationResult = validate(nodeSpecification.getSubOrder().getAllNodes());
					pathCheckResult.setResult(validationResult);
					subOrderResult.addPathCheckResult(pathCheckResult);
				}
				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	@Override
	protected int getNumberOfExecutedNodes() {
		return currentPathUnderEvaluation.size();
	}

	@Override
	protected boolean wasExecuted(ActivityNode activityNode) {
		if (activityNode == null)
			return false;
		for (ActivityNodeExecution nodeExecution : currentPathUnderEvaluation) {
			if (nodeExecution.getNode() == activityNode)
				return true;
		}
		return false;
	}

	@Override
	protected boolean isStartNode(ActivityNode activityNode) {
		return currentPathUnderEvaluation.size() > 0 && currentPathUnderEvaluation.get(0).getNode() == activityNode;
	}

	@Override
	protected boolean isEndNode(ActivityNode activityNode) {
		return currentPathUnderEvaluation.size() > 0 && currentPathUnderEvaluation.get(currentPathUnderEvaluation.size() - 1).getNode() == activityNode;
	}

	@Override
	protected boolean hasIndependentNodes(ActivityNode activityNode) {
		// as the validated path is FIXED, we can pretend that activity
		// node has no nodes that can be interchanged with it
		return false;
	}

	@Override
	protected boolean alwaysInOrder(ActivityNode firstActivityNode, ActivityNode secondActivityNode) {
		int indexOfFirst = getIndexOf(firstActivityNode), indexOfSecond = getIndexOf(secondActivityNode);
		return indexOfFirst < indexOfSecond;
	}

	@Override
	protected List<ActivityNode> getAncestors(ActivityNode activityNode) {
		List<ActivityNode> ancestors = new ArrayList<ActivityNode>();
		int indexOfNode = getIndexOf(activityNode), numberOfNodes = currentPathUnderEvaluation.size();

		if (indexOfNode > 0 && numberOfNodes > 1) {
			for (int i = 0; i < indexOfNode; i++) {
				ancestors.add(currentPathUnderEvaluation.get(i).getNode());
			}
		}

		return ancestors;
	}

	@Override
	protected List<ActivityNode> getDescendants(ActivityNode activityNode) {
		List<ActivityNode> descendants = new ArrayList<ActivityNode>();
		int indexOfNode = getIndexOf(activityNode), numberOfNodes = currentPathUnderEvaluation.size();

		if (indexOfNode > -1 && numberOfNodes > 1) {
			for (int i = indexOfNode + 1; i < numberOfNodes; i++) {
				descendants.add(currentPathUnderEvaluation.get(i).getNode());
			}
		}

		return descendants;
	}

	@Override
	protected List<ActivityNode> getSuccessors(ActivityNode activityNode) {
		List<ActivityNode> successors = new ArrayList<ActivityNode>();
		int indexOfNode = getIndexOf(activityNode), numberOfNodes = currentPathUnderEvaluation.size();

		if (indexOfNode > -1 && numberOfNodes > 1) {
			successors.add(currentPathUnderEvaluation.get(indexOfNode + 1).getNode());
		}

		return successors;
	}

	@Override
	protected List<ActivityNode> getPredecessors(ActivityNode activityNode) {
		List<ActivityNode> predecessors = new ArrayList<ActivityNode>();
		int indexOfNode = getIndexOf(activityNode), numberOfNodes = currentPathUnderEvaluation.size();

		if (indexOfNode > 0 && numberOfNodes > 1) {
			predecessors.add(currentPathUnderEvaluation.get(indexOfNode - 1).getNode());
		}

		return predecessors;
	}

	private int getIndexOf(ActivityNode activityNode) {
		for (ActivityNodeExecution nodeExecution : currentPathUnderEvaluation) {
			if (nodeExecution.getNode() == activityNode)
				return currentPathUnderEvaluation.indexOf(nodeExecution);
		}
		return -1;
	}
}