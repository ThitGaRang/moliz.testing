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

			boolean validationResult = compare(orderUtil.getTopNodes(main, path), nodeOrder);

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
					boolean validationResult = compare(orderUtil.getTopNodes(parent, path), nodeSpecification.getSubOrder().getAllNodes());
					pathCheckResult.setResult(validationResult);
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
			if (orderUtil.isUnderscore(theNode)) {
				return executedNodes.size() == 1;
			}
			if (orderUtil.isStar(theNode)) {
				return executedNodes.size() >= 0;
			}
			if (orderUtil.isNode(theNode)) {
				return nodeOrder.get(0).getNode() == executedNodes.get(0) && executedNodes.size() == 1;
			}
		} else if (nodeOrder.size() == 2) {
			NodeSpecification firstNode = nodeOrder.get(0);
			NodeSpecification secondNode = nodeOrder.get(1);
			// case: _, node
			if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode)) {
				return executedNodes.get(1).getNode() == secondNode.getNode() && executedNodes.size() == 2;
			}
			// case: *, node
			if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode)) {
				int nodeIndex = -1;
				for (ActivityNodeExecution nodeExecution : executedNodes) {
					if (nodeExecution.getNode() == secondNode.getNode())
						nodeIndex = executedNodes.indexOf(nodeExecution);
				}
				return nodeIndex >= 0 && nodeIndex == executedNodes.size() - 1;
			}
			// case: node, node
			if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode)) {
				return executedNodes.get(0).getNode() == firstNode.getNode() && executedNodes.get(1).getNode() == secondNode.getNode()
						&& executedNodes.size() == 2;
			}
			// case: node, _
			if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode)) {
				return firstNode.getNode() == executedNodes.get(0).getNode() && executedNodes.size() == 2;
			}
			// case: node,*
			if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode)) {
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

				boolean firstIsStartNode = orderUtil.indexOf(firstNode.getNode(), executedNodes) == 0;

				boolean secondIsStartNode = orderUtil.indexOf(secondNode.getNode(), executedNodes) == 0;
				boolean secondIsEndNode = orderUtil.indexOf(secondNode.getNode(), executedNodes) + 1 == executedNodes.size();

				boolean secondNodeIsNotNextToFirst = orderUtil.indexOf(secondNode.getNode(), executedNodes) != 1;
				boolean secondNodeIsNotNextToLast = orderUtil.indexOf(secondNode.getNode(), executedNodes) + 2 != executedNodes.size();

				boolean thirdIsEndNode = orderUtil.indexOf(thirdNode.getNode(), executedNodes) + 1 == executedNodes.size();

				boolean oneNodeIsInBetween = orderUtil.indexOf(firstNode.getNode(), executedNodes) + 2 == orderUtil.indexOf(thirdNode.getNode(), executedNodes);
				boolean zeroOrMoreNodesIsInBetween = orderUtil.indexOf(firstNode.getNode(), executedNodes) + 1 <= orderUtil.indexOf(thirdNode.getNode(),
						executedNodes);

				boolean firstIsNotNextToSecond = orderUtil.indexOf(firstNode.getNode(), executedNodes) + 1 != orderUtil.indexOf(secondNode.getNode(),
						executedNodes);
				boolean secondIsNotNextToThird = orderUtil.indexOf(secondNode.getNode(), executedNodes) + 1 != orderUtil.indexOf(thirdNode.getNode(),
						executedNodes);

				boolean firstWasExecuted = wasExecuted(firstNode.getNode(), executedNodes);
				boolean secondWasExecuted = wasExecuted(secondNode.getNode(), executedNodes);
				boolean thirdWasExecuted = wasExecuted(thirdNode.getNode(), executedNodes);

				if (orderUtil.isNode(firstNode) && !firstWasExecuted) {
					return false;
				}
				if (orderUtil.isNode(secondNode) && !secondWasExecuted) {
					return false;
				}
				if (orderUtil.isNode(thirdNode) && !thirdWasExecuted) {
					return false;
				}

				// case: *, node, *
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (executedNodes.size() < 1)
						return false;
				}
				// case: *, node, _
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeAfterWindowExists) {
						if (executedNodes.size() < 1)
							return false;
					} else {
						if (executedNodes.size() < 2 || secondNodeIsNotNextToLast)
							return false;
					}
				}
				// case: _, node, *
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (secondIsStartNode)
							return false;
					} else {
						if (secondNodeIsNotNextToFirst)
							return false;
					}
				}
				// case: _, node, _
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsStartNode || secondIsEndNode)
								return false;
						} else {
							if (secondIsStartNode || secondNodeIsNotNextToLast)
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
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
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
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
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
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsStartNode || secondIsNotNextToThird)
								return false;
						} else {
							if (secondIsStartNode || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (secondNodeIsNotNextToFirst || secondIsNotNextToThird)
								return false;
						} else {
							if (secondNodeIsNotNextToFirst || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: *, node, node
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (secondIsNotNextToThird)
								return false;
						} else {
							if (secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (secondIsNotNextToThird)
								return false;
						} else {
							if (secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, _, node
				if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || !oneNodeIsInBetween)
								return false;
						} else {
							if (firstIsStartNode || !oneNodeIsInBetween || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || !oneNodeIsInBetween)
								return false;
						} else {
							if (!firstIsStartNode || !oneNodeIsInBetween || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, *, node
				if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || !zeroOrMoreNodesIsInBetween)
								return false;
						} else {
							if (firstIsStartNode || !zeroOrMoreNodesIsInBetween || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || !zeroOrMoreNodesIsInBetween)
								return false;
						} else {
							if (!firstIsStartNode || !zeroOrMoreNodesIsInBetween || !thirdIsEndNode)
								return false;
						}
					}
				}
				// case: node, node, node
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							if (firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird)
								return false;
						} else {
							if (firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird || !thirdIsEndNode)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							if (!firstIsStartNode || firstIsNotNextToSecond || secondIsNotNextToThird)
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

	private boolean wasExecuted(ActivityNode node, List<ActivityNodeExecution> executedNodes) {
		if (node == null)
			return false;
		for (ActivityNodeExecution nodeExecution : executedNodes) {
			if (nodeExecution.getNode() == node)
				return true;
		}
		return false;
	}
}