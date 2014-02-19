package org.modelexecution.fumltesting.ocl.internal.provider;

import java.net.URL;

import org.modelexecution.fumltesting.ocl.internal.model.FUMLModel;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.IModelProvider;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.model.base.AbstractModelProvider;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelProvider extends AbstractModelProvider implements IModelProvider {

	private FUMLModel model;

	/** Initializes the model from fUML package. */
	public void initModel(org.modelexecution.fuml.Syntax.Classes.Kernel.Package rootPackage) {
		model = new FUMLModel(rootPackage);
	}

	public IModel getModel(URL modelURL) throws ModelAccessException {
		throw new ModelAccessException("Method not implemented! Use getModel(Package) instead.");
	}

	public IModel getModel() {
		return model;
	}
}