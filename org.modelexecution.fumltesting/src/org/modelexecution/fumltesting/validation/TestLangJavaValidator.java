package org.modelexecution.fumltesting.validation;

import org.eclipse.xtext.validation.Check;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TemporalOperator;

public class TestLangJavaValidator extends AbstractTestLangJavaValidator {
	@Check
	public void checkAfterSpecified(StateAssertion assertion) {
		if (assertion.getTemporalOperator() == TemporalOperator.BEFORE
				&& assertion.getUntilAction() != null) {
			warning("If BEFORE is specified, UNTIL has no effect!", null);
		}
	}

	@Check
	public void checkUseOfJokers(OrderAssertion assertion) {
		boolean subsequentStarUsed = false;
		for (NodeSpecification nodeSpecification : assertion.getOrder()
				.getNodes()) {
			if (nodeSpecification.getJoker() != null
					&& nodeSpecification.getJoker().equals("*")) {
				int nextNodeIndex = assertion.getOrder().getNodes()
						.indexOf(nodeSpecification) + 1;
				if (assertion.getOrder().getNodes().size() > nextNodeIndex
						&& assertion.getOrder().getNodes().get(nextNodeIndex)
								.getJoker().equals("*"))
					subsequentStarUsed = true;
			}
		}
		if (subsequentStarUsed)
			error("Use of subsequent STAR is not allowed!", null);
	}
}