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
public class FinallyStateAssertion extends StateAssertion {
	private ArrayList<Check> checks = new ArrayList<Check>();

	public void addCheck(Check check) {
		check.setContainer(this);
		this.checks.add(check);
	}

	public List<Check> getAllChecks() {
		return Collections.unmodifiableList(this.checks);
	}
}