/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getReferencePoint <em>Reference Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getUntilPoint <em>Until Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion()
 * @model
 * @generated
 */
public interface XMOFStateAssertion extends XMOFAssertion
{
  /**
   * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier
   * @see #setQuantifier(XMOFTemporalQuantifier)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion_Quantifier()
   * @model
   * @generated
   */
  XMOFTemporalQuantifier getQuantifier();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier
   * @see #getQuantifier()
   * @generated
   */
  void setQuantifier(XMOFTemporalQuantifier value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator
   * @see #setOperator(XMOFTemporalOperator)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion_Operator()
   * @model
   * @generated
   */
  XMOFTemporalOperator getOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(XMOFTemporalOperator value);

  /**
   * Returns the value of the '<em><b>Reference Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Point</em>' containment reference.
   * @see #setReferencePoint(XMOFReferencePoint)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion_ReferencePoint()
   * @model containment="true"
   * @generated
   */
  XMOFReferencePoint getReferencePoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getReferencePoint <em>Reference Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Point</em>' containment reference.
   * @see #getReferencePoint()
   * @generated
   */
  void setReferencePoint(XMOFReferencePoint value);

  /**
   * Returns the value of the '<em><b>Until Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Until Point</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Until Point</em>' containment reference.
   * @see #setUntilPoint(XMOFReferencePoint)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion_UntilPoint()
   * @model containment="true"
   * @generated
   */
  XMOFReferencePoint getUntilPoint();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getUntilPoint <em>Until Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Until Point</em>' containment reference.
   * @see #getUntilPoint()
   * @generated
   */
  void setUntilPoint(XMOFReferencePoint value);

  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFStateAssertion_Checks()
   * @model containment="true"
   * @generated
   */
  EList<XMOFCheck> getChecks();

} // XMOFStateAssertion
