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
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.exceptions.ActionNotExecutedException;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.TemporalOperator;

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

	private ValueInstance valueInstance;
	private ActivityNodeExecution referenceActionExecution;
	private ActivityNodeExecution untilActionExecution;
	private TraceUtil traceUtil;

	public SnapshotUtil(TraceUtil traceUtil) {
		this.traceUtil = traceUtil;
		predecessorSnapshots = new ArrayList<ValueSnapshot>();
		successorSnapshots = new ArrayList<ValueSnapshot>();
	}

	public ArrayList<ValueSnapshot> getRelevantSnapshots(StateExpression expression, ActivityNodeExecution referenceActionExecution,
			ActivityNodeExecution untilActionExecution) throws ActionNotExecutedException{
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
		valueInstance = traceUtil.getValueInstance(expression.getPin(), expressionNodeExecution);

		setupSucessors(assertion.getOperator(), (ActionExecution) this.referenceActionExecution);
		setupPredecessors(assertion.getOperator(), (ActionExecution) this.referenceActionExecution);

		if (assertion.getOperator() == TemporalOperator.UNTIL) {
			list = predecessorSnapshots;
		}
		if (assertion.getOperator() == TemporalOperator.AFTER) {
			if (referenceActionExecution.getNode() != expressionAction && successorSnapshots.size() == 0 && predecessorSnapshots.size() > 0) {
				// we need to add last predecessor to successors
				// if the value was not changed after the referred action
				successorSnapshots.add(predecessorSnapshots.get(0));
			}
			list = successorSnapshots;
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
				if (predecesorsOutput.getOutputValues().get(0).getValueSnapshot() != null
						&& predecesorsOutput.getOutputValues().get(0).getValueSnapshot().eContainer() == valueInstance)
					if (predecessorSnapshots.contains(predecesorsOutput.getOutputValues().get(0).getValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsOutput.getOutputValues().get(0).getValueSnapshot());
			}
			for (Input predecesorsInput : ((ActionExecution) predecessor).getInputs()) {
				if (predecesorsInput.getInputValues().get(0).getValueSnapshot() != null
						&& predecesorsInput.getInputValues().get(0).getValueSnapshot().eContainer() == valueInstance)
					if (predecessorSnapshots.contains(predecesorsInput.getInputValues().get(0).getValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsInput.getInputValues().get(0).getValueSnapshot());
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
				if (successorsInput.getInputValues().get(0).getValueSnapshot() != null
						&& successorsInput.getInputValues().get(0).getValueSnapshot().eContainer() == valueInstance)
					if (successorSnapshots.contains(successorsInput.getInputValues().get(0).getValueSnapshot()) == false)
						successorSnapshots.add(successorsInput.getInputValues().get(0).getValueSnapshot());
			}
			for (Output successorsOutput : ((ActionExecution) successor).getOutputs()) {
				if (successorsOutput.getOutputValues().get(0).getValueSnapshot() != null
						&& successorsOutput.getOutputValues().get(0).getValueSnapshot().eContainer() == valueInstance)
					if (successorSnapshots.contains(successorsOutput.getOutputValues().get(0).getValueSnapshot()) == false)
						successorSnapshots.add(successorsOutput.getOutputValues().get(0).getValueSnapshot());
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
			ValueInstance referredValueInstance = (ValueInstance) input.getInputValues().get(0).getValueSnapshot().eContainer();
			if (referredValueInstance == valueInstance && operator == TemporalOperator.UNTIL) {
				if (predecessorSnapshots.contains(input.getInputValues().get(0).getValueSnapshot()))
					predecessorSnapshots.add(input.getInputValues().get(0).getValueSnapshot());
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
			ValueInstance referredValueInstance = (ValueInstance) output.getOutputValues().get(0).getValueSnapshot().eContainer();
			if (referredValueInstance == valueInstance && operator == TemporalOperator.AFTER)
				if (successorSnapshots.contains(output.getOutputValues().get(0).getValueSnapshot()) == false)
					successorSnapshots.add(output.getOutputValues().get(0).getValueSnapshot());
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