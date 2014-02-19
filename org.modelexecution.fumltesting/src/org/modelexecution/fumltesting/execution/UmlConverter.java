package org.modelexecution.fumltesting.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.uml2.uml.NamedElement;
import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;

import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.Package;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

/**
 * Utility class providing features for converting UML to fUML models.
 * 
 * @author Stefan
 * 
 */
public class UmlConverter {
	/** Original UML model under test. */
	private static NamedElement MODEL;
	/** Result obtained from converting UML to fUML model. */
	private static IConversionResult CONVERTED_MODEL;
	private static UmlConverter INSTANCE;

	private UmlConverter() {
	}

	public static UmlConverter getInstance() {
		if (INSTANCE == null)
			INSTANCE = new UmlConverter();
		return INSTANCE;
	}

	public void setModelAndConvert(NamedElement model) {
		MODEL = model;
		IConverter converter = ConverterRegistry.getInstance().getConverter(MODEL);
		CONVERTED_MODEL = converter.convert(MODEL);
		replaceOpaqueBehaviors();
	}

	/** Returns original UML element that was converted to {@code element}. */
	public Object getOriginal(Element element) {
		return CONVERTED_MODEL.getInputObject(element);
	}

	public Activity getActivity(org.eclipse.uml2.uml.Activity activity) {
		return (Activity) CONVERTED_MODEL.getFUMLElement(activity);
	}

	public Class_ getClass(org.eclipse.uml2.uml.Class clazz) {
		return (Class_) CONVERTED_MODEL.getFUMLElement(clazz);
	}

	public Association getAssociation(org.eclipse.uml2.uml.Association association) {
		return (Association) CONVERTED_MODEL.getFUMLElement(association);
	}
	
	public Package getPackage(org.eclipse.uml2.uml.Package umlPackage){
		return (Package)CONVERTED_MODEL.getFUMLElement(umlPackage);
	}
	
	public Collection<Activity> getAllActivities() {
		return CONVERTED_MODEL.getAllActivities();
	}

	public IConversionResult getConvertedModel() {
		return CONVERTED_MODEL;
	}

	private void replaceOpaqueBehaviors() {
		List<ActivityNode> nodesWithBehavior = new ArrayList<ActivityNode>();
		for (fUML.Syntax.Activities.IntermediateActivities.Activity activity : CONVERTED_MODEL.getAllActivities()) {
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