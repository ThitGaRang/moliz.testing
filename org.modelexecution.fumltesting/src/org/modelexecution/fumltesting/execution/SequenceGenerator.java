package org.modelexecution.fumltesting.execution;

import java.util.HashMap;

import org.modelexecution.fuml.Semantics.Classes.Kernel.Object;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.sequence.Sequence;
import org.modelexecution.fumltesting.sequence.SequenceFactory;
import org.modelexecution.fumltesting.sequence.SequenceMapper;
import org.modelexecution.fumltesting.sequence.SequenceTrace;
import org.modelexecution.fumltesting.sequence.State;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.IntermediateActions.AddStructuralFeatureValueAction;
import fUML.Syntax.Actions.IntermediateActions.CreateObjectAction;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
import fUML.Syntax.Classes.Kernel.Property;

public class SequenceGenerator {
	private SequenceTrace trace;
	/** Object and Link instances added to the sequence. */
	private HashMap<Object, ValueInstance> instanceSnapshotMappings;
	private SequenceMapper mapper = new SequenceMapper();
	
	public SequenceTrace generateTrace(Trace trace){
		this.trace = SequenceFactory.eINSTANCE.createSequenceTrace();
		this.instanceSnapshotMappings = new HashMap<Object, ValueInstance>();
		
		for(ActivityExecution activityExecution: trace.getActivityExecutions()){
			Sequence sequence = SequenceFactory.eINSTANCE.createSequence();
			sequence.setActivityExecution(activityExecution);
			this.trace.getSequences().add(sequence);
			for(ActivityNodeExecution nodeExecution: activityExecution.getNodeExecutions()){
				
				if(nodeExecution instanceof ActionExecution){
					
					if(nodeExecution.getNode() instanceof ReadSelfAction){
						//create new state, add it to the sequence, 
						//and copy all links and objects from previous state
						State state = createNewState(sequence, nodeExecution);
						
						for(Output output: ((ActionExecution)nodeExecution).getOutputs()){
							ValueSnapshot snapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
							ValueInstance instance = (ValueInstance)snapshot.eContainer();
							
							Object original = getLastVersion(sequence, instance);								
							if(original != null){
								state.getObjects().remove(original);									
							}
							Object newObject = mapper.map((Object_)snapshot.getValue());
							state.getObjects().add(newObject);
						}
					}
					
					if(nodeExecution.getNode() instanceof CreateObjectAction){
						//create new state, add it to the sequence, 
						//and copy all links and objects from previous state
						State state = createNewState(sequence, nodeExecution);
						
						for(Output output: ((ActionExecution)nodeExecution).getOutputs()){
							ValueSnapshot snapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
							ValueInstance instance = (ValueInstance)snapshot.eContainer();
							
							Object object = mapper.map((Object_)snapshot.getValue());
							instanceSnapshotMappings.put(object, instance);
							state.getObjects().add(object);
						}
					}
					
					if(nodeExecution.getNode() instanceof AddStructuralFeatureValueAction){
						Property property = (Property)((AddStructuralFeatureValueAction)nodeExecution.getNode()).structuralFeature;
						
						//create new state, add it to the sequence, 
						//and copy all links and objects from previous state
						State state = createNewState(sequence, nodeExecution);
						AddStructuralFeatureValueAction theAction = (AddStructuralFeatureValueAction)nodeExecution.getNode();
						
						if(property.association == null){//case for setting the attribute of the object
							
							for(Output output: ((ActionExecution)nodeExecution).getOutputs()){
								ValueSnapshot snapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
								ValueInstance instance = (ValueInstance)snapshot.eContainer();
								
								Object original = getLastVersion(sequence, instance);								
								if(original != null){
									state.getObjects().remove(original);									
								}
								Object newObject = mapper.map((Object_)snapshot.getValue());
								state.getObjects().add(newObject);
							}
							
						}else{//case for setting a new link to the object
							
							//add new link to the new state
							for(ValueInstance link: trace.getValueInstances()){
								if(link.getCreator() == nodeExecution){
									state.getLinks().add(mapper.map((Link)link.getRuntimeValue()));
								}
							}
							
							//process output to add new version of output object to the new state
							ValueSnapshot outputSnapshot = null;
							ValueInstance outputInstance = null;
							
							for(Output output: ((ActionExecution)nodeExecution).getOutputs()){
								outputSnapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
								outputInstance = (ValueInstance)outputSnapshot.eContainer();
							}
							
							Object original = getLastVersion(sequence, outputInstance);								
							if(original != null){
								state.getObjects().remove(original);									
							}
							Object newObject = mapper.map((Object_)outputSnapshot.getValue());
							state.getObjects().add(newObject);
							
							//process input to add the value object to the new state
							for(Input input: ((ActionExecution) nodeExecution).getInputs()){
								ValueSnapshot snapshot = input.getInputValues().get(0).getInputValueSnapshot();
								ValueInstance instance = (ValueInstance)snapshot.eContainer();								
								
								if(input.getInputPin() == theAction.value){
									Object originalValue = getLastVersion(sequence, instance);								
									if(originalValue != null){
										state.getObjects().remove(originalValue);									
									}
									Object newValue = mapper.map((Object_)snapshot.getValue());
									state.getObjects().add(newValue);
								}
							}
						}
					}
					
					if(nodeExecution.getNode() instanceof CallBehaviorAction){
						
					}
				}
			}
		}
		
		return this.trace;
	}
	
	private State createNewState(Sequence sequence, ActivityNodeExecution creatorNode){
		State state = SequenceFactory.eINSTANCE.createState();
		state.setNodeExecution(creatorNode);		
		//add links and objects from last state
		State lastState = sequence.lastState();
		if(lastState != null){
			state.getObjects().addAll(lastState.getObjects());
			state.getLinks().addAll(lastState.getLinks());
		}		
		sequence.addState(state);		
		return state;
	}
	
	private Object getLastVersion(Sequence sequence, ValueInstance instance){
		State lastState = sequence.lastState();
		for(Object object: lastState.getObjects()){
			for(ValueInstance theInstance: instanceSnapshotMappings.values()){
				if(theInstance == instance)return object;
			}
		}
		return null;
	}
}