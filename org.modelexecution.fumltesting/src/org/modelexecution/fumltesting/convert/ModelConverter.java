/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.Property;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
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
		List<ActivityNode> nodesWithBehavior = new ArrayList<ActivityNode>();
		for (fUML.Syntax.Activities.IntermediateActivities.Activity activity : convertedModel.getAllActivities()) {
			nodesWithBehavior.addAll(getBehaviorNodes(activity.node));
		}
		for (ActivityNode node : nodesWithBehavior) {
			if (node instanceof CallBehaviorAction) {
				CallBehaviorAction callBehaviorAction = (CallBehaviorAction) node;
				Behavior behavior = callBehaviorAction.behavior;
				OpaqueBehavior behaviorReplacement = ExecutionContext.getInstance().getOpaqueBehavior(behavior.name);
				if (behaviorReplacement != null) {
					callBehaviorAction.behavior = behaviorReplacement;
				}
			} else if (node instanceof DecisionNode) {
				DecisionNode decision = (DecisionNode) node;
				Behavior behavior = decision.decisionInput;
				OpaqueBehavior behaviorReplacement = ExecutionContext.getInstance().getOpaqueBehavior(behavior.name);
				if (behaviorReplacement != null) {
					decision.decisionInput = behaviorReplacement;
				}
			}
		}
	}

	private List<ActivityNode> getBehaviorNodes(List<ActivityNode> nodes) {
		List<ActivityNode> nodesWithBehavior = new ArrayList<ActivityNode>();
		for (ActivityNode node : nodes) {
			if (node instanceof CallBehaviorAction) {
				CallBehaviorAction action = (CallBehaviorAction) node;
				nodesWithBehavior.add(action);
			} else if (node instanceof DecisionNode) {
				DecisionNode decision = (DecisionNode) node;
				if (decision.decisionInput != null) {
					nodesWithBehavior.add(decision);
				}
			}
			if (node instanceof StructuredActivityNode) {
				StructuredActivityNode structurednode = (StructuredActivityNode) node;
				nodesWithBehavior.addAll(getBehaviorNodes(structurednode.node));
			}
		}
		return nodesWithBehavior;
	}
}