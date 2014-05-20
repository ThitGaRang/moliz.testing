/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

/**
 * @author Stefan Mijatov
 * 
 */
public class OrderAssertion extends Assertion {
	private NodeOrder order;

	public NodeOrder getOrder() {
		return this.order;
	}

	public void setOrder(NodeOrder order) {
		this.order = order;
	}
}