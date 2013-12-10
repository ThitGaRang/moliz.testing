package org.modelexecution.fumltesting.parallelism;

import java.util.ArrayList;
import java.util.LinkedList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;

/**
 * Utility class for generating all possible paths in the execution graph.
 * 
 * @author Stefan Mijatov
 */
public class ExecutionPathFinder {

	private ExecutionGraph graph;
	private ExecutionGraphNode startNode;
	private ArrayList<ExecutionGraphNode> endNodes;
	private ArrayList<LinkedList<ExecutionGraphNode>> paths;

	public ExecutionPathFinder() {
		paths = new ArrayList<LinkedList<ExecutionGraphNode>>();
	}

	public ArrayList<LinkedList<ExecutionGraphNode>> getPaths() {
		return paths;
	}

	/** Initializes the execution graph, start and end node. */
	public void init(ActivityExecution execution) {
		graph = new ExecutionGraph();
		graph.initGraph(execution);

		startNode = graph.getRoot();
		endNodes = graph.getEndNodes();

		generatePaths(execution);
	}

	/** Prints all the paths to the console. */
	public void printPaths() {
		System.out.println("Number of executions found: " + getPaths().size());
		int numberOfPath = 0;
		for (LinkedList<ExecutionGraphNode> path : getPaths()) {
			numberOfPath++;
			System.out.print(numberOfPath + ": ");
			for (int i = 0; i < path.size(); i++) {
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

		Outer:
		for (ExecutionGraphNode node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			for(ExecutionGraphNode endNode: endNodes){
				if (node.getData() == endNode.getData()) {
					visited.add(node);
					addNewPath(visited);
					visited.removeLast();
					break Outer;
				}
			}			
		}

		Outer:
		for (ExecutionGraphNode node : nodes) {
			for(ExecutionGraphNode endNode: endNodes){
				if (visited.contains(node) || node.getData() == endNode.getData()) {
					continue Outer;
				}
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
		paths.add(path);
	}
}