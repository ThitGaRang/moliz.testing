package org.modelexecution.fumltesting.core.assertions;

import java.util.List;

import org.modelexecution.fumltesting.core.parallelism.ExecutionMatrix;
import org.modelexecution.fumltesting.core.results.MatrixOrderAssertionResult;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

public class MatrixOrderAssertionValidator {
	private TraceUtil traceUtil;
	private OrderUtil orderUtil;
	private ExecutionMatrix matrix;

	public MatrixOrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		this.orderUtil = new OrderUtil();
		this.matrix = new ExecutionMatrix(orderUtil.getTopNodes(traceUtil.getActivityExecution()));
		this.matrix.printMatrix();
	}

	public MatrixOrderAssertionResult checkOrder(OrderAssertion assertion) {
		MatrixOrderAssertionResult result = new MatrixOrderAssertionResult(((OrderAssertion) assertion).getOrder().getAllNodes());
		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = assertion.getOrder().getAllNodes();

		result.setAssertionValidationResult(validate(nodeOrder));

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

				MatrixOrderAssertionResult subOrderResult = new MatrixOrderAssertionResult(nodeSpecification.getSubOrder().getAllNodes());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);
				MatrixOrderAssertionValidator subOrderValidator = new MatrixOrderAssertionValidator(subTraceUtil);

				subOrderResult.setAssertionValidationResult(subOrderValidator.validate(nodeSpecification.getSubOrder().getAllNodes()));

				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	private boolean validate(List<NodeSpecification> orderSpecification) {
		if (orderSpecification.size() == 1) {
			NodeSpecification specifiedNode = orderSpecification.get(0);

			// case: node or _
			if (orderUtil.isNode(specifiedNode) || orderUtil.isUnderscore(specifiedNode)) {
				if (orderUtil.isNode(specifiedNode))
					return matrix.nodeSize() == 1 && matrix.wasExecuted(specifiedNode.getNode());
				return matrix.nodeSize() == 1;
			}
			// case: *
			else if (orderUtil.isStar(specifiedNode)) {
				return matrix.nodeSize() >= 0;
			}

		} else if (orderSpecification.size() == 2) {
			NodeSpecification firstNode = orderSpecification.get(0);
			NodeSpecification secondNode = orderSpecification.get(1);

			// case: node, *
			if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode)) {
				return matrix.isStartNode(firstNode.getNode()) && !matrix.hasIndependentNodes(firstNode.getNode()) && matrix.nodeSize() >= 1;
			}
			// case: *, node
			else if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode)) {
				return matrix.isEndNode(secondNode.getNode()) && !matrix.hasIndependentNodes(secondNode.getNode()) && matrix.nodeSize() >= 1;
			}
			// case: node, _
			else if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode)) {
				return matrix.isStartNode(firstNode.getNode()) && !matrix.hasIndependentNodes(firstNode.getNode()) && matrix.nodeSize() == 2;
			}
			// case: _, node
			else if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode)) {
				return matrix.isEndNode(secondNode.getNode()) && !matrix.hasIndependentNodes(secondNode.getNode()) && matrix.nodeSize() == 2;
			}
			// case: node, node
			else if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode)) {
				return matrix.isStartNode(firstNode.getNode()) && matrix.isEndNode(secondNode.getNode())
						&& matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && matrix.nodeSize() == 2;
			}

		} else if (orderSpecification.size() > 2) {
			for (int step = 0; step < orderSpecification.size(); step++) {
				// checking window of three subsequent node specifications
				NodeSpecification firstNode = orderSpecification.get(step);
				NodeSpecification secondNode = orderSpecification.get(step + 1);
				NodeSpecification thirdNode = orderSpecification.get(step + 2);

				boolean nodeBeforeWindowExists = step > 0;
				boolean nodeAfterWindowExists = orderSpecification.size() - 1 > step + 2;

				if (orderUtil.isNode(firstNode) && !matrix.wasExecuted(firstNode.getNode())) {
					return false;
				}
				if (orderUtil.isNode(secondNode) && !matrix.wasExecuted(secondNode.getNode())) {
					return false;
				}
				if (orderUtil.isNode(thirdNode) && !matrix.wasExecuted(thirdNode.getNode())) {
					return false;
				}

				// case: *, node, *
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					boolean result = matrix.nodeSize() >= 1;
					if (!result)
						return false;
				}
				// case: *, node, _
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeAfterWindowExists) {
						boolean result = !matrix.isEndNode(secondNode.getNode());
						if (!result)
							return false;
					} else {
						boolean result = matrix.getDescendants(secondNode.getNode()).size() == 1 && !matrix.hasIndependentNodes(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, *
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						boolean result = !matrix.isStartNode(secondNode.getNode()) && !matrix.isEndNode(secondNode.getNode());
						if (!result)
							return false;
					} else {
						boolean result = !matrix.isEndNode(secondNode.getNode()) && matrix.getAncestors(secondNode.getNode()).size() == 1
								&& !matrix.hasIndependentNodes(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, _
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = !matrix.isStartNode(secondNode.getNode()) && !matrix.isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = !matrix.isStartNode(secondNode.getNode()) && matrix.getDescendants(secondNode.getNode()).size() == 1
									&& !matrix.hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = !matrix.isEndNode(secondNode.getNode()) && matrix.getAncestors(secondNode.getNode()).size() == 1
									&& !matrix.hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.getDescendants(secondNode.getNode()).size() == 1 && matrix.getAncestors(secondNode.getNode()).size() == 1
									&& !matrix.hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, _
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && !matrix.isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.getDescendants(secondNode.getNode()).size() == 1;
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.isStartNode(firstNode.getNode()) && matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& !matrix.isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.isStartNode(firstNode.getNode()) && matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.getDescendants(secondNode.getNode()).size() == 1;
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, *
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && !matrix.isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode());
							if (!result)
								return false;
						}
					} else {
						boolean result = matrix.isStartNode(firstNode.getNode()) && matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
								&& !matrix.isEndNode(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, node
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.getPredecessors(secondNode.getNode()).size() == 1
									&& matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: *, node, node
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, _, node
				if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.getSuccessors(firstNode.getNode()).size() == 1 && matrix.getPredecessors(thirdNode.getNode()).size() == 1
									&& matrix.getSuccessors(firstNode.getNode()).get(0) == matrix.getPredecessors(thirdNode.getNode()).get(0);
							if (!result)
								return false;
						} else {
							boolean result = matrix.getSuccessors(firstNode.getNode()).size() == 1 && matrix.getPredecessors(thirdNode.getNode()).size() == 1
									&& matrix.getSuccessors(firstNode.getNode()).get(0) == matrix.getPredecessors(thirdNode.getNode()).get(0)
									&& matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.getSuccessors(firstNode.getNode()).size() == 1 && matrix.getPredecessors(thirdNode.getNode()).size() == 1
									&& matrix.getSuccessors(firstNode.getNode()).get(0) == matrix.getPredecessors(thirdNode.getNode()).get(0)
									&& matrix.isStartNode(firstNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.getSuccessors(firstNode.getNode()).size() == 1 && matrix.getPredecessors(thirdNode.getNode()).size() == 1
									&& matrix.getSuccessors(firstNode.getNode()).get(0) == matrix.getPredecessors(thirdNode.getNode()).get(0)
									&& matrix.isStartNode(firstNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, *, node
				if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.getDescendants(firstNode.getNode()).contains(thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.getDescendants(firstNode.getNode()).contains(thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.isStartNode(firstNode.getNode())
									&& matrix.getDescendants(firstNode.getNode()).contains(thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.isStartNode(firstNode.getNode())
									&& matrix.getDescendants(firstNode.getNode()).contains(thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, node
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = matrix.isStartNode(firstNode.getNode()) && matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = matrix.isStartNode(firstNode.getNode()) && matrix.alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& matrix.alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && matrix.isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// if it is the last window exit the for loop
				if (orderSpecification.size() == step + 3)
					break;
			}
		}
		return true;
	}
}