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
public class ConstraintReferencePoint implements ReferencePoint {
	private String constraintName;

	public String getConstraintName() {
		return this.constraintName;
	}

	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
}