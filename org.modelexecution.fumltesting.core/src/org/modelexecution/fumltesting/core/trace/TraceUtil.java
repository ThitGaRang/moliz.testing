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
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.CallActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.core.convert.ModelConverter;
import org.modelexecution.fumltesting.core.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.core.parallelism.ExecutionPathFinder;
import org.modelexecution.fumltesting.core.sequence.Sequence;
import org.modelexecution.fumltesting.core.sequence.SequenceTrace;
import org.modelexecution.fumltesting.core.sequence.State;
import org.modelexecution.fumltesting.core.sequence.util.SequenceGenerator;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList;

/**
 * @author Stefan Mijatov
 * 
 */
public abstract class TraceUtil {

	protected Trace trace;
	protected ModelConverter modelConverter;
	protected SequenceTrace sTrace;
	protected SequenceGenerator sequenceGenerator;
	protected ExecutionPathFinder pathFinder;
	protected List<ActivityNodeExecution> executedNodes;
	protected boolean executedNodesListGenerated;

	public TraceUtil(int activityExecutionID, ModelConverter modelConverter) {
		trace = ExecutionContext.getInstance().getTrace(activityExecutionID);
		this.modelConverter = modelConverter;
		executedNodes = new ArrayList<ActivityNodeExecution>();
		executedNodesListGenerated = false;
		getListOfAllExecutedNodes(activityExecutionID);

		sequenceGenerator = new SequenceGenerator();
		sTrace = sequenceGenerator.generateTrace(trace);

		pathFinder = new ExecutionPathFinder();
		pathFinder.init(trace.getActivityExecutionByID(activityExecutionID));
	}

	public abstract Object getExecution(Object node);

	public abstract ValueInstance getValueInstance(Object node, Object nodeExecution);

	public abstract List<State> getStates(Object stateAssertion) throws ConstraintNotFoundException;

	public abstract ActivityNodeExecution getReferenceActionExecution(Object stateAssertion) throws ConstraintNotFoundException;

	public abstract ActivityNodeExecution getUntilActionExecution(Object stateAssertion) throws ConstraintNotFoundException;

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

	public ModelConverter getModelConverter() {
		return modelConverter;
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

	protected ActivityNodeExecution lastAction(ActivityNodeExecution lastNode) {
		if (lastNode.getNode() instanceof fUML.Syntax.Actions.BasicActions.Action)
			return lastNode;
		if (lastNode.getChronologicalPredecessor() == null) {
			System.out.println("No action in the trace found!");
			return null;
		}
		return lastAction(lastNode.getChronologicalPredecessor());
	}

	protected ActivityNodeExecution findLastCreator(ActivityNodeExecution nodeExecution, Sequence sequence) {
		if (sequence.hasCreatedState(nodeExecution))
			return nodeExecution;
		else
			return findLastCreator(nodeExecution.getChronologicalPredecessor(), sequence);
	}
}