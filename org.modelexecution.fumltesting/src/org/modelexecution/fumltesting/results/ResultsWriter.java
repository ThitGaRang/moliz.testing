/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.results;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;

import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Activities.IntermediateActivities.ActivityFinalNode;
import fUML.Syntax.Activities.IntermediateActivities.InitialNode;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
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
			writer.println("Activity: " + testCaseResult.getActivityUnderTest().getName());
			if (testCaseResult.getActivityContextObject() != null) {
				writer.println("Activity context object: " + ((ObjectSpecification) testCaseResult.getActivityContextObject()).getName());
			}
			if (testCaseResult.getActivityInputValues().size() > 0) {
				writer.print("Activity input: ");
				for (ActivityInput activityInput : testCaseResult.getActivityInputValues()) {
					String value = null;
					if (activityInput.getValue() instanceof ObjectSpecification) {
						value = ((ObjectSpecification) activityInput.getValue()).getName();
					} else {
						value = activityInput.getValue().toString();
					}
					writer.print(activityInput.getParameter().getName() + " = " + value + "; ");
				}
			}
			writer.println();
			for (AssertionResult assertionResult : testCaseResult.getAssertionResults()) {
				if (assertionResult instanceof OrderAssertionResult) {
					OrderAssertionResult orderAssertionResult = (OrderAssertionResult) assertionResult;
					printSpecification(orderAssertionResult.getNodeOrderSpecification().getNodes());
					writer.println("\tNumber of paths checked: " + orderAssertionResult.numberOfPathsChecked());
					writer.println("\tNumber of invalid paths: " + orderAssertionResult.getFailedPathCheckResults().size());
					writer.println();

					for (PathCheckResult pathCheckResult : orderAssertionResult.getFailedPathCheckResults()) {
						writer.print("Failed path: ");
						printPath(pathCheckResult.getPath());
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