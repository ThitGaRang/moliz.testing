package org.modelexecution.fumltesting.test.userstudy;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.Link;
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
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "sizeEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartExistsDecision"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "newCart"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "setCart"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartMerge"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "getCartForOutput"));

			int actionGetCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCart");
			int actionListSizeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "listSize");
			int actionSizeEqualsIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "sizeEquals");
			int actionCartExistsDecisionIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartExistsDecision");
			int actionNewCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "newCart");
			int actionSetCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "setCart");
			int actionCartMergeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartMerge");
			int actionGetCartForOutputIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCartForOutput");

			Assert.assertTrue(actionGetCartIndex < actionListSizeIndex);
			Assert.assertTrue(actionListSizeIndex < actionSizeEqualsIndex);
			Assert.assertTrue(actionSizeEqualsIndex + 1 == actionCartExistsDecisionIndex);
			Assert.assertTrue(actionCartExistsDecisionIndex + 1 == actionNewCartIndex);
			Assert.assertTrue(actionNewCartIndex + 1 == actionSetCartIndex);
			Assert.assertTrue(actionSetCartIndex + 1 == actionCartMergeIndex);
			Assert.assertTrue(actionCartMergeIndex + 1 == actionGetCartForOutputIndex);

			// check if action getCart returns null
			Assert.assertNull(traceUtil.getOutputValue("getCart", "result"));

			// check if activity returns a new cart object
			Assert.assertNotNull(traceUtil.getOutputValue("cart"));

		} else {
			Assert.fail("Activity execution GetCart not found!");
		}
	}

	@Test
	public void getCartWithCartTest() throws Exception {
		Object_ customer = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(customer, "login", "customer");
		traceUtil.setPropertyValue(customer, "password", "pass");

		Object_ cart = traceUtil.createInstance("Cart");

		Link cart_customer = traceUtil.createLink("cart_customer");
		traceUtil.setPropertyValue(cart_customer, "customer", customer);
		traceUtil.setPropertyValue(cart_customer, "cart", cart);
		traceUtil.addToLocus(cart_customer);

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
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "sizeEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartExistsDecision"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartMerge"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "getCartForOutput"));

			int actionGetCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCart");
			int actionListSizeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "listSize");
			int actionSizeEqualsIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "sizeEquals");
			int actionCartExistsDecisionIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartExistsDecision");
			int actionCartMergeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartMerge");
			int actionGetCartForOutputIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCartForOutput");

			Assert.assertTrue(actionGetCartIndex < actionListSizeIndex);
			Assert.assertTrue(actionListSizeIndex < actionSizeEqualsIndex);
			Assert.assertTrue(actionSizeEqualsIndex + 1 == actionCartExistsDecisionIndex);
			Assert.assertTrue(actionCartExistsDecisionIndex + 1 == actionCartMergeIndex);
			Assert.assertTrue(actionCartMergeIndex + 1 == actionGetCartForOutputIndex);

			// check if action getCart returns cart of the provided customer
			Assert.assertNotNull(traceUtil.getOutputValue("getCart", "result"));

			// check if the customer's cart object is returned by activity
			Object_ cartFromOutput = (Object_) traceUtil.getOutputValue("cart");
			Assert.assertTrue(cart == cartFromOutput);

		}
	}
}