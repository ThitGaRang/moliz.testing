/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class SequenceImpl extends EObjectImpl implements Sequence {
	protected EList<State> states;
	protected ActivityExecution activityExecution;

	protected SequenceImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.SEQUENCE;
	}

	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, SequencePackage.SEQUENCE__STATES);
		}
		return states;
	}

	public ActivityExecution getActivityExecution() {
		if (activityExecution != null && activityExecution.eIsProxy()) {
			InternalEObject oldActivityExecution = (InternalEObject) activityExecution;
			activityExecution = (ActivityExecution) eResolveProxy(oldActivityExecution);
			if (activityExecution != oldActivityExecution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.SEQUENCE__ACTIVITY_EXECUTION, oldActivityExecution,
							activityExecution));
			}
		}
		return activityExecution;
	}

	public ActivityExecution basicGetActivityExecution() {
		return activityExecution;
	}

	public void setActivityExecution(ActivityExecution newActivityExecution) {
		ActivityExecution oldActivityExecution = activityExecution;
		activityExecution = newActivityExecution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.SEQUENCE__ACTIVITY_EXECUTION, oldActivityExecution,
					activityExecution));
	}

	public boolean hasCreatedState(ActivityNodeExecution nodeExecution) {
		for (State state : getStates()) {
			if (state.getNodeExecution() == nodeExecution)
				return true;
		}
		return false;
	}

	public void addState(State state) {
		State lastState = lastState();
		if (lastState != null)
			lastState.setSuccessor(state);
		state.setPredecessor(lastState);
		getStates().add(state);
	}

	public State lastState() {
		for (State current : getStates()) {
			if (current.getSuccessor() == null)
				return current;
		}
		return null;
	}

	public State firstState() {
		for (State current : getStates()) {
			if (current.getPredecessor() == null)
				return current;
		}
		return null;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SequencePackage.SEQUENCE__STATES:
			return ((InternalEList<?>) getStates()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SequencePackage.SEQUENCE__STATES:
			return getStates();
		case SequencePackage.SEQUENCE__ACTIVITY_EXECUTION:
			if (resolve)
				return getActivityExecution();
			return basicGetActivityExecution();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SequencePackage.SEQUENCE__STATES:
			getStates().clear();
			getStates().addAll((Collection<? extends State>) newValue);
			return;
		case SequencePackage.SEQUENCE__ACTIVITY_EXECUTION:
			setActivityExecution((ActivityExecution) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SequencePackage.SEQUENCE__STATES:
			getStates().clear();
			return;
		case SequencePackage.SEQUENCE__ACTIVITY_EXECUTION:
			setActivityExecution((ActivityExecution) null);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SequencePackage.SEQUENCE__STATES:
			return states != null && !states.isEmpty();
		case SequencePackage.SEQUENCE__ACTIVITY_EXECUTION:
			return activityExecution != null;
		}
		return super.eIsSet(featureID);
	}
}