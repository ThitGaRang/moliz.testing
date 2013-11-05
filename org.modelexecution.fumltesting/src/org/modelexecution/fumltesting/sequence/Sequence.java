/**
 */
package org.modelexecution.fumltesting.sequence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.sequence.Sequence#getStates <em>States</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.sequence.Sequence#getActivityExecution <em>Activity Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelexecution.fumltesting.sequence.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getSequence_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Activity Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Execution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Execution</em>' reference.
	 * @see #setActivityExecution(ActivityExecution)
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getSequence_ActivityExecution()
	 * @model required="true"
	 * @generated
	 */
	ActivityExecution getActivityExecution();

	/**
	 * Sets the value of the '{@link org.modelexecution.fumltesting.sequence.Sequence#getActivityExecution <em>Activity Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity Execution</em>' reference.
	 * @see #getActivityExecution()
	 * @generated
	 */
	void setActivityExecution(ActivityExecution value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addState(State state);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	State lastState();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	State firstState();

} // Sequence
