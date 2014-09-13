package org.modelexecution.fumltesting.core.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Activities.IntermediateActivities.ForkNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;
import fUML.Syntax.Activities.IntermediateActivities.JoinNode;
import fUML.Syntax.Activities.IntermediateActivities.MergeNode;

public class OrderUtil {
	public boolean isStar(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("*"))
			return true;
		return false;
	}

	public boolean isUnderscore(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("_"))
			return true;
		return false;
	}

	public boolean isNode(NodeSpecification nodeSpecification) {
		if (nodeSpecification.getNode() != null)
			return true;
		return false;
	}

	private boolean isFilteredOut(ActivityNode node) {
		if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode || node instanceof ForkNode || node instanceof JoinNode
				|| node instanceof DecisionNode || node instanceof MergeNode)
			return false;
		return true;
	}

	public List<ActivityNodeExecution> getTopNodes(ActivityExecution activityExecution) {
		List<ActivityNodeExecution> topNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution node : activityExecution.getNodeExecutions()) {
			if (node.getNode().owner == activityExecution.getActivity() && !isFilteredOut(node.getNode())) {
				topNodes.add(node);
			}
		}
		return topNodes;
	}

	public List<ActivityNodeExecution> getTopNodes(Activity activity, List<ActivityNodeExecution> path) {
		List<ActivityNodeExecution> topNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution node : path) {
			if (node.getNode().owner == activity && !isFilteredOut(node.getNode())) {
				topNodes.add(node);
			}
		}
		return topNodes;
	}

	public int indexOf(ActivityNode activityNode, List<ActivityNodeExecution> nodeExecutions) {
		for (ActivityNodeExecution nodeExecution : nodeExecutions) {
			if (nodeExecution.getNode() == activityNode)
				return nodeExecutions.indexOf(nodeExecution);
		}
		return -1;
	}
}