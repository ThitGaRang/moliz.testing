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
import org.modelexecution.fumldebug.core.event.SuspendEvent;
import org.modelexecution.fumltesting.testLang.ActivityInput;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Classes.Kernel.Element;
/**
 * Utility class for executing UML activities.
 * @author Stefan Mijatov
 *
 */
public class ActivityExecutor implements ExecutionEventListener {
	
	private SuspendEvent suspendEvent;
	/** Flag variable used to detect exit event from main Activity. */
	private boolean terminate;
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
		testDataConverter = new TestDataConverter(result);
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
	public int executeActivity(org.eclipse.uml2.uml.Activity activity, List<ActivityInput> activityInputs){
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
		
		//add observer and a listener
		eventlist = new ArrayList<Event>();
		registerObserver();
		ExecutionContext.getInstance().addEventListener(this);
		
		//stepwise execution with listener attached
		enabledNodes = new ArrayList<ActivityNode>();
		ExecutionContext.getInstance().executeStepwise(fumlActivity, null, parameters);
		
		if(suspendEvent != null){
			enabledNodes = suspendEvent.getNewEnabledNodes();
		}else{System.out.println("There are no enabled nodes in the Activity!");}		
		
		while (!terminate){
			for(int i=0;i<enabledNodes.size();i++){
				ExecutionContext.getInstance().nextStep(suspendEvent.getActivityExecutionID());
			}
		}
		
		terminate = false;
		return mainActivityID;
	}
	
	@Override
	public void notify(Event event) {
		if(event instanceof ActivityEntryEvent && (((ActivityEntryEvent)event).getParent() == null)){
			mainActivityID = ((ActivityEntryEvent)event).getActivityExecutionID();
		}
		eventlist.add(event);		
	}
	
	private void registerObserver(){
		ExecutionContext.getInstance().addEventListener(
				new ExecutionEventListener() {
					@Override
					public void notify(Event event) {
						if (event instanceof SuspendEvent) {
							suspendEvent = (SuspendEvent) event;
						}
						else if(event instanceof ActivityExitEvent 
								&& ((ActivityExitEvent)event).getActivityExecutionID() == mainActivityID){
							terminate = true;
						}
					}
				});
	}
}