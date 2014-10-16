/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.trace;

import java.util.ArrayList;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.exceptions.ActionNotExecutedException;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.TemporalOperator;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

/**
 * @author Stefan Mijatov
 * 
 */
public class SnapshotUtil {

	private ArrayList<ValueSnapshot> predecessorSnapshots;
	private ArrayList<ValueSnapshot> successorSnapshots;

	private ArrayList<ValueInstance> valueInstances;
	private ActivityNodeExecution referenceActionExecution;
	private ActivityNodeExecution untilActionExecution;
	private TraceUtil traceUtil;

	public SnapshotUtil(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		predecessorSnapshots = new ArrayList<ValueSnapshot>();
		successorSnapshots = new ArrayList<ValueSnapshot>();
	}

	public ArrayList<ValueSnapshot> getRelevantSnapshots(StateExpression expression, ActivityNodeExecution referenceActionExecution,
			ActivityNodeExecution untilActionExecution) throws ActionNotExecutedException {
		ArrayList<ValueSnapshot> list = new ArrayList<ValueSnapshot>();
		this.referenceActionExecution = referenceActionExecution;
		this.untilActionExecution = untilActionExecution;

		successorSnapshots.removeAll(successorSnapshots);
		predecessorSnapshots.removeAll(predecessorSnapshots);

		Object expressionAction = expression.getPin().owner;
		StateAssertion assertion = (StateAssertion) expression.getContainer();

		Object expressionNodeExecution = null;
		if (expressionAction instanceof Action)
			expressionNodeExecution = (ActionExecution) traceUtil.getExecution(expressionAction);
		if (expressionAction instanceof Activity) {
			expressionNodeExecution = (ActivityExecution) traceUtil.getExecution(expressionAction);
		}
		valueInstances = traceUtil.getValueInstances(expression.getPin(), expressionNodeExecution);

		if (valueInstances != null && valueInstances.size() > 0) {
			if (valueInstances.get(0).getOriginal().getValue() instanceof Object_) {
				setupSucessors(assertion.getOperator(), (ActionExecution) this.referenceActionExecution);
				setupPredecessors(assertion.getOperator(), (ActionExecution) this.referenceActionExecution);

				if (assertion.getOperator() == TemporalOperator.UNTIL) {
					list = predecessorSnapshots;
				}
				if (assertion.getOperator() == TemporalOperator.AFTER) {
					if (referenceActionExecution.getNode() != expressionAction && successorSnapshots.size() == 0 && predecessorSnapshots.size() > 0) {
						// we need to add last predecessor to successors
						// if the value was not changed after the referred
						// action
						successorSnapshots.add(predecessorSnapshots.get(0));
					}
					list = successorSnapshots;
				}
			} else {
				ActionExecution creatorExecution = (ActionExecution) valueInstances.get(0).getCreator();
				if (creatorExecution == null) {
					list.add(valueInstances.get(0).getOriginal());
				} else if (creatorExecution == referenceActionExecution || creatorExecution == untilActionExecution) {
					list.add(valueInstances.get(0).getOriginal());
				} else if (traceUtil.isAfter(creatorExecution, referenceActionExecution) && untilActionExecution == null)
					list.add(valueInstances.get(0).getOriginal());
				else if (traceUtil.isAfter(creatorExecution, referenceActionExecution) && !traceUtil.isAfter(creatorExecution, untilActionExecution)) {
					list.add(valueInstances.get(0).getOriginal());
				}
			}
		}
		return list;
	}

	private void initializePredecessorSnapshots(ActivityNodeExecution nodeExecution) {
		ActivityNodeExecution predecessor = nodeExecution.getChronologicalPredecessor();
		if (predecessor == null)
			return;
		if (untilActionExecution != null && untilActionExecution.getNode().name.equals(predecessor.getNode().name))
			return;
		if (predecessor instanceof ActionExecution) {
			for (Output predecesorsOutput : ((ActionExecution) predecessor).getOutputs()) {
				for (OutputValue outputValue : predecesorsOutput.getOutputValues()) {
					if (outputValue.getValueSnapshot() != null && valueInstances.contains(outputValue.getValueSnapshot().eContainer()))
						if (predecessorSnapshots.contains(outputValue.getValueSnapshot()) == false)
							predecessorSnapshots.add(outputValue.getValueSnapshot());
				}
			}
			for (Input predecesorsInput : ((ActionExecution) predecessor).getInputs()) {
				for (InputValue inputValue : predecesorsInput.getInputValues()) {
					if (inputValue.getValueSnapshot() != null && valueInstances.contains(inputValue.getValueSnapshot().eContainer()))
						if (predecessorSnapshots.contains(inputValue.getValueSnapshot()) == false)
							predecessorSnapshots.add(inputValue.getValueSnapshot());
				}
			}
		}
		initializePredecessorSnapshots(predecessor);
	}

