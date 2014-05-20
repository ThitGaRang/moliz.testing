/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class StateImpl extends EObjectImpl implements State {

	protected HashMap<ValueInstance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object> snapshotMappings = 
			new HashMap<ValueInstance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object>();
	protected EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> objects;
	protected EList<Link> links;
	protected State successor;
	protected State predecessor;
	protected ActivityNodeExecution nodeExecution;

	protected StateImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.STATE;
	}

	public EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> getObjects() {
		if (objects == null) {
			objects = new EObjectResolvingEList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object>(
					org.modelexecution.fuml.Semantics.Classes.Kernel.Object.class, this, SequencePackage.STATE__OBJECTS);
		}
		return objects;
	}

	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectResolvingEList<Link>(Link.class, this, SequencePackage.STATE__LINKS);
		}
		return links;
	}

	public State getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject) successor;
			successor = (State) eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	public State basicGetSuccessor() {
		return successor;
	}

	public NotificationChain basicSetSuccessor(State newSuccessor, NotificationChain msgs) {
		State oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__SUCCESSOR, oldSuccessor,
					newSuccessor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setSuccessor(State newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject) newSuccessor).eInverseAdd(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__SUCCESSOR, newSuccessor, newSuccessor));
	}

	public State getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject) predecessor;
			predecessor = (State) eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__PREDECESSOR, oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	public State basicGetPredecessor() {
		return predecessor;
	}

	public NotificationChain basicSetPredecessor(State newPredecessor, NotificationChain msgs) {
		State oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__PREDECESSOR, oldPredecessor,
					newPredecessor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setPredecessor(State newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject) newPredecessor).eInverseAdd(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__PREDECESSOR, newPredecessor, newPredecessor));
	}

	public ActivityNodeExecution getNodeExecution() {
		if (nodeExecution != null && nodeExecution.eIsProxy()) {
			InternalEObject oldNodeExecution = (InternalEObject) nodeExecution;
			nodeExecution = (ActivityNodeExecution) eResolveProxy(oldNodeExecution);
			if (nodeExecution != oldNodeExecution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__NODE_EXECUTION, oldNodeExecution, nodeExecution));
			}
		}
		return nodeExecution;
	}

	public ActivityNodeExecution basicGetNodeExecution() {
		return nodeExecution;
	}

	public void setNodeExecution(ActivityNodeExecution newNodeExecution) {
		ActivityNodeExecution oldNodeExecution = nodeExecution;
		nodeExecution = newNodeExecution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__NODE_EXECUTION, oldNodeExecution, nodeExecution));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SequencePackage.STATE__SUCCESSOR:
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
			return basicSetSuccessor((State) otherEnd, msgs);
		case SequencePackage.STATE__PREDECESSOR:
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
			return basicSetPredecessor((State) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SequencePackage.STATE__SUCCESSOR:
			return basicSetSuccessor(null, msgs);
		case SequencePackage.STATE__PREDECESSOR:
			return basicSetPredecessor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SequencePackage.STATE__OBJECTS:
			return getObjects();
		case SequencePackage.STATE__LINKS:
			return getLinks();
		case SequencePackage.STATE__SUCCESSOR:
			if (resolve)
				return getSuccessor();
			return basicGetSuccessor();
		case SequencePackage.STATE__PREDECESSOR:
			if (resolve)
				return getPredecessor();
			return basicGetPredecessor();
		case SequencePackage.STATE__NODE_EXECUTION:
			if (resolve)
				return getNodeExecution();
			return basicGetNodeExecution();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SequencePackage.STATE__OBJECTS:
			getObjects().clear();
			getObjects().addAll((Collection<? extends org.modelexecution.fuml.Semantics.Classes.Kernel.Object>) newValue);
			return;
		case SequencePackage.STATE__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends Link>) newValue);
			return;
		case SequencePackage.STATE__SUCCESSOR:
			setSuccessor((State) newValue);
			return;
		case SequencePackage.STATE__PREDECESSOR:
			setPredecessor((State) newValue);
			return;
		case SequencePackage.STATE__NODE_EXECUTION:
			setNodeExecution((ActivityNodeExecution) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SequencePackage.STATE__OBJECTS:
			getObjects().clear();
			return;
		case SequencePackage.STATE__LINKS:
			getLinks().clear();
			return;
		case SequencePackage.STATE__SUCCESSOR:
			setSuccessor((State) null);
			return;
		case SequencePackage.STATE__PREDECESSOR:
			setPredecessor((State) null);
			return;
		case SequencePackage.STATE__NODE_EXECUTION:
			setNodeExecution((ActivityNodeExecution) null);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SequencePackage.STATE__OBJECTS:
			return objects != null && !objects.isEmpty();
		case SequencePackage.STATE__LINKS:
			return links != null && !links.isEmpty();
		case SequencePackage.STATE__SUCCESSOR:
			return successor != null;
		case SequencePackage.STATE__PREDECESSOR:
			return predecessor != null;
		case SequencePackage.STATE__NODE_EXECUTION:
			return nodeExecution != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public org.modelexecution.fuml.Semantics.Classes.Kernel.Object getStateSnapshot(ValueInstance instance) {
		for (ValueInstance key : snapshotMappings.keySet()) {
			if (key == instance)
				return snapshotMappings.get(key);
		}
		return null;
	}

	@Override
	public void addSnapshotMapping(ValueInstance instance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot) {
		snapshotMappings.put(instance, snapshot);
	}

	@Override
	public void copySnapshotMappings(State anotherState) {
		for (ValueInstance instance : anotherState.getValueInstances()) {
			this.snapshotMappings.put(instance, anotherState.getStateSnapshot(instance));
		}
	}

	@Override
	public Set<ValueInstance> getValueInstances() {
		return this.snapshotMappings.keySet();
	}

	@Override
	public ValueInstance getInstance(org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot) {
		for (ValueInstance key : snapshotMappings.keySet()) {
			if (snapshotMappings.get(key) == snapshot)
				return key;
		}
		return null;
	}
}