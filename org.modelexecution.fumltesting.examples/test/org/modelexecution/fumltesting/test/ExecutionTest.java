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

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.ExecutionEventListener;
import org.modelexecution.fumldebug.core.event.ActivityEntryEvent;
import org.modelexecution.fumldebug.core.event.ActivityExitEvent;
import org.modelexecution.fumldebug.core.event.Event;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
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
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Classifier;

public class ExecutionTest implements ExecutionEventListener {
	
	/** Result obtained from converting UML to fUML model. */
	private IConversionResult convertedModel;
	private ResourceSet resourceSet;
	private Resource resource;
	private NamedElement model;
	private int mainActivityID;
	
	private boolean running = false;
	
	private void setup() {
		try{
			resourceSet = new ResourceSetImpl();
			resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
			//model with UML elements under test, referenced by testing model
			resource = resourceSet.getResource(URI.createFileURI(new File("model/petstore/petstore.uml").getAbsolutePath()), true);
			resource.load(null);
			
			for (EObject model : resource.getContents()) {
				if (model instanceof NamedElement){
					this.model = (NamedElement)model;
				}
			}
			ExecutionContext.getInstance().addEventListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModelConversion(){
		setup();
		IConverter converter = ConverterRegistry.getInstance().getConverter(model);
		convertedModel = converter.convert(model);
		for(PackageableElement package_: ((Model)model).getPackagedElements()){
			if(package_ instanceof Package){
				for (Element element : package_.getOwnedElements()) {
					if (element instanceof Class) {
						Class class_ = (Class) element;
						System.out.println("Class: " + class_.getQualifiedName());						
						for (Property property : class_.getAllAttributes()) {
							System.out.print(property.getName());
							System.out.print(" " + property.getType().getName());
							System.out.print(" (" + property.getLower());
							System.out.println(", " + property.getUpper() + ");");
						}
						System.out.println("\nConverted analog in FUML reference: ");
						Class_ convertedClass = (Class_) convertedModel.getFUMLElement(class_);
						System.out.println("Class: " + convertedClass.qualifiedName);						
						for (fUML.Syntax.Classes.Kernel.Property property : convertedClass.attribute) {
							System.out.print(property.name);
							System.out.print(" " + property.typedElement.name);
							System.out.print(" (" + property.multiplicityElement.lower);
							System.out.println(", " + property.multiplicityElement.upper.naturalValue + ");");
						}
					}
					System.out.println("**************************************************");
				}
			}
		}
	}
	
	//@Test
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
	
	//@Test
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
	
	//@Test
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
	
	//@Test
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

	//@Test
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
	
	//@Test
	public void testTwoCardsActivityStepwise() {
		setup();
		IConverter converter = ConverterRegistry.getInstance().getConverter(model);
		convertedModel = converter.convert(model);
		Activity fumlActivity = convertedModel.getActivity("TwoCardsActivity");
		
		ExecutionContext.getInstance().executeStepwise(fumlActivity, null, null);
		while(running) {
			ExecutionContext.getInstance().nextStep(mainActivityID);
		}
		Trace trace = ExecutionContext.getInstance().getTrace(mainActivityID);
		ActivityExecution activityExecution = trace.getActivityExecutions().get(0);			
		
		Assert.assertEquals(3, trace.getActivityExecutions().size());
		Assert.assertEquals("TwoCardsActivity", activityExecution.getActivity().name);
		Assert.assertEquals(6, activityExecution.getNodeExecutions().size());
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
	
	@Override
	public void notify(Event event) {
		if(event instanceof ActivityEntryEvent && (((ActivityEntryEvent)event).getParent() == null)){
			mainActivityID = ((ActivityEntryEvent)event).getActivityExecutionID();
			running = true;
		}
		if(event instanceof ActivityExitEvent && (((ActivityExitEvent)event).getActivityExecutionID() == mainActivityID)){
			running = false;			
		}
	}
}
