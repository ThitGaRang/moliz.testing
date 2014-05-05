/**
 */
package org.modelexecution.fumltesting.core.sequence.impl;

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
import org.modelexecution.fumltesting.core.sequence.SequencePackage;
import org.modelexecution.fumltesting.core.sequence.State;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.impl.StateImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.impl.StateImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.impl.StateImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.impl.StateImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.impl.StateImpl#getNodeExecution <em>Node Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	
	/**
	 * @generated NOT
	 * Mapping of a instance value to a corresponding snapshot.
	 */
	protected HashMap<ValueInstance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object> snapshotMappings 
		= new HashMap<ValueInstance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object>();
	
	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> objects;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected State successor;

	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected State predecessor;

	/**
	 * The cached value of the '{@link #getNodeExecution() <em>Node Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeExecution()
	 * @generated
	 * @ordered
	 */
	protected ActivityNodeExecution nodeExecution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> getObjects() {
		if (objects == null) {
			objects = new EObjectResolvingEList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object>(org.modelexecution.fuml.Semantics.Classes.Kernel.Object.class, this, SequencePackage.STATE__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectResolvingEList<Link>(Link.class, this, SequencePackage.STATE__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject)successor;
			successor = (State)eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(State newSuccessor, NotificationChain msgs) {
		State oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__SUCCESSOR, oldSuccessor, newSuccessor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessor(State newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject)successor).eInverseRemove(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject)newSuccessor).eInverseAdd(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__SUCCESSOR, newSuccessor, newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject)predecessor;
			predecessor = (State)eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__PREDECESSOR, oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(State newPredecessor, NotificationChain msgs) {
		State oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__PREDECESSOR, oldPredecessor, newPredecessor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredecessor(State newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject)predecessor).eInverseRemove(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject)newPredecessor).eInverseAdd(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__PREDECESSOR, newPredecessor, newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNodeExecution getNodeExecution() {
		if (nodeExecution != null && nodeExecution.eIsProxy()) {
			InternalEObject oldNodeExecution = (InternalEObject)nodeExecution;
			nodeExecution = (ActivityNodeExecution)eResolveProxy(oldNodeExecution);
			if (nodeExecution != oldNodeExecution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencePackage.STATE__NODE_EXECUTION, oldNodeExecution, nodeExecution));
			}
		}
		return nodeExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNodeExecution basicGetNodeExecution() {
		return nodeExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeExecution(ActivityNodeExecution newNodeExecution) {
		ActivityNodeExecution oldNodeExecution = nodeExecution;
		nodeExecution = newNodeExecution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencePackage.STATE__NODE_EXECUTION, oldNodeExecution, nodeExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequencePackage.STATE__SUCCESSOR:
				if (successor != null)
					msgs = ((InternalEObject)successor).eInverseRemove(this, SequencePackage.STATE__PREDECESSOR, State.class, msgs);
				return basicSetSuccessor((State)otherEnd, msgs);
			case SequencePackage.STATE__PREDECESSOR:
				if (predecessor != null)
					msgs = ((InternalEObject)predecessor).eInverseRemove(this, SequencePackage.STATE__SUCCESSOR, State.class, msgs);
				return basicSetPredecessor((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencePackage.STATE__OBJECTS:
				return getObjects();
			case SequencePackage.STATE__LINKS:
				return getLinks();
			case SequencePackage.STATE__SUCCESSOR:
				if (resolve) return getSuccessor();
				return basicGetSuccessor();
			case SequencePackage.STATE__PREDECESSOR:
				if (resolve) return getPredecessor();
				return basicGetPredecessor();
			case SequencePackage.STATE__NODE_EXECUTION:
				if (resolve) return getNodeExecution();
				return basicGetNodeExecution();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SequencePackage.STATE__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends org.modelexecution.fuml.Semantics.Classes.Kernel.Object>)newValue);
				return;
			case SequencePackage.STATE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case SequencePackage.STATE__SUCCESSOR:
				setSuccessor((State)newValue);
				return;
			case SequencePackage.STATE__PREDECESSOR:
				setPredecessor((State)newValue);
				return;
			case SequencePackage.STATE__NODE_EXECUTION:
				setNodeExecution((ActivityNodeExecution)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
				setSuccessor((State)null);
				return;
			case SequencePackage.STATE__PREDECESSOR:
				setPredecessor((State)null);
				return;
			case SequencePackage.STATE__NODE_EXECUTION:
				setNodeExecution((ActivityNodeExecution)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

	/* (non-Javadoc)
	 * @see org.modelexecution.fumltesting.sequence.State#getStateSnapshot(org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance)
	 */
	@Override
	public org.modelexecution.fuml.Semantics.Classes.Kernel.Object getStateSnapshot (ValueInstance instance) {
		for(ValueInstance key: snapshotMappings.keySet()){
			if (key == instance)
				return snapshotMappings.get(key);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.modelexecution.fumltesting.sequence.State#addSnapshotMapping(org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance, fUML.Semantics.Classes.Kernel.Object_)
	 */
	@Override
	public void addSnapshotMapping(ValueInstance instance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot) {
		snapshotMappings.put(instance, snapshot);
	}

	/* (non-Javadoc)
	 * @see org.modelexecution.fumltesting.sequence.State#copySnapshotMappings(org.modelexecution.fumltesting.sequence.State)
	 */
	@Override
	public void copySnapshotMappings(State anotherState) {
		for(ValueInstance instance: anotherState.getValueInstances()){
			this.snapshotMappings.put(instance, anotherState.getStateSnapshot(instance));
		}
	}

	/* (non-Javadoc)
	 * @see org.modelexecution.fumltesting.sequence.State#getValueInstances()
	 */
	@Override
	public Set<ValueInstance> getValueInstances() {
		return this.snapshotMappings.keySet();
	}
	/* (non-Javadoc)
	 * @see org.modelexecution.fumltesting.sequence.State#getInstance(org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot)
	 */
	@Override
	public ValueInstance getInstance(org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot) {
		for(ValueInstance key: snapshotMappings.keySet()){
			if(snapshotMappings.get(key) == snapshot)
				return key;
		}
		return null;
	}
} //StateImpl
