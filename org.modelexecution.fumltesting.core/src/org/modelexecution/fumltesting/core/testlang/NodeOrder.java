/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stefan Mijatov
 * 
 */
public class NodeOrder {
	private ArrayList<NodeSpecification> nodes = new ArrayList<NodeSpecification>();

	public void addNode(NodeSpecification nodeSpecification) {
		this.nodes.add(nodeSpecification);
	}

	public List<NodeSpecification> getAllNodes() {
		return Collections.unmodifiableList(this.nodes);
	}
}