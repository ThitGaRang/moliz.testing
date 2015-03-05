package org.modelexecution.fumltesting.test.userstudy;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class PetStoreExampleTaskOne {
	private ExecutionTraceUtil traceUtil = new ExecutionTraceUtil();
	private static final String checkCredentialsActivity = "petstore::logic::CustomerService::CheckCredentials";
	private static final String confirmOrderActivity = "petstore::logic::OrderService::ConfirmOrder";

	// @Test
	public void checkCredentialsTest() throws Exception {
		ParameterValueList list = new ParameterValueList();

		ParameterValue parameterValueLogin = traceUtil.createParameterValue(checkCredentialsActivity, "login", "login");
		ParameterValue parameterValuePassword = traceUtil.createParameterValue(checkCredentialsActivity, "password", "pass");

		Object_ instance = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(instance, "login", "login");
		traceUtil.setPropertyValue(instance, "password", "pass");

		ParameterValue parameterValueCustomer = traceUtil.createParameterValue(checkCredentialsActivity, "customer", instance);

		list.add(parameterValueLogin);
		list.add(parameterValuePassword);
		list.add(parameterValueCustomer);

		Trace checkCredentialsTrace = traceUtil.executeActivity(checkCredentialsActivity, null, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : checkCredentialsTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().qualifiedName.equals(checkCredentialsActivity)) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			traceUtil.setActivityExecution(mainActivityExecution);

			// check if the action loginEquals and passwordEquals are executed
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "loginEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordEquals"));

			// check if the true value is returned by the activity
			Boolean corresponds = (Boolean) traceUtil.getOutputValue("corresponds");
			Assert.assertTrue(corresponds);
		} else {
			Assert.fail("Activity execution CheckCredentials not found!");
		}
	}

	// @Test
	public void checkCredentialsIncorrectTest() throws Exception {
		ParameterValueList list = new ParameterValueList();

		ParameterValue parameterValueLogin = traceUtil.createParameterValue(checkCredentialsActivity, "login", "login");
		ParameterValue parameterValuePassword = traceUtil.createParameterValue(checkCredentialsActivity, "password", "passIncorrect");

		Object_ instance = traceUtil.createInstance("Customer");
		traceUtil.setPropertyValue(instance, "login", "login");
		traceUtil.setPropertyValue(instance, "password", "pass");

		ParameterValue parameterValueCustomer = traceUtil.createParameterValue(checkCredentialsActivity, "customer", instance);

		list.add(parameterValueLogin);
		list.add(parameterValuePassword);
		list.add(parameterValueCustomer);

		Trace checkCredentialsTrace = traceUtil.executeActivity(checkCredentialsActivity, null, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : checkCredentialsTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().qualifiedName.equals(checkCredentialsActivity)) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			traceUtil.setActivityExecution(mainActivityExecution);

			// check if the action passwordEquals and passwordFalse are executed
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordEquals"));
			Assert.assertTrue(traceUtil.activityNodeExecuted(mainActivityExecution, "passwordFalse"));

			// check if the false value is returned by the activity
			Boolean corresponds = (Boolean) traceUtil.getOutputValue("corresponds");
			Assert.assertFalse(corresponds);
		} else {
			Assert.fail("Activity execution CheckCredentials not found!");
		}
	}

	@Test
	public void confirmOrderTest() throws Exception {
		// creating the scenario
		Object_ orderService = traceUtil.createInstance("OrderService");

		Object_ productOne = traceUtil.createInstance("Product");
		traceUtil.setPropertyValue(productOne, "name", "productOne");

		Object_ productTwo = traceUtil.createInstance("Product");
		traceUtil.setPropertyValue(productTwo, "name", "productTwo");

		Object_ itemOne = traceUtil.createInstance("Item");
		traceUtil.setPropertyValue(itemOne, "unitCost", 10);

		Object_ itemTwo = traceUtil.createInstance("Item");
		traceUtil.setPropertyValue(itemTwo, "unitCost", 20);

		Link itemProductOne = traceUtil.createLink("product_item");
		traceUtil.setPropertyValue(itemProductOne, "item", itemOne);
		traceUtil.setPropertyValue(itemProductOne, "product", productOne);
		traceUtil.addToLocus(itemProductOne);

		Link itemProductTwo = traceUtil.createLink("product_item");
		traceUtil.setPropertyValue(itemProductTwo, "item", itemTwo);
		traceUtil.setPropertyValue(itemProductTwo, "product", productTwo);
		traceUtil.addToLocus(itemProductTwo);

		Object_ cartItemOne = traceUtil.createInstance("CartItem");
		traceUtil.setPropertyValue(cartItemOne, "quantity", 5);

		Object_ cartItemTwo = traceUtil.createInstance("CartItem");
		traceUtil.setPropertyValue(cartItemTwo, "quantity", 8);

		Link cartItemItemOne = traceUtil.createLink("cartItem_item");
		traceUtil.setPropertyValue(cartItemItemOne, "cartItem", cartItemOne);
		traceUtil.setPropertyValue(cartItemItemOne, "item", itemOne);
		traceUtil.addToLocus(cartItemItemOne);

		Link cartItemItemTwo = traceUtil.createLink("cartItem_item");
		traceUtil.setPropertyValue(cartItemItemTwo, "cartItem", cartItemTwo);
		traceUtil.setPropertyValue(cartItemItemTwo, "item", itemTwo);
		traceUtil.addToLocus(cartItemItemTwo);

		Object_ cart = traceUtil.createInstance("Cart");

		Link cartCartItemOne = traceUtil.createLink("cart_cartItem");
		traceUtil.setPropertyValue(cartCartItemOne, "cart", cart);
		traceUtil.setPropertyValue(cartCartItemOne, "cartItems", cartItemOne);
		traceUtil.addToLocus(cartCartItemOne);

		Link cartCartItemTwo = traceUtil.createLink("cart_cartItem");
		traceUtil.setPropertyValue(cartCartItemTwo, "cart", cart);
		traceUtil.setPropertyValue(cartCartItemTwo, "cartItems", cartItemTwo);
		traceUtil.addToLocus(cartCartItemTwo);

		Object_ customer = traceUtil.createInstance("Customer");

		Link cartCustomer = traceUtil.createLink("cart_customer");
		traceUtil.setPropertyValue(cartCustomer, "customer", customer);
		traceUtil.setPropertyValue(cartCustomer, "cart", cart);
		traceUtil.addToLocus(cartCustomer);

		ParameterValueList list = new ParameterValueList();
		ParameterValue parameterValueCustomer = traceUtil.createParameterValue(confirmOrderActivity, "customer", customer);
		list.add(parameterValueCustomer);

		Trace confirmOrderTrace = traceUtil.executeActivity(confirmOrderActivity, orderService, list);
		ActivityExecution mainActivityExecution = null;
		for (ActivityExecution activityExecution : confirmOrderTrace.getActivityExecutions()) {
			if (activityExecution.getActivity().qualifiedName.equals(confirmOrderActivity)) {
				mainActivityExecution = activityExecution;
				break;
			}
		}

		if (mainActivityExecution != null) {
			traceUtil.setActivityExecution(mainActivityExecution);

			// check if order instance contains provided customer
			Object_ order = (Object_) traceUtil.getOutputValue("order");
			Object_ customerFromOrder = traceUtil.getLinkedObject(order, "order_customer");
			Assert.assertEquals(customer, customerFromOrder);

			// check if cart has been removed from customer
			Object_ cartFromCustomer = traceUtil.getLinkedObject(customerFromOrder, "cart_customer");
			Assert.assertNull(cartFromCustomer);

			// check if number of orderLines is equal to number of cartItems
			List<Object_> orderLines = traceUtil.getLinkedObjects(order, "order_orderLine");
			Assert.assertEquals(2, orderLines.size());
		} else {
			Assert.fail("Activity execution ConfirmOrder not found!");
		}
	}
}