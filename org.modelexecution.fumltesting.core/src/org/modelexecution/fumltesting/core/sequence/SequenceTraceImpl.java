/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class SequenceTraceImpl extends EObjectImpl implements SequenceTrace {
	protected EList<Sequence> sequences;

	protected SequenceTraceImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return SequencePackage.Literals.SEQUENCE_TRACE;
	}

	public EList<Sequence> getSequences() {
		if (sequences == null) {
			sequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, SequencePackage.SEQUENCE_TRACE__SEQUENCES);
		}
		return sequences;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SequencePackage.SEQUENCE_TRACE__SEQUENCES:
			return ((InternalEList<?>) getSequences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SequencePackage.SEQUENCE_TRACE__SEQUENCES:
			return getSequences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SequencePackage.SEQUENCE_TRACE__SEQUENCES:
			getSequences().clear();
			getSequences().addAll((Collection<? extends Sequence>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SequencePackage.SEQUENCE_TRACE__SEQUENCES:
			getSequences().clear();
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SequencePackage.SEQUENCE_TRACE__SEQUENCES:
			return sequences != null && !sequences.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}