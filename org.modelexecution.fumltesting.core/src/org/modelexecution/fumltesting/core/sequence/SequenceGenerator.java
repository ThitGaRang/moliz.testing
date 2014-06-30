/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
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

	private void createInitialState(ActivityNodeExecution nodeExecution, Sequence sequence) {
		State state = sequence.createNewState(nodeExecution);

		ValueSnapshot contextSnapshot = nodeExecution.getActivityExecution().getContextValueSnapshot();
		if (contextSnapshot != null) {
			if (contextSnapshot.getRuntimeValue() instanceof Object_) {
				ValueInstance instance = (ValueInstance) contextSnapshot.eContainer();
				Object_ object = (Object_) instance.getOriginal().getRuntimeValue();
				state.addStateObjectSnapshot(object, instance);
				addLinksAndLinkedObjects(object, state);
			}
		}

		for (InputParameterSetting inputParameterSetting : nodeExecution.getActivityExecution().getActivityInputs()) {
			ValueSnapshot snapshot = inputParameterSetting.getParameterValues().get(0).getValueSnapshot();
			if (snapshot.getValue() instanceof Object_) {
				ValueInstance instance = (ValueInstance) snapshot.eContainer();
				Object_ object = (Object_) instance.getOriginal().getRuntimeValue();
				state.addStateObjectSnapshot(object, instance);
				addLinksAndLinkedObjects(object, state);
			}
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
			} else if (nodeExecution.getNode() instanceof AddStructuralFeatureValueAction) {
				State state = sequence.createNewState(nodeExecution);
				AddStructuralFeatureValueAction node = (AddStructuralFeatureValueAction) nodeExecution.getNode();
				Property property = (Property) ((AddStructuralFeatureValueAction) nodeExecution.getNode()).structuralFeature;

				ValueSnapshot objectSnapshot = null;
				ValueInstance objectInstance = null;

				ValueSnapshot valueSnapshot = null;
				ValueInstance valueInstance = null;

				for (Input input : ((ActionExecution) nodeExecution).getInputs()) {
					if (input.getInputPin() == node.value) {
						valueSnapshot = input.getInputValues().get(0).getValueSnapshot();
						if (valueSnapshot != null)
							valueInstance = valueSnapshot.getValueInstance();
					}
				}

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
					for (ValueInstance link : ((Trace) nodeExecution.getActivityExecution().eContainer()).getValueInstances()) {
						if (link.getCreator() == nodeExecution) {
							Link linkValue = (Link) link.getRuntimeValue();

							Property firstEnd = linkValue.type.ownedEnd.get(0);
							Property secondEnd = linkValue.type.ownedEnd.get(1);

							FeatureValue firstFeatureValue = null;
							FeatureValue secondFeatureValue = null;
							Object_ theFirstEndObject = null;
							Object_ theSecondEndObject = null;

							for (FeatureValue featureValue : linkValue.featureValues) {
								if (featureValue.feature == firstEnd) {
									firstFeatureValue = featureValue;
								}
								if (featureValue.feature == secondEnd) {
									secondFeatureValue = featureValue;
								}
							}
							if (firstFeatureValue != null && secondFeatureValue != null) {
								for (Value firstEndObject : firstFeatureValue.values) {
									theFirstEndObject = ((Reference) firstEndObject).referent;
									break;
								}
								for (Value secondEndObject : secondFeatureValue.values) {
									theSecondEndObject = ((Reference) secondEndObject).referent;
									break;
								}
							} else {
								throw new SequenceGeneratorException("Features values of the association " + linkValue.type.name + " not found!");
							}

							state.addStateObjectSnapshot(theFirstEndObject, objectInstance);
							state.addStateObjectSnapshot(theSecondEndObject, valueInstance);

							state.addStateLinkSnapshot(linkValue, link);

							linkFoundAndProcessed = true;
						}
					}
					if (!linkFoundAndProcessed)
						throw new SequenceGeneratorException("Link after execution of action " + nodeExecution.getNode().name + " not found!");
				}
			} else if (nodeExecution.getNode() instanceof CallBehaviorAction || nodeExecution.getNode() instanceof CallOperationAction) {
				Trace trace = (Trace) nodeExecution.getActivityExecution().eContainer();
				Sequence calledActionSequence = null;
				for (ActivityExecution execution : trace.getActivityExecutions()) {
					if (nodeExecution.getNode() instanceof CallBehaviorAction
							&& execution.getActivity() == ((CallBehaviorAction) nodeExecution.getNode()).behavior) {
						calledActionSequence = createSequence(execution);
						break;
					}
					if (nodeExecution.getNode() instanceof CallOperationAction
							&& execution.getActivity() == ((CallOperationAction) nodeExecution.getNode()).operation.method.get(0)) {
						calledActionSequence = createSequence(execution);
						break;
					}
				}
				if (calledActionSequence != null) {
					State lastStateOfCalled = calledActionSequence.lastState();
					State state = sequence.createNewState(nodeExecution);

					for (ValueInstance instance : lastStateOfCalled.getStateObjectInstances()) {
						Object_ object = lastStateOfCalled.getStateObjectSnapshot(instance);
						state.addStateObjectSnapshot(object, instance);
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
	
	private void addLinksAndLinkedObjects(Object_ object, State state){
		for (ValueInstance locusInstance : trace.getInitialLocusValueInstances()) {
			if (locusInstance.getRuntimeValue() != null && locusInstance.getRuntimeValue() instanceof Link) {
				Link locusLink = (Link) locusInstance.getRuntimeValue();
				FeatureValue linkSource = null;
				FeatureValue linkTarget = null;
				for (FeatureValue featureValue : locusLink.featureValues) {
					if (locusLink.type.navigableOwnedEnd.contains(featureValue.feature))
						linkTarget = featureValue;
					else
						linkSource = featureValue;
				}
				for (Value reference : linkSource.values) {
					Reference theReference = (Reference) reference;
					if (theReference.referent == object) {
						Object_ targetValue = ((Reference) linkTarget.values.get(0)).referent;
						ValueInstance targetInstance = null;
						for (ValueInstance locusTargetInstance : trace.getValueInstances()) {
							if (locusTargetInstance.getRuntimeValue() == targetValue) {
								targetInstance = locusTargetInstance;
								break;
							}
						}
						if (targetInstance != null) {
							state.addStateObjectSnapshot(targetValue, targetInstance);
							state.addStateLinkSnapshot(locusLink, locusInstance);
							break;
						}
					}
				}
			}
		}
	}
}