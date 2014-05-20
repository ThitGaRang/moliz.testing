/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public interface Sequence extends EObject {
	EList<State> getStates();

	ActivityExecution getActivityExecution();

	void setActivityExecution(ActivityExecution value);

	void addState(State state);

	State lastState();

	State firstState();

	boolean hasCreatedState(ActivityNodeExecution nodeExecution);

}