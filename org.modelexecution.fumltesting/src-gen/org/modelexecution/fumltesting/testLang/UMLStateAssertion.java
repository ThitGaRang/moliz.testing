/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getReferencePoint <em>Reference Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getUntilPoint <em>Until Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion()
 * @model
 * @generated
 */
public interface UMLStateAssertion extends UMLAssertion
{
  /**
   * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.UMLTemporalQuantifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.UMLTemporalQuantifier
   * @see #setQuantifier(UMLTemporalQuantifier)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion_Quantifier()
   * @model
   * @generated
   */
  UMLTemporalQuantifier getQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.UMLTemporalQuantifier
   * @see #getQuantifier()
   * @generated
   */
  void setQuantifier(UMLTemporalQuantifier value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.UMLTemporalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.UMLTemporalOperator
   * @see #setOperator(UMLTemporalOperator)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion_Operator()
   * @model
   * @generated
   */
  UMLTemporalOperator getOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.UMLTemporalOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UMLTemporalOperator value);

  /**
   * Returns the value of the '<em><b>Reference Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Point</em>' containment reference.
   * @see #setReferencePoint(UMLReferencePoint)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion_ReferencePoint()
   * @model containment="true"
   * @generated
   */
  UMLReferencePoint getReferencePoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getReferencePoint <em>Reference Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Point</em>' containment reference.
   * @see #getReferencePoint()
   * @generated
   */
  void setReferencePoint(UMLReferencePoint value);

  /**
   * Returns the value of the '<em><b>Until Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Point</em>' containment reference.
   * @see #setUntilPoint(UMLReferencePoint)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion_UntilPoint()
   * @model containment="true"
   * @generated
   */
  UMLReferencePoint getUntilPoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLStateAssertion#getUntilPoint <em>Until Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Point</em>' containment reference.
   * @see #getUntilPoint()
   * @generated
   */
  void setUntilPoint(UMLReferencePoint value);

  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.UMLCheck}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLStateAssertion_Checks()
   * @model containment="true"
   * @generated
   */
  EList<UMLCheck> getChecks();

} // UMLStateAssertion
