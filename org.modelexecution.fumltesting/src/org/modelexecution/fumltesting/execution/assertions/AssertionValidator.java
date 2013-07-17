package org.modelexecution.fumltesting.execution.assertions;

import java.util.List;

import org.modelexecution.fumltesting.execution.ActivityExecutor;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;
/**
 * Composition class for delegating assertion validation to specific classes.
 * @author Stefan Mijatov
 *
 */
public class AssertionValidator {
	
	private OrderExecutionAssertionValidator orderValidator;
	private StateAssertionValidator stateValidator;
	private TraceUtil traceUtil;
	
	public AssertionValidator(int activityExecutionID, ActivityExecutor executor){
		traceUtil = new TraceUtil(activityExecutionID, executor);		
		stateValidator = new StateAssertionValidator(traceUtil);
		orderValidator =  new OrderExecutionAssertionValidator();
	}
	
	public boolean check(Assertion assertion){
		if(assertion instanceof OrderAssertion){
			String parentNodeName = ((TestCase)assertion.eContainer()).getActivityUnderTest().getName();
			List<NodeSpecification> nodeOrder = ((OrderAssertion)assertion).getOrder().getNodes();
			AssertionPrinter.print(traceUtil.getExecutedNodesList());
			return orderValidator.checkOrder(parentNodeName, nodeOrder, traceUtil.getExecutedNodesList());
		}
		if(assertion instanceof StateAssertion){
			return stateValidator.check((StateAssertion)assertion);
		}
		return false;
	}
}