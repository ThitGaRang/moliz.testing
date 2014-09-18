/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class Sequence {
	private LinkedList<State> states;
	private State lastState;
	private ActivityExecution activityExecution;

	public Sequence(ActivityExecution activityExecution) {
		this.activityExecution = activityExecution;
		this.states = new LinkedList<State>();
	}

	public ActivityExecution getActivityExecution() {
		return activityExecution;
	}

	public State createNewState(ActivityNodeExecution stateCreator) {
		State state = new State(stateCreator);
		if (lastState != null) {
			for (ValueInstance instance : lastState.getStateObjectInstances()) {
				Object_ object = lastState.getStateObjectSnapshot(instance);
				state.addStateObjectSnapshot(object, instance);
			}
			for (ValueInstance instance : lastState.getStateLinkInstances()) {
				Link link = lastState.getStateLinkSnapshot(instance);
				state.addStateLinkSnapshot(link, instance);
			}
			lastState.setSuccessor(state);
			state.setPredecessor(lastState);
		}
		states.add(state);
		lastState = state;
		return state;
	}

	public State createNewState(State anotherState) {
		State state = new State(null);
		if (lastState != null) {
			for (ValueInstance instance : anotherState.getStateObjectInstances()) {
				Object_ object = anotherState.getStateObjectSnapshot(instance);
				state.addStateObjectSnapshot(object, instance);
			}
			for (ValueInstance instance : anotherState.getStateLinkInstances()) {
				Link link = anotherState.getStateLinkSnapshot(instance);
				state.addStateLinkSnapshot(link, instance);
			}
		}
		states.add(state);
		lastState = state;
		return state;
	}

	public List<State> getStates() {
		return Collections.unmodifiableList(states);
	}

	public State getState(ActivityNodeExecution stateCreator) {
		for (State state : states) {
			if (state.getStateCreator() == stateCreator)
				return state;
		}
		return null;
	}

	public State lastState() {
		return lastState;
	}
}