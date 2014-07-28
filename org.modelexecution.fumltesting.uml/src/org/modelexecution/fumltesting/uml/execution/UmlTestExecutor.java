/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.uml.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.dresdenocl.parser.ParseException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;
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
import org.modelexecution.fumltesting.core.testlang.TestSuite;
import org.modelexecution.fumltesting.core.trace.TraceUtil;
import org.modelexecution.fumltesting.uml.UmlTestLangStandaloneSetup;
import org.modelexecution.fumltesting.uml.convert.UmlTestConverter;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite;
import org.modelexecution.fumltesting.xtext.UmlSupport;

import com.google.inject.Injector;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
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
	private TestSuite convertedSuite;

	private ActivityExecutor executor;
	private OclExecutor oclExecutor;
	private TestDataConverter testDataConverter;
	private TraceUtil traceUtil;

	private OrderAssertionValidator orderAssertionValidator;
	private StateAssertionValidator stateAssertionValidator;

	private XtextResourceSet resourceSet;
	private Resource testResource;
	private Resource umlResource;
	private Resource primitiviesResource;
	private NamedElement umlModel;
	private TestConverter testConverter;

	// banking_new:banking, webstore:webstore
	private String modelFolder = "banking_new";
	private String modelName = "banking";
	
	private String testsPath = "../org.modelexecution.fumltesting.examples/model/" + modelFolder + "/tests";
	private String umlModelPath = "../org.modelexecution.fumltesting.examples/model/" + modelFolder + "/" + modelName + ".uml";
	private String primitivesPath = "../../moliz/org.modelexecution.fumldebug.standardlibrary/library/uml_library.uml";
	private String oclPath = "../org.modelexecution.fumltesting.examples/model/" + modelFolder + "/" + modelName + ".ocl";

	private String testEndsWithFilter = ".umltest";

	/** Main method of the testing framework. */
	@Test
	public void runTests() {
		File folder = new File(testsPath);
		File[] files = folder.listFiles();
		for (File testFile : files) {
			if (testFile.isFile() && testFile.getName().endsWith(testEndsWithFilter)) {
				try {
					loadAndSetupAllTestResources(testFile);
				} catch (ParseException e) {
					System.out.println("Problem with loading OCL file!");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
				testSuiteEvaluation(testFile);
			}
		}
	}

	private void loadAndSetupAllTestResources(File testFile) throws Exception {
		executor = new ActivityExecutor();
		testDataConverter = new TestDataConverter();

		String testLocation = testsPath + "/" + testFile.getName();

		new UmlSupport().registerServices(true);
		Injector injector = new UmlTestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		testResource = resourceSet.getResource(URI.createFileURI(new File(testLocation).getAbsolutePath()), true);
		testResource.load(null);

		if (testResource != null) {
			resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

			primitiviesResource = resourceSet.getResource(URI.createFileURI(new File(primitivesPath).getAbsolutePath()), true);
			primitiviesResource.load(null);

			umlResource = resourceSet.getResource(URI.createFileURI(new File(umlModelPath).getAbsolutePath()), true);
			umlResource.load(null);

			umlResource.getContents().addAll(primitiviesResource.getContents());
			testResource.getContents().addAll(umlResource.getContents());

			EcoreUtil.resolveAll(resourceSet);

			for (EObject model : testResource.getContents()) {
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
		}

		oclExecutor = OclExecutor.getInstance();
		testConverter = new UmlTestConverter(umlModel);

		convertedSuite = testConverter.convertSuite(suite);

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
		oclExecutor.loadConstraints(new File(oclPath));
	}

	private void testSuiteEvaluation(File testFile) {
		TestSuiteResult suiteResult = new TestSuiteResult();
		SimpleDateFormat currentTime = new SimpleDateFormat("dd.MM.yy_HH.mm.ss");
		String testFileNameWithoutExtension = testFile.getName().replace(".fumltest", "");
		String testResultsFile = "results/testresults_" + testFileNameWithoutExtension + "_" + currentTime.format(new Date()) + ".txt";
		HashMap<String, String> testsThatDidNotRun = new HashMap<String, String>();
		for (TestCase testCase : convertedSuite.getAllTestCases()) {
			Activity activity = testCase.getActivityUnderTest();

			testDataConverter.cleanUpAndInit(convertedSuite);

			boolean requiresContext = false;
			Class_ contextType = null;
			for (ActivityNode node : activity.node) {
				if (node instanceof ReadSelfAction) {
					requiresContext = true;
					contextType = (Class_) ((ReadSelfAction) node).output.get(0).typedElement.type;
					break;
				}
			}

			HashMap<ActivityParameterNode, Object> inputValues = new HashMap<ActivityParameterNode, Object>();
			for (ActivityInput input : testCase.getAllInputs()) {
				ActivityParameterNode parameter = input.getParameter();
				Object value = null;
				if (input.getValue() instanceof ObjectValue) {
					value = testDataConverter.getFumlObject((ObjectValue) input.getValue());
				} else {
					value = testDataConverter.getFumlValue(input.getValue());
				}
				inputValues.put(parameter, value);
			}

			if (testCase.getContextObject() != null) {
				if (contextType != testCase.getContextObject().getType()) {
					testsThatDidNotRun.put(testCase.getName(), "Object of wrong type declared as context! Please use the proper one.");
					continue;
				}
				ObjectValue contextValue = new ObjectValue(null);
				contextValue.setValue(testCase.getContextObject());
				Object_ contextObject = (Object_) testDataConverter.getFumlObject(contextValue);
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, contextObject);
			} else {
				if (requiresContext) {
					testsThatDidNotRun.put(testCase.getName(), "CONTEXT for activity NOT defined. Please correct the test declaration.");
					continue;
				}
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, null);
			}

			traceUtil = new TraceUtil(mainActivityExecutionID);
			orderAssertionValidator = new OrderAssertionValidator(traceUtil);
			stateAssertionValidator = new StateAssertionValidator(traceUtil, testDataConverter);

			TestCaseResult testCaseResult = new TestCaseResult(testCase.getName(), executor.getActivityExecution(mainActivityExecutionID));
			testCaseResult.setActivityContextObject(testCase.getContextObject());

			for (ActivityInput activityInput : testCase.getAllInputs()) {
				org.modelexecution.fumltesting.core.results.ActivityInput activityInputForResult = new org.modelexecution.fumltesting.core.results.ActivityInput(
						activityInput.getParameter(), activityInput.getValue());
				testCaseResult.addActivityInputValue(activityInputForResult);
			}

			for (Assertion assertion : testCase.getAllAssertions()) {
				AssertionResult result = null;
				if (assertion instanceof OrderAssertion) {
					result = orderAssertionValidator.checkOrder((OrderAssertion) assertion);
				} else if (assertion instanceof FinallyStateAssertion) {
					try {
						result = stateAssertionValidator.check((FinallyStateAssertion) assertion);
					} catch (ActionNotExecutedException e) {
						result = new StateAssertionResult(assertion);
						result.setError(e.getMessage());
					}
				} else if (assertion instanceof StateAssertion) {
					result = stateAssertionValidator.check((StateAssertion) assertion);
				}
				testCaseResult.addAssertionResult(result);
			}
			suiteResult.addTestCaseResult(testCaseResult);
		}

		try {
			ResultsWriter writer = new ResultsWriter(testResultsFile, suiteResult, testsThatDidNotRun);
			writer.writeResults();
		} catch (FileNotFoundException e) {
			System.out.println("Could not write to file " + testResultsFile);
		}

		System.out.println("Results successfully written to file: " + testResultsFile);
		System.out.println("End of test suite.");
	}
}