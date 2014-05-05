/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence.util;

import java.util.ArrayList;

import org.modelexecution.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.modelexecution.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.modelexecution.fuml.Semantics.Classes.Kernel.IntegerValue;
import org.modelexecution.fuml.Semantics.Classes.Kernel.KernelFactory;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Object;
import org.modelexecution.fuml.Semantics.Classes.Kernel.StringValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.InitialNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.convert.FumlConverter;
import org.modelexecution.fumltesting.core.sequence.Sequence;
import org.modelexecution.fumltesting.core.sequence.SequenceFactory;
import org.modelexecution.fumltesting.core.sequence.SequenceTrace;
import org.modelexecution.fumltesting.core.sequence.State;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.IntermediateActions.AddStructuralFeatureValueAction;
import fUML.Syntax.Actions.IntermediateActions.CreateObjectAction;
import fUML.Syntax.Actions.IntermediateActions.DestroyObjectAction;
import fUML.Syntax.Actions.IntermediateActions.ReadSelfAction;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * Utility class for generating state sequences.
 * 
 * @author Stefan Mijatov
 * 
 */
public class SequenceGenerator {
	private Trace trace;
	private SequenceTrace sequenceTrace;
	private FumlConverter mapper = new FumlConverter();

	public SequenceTrace generateTrace(Trace trace) {
		this.trace = trace;
		this.sequenceTrace = SequenceFactory.eINSTANCE.createSequenceTrace();
		for (ActivityExecution activityExecution : trace.getActivityExecutions()) {
			Sequence sequence = createSequence(activityExecution);
			boolean alreadyAdded = false;
			for (Sequence theSequence : this.sequenceTrace.getSequences()) {
				if (theSequence.getActivityExecution().getActivity() == sequence.getActivityExecution().getActivity()) {
					alreadyAdded = true;
					break;
				}
			}
			if (alreadyAdded == false) {
				this.sequenceTrace.getSequences().add(sequence);
			}
		}
		return this.sequenceTrace;
	}

