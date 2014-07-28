/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.parallelism;

import java.util.ArrayList;
import java.util.LinkedList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

/**
 * Utility class for generating all possible paths in the execution graph.
 * 
 * @author Stefan Mijatov
 */
public class ExecutionPathFinder {

	private ExecutionGraph graph;
	private ExecutionGraphNode startNode;
	private ExecutionGraphNode endNode;
	private ArrayList<ExecutionPath> paths = new ArrayList<ExecutionPath>();

	public void init(ActivityExecution execution) {
		for (ActivityNodeExecution nodeExecution : execution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0) {
				graph = new ExecutionGraph();
				graph.initGraph(nodeExecution);

				startNode = graph.getRoot();
				for (ExecutionGraphNode theEndNode : graph.getEndNodes()) {
					endNode = theEndNode;
					LinkedList<ExecutionGraphNode> visited = new LinkedList<ExecutionGraphNode>();
					visited.add(startNode);
					generatePaths(graph, visited);
				}
			}
		}
	}

	public ArrayList<ArrayList<ActivityNodeExecution>> getAllPaths() {
		ArrayList<ArrayList<ActivityNodeExecution>> paths = new ArrayList<ArrayList<ActivityNodeExecution>>();
		for (ExecutionPath path : this.paths) {
			paths.add(path.getPath());
		}
		return paths;
	}

	private void generatePaths(ExecutionGraph graph, LinkedList<ExecutionGraphNode> visited) {
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
			generatePaths(graph, visited);
			visited.removeLast();
		}
	}

	private void addNewPath(LinkedList<ExecutionGraphNode> nodes) {
		ExecutionPath newPath = new ExecutionPath(nodes);
		if (!newPath.isEmpty() && !paths.contains(newPath))
			paths.add(newPath);
	}
}