package org.modelexecution.fumltesting.parallelism;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

public class ExecutionGraphNode {	
	
	public ExecutionGraphNode(ActivityNodeExecution data){this.data = data;}
	
	private ActivityNodeExecution data;
	private ExecutionGraphNode parent;
	private ArrayList<ExecutionGraphNode> successors = new ArrayList<ExecutionGraphNode>();
		
	public ActivityNodeExecution getData(){return data;}	
	
	public void addSuccessor(ExecutionGraphNode successor){
		successors.add(successor);
		successor.parent = this;
	}
	
	public boolean containsPredecessor(ActivityNodeExecution node){
		if(parent != null && (parent.getData() == node || parent.containsPredecessor(node)))
			return true;
		return false;
	}
}