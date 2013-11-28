package org.modelexecution.fumltesting.ocl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.model.OCLstdlib;
import org.eclipse.ocl.examples.pivot.uml.UML2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.google.inject.Injector;

public class OclUmlLoader {
	private List<Constraint> constraints;
	private Resource resource;

	public OclUmlLoader() {
	}

	public void loadOCL(String path) throws FileNotFoundException,
			ParserException, IOException {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		PivotEnvironmentFactory environmentFactory = new PivotEnvironmentFactory(
				registry, null);
		OCL ocl = OCL.newInstance(environmentFactory);

		Injector injector = new CompleteOCLStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

		OCLstdlib.install();
		UML2Pivot.initialize(resourceSet);
		CompleteOCLStandaloneSetup.doSetup();

		URI uri = URI.createFileURI(path);
		resource = ocl.parse(uri);
		resource.load(null);

		constraints = new ArrayList<Constraint>();

		for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator
				.hasNext();) {
			EObject next = iterator.next();
			if (next instanceof Constraint) {
				constraints.add((Constraint) next);
			}
		}
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public Resource getOclResource() {
		return resource;
	}
}