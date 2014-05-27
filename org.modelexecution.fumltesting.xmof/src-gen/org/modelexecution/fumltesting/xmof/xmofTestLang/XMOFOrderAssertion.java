/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Order Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFOrderAssertion()
 * @model
 * @generated
 */
public interface XMOFOrderAssertion extends XMOFAssertion
{
  /**
   * Returns the value of the '<em><b>Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Order</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Order</em>' containment reference.
   * @see #setOrder(XMOFNodeOrder)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFOrderAssertion_Order()
   * @model containment="true"
   * @generated
   */
  XMOFNodeOrder getOrder();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion#getOrder <em>Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Order</em>' containment reference.
   * @see #getOrder()
   * @generated
   */
  void setOrder(XMOFNodeOrder value);

} // XMOFOrderAssertion
