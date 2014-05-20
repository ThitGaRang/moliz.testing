/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class SequenceAdapterFactory extends AdapterFactoryImpl {

	protected static SequencePackage modelPackage;

	public SequenceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SequencePackage.eINSTANCE;
		}
	}

	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	protected SequenceSwitch<Adapter> modelSwitch = new SequenceSwitch<Adapter>() {
		@Override
		public Adapter caseSequenceTrace(SequenceTrace object) {
			return createSequenceTraceAdapter();
		}

		@Override
		public Adapter caseSequence(Sequence object) {
			return createSequenceAdapter();
		}

		@Override
		public Adapter caseState(State object) {
			return createStateAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	public Adapter createSequenceTraceAdapter() {
		return null;
	}

	public Adapter createSequenceAdapter() {
		return null;
	}

	public Adapter createStateAdapter() {
		return null;
	}

	public Adapter createEObjectAdapter() {
		return null;
	}
}