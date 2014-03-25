/**
 */
package org.modelexecution.fumltesting.sequence;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.sequence.State#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.sequence.State#getLinks <em>Links</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.sequence.State#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.sequence.State#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.sequence.State#getNodeExecution <em>Node Execution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	
	/**
	 * @generated NOT
	 * Returns a snapshot of a given instance for this state.
	 */
	org.modelexecution.fuml.Semantics.Classes.Kernel.Object getStateSnapshot(ValueInstance instance);
	
	/**
	 * @generated NOT
	 * Add snapshot mapping to the state.
	 */
	void addSnapshotMapping(ValueInstance instance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot);
	
	/**
	 * @generated NOT
	 * Get value instances existing in the state.
	 */
	Set<ValueInstance> getValueInstances();
	
	/**
	 * @generated NOT
	 * Copy snapshot mappings to another state.
	 */
	
	void copySnapshotMappings(State anotherState);
	
	/**
	 * Returns the value of the '<em><b>Objects</b></em>' reference list.
	 * The list contents are of type {@link org.modelexecution.fuml.Semantics.Classes.Kernel.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' reference list.
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState_Objects()
	 * @model
	 * @generated
	 */
	EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> getObjects();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link org.modelexecution.fuml.Semantics.Classes.Kernel.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState_Links()
	 * @model
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.modelexecution.fumltesting.sequence.State#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(State)
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState_Successor()
	 * @see org.modelexecution.fumltesting.sequence.State#getPredecessor
	 * @model opposite="predecessor"
	 * @generated
	 */
	State getSuccessor();

	/**
	 * Sets the value of the '{@link org.modelexecution.fumltesting.sequence.State#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(State value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.modelexecution.fumltesting.sequence.State#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(State)
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState_Predecessor()
	 * @see org.modelexecution.fumltesting.sequence.State#getSuccessor
	 * @model opposite="successor"
	 * @generated
	 */
	State getPredecessor();

	/**
	 * Sets the value of the '{@link org.modelexecution.fumltesting.sequence.State#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(State value);

	/**
	 * Returns the value of the '<em><b>Node Execution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Execution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Execution</em>' reference.
	 * @see #setNodeExecution(ActivityNodeExecution)
	 * @see org.modelexecution.fumltesting.sequence.SequencePackage#getState_NodeExecution()
	 * @model required="true"
	 * @generated
	 */
	ActivityNodeExecution getNodeExecution();

	/**
	 * Sets the value of the '{@link org.modelexecution.fumltesting.sequence.State#getNodeExecution <em>Node Execution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Execution</em>' reference.
	 * @see #getNodeExecution()
	 * @generated
	 */
	void setNodeExecution(ActivityNodeExecution value);

} // State
