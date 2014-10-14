/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.uml.execution;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;

import org.dresdenocl.parser.ParseException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumltesting.core.assertions.MatrixOrderAssertionValidator;
import org.modelexecution.fumltesting.core.assertions.OrderAssertionValidator;
import org.modelexecution.fumltesting.core.assertions.StateAssertionValidator;
import org.modelexecution.fumltesting.core.convert.TestConverter;
import org.modelexecution.fumltesting.core.convert.TestDataConverter;
import org.modelexecution.fumltesting.core.exceptions.ActionNotExecutedException;
import org.modelexecution.fumltesting.core.execution.ActivityExecutor;
import org.modelexecution.fumltesting.core.execution.OclExecutor;
import org.modelexecution.fumltesting.core.execution.ResultsWriter;
import org.modelexecution.fumltesting.core.results.AssertionResult;
import org.modelexecution.fumltesting.core.results.StateAssertionResult;
import org.modelexecution.fumltesting.core.results.TestCaseResult;
import org.modelexecution.fumltesting.core.results.TestSuiteResult;
import org.modelexecution.fumltesting.core.testlang.ActivityInput;
import org.modelexecution.fumltesting.core.testlang.Assertion;
import org.modelexecution.fumltesting.core.testlang.FinallyStateAssertion;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.TestCase;
import org.modelexecution.fumltesting.core.trace.TraceUtil;
import org.modelexecution.fumltesting.uml.UmlTestLangStandaloneSetup;
import org.modelexecution.fumltesting.uml.convert.UmlTestConverter;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite;
import org.modelexecution.fumltesting.xtext.UmlSupport;

import com.google.inject.Injector;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
import fUML.Syntax.Activities.ExtraStructuredActivities.ExpansionRegion;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Package;

/**
 * @author Stefan Mijatov
 * 
 */
public class UmlTestExecutor {
	private int mainActivityExecutionID;
	private UMLTestSuite suite;

	private ActivityExecutor executor;
	private OclExecutor oclExecutor;
	private TestDataConverter testDataConverter;
	private TraceUtil traceUtil;

	private OrderAssertionValidator orderAssertionValidator;
	private MatrixOrderAssertionValidator matrixOrderAssertionValidator;
	private StateAssertionValidator stateAssertionValidator;

	private XtextResourceSet resourceSet;
	private Resource testResource;
	private Resource umlResource;
	private NamedElement umlModel;
	private TestConverter testConverter;

	private String testsPath = "";
	private String umlModelPath = "";
	private String oclPath = "";
	private OutputStream output;

	private boolean bruteForceOn;

	public void setModelResource(String modelResource) {
		umlModelPath = modelResource;
	}

	public void setTestSuiteResource(String testSuiteResource) {
		testsPath = testSuiteResource;
	}

	public void setOclResource(String oclResource) {
		oclPath = oclResource;
	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}

	public void setBruteForceOn(boolean bruteForceOn) {
		this.bruteForceOn = bruteForceOn;
	}

