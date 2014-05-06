/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.core.assertions;

import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

/**
 * @author Stefan Mijatov
 * 
 */
public class ConvertedNodeSpecification {
	private String joker;
	private ActivityNode node;

	public void setJoker(String joker) {
		this.joker = joker;
	}

	public String getJoker() {
		return joker;
	}

	public void setNode(ActivityNode node) {
		this.node = node;
	}

	public ActivityNode getNode() {
		return node;
	}
}