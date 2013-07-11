/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.Attribute#getAtt <em>Att</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.Attribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Att</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Att</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Att</em>' reference.
   * @see #setAtt(Property)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getAttribute_Att()
   * @model
   * @generated
   */
  Property getAtt();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.Attribute#getAtt <em>Att</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Att</em>' reference.
   * @see #getAtt()
   * @generated
   */
  void setAtt(Property value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Value)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getAttribute_Value()
   * @model containment="true"
   * @generated
   */
  Value getValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.Attribute#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Value value);

} // Attribute