	/** Main method of the testing framework. */
	@Test
	public void runTests() {
		File testSuite = new File(testsPath);

		try {
			loadAndSetupAllTestResources();
		} catch (ParseException e) {
			System.out.println("Problem with loading OCL file!");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		testSuiteEvaluation(testSuite);
	}

	private void loadAndSetupAllTestResources() throws Exception {
		executor = new ActivityExecutor();
		testDataConverter = new TestDataConverter();

		new UmlSupport().preInvoke();
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

		Injector injector = new UmlTestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		umlResource = resourceSet.getResource(URI.createURI(umlModelPath), true);
		umlResource.load(null);
		testResource = resourceSet.getResource(URI.createURI(testsPath), true);
		testResource.load(null);

		EcoreUtil.resolveAll(resourceSet);

		for (EObject model : umlResource.getContents()) {
			if (model instanceof Model) {
				umlModel = (NamedElement) model;
				break;
			}
		}

		for (EObject testSuite : testResource.getContents()) {
			if (testSuite instanceof UMLTestSuite) {
				suite = (UMLTestSuite) testSuite;
				break;
			}
		}

		oclExecutor = OclExecutor.getInstance();
		testConverter = new UmlTestConverter(umlModel);

		if (oclExecutor.getMetamodel() != null) {
			System.out.println("Metamodel adaptation: " + oclExecutor.getMetamodel().getName());
			System.out.println("Model adaptation: " + umlModel.getName());

			Package fumlPackage = new Package();
			fumlPackage.name = umlModel.getName();
			fumlPackage.qualifiedName = umlModel.getQualifiedName();

			for (org.eclipse.uml2.uml.Package umlPackage : ((Model) umlModel).getNestedPackages()) {
				Package nestedPackage = testConverter.getModelConverter().convertPackage(umlPackage);
				fumlPackage.addPackagedElement(nestedPackage);
			}
			if (fumlPackage != null) {
				oclExecutor.setModel(fumlPackage);
			}
		}
		if (!oclPath.equals("")) {
			oclExecutor.loadConstraints(URI.createURI(oclPath));
		}
	}

	private void testSuiteEvaluation(File testFile) {
		TestSuiteResult suiteResult = new TestSuiteResult();

		HashMap<String, String> testsThatDidNotRun = new HashMap<String, String>();
		for (UMLTestCase umlTestCase : suite.getTests()) {
			TestCase testCase = testConverter.convertTestCase(umlTestCase);
			Activity activity = testCase.getActivityUnderTest();

			testDataConverter.cleanUpAndInit(testCase);

			boolean requiresContext = false;
			Class_ contextType = null;
			for (ActivityNode node : activity.node) {
				if (node instanceof ReadSelfAction) {
					requiresContext = true;
					contextType = (Class_) ((ReadSelfAction) node).output.get(0).typedElement.type;
					break;
				}
				if (node instanceof ExpansionRegion) {
					ExpansionRegion expansionRegion = (ExpansionRegion) node;
					for (ActivityNode innerNode : expansionRegion.node) {
						if (innerNode instanceof ReadSelfAction) {
							requiresContext = true;
							contextType = (Class_) ((ReadSelfAction) innerNode).output.get(0).typedElement.type;
							break;
						}
					}
				}
			}

			HashMap<ActivityParameterNode, Object> inputValues = new HashMap<ActivityParameterNode, Object>();
			for (ActivityInput input : testCase.getAllInputs()) {
				ActivityParameterNode parameter = input.getParameter();
				Object value = null;
				if (input.getValue() instanceof ObjectValue) {
					value = testDataConverter.convertObject((ObjectValue) input.getValue());
				} else {
					value = testDataConverter.getFumlValue(input.getValue());
				}
				inputValues.put(parameter, value);
			}

			if (testCase.getContextObject() != null) {
				if (contextType != testCase.getContextObject().getType() && requiresContext) {
					testsThatDidNotRun.put(testCase.getName(), "Object of wrong type declared as context! Please use the proper one.");
					continue;
				}
				ObjectValue contextValue = new ObjectValue(null);
				contextValue.setValue(testCase.getContextObject());
				Object_ contextObject = (Object_) testDataConverter.convertObject(contextValue);
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, contextObject);
				ActivityExecution activityExecution = executor.getActivityExecution(mainActivityExecutionID);
				testDataConverter.setActivityExecution(activityExecution);
			} else {
				if (requiresContext) {
					testsThatDidNotRun.put(testCase.getName(), "CONTEXT for activity NOT defined. Please correct the test declaration.");
					continue;
				}
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, null);
				ActivityExecution activityExecution = executor.getActivityExecution(mainActivityExecutionID);
				testDataConverter.setActivityExecution(activityExecution);
			}

			traceUtil = new TraceUtil(mainActivityExecutionID);
			orderAssertionValidator = new OrderAssertionValidator(traceUtil);
			matrixOrderAssertionValidator = new MatrixOrderAssertionValidator(traceUtil);
			stateAssertionValidator = new StateAssertionValidator(traceUtil, testDataConverter);

			TestCaseResult testCaseResult = new TestCaseResult(testCase.getName(), executor.getActivityExecution(mainActivityExecutionID));
			testCaseResult.setActivityContextObject(testCase.getContextObject());

			for (ActivityInput activityInput : testCase.getAllInputs()) {
				org.modelexecution.fumltesting.core.results.ActivityInput activityInputForResult = new org.modelexecution.fumltesting.core.results.ActivityInput(
						activityInput.getParameter(), activityInput.getValue());
				testCaseResult.addActivityInputValue(activityInputForResult);
			}

			for (Assertion assertion : testCase.getAllAssertions()) {
				if (assertion instanceof OrderAssertion) {
					if (bruteForceOn) {
						testCaseResult.addAssertionResult(orderAssertionValidator.checkOrder((OrderAssertion) assertion));
					}
					testCaseResult.addAssertionResult(matrixOrderAssertionValidator.checkOrder((OrderAssertion) assertion));
				} else if (assertion instanceof FinallyStateAssertion) {
					try {
						AssertionResult result = stateAssertionValidator.check((FinallyStateAssertion) assertion);
						testCaseResult.addAssertionResult(result);
					} catch (ActionNotExecutedException e) {
						AssertionResult result = new StateAssertionResult(assertion);
						result.setError(e.getMessage());
						testCaseResult.addAssertionResult(result);
					}
				} else if (assertion instanceof StateAssertion) {
					AssertionResult result = stateAssertionValidator.check((StateAssertion) assertion);
					testCaseResult.addAssertionResult(result);
				}
			}
			suiteResult.addTestCaseResult(testCaseResult);
		}

		ResultsWriter writer = new ResultsWriter(suiteResult, testsThatDidNotRun, output);
		writer.writeResults();

		System.out.println("End of test suite.");
	}
}