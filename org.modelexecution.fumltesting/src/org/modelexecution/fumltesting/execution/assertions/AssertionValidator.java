package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;

/**
 * Composition class for delegating assertion validation to specific classes.
 * 
 * @author Stefan
 * 
 */
public class AssertionValidator {

	private OrderAssertionValidator orderValidator;
	private StateAssertionValidator stateValidator;
	private TraceUtil traceUtil;

	public AssertionValidator(int activityExecutionID) {
		traceUtil = new TraceUtil(activityExecutionID);
		stateValidator = new StateAssertionValidator(traceUtil);
		orderValidator = new OrderAssertionValidator();
	}

	public boolean check(Assertion assertion) {
		if (assertion instanceof OrderAssertion) {
			String parentNodeName = ((TestCase) assertion.eContainer()).getActivityUnderTest().getName();
			List<NodeSpecification> nodeOrder = ((OrderAssertion) assertion).getOrder().getNodes();
			AssertionPrinter.print(traceUtil.getExecutedNodesList());
			for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
				boolean result = orderValidator.checkOrder(parentNodeName, nodeOrder, path);
				if (result == false) {
					return result;
				}
			}
			return true;
		}
		if (assertion instanceof StateAssertion) {
			return stateValidator.check((StateAssertion) assertion);
		}
		if (assertion instanceof FinallyStateAssertion) {
			return stateValidator.check((FinallyStateAssertion) assertion);
		}
		return false;
	}
}