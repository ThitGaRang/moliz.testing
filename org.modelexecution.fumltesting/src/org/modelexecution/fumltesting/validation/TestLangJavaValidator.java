/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.validation;

import java.util.HashSet;

import org.eclipse.xtext.validation.Check;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * Utility class for validation in TestLang editor.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestLangJavaValidator extends AbstractTestLangJavaValidator {
	@Check
	public void checkAfterSpecified(StateAssertion assertion) {
		if (assertion.getOperator() == TemporalOperator.BEFORE && assertion.getUntilPoint() != null) {
			warning("If BEFORE is specified, UNTIL has no effect!", null);
		}
	}

	@Check
	public void checkUseOfJokers(OrderAssertion assertion) {
		boolean subsequentStarUsed = false;
		for (NodeSpecification nodeSpecification : assertion.getOrder().getNodes()) {
			if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("*")) {
				int nextNodeIndex = assertion.getOrder().getNodes().indexOf(nodeSpecification) + 1;
				if (assertion.getOrder().getNodes().size() > nextNodeIndex
						&& assertion.getOrder().getNodes().get(nextNodeIndex).getJoker().equals("*"))
					subsequentStarUsed = true;
			}
		}
		if (subsequentStarUsed)
			error("Use of subsequent STAR is not allowed!", TestLangPackage.Literals.ORDER_ASSERTION__ORDER);
	}

	@Check
	public void checkScenarioInitialize(TestCase testCase) {
		HashSet<Scenario> set = new HashSet<Scenario>(testCase.getInitScenarios());
		if (testCase.getInitScenarios().size() > set.size())
			error("Duplicate scenario declarations!", TestLangPackage.Literals.TEST_CASE__INIT_SCENARIOS);
	}
}