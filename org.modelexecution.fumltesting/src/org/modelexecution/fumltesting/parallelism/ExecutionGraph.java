package org.modelexecution.fumltesting.parallelism;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

/**
 * Utility class for generating all possible orders of execution.
 * 
 * @author Stefan Mijatov
 */
public class ExecutionGraph {

	private ExecutionGraphNode root;
	private ArrayList<ExecutionGraphNode> endNodes;

	public ExecutionGraphNode getRoot() {
		return root;
	}

	/** Takes a node and generates executions from it till the last node. */
	private ExecutionGraphNode generateExecutionGraphNode(ExecutionGraphNode node) {
		List<ActivityNodeExecution> allPossibleSuccessors = getAllPossibleSuccessors(node, new ArrayList<ActivityNodeExecution>());

		for (ActivityNodeExecution successor : allPossibleSuccessors) {
			boolean canAdd = canAddSuccessor(node, successor);
			if (canAdd) {
				ExecutionGraphNode nodeSuccessor = new ExecutionGraphNode(successor);
				if (!node.containsPredecessor(nodeSuccessor.getData())) {
					node.addSuccessor(nodeSuccessor);
					nodeSuccessor = generateExecutionGraphNode(nodeSuccessor);
				}
			}
		}
		return node;
	}

	/**
	 * Checks if successor can be added to the node based on logical dependency
	 * from the trace.
	 */
	private boolean canAddSuccessor(ExecutionGraphNode node, ActivityNodeExecution successor) {
		for (ActivityNodeExecution predecessor : successor.getLogicalPredecessor()) {
			if (successor.isExecuted() && !node.containsPredecessor(predecessor) && node.getData() != predecessor 
					&& node.getData() != successor && !node.containsPredecessor(successor)) {
				return false;
			}
			if(node.containsSuccessor(successor))return false;
		}
		return true;
	}

	/** Returns all logical and all possible non-logical successors of the node. */
	private List<ActivityNodeExecution> getAllPossibleSuccessors(ExecutionGraphNode node, List<ActivityNodeExecution> allSuccessors) {
		ActivityNodeExecution nodeExecution = node.getData();
		
		List<ActivityNodeExecution> allLogicalSuccessors = getAllLogicalSuccessors(nodeExecution, new ArrayList<ActivityNodeExecution>());
		List<ActivityNodeExecution> allLogicalPredecessors = getAllLogicalPredecessors(nodeExecution, new ArrayList<ActivityNodeExecution>());
				
		List<ActivityNodeExecution> freeNodes = getAllFreeNodes(nodeExecution.getActivityExecution());
		for(ActivityNodeExecution aNodeExecution: freeNodes){
			if(aNodeExecution != nodeExecution){
				allSuccessors.add(aNodeExecution);
				ArrayList<ActivityNodeExecution> successorsOfANode = new ArrayList<ActivityNodeExecution>(getAllLogicalSuccessors(aNodeExecution, new ArrayList<ActivityNodeExecution>()));
				successorsOfANode.removeAll(getAllLogicalSuccessors(node.getData(), new ArrayList<ActivityNodeExecution>()));
				successorsOfANode.remove(node.getData());
				allSuccessors.addAll(successorsOfANode);
			}
		}
		
		for (ActivityNodeExecution successor : nodeExecution.getLogicalSuccessor()) {
			allSuccessors.add(successor);
			for (ActivityNodeExecution predecessor : getAllLogicalPredecessors(nodeExecution, new ArrayList<ActivityNodeExecution>())) {
				for (ActivityNodeExecution successorOfPredecessor : getAllLogicalSuccessors(predecessor, new ArrayList<ActivityNodeExecution>())) {
					if (successorOfPredecessor != nodeExecution && !allLogicalSuccessors.contains(successorOfPredecessor)
							&& !allLogicalPredecessors.contains(successorOfPredecessor)) {
						if (!allSuccessors.contains(successorOfPredecessor))
							allSuccessors.add(successorOfPredecessor);
					}
				}
			}
		}
		return allSuccessors;
	}

	/**
	 * Returns all logical successors of the node, and logical successors of the
	 * successors.
	 */
	private List<ActivityNodeExecution> getAllLogicalSuccessors(ActivityNodeExecution nodeExecution, List<ActivityNodeExecution> allLogicalSuccessors) {
		for (ActivityNodeExecution successor : nodeExecution.getLogicalSuccessor()) {
			if (!allLogicalSuccessors.contains(successor))
				allLogicalSuccessors.add(successor);
			if (successor.getLogicalSuccessor().size() > 0)
				getAllLogicalSuccessors(successor, allLogicalSuccessors);
		}
		return allLogicalSuccessors;
	}

	/**
	 * Returns all logical predecessors of the node, and logical predecessors of
	 * the predecessors.
	 */
	private List<ActivityNodeExecution> getAllLogicalPredecessors(ActivityNodeExecution nodeExecution,
			List<ActivityNodeExecution> allLogicalPredecessors) {
		for (ActivityNodeExecution predecessor : nodeExecution.getLogicalPredecessor()) {
			if (!allLogicalPredecessors.contains(predecessor))
				allLogicalPredecessors.add(predecessor);
			if (predecessor.getLogicalPredecessor().size() > 0)
				getAllLogicalPredecessors(predecessor, allLogicalPredecessors);
		}
		return allLogicalPredecessors;
	}

	/** Method to generate execution graph for the root node. */
	public void initGraph(ActivityNodeExecution execution) {
		root = generateExecutionGraphNode(new ExecutionGraphNode(execution));
	}

	/** Returns all nodes without the successors. */
	public ArrayList<ExecutionGraphNode> getEndNodes() {
		endNodes = new ArrayList<ExecutionGraphNode>();
		getEndNodes(root);
		return endNodes;
	}

	private void getEndNodes(ExecutionGraphNode node) {
		for (ExecutionGraphNode child : node.getSuccessors()) {
			if (child.getData().getLogicalSuccessor().size() == 0) {
				boolean isContained = false;
				for(ExecutionGraphNode successor: endNodes){
					if(successor.getData() == child.getData())isContained = true;
				}
				if(!isContained)endNodes.add(child);
			} else {
				getEndNodes(child);
			}
		}
	}

	private ArrayList<ActivityNodeExecution> getAllFreeNodes(ActivityExecution activityExecution) {
		ArrayList<ActivityNodeExecution> freeNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0)
				freeNodes.add(nodeExecution);
		}
		return freeNodes;
	}
}