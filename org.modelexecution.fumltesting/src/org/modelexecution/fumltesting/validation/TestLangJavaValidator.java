/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.validation;

import java.util.HashSet;

import org.eclipse.xtext.validation.Check;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.testLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.testLang.UMLScenario;
import org.modelexecution.fumltesting.testLang.UMLStateAssertion;
import org.modelexecution.fumltesting.testLang.UMLTemporalOperator;
import org.modelexecution.fumltesting.testLang.UMLTestCase;

/**
 * Utility class for validation in TestLang editor.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestLangJavaValidator extends AbstractTestLangJavaValidator {
	@Check
	public void checkAfterSpecified(UMLStateAssertion assertion) {
		if (assertion.getOperator() == UMLTemporalOperator.UNTIL && assertion.getUntilPoint() != null) {
			warning("Subsequent usage of UNTIL is not allowed!", TestLangPackage.Literals.UML_STATE_ASSERTION__UNTIL_POINT);
		}
	}

	@Check
	public void checkUseOfJokers(UMLOrderAssertion assertion) {
		boolean subsequentStarUsed = false;
		for (UMLNodeSpecification nodeSpecification : assertion.getOrder().getNodes()) {
			if (nodeSpecification.getJoker() != null && nodeSpecification.getJoker().equals("*")) {
				int nextNodeIndex = assertion.getOrder().getNodes().indexOf(nodeSpecification) + 1;
				if (assertion.getOrder().getNodes().size() > nextNodeIndex
						&& assertion.getOrder().getNodes().get(nextNodeIndex).getJoker().equals("*"))
					subsequentStarUsed = true;
			}
		}
		if (subsequentStarUsed)
			error("Use of subsequent STAR is not allowed!", TestLangPackage.Literals.UML_ORDER_ASSERTION__ORDER);
	}

	@Check
	public void checkScenarioInitialize(UMLTestCase testCase) {
		HashSet<UMLScenario> set = new HashSet<UMLScenario>(testCase.getInitScenarios());
		if (testCase.getInitScenarios().size() > set.size())
			error("Duplicate scenario declarations!", TestLangPackage.Literals.UML_TEST_CASE__INIT_SCENARIOS);
	}
}