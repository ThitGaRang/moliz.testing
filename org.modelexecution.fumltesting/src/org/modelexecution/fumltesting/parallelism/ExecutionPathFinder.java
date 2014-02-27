/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.parallelism;

import java.util.ArrayList;
import java.util.LinkedList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

import fUML.Syntax.Activities.IntermediateActivities.FinalNode;

/**
 * Utility class for generating all possible paths in the execution graph.
 * 
 * @author Stefan Mijatov
 */
public class ExecutionPathFinder {

	private ExecutionGraph graph;
	private ExecutionGraphNode startNode;
	private ExecutionGraphNode endNode;
	private ArrayList<LinkedList<ExecutionGraphNode>> paths;

	public ExecutionPathFinder() {
		paths = new ArrayList<LinkedList<ExecutionGraphNode>>();
	}

	public ArrayList<LinkedList<ExecutionGraphNode>> getPaths() {
		return paths;
	}

	/** Initializes the execution graph, start and end node. */
	public void init(ActivityExecution execution) {
		for (ActivityNodeExecution nodeExecution : execution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0) {
				graph = new ExecutionGraph();
				graph.initGraph(nodeExecution);

				startNode = graph.getRoot();
				for (ExecutionGraphNode theEndNode : graph.getEndNodes()) {
					endNode = theEndNode;
					generatePaths(execution);
				}
			}
		}
	}

	/** Prints all the paths to the console. */
	public void printPaths() {
		System.out.println("Number of executions found: " + getPaths().size());
		int numberOfPath = 0;
		for (LinkedList<ExecutionGraphNode> path : getPaths()) {
			numberOfPath++;
			System.out.print(numberOfPath + ":");
			for (int i = 0; i < path.size(); i++) {
				if (i == path.size() - 1)
					System.out.print(path.get(i).getData().getNode().name);
				else
					System.out.print(path.get(i).getData().getNode().name + ", ");
			}
			System.out.println();
		}
	}

	/**
	 * Finds all the paths in the execution graph, and stores them into 'paths'
	 * list.
	 */
	private void generatePaths(ActivityExecution execution) {
		LinkedList<ExecutionGraphNode> visited = new LinkedList<ExecutionGraphNode>();
		visited.add(startNode);
		generatePath(graph, visited);
	}

	/** Breadth first search to find all paths. */
	private void generatePath(ExecutionGraph graph, LinkedList<ExecutionGraphNode> visited) {
		LinkedList<ExecutionGraphNode> nodes = new LinkedList<ExecutionGraphNode>(visited.getLast().getSuccessors());

		Outer: for (ExecutionGraphNode node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.getData() == endNode.getData() && node.getSuccessors().size() == 0) {
				visited.add(node);
				addNewPath(visited);
				visited.removeLast();
				break Outer;
			}
		}

		Outer: for (ExecutionGraphNode node : nodes) {
			if (visited.contains(node) || node.getData() == endNode.getData()) {
				continue Outer;
			}
			visited.addLast(node);
			generatePath(graph, visited);
			visited.removeLast();
		}
	}

	/** Adds a new path to the paths list. */
	private void addNewPath(LinkedList<ExecutionGraphNode> nodes) {
		LinkedList<ExecutionGraphNode> path = new LinkedList<ExecutionGraphNode>();
		path.addAll(nodes);

		for (ExecutionGraphNode node : nodes) {
			if (node.getData().getNode() instanceof FinalNode) {
				int nextIndex = nodes.indexOf(node) + 1;
				if (nextIndex < nodes.size()) {
					if (nodes.get(nextIndex).getData().getActivityExecution() == node.getData().getActivityExecution()) {
						for (int i = nextIndex; i < nodes.size(); i++) {
							if (!path.isEmpty())
								path.removeLast();
						}
					}
				}
			}
		}

		if (!path.isEmpty() && !pathAlreadyAdded(path))
			paths.add(path);
	}

	private boolean pathAlreadyAdded(LinkedList<ExecutionGraphNode> path) {
		outer: for (LinkedList<ExecutionGraphNode> aPath : paths) {
			if (aPath.size() == path.size()) {
				for (int i = 0; i < aPath.size(); i++) {
					if (aPath.get(i).getData().getNode() != path.get(i).getData().getNode())
						continue outer;
				}
				return true;
			}
		}
		return false;
	}
}