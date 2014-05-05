/**
 */
package org.modelexecution.fumltesting.core.sequence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.core.sequence.SequenceTrace#getSequences <em>Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.core.sequence.SequencePackage#getSequenceTrace()
 * @model
 * @generated
 */
public interface SequenceTrace extends EObject {
	/**
	 * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link org.modelexecution.fumltesting.core.sequence.Sequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequences</em>' containment reference list.
	 * @see org.modelexecution.fumltesting.core.sequence.SequencePackage#getSequenceTrace_Sequences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sequence> getSequences();

} // SequenceTrace