	private Sequence createSequence(ActivityExecution activityExecution) {
		Sequence sequence = SequenceFactory.eINSTANCE.createSequence();
		sequence.setActivityExecution(activityExecution);
		ActivityNodeExecution initial = null;
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0) {
				initial = nodeExecution;
				break;
			}
		}
		if (initial != null)
			completeSequence(initial, sequence);
		return sequence;
	}

	private void completeSequence(ActivityNodeExecution nodeExecution, Sequence sequence) {
		if (nodeExecution instanceof ActionExecution || nodeExecution instanceof InitialNodeExecution) {
			if (nodeExecution instanceof InitialNodeExecution) {
				State state = createNewState(sequence, nodeExecution);
				for (InputParameterSetting inputParameterSetting : nodeExecution.getActivityExecution().getActivityInputs()) {
					ValueSnapshot snapshot = inputParameterSetting.getParameterValues().get(0).getValueSnapshot();
					if (snapshot.getValue() instanceof Object_) {
						ValueInstance instance = (ValueInstance) snapshot.eContainer();
						Object original = getLastVersion(sequence, instance);
						if (original != null) {
							state.getObjects().remove(original);
						}
						Object newObject = mapper.map((Object_) snapshot.getValue());
						state.getObjects().add(newObject);
						state.addSnapshotMapping(instance, newObject);
					}
				}
			}
			if (nodeExecution.getNode() instanceof ReadSelfAction || nodeExecution.getNode() instanceof CreateObjectAction) {
				State state = createNewState(sequence, nodeExecution);
				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					ValueSnapshot snapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
					ValueInstance instance = (ValueInstance) snapshot.eContainer();
					Object original = getLastVersion(sequence, instance);
					if (original != null) {
						state.getObjects().remove(original);
					}
					Object newObject = mapper.map((Object_) snapshot.getValue());
					state.getObjects().add(newObject);
					state.addSnapshotMapping(instance, newObject);
				}
			}
			if (nodeExecution.getNode() instanceof DestroyObjectAction) {
				State state = createNewState(sequence, nodeExecution);
				for (Input input : ((ActionExecution) nodeExecution).getInputs()) {
					ValueSnapshot snapshot = input.getInputValues().get(0).getInputValueSnapshot();
					Object object = mapper.map((Object_) snapshot.getValue());
					state.getObjects().remove(object);
				}
				// TODO handle links from this object, or to this object..
			}
			if (nodeExecution.getNode() instanceof AddStructuralFeatureValueAction) {
				State state = createNewState(sequence, nodeExecution);
				Property property = (Property) ((AddStructuralFeatureValueAction) nodeExecution.getNode()).structuralFeature;

				if (property.association == null) {// attribute
					for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
						ValueSnapshot snapshot = output.getOutputValues().get(0).getOutputValueSnapshot();
						ValueInstance instance = (ValueInstance) snapshot.eContainer();
						Object original = getLastVersion(sequence, instance);
						if (original != null) {
							state.getObjects().remove(original);
						}
						Object newObject = mapper.map((Object_) snapshot.getValue());
						state.getObjects().add(newObject);
						state.addSnapshotMapping(instance, newObject);
					}
				} else {// link
					for (ValueInstance link : ((Trace) nodeExecution.getActivityExecution().eContainer()).getValueInstances()) {
						if (link.getCreator() == nodeExecution) {
							for (fUML.Semantics.Classes.Kernel.FeatureValue featureValue : ((Link) link.getRuntimeValue()).featureValues) {
								fUML.Semantics.Classes.Kernel.FeatureValue newFeatureValue = new fUML.Semantics.Classes.Kernel.FeatureValue();
								newFeatureValue.feature = featureValue.feature;
								newFeatureValue.position = featureValue.position;
								outter: for (Object object : state.getObjects()) {
									Object_ original = mapper.mappedFrom(object);

									ArrayList<ValueInstance> allValueInstances = new ArrayList<>();
									allValueInstances.addAll(trace.getValueInstances());
									allValueInstances.addAll(trace.getInitialLocusValueInstances());

									for (ValueInstance instance : allValueInstances) {
										boolean snapshotContained = false;
										for (ValueSnapshot snapshot : instance.getSnapshots()) {
											if (snapshot.getValue() == original)
												snapshotContained = true;
										}
										if (snapshotContained) {
											Object_ runtimeValue = (Object_) instance.getRuntimeValue();
											for (Value referenceValue : featureValue.values) {
												if (((Reference) referenceValue).referent == runtimeValue) {
													((Reference) referenceValue).referent = original;
													break outter;
												}
											}
										}
									}
								}
							}
							org.modelexecution.fuml.Semantics.Classes.Kernel.Link mappedLink = mapper.map((Link) link.getRuntimeValue());

							for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property target : mappedLink.getType().getNavigableOwnedEnd()) {
								for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property source : mappedLink.getType().getOwnedEnd()) {
									if (target != source) {
										Object sourceObject = null;
										FeatureValue targetFeatureValue = null;
										for (FeatureValue featureValue : mappedLink.getFeatureValues()) {
											if (featureValue.getFeature() == source) {
												sourceObject = (Object) featureValue.getValues().get(0);
											}
											if (featureValue.getFeature() == target) {
												targetFeatureValue = featureValue;
											}
										}

										Object original = getLastVersion(sequence, state.getInstance(sourceObject));
										if (original != null) {
											state.getObjects().remove(original);
										}
										Object newObject = KernelFactory.eINSTANCE.createObject();
										newObject.getTypes().addAll(original.getTypes());
										for (FeatureValue featureValue : original.getFeatureValues()) {
											FeatureValue newFeatureValue = KernelFactory.eINSTANCE.createFeatureValue();
											newFeatureValue.setFeature(featureValue.getFeature());
											newFeatureValue.setPosition(featureValue.getPosition());
											for (org.modelexecution.fuml.Semantics.Classes.Kernel.Value oldValue : featureValue.getValues()) {
												org.modelexecution.fuml.Semantics.Classes.Kernel.Value newValue = null;
												if (oldValue instanceof StringValue) {
													newValue = KernelFactory.eINSTANCE.createStringValue();
													((StringValue) newValue).setValue(((StringValue) oldValue).getValue());
													((StringValue) newValue).setType(((StringValue) oldValue).getType());
												}
												if (oldValue instanceof BooleanValue) {
													newValue = KernelFactory.eINSTANCE.createBooleanValue();
													((BooleanValue) newValue).setValue(((BooleanValue) oldValue).isValue());
													((BooleanValue) newValue).setType(((BooleanValue) oldValue).getType());
												}
												if (oldValue instanceof IntegerValue) {
													newValue = KernelFactory.eINSTANCE.createIntegerValue();
													((IntegerValue) newValue).setValue(((IntegerValue) oldValue).getValue());
													((IntegerValue) newValue).setType(((IntegerValue) oldValue).getType());
												}
												newFeatureValue.getValues().add(newValue);
											}
											newObject.getFeatureValues().add(newFeatureValue);
										}

										newObject.getFeatureValues().add(targetFeatureValue);
										state.getObjects().add(newObject);
										state.addSnapshotMapping(state.getInstance(sourceObject), newObject);
									}
								}
							}
						}
					}
				}
			}
			if (nodeExecution.getNode() instanceof CallBehaviorAction) {
				Trace trace = (Trace) nodeExecution.getActivityExecution().eContainer();
				Sequence calledActionSequence = null;
				for (ActivityExecution execution : trace.getActivityExecutions()) {
					if (execution.getActivity() == ((CallBehaviorAction) nodeExecution.getNode()).behavior) {
						calledActionSequence = createSequence(execution);
						break;
					}
				}
				if (calledActionSequence != null) {
					State lastStateOfCalled = calledActionSequence.lastState();
					State state = SequenceFactory.eINSTANCE.createState();
					state.setNodeExecution(nodeExecution);
					state.getObjects().addAll(lastStateOfCalled.getObjects());
					state.getLinks().addAll(lastStateOfCalled.getLinks());
					sequence.addState(state);
				}
			}
		}
		if (nodeExecution.getChronologicalSuccessor() != null)
			completeSequence(nodeExecution.getChronologicalSuccessor(), sequence);
	}

	private State createNewState(Sequence sequence, ActivityNodeExecution creatorNode) {
		State state = SequenceFactory.eINSTANCE.createState();
		state.setNodeExecution(creatorNode);
		// add links and objects from last state
		State lastState = sequence.lastState();
		if (lastState != null) {
			state.getObjects().addAll(lastState.getObjects());
			state.getLinks().addAll(lastState.getLinks());
			state.copySnapshotMappings(lastState);
		}
		sequence.addState(state);
		return state;
	}

	private Object getLastVersion(Sequence sequence, ValueInstance instance) {
		return sequence.lastState().getStateSnapshot(instance);
	}
}