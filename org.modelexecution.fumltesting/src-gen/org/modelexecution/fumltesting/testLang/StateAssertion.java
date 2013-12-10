/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalOperator <em>Temporal Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getReferenceAction <em>Reference Action</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getUntilAction <em>Until Action</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion()
 * @model
 * @generated
 */
public interface StateAssertion extends Assertion
{
  /**
   * Returns the value of the '<em><b>Temporal Quantifier</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.TemporalQuantifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Temporal Quantifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Temporal Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see #setTemporalQuantifier(TemporalQuantifier)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_TemporalQuantifier()
   * @model
   * @generated
   */
  TemporalQuantifier getTemporalQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Temporal Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see #getTemporalQuantifier()
   * @generated
   */
  void setTemporalQuantifier(TemporalQuantifier value);

  /**
   * Returns the value of the '<em><b>Temporal Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.TemporalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Temporal Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Temporal Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see #setTemporalOperator(TemporalOperator)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_TemporalOperator()
   * @model
   * @generated
   */
  TemporalOperator getTemporalOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalOperator <em>Temporal Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Temporal Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see #getTemporalOperator()
   * @generated
   */
  void setTemporalOperator(TemporalOperator value);

  /**
   * Returns the value of the '<em><b>Reference Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Action</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Action</em>' reference.
   * @see #setReferenceAction(Action)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_ReferenceAction()
   * @model
   * @generated
   */
  Action getReferenceAction();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getReferenceAction <em>Reference Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Action</em>' reference.
   * @see #getReferenceAction()
   * @generated
   */
  void setReferenceAction(Action value);

  /**
   * Returns the value of the '<em><b>Until Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Action</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Action</em>' reference.
   * @see #setUntilAction(Action)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_UntilAction()
   * @model
   * @generated
   */
  Action getUntilAction();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getUntilAction <em>Until Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Action</em>' reference.
   * @see #getUntilAction()
   * @generated
   */
  void setUntilAction(Action value);

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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<StateExpression> getExpressions();

} // StateAssertion
