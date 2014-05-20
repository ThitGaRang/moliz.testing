/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public interface SequencePackage extends EPackage {
	String eNAME = "sequence";
	String eNS_URI = "http://www.modelexecution.org/sequence";
	String eNS_PREFIX = "sequence";
	SequencePackage eINSTANCE = org.modelexecution.fumltesting.core.sequence.SequencePackageImpl.init();
	int SEQUENCE_TRACE = 0;
	int SEQUENCE_TRACE__SEQUENCES = 0;
	int SEQUENCE_TRACE_FEATURE_COUNT = 1;
	int SEQUENCE = 1;
	int SEQUENCE__STATES = 0;
	int SEQUENCE__ACTIVITY_EXECUTION = 1;
	int SEQUENCE_FEATURE_COUNT = 2;
	int STATE = 2;
	int STATE__OBJECTS = 0;
	int STATE__LINKS = 1;
	int STATE__SUCCESSOR = 2;
	int STATE__PREDECESSOR = 3;
	int STATE__NODE_EXECUTION = 4;
	int STATE_FEATURE_COUNT = 5;

	EClass getSequenceTrace();

	EReference getSequenceTrace_Sequences();

	EClass getSequence();

	EReference getSequence_States();

	EReference getSequence_ActivityExecution();

	EClass getState();

	EReference getState_Objects();

	EReference getState_Links();

	EReference getState_Successor();

	EReference getState_Predecessor();

	EReference getState_NodeExecution();

	SequenceFactory getSequenceFactory();

	interface Literals {

		EClass SEQUENCE_TRACE = eINSTANCE.getSequenceTrace();

		EReference SEQUENCE_TRACE__SEQUENCES = eINSTANCE.getSequenceTrace_Sequences();

		EClass SEQUENCE = eINSTANCE.getSequence();

		EReference SEQUENCE__STATES = eINSTANCE.getSequence_States();

		EReference SEQUENCE__ACTIVITY_EXECUTION = eINSTANCE.getSequence_ActivityExecution();

		EClass STATE = eINSTANCE.getState();

		EReference STATE__OBJECTS = eINSTANCE.getState_Objects();

		EReference STATE__LINKS = eINSTANCE.getState_Links();

		EReference STATE__SUCCESSOR = eINSTANCE.getState_Successor();

		EReference STATE__PREDECESSOR = eINSTANCE.getState_Predecessor();

		EReference STATE__NODE_EXECUTION = eINSTANCE.getState_NodeExecution();
	}
}