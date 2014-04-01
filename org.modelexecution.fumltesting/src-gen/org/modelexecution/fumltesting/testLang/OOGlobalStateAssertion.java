/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OO Global State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getConditionConstraint <em>Condition Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getEvaluatedConstraint <em>Evaluated Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOGlobalStateAssertion()
 * @model
 * @generated
 */
public interface OOGlobalStateAssertion extends Assertion
{
  /**
   * Returns the value of the '<em><b>Condition Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition Constraint</em>' containment reference.
   * @see #setConditionConstraint(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOGlobalStateAssertion_ConditionConstraint()
   * @model containment="true"
   * @generated
   */
  XExpression getConditionConstraint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getConditionConstraint <em>Condition Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition Constraint</em>' containment reference.
   * @see #getConditionConstraint()
   * @generated
   */
  void setConditionConstraint(XExpression value);

  /**
   * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.TemporalQuantifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see #setQuantifier(TemporalQuantifier)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOGlobalStateAssertion_Quantifier()
   * @model
   * @generated
   */
  TemporalQuantifier getQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see #getQuantifier()
   * @generated
   */
  void setQuantifier(TemporalQuantifier value);

  /**
   * Returns the value of the '<em><b>Evaluated Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evaluated Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evaluated Constraint</em>' containment reference.
   * @see #setEvaluatedConstraint(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOGlobalStateAssertion_EvaluatedConstraint()
   * @model containment="true"
   * @generated
   */
  XExpression getEvaluatedConstraint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getEvaluatedConstraint <em>Evaluated Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Evaluated Constraint</em>' containment reference.
   * @see #getEvaluatedConstraint()
   * @generated
   */
  void setEvaluatedConstraint(XExpression value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' reference.
   * @see #setObject(VarDeclaration)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOOGlobalStateAssertion_Object()
   * @model
   * @generated
   */
  VarDeclaration getObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getObject <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' reference.
   * @see #getObject()
   * @generated
   */
  void setObject(VarDeclaration value);

} // OOGlobalStateAssertion
