package org.modelexecution.fumltesting.execution;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.NamedElement;
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
 * @author Stefan Mijatov
 *
 */
public class TestExecutor{
	
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
	/** ID of the main activity.*/
	private int mainActivityExecutionID;
	
	/** Sets up all the resources, UML model and testing model,
	 *	and initializes the testSuite.
	 */
	private void setup() {
		try{
			new UmlSupport().registerServices(true);
			Injector injector = new TestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
			resourceSet = injector.getInstance(XtextResourceSet.class);
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

			//model of the test suite to be executed, with references to UML model under test
			resource = resourceSet.getResource(URI.createFileURI(new File("example/banking.fumltest").getAbsolutePath()), true);

			resource.load(null);
			if (resource != null){
				resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
				//model with UML elements under test, referenced by testing model
				Resource r = resourceSet.getResource(URI.createFileURI(new File("example/model.uml").getAbsolutePath()), true);
				r.load(null);
				
				//replacement of references with the elements from UML model
				resource.getContents().addAll(r.getContents());
				
				for (EObject model : resource.getContents()) {
					if (model instanceof NamedElement){
						executor = new ActivityExecutor((NamedElement)model);
					}
				}
				
				if(executor == null)throw new Exception("Couldn't load UML model properly!");
				suite = (TestSuite)resource.getContents().get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** Main method of the testing framework. */
	@Test
	public void test() {
		setup();		
		
		for (int i = 0; i < suite.getTests().size(); i++) {
			TestCase testCase = suite.getTests().get(i);
			
			AssertionPrinter.print(testCase);
			
			Activity activity = testCase.getActivityUnderTest();
			
			mainActivityExecutionID = executor.executeActivity(activity, testCase.getInputs());
			validator = new AssertionValidator(mainActivityExecutionID, executor);
			
			for(int j=0;j<testCase.getAssertions().size();j++){
				Assertion assertion = testCase.getAssertions().get(j);
				assertTrue(validator.check(assertion));
			}
			System.out.println("End of test.");
			AssertionPrinter.printStartEnd();
		}
	}
}