package org.modelexecution.fumltesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class PetStoreExample {
	private PetStoreUtil petStoreUtil = new PetStoreUtil();

	@Test
	public void checkCredentialsTest() throws Exception {
		ParameterValueList list = new ParameterValueList();

		ParameterValue parameterValueLogin = petStoreUtil.createParameterValue("CheckCredentials", "login", "login");
		ParameterValue parameterValuePassword = petStoreUtil.createParameterValue("CheckCredentials", "password", "pass1");

		Object_ instance = petStoreUtil.createReference("Customer");
		petStoreUtil.setPropertyValue(instance, "login", "login");
		petStoreUtil.setPropertyValue(instance, "password", "pass1");
		
		ParameterValue parameterValueCustomer = petStoreUtil.createParameterValue("CheckCredentials", "customer", instance);

		list.add(parameterValueLogin);
		list.add(parameterValuePassword);
		list.add(parameterValueCustomer);

		Trace checkCredentialsTrace = petStoreUtil.executeActivity("CheckCredentials", null, list);

		Assert.assertNotNull(checkCredentialsTrace);
		Object value = petStoreUtil.getOutputValue(checkCredentialsTrace, "CheckCredentials", "corresponds");
		Assert.assertEquals(true, value);
	}
}