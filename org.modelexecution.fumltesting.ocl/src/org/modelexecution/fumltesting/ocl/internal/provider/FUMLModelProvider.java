package org.modelexecution.fumltesting.ocl.internal.provider;

import java.net.URL;

import org.dresdenocl.model.IModel;
import org.dresdenocl.model.IModelProvider;
import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.model.base.AbstractModelProvider;
import org.modelexecution.fumltesting.ocl.internal.model.FUMLModel;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelProvider extends AbstractModelProvider implements IModelProvider {

	private FUMLModel model;

	/** Initializes the model from fUML package. */
	public void initModel(fUML.Syntax.Classes.Kernel.Package rootPackage) {
		model = new FUMLModel(rootPackage);
	}

	public IModel getModel(URL modelURL) throws ModelAccessException {
		throw new ModelAccessException("Method not implemented! Use getModel(Package) instead.");
	}

	public IModel getModel() {
		return model;
	}
}