	private void initializeSuccessorSnapshots(ActivityNodeExecution nodeExecution) {
		ActivityNodeExecution successor = nodeExecution.getChronologicalSuccessor();
		if (successor == null)
			return;
		if (untilActionExecution != null && untilActionExecution.getNode().name.equals(successor.getNode().name))
			return;
		if (successor instanceof ActionExecution) {
			for (Input successorsInput : ((ActionExecution) successor).getInputs()) {
				for (InputValue inputValue : successorsInput.getInputValues()) {
					if (inputValue.getValueSnapshot() != null && valueInstances.contains(inputValue.getValueSnapshot().eContainer()))
						if (successorSnapshots.contains(inputValue.getValueSnapshot()) == false)
							successorSnapshots.add(inputValue.getValueSnapshot());
				}
			}
			for (Output successorsOutput : ((ActionExecution) successor).getOutputs()) {
				for (OutputValue outputValue : successorsOutput.getOutputValues()) {
					if (outputValue.getValueSnapshot() != null && valueInstances.contains(outputValue.getValueSnapshot().eContainer()))
						if (successorSnapshots.contains(outputValue.getValueSnapshot()) == false)
							successorSnapshots.add(outputValue.getValueSnapshot());
				}
			}
		}
		initializeSuccessorSnapshots(successor);
	}

	private void setupPredecessors(TemporalOperator operator, ActionExecution nodeExecution) {
		for (Input input : nodeExecution.getInputs()) {
			if (input.getInputValues().size() == 0)
				continue;
			if (input.getInputValues().get(0).getValueSnapshot() == null)
				continue;
			if (operator == TemporalOperator.UNTIL) {
				for (InputValue inputValue : input.getInputValues()) {
					if (!predecessorSnapshots.contains(inputValue.getValueSnapshot())
							&& valueInstances.contains(inputValue.getValueSnapshot().getValueInstance()))
						predecessorSnapshots.add(inputValue.getValueSnapshot());
				}
			}
		}

		// adding snapshots of the valueInstance created
		// before and after the referred one
		if ((nodeExecution.getNode() instanceof CallBehaviorAction && !(((CallBehaviorAction) nodeExecution.getNode()).behavior instanceof OpaqueBehavior))
				|| nodeExecution.getNode() instanceof CallOperationAction) {
			ActivityNodeExecution lastNodeInBehavior = traceUtil.getLastExecutedNode(nodeExecution);
			initializePredecessorSnapshots(lastNodeInBehavior);
		} else {
			initializePredecessorSnapshots(nodeExecution);
		}
	}

	private void setupSucessors(TemporalOperator operator, ActionExecution nodeExecution) {
		for (Output output : nodeExecution.getOutputs()) {
			if (output.getOutputValues().size() == 0)
				continue;
			if (output.getOutputValues().get(0).getValueSnapshot() == null)
				continue;
			if (operator == TemporalOperator.AFTER)
				for (OutputValue outputValue : output.getOutputValues()) {
					if (!successorSnapshots.contains(outputValue.getValueSnapshot())
							&& valueInstances.contains(outputValue.getValueSnapshot().getValueInstance()))
						successorSnapshots.add(outputValue.getValueSnapshot());
				}
		}

		// adding snapshots of the valueInstance created
		// before and after the referred one
		if ((nodeExecution.getNode() instanceof CallBehaviorAction && !(((CallBehaviorAction) nodeExecution.getNode()).behavior instanceof OpaqueBehavior))
				|| nodeExecution.getNode() instanceof CallOperationAction) {
			ActivityNodeExecution lastNodeInBehavior = traceUtil.getLastExecutedNode(nodeExecution);
			initializeSuccessorSnapshots(lastNodeInBehavior);
		} else {
			initializeSuccessorSnapshots(nodeExecution);
		}
	}
}