package org.modelexecution.fumltesting.core.assertions;

import java.util.List;

import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

public abstract class OrderAssertionValidator {
	protected TraceUtil traceUtil;
	protected OrderUtil orderUtil;

	public OrderAssertionValidator(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		this.orderUtil = new OrderUtil();
	}

	protected OrderAssertionResult prepareResult(List<NodeSpecification> nodes, OrderAssertionValidationType validationType) {
		OrderAssertionResult result = new OrderAssertionResult(nodes, validationType);
		return result;
	}

	protected boolean validate(List<NodeSpecification> orderSpecification) {
		if (orderSpecification.size() == 1) {
			NodeSpecification specifiedNode = orderSpecification.get(0);
			// case: node or _
			if (orderUtil.isNode(specifiedNode) || orderUtil.isUnderscore(specifiedNode)) {
				if (orderUtil.isNode(specifiedNode))
					return getNumberOfExecutedNodes() == 1 && wasExecuted(specifiedNode.getNode());
				return getNumberOfExecutedNodes() == 1;
			}
			// case: *
			else if (orderUtil.isStar(specifiedNode)) {
				return getNumberOfExecutedNodes() >= 0;
			}
		} else if (orderSpecification.size() == 2) {
			NodeSpecification firstNode = orderSpecification.get(0);
			NodeSpecification secondNode = orderSpecification.get(1);

			// case: node, *
			if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode)) {
				return isStartNode(firstNode.getNode()) && !hasIndependentNodes(firstNode.getNode()) && getNumberOfExecutedNodes() >= 1;
			}
			// case: *, node
			else if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode)) {
				return isEndNode(secondNode.getNode()) && !hasIndependentNodes(secondNode.getNode()) && getNumberOfExecutedNodes() >= 1;
			}
			// case: node, _
			else if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode)) {
				return isStartNode(firstNode.getNode()) && !hasIndependentNodes(firstNode.getNode()) && getNumberOfExecutedNodes() == 2;
			}
			// case: _, node
			else if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode)) {
				return isEndNode(secondNode.getNode()) && !hasIndependentNodes(secondNode.getNode()) && getNumberOfExecutedNodes() == 2;
			}
			// case: node, node
			else if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode)) {
				return isStartNode(firstNode.getNode()) && isEndNode(secondNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
						&& getNumberOfExecutedNodes() == 2;
			}
		} else if (orderSpecification.size() > 2) {
			for (int step = 0; step < orderSpecification.size(); step++) {
				// checking window of three subsequent node specifications
				NodeSpecification firstNode = orderSpecification.get(step);
				NodeSpecification secondNode = orderSpecification.get(step + 1);
				NodeSpecification thirdNode = orderSpecification.get(step + 2);

				boolean nodeBeforeWindowExists = step > 0;
				boolean nodeAfterWindowExists = orderSpecification.size() - 1 > step + 2;

				if (orderUtil.isNode(firstNode) && !wasExecuted(firstNode.getNode())) {
					return false;
				}
				if (orderUtil.isNode(secondNode) && !wasExecuted(secondNode.getNode())) {
					return false;
				}
				if (orderUtil.isNode(thirdNode) && !wasExecuted(thirdNode.getNode())) {
					return false;
				}

				// case: *, node, *
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					boolean result = getNumberOfExecutedNodes() >= 1;
					if (!result)
						return false;
				}
				// case: *, node, _
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeAfterWindowExists) {
						boolean result = !isEndNode(secondNode.getNode());
						if (!result)
							return false;
					} else {
						boolean result = getDescendants(secondNode.getNode()).size() == 1 && !hasIndependentNodes(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, *
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						boolean result = !isStartNode(secondNode.getNode());
						if (!result)
							return false;
					} else {
						boolean result = !isEndNode(secondNode.getNode()) && getAncestors(secondNode.getNode()).size() == 1
								&& !hasIndependentNodes(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, _
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = !isStartNode(secondNode.getNode()) && !isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = !isStartNode(secondNode.getNode()) && getDescendants(secondNode.getNode()).size() == 1
									&& !hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = !isEndNode(secondNode.getNode()) && getAncestors(secondNode.getNode()).size() == 1
									&& !hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = getDescendants(secondNode.getNode()).size() == 1 && getAncestors(secondNode.getNode()).size() == 1
									&& !hasIndependentNodes(secondNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, _
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isUnderscore(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && !isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && getDescendants(secondNode.getNode()).size() == 1;
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = isStartNode(firstNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& !isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = isStartNode(firstNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& getDescendants(secondNode.getNode()).size() == 1;
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, *
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isStar(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode()) && !isEndNode(secondNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode());
							if (!result)
								return false;
						}
					} else {
						boolean result = isStartNode(firstNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
								&& !isEndNode(secondNode.getNode());
						if (!result)
							return false;
					}
				}
				// case: _, node, node
				if (orderUtil.isUnderscore(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = getPredecessors(secondNode.getNode()).size() == 1 && alwaysInOrder(secondNode.getNode(), thirdNode.getNode())
									&& isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: *, node, node
				if (orderUtil.isStar(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, _, node
				if (orderUtil.isNode(firstNode) && orderUtil.isUnderscore(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = getSuccessors(firstNode.getNode()).size() == 1 && getPredecessors(thirdNode.getNode()).size() == 1
									&& getSuccessors(firstNode.getNode()).get(0) == getPredecessors(thirdNode.getNode()).get(0);
							if (!result)
								return false;
						} else {
							boolean result = getSuccessors(firstNode.getNode()).size() == 1 && getPredecessors(thirdNode.getNode()).size() == 1
									&& getSuccessors(firstNode.getNode()).get(0) == getPredecessors(thirdNode.getNode()).get(0)
									&& isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = getSuccessors(firstNode.getNode()).size() == 1 && getPredecessors(thirdNode.getNode()).size() == 1
									&& getSuccessors(firstNode.getNode()).get(0) == getPredecessors(thirdNode.getNode()).get(0)
									&& isStartNode(firstNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = getSuccessors(firstNode.getNode()).size() == 1 && getPredecessors(thirdNode.getNode()).size() == 1
									&& getSuccessors(firstNode.getNode()).get(0) == getPredecessors(thirdNode.getNode()).get(0)
									&& isStartNode(firstNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, *, node
				if (orderUtil.isNode(firstNode) && orderUtil.isStar(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = getDescendants(firstNode.getNode()).contains(thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = getDescendants(firstNode.getNode()).contains(thirdNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = isStartNode(firstNode.getNode()) && getDescendants(firstNode.getNode()).contains(thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = isStartNode(firstNode.getNode()) && getDescendants(firstNode.getNode()).contains(thirdNode.getNode())
									&& isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					}
				}
				// case: node, node, node
				if (orderUtil.isNode(firstNode) && orderUtil.isNode(secondNode) && orderUtil.isNode(thirdNode)) {
					if (nodeBeforeWindowExists) {
						if (nodeAfterWindowExists) {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && isEndNode(thirdNode.getNode());
							if (!result)
								return false;
						}
					} else {
						if (nodeAfterWindowExists) {
							boolean result = isStartNode(firstNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& alwaysInOrder(secondNode.getNode(), thirdNode.getNode());
							if (!result)
								return false;
						} else {
							boolean result = isStartNode(firstNode.getNode()) && alwaysInOrder(firstNode.getNode(), secondNode.getNode())
									&& alwaysInOrder(secondNode.getNode(), thirdNode.getNode()) && isEndNode(thirdNode.getNode());
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

	protected abstract int getNumberOfExecutedNodes();

	protected abstract boolean wasExecuted(ActivityNode activityNode);

	protected abstract boolean isStartNode(ActivityNode activityNode);

	protected abstract boolean isEndNode(ActivityNode activityNode);

	protected abstract boolean hasIndependentNodes(ActivityNode activityNode);

	protected abstract boolean alwaysInOrder(ActivityNode firstActivityNode, ActivityNode secondActivityNode);

	protected abstract List<ActivityNode> getAncestors(ActivityNode activityNode);

	protected abstract List<ActivityNode> getDescendants(ActivityNode activityNode);

	protected abstract List<ActivityNode> getSuccessors(ActivityNode activityNode);

	protected abstract List<ActivityNode> getPredecessors(ActivityNode activityNode);

	public abstract OrderAssertionResult checkOrder(OrderAssertion assertion);
}