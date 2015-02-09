package org.modelexecution.fumltesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class PetStoreExample {
	private ExecutionTraceUtil traceUtil = new ExecutionTraceUtil();

	@Test
	public void checkCredentialsTest() throws Exception {
		ParameterValueList list = new ParameterValueList();

		ParameterValue parameterValueLogin = traceUtil.createParameterValue("CheckCredentials", "login", "login");
		ParameterValue parameterValuePassword = traceUtil.createParameterValue("CheckCredentials", "password", "pass");

		Object_ instance = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(instance, "login", "login");
		traceUtil.setPropertyValue(instance, "password", "pass");

		ParameterValue parameterValueCustomer = traceUtil.createParameterValue("CheckCredentials", "customer", instance);

		list.add(parameterValueLogin);
		list.add(parameterValuePassword);
		list.add(parameterValueCustomer);

		Trace checkCredentialsTrace = traceUtil.executeActivity("CheckCredentials", null, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : checkCredentialsTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().name.equals("CheckCredentials")) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			// check if the action loginEquals and passwordEquals are executed
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "loginEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordEquals"));

			// check if the true value is returned by the activity
			Boolean corresponds = (Boolean) traceUtil.getOutputValue(mainActivityExecution, "corresponds");
			Assert.assertTrue(corresponds);
		} else {
			Assert.fail("Activity execution CheckCredentials not found!");
		}
	}

	@Test
	public void checkCredentialsIncorrectTest() throws Exception {
		ParameterValueList list = new ParameterValueList();

		ParameterValue parameterValueLogin = traceUtil.createParameterValue("CheckCredentials", "login", "login");
		ParameterValue parameterValuePassword = traceUtil.createParameterValue("CheckCredentials", "password", "passIncorrect");

		Object_ instance = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(instance, "login", "login");
		traceUtil.setPropertyValue(instance, "password", "pass");

		ParameterValue parameterValueCustomer = traceUtil.createParameterValue("CheckCredentials", "customer", instance);

		list.add(parameterValueLogin);
		list.add(parameterValuePassword);
		list.add(parameterValueCustomer);

		Trace checkCredentialsTrace = traceUtil.executeActivity("CheckCredentials", null, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : checkCredentialsTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().name.equals("CheckCredentials")) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			// check if the action passwordEquals and passwordFalse are executed
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordFalse"));

			// check if the false value is returned by the activity
			Boolean corresponds = (Boolean) traceUtil.getOutputValue(mainActivityExecution, "corresponds");
			Assert.assertFalse(corresponds);
		} else {
			Assert.fail("Activity execution CheckCredentials not found!");
		}
	}

	@Test
	public void confirmOrderTest() {
		Object_ orderService = traceUtil.createInstance("OrderService");
		
		Object_ productOne = traceUtil.createInstance("Product");
		traceUtil.setPropertyValue(productOne, "name", "productOne");
		
		Object_ productTwo = traceUtil.createInstance("Product");
		traceUtil.setPropertyValue(productTwo, "name", "productTwo");
		
		Object_ itemOne = traceUtil.createInstance("Item");
		traceUtil.setPropertyValue(itemOne, "unitCost", 10);
		
		Object_ itemTwo = traceUtil.createInstance("Item");
		traceUtil.setPropertyValue(itemTwo, "unitCost", 20);
	}
}