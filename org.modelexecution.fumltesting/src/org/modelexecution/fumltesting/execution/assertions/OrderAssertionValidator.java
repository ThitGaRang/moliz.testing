/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.convert.UmlConverter;
import org.modelexecution.fumltesting.results.OrderAssertionResult;
import org.modelexecution.fumltesting.results.PathCheckResult;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;

/**
 * Utility class for validation of order execution assertion.
 * 
 * @author Stefan Mijatov
 * 
 */
public class OrderAssertionValidator {

	/** Check order of nodes up to two levels and generate result. */
	public OrderAssertionResult checkOrder(OrderAssertion assertion, TraceUtil traceUtil) {
		OrderAssertionResult result = new OrderAssertionResult(((OrderAssertion) assertion).getOrder());
		result.setAssertion(assertion);

		org.eclipse.uml2.uml.Activity main = ((TestCase) assertion.eContainer()).getActivityUnderTest();
		List<NodeSpecification> nodeOrder = ((OrderAssertion) assertion).getOrder().getNodes();

		AssertionPrinter.printOrderSpecification(nodeOrder);
		System.out.println("Checking order assertion against " + traceUtil.getAllPaths().size() + " generated paths..");

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);
			boolean validationResult = compare(getTopNodes(main, path), nodeOrder);
			pathCheckResult.setValidationResult(validationResult);
			result.addPathCheckResult(pathCheckResult);
		}

		for (NodeSpecification nodeSpecification : nodeOrder) {
			if (nodeSpecification.getSubOrder() != null) {
				org.eclipse.uml2.uml.Activity parent = null;
				if (nodeSpecification.getNode() instanceof CallBehaviorAction) {
					parent = (org.eclipse.uml2.uml.Activity) ((CallBehaviorAction) nodeSpecification.getNode()).getBehavior();
				}
				if (nodeSpecification.getNode() instanceof CallOperationAction) {
					parent = (org.eclipse.uml2.uml.Activity) ((CallOperationAction) nodeSpecification.getNode()).getOperation().getMethods().get(0);
				}

				int activityExecutionID = traceUtil.getActivityExecutionID(parent.getName());
				System.out.println("Checking sub-order: ");
				AssertionPrinter.printOrderSpecification(nodeSpecification.getSubOrder().getNodes());

				OrderAssertionResult subOrderResult = new OrderAssertionResult(nodeSpecification.getSubOrder());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);
				System.out.println("Checking sub-order assertion against " + subTraceUtil.getAllPaths().size() + " generated paths..");

				for (ArrayList<ActivityNodeExecution> path : subTraceUtil.getAllPaths()) {
					PathCheckResult pathCheckResult = new PathCheckResult(path);
					boolean validationResult = compare(getTopNodes(parent, path), nodeSpecification.getSubOrder().getNodes());
					pathCheckResult.setValidationResult(validationResult);
					subOrderResult.addPathCheckResult(pathCheckResult);
				}
				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	private boolean compare(List<ActivityNodeExecution> executedNodes, List<NodeSpecification> nodeOrderList) {
		int executedNodeIndex = 0;
		for (int i = 0; i < nodeOrderList.size(); i++) {
			if (executedNodeIndex == -1) {
				return false;
			}
			if (nodeOrderList.get(i).getJoker() != null) {
				if (nodeOrderList.get(i).getJoker().equals("_")) {
					executedNodeIndex++;
				}
				if (nodeOrderList.get(i).getJoker().equals("*")) {
					if (i < nodeOrderList.size() - 1) {
						if (nodeOrderList.get(i + 1).getNode() == null) {
							System.out.println("Use of subsequent star joker not allowed!");
							System.out.println("Assertion skipped!");
							return false;
						}
						ActivityNode nextNode = nodeOrderList.get(i + 1).getNode();
						if (nodeOrderList.get(i + 1).getNode() != null)
							executedNodeIndex = getExecutedNodeIndex(nextNode, executedNodes);
					}
				}
			} else {
				if (nodeOrderList.get(i).getNode() != UmlConverter.getInstance().getOriginal(executedNodes.get(executedNodeIndex).getNode()))
					return false;
				executedNodeIndex++;
			}
		}
		// in case that the number of specified nodes is smaller than number of
		// executed ones, and that the last specified node is not *, assertion
		// should fail
		if (executedNodeIndex < executedNodes.size() - 1
				&& (nodeOrderList.get(nodeOrderList.size() - 1).getJoker() == null || !nodeOrderList.get(nodeOrderList.size() - 1).getJoker()
						.equals("*"))) {
			return false;
		}
		return true;
	}

	private int getExecutedNodeIndex(ActivityNode node, List<ActivityNodeExecution> executedNodes) {
		for (int i = 0; i < executedNodes.size(); i++) {
			if (UmlConverter.getInstance().getOriginal(executedNodes.get(i).getNode()) == node)
				return i;
		}
		return -1;
	}

	private List<ActivityNodeExecution> getTopNodes(org.eclipse.uml2.uml.Activity activity, List<ActivityNodeExecution> executedNodes) {
		List<ActivityNodeExecution> topNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution node : executedNodes) {
			if (UmlConverter.getInstance().getOriginal(node.getNode().owner) == activity
					&& (node.getNode() instanceof Action || node.getNode() instanceof InitialNode || node.getNode() instanceof ActivityFinalNode)) {
				topNodes.add(node);
			}
		}
		return topNodes;
	}
}