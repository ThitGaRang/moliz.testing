package org.modelexecution.fumltesting.test.userstudy;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.ExtensionalValueList;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class PetStoreExampleTaskTwo {
	private ExecutionTraceUtil traceUtil = new ExecutionTraceUtil();
	private static final String getCartActivity = "petstore::logic::OrderService::GetCart";

	@Test
	public void getCartNoCartTest() throws Exception {
		System.out.println("Setup time: " + traceUtil.getSetupTime());

		long startTime = System.currentTimeMillis();

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
			Object_ cartFromGetCart = (Object_) traceUtil.getOutputValue("getCart", "result");
			Assert.assertNull(cartFromGetCart);

			// check if activity returns a new cart object
			Object_ cartFromOutput = (Object_) traceUtil.getOutputValue("cart");
			Assert.assertNotNull(cartFromOutput);

		} else {
			Assert.fail("Activity execution GetCart not found!");
		}

		long endTime = System.currentTimeMillis();
		long runningTime = endTime - startTime;
		System.out.println("Get Cart no cart Time: " + runningTime);
	}

	@Test
	public void getCartWithCartTest() throws Exception {
		long startTime = System.currentTimeMillis();

		Object_ customer = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(customer, "login", "customer");
		traceUtil.setPropertyValue(customer, "password", "pass");

		Object_ cart = traceUtil.createInstance("Cart");

		Link cart_customer = traceUtil.createLink("cart_customer");
		traceUtil.setPropertyValue(cart_customer, "customer", customer);
		traceUtil.setPropertyValue(cart_customer, "cart", cart);

		ParameterValueList list = new ParameterValueList();
		ParameterValue parameterValueCustomer = traceUtil.createParameterValue(getCartActivity, "customer", customer);
		list.add(parameterValueCustomer);

		ExtensionalValueList listValues = traceUtil.createExtensionalValueList(customer, cart, cart_customer);

		Trace getCartTrace = traceUtil.executeActivity(getCartActivity, null, list, listValues);
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
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "listSizeValue"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "sizeEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartExistsDecision"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "cartMerge"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "getCartForOutput"));

			int actionGetCartIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCart");
			int actionListSizeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "listSize");
			int actionListSizeValueIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "listSizeValue");
			int actionSizeEqualsIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "sizeEquals");
			int actionCartExistsDecisionIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartExistsDecision");
			int actionCartMergeIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "cartMerge");
			int actionGetCartForOutputIndex = traceUtil.indexOfExecutedNode(mainActivityExecution, "getCartForOutput");

			Assert.assertTrue(actionGetCartIndex < actionListSizeIndex);
			Assert.assertTrue(actionListSizeIndex < actionSizeEqualsIndex);
			Assert.assertTrue(actionListSizeValueIndex < actionSizeEqualsIndex);
			Assert.assertTrue(actionSizeEqualsIndex + 1 == actionCartExistsDecisionIndex);
			Assert.assertTrue(actionCartExistsDecisionIndex + 1 == actionCartMergeIndex);
			Assert.assertTrue(actionCartMergeIndex + 1 == actionGetCartForOutputIndex);

			// check if cart from action getCart is equal to cart provided
			Object_ cartFromGetCart = (Object_) traceUtil.getOutputValue("getCart", "result");
			Assert.assertTrue(cart.equals(cartFromGetCart));

			// check if the customer's cart object is returned by activity
			Object_ cartFromOutput = (Object_) traceUtil.getOutputValue("cart");
			Assert.assertTrue(cart.equals(cartFromOutput));
		}

		long endTime = System.currentTimeMillis();
		long runningTime = endTime - startTime;
		System.out.println("Get Cart with cart Time: " + runningTime);
	}
}