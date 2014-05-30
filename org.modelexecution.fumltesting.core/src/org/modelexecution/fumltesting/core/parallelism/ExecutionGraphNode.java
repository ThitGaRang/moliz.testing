/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.parallelism;

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

	public ExecutionGraphNode getParent() {
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

	public boolean containsSuccessor(ActivityNodeExecution node) {
		for (ExecutionGraphNode successor : getSuccessors()) {
			if (successor.getData() == node)
				return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object node) {
		if (node instanceof ExecutionGraphNode) {
			ExecutionGraphNode aNode = (ExecutionGraphNode) node;
			return getData().equals(aNode.getData());
		} else {
			return false;
		}
	}
}