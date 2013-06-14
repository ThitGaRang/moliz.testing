/**
 */
package org.modelexecution.fumltesting.testLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.ObjectValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getObjectValue()
 * @model
 * @generated
 */
public interface ObjectValue extends Value
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(ObjectSpecification)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getObjectValue_Value()
   * @model
   * @generated
   */
  ObjectSpecification getValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.ObjectValue#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ObjectSpecification value);

} // ObjectValue
