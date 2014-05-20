/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
/**
 * 
 * @author Stefan Mijatov
 *
 * @param <T>
 */
public class SequenceSwitch<T> extends Switch<T> {
	protected static SequencePackage modelPackage;

	public SequenceSwitch() {
		if (modelPackage == null) {
			modelPackage = SequencePackage.eINSTANCE;
		}
	}

	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case SequencePackage.SEQUENCE_TRACE: {
			SequenceTrace sequenceTrace = (SequenceTrace) theEObject;
			T result = caseSequenceTrace(sequenceTrace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SequencePackage.SEQUENCE: {
			Sequence sequence = (Sequence) theEObject;
			T result = caseSequence(sequence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SequencePackage.STATE: {
			State state = (State) theEObject;
			T result = caseState(state);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	public T caseSequenceTrace(SequenceTrace object) {
		return null;
	}

	public T caseSequence(Sequence object) {
		return null;
	}

	public T caseState(State object) {
		return null;
	}

	@Override
	public T defaultCase(EObject object) {
		return null;
	}
}