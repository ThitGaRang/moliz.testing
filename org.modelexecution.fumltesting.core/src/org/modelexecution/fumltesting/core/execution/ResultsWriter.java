/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.execution;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.core.assertions.OrderAssertionValidationType;
import org.modelexecution.fumltesting.core.results.ActivityInput;
import org.modelexecution.fumltesting.core.results.AssertionResult;
import org.modelexecution.fumltesting.core.results.ConstraintResult;
import org.modelexecution.fumltesting.core.results.OrderAssertionResult;
import org.modelexecution.fumltesting.core.results.PathCheckResult;
import org.modelexecution.fumltesting.core.results.StateAssertionResult;
import org.modelexecution.fumltesting.core.results.StateExpressionResult;
import org.modelexecution.fumltesting.core.results.TestCaseResult;
import org.modelexecution.fumltesting.core.results.TestSuiteResult;
import org.modelexecution.fumltesting.core.testlang.ActionReferencePoint;
import org.modelexecution.fumltesting.core.testlang.BooleanValue;
import org.modelexecution.fumltesting.core.testlang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.core.testlang.IntegerValue;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.NullValue;
import org.modelexecution.fumltesting.core.testlang.ObjectSpecification;
import org.modelexecution.fumltesting.core.testlang.ObjectStateExpression;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.PropertyStateExpression;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.StringValue;
import org.modelexecution.fumltesting.core.testlang.Value;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.DecisionNode;
import fUML.Syntax.Activities.IntermediateActivities.ForkNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;
import fUML.Syntax.Activities.IntermediateActivities.MergeNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class ResultsWriter {
	private TestSuiteResult suiteResult;
	private PrintWriter writer;
	private final String marking = "******************************************************************************************";

	public ResultsWriter(TestSuiteResult suiteResult, OutputStream output) {
		this.suiteResult = suiteResult;
		writer = new PrintWriter(output);
	}

	public void writeResults() {
		writer.println("Test Suite Run: " + suiteResult.executedOn());
		writer.println("Setup time: " + suiteResult.getSetupTime());
		writer.println();

		writeTestsThatDidNotRun(suiteResult);

		for (TestCaseResult testCaseResult : suiteResult.getTestCaseResults()) {
			writer.println("TestCase: " + testCaseResult.getTestCaseName());
			writer.println("Activity: " + ((NamedElement) testCaseResult.getActivityUnderTest().getActivity().owner).name + "."
					+ testCaseResult.getActivityUnderTest().getActivity().name);
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
						Value aValue = (Value) activityInput.getValue();
						if (aValue instanceof NullValue) {
							value = "null";
						} else if (aValue instanceof StringValue) {
							value = ((StringValue) aValue).getValue();
						} else if (aValue instanceof IntegerValue) {
							value = ((IntegerValue) aValue).getValue().toString();
						} else if (aValue instanceof BooleanValue) {
							value = String.valueOf(((BooleanValue) aValue).getValue());
						} else {
							value = "UNKNOWN";
						}
					}
					writer.print(activityInput.getParameter().name + " = " + value + "; ");
				}
			}
			writer.println("\nRunning time (ms): " + testCaseResult.getRunningTime());
			writer.println();
			for (AssertionResult assertionResult : testCaseResult.getAssertionResults()) {

				if (assertionResult instanceof OrderAssertionResult
						&& ((OrderAssertionResult) assertionResult).getValidationType() == OrderAssertionValidationType.MATRIX) {
					OrderAssertionResult orderAssertionResult = (OrderAssertionResult) assertionResult;
					printSpecification(orderAssertionResult.getOrderSpecification());
					writer.println("\tValidation result: " + (orderAssertionResult.getResult() ? "SUCCESS" : "FAIL"));
					for (OrderAssertionResult subResult : orderAssertionResult.getSubOrderResults()) {
						writer.println("\t\tSub-order checked..");
						writer.print("\t");
						printSpecification(subResult.getOrderSpecification());
						writer.println("\t\tValidation result: " + (orderAssertionResult.getResult() ? "SUCCESS" : "FAIL"));
					}
				}
				if (assertionResult instanceof OrderAssertionResult
						&& (((OrderAssertionResult) assertionResult).getValidationType() == OrderAssertionValidationType.GRAPH)) {
					OrderAssertionResult orderAssertionResult = (OrderAssertionResult) assertionResult;
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
					writer.println();
				}
				if (assertionResult instanceof StateAssertionResult) {
					StateAssertionResult stateAssertionResult = (StateAssertionResult) assertionResult;
					StateAssertion assertion = (StateAssertion) stateAssertionResult.getAssertion();
					writer.print("\n\tState assertion: " + assertion.getQuantifier() + " " + assertion.getOperator() + " ");
					if (assertion.getReferencePoint() instanceof ActionReferencePoint) {
						Action action = ((ActionReferencePoint) assertion.getReferencePoint()).getAction();
						if (action == null)
							writer.print("UNKNOWN");
						else
							writer.print("action " + action.name);
					}
					if (assertion.getReferencePoint() instanceof ConstraintReferencePoint) {
						writer.print("constraint " + ((ConstraintReferencePoint) assertion.getReferencePoint()).getConstraintName());
					}
					if (assertion.getUntilPoint() != null) {
						if (assertion.getUntilPoint() instanceof ActionReferencePoint) {
							Action action = ((ActionReferencePoint) assertion.getUntilPoint()).getAction();
							writer.print(" until action " + action.name);
						}
						if (assertion.getUntilPoint() instanceof ConstraintReferencePoint) {
							writer.print(" until constraint " + ((ConstraintReferencePoint) assertion.getUntilPoint()).getConstraintName());
						}
					}
					writer.println();
					if (stateAssertionResult.hasError()) {
						writer.println("\tError: " + stateAssertionResult.getError());
					} else {
						if (stateAssertionResult.getNumberOfConstraints() > 0) {
							writer.println("\tConstraints checked: " + stateAssertionResult.getNumberOfConstraints());
							writer.println("\tConstraints failed: " + stateAssertionResult.getFailedConstraints().size());
							for (ConstraintResult constraintResult : stateAssertionResult.getFailedConstraints()) {
								writer.println("\t\tConstraint: " + constraintResult.getConstraintName());
							}
						}
						if (((StateAssertionResult) assertionResult).getNumberOfStateExpressions() > 0) {
							writer.println("\tState expressions checked: " + ((StateAssertionResult) assertionResult).getNumberOfStateExpressions());
							writer.println("\tState expressions failed: "
									+ ((StateAssertionResult) assertionResult).getFailedStateExpressions().size());

							for (StateExpressionResult result : ((StateAssertionResult) assertionResult).getFailedStateExpressions()) {
								if (result.hasError()) {
									writer.println("\tError occurred: " + result.getError());
								} else {
									String pinQualifiedName = "";
									if (result.getStateExpression() instanceof PropertyStateExpression) {
										ObjectNode pin = ((PropertyStateExpression) result.getStateExpression()).getPin();
										if (pin.owner instanceof Activity) {
											pinQualifiedName = ((Activity) pin.owner).name + "." + pin.name;
										} else if (pin.owner instanceof Action) {
											pinQualifiedName = ((Action) pin.owner).activity.name + "." + ((Action) pin.owner).name + "." + pin.name;
										}
										Property property = ((PropertyStateExpression) result.getStateExpression()).getProperty();
										writer.print("\t\tExpression: " + pinQualifiedName + "::" + property.name + " "
												+ ((StateExpression) result.getStateExpression()).getOperator() + " ");
									}
									if (result.getStateExpression() instanceof ObjectStateExpression) {
										ObjectNode pin = ((ObjectStateExpression) result.getStateExpression()).getPin();
										if (pin.owner instanceof Activity) {
											pinQualifiedName = ((Activity) pin.owner).name + "." + pin.name;
										} else if (pin.owner instanceof Action) {
											pinQualifiedName = ((Action) pin.owner).activity.name + "." + ((Action) pin.owner).name + "." + pin.name;
										}
										writer.print("\t\tExpression: " + pinQualifiedName + " "
												+ ((StateExpression) result.getStateExpression()).getOperator() + " ");
									}
									Value value = ((StateExpression) result.getStateExpression()).getValue();
									if (value instanceof ObjectValue) {
										writer.print(((ObjectValue) value).getValue().getName());
									} else if (value instanceof Value) {
										if (value instanceof NullValue) {
											writer.print("null");
										} else if (value instanceof StringValue) {
											writer.print(((StringValue) value).getValue());
										} else if (value instanceof BooleanValue) {
											writer.print(((BooleanValue) value).getValue());
										} else if (value instanceof IntegerValue) {
											writer.print(((IntegerValue) value).getValue());
										}
									}
									if (result.getActual() != null)
										writer.println(" / Actual was: " + result.getActual());
									if (result.getActual() == null) {
										writer.println(" / Actual was: NULL");
									}
								}
							}
						}
					}
				}
			}
			writer.println(marking);
		}
		writer.close();
	}

	private void writeTestsThatDidNotRun(TestSuiteResult suiteResult) {
		ArrayList<TestCaseResult> testsThatDidNotRun = new ArrayList<TestCaseResult>();
		for (TestCaseResult testCaseResult : suiteResult.getTestCaseResults()) {
			if (!testCaseResult.hasError())
				testsThatDidNotRun.add(testCaseResult);
		}
		if (testsThatDidNotRun.size() > 0) {
			writer.println("These tests did not run: \n");
			for (TestCaseResult testCaseResult : testsThatDidNotRun) {
				writer.println("Test name: \t" + testCaseResult.getTestCaseName());
				writer.println("Cause: \t" + testCaseResult.getError());
				writer.println(marking);
			}
		}
	}

	private void printSpecification(List<NodeSpecification> nodeOrder) {
		writer.print("\tOrder specification: ");
		for (int i = 0; i < nodeOrder.size(); i++) {
			if (nodeOrder.get(i).getNode() != null) {
				ActivityNode node = nodeOrder.get(i).getNode();
				if (i == nodeOrder.size() - 1)
					writer.print(node.name);
				else
					writer.print(node.name + ", ");
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
					|| execution.getNode() instanceof ActivityFinalNode || execution.getNode() instanceof MergeNode
					|| execution.getNode() instanceof DecisionNode || execution.getNode() instanceof ForkNode) {
				if (i == executions.size() - 1)
					writer.print(execution.getNode().name);
				else
					writer.print(execution.getNode().name + ", ");
			}
		}
		writer.println();
	}
}