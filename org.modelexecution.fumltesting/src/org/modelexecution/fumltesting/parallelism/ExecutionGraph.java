package org.modelexecution.fumltesting.parallelism;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

public class ExecutionGraph {
	private ExecutionGraphNode node;	
	
	public ExecutionGraphNode getRoot(){return node;}
	
	public void initGraph(ActivityExecution execution){
		node = new ExecutionGraphNode(execution.getNodeExecutions().get(0));
		initGraph(node);
	}
	
	private void initGraph(ExecutionGraphNode node){
		for(ActivityNodeExecution execution: node.getData().getLogicalSuccessor()){
			if(allPredecessorsTraversed(execution)){}
		}
	}
	
	private boolean allPredecessorsTraversed(ActivityNodeExecution nodeExecution){
		return false;
	}
}