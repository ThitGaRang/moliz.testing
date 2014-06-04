package org.modelexecution.fumltesting.ocl.internal.provider;

import java.net.URL;

import org.dresdenocl.model.IModel;
import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.modelinstance.IModelInstance;
import org.dresdenocl.modelinstance.IModelInstanceProvider;
import org.dresdenocl.modelinstance.base.AbstractModelInstanceProvider;
import org.modelexecution.fumltesting.ocl.internal.modelinstance.FUMLModelInstance;

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