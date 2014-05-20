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
public enum ArithmeticOperator {
	EQUAL, NOT_EQUAL, SMALLER, SMALLER_EQUAL, GREATER, GREATER_EQUAL, INCLUDES, EXCLUDES;

	@Override
	public String toString() {
		switch (this) {
		case EQUAL:
			return "=";
		case EXCLUDES:
			return "excludes";
		case GREATER:
			return ">";
		case GREATER_EQUAL:
			return ">=";
		case INCLUDES:
			return "includes";
		case NOT_EQUAL:
			return "!=";
		case SMALLER:
			return "<";
		case SMALLER_EQUAL:
			return "<";
		}
		return null;
	}
}