/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import java.util.List;

import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstance.base.AbstractModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.OperationAccessException;
import tudresden.ocl20.pivot.modelinstancetype.exception.OperationNotFoundException;
import tudresden.ocl20.pivot.modelinstancetype.exception.PropertyAccessException;
import tudresden.ocl20.pivot.modelinstancetype.exception.PropertyNotFoundException;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;

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
		IModelInstanceElement result = addObject(object);
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

	private IModelInstanceElement addObject(Object object) throws TypeNotFoundInModelException {
		IModelInstanceElement result = myModelInstanceFactory.createModelInstanceElement(object);
		if (result == null) {
			if(object instanceof Link)return result;
			throw new TypeNotFoundInModelException(FUMLModelInstanceTypeMessages.FUMLModelInstance_ObjectDoesNoMatchToModel);
		}
		if (result instanceof IModelInstanceObject) {
			myModelInstanceObjects.add((IModelInstanceObject) result);
		}
		return result;
	}
}