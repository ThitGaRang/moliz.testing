/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import java.util.List;

import org.dresdenocl.model.IModel;
import org.dresdenocl.modelinstance.IModelInstance;
import org.dresdenocl.modelinstance.base.AbstractModelInstance;
import org.dresdenocl.modelinstancetype.exception.OperationAccessException;
import org.dresdenocl.modelinstancetype.exception.OperationNotFoundException;
import org.dresdenocl.modelinstancetype.exception.PropertyAccessException;
import org.dresdenocl.modelinstancetype.exception.PropertyNotFoundException;
import org.dresdenocl.modelinstancetype.exception.TypeNotFoundInModelException;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.modelinstancetype.types.IModelInstanceObject;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Property;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLModelInstance extends AbstractModelInstance implements IModelInstance {
	private static int nameCounter = 0;

	public FUMLModelInstance(IModel model) {
		myModel = model;
		myModelInstanceFactory = new FUMLModelInstanceFactory(myModel);
		myName = getClass().getSimpleName() + nameCounter;
	}

	public IModelInstanceElement addModelInstanceElement(Object object) throws TypeNotFoundInModelException {
		if (object == null) {
			throw new IllegalArgumentException("Parameter 'object' must not be null!");
		}
		IModelInstanceElement result = adaptObject(object);
		if (result instanceof IModelInstanceObject) {
			addModelInstanceObjectToCache((IModelInstanceObject) result);
		}
		return result;
	}

	public IModelInstanceElement getStaticProperty(Property property) throws PropertyAccessException, PropertyNotFoundException {
		if (property == null) {
			throw new IllegalArgumentException("Parameter 'property' must not be null!");
		}
		throw new PropertyAccessException(FUMLModelInstanceTypeMessages.FUMLModelInstance_NoSupportOfStaticProperties);
	}

	public IModelInstanceElement invokeStaticOperation(Operation operation, List<IModelInstanceElement> args) throws OperationAccessException,
			OperationNotFoundException {
		if (operation == null) {
			throw new IllegalArgumentException("Parameter 'operation' must not be null!");
		} else if (args == null) {
			throw new IllegalArgumentException("Parameter 'args' must not be null!");
		}
		throw new OperationAccessException(FUMLModelInstanceTypeMessages.FUMLModelInstance_NoSupportOfStaticOperations);
	}

	private IModelInstanceElement adaptObject(Object object) throws TypeNotFoundInModelException {
		IModelInstanceElement result = myModelInstanceFactory.createModelInstanceElement(object);
		if (result == null) {
			throw new TypeNotFoundInModelException(FUMLModelInstanceTypeMessages.FUMLModelInstance_ObjectDoesNoMatchToModel);
		}
		if (result instanceof IModelInstanceObject) {
			myModelInstanceObjects.add((IModelInstanceObject) result);
		}
		return result;
	}
}