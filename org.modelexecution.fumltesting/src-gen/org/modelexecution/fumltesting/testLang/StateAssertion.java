/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getReferencePoint <em>Reference Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getUntilPoint <em>Until Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateAssertion#getChecks <em>Checks</em>}</li>
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_Quantifier()
   * @model
   * @generated
   */
  TemporalQuantifier getQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see #getQuantifier()
   * @generated
   */
  void setQuantifier(TemporalQuantifier value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.TemporalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see #setOperator(TemporalOperator)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_Operator()
   * @model
   * @generated
   */
  TemporalOperator getOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(TemporalOperator value);

  /**
   * Returns the value of the '<em><b>Reference Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Point</em>' containment reference.
   * @see #setReferencePoint(ReferencePoint)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_ReferencePoint()
   * @model containment="true"
   * @generated
   */
  ReferencePoint getReferencePoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getReferencePoint <em>Reference Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Point</em>' containment reference.
   * @see #getReferencePoint()
   * @generated
   */
  void setReferencePoint(ReferencePoint value);

  /**
   * Returns the value of the '<em><b>Until Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Point</em>' containment reference.
   * @see #setUntilPoint(ReferencePoint)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_UntilPoint()
   * @model containment="true"
   * @generated
   */
  ReferencePoint getUntilPoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getUntilPoint <em>Until Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Point</em>' containment reference.
   * @see #getUntilPoint()
   * @generated
   */
  void setUntilPoint(ReferencePoint value);

  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.Check}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateAssertion_Checks()
   * @model containment="true"
   * @generated
   */
  EList<Check> getChecks();

} // StateAssertion
