/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.results.OrderAssertionResult;
import org.modelexecution.fumltesting.results.PathCheckResult;
import org.modelexecution.fumltesting.testLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.testLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.testLang.UMLTestCase;
import org.modelexecution.fumltesting.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;

/**
 * Utility class for validation of order execution assertion.
 * 
 * @author Stefan Mijatov
 * 
 */
public class OrderAssertionValidator {

	private TraceUtil traceUtil;
	private AssertionPrinter assertionPrinter;

	public OrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		this.assertionPrinter = new AssertionPrinter(traceUtil.getModelConverter());
	}

	public OrderAssertionResult checkOrder(UMLOrderAssertion assertion) {
		OrderAssertionResult result = new OrderAssertionResult(((UMLOrderAssertion) assertion).getOrder());
		result.setAssertion(assertion);

		List<UMLNodeSpecification> nodeOrder = ((UMLOrderAssertion) assertion).getOrder().getNodes();
		Activity main = traceUtil.getModelConverter().convertActivity(((UMLTestCase) assertion.eContainer()).getActivityUnderTest());

		assertionPrinter.printOrderSpecification(nodeOrder);
		System.out.println("Checking order assertion against " + traceUtil.getAllPaths().size() + " generated paths..");

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);

			boolean validationResult = compare(getTopNodes(main, path), nodeOrder);

			pathCheckResult.setValidationResult(validationResult);
			result.addPathCheckResult(pathCheckResult);
		}

		for (UMLNodeSpecification nodeSpecification : nodeOrder) {
			if (nodeSpecification.getSubOrder() != null) {
				Activity parent = null;
				ActivityNode node = traceUtil.getModelConverter().convertActivityNode(nodeSpecification.getNode());

				if (node instanceof CallBehaviorAction) {
					parent = (Activity) ((CallBehaviorAction) node).behavior;
				}
				if (node instanceof CallOperationAction) {
					parent = (Activity) ((CallOperationAction) node).operation.method.get(0);
				}

				int activityExecutionID = traceUtil.getActivityExecutionID(parent.name);
				System.out.println("Checking sub-order: ");
				assertionPrinter.printOrderSpecification(nodeSpecification.getSubOrder().getNodes());

				OrderAssertionResult subOrderResult = new OrderAssertionResult(nodeSpecification.getSubOrder());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID, traceUtil.getModelConverter());
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

	private boolean compare(List<ActivityNodeExecution> executedNodes, List<UMLNodeSpecification> nodeOrder) {
		int executedNodeIndex = 0;
		for (int i = 0; i < nodeOrder.size(); i++) {
			if (executedNodeIndex == -1) {
				return false;
			}
			if (nodeOrder.get(i).getJoker() != null) {
				if (nodeOrder.get(i).getJoker().equals("_")) {
					executedNodeIndex++;
				}
				if (nodeOrder.get(i).getJoker().equals("*")) {
					if (i < nodeOrder.size() - 1) {
						if (nodeOrder.get(i + 1).getNode() == null) {
							System.out.println("Use of subsequent star joker not allowed!");
							System.out.println("Assertion skipped!");
							return false;
						}
						ActivityNode nextNode = traceUtil.getModelConverter().convertActivityNode(nodeOrder.get(i + 1).getNode());
						if (nodeOrder.get(i + 1).getNode() != null)
							executedNodeIndex = getExecutedNodeIndex(nextNode, executedNodes);
					}
				}
			} else {
				if (traceUtil.getModelConverter().convertActivityNode(nodeOrder.get(i).getNode()) != executedNodes.get(executedNodeIndex).getNode())
					return false;
				executedNodeIndex++;
			}
		}
		// in case that the number of specified nodes is smaller than number of
		// executed ones, and that the last specified node is not *, assertion
		// should fail
		if (executedNodeIndex < executedNodes.size() - 1
				&& (nodeOrder.get(nodeOrder.size() - 1).getJoker() == null || !nodeOrder.get(nodeOrder.size() - 1).getJoker().equals("*"))) {
			return false;
		}
		return true;
	}

	private int getExecutedNodeIndex(ActivityNode node, List<ActivityNodeExecution> executedNodes) {
		for (int i = 0; i < executedNodes.size(); i++) {
			if (executedNodes.get(i).getNode() == node)
				return i;
		}
		return -1;
	}

	private List<ActivityNodeExecution> getTopNodes(Activity activity, List<ActivityNodeExecution> executedNodes) {
		List<ActivityNodeExecution> topNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution node : executedNodes) {
			if (node.getNode().owner == activity
					&& (node.getNode() instanceof Action || node.getNode() instanceof InitialNode || node.getNode() instanceof ActivityFinalNode)) {
				topNodes.add(node);
			}
		}
		return topNodes;
	}
}