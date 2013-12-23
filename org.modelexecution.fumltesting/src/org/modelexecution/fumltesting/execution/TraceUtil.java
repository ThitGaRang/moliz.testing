package org.modelexecution.fumltesting.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.CallActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumltesting.parallelism.ExecutionPathFinder;
import org.modelexecution.fumltesting.sequence.Sequence;
import org.modelexecution.fumltesting.sequence.SequenceTrace;
import org.modelexecution.fumltesting.sequence.State;
import org.modelexecution.fumltesting.sequence.execution.SequenceGenerator;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;

import fUML.Semantics.Classes.Kernel.Link;

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
	/** Utility class for executing fUML activities. */
	private ActivityExecutor executor;

	public TraceUtil(int activityExecutionID, ActivityExecutor executor) {
		trace = ExecutionContext.getInstance().getTrace(activityExecutionID);
		this.executor = executor;
		executedNodes = new ArrayList<ActivityNodeExecution>();
		executedNodesListGenerated = false;
		initializeExecutedNodesList(activityExecutionID);

		sequenceGenerator = new SequenceGenerator();
		sTrace = sequenceGenerator.generateTrace(trace);

		pathFinder = new ExecutionPathFinder();
		pathFinder.init(trace.getActivityExecutionByID(activityExecutionID));
		pathFinder.printPaths();
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
				if (executor.getOriginal(execution.getNode()) == node)
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
		if (execution1.getChronologicalSuccessor() != null) {
			if (execution1.getChronologicalSuccessor() == execution2)
				return true;
			else
				return isAfter(execution1.getChronologicalSuccessor(), execution2);
		}
		return false;
	}

	public ActivityNode getLastExecutedAction() {
		ActivityNodeExecution lastNodeExecution = trace.getLastActivityNodeExecution();
		ActivityNodeExecution lastActionExecution = lastAction(lastNodeExecution);
		ActivityNode lastAction = (ActivityNode) executor.getOriginal(lastActionExecution.getNode());
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

	public List<State> getStates(TemporalQuantifier quantifier, TemporalOperator operator, ActivityNodeExecution nodeExecution) {
		List<State> states = new ArrayList<State>();
		for (Sequence sequence : sTrace.getSequences()) {
			if (sequence.getActivityExecution() == nodeExecution.getActivityExecution()) {
				for (State state : sequence.getStates()) {
					if (state.getNodeExecution() == nodeExecution) {
						switch (operator) {
						case AFTER:
							switch (quantifier) {
							case ALWAYS:
								while (state.getSuccessor() != null) {
									states.add(state.getSuccessor());
									state = state.getSuccessor();
								}
								break;
							case EXACTLY:
								states.add(state.getSuccessor());
								break;
							}
						case BEFORE:
							switch (quantifier) {
							case ALWAYS:
								while (state.getPredecessor() != null) {
									states.add(state.getPredecessor());
									state = state.getPredecessor();
								}
								break;
							case EXACTLY:
								states.add(state.getPredecessor());
								break;
							}
						}
					}
				}
			}
		}
		return states;
	}
}