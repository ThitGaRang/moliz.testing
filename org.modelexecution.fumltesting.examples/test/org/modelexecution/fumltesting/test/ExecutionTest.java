/*
 * Copyright (c) 2013 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Tanja Mayerhofer - initial API and implementation
 */
package org.modelexecution.fumltesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.papyrus.PapyrusModelExecutor;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.Classes.Kernel.ValueList;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Classes.Kernel.Classifier;

public class ExecutionTest {

	@Test
	public void testBankingExampleCorrectScenario1() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/banking_correct/banking.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("scenario1", null, null);
		Assert.assertEquals(4, trace.getActivityExecutions().size());
		Assert.assertEquals("scenario1", trace.getActivityExecutions().get(0).getActivity().name);
		ParameterValueList output = executor.getExecutionContext().getActivityOutput(trace.getActivityExecutions().get(0).getActivityExecutionID());
		Assert.assertEquals(1, output.size());
		Assert.assertEquals(1, output.get(0).values.size());
		Assert.assertTrue(((BooleanValue)output.get(0).values.get(0)).value);
		Object_ accountObject = getObject(trace, "Account");
		Assert.assertNotNull(accountObject);
		ValueList accountBalanceValues = getAccountBalance(accountObject, "balance");
		Assert.assertEquals(1, accountBalanceValues.size());
		Assert.assertEquals(500, ((IntegerValue)accountBalanceValues.get(0)).value);
	}
	
	@Test
	public void testBankingExampleCorrectScenario2() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/banking_correct/banking.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("scenario2", null, null);
		Assert.assertEquals(4, trace.getActivityExecutions().size());
		Assert.assertEquals("scenario2", trace.getActivityExecutions().get(0).getActivity().name);
		ParameterValueList output = executor.getExecutionContext().getActivityOutput(trace.getActivityExecutions().get(0).getActivityExecutionID());
		Assert.assertEquals(1, output.size());
		Assert.assertEquals(1, output.get(0).values.size());
		Assert.assertFalse(((BooleanValue)output.get(0).values.get(0)).value);
		Object_ accountObject = getObject(trace, "Account");
		Assert.assertNotNull(accountObject);
		ValueList accountBalanceValues = getAccountBalance(accountObject, "balance");
		Assert.assertEquals(1, accountBalanceValues.size());
		Assert.assertEquals(300, ((IntegerValue)accountBalanceValues.get(0)).value);		
	}
	
	@Test
	public void testBankingExampleIncorrectScenario1() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/banking_incorrect/banking.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("scenario1", null, null);
		Assert.assertEquals(4, trace.getActivityExecutions().size());
		Assert.assertEquals("scenario1", trace.getActivityExecutions().get(0).getActivity().name);
		ParameterValueList output = executor.getExecutionContext().getActivityOutput(trace.getActivityExecutions().get(0).getActivityExecutionID());
		Assert.assertEquals(1, output.size());
		Assert.assertEquals(1, output.get(0).values.size());
		Assert.assertTrue(((BooleanValue)output.get(0).values.get(0)).value);
		Object_ accountObject = getObject(trace, "Account");
		Assert.assertNotNull(accountObject);
		ValueList accountBalanceValues = getAccountBalance(accountObject, "balance");
		Assert.assertEquals(1, accountBalanceValues.size());
		// error (argument order of subtract method wrong):
		Assert.assertEquals(-500, ((IntegerValue)accountBalanceValues.get(0)).value);
	}
	
	@Test
	public void testBankingExampleIncorrectScenario2() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/banking_incorrect/banking.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("scenario2", null, null);
		Assert.assertEquals(3, trace.getActivityExecutions().size());
		Assert.assertEquals("scenario2", trace.getActivityExecutions().get(0).getActivity().name);
		ParameterValueList output = executor.getExecutionContext().getActivityOutput(trace.getActivityExecutions().get(0).getActivityExecutionID());		
		Assert.assertEquals(1, output.size());
		// error (no output provided because pin was invalid):
		Assert.assertEquals(0, output.get(0).values.size());
		Object_ accountObject = getObject(trace, "Account");
		Assert.assertNotNull(accountObject);
		ValueList accountBalanceValues = getAccountBalance(accountObject, "balance");
		Assert.assertEquals(1, accountBalanceValues.size());
		Assert.assertEquals(800, ((IntegerValue)accountBalanceValues.get(0)).value);		
	}

	@Test
	public void testBankingExampleIncorrectScenario3() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/banking_incorrect/banking.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("scenario3", null, null);
		Assert.assertEquals(4, trace.getActivityExecutions().size());
		Assert.assertEquals("scenario3", trace.getActivityExecutions().get(0).getActivity().name);
		ParameterValueList output = executor.getExecutionContext().getActivityOutput(trace.getActivityExecutions().get(0).getActivityExecutionID());
		Assert.assertEquals(1, output.size());
		// error (no output provided because balance == amount):
		Assert.assertEquals(0, output.get(0).values.size());
		Object_ accountObject = getObject(trace, "Account");
		Assert.assertNotNull(accountObject);
		ValueList accountBalanceValues = getAccountBalance(accountObject, "balance");
		Assert.assertEquals(1, accountBalanceValues.size());
		// error (balance was not reduced):
		Assert.assertEquals(800, ((IntegerValue)accountBalanceValues.get(0)).value);
	}
	
	@Test
	public void testTwoCardsActivityStepwise() {
		PapyrusModelExecutor executor = new PapyrusModelExecutor("model/interpreter_observation/interpreter_observation.di");
		clearLocus(executor);
		Trace trace = executor.executeActivity("TwoCardsActivity", null, null);
		Assert.assertEquals(3, trace.getActivityExecutions().size());
		Assert.assertEquals("TwoCardsActivity", trace.getActivityExecutions().get(0).getActivity().name);
		Assert.assertEquals("CardAccountActivity", trace.getActivityExecutions().get(1).getActivity().name);
		Assert.assertEquals("CardAccountActivity", trace.getActivityExecutions().get(2).getActivity().name);
	}
	
	private void clearLocus(PapyrusModelExecutor executor) {
		executor.getExecutionContext().getLocus().extensionalValues.clear();
	}
	
	private ValueList getAccountBalance(Object_ object, String featurename) {
		for(FeatureValue fv : object.featureValues) {
			if(fv.feature.name.equals(featurename)) {
				return fv.values;
			}
		}
		return null;
	}

	private Object_ getObject(Trace trace, String classifiername) {
		for(ValueInstance valueInstance : trace.getValueInstances()) {
			Value value = valueInstance.getRuntimeValue();
			if(value instanceof Object_) {
				Object_ object_ = (Object_) value;
				for(Classifier c : object_.getTypes()) {
					if(c.name.equals(classifiername)) {
						return object_;
					}
				}
			}
		}
		return null;
	}
}
