package org.modelexecution.fumltesting.core.parallelism;

import java.util.ArrayList;
import java.util.LinkedList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

import fUML.Syntax.Activities.IntermediateActivities.FinalNode;

public class ExecutionPath {
	private boolean isCritical = false;
	private ArrayList<ActivityNodeExecution> path;

	public ExecutionPath(LinkedList<ExecutionGraphNode> nodes) {
		path = new ArrayList<ActivityNodeExecution>();
		for (ExecutionGraphNode node : nodes) {
			path.add(node.getData());
			if (node.getData().getNode() instanceof FinalNode)
				break;
		}
	}

	public ArrayList<ActivityNodeExecution> getPath() {
		return path;
	}

	public boolean isEmpty() {
		return path.isEmpty();
	}

	public void setCritical() {
		isCritical = true;
	}

	public boolean isCritical() {
		return isCritical;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExecutionPath) {
			ExecutionPath another = (ExecutionPath) obj;
			if (another.getPath().size() == getPath().size()) {
				for (int i = 0; i < getPath().size(); i++) {
					ActivityNodeExecution nodeFromThis = getPath().get(i);
					ActivityNodeExecution nodeFromAnother = another.getPath().get(i);
					if (nodeFromThis != nodeFromAnother)
						return false;
				}
				return true;
			}
		}
		return false;
	}
}