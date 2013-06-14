package org.modelexecution.fumltesting.execution.assertions;

import org.modelexecution.fumltesting.execution.ActivityExecutor;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.OrderExecutionAssertion;
import org.modelexecution.fumltesting.testLang.StateAssertion;
/**
 * Composition class for delegating assertion validation to specific classes.
 * @author Stefan Mijatov
 *
 */
public class AssertionValidator {
	
	private OrderExecutionAssertionValidator orderValidator = new OrderExecutionAssertionValidator();
	private StateAssertionValidator stateValidator;
	private TraceUtil traceUtil;
	
	public AssertionValidator(int activityExecutionID, ActivityExecutor executor){
		traceUtil = new TraceUtil(activityExecutionID, executor);		
		stateValidator = new StateAssertionValidator(traceUtil, executor.getConversionResult());
	}
	
	public boolean check(Assertion assertion){
		if(assertion instanceof OrderExecutionAssertion)
			return orderValidator.checkOrder((OrderExecutionAssertion)assertion, traceUtil.getExecutedNodesList());
		if(assertion instanceof StateAssertion){
			return stateValidator.check((StateAssertion)assertion);
		}
		return false;
	}
}