package org.modelexecution.fumltesting.sequence.execution;

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
import org.modelexecution.fumltesting.sequence.SequenceTrace;
import org.modelexecution.fumltesting.sequence.State;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.IntermediateActions.AddStructuralFeatureValueAction;
import fUML.Syntax.Actions.IntermediateActions.CreateObjectAction;
import fUML.Syntax.Actions.IntermediateActions.DestroyObjectAction;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
import fUML.Syntax.Classes.Kernel.Property;

public class SequenceGenerator {
	private SequenceTrace trace;
	/** Object and Link instances added to the sequence. */
	private HashMap<Object, ValueInstance> instanceSnapshotMappings;
	private SequenceMapper mapper = new SequenceMapper();

	public SequenceTrace generateTrace(Trace trace) {
		this.trace = SequenceFactory.eINSTANCE.createSequenceTrace();
		this.instanceSnapshotMappings = new HashMap<Object, ValueInstance>();
		for (ActivityExecution activityExecution : trace
				.getActivityExecutions()) {
			Sequence sequence = createSequence(activityExecution);
			boolean alreadyAdded = false;
			for (Sequence theSequence : this.trace.getSequences()) {
				if (theSequence.getActivityExecution().getActivity() == sequence
						.getActivityExecution().getActivity()) {
					alreadyAdded = true;
					break;
				}
			}
			if (alreadyAdded == false) {
				this.trace.getSequences().add(sequence);
			}
		}
		return this.trace;
	}

	private Sequence createSequence(ActivityExecution activityExecution) {
		Sequence sequence = SequenceFactory.eINSTANCE.createSequence();
		sequence.setActivityExecution(activityExecution);
		for (ActivityNodeExecution nodeExecution : activityExecution
				.getNodeExecutions()) {

			if (nodeExecution instanceof ActionExecution) {
				if (nodeExecution.getNode() instanceof ReadSelfAction
						|| nodeExecution.getNode() instanceof CreateObjectAction) {
					State state = createNewState(sequence, nodeExecution);
					for (Output output : ((ActionExecution) nodeExecution)
							.getOutputs()) {
						ValueSnapshot snapshot = output.getOutputValues()
								.get(0).getOutputValueSnapshot();
						ValueInstance instance = (ValueInstance) snapshot
								.eContainer();
						Object original = getLastVersion(sequence, instance);
						if (original != null) {
							state.getObjects().remove(original);
						}
						Object newObject = mapper.map((Object_) snapshot
								.getValue());
						state.getObjects().add(newObject);
						instanceSnapshotMappings.put(newObject, instance);
					}
				}
				if (nodeExecution.getNode() instanceof DestroyObjectAction) {
					State state = createNewState(sequence, nodeExecution);
					for (Input input : ((ActionExecution) nodeExecution)
							.getInputs()) {
						ValueSnapshot snapshot = input.getInputValues().get(0)
								.getInputValueSnapshot();
						Object object = mapper.map((Object_) snapshot
								.getValue());
						instanceSnapshotMappings.remove(object);
						state.getObjects().remove(object);
					}
					// TODO handle links from this object, or to this object..
				}
				if (nodeExecution.getNode() instanceof AddStructuralFeatureValueAction) {
					State state = createNewState(sequence, nodeExecution);
					AddStructuralFeatureValueAction theAction = (AddStructuralFeatureValueAction) nodeExecution
							.getNode();
					Property property = (Property) ((AddStructuralFeatureValueAction) nodeExecution
							.getNode()).structuralFeature;

					if (property.association == null) {// attribute
						for (Output output : ((ActionExecution) nodeExecution)
								.getOutputs()) {
							ValueSnapshot snapshot = output.getOutputValues()
									.get(0).getOutputValueSnapshot();
							ValueInstance instance = (ValueInstance) snapshot
									.eContainer();
							Object original = getLastVersion(sequence, instance);
							if (original != null) {
								state.getObjects().remove(original);
							}
							Object newObject = mapper.map((Object_) snapshot
									.getValue());
							state.getObjects().add(newObject);
							instanceSnapshotMappings.put(newObject, instance);
						}
					} else {// link
						for (ValueInstance link : ((Trace) activityExecution
								.eContainer()).getValueInstances()) {
							if (link.getCreator() == nodeExecution) {
								state.getLinks().add(
										mapper.map((Link) link
												.getRuntimeValue()));
							}
						}
						// add new version of output
						for (Output output : ((ActionExecution) nodeExecution)
								.getOutputs()) {
							ValueSnapshot outputSnapshot = output
									.getOutputValues().get(0)
									.getOutputValueSnapshot();
							ValueInstance outputInstance = (ValueInstance) outputSnapshot
									.eContainer();
							if (output.getOutputPin() == theAction.result) {
								Object original = getLastVersion(sequence,
										outputInstance);
								if (original != null) {
									state.getObjects().remove(original);
								}
								Object newObject = mapper
										.map((Object_) outputSnapshot
												.getValue());
								state.getObjects().add(newObject);
							}
						}
						// add new version input
						for (Input input : ((ActionExecution) nodeExecution)
								.getInputs()) {
							ValueSnapshot snapshot = input.getInputValues()
									.get(0).getInputValueSnapshot();
							ValueInstance instance = (ValueInstance) snapshot
									.eContainer();
							if (input.getInputPin() == theAction.value) {
								Object originalValue = getLastVersion(sequence,
										instance);
								if (originalValue != null) {
									state.getObjects().remove(originalValue);
								}
								Object newValue = mapper.map((Object_) snapshot
										.getValue());
								state.getObjects().add(newValue);
							}
						}
					}
				}
				if (nodeExecution.getNode() instanceof CallBehaviorAction) {
					Trace trace = (Trace) activityExecution.eContainer();
					Sequence calledActionSequence = null;
					for (ActivityExecution execution : trace
							.getActivityExecutions()) {
						if (execution.getActivity() == ((CallBehaviorAction) nodeExecution
								.getNode()).behavior) {
							calledActionSequence = createSequence(execution);
							break;
						}
					}
					if (calledActionSequence != null) {
						State lastStateOfCalled = calledActionSequence
								.lastState();
						State state = SequenceFactory.eINSTANCE.createState();
						state.setNodeExecution(nodeExecution);
						state.getObjects().addAll(
								lastStateOfCalled.getObjects());
						state.getLinks().addAll(lastStateOfCalled.getLinks());
						sequence.addState(state);
					}
				}
			}
		}
		return sequence;
	}

	private State createNewState(Sequence sequence,
			ActivityNodeExecution creatorNode) {
		State state = SequenceFactory.eINSTANCE.createState();
		state.setNodeExecution(creatorNode);
		// add links and objects from last state
		State lastState = sequence.lastState();
		if (lastState != null) {
			state.getObjects().addAll(lastState.getObjects());
			state.getLinks().addAll(lastState.getLinks());
		}
		sequence.addState(state);
		return state;
	}

	private Object getLastVersion(Sequence sequence, ValueInstance instance) {
		State lastState = sequence.lastState();
		for (Object object : lastState.getObjects()) {
			for (ValueInstance theInstance : instanceSnapshotMappings.values()) {
				if (theInstance == instance)
					return object;
			}
		}
		return null;
	}
}