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
import org.modelexecution.fumldebug.core.event.Event;
import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectValue;
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
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;
/**
 * Utility class for executing UML activities.
 * @author Stefan Mijatov
 *
 */
public class ActivityExecutor implements ExecutionEventListener {
	
	/** ID of main Activity. */
	private int mainActivityID;
	/** Original UML model under test. */
	private NamedElement umlModel;
	/** List of events risen during execution. */
	private List<Event> eventlist;
	/** Result obtained from converting UML to fUML model. */
	private IConversionResult result;
	/** Utility class for converting input data for activity under test. */
	private TestDataConverter testDataConverter;
	/** List of parameters for an activity. */
	private ParameterValueList parameters = new ParameterValueList();
	List<ActivityNode> enabledNodes;
	
	public ActivityExecutor(NamedElement umlModel){
		this.umlModel = umlModel;
		IConverter converter = ConverterRegistry.getInstance().getConverter(umlModel);
		result = converter.convert(this.umlModel);
		replaceOpaqueBehaviors();
		TestDataConverter.setModel(result);
		testDataConverter = TestDataConverter.getInstance();
	}

	/** 
	 * Returns original UML element that was converted to {@code element}. 
	 */
	public Object getOriginal(Element element){
		return result.getInputObject(element);
	}
	
	/**
	 * Returs the result of conversion of UML model to fUML.
	 * @return
	 */
	public IConversionResult getConversionResult(){
		return result;
	}
	
	/**
	 * Converts the specified {@code activity} into fUML Activity and executes it.
	 */
	public int executeActivity(org.eclipse.uml2.uml.Activity activity, List<ActivityInput> activityInputs, ObjectSpecification context){
		Activity fumlActivity = result.getActivity(activity.getName());
		for(ActivityInput input: activityInputs){
			Object object = testDataConverter.getFUMLElement(input.getValue());
			
			ParameterValue parameterValue = new ParameterValue();
			for(ActivityNode node: fumlActivity.node){
				if(node instanceof ActivityParameterNode && node.name.equals(input.getParameter().getName())){
					parameterValue.parameter = ((ActivityParameterNode)node).parameter;
					break;
				}
			}
			if(object instanceof Object_){
				Reference reference = new Reference();
				reference.referent = (Object_)object;
				parameterValue.values.add(reference);
			}else{
				parameterValue.values.add((Value)object);
			}
			parameters.add(parameterValue);
		}
		
		//converting and setting the context object
		Object_ contextObject = null;
		if(context != null){
			ObjectValue contextValue = TestLangFactory.eINSTANCE.createObjectValue();
			contextValue.setValue(context);
			contextObject = (Object_)testDataConverter.getFUMLElement(contextValue);
		}
		
		//add a listener
		eventlist = new ArrayList<Event>();
		getExecutionContext().addEventListener(this);
		
		//execution with listener attached
		enabledNodes = new ArrayList<ActivityNode>();
		
		//insert the converted context object, if it exists
		if(context != null){
			getExecutionContext().execute(fumlActivity, contextObject, parameters);
		}else{
			getExecutionContext().execute(fumlActivity, null, parameters);
		}
		
		return mainActivityID;
	}
	
	private void replaceOpaqueBehaviors() {
		List<ActivityNode> nodesWithBehavior = new ArrayList<ActivityNode>();
		for (fUML.Syntax.Activities.IntermediateActivities.Activity activity : result
				.getAllActivities()) {
			nodesWithBehavior.addAll(getBehaviorNodes(activity.node));
		}

		for (ActivityNode node : nodesWithBehavior) {
			if (node instanceof CallBehaviorAction) {
				CallBehaviorAction callBehaviorAction = (CallBehaviorAction) node;
				Behavior behavior = callBehaviorAction.behavior;
				OpaqueBehavior behaviorReplacement = getExecutionContext()
						.getOpaqueBehavior(behavior.name);
				if (behaviorReplacement != null) {
					callBehaviorAction.behavior = behaviorReplacement;
				}
			} else if (node instanceof DecisionNode) {
				DecisionNode decision = (DecisionNode) node;
				Behavior behavior = decision.decisionInput;
				OpaqueBehavior behaviorReplacement = getExecutionContext()
						.getOpaqueBehavior(behavior.name);
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
	
	@Override
	public void notify(Event event) {
		if(event instanceof ActivityEntryEvent && (((ActivityEntryEvent)event).getParent() == null)){
			mainActivityID = ((ActivityEntryEvent)event).getActivityExecutionID();
		}
		eventlist.add(event);		
	}
	
	private ExecutionContext getExecutionContext(){
		return ExecutionContext.getInstance();
	}
}