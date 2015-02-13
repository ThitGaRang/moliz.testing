package org.modelexecution.fumltesting.test.userstudy;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class PetStoreExampleTaskTwo {
	private ExecutionTraceUtil traceUtil = new ExecutionTraceUtil();
	private static final String getCartActivity = "petstore::logic::OrderService::GetCart";

	@Test
	public void getCartNoCartTest() throws Exception {
		Object_ customer = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(customer, "login", "customer");
		traceUtil.setPropertyValue(customer, "password", "pass");

		ParameterValueList list = new ParameterValueList();
		ParameterValue parameterValueCustomer = traceUtil.createParameterValue(getCartActivity, "customer", customer);
		list.add(parameterValueCustomer);

		Trace getCartTrace = traceUtil.executeActivity(getCartActivity, null, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : getCartTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().qualifiedName.equals(getCartActivity)) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			traceUtil.setActivityExecution(mainActivityExecution);

			// checking order of execution
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "getCart"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "listSize"));

			int actionGetCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCart");
			int actionListSizeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "listSize");
			Assert.assertTrue(actionGetCartIndex < actionListSizeIndex);
		} else {
			Assert.fail("Activity execution GetCart not found!");
		}
	}

	@Test
	public void getCartWithCartTest() throws Exception {
	}
}