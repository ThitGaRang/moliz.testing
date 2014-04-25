/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.ocl.internal.model.FUMLClass;
import org.modelexecution.fumltesting.ocl.internal.provider.FUMLModelInstanceProvider;
import org.modelexecution.fumltesting.ocl.internal.provider.FUMLModelProvider;
import org.modelexecution.fumltesting.sequence.State;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject;
import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.interpreter.IOclInterpreter;
import tudresden.ocl20.pivot.interpreter.OclInterpreterPlugin;
import tudresden.ocl20.pivot.model.metamodel.IMetamodel;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.pivotmodel.ConstrainableElement;
import tudresden.ocl20.pivot.pivotmodel.Constraint;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class OclExecutor {
	private OclExecutor() {
		metamodel = Ocl2ForEclipseFacade.getMetaModel("tudresden.ocl20.pivot.metamodels.fuml");
		modelProvider = (FUMLModelProvider) metamodel.getModelProvider();
		modelInstanceProvider = new FUMLModelInstanceProvider();
		adaptedStates = new HashMap<State, IModelInstance>();
	}

	private static OclExecutor INSTANCE;

	private IOclInterpreter oclInterpreter;
	private List<Constraint> constraints;

	private FUMLModelProvider modelProvider;
	private FUMLModelInstanceProvider modelInstanceProvider;
	private IMetamodel metamodel;

	/** Hash map of adapted states for the OCL interpreter. */
	private HashMap<State, IModelInstance> adaptedStates;

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

	public IModelInstance getEmptyModelInstance() {
		return modelInstanceProvider.createEmptyModelInstance(modelProvider.getModel());
	}

	public boolean checkConstraint(String constraintName, ValueInstance contextObject, State state) throws ConstraintNotFoundException {
		IModelInstance modelInstance = null;
		org.modelexecution.fuml.Semantics.Classes.Kernel.Object contextObjectSnapshot = state.getStateSnapshot(contextObject);

		if (adaptedStates.containsKey(state)) {
			modelInstance = adaptedStates.get(state);
		} else {
			modelInstance = OclExecutor.getInstance().getEmptyModelInstance();
			try {
				ArrayList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> objects = new ArrayList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object>();
				objects.addAll(state.getObjects());

				ArrayList<org.modelexecution.fuml.Semantics.Classes.Kernel.Link> links = new ArrayList<org.modelexecution.fuml.Semantics.Classes.Kernel.Link>();
				links.addAll(state.getLinks());

				for (org.modelexecution.fuml.Semantics.Classes.Kernel.Object object : objects) {
					modelInstance.addModelInstanceElement(object);
				}
				for (org.modelexecution.fuml.Semantics.Classes.Kernel.Link link : links) {
					modelInstance.addModelInstanceElement(link);
				}
				adaptedStates.put(state, modelInstance);
			} catch (TypeNotFoundInModelException e) {
				e.printStackTrace();
			}
		}
		boolean validationResult = OclExecutor.getInstance().evaluateConstraint(constraintName, contextObjectSnapshot, modelInstance);
		return validationResult;
	}

	private boolean evaluateConstraint(String constraintName, org.modelexecution.fuml.Semantics.Classes.Kernel.Object contextObject,
			IModelInstance modelInstance) throws ConstraintNotFoundException {
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
		if (constraint != null) {
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
			}
		}
		return false;
	}
}