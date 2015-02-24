/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Order Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLOrderAssertion()
 * @model
 * @generated
 */
public interface UMLOrderAssertion extends UMLAssertion
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
   * @see #setOrder(UMLNodeOrder)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLOrderAssertion_Order()
   * @model containment="true"
   * @generated
   */
  UMLNodeOrder getOrder();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion#getOrder <em>Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Order</em>' containment reference.
   * @see #getOrder()
   * @generated
   */
  void setOrder(UMLNodeOrder value);

} // UMLOrderAssertion
