package org.modelexecution.fumltesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Parameter;
import fUML.Syntax.Classes.Kernel.ParameterList;

public class PetStoreExample {
	private PetStoreUtil petStoreUtil = new PetStoreUtil();

	@Test
	public void findAllItemsTest() throws Exception{
		ParameterValueList list = new ParameterValueList();
		ParameterValue parameterValueLogin = petStoreUtil.getParameterValue("CehckCredentials", "login", "customerOne");
		ParameterValue parameterValuePassword = petStoreUtil.getParameterValue("CehckCredentials", "password", "pass1");
		
		Trace findAllItemsTrace = petStoreUtil.executeActivity("CheckCredentials", null, null);
		Assert.assertNotNull(findAllItemsTrace);
	}
}