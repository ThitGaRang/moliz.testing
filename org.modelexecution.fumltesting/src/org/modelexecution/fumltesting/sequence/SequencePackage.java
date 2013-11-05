/**
 */
package org.modelexecution.fumltesting.sequence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.sequence.SequenceFactory
 * @model kind="package"
 * @generated
 */
public interface SequencePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sequence";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.modelexecution.org/sequence";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sequence";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SequencePackage eINSTANCE = org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.modelexecution.fumltesting.sequence.impl.SequenceTraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelexecution.fumltesting.sequence.impl.SequenceTraceImpl
	 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getSequenceTrace()
	 * @generated
	 */
	int SEQUENCE_TRACE = 0;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TRACE__SEQUENCES = 0;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TRACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.modelexecution.fumltesting.sequence.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelexecution.fumltesting.sequence.impl.SequenceImpl
	 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__STATES = 0;

	/**
	 * The feature id for the '<em><b>Activity Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ACTIVITY_EXECUTION = 1;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.modelexecution.fumltesting.sequence.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.modelexecution.fumltesting.sequence.impl.StateImpl
	 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OBJECTS = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LINKS = 1;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUCCESSOR = 2;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PREDECESSOR = 3;

	/**
	 * The feature id for the '<em><b>Node Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NODE_EXECUTION = 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.modelexecution.fumltesting.sequence.SequenceTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.modelexecution.fumltesting.sequence.SequenceTrace
	 * @generated
	 */
	EClass getSequenceTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.sequence.SequenceTrace#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see org.modelexecution.fumltesting.sequence.SequenceTrace#getSequences()
	 * @see #getSequenceTrace()
	 * @generated
	 */
	EReference getSequenceTrace_Sequences();

	/**
	 * Returns the meta object for class '{@link org.modelexecution.fumltesting.sequence.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.modelexecution.fumltesting.sequence.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.sequence.Sequence#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.modelexecution.fumltesting.sequence.Sequence#getStates()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_States();

	/**
	 * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.sequence.Sequence#getActivityExecution <em>Activity Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity Execution</em>'.
	 * @see org.modelexecution.fumltesting.sequence.Sequence#getActivityExecution()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_ActivityExecution();

	/**
	 * Returns the meta object for class '{@link org.modelexecution.fumltesting.sequence.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link org.modelexecution.fumltesting.sequence.State#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objects</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State#getObjects()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Objects();

	/**
	 * Returns the meta object for the reference list '{@link org.modelexecution.fumltesting.sequence.State#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State#getLinks()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Links();

	/**
	 * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.sequence.State#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State#getSuccessor()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Successor();

	/**
	 * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.sequence.State#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State#getPredecessor()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.sequence.State#getNodeExecution <em>Node Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Execution</em>'.
	 * @see org.modelexecution.fumltesting.sequence.State#getNodeExecution()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_NodeExecution();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SequenceFactory getSequenceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.modelexecution.fumltesting.sequence.impl.SequenceTraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelexecution.fumltesting.sequence.impl.SequenceTraceImpl
		 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getSequenceTrace()
		 * @generated
		 */
		EClass SEQUENCE_TRACE = eINSTANCE.getSequenceTrace();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_TRACE__SEQUENCES = eINSTANCE.getSequenceTrace_Sequences();

		/**
		 * The meta object literal for the '{@link org.modelexecution.fumltesting.sequence.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelexecution.fumltesting.sequence.impl.SequenceImpl
		 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__STATES = eINSTANCE.getSequence_States();

		/**
		 * The meta object literal for the '<em><b>Activity Execution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__ACTIVITY_EXECUTION = eINSTANCE.getSequence_ActivityExecution();

		/**
		 * The meta object literal for the '{@link org.modelexecution.fumltesting.sequence.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.modelexecution.fumltesting.sequence.impl.StateImpl
		 * @see org.modelexecution.fumltesting.sequence.impl.SequencePackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OBJECTS = eINSTANCE.getState_Objects();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__LINKS = eINSTANCE.getState_Links();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUCCESSOR = eINSTANCE.getState_Successor();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__PREDECESSOR = eINSTANCE.getState_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Node Execution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__NODE_EXECUTION = eINSTANCE.getState_NodeExecution();

	}

} //SequencePackage
