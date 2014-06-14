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
		this.assertionPrinter = new AssertionPrinter();
	}

	public OrderAssertionResult checkOrder(OrderAssertion assertion) {
		OrderAssertionResult result = new OrderAssertionResult(((OrderAssertion) assertion).getOrder());
		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = assertion.getOrder().getAllNodes();
		Activity main = assertion.getContainer().getActivityUnderTest();

		assertionPrinter.printOrderSpecification(nodeOrder);
		System.out.println("Checking order assertion against " + traceUtil.getAllPaths().size() + " generated paths..");

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);

			boolean validationResult = compare(getTopNodes(main, path), nodeOrder);

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
				System.out.println("Checking sub-order: ");
				assertionPrinter.printOrderSpecification(nodeSpecification.getSubOrder().getAllNodes());

				OrderAssertionResult subOrderResult = new OrderAssertionResult(nodeSpecification.getSubOrder());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);
				System.out.println("Checking sub-order assertion against " + subTraceUtil.getAllPaths().size() + " generated paths..");

				for (ArrayList<ActivityNodeExecution> path : subTraceUtil.getAllPaths()) {
					PathCheckResult pathCheckResult = new PathCheckResult(path);
					boolean validationResult = compare(getTopNodes(parent, path), nodeSpecification.getSubOrder().getAllNodes());
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
			if (isUnderscore(theNode)) {
				if (executedNodes.size() == 1)
					return true;
				else
					return true;
			}
			if (isStar(theNode)) {
				return true;
			}
			if (isNode(theNode)) {
				if (nodeOrder.get(0).getNode() == executedNodes.get(0) && executedNodes.size() == 1)
					return true;
				else
					return false;
			}
		} else if (nodeOrder.size() == 2) {
			NodeSpecification firstNode = nodeOrder.get(0);
			NodeSpecification secondNode = nodeOrder.get(1);
			// case: _, node
			if (isUnderscore(firstNode) && isNode(secondNode)) {
				if (executedNodes.get(1).getNode() == secondNode.getNode() && executedNodes.size() == 2)
					return true;
				else
					return false;
			}
			// case: *, node
			if (isStar(firstNode) && isNode(secondNode)) {
				int nodeIndex = getExecutedNodeIndex(secondNode.getNode(), executedNodes);
				if (nodeIndex > 0)
					return true;
				else
					return false;
			}
			// case: node, node
			if (isNode(firstNode) && isNode(secondNode)) {
				if (executedNodes.get(0).getNode() == firstNode.getNode() && executedNodes.get(1).getNode() == secondNode.getNode()
						&& executedNodes.size() == 2) {
					return true;
				} else
					return false;
			}
			// case: node, _
			if (isNode(firstNode) && isUnderscore(secondNode)) {
				if (firstNode.getNode() == executedNodes.get(0).getNode() && executedNodes.size() == 2)
					return true;
				else
					return false;
			}
			// case: node,*
			if (isNode(firstNode) && isStar(secondNode)) {
				if (firstNode.getNode() == executedNodes.get(0).getNode() && executedNodes.size() >= 2)
					return true;
				else
					return false;
			}
		} else if (nodeOrder.size() > 2) {
			if (executedNodes.size() < nodeOrder.size()) {
				return false;
			}
			for (int step = 0; step < nodeOrder.size(); step++) {
				// checking window of three subsequent node specifications
				NodeSpecification firstNode = nodeOrder.get(step);
				NodeSpecification secondNode = nodeOrder.get(step + 1);
				NodeSpecification thirdNode = nodeOrder.get(step + 2);

				boolean nodeBeforeWindowExists = step > 0;
				boolean nodeAfterWindowExists = nodeOrder.size() - 1 > step + 2;

				int nodeIndexFirst = getExecutedNodeIndex(firstNode.getNode(), executedNodes);
				int nodeIndexSecond = getExecutedNodeIndex(secondNode.getNode(), executedNodes);
				int nodeIndexThird = getExecutedNodeIndex(thirdNode.getNode(), executedNodes);

				// case: *, node, *
				if (isStar(firstNode) && isNode(secondNode) && isStar(thirdNode)) {
					if (nodeIndexSecond == 0 || nodeIndexSecond == executedNodes.size() - 1)
						return false;
				}
				// case: *, node, _
				if (isStar(firstNode) && isNode(secondNode) && isUnderscore(thirdNode)) {
					if (nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || executedNodes.size() <= nodeIndexSecond + 1)
							return false;
					} else {
						if (nodeIndexSecond == 0 || executedNodes.size() != nodeIndexSecond + 1)
							return false;
					}
				}
				// case: _, node, *
				if (isUnderscore(firstNode) && isNode(secondNode) && isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeIndexSecond == 0 || executedNodes.size() <= nodeIndexSecond + 1)
							return false;
					} else {
						if (nodeIndexSecond != 1 || executedNodes.size() <= nodeIndexSecond + 1)
							return false;
					}
				}
				// case: _, node, _
				if (isUnderscore(firstNode) && isNode(secondNode) && isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond != 0 || nodeIndexSecond != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond != 0 || nodeIndexSecond < executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 && nodeIndexSecond == executedNodes.size() - 1)
							return false;
					}
				}
				// case: node, node, _
				if (isNode(firstNode) && isNode(secondNode) && isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond != executedNodes.size() - 2)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexSecond != 1 || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond != executedNodes.size() - 2)
							return false;
					}
				}
				// case: node, node, *
				if (isNode(firstNode) && isNode(secondNode) && isStar(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexSecond != 1 || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond != executedNodes.size() - 1)
							return false;
					}
				}
				// case: _, node, node
				if (isUnderscore(firstNode) && isNode(secondNode) && isNode(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond != 1 || nodeIndexThird != 2 || nodeIndexThird != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond != 1 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					}
				}
				// case: *, node, node
				if (isStar(firstNode) && isNode(secondNode) && isNode(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexSecond == 0 || nodeIndexSecond + 1 != nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					}
				}
				// case: node, _, node
				if (isNode(firstNode) && isUnderscore(secondNode) && isNode(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 2 != nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexThird != 2 || nodeIndexThird != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexThird != 2 || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 2 != nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					}
				}
				// case: node, *, node
				if (isNode(firstNode) && isStar(secondNode) && isNode(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst >= nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexFirst >= nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexFirst >= nodeIndexThird || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst >= nodeIndexThird || nodeIndexThird != executedNodes.size() - 1)
							return false;
					}
				}
				// case: node, node, node
				if (isNode(firstNode) && isNode(secondNode) && isNode(thirdNode)) {
					if (nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond + 1 != nodeIndexThird
								|| nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexSecond != 1 || nodeIndexThird != 2 || nodeIndexThird != executedNodes.size() - 1)
							return false;
					} else if (!nodeBeforeWindowExists && nodeAfterWindowExists) {
						if (nodeIndexFirst != 0 || nodeIndexSecond != 1 || nodeIndexThird != 2 || nodeIndexThird == executedNodes.size() - 1)
							return false;
					} else if (nodeBeforeWindowExists && !nodeAfterWindowExists) {
						if (nodeIndexFirst == 0 || nodeIndexFirst + 1 != nodeIndexSecond || nodeIndexSecond + 1 != nodeIndexThird
								|| nodeIndexThird != executedNodes.size() - 1)
							return false;
					}
				}
				// if it is the last window exit the for loop
				if (nodeOrder.size() == step + 3)
					break;
			}
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

	private boolean isStar(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("*"))
			return true;
		return false;
	}

	private boolean isUnderscore(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("_"))
			return true;
		return false;
	}

	private boolean isNode(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getNode() != null)
			return true;
		return false;
	}
}