/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.core.convert.ModelConverter;
import org.modelexecution.fumltesting.core.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.core.execution.OclExecutor;
import org.modelexecution.fumltesting.core.sequence.Sequence;
import org.modelexecution.fumltesting.core.sequence.State;
import org.modelexecution.fumltesting.core.trace.TraceUtil;
import org.modelexecution.fumltesting.testLang.ActionReferencePoint;
import org.modelexecution.fumltesting.testLang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;

/**
 * Utility class for managing the trace of execution.
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class UmlTraceUtil extends TraceUtil {

	public UmlTraceUtil(int activityExecutionID, ModelConverter modelConverter) {
		super(activityExecutionID, modelConverter);
	}

	@Override
	public Object getExecution(Object node) {
		if (node instanceof Action) {
			for (ActivityNodeExecution execution : this.executedNodes) {
				if (modelConverter.getOriginal(execution.getNode()) == node)
					return execution;
			}
		}
		if (node instanceof Activity) {
			for (ActivityExecution execution : this.trace.getActivityExecutions()) {
				if (execution.getActivity().name.equals(((Activity) node).getName())) {
					return execution;
				}
			}
		}
		return null;
	}

	@Override
	public ValueInstance getValueInstance(Object nodeObject, Object nodeExecution) {
		ObjectNode node = (ObjectNode) nodeObject;
		ValueInstance instance = null;
		if (node instanceof OutputPin || node instanceof ActivityParameterNode) {
			if (nodeExecution instanceof ActionExecution) {
				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					if (output.getOutputPin().name.equals(node.getName())) {
						if (output.getOutputValues().size() > 0)
							instance = (ValueInstance) output.getOutputValues().get(0).getOutputValueSnapshot().eContainer();
					}
				}
			}
			if (nodeExecution instanceof ActivityExecution) {
				for (OutputParameterSetting output : ((ActivityExecution) nodeExecution).getActivityOutputs()) {
					if (output.getParameter().name.equals(node.getName())) {
						if (output.getParameterValues().size() > 0)
							instance = (ValueInstance) output.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}

		if (node instanceof InputPin || node instanceof ActivityParameterNode) {
			if (nodeExecution instanceof ActionExecution) {
				for (Input input : ((ActionExecution) nodeExecution).getInputs()) {
					if (input.getInputPin().name.equals(node.getName())) {
						if (input.getInputValues().size() > 0)
							instance = (ValueInstance) input.getInputValues().get(0).getInputValueSnapshot().eContainer();
					}
				}
			}
			if (nodeExecution instanceof ActivityExecution) {
				for (InputParameterSetting input : ((ActivityExecution) nodeExecution).getActivityInputs()) {
					if (input.getParameter().name.equals(node.getName())) {
						if (input.getParameterValues().size() > 0)
							instance = (ValueInstance) input.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}
		return instance;
	}

	@Override
	public List<State> getStates(Object stateAssertion) throws ConstraintNotFoundException {
		StateAssertion assertion = (StateAssertion) stateAssertion;
		ActivityNodeExecution referredActionExecution = getReferenceActionExecution(assertion);
		ActivityNodeExecution untilActionExecution = getUntilActionExecution(assertion);

		List<State> states = new ArrayList<State>();
		for (Sequence sequence : sTrace.getSequences()) {
			if (sequence.getActivityExecution() == referredActionExecution.getActivityExecution()) {
				referredActionExecution = findLastCreator(referredActionExecution, sequence);
				for (State state : sequence.getStates()) {
					if (state.getNodeExecution() == referredActionExecution) {
						switch (assertion.getOperator()) {
						case AFTER:
							while (state != null) {
								if (untilActionExecution != null && untilActionExecution == state.getNodeExecution()) {
									break;
								}
								states.add(state);
								state = state.getSuccessor();
							}
							break;
						case UNTIL:
							while (state.getPredecessor() != null) {
								states.add(state.getPredecessor());
								state = state.getPredecessor();
							}
							break;
						}
					}
				}
			}
		}
		return states;
	}

	@Override
	public ActivityNodeExecution getReferenceActionExecution(Object stateAssertion) throws ConstraintNotFoundException {
		ActivityNodeExecution referenceActionExecution = null;
		StateAssertion assertion = (StateAssertion) stateAssertion;
		Activity activityUnderTest = ((TestCase) assertion.eContainer()).getActivityUnderTest();
		fUML.Syntax.Activities.IntermediateActivities.Activity convertedActivity = (fUML.Syntax.Activities.IntermediateActivities.Activity) modelConverter
				.convertElement(activityUnderTest);

		if (assertion.getReferencePoint() instanceof ActionReferencePoint)
			referenceActionExecution = (ActivityNodeExecution) getExecution(((ActionReferencePoint) assertion.getReferencePoint()).getAction());

		if (assertion.getReferencePoint() instanceof ConstraintReferencePoint) {
			String constraintRefPoint = ((XStringLiteral) ((ConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName()).getValue();
			for (Sequence sequence : sTrace.getSequences()) {
				if (sequence.getActivityExecution().getActivity() == convertedActivity) {
					for (State state : sequence.getStates()) {
						boolean result = OclExecutor.getInstance().checkConstraint(constraintRefPoint, null, state);
						if (result) {
							referenceActionExecution = state.getNodeExecution();
							break;
						}
					}
				}
			}
		}
		return referenceActionExecution;
	}

	@Override
	public ActivityNodeExecution getUntilActionExecution(Object stateAssertion) throws ConstraintNotFoundException {
		ActivityNodeExecution untilActionExecution = null;
		StateAssertion assertion = (StateAssertion) stateAssertion;
		Activity activityUnderTest = ((TestCase) assertion.eContainer()).getActivityUnderTest();
		fUML.Syntax.Activities.IntermediateActivities.Activity convertedActivity = (fUML.Syntax.Activities.IntermediateActivities.Activity) modelConverter
				.convertElement(activityUnderTest);

		if (assertion.getUntilPoint() != null && assertion.getUntilPoint() instanceof ActionReferencePoint)
			untilActionExecution = (ActivityNodeExecution) getExecution(((ActionReferencePoint) assertion.getUntilPoint()).getAction());

		if (assertion.getUntilPoint() instanceof ConstraintReferencePoint) {
			String constraintUntilPoint = ((XStringLiteral) ((ConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName()).getValue();
			for (Sequence sequence : sTrace.getSequences()) {
				if (sequence.getActivityExecution().getActivity() == convertedActivity) {
					for (State state : sequence.getStates()) {
						if (isAfter(getReferenceActionExecution(assertion), state.getNodeExecution()))
							continue;
						boolean result = OclExecutor.getInstance().checkConstraint(constraintUntilPoint, null, state);
						if (result) {
							untilActionExecution = state.getNodeExecution();
							break;
						}
					}
				}
			}
		}
		return untilActionExecution;
	}
}