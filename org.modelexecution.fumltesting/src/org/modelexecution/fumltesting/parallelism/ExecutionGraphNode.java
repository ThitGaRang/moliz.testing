package org.modelexecution.fumltesting.parallelism;

import java.util.HashSet;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

public class ExecutionGraphNode {
	private ActivityNodeExecution data;
	private HashSet<ExecutionGraphNode> predecessors = new HashSet<ExecutionGraphNode>();
	private HashSet<ExecutionGraphNode> successors = new HashSet<ExecutionGraphNode>();
	public ExecutionGraphNode(ActivityNodeExecution data){this.data = data;}
	
	public ActivityNodeExecution getData(){return data;}
	
	public void addSuccessor(ExecutionGraphNode successor){successors.add(successor);}
	public boolean hasNextSuccessor(){return successors.iterator().hasNext();}
	public ExecutionGraphNode getNextSuccessor(){return successors.iterator().next();}
	
	public void addPredecessor(ExecutionGraphNode predecessor){predecessors.add(predecessor);}
	public boolean containsPredecessor(ExecutionGraphNode predecessor){return predecessors.contains(predecessor);}
}