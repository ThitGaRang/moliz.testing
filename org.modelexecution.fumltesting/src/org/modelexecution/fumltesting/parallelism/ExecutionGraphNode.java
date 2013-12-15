package org.modelexecution.fumltesting.parallelism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

/**
 * Class representing a single node of execution graph.
 * 
 * @author Stefan Mijatov
 * 
 */
public class ExecutionGraphNode {

	public ExecutionGraphNode(ActivityNodeExecution data) {
		this.data = data;
	}

	private ActivityNodeExecution data;
	private ExecutionGraphNode parent;
	private ArrayList<ExecutionGraphNode> successors = new ArrayList<ExecutionGraphNode>();

	public ActivityNodeExecution getData() {
		return data;
	}
	
	public ExecutionGraphNode getParent(){
		return parent;
	}

	public void addSuccessor(ExecutionGraphNode successor) {
		successors.add(successor);
		successor.parent = this;
	}

	public List<ExecutionGraphNode> getSuccessors() {
		return Collections.unmodifiableList(successors);
	}

	public boolean containsPredecessor(ActivityNodeExecution node) {
		if (parent != null && (parent.getData() == node || parent.containsPredecessor(node)))
			return true;
		return false;
	}
	
	public boolean containsSuccessor(ActivityNodeExecution node){
		for(ExecutionGraphNode successor: getSuccessors()){
			if(successor.getData() == node)return true;
		}
		return false;
	}
}