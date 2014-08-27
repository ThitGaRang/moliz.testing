/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.parallelism;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

import fUML.Syntax.Activities.IntermediateActivities.FinalNode;

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

	/** Generates execution graph for the given root node. */
	public void initGraph(ActivityNodeExecution execution) {
		root = generateExecutionGraphNode(new ExecutionGraphNode(execution));
	}

	/** Takes a node and generates executions from it till the last node. */
	private ExecutionGraphNode generateExecutionGraphNode(ExecutionGraphNode node) {
		List<ActivityNodeExecution> allPotentialSuccessors = getAllPotentialSuccessors(node);

		for (ActivityNodeExecution successor : allPotentialSuccessors) {
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

	/** Checks if successor can be added to the node. */
	private boolean canAddSuccessor(ExecutionGraphNode node, ActivityNodeExecution successor) {
		if (node.getData().getNode() instanceof FinalNode) {
			return false;
		}
		if (!successor.isExecuted() || node.getData() == successor || node.containsSuccessor(successor) || node.containsPredecessor(successor))
			return false;
		for (ActivityNodeExecution predecessor : successor.getLogicalPredecessor()) {
			if (!node.containsPredecessor(predecessor) && node.getData() != predecessor) {
				return false;
			}
		}
		return true;
	}

	/** Returns all logical and all possible non-logical successors of the node. */
	private List<ActivityNodeExecution> getAllPotentialSuccessors(ExecutionGraphNode node) {
		List<ActivityNodeExecution> allPotentialSuccessors = new ArrayList<ActivityNodeExecution>();
		ActivityNodeExecution nodeExecution = node.getData();

		List<ActivityNodeExecution> descendants = getDescendants(nodeExecution, new ArrayList<ActivityNodeExecution>());
		List<ActivityNodeExecution> ancestors = getAncestors(nodeExecution, new ArrayList<ActivityNodeExecution>());

		List<ActivityNodeExecution> startNodes = getStartNodes(nodeExecution.getActivityExecution());
		for (ActivityNodeExecution aNodeExecution : startNodes) {
			if (aNodeExecution != nodeExecution) {
				allPotentialSuccessors.add(aNodeExecution);
				List<ActivityNodeExecution> descendantsOfANode = getDescendants(aNodeExecution, new ArrayList<ActivityNodeExecution>());
				descendantsOfANode.removeAll(descendants);
				descendantsOfANode.remove(node.getData());
				allPotentialSuccessors.addAll(descendantsOfANode);
			}
		}

		allPotentialSuccessors.addAll(nodeExecution.getLogicalSuccessor());

		for (ActivityNodeExecution ancestor : ancestors) {
			for (ActivityNodeExecution descendantOfAncestor : getDescendants(ancestor, new ArrayList<ActivityNodeExecution>())) {
				if (descendantOfAncestor != nodeExecution && !ancestors.contains(descendantOfAncestor)) {
					if (!allPotentialSuccessors.contains(descendantOfAncestor))
						allPotentialSuccessors.add(descendantOfAncestor);
				}
			}
		}

		return allPotentialSuccessors;
	}

	/**
	 * Returns all logical successors, and logical successors of the successors
	 * of the node, and so on.
	 */
	private List<ActivityNodeExecution> getDescendants(ActivityNodeExecution nodeExecution, List<ActivityNodeExecution> descendants) {
		for (ActivityNodeExecution successor : nodeExecution.getLogicalSuccessor()) {
			if (!descendants.contains(successor))
				descendants.add(successor);
			if (successor.getLogicalSuccessor().size() > 0)
				getDescendants(successor, descendants);
		}
		return descendants;
	}

	/**
	 * Returns all logical predecessors, and logical predecessors of the
	 * predecessors of the node, and so on.
	 */
	private List<ActivityNodeExecution> getAncestors(ActivityNodeExecution nodeExecution, List<ActivityNodeExecution> ancestors) {
		for (ActivityNodeExecution predecessor : nodeExecution.getLogicalPredecessor()) {
			if (!ancestors.contains(predecessor))
				ancestors.add(predecessor);
			if (predecessor.getLogicalPredecessor().size() > 0)
				getAncestors(predecessor, ancestors);
		}
		return ancestors;
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
				for (ExecutionGraphNode successor : endNodes) {
					if (successor.getData() == child.getData())
						isContained = true;
				}
				if (!isContained)
					endNodes.add(child);
			} else {
				getEndNodes(child);
			}
		}
	}

	private ArrayList<ActivityNodeExecution> getStartNodes(ActivityExecution activityExecution) {
		ArrayList<ActivityNodeExecution> startNodes = new ArrayList<ActivityNodeExecution>();
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.isExecuted() && nodeExecution.getLogicalPredecessor().size() == 0)
				startNodes.add(nodeExecution);
		}
		return startNodes;
	}
}