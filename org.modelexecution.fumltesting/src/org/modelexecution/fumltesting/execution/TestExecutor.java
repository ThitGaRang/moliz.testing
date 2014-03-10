/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.uml.UmlSupport;
import org.junit.Test;
import org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory;
import org.modelexecution.fumltesting.TestLangStandaloneSetup;
import org.modelexecution.fumltesting.execution.assertions.AssertionPrinter;
import org.modelexecution.fumltesting.execution.assertions.AssertionValidator;
import org.modelexecution.fumltesting.results.AssertionResult;
import org.modelexecution.fumltesting.results.ResultsWriter;
import org.modelexecution.fumltesting.results.TestCaseResult;
import org.modelexecution.fumltesting.results.TestSuiteResult;
import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestSuite;

import com.google.inject.Injector;

import fUML.Syntax.Classes.Kernel.Package;

/**
 * Main class that runs all the tests.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestExecutor {

	/** Utility class for executing fUML activities. */
	private ActivityExecutor executor;
	/** The resource set to be used for loading the model resource. */
	private XtextResourceSet resourceSet;
	/** The resource for reading test models. */
	private Resource resource;
	/** The resource for reading UML model. */
	private Resource umlResource;
	/** The UML Model. */
	private NamedElement umlModel;
	/** Complete test suite. */
	private TestSuite suite;
	/** Utility class for validating assertions. */
	private AssertionValidator validator;
	/** ID of the main activity. */
	private int mainActivityExecutionID;
	/** The fUML reference implementation to fUML meta model converter. */
	private FumlConverter fumlConverter;
	/** Utility class for interpreting OCL constraints on fUML model. */
	private FumlOclInterpreter oclInterpreter;

	/**
	 * Sets up all the resources, UML model and testing model, and initializes
	 * the testSuite.
	 */
	private void setup(String testLocation) {
		try {
			fumlConverter = new FumlConverter();
			new UmlSupport().registerServices(true);
			Injector injector = new TestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
			resourceSet = injector.getInstance(XtextResourceSet.class);
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

			// model of the test suite to be executed
			resource = resourceSet.getResource(URI.createFileURI(new File(testLocation).getAbsolutePath()), true);

			resource.load(null);
			if (resource != null) {
				resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
				// model with UML elements under test
				umlResource = resourceSet
						.getResource(URI.createFileURI(new File("../org.modelexecution.fumltesting.examples/model/petstore/petstore.uml")
								.getAbsolutePath()), true);
				umlResource.load(null);

				// adds elements from UML model to test suite
				resource.getContents().addAll(umlResource.getContents());
				EcoreUtil.resolveAll(resourceSet);

				for (EObject model : resource.getContents()) {
					if (model instanceof NamedElement) {
						umlModel = (NamedElement) model;
						executor = new ActivityExecutor((NamedElement) model);
					}
				}

				if (executor == null)
					throw new Exception("Couldn't load UML model properly!");
				suite = (TestSuite) resource.getContents().get(0);
			}

			oclInterpreter = FumlOclInterpreter.getInstance();

			if (oclInterpreter.getMetamodel() != null) {
				System.out.println("Metamodel adaptation: " + oclInterpreter.getMetamodel().getName());
				System.out.println("Model adaptation: " + umlModel.getName());

				org.modelexecution.fuml.Syntax.Classes.Kernel.Package modelPackage = KernelFactory.eINSTANCE.createPackage();
				modelPackage.setName(umlModel.getName());
				modelPackage.setQualifiedName(umlModel.getQualifiedName());

				if (umlModel.getNamespace() != null) {
					modelPackage.getNamespace().setName(umlModel.getNamespace().getName());
					modelPackage.getNamespace().setQualifiedName(umlModel.getNamespace().getQualifiedName());
				}

				for (org.eclipse.uml2.uml.Package umlPackage : ((Model) umlModel).getNestedPackages()) {
					Package fumlPackage = UmlConverter.getInstance().getPackage(umlPackage);
					if (fumlPackage != null) {
						org.modelexecution.fuml.Syntax.Classes.Kernel.Package mappedPackage = fumlConverter.mapAndWire(fumlPackage);
						modelPackage.getNestedPackage().add(mappedPackage);
						mappedPackage.setOwner(modelPackage);
					}
				}
				oclInterpreter.setModel(modelPackage);
			}
			oclInterpreter.loadConstraints(new File("../org.modelexecution.fumltesting.examples/model/petstore/petstore.ocl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Main method of the testing framework. */
	@Test
	public void test() {
		File folder = new File("../org.modelexecution.fumltesting.examples/model/petstore/tests");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith("newProductActivity.fumltest")) {
				String testLocation = "../org.modelexecution.fumltesting.examples/model/petstore/tests/" + file.getName();
				setup(testLocation);
				testsEvaluation();
			}
		}
	}

	private void testsEvaluation() {
		TestSuiteResult suiteResult = new TestSuiteResult();
		SimpleDateFormat currentTime = new SimpleDateFormat("dd.MM.yy_HH.mm.ss");
		String testResultsFile = "results/testresults_" + currentTime.format(new Date()) + ".txt";
		for (int i = 0; i < suite.getTests().size(); i++) {
			TestCase testCase = suite.getTests().get(i);
			AssertionPrinter.print(testCase);
			Activity activity = testCase.getActivityUnderTest();

			TestDataConverter.getInstance().cleanUp();
			executor.initScenarios(testCase.getInitScenarios());

			boolean requiresContext = false;
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof ReadSelfAction) {
					requiresContext = true;
					break;
				}
			}

			if (testCase.getContextObject() != null) {
				mainActivityExecutionID = executor.executeActivity(activity, testCase.getInputs(), testCase.getContextObject());
			} else {
				if (requiresContext) {
					System.out.println("CONTEXT for activity NOT defined. Please correct the test declaration.");
					System.out.println("Test execution failed.");
					AssertionPrinter.printStartEnd();
					break;
				}
				mainActivityExecutionID = executor.executeActivity(activity, testCase.getInputs(), null);
			}

			validator = new AssertionValidator(mainActivityExecutionID);

			// add test case result
			TestCaseResult testCaseResult = new TestCaseResult(testCase.getName(), activity);
			testCaseResult.setActivityContextObject(testCase.getContextObject());

			for (ActivityInput activityInput : testCase.getInputs()) {
				org.modelexecution.fumltesting.results.ActivityInput activityInputForResult = new org.modelexecution.fumltesting.results.ActivityInput(
						activityInput.getParameter(), activityInput.getValue());
				testCaseResult.addActivityInputValue(activityInputForResult);
			}

			for (int j = 0; j < testCase.getAssertions().size(); j++) {
				Assertion assertion = testCase.getAssertions().get(j);
				AssertionResult result = validator.check(assertion);
				testCaseResult.addAssertionResult(result);
			}

			suiteResult.addTestCaseResult(testCaseResult);

			System.out.println("End of test.");
			AssertionPrinter.printStartEnd();
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