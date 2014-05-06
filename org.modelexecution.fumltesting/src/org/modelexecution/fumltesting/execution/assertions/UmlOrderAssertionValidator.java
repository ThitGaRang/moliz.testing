/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.results.PathCheckResult;
import org.modelexecution.fumltesting.core.trace.TraceUtil;
import org.modelexecution.fumltesting.execution.core.assertions.ConvertedNodeSpecification;
import org.modelexecution.fumltesting.execution.core.assertions.OrderAssertionValidator;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.trace.UmlTraceUtil;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;

/**
 * Utility class for validation of order execution assertion.
 * 
 * @author Stefan Mijatov
 * 
 */
public class UmlOrderAssertionValidator extends OrderAssertionValidator {

	public UmlOrderAssertionValidator(TraceUtil traceUtil) {
		super(traceUtil);
	}

	@Override
	public OrderAssertionResult checkOrder(Object orderAssertion) {
		OrderAssertion assertion = (OrderAssertion) orderAssertion;
		OrderAssertionResult result = new OrderAssertionResult(((OrderAssertion) assertion).getOrder());
		result.setAssertion(assertion);

		List<NodeSpecification> nodeOrder = ((OrderAssertion) assertion).getOrder().getNodes();
		Activity main = (Activity) traceUtil.getModelConverter().convertElement(((TestCase) assertion.eContainer()).getActivityUnderTest());

		AssertionPrinter.printOrderSpecification(nodeOrder);
		System.out.println("Checking order assertion against " + traceUtil.getAllPaths().size() + " generated paths..");

		for (ArrayList<ActivityNodeExecution> path : traceUtil.getAllPaths()) {
			PathCheckResult pathCheckResult = new PathCheckResult(path);
			List<ConvertedNodeSpecification> convertedNodeOrder = convertNodeOrder(nodeOrder);

			boolean validationResult = compare(getTopNodes(main, path), convertedNodeOrder);

			pathCheckResult.setValidationResult(validationResult);
			result.addPathCheckResult(pathCheckResult);
		}

		for (NodeSpecification nodeSpecification : nodeOrder) {
			if (nodeSpecification.getSubOrder() != null) {
				Activity parent = null;

				if (nodeSpecification.getNode() instanceof CallBehaviorAction) {
					parent = (Activity) traceUtil.getModelConverter()
							.convertElement(((CallBehaviorAction) nodeSpecification.getNode()).getBehavior());
				}
				if (nodeSpecification.getNode() instanceof CallOperationAction) {
					parent = (Activity) traceUtil.getModelConverter().convertElement(
							((CallOperationAction) nodeSpecification.getNode()).getOperation().getMethods().get(0));
				}

				int activityExecutionID = traceUtil.getActivityExecutionID(parent.name);
				System.out.println("Checking sub-order: ");
				AssertionPrinter.printOrderSpecification(nodeSpecification.getSubOrder().getNodes());

				OrderAssertionResult subOrderResult = new OrderAssertionResult(nodeSpecification.getSubOrder());
				subOrderResult.setAssertion(assertion);

				TraceUtil subTraceUtil = new UmlTraceUtil(activityExecutionID, traceUtil.getModelConverter());
				System.out.println("Checking sub-order assertion against " + subTraceUtil.getAllPaths().size() + " generated paths..");

				for (ArrayList<ActivityNodeExecution> path : subTraceUtil.getAllPaths()) {
					PathCheckResult pathCheckResult = new PathCheckResult(path);
					List<ConvertedNodeSpecification> convertedNodeOrder = convertNodeOrder(nodeSpecification.getSubOrder().getNodes());
					boolean validationResult = compare(getTopNodes(parent, path), convertedNodeOrder);
					pathCheckResult.setValidationResult(validationResult);
					subOrderResult.addPathCheckResult(pathCheckResult);
				}
				result.addSubOrderAssertionResult(subOrderResult);
			}
		}
		return result;
	}

	@Override
	public List<ConvertedNodeSpecification> convertNodeOrder(List<? extends Object> nodeOrder) {
		List<ConvertedNodeSpecification> convertedNodeOrder = new ArrayList<ConvertedNodeSpecification>();
		for (Object objectNode : nodeOrder) {
			NodeSpecification node = (NodeSpecification) objectNode;
			if (node.getJoker() != null) {
				ConvertedNodeSpecification convertedNode = new ConvertedNodeSpecification();
				convertedNode.setJoker(node.getJoker());
				convertedNodeOrder.add(convertedNode);
			} else if (node.getNode() != null) {
				ConvertedNodeSpecification convertedNode = new ConvertedNodeSpecification();
				convertedNode.setNode((ActivityNode) traceUtil.getModelConverter().convertElement(node.getNode()));
				convertedNodeOrder.add(convertedNode);
			} else {
				System.out.println("Node specification error! Either joker or node must be set!");
			}
		}
		return convertedNodeOrder;
	}
}