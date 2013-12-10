package org.modelexecution.fumltesting.execution;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.uml.UmlSupport;
import org.junit.Test;
import org.modelexecution.fumltesting.TestLangStandaloneSetup;
import org.modelexecution.fumltesting.execution.assertions.AssertionPrinter;
import org.modelexecution.fumltesting.execution.assertions.AssertionValidator;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestSuite;

import com.google.inject.Injector;

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
	/** The resource for reading models. */
	private Resource resource;
	/** Complete test suite. */
	private TestSuite suite;
	/** Utility class for validating assertions. */
	private AssertionValidator validator;
	/** ID of the main activity. */
	private int mainActivityExecutionID;

	/**
	 * Sets up all the resources, UML model and testing model, and initializes
	 * the testSuite.
	 */
	private void setup(String fumlTestLocation) {
		try {
			new UmlSupport().registerServices(true);
			Injector injector = new TestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
			resourceSet = injector.getInstance(XtextResourceSet.class);
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

			// model of the test suite to be executed
			resource = resourceSet.getResource(URI.createFileURI(new File(fumlTestLocation).getAbsolutePath()), true);

			resource.load(null);
			if (resource != null) {
				resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
				// model with UML elements under test
				Resource r = resourceSet.getResource(URI.createFileURI(new File("example/petstore/petstore.uml").getAbsolutePath()), true);
				r.load(null);

				// adds elements from UML model to test suite
				resource.getContents().addAll(r.getContents());

				for (EObject model : resource.getContents()) {
					if (model instanceof NamedElement) {
						executor = new ActivityExecutor((NamedElement) model);
					}
				}

				if (executor == null)
					throw new Exception("Couldn't load UML model properly!");
				suite = (TestSuite) resource.getContents().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Main method of the testing framework. */
	@Test
	public void test() {
		File folder = new File("example/petstore/tests");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith("fumltest")) {
				String path = "example/petstore/tests/" + file.getName();
				setup(path);
				testsEvaluation();
			}
		}
	}

	private void testsEvaluation() {
		for (int i = 0; i < suite.getTests().size(); i++) {
			TestCase testCase = suite.getTests().get(i);
			AssertionPrinter.print(testCase);
			Activity activity = testCase.getActivityUnderTest();

			executor.cleanUp();
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

			validator = new AssertionValidator(mainActivityExecutionID, executor);

			for (int j = 0; j < testCase.getAssertions().size(); j++) {
				Assertion assertion = testCase.getAssertions().get(j);
				validator.check(assertion);
			}

			System.out.println("End of test.");
			AssertionPrinter.printStartEnd();
		}
	}
}