/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.exceptions;

/**
 * @author Stefan Mijatov
 * 
 */
public class ConstraintStateNotFoundException extends Exception {
	private static final long serialVersionUID = -6861956594127110024L;

	public ConstraintStateNotFoundException(String message) {
		super(message);
	}
}