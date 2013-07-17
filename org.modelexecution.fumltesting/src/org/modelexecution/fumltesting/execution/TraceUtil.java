package org.modelexecution.fumltesting.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.CallActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;

import fUML.Semantics.Classes.Kernel.Link;

/**
 * Utility class for managing the trace of execution.
 * @author Stefan Mijatov
 *
 */
public class TraceUtil {
	/** Trace of an activity execution. */
	private Trace trace;
	/** Used to generate flat list with all node executions, from main activity and all its children activities. */
	private List<ActivityNodeExecution> executedNodes;
	/** Flag indicating if the flat list of executed nodes has already been generated. */
	private boolean executedNodesListGenerated;
	/** Utility class for executing fUML activities. */
	private ActivityExecutor executor;
	
	public TraceUtil(int activityExecutionID, ActivityExecutor executor){
		trace = ExecutionContext.getInstance().getTrace(activityExecutionID);
		this.executor = executor;
		executedNodes = new ArrayList<ActivityNodeExecution>();
		executedNodesListGenerated = false;
		initializeExecutedNodesList(activityExecutionID);		
	}
	
	/** Generates flat list of all executed nodes, from main activity and all nested activities. */
	private void generateExecutionOrderList(List<ActivityNodeExecution> nodes){
		for(ActivityNodeExecution exe : nodes){
			executedNodes.add(exe);
			if(exe instanceof CallActionExecution){
				if(((CallActionExecution)exe).getCallee() != null)
					generateExecutionOrderList(((CallActionExecution)exe).getCallee().getNodeExecutions());
			}		
		}
	}
	
	/** Returns a flat list of all executed nodes, from main activity and any nested inside it.*/
	private List<ActivityNodeExecution> initializeExecutedNodesList(int activityExecutionID){
		ActivityExecution activityExecution = trace.getActivityExecutionByID(activityExecutionID);
		List<ActivityNodeExecution> nodeExecutions = activityExecution.getNodeExecutions();
		if(executedNodesListGenerated == false){
			generateExecutionOrderList(nodeExecutions);
			executedNodesListGenerated = true;
		}
		return executedNodes;
	}
	
	/** Gets a node execution for UML node that was converted to corresponding fUML element. */
	public Object getNodeExecution(Object node){
		if(node instanceof Action){
			for(ActivityNodeExecution execution: this.executedNodes){
				if(executor.getOriginal(execution.getNode()) == node)
					return execution;
			}
		}
		if(node instanceof Activity){
			for(ActivityExecution execution: this.trace.getActivityExecutions()){
				if(execution.getActivity().name.equals(((Activity) node).getName())){
					return execution;
				}
			}
		}
		return null;
	}
	
	/** Gets all links in the trace. */
	public ArrayList<ValueInstance> getAllLinks(){
		ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();
		for(ValueInstance instance: trace.getValueInstances()){
			if(instance.getRuntimeValue() != null && instance.getRuntimeValue() instanceof Link)
				links.add(instance);
		}
		return links;
	}
	
	public List<ActivityNodeExecution> getExecutedNodesList(){
		return executedNodes;
	}
}