/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.modelexecution.fuml.Semantics.Loci.LociL1.LociL1Package;
import org.modelexecution.fuml.Syntax.Actions.BasicActions.BasicActionsPackage;
import org.modelexecution.fuml.Syntax.Actions.CompleteActions.CompleteActionsPackage;
import org.modelexecution.fuml.Syntax.Actions.IntermediateActions.IntermediateActionsPackage;
import org.modelexecution.fuml.Syntax.Activities.CompleteStructuredActivities.CompleteStructuredActivitiesPackage;
import org.modelexecution.fuml.Syntax.Activities.ExtraStructuredActivities.ExtraStructuredActivitiesPackage;
import org.modelexecution.fuml.Syntax.Activities.IntermediateActivities.IntermediateActivitiesPackage;
import org.modelexecution.fuml.Syntax.Classes.Kernel.KernelPackage;
import org.modelexecution.fuml.Syntax.CommonBehaviors.BasicBehaviors.BasicBehaviorsPackage;
import org.modelexecution.fuml.Syntax.CommonBehaviors.Communications.CommunicationsPackage;
import org.modelexecution.fumldebug.core.trace.tracemodel.TracemodelPackage;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public class SequencePackageImpl extends EPackageImpl implements SequencePackage {
	private EClass sequenceTraceEClass = null;

	private EClass sequenceEClass = null;

	private EClass stateEClass = null;

	private SequencePackageImpl() {
		super(eNS_URI, SequenceFactory.eINSTANCE);
	}

	private static boolean isInited = false;

	public static SequencePackage init() {
		if (isInited)
			return (SequencePackage) EPackage.Registry.INSTANCE.getEPackage(SequencePackage.eNS_URI);

		SequencePackageImpl theSequencePackage = (SequencePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SequencePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new SequencePackageImpl());

		isInited = true;

		BasicBehaviorsPackage.eINSTANCE.eClass();
		CommunicationsPackage.eINSTANCE.eClass();
		KernelPackage.eINSTANCE.eClass();
		IntermediateActivitiesPackage.eINSTANCE.eClass();
		CompleteStructuredActivitiesPackage.eINSTANCE.eClass();
		ExtraStructuredActivitiesPackage.eINSTANCE.eClass();
		IntermediateActionsPackage.eINSTANCE.eClass();
		CompleteActionsPackage.eINSTANCE.eClass();
		BasicActionsPackage.eINSTANCE.eClass();
		org.modelexecution.fuml.Semantics.Classes.Kernel.KernelPackage.eINSTANCE.eClass();
		LociL1Package.eINSTANCE.eClass();
		TracemodelPackage.eINSTANCE.eClass();

		theSequencePackage.createPackageContents();

		theSequencePackage.initializePackageContents();

		theSequencePackage.freeze();

		EPackage.Registry.INSTANCE.put(SequencePackage.eNS_URI, theSequencePackage);
		return theSequencePackage;
	}

	public EClass getSequenceTrace() {
		return sequenceTraceEClass;
	}

	public EReference getSequenceTrace_Sequences() {
		return (EReference) sequenceTraceEClass.getEStructuralFeatures().get(0);
	}

	public EClass getSequence() {
		return sequenceEClass;
	}

	public EReference getSequence_States() {
		return (EReference) sequenceEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSequence_ActivityExecution() {
		return (EReference) sequenceEClass.getEStructuralFeatures().get(1);
	}

	public EClass getState() {
		return stateEClass;
	}

	public EReference getState_Objects() {
		return (EReference) stateEClass.getEStructuralFeatures().get(0);
	}

	public EReference getState_Links() {
		return (EReference) stateEClass.getEStructuralFeatures().get(1);
	}

	public EReference getState_Successor() {
		return (EReference) stateEClass.getEStructuralFeatures().get(2);
	}

	public EReference getState_Predecessor() {
		return (EReference) stateEClass.getEStructuralFeatures().get(3);
	}

	public EReference getState_NodeExecution() {
		return (EReference) stateEClass.getEStructuralFeatures().get(4);
	}

	public SequenceFactory getSequenceFactory() {
		return (SequenceFactory) getEFactoryInstance();
	}

	private boolean isCreated = false;

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		sequenceTraceEClass = createEClass(SEQUENCE_TRACE);
		createEReference(sequenceTraceEClass, SEQUENCE_TRACE__SEQUENCES);

		sequenceEClass = createEClass(SEQUENCE);
		createEReference(sequenceEClass, SEQUENCE__STATES);
		createEReference(sequenceEClass, SEQUENCE__ACTIVITY_EXECUTION);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__OBJECTS);
		createEReference(stateEClass, STATE__LINKS);
		createEReference(stateEClass, STATE__SUCCESSOR);
		createEReference(stateEClass, STATE__PREDECESSOR);
		createEReference(stateEClass, STATE__NODE_EXECUTION);
	}

	private boolean isInitialized = false;

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		TracemodelPackage theTracemodelPackage = (TracemodelPackage) EPackage.Registry.INSTANCE.getEPackage(TracemodelPackage.eNS_URI);
		org.modelexecution.fuml.Semantics.Classes.Kernel.KernelPackage theKernelPackage_1 = (org.modelexecution.fuml.Semantics.Classes.Kernel.KernelPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.modelexecution.fuml.Semantics.Classes.Kernel.KernelPackage.eNS_URI);

		initEClass(sequenceTraceEClass, SequenceTrace.class, "SequenceTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceTrace_Sequences(), this.getSequence(), null, "sequences", null, 0, -1, SequenceTrace.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequence_States(), this.getState(), null, "states", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_ActivityExecution(), theTracemodelPackage.getActivityExecution(), null, "activityExecution", null, 1, 1,
				Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sequenceEClass, null, "addState", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getState(), "state", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sequenceEClass, this.getState(), "lastState", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sequenceEClass, this.getState(), "firstState", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_Objects(), theKernelPackage_1.getObject(), null, "objects", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Links(), theKernelPackage_1.getLink(), null, "links", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Successor(), this.getState(), this.getState_Predecessor(), "successor", null, 0, 1, State.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_Predecessor(), this.getState(), this.getState_Successor(), "predecessor", null, 0, 1, State.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_NodeExecution(), theTracemodelPackage.getActivityNodeExecution(), null, "nodeExecution", null, 1, 1, State.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		createResource(eNS_URI);
	}
}