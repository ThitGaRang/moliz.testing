package org.modelexecution.fumltesting.core.parallelism;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;

import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

public class ExecutionMatrix {
	private boolean[][] matrix;

	private ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();

	private ArrayList<ActivityNode> startNodes = new ArrayList<ActivityNode>();
	private ArrayList<ActivityNode> endNodes = new ArrayList<ActivityNode>();

	public ExecutionMatrix(List<ActivityNodeExecution> nodeExecutions) {
		for (ActivityNodeExecution nodeExecution : nodeExecutions) {
			nodes.add(nodeExecution.getNode());
			if (nodeExecution.getLogicalPredecessor().size() == 0)
				startNodes.add(nodeExecution.getNode());
			if (nodeExecution.getLogicalSuccessor().size() == 0)
				endNodes.add(nodeExecution.getNode());
		}

		matrix = new boolean[nodes.size()][nodes.size()];

		for (int rowIndex = 0; rowIndex < nodeExecutions.size(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < nodeExecutions.size(); columnIndex++) {
				ActivityNodeExecution sourceNode = nodeExecutions.get(rowIndex);
				ActivityNodeExecution targetNode = nodeExecutions.get(columnIndex);
				if (sourceNode.getLogicalSuccessor().contains(targetNode)) {
					matrix[rowIndex][columnIndex] = true;
				}
			}
		}
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public boolean wasExecuted(ActivityNode node) {
		return nodes.contains(node);
	}

	public ArrayList<ActivityNode> getPredecessors(ActivityNode node) {
		ArrayList<ActivityNode> predecessors = new ArrayList<ActivityNode>();
		int index = indexOf(node);
		for (int rowIndex = 0; rowIndex < nodes.size(); rowIndex++) {
			if (matrix[rowIndex][index])
				predecessors.add(nodes.get(rowIndex));
		}
		return predecessors;
	}

	public ArrayList<ActivityNode> getAncestors(ActivityNode node) {
		ArrayList<ActivityNode> ancestors = new ArrayList<>();
		loadAncestors(node, ancestors);
		return ancestors;
	}

	private void loadAncestors(ActivityNode node, ArrayList<ActivityNode> ancestors) {
		int index = indexOf(node);
		for (int rowIndex = 0; rowIndex < nodes.size(); rowIndex++) {
			if (matrix[rowIndex][index]) {
				ancestors.add(nodes.get(rowIndex));
				loadAncestors(nodes.get(rowIndex), ancestors);
			}
		}
	}

	public ArrayList<ActivityNode> getSuccessors(ActivityNode node) {
		ArrayList<ActivityNode> successors = new ArrayList<ActivityNode>();
		int index = indexOf(node);
		for (int columnIndex = 0; columnIndex < nodes.size(); columnIndex++) {
			if (matrix[index][columnIndex])
				successors.add(nodes.get(columnIndex));
		}
		return successors;
	}

	public ArrayList<ActivityNode> getDescendants(ActivityNode node) {
		ArrayList<ActivityNode> descendants = new ArrayList<ActivityNode>();
		loadDescendants(node, descendants);
		return descendants;
	}

	private void loadDescendants(ActivityNode node, ArrayList<ActivityNode> descendants) {
		int index = indexOf(node);
		for (int columnIndex = 0; columnIndex < nodes.size(); columnIndex++) {
			if (matrix[index][columnIndex]) {
				descendants.add(nodes.get(columnIndex));
				loadDescendants(nodes.get(columnIndex), descendants);
			}
		}
	}

	private int indexOf(ActivityNode node) {
		for (ActivityNode aNode : nodes) {
			if (aNode.name.equals(node.name))
				return nodes.indexOf(aNode);
		}
		return -1;
	}

	public boolean hasIndependentNodes(ActivityNode node) {
		for (ActivityNode aNode : nodes) {
			if (!getAncestors(node).contains(aNode) && !getDescendants(node).contains(aNode) && aNode != node)
				return true;
		}
		return false;
	}

	public boolean alwaysInOrder(ActivityNode nodeA, ActivityNode nodeB) {
		return getSuccessors(nodeA).contains(nodeB) && !hasIndependentNodes(nodeA) && !hasIndependentNodes(nodeB);
	}

	public boolean isStartNode(ActivityNode node) {
		for (ActivityNode aNode : startNodes) {
			if (aNode.name.equals(node.name))
				return true;
		}
		return false;
	}

	public int startNodeSize() {
		return startNodes.size();
	}

	public boolean isEndNode(ActivityNode node) {
		for (ActivityNode aNode : endNodes) {
			if (aNode.name.equals(node.name))
				return true;
		}
		return false;
	}

	public int endNodeSize() {
		return endNodes.size();
	}

	public int nodeSize() {
		return nodes.size();
	}
}