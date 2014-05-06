/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.core.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;

/**
 * @author Stefan Mijatov
 * 
 */
public abstract class OrderAssertionValidator {

	protected TraceUtil traceUtil;

	public OrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
	}

	public abstract OrderAssertionResult checkOrder(Object orderAssertion);

	public abstract List<ConvertedNodeSpecification> convertNodeOrder(List<? extends Object> nodeOrder);

	protected boolean compare(List<ActivityNodeExecution> executedNodes, List<ConvertedNodeSpecification> nodeOrder) {
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
						ActivityNode nextNode = nodeOrder.get(i + 1).getNode();
						if (nodeOrder.get(i + 1).getNode() != null)
							executedNodeIndex = getExecutedNodeIndex(nextNode, executedNodes);
					}
				}
			} else {
				if (nodeOrder.get(i).getNode() != executedNodes.get(executedNodeIndex).getNode())
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

	protected int getExecutedNodeIndex(ActivityNode node, List<ActivityNodeExecution> executedNodes) {
		for (int i = 0; i < executedNodes.size(); i++) {
			if (executedNodes.get(i).getNode() == node)
				return i;
		}
		return -1;
	}

	protected List<ActivityNodeExecution> getTopNodes(Activity activity, List<ActivityNodeExecution> executedNodes) {
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