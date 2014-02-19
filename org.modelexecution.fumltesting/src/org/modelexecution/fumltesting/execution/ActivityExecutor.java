package org.modelexecution.fumltesting.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.NamedElement;
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
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.FinalNode;

/**
 * Utility class for executing UML activities.
 * 
 * @author Stefan
 * 
 */
public class ActivityExecutor implements ExecutionEventListener {

	/** ID of main activity. */
	private int mainActivityID;
	/** ID of current activity. */
	private int currentActivityID;
	private boolean running;
	/** List of events risen during execution. */
	private List<Event> eventlist;
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
				TestDataConverter.getInstance().getFUMLElement(value);
			}
		}
	}

	public ActivityExecutor(NamedElement umlModel) {
		UmlConverter.getInstance().setModelAndConvert(umlModel);
		parameters = new ParameterValueList();
	}

	/**
	 * Converts the specified {@code activity} into fUML Activity and executes
	 * it.
	 */
	public int executeActivity(org.eclipse.uml2.uml.Activity activity, List<ActivityInput> activityInputs, ObjectSpecification context) {
		Activity fumlActivity = UmlConverter.getInstance().getActivity(activity);

		for (ActivityInput input : activityInputs) {
			Object object = TestDataConverter.getInstance().getFUMLElement(input.getValue());

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
			contextObject = (Object_) TestDataConverter.getInstance().getFUMLElement(contextValue);
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