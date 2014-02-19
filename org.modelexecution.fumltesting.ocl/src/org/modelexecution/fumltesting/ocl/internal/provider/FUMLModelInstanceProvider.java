package org.modelexecution.fumltesting.ocl.internal.provider;

import java.net.URL;

import org.modelexecution.fumltesting.ocl.internal.modelinstance.FUMLModelInstance;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstance.IModelInstanceProvider;
import tudresden.ocl20.pivot.modelinstance.base.AbstractModelInstanceProvider;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelInstanceProvider extends AbstractModelInstanceProvider implements IModelInstanceProvider {
	public FUMLModelInstanceProvider() {
	}

	public IModelInstance createEmptyModelInstance(IModel model) {
		if (model == null) {
			throw new IllegalArgumentException("Parameter 'model' must not be null!");
		}
		return new FUMLModelInstance(model);
	}

	@Override
	public IModelInstance getModelInstance(URL url, IModel model) throws ModelAccessException {
		throw new UnsupportedOperationException("This method is not supported!");
	}
}