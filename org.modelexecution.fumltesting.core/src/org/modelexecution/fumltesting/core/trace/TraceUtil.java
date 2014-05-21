/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.trace;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.CallActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.core.exceptions.ActionNotExecutedException;
import org.modelexecution.fumltesting.core.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.core.execution.OclExecutor;
import org.modelexecution.fumltesting.core.parallelism.ExecutionPathFinder;
import org.modelexecution.fumltesting.core.sequence.Sequence;
import org.modelexecution.fumltesting.core.sequence.SequenceTrace;
import org.modelexecution.fumltesting.core.sequence.State;
import org.modelexecution.fumltesting.core.sequence.SequenceGenerator;
import org.modelexecution.fumltesting.core.testlang.ActionReferencePoint;
import org.modelexecution.fumltesting.core.testlang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.InputPin;
import fUML.Syntax.Actions.BasicActions.OutputPin;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;

/**
 * Utility class for managing the trace of execution.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TraceUtil {

	private Trace trace;
	private SequenceTrace sTrace;
	private SequenceGenerator sequenceGenerator;
	private ExecutionPathFinder pathFinder;
	private List<ActivityNodeExecution> executedNodes;
	private boolean executedNodesListGenerated;

	public TraceUtil(int activityExecutionID) {
		trace = ExecutionContext.getInstance().getTrace(activityExecutionID);
		executedNodes = new ArrayList<ActivityNodeExecution>();
		executedNodesListGenerated = false;
		getListOfAllExecutedNodes(activityExecutionID);

		sequenceGenerator = new SequenceGenerator();
		sTrace = sequenceGenerator.generateTrace(trace);

		pathFinder = new ExecutionPathFinder();
		pathFinder.init(trace.getActivityExecutionByID(activityExecutionID));
	}

	public Object getExecution(Object node) throws ActionNotExecutedException {
		String nodeName = "";
		if (node instanceof Action) {
			nodeName = ((Action) node).name;
			for (ActivityNodeExecution execution : this.executedNodes) {
				if (execution.getNode() == node)
					return execution;
			}
		}
		if (node instanceof Activity) {
			nodeName = ((Activity) node).name;
			for (ActivityExecution execution : this.trace.getActivityExecutions()) {
				if (execution.getActivity() == node) {
					return execution;
				}
			}
		}
		throw new ActionNotExecutedException("Action " + nodeName + " was never executed!");
	}

	public ValueInstance getValueInstance(ObjectNode node, Object nodeExecution) {
		ValueInstance instance = null;
		if (node instanceof OutputPin || node instanceof ActivityParameterNode) {
			if (nodeExecution instanceof ActionExecution) {
				for (Output output : ((ActionExecution) nodeExecution).getOutputs()) {
					if (output.getOutputPin().name.equals(node.name)) {
						if (output.getOutputValues().size() > 0)
							instance = (ValueInstance) output.getOutputValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
			if (nodeExecution instanceof ActivityExecution) {
				for (OutputParameterSetting output : ((ActivityExecution) nodeExecution).getActivityOutputs()) {
					if (output.getParameter().name.equals(node.name)) {
						if (output.getParameterValues().size() > 0)
							instance = (ValueInstance) output.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}

		if (node instanceof InputPin || node instanceof ActivityParameterNode) {
			if (nodeExecution instanceof ActionExecution) {
				for (Input input : ((ActionExecution) nodeExecution).getInputs()) {
					if (input.getInputPin().name.equals(node.name)) {
						if (input.getInputValues().size() > 0)
							instance = (ValueInstance) input.getInputValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
			if (nodeExecution instanceof ActivityExecution) {
				for (InputParameterSetting input : ((ActivityExecution) nodeExecution).getActivityInputs()) {
					if (input.getParameter().name.equals(node.name)) {
						if (input.getParameterValues().size() > 0)
							instance = (ValueInstance) input.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}
		return instance;
	}

	public List<State> getStates(Object stateAssertion) throws ConstraintNotFoundException, ActionNotExecutedException {
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

	public ActivityNodeExecution getReferenceActionExecution(StateAssertion assertion) throws ConstraintNotFoundException, ActionNotExecutedException {
		ActivityNodeExecution referenceActionExecution = null;
		Activity activityUnderTest = assertion.getContainer().getActivityUnderTest();

		if (assertion.getReferencePoint() instanceof ActionReferencePoint)
			referenceActionExecution = (ActivityNodeExecution) getExecution(((ActionReferencePoint) assertion.getReferencePoint()).getAction());

		if (assertion.getReferencePoint() instanceof ConstraintReferencePoint) {
			String constraintRefPoint = ((ConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName();
			for (Sequence sequence : sTrace.getSequences()) {
				if (sequence.getActivityExecution().getActivity() == activityUnderTest) {
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

	public ActivityNodeExecution getUntilActionExecution(StateAssertion assertion) throws ConstraintNotFoundException, ActionNotExecutedException {
		ActivityNodeExecution untilActionExecution = null;
		Activity activityUnderTest = assertion.getContainer().getActivityUnderTest();

		if (assertion.getUntilPoint() != null && assertion.getUntilPoint() instanceof ActionReferencePoint)
			untilActionExecution = (ActivityNodeExecution) getExecution(((ActionReferencePoint) assertion.getUntilPoint()).getAction());

		if (assertion.getUntilPoint() instanceof ConstraintReferencePoint) {
			String constraintUntilPoint = ((ConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName();
			for (Sequence sequence : sTrace.getSequences()) {
				if (sequence.getActivityExecution().getActivity() == activityUnderTest) {
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

	public fUML.Syntax.Activities.IntermediateActivities.ActivityNode getLastExecutedAction() {
		ActivityNodeExecution lastNodeExecution = trace.getLastActivityNodeExecution();
		ActivityNodeExecution lastActionExecution = lastAction(lastNodeExecution);
		return lastActionExecution.getNode();
	}

	public int getActivityExecutionID(String name) {
		int id = -1;
		for (ActivityExecution execution : trace.getActivityExecutions()) {
			if (execution.getActivity().name.equals(name))
				return execution.getActivityExecutionID();
		}
		return id;
	}

	public boolean isAfter(ActivityNodeExecution execution1, ActivityNodeExecution execution2) {
		if (execution2.getChronologicalSuccessor() != null) {
			if (execution2.getChronologicalSuccessor() == execution1)
				return true;
			else
				return isAfter(execution1, execution2.getChronologicalSuccessor());
		}
		return false;
	}

	public ArrayList<ArrayList<ActivityNodeExecution>> getAllPaths() {
		return pathFinder.getAllPaths();
	}

	public ActivityNodeExecution getLastExecutedNode(ActivityNodeExecution nodeExecution) {
		ActivityNodeList nodes = nodeExecution.getNode().activity.node;
		return getLastNode(nodeExecution, nodes);
	}

	public ArrayList<ValueInstance> getAllLinks() {
		ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();
		for (ValueInstance instance : trace.getValueInstances()) {
			if (instance.getRuntimeValue() != null && instance.getRuntimeValue() instanceof Link)
				links.add(instance);
		}
		return links;
	}

	private ActivityNodeExecution getLastNode(ActivityNodeExecution nodeExecution, ActivityNodeList nodeList) {
		fUML.Syntax.Activities.IntermediateActivities.ActivityNode successor = nodeExecution.getChronologicalSuccessor().getNode();
		fUML.Syntax.Activities.IntermediateActivities.ActivityNode successorOfSuccessor = null;

		if (nodeExecution.getChronologicalSuccessor().getChronologicalSuccessor() != null) {
			successorOfSuccessor = nodeExecution.getChronologicalSuccessor().getChronologicalSuccessor().getNode();
		}

		if (!nodeList.contains(successor) && (nodeList.contains(successorOfSuccessor) || successorOfSuccessor == null)) {
			return nodeExecution.getChronologicalSuccessor();
		}
		return getLastNode(nodeExecution.getChronologicalSuccessor(), nodeList);
	}

	/**
	 * Returns a flat list of all executed nodes, from main activity and any
	 * nested inside it.
	 */
	private List<ActivityNodeExecution> getListOfAllExecutedNodes(int activityExecutionID) {
		ActivityExecution activityExecution = trace.getActivityExecutionByID(activityExecutionID);
		List<ActivityNodeExecution> nodeExecutions = activityExecution.getNodeExecutions();
		if (executedNodesListGenerated == false) {
			generateExecutionOrderList(nodeExecutions);
			executedNodesListGenerated = true;
		}
		return executedNodes;
	}

	private void generateExecutionOrderList(List<ActivityNodeExecution> nodes) {
		for (ActivityNodeExecution exe : nodes) {
			executedNodes.add(exe);
			if (exe instanceof CallActionExecution) {
				if (((CallActionExecution) exe).getCallee() != null)
					generateExecutionOrderList(((CallActionExecution) exe).getCallee().getNodeExecutions());
			}
		}
	}

	private ActivityNodeExecution lastAction(ActivityNodeExecution lastNode) {
		if (lastNode.getNode() instanceof fUML.Syntax.Actions.BasicActions.Action)
			return lastNode;
		if (lastNode.getChronologicalPredecessor() == null) {
			System.out.println("No action in the trace found!");
			return null;
		}
		return lastAction(lastNode.getChronologicalPredecessor());
	}

	private ActivityNodeExecution findLastCreator(ActivityNodeExecution nodeExecution, Sequence sequence) {
		if (sequence.hasCreatedState(nodeExecution))
			return nodeExecution;
		else
			return findLastCreator(nodeExecution.getChronologicalPredecessor(), sequence);
	}
}