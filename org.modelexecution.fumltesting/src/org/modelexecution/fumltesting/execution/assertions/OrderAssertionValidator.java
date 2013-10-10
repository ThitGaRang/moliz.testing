package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.testLang.NodeSpecification;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;
/**
 * Utility class for validation of order execution assertion.
 * @author Stefan Mijatov
 *
 */
public class OrderAssertionValidator {
	private List<ActivityNodeExecution> executedNodes;
	
	/**
	 * Check the order of executed nodes.
	 * @param parentNodeName
	 * @param specifiedOrder
	 * @param executedNodes
	 * @return
	 */
	public boolean checkOrder(String parentNodeName, List<NodeSpecification> specifiedOrder, List<ActivityNodeExecution> executedNodes){
		this.executedNodes = executedNodes;
		boolean result = compare(getTopNodes(parentNodeName, executedNodes), specifiedOrder);
		//result &= checkParallelism(specifiedOrder, executedNodes);
		AssertionPrinter.print(specifiedOrder, result);		
		return result;
	}
	
	/**
	 * Compares the specified order with executed nodes(for top nodes and each sub order).
	 * @param executedNodes
	 * @param nodeOrderList
	 * @return
	 */
	private boolean compare(List<ActivityNodeExecution> executedNodes, List<NodeSpecification> nodeOrderList){
		int executedNodeIndex = 0;;
		for(int i=0;i<nodeOrderList.size();i++){
			if(executedNodeIndex == -1){
				return false;
			}
			
			if(nodeOrderList.get(i).getNode() != null){
				if(nodeOrderList.get(i).getSubOrder() != null){
					OrderAssertionValidator validator = new OrderAssertionValidator();
					String activityName = null;
					if(nodeOrderList.get(i).getNode() instanceof CallBehaviorAction){
						activityName = ((CallBehaviorAction)nodeOrderList.get(i).getNode()).getBehavior().getName();
					}
					if(nodeOrderList.get(i).getNode() instanceof CallOperationAction){
						activityName = ((CallOperationAction)nodeOrderList.get(i).getNode()).getOperation().getMethods().get(0).getName();
					}
					List<ActivityNodeExecution> executedSubNodes = validator.getTopNodes(activityName, this.executedNodes);
					List<NodeSpecification> subNodesSpecification = nodeOrderList.get(i).getSubOrder().getNodes();
					boolean subOrderValid = validator.checkOrder(activityName, subNodesSpecification, executedSubNodes);
					if(subOrderValid == false){
						return false;
					}
				}
				if(executedNodeIndex >= executedNodes.size() || !nodeOrderList.get(i).getNode().getName().equals(executedNodes.get(executedNodeIndex).getNode().name)){
					return false;
				}				
				executedNodeIndex++;
			}
			if(nodeOrderList.get(i).getJoker() != null){
				if(nodeOrderList.get(i).getJoker().equals("_")){
					executedNodeIndex++;
				}
				if(nodeOrderList.get(i).getJoker().equals("*")){
					if(i < nodeOrderList.size()-1){
						if(nodeOrderList.get(i+1).getNode() == null){
							System.out.println("Use of subsequent star joker not allowed!");
							System.out.println("Assertion skipped!");
							return false;
						}
						String nextNode = nodeOrderList.get(i+1).getNode().getName();
						if(nodeOrderList.get(i+1).getNode() != null)executedNodeIndex = getExecutedNodeIndex(nextNode, executedNodes);
					}					
				}
			}
		}
		//in case that the number of specified nodes is smaller than number of executed ones, 
		//and that the last specified node is not *, assertion should fail
		if(executedNodeIndex < executedNodes.size()-1 && 
				(nodeOrderList.get(nodeOrderList.size()-1).getJoker()==null || !nodeOrderList.get(nodeOrderList.size()-1).getJoker().equals("*"))){
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the index of the executed node with the given name.
	 * @param name
	 * @param executedNodes
	 * @return
	 */
	private int getExecutedNodeIndex(String name, List<ActivityNodeExecution> executedNodes){
		for(int i=0;i<executedNodes.size();i++){
			if(executedNodes.get(i).getNode().name.equals(name))return i;
		}
		return -1;
	}
	
	/**
	 * Returns top nodes for the given parent node name. 
	 * Either activity or CallBehaviorAction can be a parent node.
	 * @param activityName
	 * @param executedNodes
	 * @return
	 */
	private List<ActivityNodeExecution> getTopNodes(String activityName, List<ActivityNodeExecution> executedNodes){
		List<ActivityNodeExecution> topNodes = new ArrayList<ActivityNodeExecution>();
		for(ActivityNodeExecution node: executedNodes ){
			if(((Activity)node.getNode().owner).name.equals(activityName) 
					&& (node.getNode() instanceof Action || node.getNode() instanceof InitialNode 
							|| node.getNode() instanceof ActivityFinalNode)){
				topNodes.add(node);
			}
		}
		return topNodes;
	}
}