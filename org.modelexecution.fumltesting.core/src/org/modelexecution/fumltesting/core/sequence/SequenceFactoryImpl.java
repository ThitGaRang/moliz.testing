/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class SequenceFactoryImpl extends EFactoryImpl implements SequenceFactory {
	public static SequenceFactory init() {
		try {
			SequenceFactory theSequenceFactory = (SequenceFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.modelexecution.org/sequence");
			if (theSequenceFactory != null) {
				return theSequenceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SequenceFactoryImpl();
	}

	public SequenceFactoryImpl() {
		super();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SequencePackage.SEQUENCE_TRACE:
			return createSequenceTrace();
		case SequencePackage.SEQUENCE:
			return createSequence();
		case SequencePackage.STATE:
			return createState();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public SequenceTrace createSequenceTrace() {
		SequenceTraceImpl sequenceTrace = new SequenceTraceImpl();
		return sequenceTrace;
	}

	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	public SequencePackage getSequencePackage() {
		return (SequencePackage) getEPackage();
	}

	@Deprecated
	public static SequencePackage getPackage() {
		return SequencePackage.eINSTANCE;
	}
}