/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.results.ActivityInput;
import org.modelexecution.fumltesting.results.AssertionResult;
import org.modelexecution.fumltesting.results.ConstraintResult;
import org.modelexecution.fumltesting.results.OrderAssertionResult;
import org.modelexecution.fumltesting.results.PathCheckResult;
import org.modelexecution.fumltesting.results.StateAssertionResult;
import org.modelexecution.fumltesting.results.StateExpressionResult;
import org.modelexecution.fumltesting.results.TestCaseResult;
import org.modelexecution.fumltesting.results.TestSuiteResult;
import org.modelexecution.fumltesting.testLang.ActionReferencePoint;
import org.modelexecution.fumltesting.testLang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.Value;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class ResultsWriter {
	private String fileName;
	private TestSuiteResult suiteResult;
	private PrintWriter writer;

	public ResultsWriter(String fileName, TestSuiteResult suiteResult) {
		this.fileName = fileName;
		this.suiteResult = suiteResult;
	}

	public void writeResults() throws FileNotFoundException {
		writer = new PrintWriter(fileName);

		SimpleDateFormat currentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		writer.println("Test Suite Run: " + currentTime.format(new Date()));
		writer.println();

		for (TestCaseResult testCaseResult : suiteResult.getTestCaseResults()) {
			writer.println("TestCase: " + testCaseResult.getTestCaseName());
			writer.println("Activity: " + ((Activity) testCaseResult.getActivityUnderTest()).name);
			if (testCaseResult.getActivityContextObject() != null) {
				writer.println("Activity context object: " + ((ObjectSpecification) testCaseResult.getActivityContextObject()).getName());
			}
			if (testCaseResult.getActivityInputValues().size() > 0) {
				writer.print("Activity input: ");
				for (ActivityInput activityInput : testCaseResult.getActivityInputValues()) {
					String value = null;
					if (activityInput.getValue() instanceof ObjectValue) {
						value = ((ObjectValue) activityInput.getValue()).getValue().getName();
					} else {
						XExpression expression = ((SimpleValue) activityInput.getValue()).getValue();
						if (expression instanceof XStringLiteral) {
							value = ((XStringLiteral) expression).getValue();
						} else if (expression instanceof XNumberLiteral) {
							value = ((XNumberLiteral) expression).getValue();
						} else if (expression instanceof XBooleanLiteral) {
							value = String.valueOf(((XBooleanLiteral) expression).isIsTrue());
						} else {
							value = "UNKNOWN";
						}
					}
					writer.print(((ActivityParameterNode) activityInput.getParameter()).name + " = " + value + "; ");
				}
			}
			writer.println();
			for (AssertionResult assertionResult : testCaseResult.getAssertionResults()) {
				if (assertionResult instanceof OrderAssertionResult) {
					OrderAssertionResult orderAssertionResult = (OrderAssertionResult) assertionResult;
					printSpecification(((NodeOrder) orderAssertionResult.getNodeOrderSpecification()).getNodes());
					writer.println("\tNumber of paths checked: " + orderAssertionResult.numberOfPathsChecked());
					writer.println("\tNumber of invalid paths: " + orderAssertionResult.getFailedPathCheckResults().size());
					writer.println();

					int counter = 0;

					for (PathCheckResult pathCheckResult : orderAssertionResult.getFailedPathCheckResults()) {
						counter++;
						writer.print("\tFailed path: ");
						printPath(pathCheckResult.getPath());
						if (counter == 5) {
							writer.println("\n\tThere are " + (orderAssertionResult.getFailedPathCheckResults().size() - 5) + " more failed paths.");
							break;
						}
					}

					for (OrderAssertionResult subResult : orderAssertionResult.getSubOrderResults()) {
						writer.println("\t\tSub-order checked..");
						writer.print("\t");
						printSpecification(((NodeOrder) subResult.getNodeOrderSpecification()).getNodes());
						writer.println("\t\tNumber of paths checked: " + subResult.numberOfPathsChecked());
						writer.println("\t\tNumber of invalid paths: " + subResult.getFailedPathCheckResults().size());
						writer.println();

						counter = 0;
						for (PathCheckResult pathCheckResult : subResult.getFailedPathCheckResults()) {
							counter++;
							writer.print("\t\tFailed path: ");
							printPath(pathCheckResult.getPath());
							if (counter == 5) {
								writer.println("\n\t\tThere are " + (subResult.getFailedPathCheckResults().size() - 5) + " more failed paths.");
								break;
							}
						}
					}
				}
				if (assertionResult instanceof StateAssertionResult) {
					StateAssertionResult stateAssertionResult = (StateAssertionResult) assertionResult;
					StateAssertion assertion = (StateAssertion) stateAssertionResult.getAssertion();
					writer.print("\n\tState assertion: " + assertion.getQuantifier() + " " + assertion.getOperator() + " ");
					if (assertion.getReferencePoint() instanceof ActionReferencePoint)
						writer.print("action " + ((ActionReferencePoint) assertion.getReferencePoint()).getAction().getName());
					if (assertion.getReferencePoint() instanceof ConstraintReferencePoint) {
						writer.print("constraint "
								+ ((XStringLiteral) ((ConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName()).getValue());
					}
					if (assertion.getUntilPoint() != null) {
						if (assertion.getUntilPoint() instanceof ActionReferencePoint)
							writer.print(" until action " + ((ActionReferencePoint) assertion.getUntilPoint()).getAction().getName());
						if (assertion.getUntilPoint() instanceof ConstraintReferencePoint) {
							writer.print(" until constraint "
									+ (((XStringLiteral) ((ConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName()).getValue()));
						}
					}
					writer.println();
					if (assertionResult.hasError()) {
						writer.print("\tError occurred: " + assertionResult.getError());
					}
					if (stateAssertionResult.numberOfConstraintsChecked() > 0) {
						writer.println("\tConstraints checked: " + stateAssertionResult.numberOfConstraintsChecked());
						writer.println("\tConstraints failed: " + stateAssertionResult.getFailedConstraints().size());
						for (ConstraintResult constraintResult : stateAssertionResult.getFailedConstraints()) {
							writer.print("\t\tConstraint: " + constraintResult.getConstraint() + " State(s): ");
							for (int count = 0; count < constraintResult.getFailedStates().size(); count++) {
								writer.print(constraintResult.getFailedStates().get(count).getNodeExecution().getNode().name);
								if (count < constraintResult.getFailedStates().size() - 1)
									writer.print(", ");
							}
							writer.println();
						}
					}
					if (((StateAssertionResult) assertionResult).getFailedStateExpressions().size() > 0) {
						writer.println("\tFailed state expressions: ");
					}

					if (((StateAssertionResult) assertionResult).getNumberOfStateExpressions() > 0) {
						writer.println("\tState expressions checked: " + ((StateAssertionResult) assertionResult).getNumberOfStateExpressions());
						writer.println("\tState expressions failed: " + ((StateAssertionResult) assertionResult).getFailedStateExpressions().size());

						for (StateExpressionResult result : ((StateAssertionResult) assertionResult).getFailedStateExpressions()) {
							if (result.getStateExpression() instanceof PropertyStateExpression)
								writer.print("\t\tExpression: " + ((PropertyStateExpression) result.getStateExpression()).getPin().getName() + "::"
										+ ((PropertyStateExpression) result.getStateExpression()).getProperty().getName() + " "
										+ ((StateExpression) result.getStateExpression()).getOperator() + " ");
							if (result.getStateExpression() instanceof ObjectStateExpression) {
								writer.print("\t\tExpression: " + ((ObjectStateExpression) result.getStateExpression()).getPin().getName() + " "
										+ ((StateExpression) result.getStateExpression()).getOperator() + " ");
							}
							Value value = ((StateExpression) result.getStateExpression()).getValue();
							if (value instanceof ObjectValue) {
								writer.print(((ObjectValue) value).getValue().getName());
							} else if (value instanceof SimpleValue) {
								XExpression valueExpression = ((SimpleValue) value).getValue();
								if (valueExpression instanceof XStringLiteral) {
									writer.print(((XStringLiteral) valueExpression).getValue());
								} else if (valueExpression instanceof XBooleanLiteral) {
									writer.print(((XBooleanLiteral) valueExpression).isIsTrue());
								} else if (valueExpression instanceof XNumberLiteral) {
									writer.print(((XNumberLiteral) valueExpression).getValue());
								} else if (valueExpression instanceof XNullLiteral) {
									writer.print("null");
								}
							}
						}
					}
				}
			}
		}
		writer.close();
	}

	private void printSpecification(List<NodeSpecification> nodeOrder) {
		writer.print("\tOrder specification: ");
		for (int i = 0; i < nodeOrder.size(); i++) {
			if (nodeOrder.get(i).getNode() != null) {
				if (i == nodeOrder.size() - 1)
					writer.print(nodeOrder.get(i).getNode().getName());
				else
					writer.print(nodeOrder.get(i).getNode().getName() + ", ");
			}
			if (nodeOrder.get(i).getJoker() != null) {
				if (i == nodeOrder.size() - 1)
					writer.print(nodeOrder.get(i).getJoker());
				else
					writer.print(nodeOrder.get(i).getJoker() + ", ");
			}
		}
		writer.println();
	}

	private void printPath(List<ActivityNodeExecution> executions) {
		for (int i = 0; i < executions.size(); i++) {
			ActivityNodeExecution execution = executions.get(i);
			if (execution.getNode() instanceof Action || execution.getNode() instanceof InitialNode
					|| execution.getNode() instanceof ActivityFinalNode) {
				if (i == executions.size() - 1)
					writer.print(execution.getNode().name);
				else
					writer.print(execution.getNode().name + ", ");
			}
		}
		writer.println();
	}
}