package org.modelexecution.fumltesting.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.NamedElement;
import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.ExecutionEventListener;
import org.modelexecution.fumldebug.core.event.ActivityEntryEvent;
import org.modelexecution.fumldebug.core.event.ActivityExitEvent;
import org.modelexecution.fumldebug.core.event.ActivityNodeExitEvent;
import org.modelexecution.fumldebug.core.event.Event;
import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.TestLangFactory;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Activities.IntermediateActivities.FinalNode;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

/**
 * Utility class for executing UML activities.
 * 
 * @author Stefan Mijatov
 * 
 */
public class ActivityExecutor implements ExecutionEventListener {

	/** ID of main activity. */
	private int mainActivityID;
	/** ID of current activity. */
	private int currentActivityID;
	private boolean running;
	/** Original UML model under test. */
	private NamedElement umlModel;
	/** Result obtained from converting UML to fUML model. */
	private IConversionResult convertedModel;
	/** List of events risen during execution. */
	private List<Event> eventlist;
	/** Utility class for converting input data for activity under test. */
	private TestDataConverter testDataConverter;
	/** List of parameters for an activity. */
	private ParameterValueList parameters;

	public void initScenarios(List<Scenario> scenarios) {
		for (Scenario scenario : scenarios) {
			for (ObjectSpecification objectSpecification : scenario.getObjects()) {
				org.modelexecution.fumltesting.testLang.ObjectValue value = TestLangFactory.eINSTANCE.createObjectValue();
				value.setValue(objectSpecification);
				// initializes fUML object, puts it into locus and returns it
				// for each object existing links are created and
				// put into locus also
				testDataConverter.getFUMLElement(value);
			}
		}
	}

	public void cleanUp() {
		testDataConverter.cleanUp();
	}

	public ActivityExecutor(NamedElement umlModel) {
		this.umlModel = umlModel;
		IConverter converter = ConverterRegistry.getInstance().getConverter(umlModel);
		convertedModel = converter.convert(this.umlModel);
		replaceOpaqueBehaviors();
		TestDataConverter.setModel(convertedModel);
		testDataConverter = TestDataConverter.getInstance();
		parameters = new ParameterValueList();
	}

	/**
	 * Converts the specified {@code activity} into fUML Activity and executes
	 * it.
	 */
	public int executeActivity(org.eclipse.uml2.uml.Activity activity, List<ActivityInput> activityInputs, ObjectSpecification context) {
		Activity fumlActivity = convertedModel.getActivity(activity.getName());

		for (ActivityInput input : activityInputs) {
			Object object = testDataConverter.getFUMLElement(input.getValue());

			ParameterValue parameterValue = new ParameterValue();
			for (ActivityNode node : fumlActivity.node) {
				if (node instanceof ActivityParameterNode && node.name.equals(input.getParameter().getName())) {
					parameterValue.parameter = ((ActivityParameterNode) node).parameter;
					break;
				}
			}
			if (object instanceof Object_) {
				Reference reference = new Reference();
				reference.referent = (Object_) object;
				parameterValue.values.add(reference);
			} else {
				parameterValue.values.add((Value) object);
			}
			parameters.add(parameterValue);
		}

		// converting and setting the context object
		Object_ contextObject = null;
		if (context != null) {
			ObjectValue contextValue = TestLangFactory.eINSTANCE.createObjectValue();
			contextValue.setValue(context);
			contextObject = (Object_) testDataConverter.getFUMLElement(contextValue);
		}

		// add a listener
		eventlist = new ArrayList<Event>();
		getExecutionContext().addEventListener(this);

		// insert the converted context object, if it exists
		if (context != null) {
			running = true;
			getExecutionContext().executeStepwise(fumlActivity, contextObject, parameters);
		} else {
			running = true;
			getExecutionContext().executeStepwise(fumlActivity, null, parameters);
		}
		while (running) {
			List<ActivityNode> enabledNodes = ExecutionContext.getInstance().getEnabledNodes(currentActivityID);
			ActivityNode nonFinalNode = null;
			if (enabledNodes.size() > 1) {
				for (ActivityNode node : enabledNodes) {
					if (!(node instanceof FinalNode)) {
						nonFinalNode = node;
						break;
					}
				}
				ExecutionContext.getInstance().nextStep(currentActivityID, nonFinalNode);
			}
			if (enabledNodes.size() == 1) {
				nonFinalNode = enabledNodes.get(0);
				ExecutionContext.getInstance().nextStep(currentActivityID, nonFinalNode);
			}
		}

		return mainActivityID;
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
				OpaqueBehavior behaviorReplacement = getExecutionContext().getOpaqueBehavior(behavior.name);
				if (behaviorReplacement != null) {
					callBehaviorAction.behavior = behaviorReplacement;
				}
			} else if (node instanceof DecisionNode) {
				DecisionNode decision = (DecisionNode) node;
				Behavior behavior = decision.decisionInput;
				OpaqueBehavior behaviorReplacement = getExecutionContext().getOpaqueBehavior(behavior.name);
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

	/**
	 * Returns original UML element that was converted to {@code element}.
	 */
	public Object getOriginal(Element element) {
		return convertedModel.getInputObject(element);
	}

	@Override
	public void notify(Event event) {
		if (event instanceof ActivityEntryEvent && (((ActivityEntryEvent) event).getParent() == null)) {
			mainActivityID = ((ActivityEntryEvent) event).getActivityExecutionID();			

		}
		if (event instanceof ActivityEntryEvent) {
			currentActivityID = ((ActivityEntryEvent) event).getActivityExecutionID();			
		}
		if (event instanceof ActivityNodeExitEvent) {
			currentActivityID = ((ActivityNodeExitEvent) event).getActivityExecutionID();
		}
		if (event instanceof ActivityExitEvent && (((ActivityExitEvent) event).getActivityExecutionID() == mainActivityID)) {
			running = false;
		}
		eventlist.add(event);
	}

	private ExecutionContext getExecutionContext() {
		return ExecutionContext.getInstance();
	}
}