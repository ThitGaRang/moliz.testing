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
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OutputPin;
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
import org.modelexecution.fumltesting.convert.UmlConverter;
import org.modelexecution.fumltesting.parallelism.ExecutionPathFinder;
import org.modelexecution.fumltesting.sequence.Sequence;
import org.modelexecution.fumltesting.sequence.SequenceTrace;
import org.modelexecution.fumltesting.sequence.State;
import org.modelexecution.fumltesting.sequence.execution.SequenceGenerator;
import org.modelexecution.fumltesting.testLang.ActionReferencePoint;
import org.modelexecution.fumltesting.testLang.StateAssertion;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList;

/**
 * Utility class for managing the trace of execution.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TraceUtil {
	/** Trace of an activity execution. */
	private Trace trace;
	/** Trace as a sequence of snapshots. */
	private SequenceTrace sTrace;
	/** Sequence trace generator utility class. */
	private SequenceGenerator sequenceGenerator;
	/** Execution paths utility class. */
	private ExecutionPathFinder pathFinder;
	/**
	 * Used to generate flat list with all node executions, from main activity
	 * and all its children activities.
	 */
	private List<ActivityNodeExecution> executedNodes;
	/**
	 * Flag indicating if the flat list of executed nodes has already been
	 * generated.
	 */
	private boolean executedNodesListGenerated;

	public TraceUtil(int activityExecutionID) {
		trace = ExecutionContext.getInstance().getTrace(activityExecutionID);
		executedNodes = new ArrayList<ActivityNodeExecution>();
		executedNodesListGenerated = false;
		initializeExecutedNodesList(activityExecutionID);

		sequenceGenerator = new SequenceGenerator();
		sTrace = sequenceGenerator.generateTrace(trace);

		pathFinder = new ExecutionPathFinder();
		pathFinder.init(trace.getActivityExecutionByID(activityExecutionID));
	}

	/** Returns ID of the activity execution by the name of the activity itself. */
	public int getActivityExecutionID(String name) {
		int id = -1;
		for (ActivityExecution execution : trace.getActivityExecutions()) {
			if (execution.getActivity().name.equals(name))
				return execution.getActivityExecutionID();
		}
		return id;
	}

	/**
	 * Generates flat list of all executed nodes, from main activity and all
	 * nested activities.
	 */
	private void generateExecutionOrderList(List<ActivityNodeExecution> nodes) {
		for (ActivityNodeExecution exe : nodes) {
			executedNodes.add(exe);
			if (exe instanceof CallActionExecution) {
				if (((CallActionExecution) exe).getCallee() != null)
					generateExecutionOrderList(((CallActionExecution) exe).getCallee().getNodeExecutions());
			}
		}
	}

	/**
	 * Returns a flat list of all executed nodes, from main activity and any
	 * nested inside it.
	 */
	private List<ActivityNodeExecution> initializeExecutedNodesList(int activityExecutionID) {
		ActivityExecution activityExecution = trace.getActivityExecutionByID(activityExecutionID);
		List<ActivityNodeExecution> nodeExecutions = activityExecution.getNodeExecutions();
		if (executedNodesListGenerated == false) {
			generateExecutionOrderList(nodeExecutions);
			executedNodesListGenerated = true;
		}
		return executedNodes;
	}

	/**
	 * Gets a node execution for UML node that was converted to corresponding
	 * fUML element.
	 */
	public Object getExecution(Object node) {
		if (node instanceof Action) {
			for (ActivityNodeExecution execution : this.executedNodes) {
				if (UmlConverter.getInstance().getOriginal(execution.getNode()) == node)
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

	/**
	 * Getting the value instance from the trace based on the input pin.
	 * 
	 * @param expression
	 */
	public ValueInstance getValueInstance(ObjectNode node, Object nodeExecution) {
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

	/** Gets all links in the trace. */
	public ArrayList<ValueInstance> getAllLinks() {
		ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();
		for (ValueInstance instance : trace.getValueInstances()) {
			if (instance.getRuntimeValue() != null && instance.getRuntimeValue() instanceof Link)
				links.add(instance);
		}
		return links;
	}

	public List<ActivityNodeExecution> getExecutedNodesList() {
		return executedNodes;
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

	public ActivityNode getLastExecutedAction() {
		ActivityNodeExecution lastNodeExecution = trace.getLastActivityNodeExecution();
		ActivityNodeExecution lastActionExecution = lastAction(lastNodeExecution);
		ActivityNode lastAction = (ActivityNode) UmlConverter.getInstance().getOriginal(lastActionExecution.getNode());
		return lastAction;
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

	public List<State> getStates(StateAssertion assertion) {
		Action referredAction = null;
		if (assertion.getReferencePoint() instanceof ActionReferencePoint)
			referredAction = ((ActionReferencePoint) assertion.getReferencePoint()).getAction();

		ActionExecution nodeExecution = (ActionExecution) getExecution(referredAction);

		List<State> states = new ArrayList<State>();
		for (Sequence sequence : sTrace.getSequences()) {
			if (sequence.getActivityExecution() == nodeExecution.getActivityExecution()) {
				for (State state : sequence.getStates()) {
					if (state.getNodeExecution() == nodeExecution) {
						switch (assertion.getOperator()) {
						case AFTER:
							while (state != null) {
								if (assertion.getUntilPoint() != null && assertion.getUntilPoint() instanceof ActionReferencePoint) {
									Action untilAction = ((ActionReferencePoint) assertion.getUntilPoint()).getAction();
									if (untilAction == UmlConverter.getInstance().getOriginal(state.getNodeExecution().getNode()))
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

	public ArrayList<ArrayList<ActivityNodeExecution>> getAllPaths() {
		return pathFinder.getAllPaths();
	}

	public ActivityNodeExecution getLastExecutedNode(ActivityNodeExecution nodeExecution) {
		ActivityNodeList nodes = nodeExecution.getNode().activity.node;
		return getLastNode(nodeExecution, nodes);
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
}