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
public class OrderAssertionValidator {

	private TraceUtil traceUtil;
	private OrderUtil orderAssertionUtil;

	public OrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		this.orderAssertionUtil = new OrderUtil();
	}

	public OrderAssertionResult checkOrder(OrderAssertion assertion) {
		OrderAssertionResult result = new OrderAssertionResult(((OrderAssertion) assertion).getOrder().getAllNodes());

		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = assertion.getOrder().getAllNodes();
		Activity main = assertion.getContainer().getActivityUnderTest();

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);

			boolean validationResult = compare(orderAssertionUtil.getTopNodes(main, path), nodeOrder);

			pathCheckResult.setValidationResult(validationResult);
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

				OrderAssertionResult subOrderResult = new OrderAssertionResult(nodeSpecification.getSubOrder().getAllNodes());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);

				for (ArrayList<ActivityNodeExecution> path : subTraceUtil.getAllPaths()) {
					PathCheckResult pathCheckResult = new PathCheckResult(path);
					boolean validationResult = compare(orderAssertionUtil.getTopNodes(parent, path), nodeSpecification.getSubOrder().getAllNodes());
					pathCheckResult.setValidationResult(validationResult);
					subOrderResult.addPathCheckResult(pathCheckResult);
				}
				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	private boolean compare(List<ActivityNodeExecution> executedNodes, List<NodeSpecification> nodeOrder) {
		if (nodeOrder.size() == 1) {
			NodeSpecification theNode = nodeOrder.get(0);
			if (orderAssertionUtil.isUnderscore(theNode)) {
				return executedNodes.size() == 1;
			}
			if (orderAssertionUtil.isStar(theNode)) {
				return executedNodes.size() >= 0;
			}
			if (orderAssertionUtil.isNode(theNode)) {
				return nodeOrder.get(0).getNode() == executedNodes.get(0) && executedNodes.size() == 1;
			}
		} else if (nodeOrder.size() == 2) {
			NodeSpecification firstNode = nodeOrder.get(0);
			NodeSpecification secondNode = nodeOrder.get(1);
			// case: _, node
			if (orderAssertionUtil.isUnderscore(firstNode) && orderAssertionUtil.isNode(secondNode)) {
				return executedNodes.get(1).getNode() == secondNode.getNode() && executedNodes.size() == 2;
			}
			// case: *, node
			if (orderAssertionUtil.isStar(firstNode) && orderAssertionUtil.isNode(secondNode)) {
				int nodeIndex = executedNodes.indexOf(secondNode.getNode());
				return nodeIndex >= 0 && nodeIndex == executedNodes.size() - 1;
			}
			// case: node, node
			if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isNode(secondNode)) {
				return executedNodes.get(0).getNode() == firstNode.getNode() && executedNodes.get(1).getNode() == secondNode.getNode()
						&& executedNodes.size() == 2;
			}
			// case: node, _
			if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isUnderscore(secondNode)) {
				return firstNode.getNode() == executedNodes.get(0).getNode() && executedNodes.size() == 2;
			}
			// case: node,*
			if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isStar(secondNode)) {
				return firstNode.getNode() == executedNodes.get(0).getNode() && executedNodes.size() >= 1;
			}
		} else if (nodeOrder.size() > 2) {
			for (int step = 0; step < nodeOrder.size(); step++) {
				// checking window of three subsequent node specifications
				NodeSpecification firstNode = nodeOrder.get(step);
				NodeSpecification secondNode = nodeOrder.get(step + 1);
				NodeSpecification thirdNode = nodeOrder.get(step + 2);

				boolean nodeBeforeWindowExists = step > 0;
				boolean nodeAfterWindowExists = nodeOrder.size() - 1 > step + 2;

				boolean firstIsStartNode = orderAssertionUtil.indexOf(firstNode.getNode(), executedNodes) == 0;

				boolean secondIsStartNode = orderAssertionUtil.indexOf(secondNode.getNode(), executedNodes) == 0;
				boolean secondIsEndNode = orderAssertionUtil.indexOf(secondNode.getNode(), executedNodes) + 1 == executedNodes.size();

				boolean secondNodeIsNotNextToFirst = orderAssertionUtil.indexOf(secondNode.getNode(), executedNodes) != 1;
				boolean secondNodeIsNotNextToLast = orderAssertionUtil.indexOf(secondNode.getNode(), executedNodes) + 2 != executedNodes.size();

				boolean thirdIsEndNode = orderAssertionUtil.indexOf(thirdNode.getNode(), executedNodes) + 1 == executedNodes.size();

				boolean oneNodeIsInBetween = orderAssertionUtil.indexOf(firstNode.getNode(), executedNodes) + 2 == orderAssertionUtil.indexOf(
						thirdNode.getNode(), executedNodes);
				boolean zeroOrMoreNodesIsInBetween = orderAssertionUtil.indexOf(firstNode.getNode(), executedNodes) + 1 <= orderAssertionUtil.indexOf(
						thirdNode.getNode(), executedNodes);

				boolean firstIsNotNextToSecond = orderAssertionUtil.indexOf(firstNode.getNode(), executedNodes) + 1 != orderAssertionUtil.indexOf(
						secondNode.getNode(), executedNodes);
				boolean secondIsNotNextToThird = orderAssertionUtil.indexOf(secondNode.getNode(), executedNodes) + 1 != orderAssertionUtil.indexOf(
						thirdNode.getNode(), executedNodes);

				// case: *, node, *
				if (orderAssertionUtil.isStar(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isStar(thirdNode)) {
					if (executedNodes.size() < 1)
						return false;
				}
				// case: *, node, _
				if (orderAssertionUtil.isStar(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isUnderscore(thirdNode)) {
					if (nodeAfterWindowExists) {
						if (executedNodes.size() < 1)
							return false;
					} else {
						if (executedNodes.size() < 2 || secondNodeIsNotNextToLast)
							return false;
					}
				}
				// case: _, node, *
				if (orderAssertionUtil.isUnderscore(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (secondIsStartNode)
							return false;
					} else {
						if (secondNodeIsNotNextToFirst)
							return false;
					}
				}
				// case: _, node, _
				if (orderAssertionUtil.isUnderscore(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsStartNode || secondIsEndNode)
								return false;
						} else {
							if (secondIsStartNode && secondNodeIsNotNextToLast)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (secondNodeIsNotNextToFirst || secondIsEndNode)
								return false;
						} else {
							if (secondNodeIsNotNextToFirst || secondNodeIsNotNextToLast)
								return false;
						}
					}
				}
				// case: node, node, _
				if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || firstIsNotNextToSecond || secondIsEndNode)
								return false;
						} else {
							if (firstIsStartNode || firstIsNotNextToSecond || secondNodeIsNotNextToLast)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || firstIsNotNextToSecond)
								return false;
						} else {
							if (!firstIsStartNode || firstIsNotNextToSecond || secondNodeIsNotNextToLast)
								return false;
						}
					}
				}
				// case: node, node, *
				if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || firstIsNotNextToSecond)
								return false;
						} else {
							if (firstIsStartNode || firstIsNotNextToSecond)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || firstIsNotNextToSecond)
								return false;
						} else {
							if (!firstIsStartNode || firstIsNotNextToSecond)
								return false;
						}
					}
				}
				// case: _, node, node
				if (orderAssertionUtil.isUnderscore(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsStartNode || secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (secondIsStartNode || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (secondNodeIsNotNextToFirst || secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (secondNodeIsNotNextToFirst || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: *, node, node
				if (orderAssertionUtil.isStar(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, _, node
				if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isUnderscore(secondNode) && orderAssertionUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || !oneNodeIsInBetween || thirdIsEndNode)
								return false;
						} else {
							if (firstIsStartNode || !oneNodeIsInBetween || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || !oneNodeIsInBetween || thirdIsEndNode)
								return false;
						} else {
							if (!firstIsStartNode || !oneNodeIsInBetween || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, *, node
				if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isStar(secondNode) && orderAssertionUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || !zeroOrMoreNodesIsInBetween || thirdIsEndNode)
								return false;
						} else {
							if (firstIsStartNode || !zeroOrMoreNodesIsInBetween || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || !zeroOrMoreNodesIsInBetween || thirdIsEndNode)
								return false;
						} else {
							if (!firstIsStartNode || !zeroOrMoreNodesIsInBetween || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, node, node
				if (orderAssertionUtil.isNode(firstNode) && orderAssertionUtil.isNode(secondNode) && orderAssertionUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird || thirdIsEndNode)
								return false;
						} else {
							if (!firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					}
				}
				// if it is the last window exit the for loop
				if (nodeOrder.size() == step + 3)
					break;
			}
		}
		return true;
	}
}