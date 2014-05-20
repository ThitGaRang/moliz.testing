/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

/**
 * @author Stefan Mijatov
 * 
 */
public class NodeSpecification {
	private ActivityNode node;
	private int size;
	private NodeOrder subOrder;
	private String joker;

	public ActivityNode getNode() {
		return this.node;
	}

	public void setNode(ActivityNode node) {
		this.node = node;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public NodeOrder getSubOrder() {
		return this.subOrder;
	}

	public void setSubOrder(NodeOrder subOrder) {
		this.subOrder = subOrder;
	}

	public String getJoker() {
		return this.joker;
	}

	public void setJoker(String joker) {
		this.joker = joker;
	}
}