/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OO State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalOperator <em>Temporal Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getReferenceConstraint <em>Reference Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getUntilConstraint <em>Until Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getConstraintCheck <em>Constraint Check</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion()
 * @model
 * @generated
 */
public interface OOStateAssertion extends Assertion
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_TemporalQuantifier()
   * @model
   * @generated
   */
  TemporalQuantifier getTemporalQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}' attribute.
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_TemporalOperator()
   * @model
   * @generated
   */
  TemporalOperator getTemporalOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalOperator <em>Temporal Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Temporal Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see #getTemporalOperator()
   * @generated
   */
  void setTemporalOperator(TemporalOperator value);

  /**
   * Returns the value of the '<em><b>Reference Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Constraint</em>' containment reference.
   * @see #setReferenceConstraint(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_ReferenceConstraint()
   * @model containment="true"
   * @generated
   */
  XExpression getReferenceConstraint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getReferenceConstraint <em>Reference Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Constraint</em>' containment reference.
   * @see #getReferenceConstraint()
   * @generated
   */
  void setReferenceConstraint(XExpression value);

  /**
   * Returns the value of the '<em><b>Until Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Constraint</em>' containment reference.
   * @see #setUntilConstraint(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_UntilConstraint()
   * @model containment="true"
   * @generated
   */
  XExpression getUntilConstraint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getUntilConstraint <em>Until Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Constraint</em>' containment reference.
   * @see #getUntilConstraint()
   * @generated
   */
  void setUntilConstraint(XExpression value);

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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_ConstraintCheck()
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOStateAssertion_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<StateExpression> getExpressions();

} // OOStateAssertion
