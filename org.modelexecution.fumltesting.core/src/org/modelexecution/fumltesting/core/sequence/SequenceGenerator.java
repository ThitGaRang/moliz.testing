/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.CallActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.exceptions.SequenceGeneratorException;

import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Actions.CompleteActions.ReadExtentAction;
import fUML.Syntax.Actions.IntermediateActions.AddStructuralFeatureValueAction;
import fUML.Syntax.Actions.IntermediateActions.CreateObjectAction;
import fUML.Syntax.Actions.IntermediateActions.DestroyObjectAction;
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

	public SequenceTrace generateTrace(Trace trace) throws SequenceGeneratorException {
		this.trace = trace;
		this.sequenceTrace = new SequenceTrace();
		for (ActivityExecution activityExecution : trace.getActivityExecutions()) {
			boolean alreadyAdded = false;
			for (Sequence sequence : sequenceTrace.getSequences()) {
				if (sequence.getActivityExecution() == activityExecution)
					alreadyAdded = true;
			}
			if (alreadyAdded) {
				break;
			}
			createSequence(activityExecution);
		}
		return this.sequenceTrace;
	}

	private Sequence createSequence(ActivityExecution activityExecution) throws SequenceGeneratorException {
		Sequence sequence = new Sequence(activityExecution);
		sequenceTrace.getSequences().add(sequence);
		ActivityNodeExecution initial = null;
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0) {
				initial = nodeExecution;
				break;
			}
		}
		if (initial != null) {
			createInitialState(initial, sequence);
			if (initial.getChronologicalSuccessor() != null) {
				completeSequence(initial.getChronologicalSuccessor(), sequence);
			}
		}
		return sequence;
	}

	private Sequence createSequenceOfCalled(ActivityExecution activityExecution, State lastState) throws SequenceGeneratorException {
		Sequence sequence = new Sequence(activityExecution);
		sequenceTrace.getSequences().add(sequence);
		ActivityNodeExecution initial = null;
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getLogicalPredecessor().size() == 0) {
				initial = nodeExecution;
				break;
			}
		}
		
		sequence.createNewState(lastState);
		
		if (initial != null) {
			completeSequence(initial.getChronologicalSuccessor(), sequence);			
		}
		return sequence;
	}

	private void createInitialState(ActivityNodeExecution nodeExecution, Sequence sequence) {
		State state = sequence.createNewState(nodeExecution);
		ArrayList<Object_> initialObjects = new ArrayList<Object_>();

		for (ValueInstance instance : trace.getInitialLocusValueInstances()) {
			if (instance.getRuntimeValue() != null && instance.getRuntimeValue() instanceof Object_) {
				initialObjects.add((Object_) instance.getOriginal().getValue());
				state.addStateObjectSnapshot((Object_) instance.getOriginal().getValue(), instance);
			}
		}

		for (Object_ initialObject : initialObjects) {
			addLinksOfInitialObject(initialObject, state);
		}
	}

	private void completeSequence(ActivityNodeExecution nodeExecution, Sequence sequence) throws SequenceGeneratorException {
		if (nodeExecution instanceof ActionExecution) {
			if (nodeExecution.getNode() instanceof CreateObjectAction) {
				State state = sequence.createNewState(nodeExecution);
				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					ValueSnapshot snapshot = output.getOutputValues().get(0).getValueSnapshot();
					ValueInstance instance = (ValueInstance) snapshot.eContainer();
					Object_ object = (Object_) snapshot.getValue();
					state.addStateObjectSnapshot(object, instance);
				}
			} else if (nodeExecution.getNode() instanceof DestroyObjectAction) {
				State state = sequence.createNewState(nodeExecution);
				for (Input input : ((ActionExecution) nodeExecution).getInputs()) {
					ValueSnapshot snapshot = input.getInputValues().get(0).getValueSnapshot();
					ValueInstance instance = (ValueInstance) snapshot.eContainer();
					state.removeStateObjectSnapshot(instance);
				}
			} else if (nodeExecution.getNode() instanceof ReadExtentAction) {
				State state = sequence.createNewState(nodeExecution);
				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					for (OutputValue outputValue : output.getOutputValues()) {
						ValueSnapshot snapshot = outputValue.getValueSnapshot();
						ValueInstance instance = (ValueInstance) snapshot.eContainer();
						Object_ object = (Object_) snapshot.getValue();
						state.addStateObjectSnapshot(object, instance);
					}
				}
			} else if (nodeExecution.getNode() instanceof AddStructuralFeatureValueAction) {
				State state = sequence.createNewState(nodeExecution);
				AddStructuralFeatureValueAction node = (AddStructuralFeatureValueAction) nodeExecution.getNode();
				Property property = (Property) ((AddStructuralFeatureValueAction) nodeExecution.getNode()).structuralFeature;

				ValueSnapshot objectSnapshot = null;
				ValueInstance objectInstance = null;

				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					if (output.getOutputPin() == node.result) {
						objectSnapshot = output.getOutputValues().get(0).getValueSnapshot();
						objectInstance = (ValueInstance) objectSnapshot.eContainer();
					}
				}

				if (property.association == null) {// attribute
					Object_ object = (Object_) objectSnapshot.getValue();
					state.addStateObjectSnapshot(object, objectInstance);
				} else {// link
					boolean linkFoundAndProcessed = false;
					for (ValueInstance link : trace.getValueInstances()) {
						if (link.getCreator() == nodeExecution) {
							Link linkValue = (Link) link.getRuntimeValue();
							state.addStateLinkSnapshot(linkValue, link);
							linkFoundAndProcessed = true;
						}
					}
					if (!linkFoundAndProcessed)
						throw new SequenceGeneratorException("Link after execution of action " + nodeExecution.getNode().name + " not found!");
				}
			} else if (nodeExecution.getNode() instanceof CallBehaviorAction || nodeExecution.getNode() instanceof CallOperationAction) {
				Sequence calledActionSequence = null;
				for (ActivityExecution execution : trace.getActivityExecutions()) {
					if (nodeExecution.getNode() instanceof CallBehaviorAction && execution == ((CallActionExecution) nodeExecution).getCallee()) {
						calledActionSequence = createSequenceOfCalled(execution, sequence.lastState());
						break;
					}
					if (nodeExecution.getNode() instanceof CallOperationAction && execution == ((CallActionExecution) nodeExecution).getCallee()) {
						calledActionSequence = createSequenceOfCalled(execution, sequence.lastState());
						break;
					}
				}
				if (calledActionSequence != null) {
					State lastStateOfCalled = calledActionSequence.lastState();
					State state = sequence.createNewState(nodeExecution);

					ArrayList<ValueInstance> objectsToRemove = new ArrayList<ValueInstance>();
					ArrayList<ValueInstance> linksToRemove = new ArrayList<ValueInstance>();

					for (ValueInstance instance : state.getStateObjectInstances()) {
						if (instance.getDestroyer() != null
								&& calledActionSequence.getActivityExecution().getNodeExecutions().contains(instance.getDestroyer())) {
							objectsToRemove.add(instance);
						}
					}
					for (ValueInstance instance : state.getStateLinkInstances()) {
						if (instance.getDestroyer() != null
								&& calledActionSequence.getActivityExecution().getNodeExecutions().contains(instance.getDestroyer())) {
							linksToRemove.add(instance);
						}
					}
					for (ValueInstance instanceToRemove : objectsToRemove) {
						state.removeStateObjectSnapshot(instanceToRemove);
					}
					for (ValueInstance instanceToRemove : linksToRemove) {
						state.removeStateLinkSnapshot(instanceToRemove);
					}

					for (ValueInstance instance : lastStateOfCalled.getStateObjectInstances()) {
						Object_ object = lastStateOfCalled.getStateObjectSnapshot(instance);
						if (object != null)
							state.addStateObjectSnapshot(object, instance);
					}
					for (ValueInstance instance : lastStateOfCalled.getStateLinkInstances()) {
						Link link = lastStateOfCalled.getStateLinkSnapshot(instance);
						if (link != null)
							state.addStateLinkSnapshot(link, instance);
					}
				}
			}
		}
		if (nodeExecution.getChronologicalSuccessor() != null) {
			ActivityNodeExecution successor = getNextChronologicalSuccessorAtSameLevel(nodeExecution, sequence.getActivityExecution());
			if (successor != null)
				completeSequence(successor, sequence);
		}
	}

	private ActivityNodeExecution getNextChronologicalSuccessorAtSameLevel(ActivityNodeExecution nodeExecution, ActivityExecution activityExecution) {
		if (nodeExecution.getChronologicalSuccessor() != null) {
			if (nodeExecution.getChronologicalSuccessor().getActivityExecution() == activityExecution) {
				return nodeExecution.getChronologicalSuccessor();
			} else {
				return getNextChronologicalSuccessorAtSameLevel(nodeExecution.getChronologicalSuccessor(), activityExecution);
			}
		}
		return null;
	}

	private void addLinksOfInitialObject(Object_ object, State state) {
		Link link = null;
		for (ValueInstance instance : trace.getInitialLocusValueInstances()) {
			if (instance.getRuntimeValue() != null && instance.getRuntimeValue() instanceof Link) {
				link = (Link) instance.getRuntimeValue();
				FeatureValue linkSource = null;
				FeatureValue linkTarget = null;
				for (FeatureValue featureValue : link.featureValues) {
					if (!link.type.navigableOwnedEnd.contains(featureValue.feature))
						linkSource = featureValue;
					else
						linkTarget = featureValue;
				}
				if (linkSource == null) {
					for (FeatureValue featureValue : link.featureValues) {
						if (featureValue != linkTarget) {
							linkSource = featureValue;
						}
					}
				}
				for (Value reference : linkSource.values) {
					Reference theSourceReference = (Reference) reference;
					if (object.equals(theSourceReference.referent)) {
						Object_ targetValue = ((Reference) linkTarget.values.get(0)).referent;
						ValueInstance targetInstance = trace.getValueInstance(targetValue);
						state.addStateObjectSnapshot((Object_) targetInstance.getOriginal().getValue(), targetInstance);
						state.addStateLinkSnapshot(link, instance);
					}
				}
			}
		}
	}
}