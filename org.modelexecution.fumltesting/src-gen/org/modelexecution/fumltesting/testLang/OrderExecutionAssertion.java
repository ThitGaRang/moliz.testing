/**
 */
package org.modelexecution.fumltesting.testLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Execution Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OrderExecutionAssertion#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOrderExecutionAssertion()
 * @model
 * @generated
 */
public interface OrderExecutionAssertion extends Assertion
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
   * @see #setOrder(NodeOrder)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOrderExecutionAssertion_Order()
   * @model containment="true"
   * @generated
   */
  NodeOrder getOrder();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.OrderExecutionAssertion#getOrder <em>Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Order</em>' containment reference.
   * @see #getOrder()
   * @generated
   */
  void setOrder(NodeOrder value);

} // OrderExecutionAssertion
