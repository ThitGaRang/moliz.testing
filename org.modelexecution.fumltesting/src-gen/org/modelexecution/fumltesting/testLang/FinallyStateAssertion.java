/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finally State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getConstraintCheck <em>Constraint Check</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getFinallyStateAssertion()
 * @model
 * @generated
 */
public interface FinallyStateAssertion extends Assertion
{
  /**
   * Returns the value of the '<em><b>Constraint Check</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.ConstraintCheck}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Check</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Check</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getFinallyStateAssertion_ConstraintCheck()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintCheck> getConstraintCheck();

  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.StateExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getFinallyStateAssertion_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<StateExpression> getExpressions();

} // FinallyStateAssertion
