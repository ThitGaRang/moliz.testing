/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.trace;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.trace.SnapshotUtil;
import org.modelexecution.fumltesting.core.trace.TraceUtil;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;

/**
 * @author Stefan Mijatov
 * 
 */
public class UmlSnapshotUtil extends SnapshotUtil {

	public UmlSnapshotUtil(TraceUtil traceUtil) {
		super(traceUtil);
	}

	@Override
	public ArrayList<ValueSnapshot> getRelevantSnapshots(Object expressionObject, ActivityNodeExecution referenceActionExecution,
			ActivityNodeExecution untilActionExecution) {
		StateExpression expression = (StateExpression) expressionObject;
		ArrayList<ValueSnapshot> list = new ArrayList<ValueSnapshot>();
		this.referenceActionExecution = referenceActionExecution;
		this.untilActionExecution = untilActionExecution;

		successorSnapshots.removeAll(successorSnapshots);
		predecessorSnapshots.removeAll(predecessorSnapshots);

		Object expressionAction = expression.getPin().eContainer();
		StateAssertion assertion = (StateAssertion) expression.eContainer();

		Object expressionNodeExecution = null;
		if (expressionAction instanceof Action)
			expressionNodeExecution = (ActionExecution) traceUtil.getExecution((Action) expressionAction);
		if (expressionAction instanceof Activity) {
			expressionNodeExecution = (ActivityExecution) traceUtil.getExecution((Activity) expressionAction);
		}
		valueInstance = traceUtil.getValueInstance(expression.getPin(), expressionNodeExecution);

		setupSucessors(assertion.getOperator().getName(), (ActionExecution) referenceActionExecution);
		setupPredecessors(assertion.getOperator().getName(), (ActionExecution) referenceActionExecution);

		if (assertion.getOperator() == TemporalOperator.UNTIL) {
			list = predecessorSnapshots;
		}
		if (assertion.getOperator() == TemporalOperator.AFTER) {
			if (referenceActionExecution.getNode() != expressionAction && successorSnapshots.size() == 0 && predecessorSnapshots.size() > 0) {
				// we need to add last predecessor to successors
				// if the value was not changed after the referred action
				successorSnapshots.add(predecessorSnapshots.get(0));
			}
			list = successorSnapshots;
		}
		return list;
	}
}