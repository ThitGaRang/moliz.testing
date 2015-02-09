package org.modelexecution.fumltesting.core.assertions;

import java.util.List;

import org.modelexecution.fumltesting.core.parallelism.ExecutionMatrix;
import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

public class MatrixOrderAssertionValidator extends OrderAssertionValidator {
	private ExecutionMatrix matrix;

	public MatrixOrderAssertionValidator(TraceUtil traceUtil) {
		super(traceUtil);
		this.matrix = new ExecutionMatrix(orderUtil.getTopNodes(traceUtil.getActivityExecution()));
	}

	public OrderAssertionResult checkOrder(OrderAssertion assertion) {
		OrderAssertionResult result = prepareResult(assertion.getOrder().getAllNodes(), OrderAssertionValidationType.MATRIX);
		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = assertion.getOrder().getAllNodes();
		result.setResult(validate(nodeOrder));

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

				OrderAssertionResult subOrderResult = prepareResult(nodeSpecification.getSubOrder().getAllNodes(), OrderAssertionValidationType.MATRIX);
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new TraceUtil(activityExecutionID);
				MatrixOrderAssertionValidator subOrderValidator = new MatrixOrderAssertionValidator(subTraceUtil);

				subOrderResult.setResult(subOrderValidator.validate(nodeSpecification.getSubOrder().getAllNodes()));

				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	@Override
	protected int getNumberOfExecutedNodes() {
		return matrix.nodeSize();
	}

	@Override
	protected boolean wasExecuted(ActivityNode activityNode) {
		return matrix.wasExecuted(activityNode);
	}

	@Override
	protected boolean isStartNode(ActivityNode activityNode) {
		return matrix.isStartNode(activityNode);
	}

	@Override
	protected boolean isEndNode(ActivityNode activityNode) {
		return matrix.isEndNode(activityNode);
	}

	@Override
	protected boolean hasIndependentNodes(ActivityNode activityNode) {
		return matrix.hasIndependentNodes(activityNode);
	}

	@Override
	protected boolean alwaysInOrder(ActivityNode firstActivityNode, ActivityNode secondActivityNode) {
		return matrix.alwaysInOrder(firstActivityNode, secondActivityNode);
	}

	@Override
	protected List<ActivityNode> getAncestors(ActivityNode activityNode) {
		return matrix.getAncestors(activityNode);
	}

	@Override
	protected List<ActivityNode> getDescendants(ActivityNode activityNode) {
		return matrix.getDescendants(activityNode);
	}

	@Override
	protected List<ActivityNode> getSuccessors(ActivityNode activityNode) {
		return matrix.getSuccessors(activityNode);
	}

	@Override
	protected List<ActivityNode> getPredecessors(ActivityNode activityNode) {
		return matrix.getPredecessors(activityNode);
	}
}