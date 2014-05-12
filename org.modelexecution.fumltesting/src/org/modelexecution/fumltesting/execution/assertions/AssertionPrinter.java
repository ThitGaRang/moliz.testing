/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.List;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.convert.ModelConverter;
import org.modelexecution.fumltesting.testLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLConstraintReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.testLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.testLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.testLang.UMLObjectValue;
import org.modelexecution.fumltesting.testLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.testLang.UMLSimpleValue;
import org.modelexecution.fumltesting.testLang.UMLStateAssertion;
import org.modelexecution.fumltesting.testLang.UMLStateExpression;
import org.modelexecution.fumltesting.testLang.UMLTestCase;

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
@SuppressWarnings("restriction")
public class AssertionPrinter {

	private ModelConverter modelConverter;

	public AssertionPrinter(ModelConverter modelConverter) {
		this.modelConverter = modelConverter;
	}

	public void print(UMLStateExpression stateExpression, boolean result) {
		System.out.println();
		ObjectNode pin = modelConverter.convertPin(stateExpression.getPin());
		if (stateExpression instanceof UMLObjectStateExpression) {
			UMLObjectStateExpression expression = (UMLObjectStateExpression) stateExpression;
			String valueStr = null;
			if (expression.getValue() instanceof UMLSimpleValue) {
				if (((UMLSimpleValue) expression.getValue()).getValue() instanceof XNullLiteral) {
					valueStr = "null";
				} else if (((UMLSimpleValue) expression.getValue()).getValue() instanceof XNumberLiteral) {
					valueStr = ((XNumberLiteral) ((UMLSimpleValue) expression.getValue()).getValue()).getValue();
				} else if (((UMLSimpleValue) expression.getValue()).getValue() instanceof XBooleanLiteral) {
					valueStr = String.valueOf(((XBooleanLiteral) ((UMLSimpleValue) expression.getValue()).getValue()).isIsTrue());
				} else if (((UMLSimpleValue) expression.getValue()).getValue() instanceof XStringLiteral) {
					valueStr = ((XStringLiteral) ((UMLSimpleValue) expression.getValue())).getValue();
				} else {
					valueStr = expression.getValue().toString();
				}
				System.out.println(pin.name + " " + expression.getOperator() + " " + valueStr);
			}
			if (expression.getValue() instanceof UMLObjectValue) {
				System.out.println(pin.name + " " + expression.getOperator() + " " + ((UMLObjectValue) expression.getValue()).getValue().getName());
			}
			if (result)
				System.out.println("Assertion success!");
			else
				System.out.println("Assertion failed!");
		}
		if (stateExpression instanceof UMLPropertyStateExpression) {
			UMLPropertyStateExpression expression = (UMLPropertyStateExpression) stateExpression;
			String valueStr = null;
			Property property = modelConverter.convertProperty(expression.getProperty());
			if (expression.getValue() instanceof UMLSimpleValue) {
				XExpression literal = ((UMLSimpleValue) expression.getValue()).getValue();
				if (literal instanceof XNullLiteral) {
					valueStr = "null";
				} else if (literal instanceof XNumberLiteral) {
					valueStr = ((XNumberLiteral) literal).getValue();
				} else if (literal instanceof XBooleanLiteral) {
					valueStr = String.valueOf(((XBooleanLiteral) literal).isIsTrue());
				} else if (literal instanceof XStringLiteral) {
					valueStr = ((XStringLiteral) literal).getValue();
				} else {
					valueStr = expression.getValue().toString();
				}
				System.out.println(pin.name + " -> " + property.name + " " + expression.getOperator() + " " + valueStr);
			}
			if (expression.getValue() instanceof UMLObjectValue) {
				UMLObjectSpecification literal = ((UMLObjectValue) expression.getValue()).getValue();
				valueStr = literal.getName();
				System.out.println(pin.name + " -> " + property.name + " " + expression.getOperator() + " " + valueStr);
			}
			if (result)
				System.out.println("Assertion success!");
			else
				System.out.println("Assertion failed!");
		}
	}

	public void printOrderSpecification(List<UMLNodeSpecification> nodeOrder) {
		System.out.print("Order assertion: ");
		for (int i = 0; i < nodeOrder.size(); i++) {
			if (nodeOrder.get(i).getNode() != null) {
				ActivityNode node = modelConverter.convertActivityNode(nodeOrder.get(i).getNode());
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

	public void print(List<UMLNodeSpecification> nodeOrder, List<ActivityNodeExecution> executedNodes, boolean result) {
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

	public void printStateAssertion(UMLStateAssertion assertion) {
		System.out.println();

		System.out.print("State assertion: " + assertion.getQuantifier() + " " + assertion.getOperator() + " ");
		if (assertion.getReferencePoint() instanceof UMLActionReferencePoint) {
			Action action = modelConverter.convertAction(((UMLActionReferencePoint) assertion.getReferencePoint()).getAction());
			System.out.print(action.name);
		}
		if (assertion.getReferencePoint() instanceof UMLConstraintReferencePoint) {
			String constraint = ((XStringLiteral) ((UMLConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName()).getValue();
			System.out.print(constraint);
		}
		if (assertion.getUntilPoint() != null) {
			if (assertion.getUntilPoint() instanceof UMLActionReferencePoint) {
				Action action = modelConverter.convertAction(((UMLActionReferencePoint) assertion.getUntilPoint()).getAction());
				System.out.print(" until " + action.name);
			}
			if (assertion.getUntilPoint() instanceof UMLConstraintReferencePoint) {
				String constraint = ((XStringLiteral) ((UMLConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName()).getValue();
				System.out.print(" until " + constraint);
			}
		}
		System.out.println();
	}

	public void print(UMLTestCase testCase) {
		System.out.println();
		System.out.println("Running test: " + testCase.getName());
		System.out.println("Activity under test: " + (modelConverter.convertActivity(testCase.getActivityUnderTest())).name);
	}

	public void printStartEnd() {
		System.out.println("*********************");
	}
}