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
public class StateAssertion extends Assertion {
	private TemporalQuantifier quantifier;
	private TemporalOperator operator;

	private ReferencePoint referencePoint;
	private ReferencePoint untilPoint;

	private ArrayList<Check> checks = new ArrayList<Check>();

	public TemporalQuantifier getQuantifier() {
		return this.quantifier;
	}

	public void setQuantifier(TemporalQuantifier quantifier) {
		this.quantifier = quantifier;
	}

	public TemporalOperator getOperator() {
		return this.operator;
	}

	public void setOperator(TemporalOperator operator) {
		this.operator = operator;
	}

	public ReferencePoint getReferencePoint() {
		return this.referencePoint;
	}

	public void setReferencePoint(ReferencePoint referencePoint) {
		this.referencePoint = referencePoint;
	}

	public ReferencePoint getUntilPoint() {
		return this.untilPoint;
	}

	public void setUntilPoint(ReferencePoint untilPoint) {
		this.untilPoint = untilPoint;
	}

	public void addCheck(Check check) {
		check.setContainer(this);
		this.checks.add(check);
	}

	public List<Check> getAllChecks() {
		return Collections.unmodifiableList(this.checks);
	}
}