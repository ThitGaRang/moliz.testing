/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

import java.util.Collection;
import java.util.Map;

import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.libraryregistry.LibraryRegistry;
import org.modelexecution.fumldebug.libraryregistry.OpaqueBehaviorCallReplacer;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.Property;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

/**
 * Utility class providing features for converting UML to fUML models.
 * 
 * @author Stefan Mijatov
 * 
 */
public class ModelConverter {
	private IConversionResult convertedModel;

	public void setModelAndConvert(Object model) {
		IConverter converter = ConverterRegistry.getInstance().getConverter(model);
		convertedModel = converter.convert(model);
		replaceOpaqueBehaviors();
	}

	public Object getOriginal(Element element) {
		return convertedModel.getInputObject(element);
	}

	public Object convertElement(Object element) {
		return convertedModel.getFUMLElement(element);
	}

	public fUML.Syntax.Classes.Kernel.Package convertPackage(Object aPackage) {
		return (fUML.Syntax.Classes.Kernel.Package) convertedModel.getFUMLElement(aPackage);
	}

	public Class_ convertClass(Object aClass) {
		return (Class_) convertedModel.getFUMLElement(aClass);
	}

	public Property convertProperty(Object aProperty) {
		return (Property) convertedModel.getFUMLElement(aProperty);
	}

	public Association convertAssociation(Object anAssociation) {
		return (Association) convertedModel.getFUMLElement(anAssociation);
	}

	public Activity convertActivity(Object anActivity) {
		return (Activity) convertedModel.getFUMLElement(anActivity);
	}

	public ActivityParameterNode convertActivityParameterNode(Object anActivityParameterNode) {
		return (ActivityParameterNode) convertedModel.getFUMLElement(anActivityParameterNode);
	}

	public ActivityNode convertActivityNode(Object anActivityNode) {
		return (ActivityNode) convertedModel.getFUMLElement(anActivityNode);
	}

	public Action convertAction(Object anAction) {
		return (Action) convertedModel.getFUMLElement(anAction);
	}

	public ObjectNode convertPin(Object aPin) {
		return (ObjectNode) convertedModel.getFUMLElement(aPin);
	}

	public Collection<Activity> getAllActivities() {
		return convertedModel.getAllActivities();
	}

	private void replaceOpaqueBehaviors() {
		LibraryRegistry libraryRegistry = new LibraryRegistry(ExecutionContext.getInstance());
		Map<String, OpaqueBehavior> registeredOpaqueBehaviors = libraryRegistry.loadRegisteredLibraries();
		OpaqueBehaviorCallReplacer.instance.replaceOpaqueBehaviorCalls(convertedModel.getAllActivities(), registeredOpaqueBehaviors);
	}
}