/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.assertions;

import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.testlang.ActionReferencePoint;
import org.modelexecution.fumltesting.core.testlang.BooleanValue;
import org.modelexecution.fumltesting.core.testlang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.core.testlang.IntegerValue;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.NullValue;
import org.modelexecution.fumltesting.core.testlang.ObjectStateExpression;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.PropertyStateExpression;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.StringValue;
import org.modelexecution.fumltesting.core.testlang.TestCase;
import org.modelexecution.fumltesting.core.testlang.Value;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * Class for printing assertions, expressions, and test evaluation results to
 * console.
 * 
 * @author Stefan Mijatov
 * 
 */
public class AssertionPrinter {

	public void print(StateExpression stateExpression, boolean result) {
		System.out.println();
		ObjectNode pin = stateExpression.getPin();
		if (stateExpression instanceof ObjectStateExpression) {
			ObjectStateExpression expression = (ObjectStateExpression) stateExpression;
			String valueStr = null;
			if (expression.getValue() instanceof NullValue) {
				valueStr = "null";
			} else if (expression.getValue() instanceof IntegerValue) {
				valueStr = (((IntegerValue) expression.getValue()).getValue()).toString();
			} else if (expression.getValue() instanceof BooleanValue) {
				valueStr = String.valueOf(((BooleanValue) expression.getValue()).getValue());
			} else if (expression.getValue() instanceof StringValue) {
				valueStr = ((StringValue) expression.getValue()).getValue();
			} else if (expression.getValue() instanceof NullValue) {
				valueStr = "null";
			} else if (expression.getValue() instanceof ObjectValue) {
				valueStr = ((ObjectValue) expression.getValue()).getValue().getName();
			}
			System.out.println(pin.name + " " + expression.getOperator() + " " + valueStr);
			if (result)
				System.out.println("Assertion success!");
			else
				System.out.println("Assertion failed!");
		}
		if (stateExpression instanceof PropertyStateExpression) {
			PropertyStateExpression expression = (PropertyStateExpression) stateExpression;
			String valueStr = null;
			Property property = expression.getProperty();

			Value literal = expression.getValue();

			if (literal instanceof NullValue) {
				valueStr = "null";
			} else if (literal instanceof IntegerValue) {
				valueStr = ((IntegerValue) literal).getValue().toString();
			} else if (literal instanceof BooleanValue) {
				valueStr = String.valueOf(((BooleanValue) literal).getValue());
			} else if (literal instanceof StringValue) {
				valueStr = ((StringValue) literal).getValue();
			} else {
				valueStr = ((ObjectValue) expression.getValue()).getValue().getName();
			}
			System.out.println(pin.name + " -> " + property.name + " " + expression.getOperator() + " " + valueStr);
			if (result)
				System.out.println("Assertion success!");
			else
				System.out.println("Assertion failed!");
		}
	}

	public void printOrderSpecification(List<NodeSpecification> nodeOrder) {
		System.out.print("Order assertion: ");
		for (int i = 0; i < nodeOrder.size(); i++) {
			if (nodeOrder.get(i).getNode() != null) {
				ActivityNode node = nodeOrder.get(i).getNode();
				if (i == nodeOrder.size() - 1)
					System.out.print(node.name);
				else
					System.out.print(node.name + ", ");
			}
			if (nodeOrder.get(i).getJoker() != null) {
				if (i == nodeOrder.size() - 1)
					System.out.print(nodeOrder.get(i).getJoker());
				else
					System.out.print(nodeOrder.get(i).getJoker() + ", ");
			}
		}
		System.out.println();
	}

	public void print(List<NodeSpecification> nodeOrder, List<ActivityNodeExecution> executedNodes, boolean result) {
		System.out.print("Checked path: ");
		for (int i = 0; i < executedNodes.size(); i++) {
			if (executedNodes.get(i).getNode() != null) {
				if (i == executedNodes.size() - 1)
					System.out.print(executedNodes.get(i).getNode().name);
				else
					System.out.print(executedNodes.get(i).getNode().name + ", ");
			}
		}
		System.out.println();

		if (result)
			System.out.println("Assertion success!");
		else
			System.out.println("Assertion failed!");
	}

	public void print(List<ActivityNodeExecution> executions) {
		System.out.println();
		System.out.print("Executed nodes:");
		for (int i = 0; i < executions.size(); i++) {
			ActivityNodeExecution execution = executions.get(i);
			if (execution.getNode() instanceof Action || execution.getNode() instanceof InitialNode
					|| execution.getNode() instanceof ActivityFinalNode) {
				if (i == executions.size() - 1)
					System.out.print(execution.getNode().name);
				else
					System.out.print(execution.getNode().name + ", ");
			}
		}
		System.out.println();
	}

	public void printStateAssertion(StateAssertion assertion) {
		System.out.println();

		System.out.print("State assertion: " + assertion.getQuantifier() + " " + assertion.getOperator() + " ");
		if (assertion.getReferencePoint() instanceof ActionReferencePoint) {
			Action action = ((ActionReferencePoint) assertion.getReferencePoint()).getAction();
			System.out.print(action.name);
		}
		if (assertion.getReferencePoint() instanceof ConstraintReferencePoint) {
			String constraint = ((ConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName();
			System.out.print(constraint);
		}
		if (assertion.getUntilPoint() != null) {
			if (assertion.getUntilPoint() instanceof ActionReferencePoint) {
				Action action = ((ActionReferencePoint) assertion.getUntilPoint()).getAction();
				System.out.print(" until " + action.name);
			}
			if (assertion.getUntilPoint() instanceof ConstraintReferencePoint) {
				String constraint = ((ConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName();
				System.out.print(" until " + constraint);
			}
		}
		System.out.println();
	}

	public void print(TestCase testCase) {
		System.out.println();
		System.out.println("Running test: " + testCase.getName());
		System.out.println("Activity under test: " + (testCase.getActivityUnderTest()).name);
	}

	public void printStartEnd() {
		System.out.println("*********************");
	}
}