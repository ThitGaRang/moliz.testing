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
import org.modelexecution.fumldebug.core.event.Event;
import org.modelexecution.fumldebug.core.util.ActivityFactory;
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
import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.InputPin;
import fUML.Syntax.Actions.BasicActions.OutputPin;
import fUML.Syntax.Activities.CompleteStructuredActivities.StructuredActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityEdge;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.ControlFlow;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Activities.IntermediateActivities.FinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ForkNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;
import fUML.Syntax.Activities.IntermediateActivities.JoinNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectFlow;
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

	/** ID of main Activity. */
	private int mainActivityID;
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
		prepActivity(fumlActivity);

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
			ExecutionContext.getInstance().nextStep(mainActivityID);
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
		eventlist.add(event);
		if (event instanceof ActivityExitEvent && (((ActivityExitEvent) event).getActivityExecutionID() == mainActivityID)) {
			running = false;
		}
	}

	/** Insert fake initial-fork if needed, and fake control flows. */
	private void prepActivity(Activity activity) {

		boolean containsFinal = false;
		FinalNode finalNode = null;
		ArrayList<ActivityNode> freeNodes = new ArrayList<ActivityNode>();

		for (ActivityNode node : activity.node) {
			if (node instanceof FinalNode) {
				containsFinal = true;
				finalNode = (FinalNode) node;
			}
			boolean isFree = true;
			for (ActivityEdge edge : node.incoming) {
				if (edge instanceof ControlFlow)
					isFree = false;
				if (edge instanceof ObjectFlow) {
					if (!(edge.source instanceof ActivityParameterNode))
						isFree = false;
				}
			}
			if (node instanceof Action) {
				for (InputPin pin : ((Action) node).input) {
					if (pin.incoming.size() > 0)
						isFree = false;
				}
			}
			if (node instanceof InitialNode || node instanceof ActivityParameterNode) {
				isFree = false;
			}
			if (isFree)
				freeNodes.add(node);
		}

		if (freeNodes.size() > 1) {
			System.out.println("Fake initial-fork nodes added.");
			InitialNode initFake = ActivityFactory.createInitialNode(activity, "fake_init");
			ForkNode forkFake = ActivityFactory.createForkNode(activity, "fake_fork");
			ActivityFactory.createControlFlow(activity, initFake, forkFake);

			for (ActivityNode freeNode : freeNodes) {
				ActivityFactory.createControlFlow(activity, forkFake, freeNode);
			}
		}
		// empty free nodes collection
		if (!freeNodes.isEmpty())
			freeNodes.removeAll(freeNodes);

		for (ActivityNode node : activity.node) {
			boolean isFree = true;
			for (ActivityEdge edge : node.outgoing) {
				if (edge instanceof ControlFlow)
					isFree = false;
				if (edge instanceof ObjectFlow) {
					if (edge.target instanceof Action || edge.target instanceof InputPin)
						isFree = false;
				}
			}
			if (node instanceof Action) {
				for (OutputPin pin : ((Action) node).output) {
					if (pin.outgoing.size() > 0)
						isFree = false;
				}
			}
			if (node instanceof ActivityParameterNode || node instanceof FinalNode) {
				isFree = false;
			}
			if (isFree)
				freeNodes.add(node);
		}
		
		if (containsFinal) {
			for (ActivityNode freeNode : freeNodes) {
				System.out.println("Fake control flow from " + freeNode.name + " to " + finalNode.name + " added.");
				ActivityFactory.createControlFlow(activity, freeNode, finalNode);
			}
		}else{
			System.out.println("Fake join-final nodes added.");
			JoinNode fakeJoin = ActivityFactory.createJoinNode(activity, "fake_join");
			ActivityFinalNode fakeFinal = ActivityFactory.createActivityFinalNode(activity, "fake_final");
			ActivityFactory.createControlFlow(activity, fakeJoin, fakeFinal);
			
			for(ActivityNode freeNode: freeNodes){
				System.out.println("Fake control flow from " + freeNode.name + " to " + fakeJoin.name + " added.");
				ActivityFactory.createControlFlow(activity, freeNode, fakeJoin);
			}
		}
	}

	private ExecutionContext getExecutionContext() {
		return ExecutionContext.getInstance();
	}
}