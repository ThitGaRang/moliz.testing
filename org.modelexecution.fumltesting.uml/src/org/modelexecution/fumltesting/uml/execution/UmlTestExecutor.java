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
import org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory;
import org.modelexecution.fumltesting.core.assertions.AssertionPrinter;
import org.modelexecution.fumltesting.core.assertions.OrderAssertionValidator;
import org.modelexecution.fumltesting.core.assertions.StateAssertionValidator;
import org.modelexecution.fumltesting.core.convert.FumlConverter;
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

import tudresden.ocl20.pivot.parser.ParseException;

import com.google.inject.Injector;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
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
	private FumlConverter fumlConverter;
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

	private String testsPath = "../org.modelexecution.fumltesting.examples/model/webstore/tests";
	private String umlModelPath = "../org.modelexecution.fumltesting.examples/model/webstore/webstore.uml";
	private String primitivesPath = "../../moliz/org.modelexecution.fumldebug.standardlibrary/library/uml_library.uml";
	private String oclPath = "../org.modelexecution.fumltesting.examples/model/webstore/webstore.ocl";

	private String testEndsWith = "addCartItem.umltest";

	private AssertionPrinter assertionPrinter;

	private void setup(String testLocation) throws Exception {
		fumlConverter = new FumlConverter();
		executor = new ActivityExecutor();
		testDataConverter = new TestDataConverter();
		assertionPrinter = new AssertionPrinter();

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

			org.modelexecution.fuml.Syntax.Classes.Kernel.Package modelPackage = KernelFactory.eINSTANCE.createPackage();
			modelPackage.setName(umlModel.getName());
			modelPackage.setQualifiedName(umlModel.getQualifiedName());

			if (umlModel.getNamespace() != null) {
				modelPackage.getNamespace().setName(umlModel.getNamespace().getName());
				modelPackage.getNamespace().setQualifiedName(umlModel.getNamespace().getQualifiedName());
			}

			for (org.eclipse.uml2.uml.Package umlPackage : ((Model) umlModel).getNestedPackages()) {
				Package fumlPackage = testConverter.getModelConverter().convertPackage(umlPackage);
				if (fumlPackage != null) {
					org.modelexecution.fuml.Syntax.Classes.Kernel.Package mappedPackage = fumlConverter.mapAndWire(fumlPackage);
					modelPackage.getNestedPackage().add(mappedPackage);
					mappedPackage.setOwner(modelPackage);
				}
			}
			oclExecutor.setModel(modelPackage);
		}
		oclExecutor.loadConstraints(new File(oclPath));
	}

	/** Main method of the testing framework. */
	@Test
	public void test() {
		File folder = new File(testsPath);
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(testEndsWith)) {
				String testLocation = testsPath + "/" + file.getName();
				try {
					setup(testLocation);
				} catch (ParseException e) {
					System.out.println("Problem with loading OCL file!");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
				testsEvaluation(file.getName().replace(".fumltest", ""));
			}
		}
	}

	private void testsEvaluation(String testName) {
		TestSuiteResult suiteResult = new TestSuiteResult();
		SimpleDateFormat currentTime = new SimpleDateFormat("dd.MM.yy_HH.mm.ss");
		String testResultsFile = "results/testresults_" + testName + "_" + currentTime.format(new Date()) + ".txt";
		for (TestCase testCase : convertedSuite.getAllTestCases()) {
			assertionPrinter.print(testCase);
			Activity activity = testCase.getActivityUnderTest();

			testDataConverter.cleanUpAndInit(convertedSuite);

			boolean requiresContext = false;
			for (ActivityNode node : activity.node) {
				if (node instanceof ReadSelfAction) {
					requiresContext = true;
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
				ObjectValue contextValue = new ObjectValue(null);
				contextValue.setValue(testCase.getContextObject());
				Object_ contextObject = (Object_) testDataConverter.getFumlObject(contextValue);
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, contextObject);
			} else {
				if (requiresContext) {
					System.out.println("CONTEXT for activity NOT defined. Please correct the test declaration.");
					System.out.println("Test execution failed.");
					assertionPrinter.printStartEnd();
					break;
				}
				mainActivityExecutionID = executor.executeActivity(activity, inputValues, null);
			}

			traceUtil = new TraceUtil(mainActivityExecutionID);
			orderAssertionValidator = new OrderAssertionValidator(traceUtil);
			stateAssertionValidator = new StateAssertionValidator(traceUtil, testDataConverter);

			TestCaseResult testCaseResult = new TestCaseResult(testCase.getName(), activity);
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
					if (result.getAssertionValidationResult())
						System.out.println("Assertion success!");
					else
						System.out.println("Assertion failed!");
				} else if (assertion instanceof FinallyStateAssertion) {
					try {
						result = stateAssertionValidator.check((FinallyStateAssertion) assertion);
					} catch (ActionNotExecutedException e) {
						result = new StateAssertionResult(assertion);
						result.setError(e.getMessage());
						System.out.println(e.getMessage());
					}
				} else if (assertion instanceof StateAssertion) {
					result = stateAssertionValidator.check((StateAssertion) assertion);
				}
				testCaseResult.addAssertionResult(result);
			}

			suiteResult.addTestCaseResult(testCaseResult);

			System.out.println("End of test.");
			assertionPrinter.printStartEnd();
		}

		ResultsWriter writer = new ResultsWriter(testResultsFile, suiteResult);

		try {
			writer.writeResults();
		} catch (FileNotFoundException e) {
			System.out.println("Could not write to file " + testResultsFile);
		}

		System.out.println("Results successfully written to file: " + testResultsFile);
		System.out.println("End of test suite.");
	}
}