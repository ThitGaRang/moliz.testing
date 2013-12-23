/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Checking</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.ConstraintChecking#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintChecking()
 * @model
 * @generated
 */
public interface ConstraintChecking extends EObject
{
  /**
   * Returns the value of the '<em><b>Constraints</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.uml2.uml.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintChecking_Constraints()
   * @model
   * @generated
   */
  EList<Constraint> getConstraints();

} // ConstraintChecking
