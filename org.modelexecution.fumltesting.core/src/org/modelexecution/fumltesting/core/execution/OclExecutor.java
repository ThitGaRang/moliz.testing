/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.execution;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dresdenocl.essentialocl.standardlibrary.OclAny;
import org.dresdenocl.essentialocl.standardlibrary.OclBoolean;
import org.dresdenocl.essentialocl.standardlibrary.OclModelInstanceObject;
import org.dresdenocl.facade.Ocl2ForEclipseFacade;
import org.dresdenocl.interpreter.IInterpretationResult;
import org.dresdenocl.interpreter.IOclInterpreter;
import org.dresdenocl.interpreter.OclInterpreterPlugin;
import org.dresdenocl.model.metamodel.IMetamodel;
import org.dresdenocl.modelinstance.IModelInstance;
import org.dresdenocl.modelinstancetype.exception.TypeNotFoundInModelException;
import org.dresdenocl.modelinstancetype.types.IModelInstanceObject;
import org.dresdenocl.modelinstancetype.types.base.JavaModelInstanceBoolean;
import org.dresdenocl.parser.ParseException;
import org.dresdenocl.pivotmodel.ConstrainableElement;
import org.dresdenocl.pivotmodel.Constraint;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.core.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.core.sequence.State;
import org.modelexecution.fumltesting.ocl.internal.model.FUMLClass;
import org.modelexecution.fumltesting.ocl.internal.provider.FUMLModelInstanceProvider;
import org.modelexecution.fumltesting.ocl.internal.provider.FUMLModelProvider;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Object;

/**
 * Utility class for interpreting and evaluating OCL constraints.
 * 
 * @author Stefan Mijatov
 * 
 */
public class OclExecutor {
	private static OclExecutor INSTANCE;

	private IMetamodel metamodel;
	private IModelInstance modelInstance;
	private FUMLModelProvider modelProvider;
	private FUMLModelInstanceProvider modelInstanceProvider = new FUMLModelInstanceProvider();

	private List<Constraint> constraints;
	private IOclInterpreter oclInterpreter;
	private HashMap<State, IModelInstance> adaptedStates = new HashMap<State, IModelInstance>();

	private OclExecutor() {
		metamodel = Ocl2ForEclipseFacade.getMetaModel("tudresden.ocl20.pivot.metamodels.fuml");
		modelProvider = (FUMLModelProvider) metamodel.getModelProvider();
	}

	public static OclExecutor getInstance() {
		if (INSTANCE == null)
			INSTANCE = new OclExecutor();
		return INSTANCE;
	}

	public IMetamodel getMetamodel() {
		return metamodel;
	}

	public void setModel(Package modelPackage) {
		getInstance().modelProvider.initModel(modelPackage);
	}

	public void loadConstraints(File oclFile) throws ParseException {
		constraints = Ocl2ForEclipseFacade.parseConstraints(oclFile, modelProvider.getModel(), false);
	}

	public boolean checkConstraint(String constraintName, ValueInstance contextObject, State state) throws ConstraintNotFoundException {
		Object contextObjectSnapshot = state.getStateSnapshot(contextObject);

		if (adaptedStates.containsKey(state)) {
			modelInstance = adaptedStates.get(state);
		} else {
			modelInstance = modelInstanceProvider.createEmptyModelInstance(modelProvider.getModel());
			try {
				ArrayList<Object> objects = new ArrayList<Object>(state.getObjects());
				ArrayList<Link> links = new ArrayList<Link>(state.getLinks());

				for (Object object : objects) {
					modelInstance.addModelInstanceElement(object);
				}
				for (Link link : links) {
					modelInstance.addModelInstanceElement(link);
				}
				adaptedStates.put(state, modelInstance);
			} catch (TypeNotFoundInModelException e) {
				e.printStackTrace();
			}
		}

		boolean validationResult = OclExecutor.getInstance().evaluateConstraint(constraintName, contextObjectSnapshot);
		return validationResult;
	}

	private boolean evaluateConstraint(String constraintName, Object contextObject) throws ConstraintNotFoundException {
		Constraint constraint = null;
		boolean result = false;

		for (Constraint aConstraint : constraints) {
			if (aConstraint.getName().equals(constraintName)) {
				constraint = aConstraint;
				break;
			}
		}
		if (constraint == null)
			throw new ConstraintNotFoundException("Constraint " + constraintName + " not found!");
		else {
			// TODO continue implementing constraint checking
			System.out.println("Checking constraint..\n" + constraint.getSpecification().getBody().trim());

			oclInterpreter = OclInterpreterPlugin.createInterpreter(modelInstance);
			ConstrainableElement constrainedElement = constraint.getConstrainedElement().get(0);
			if (constrainedElement instanceof FUMLClass) {
				FUMLClass constrainedClass = (FUMLClass) constrainedElement;
				if (contextObject == null) {
					for (IModelInstanceObject object : modelInstance.getAllInstances(constrainedClass)) {
						result = evaluate(constraint, object);
						if (result == false)
							return result;
					}
				} else {
					for (IModelInstanceObject object : modelInstance.getAllInstances(constrainedClass)) {
						if (object.getObject() == contextObject) {
							result = evaluate(constraint, object);
							if (result == false)
								return result;
						}
					}
				}
			}
		}
		return result;
	}

	private boolean evaluate(Constraint constraint, IModelInstanceObject object) {
		IInterpretationResult result = oclInterpreter.interpretConstraint(constraint, object);
		OclAny resultValue = result.getResult();
		if (resultValue instanceof OclBoolean) {
			OclBoolean resultBoolean = (OclBoolean) resultValue;
			if (resultBoolean.getInvalidReason() != null && resultBoolean.getInvalidReason().getMessage().contains("Tried to invoke operation")
					&& resultBoolean.getInvalidReason().getMessage().contains("on null")) {
				if (constraint.getSpecification().getBody().trim().endsWith("= null")) {
					return true;
				} else {
					return false;
				}
			}
			return resultBoolean.isTrue();
		}
		if (resultValue instanceof OclModelInstanceObject) {
			if (((OclModelInstanceObject) resultValue).getModelInstanceObject().getObject() instanceof Boolean) {
				return (Boolean) ((OclModelInstanceObject) resultValue).getModelInstanceObject().getObject();
			} else if (((OclModelInstanceObject) resultValue).getModelInstanceObject().getObject() instanceof JavaModelInstanceBoolean) {
				return ((JavaModelInstanceBoolean) ((OclModelInstanceObject) resultValue).getModelInstanceObject().getObject()).getBoolean();
			}
		}
		return false;
	}
}