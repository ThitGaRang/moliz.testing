/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Object Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLObjectSpecification#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLObjectSpecification#getType <em>Type</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLObjectSpecification#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLObjectSpecification()
 * @model
 * @generated
 */
public interface UMLObjectSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLObjectSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLObjectSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(org.eclipse.uml2.uml.Class)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLObjectSpecification_Type()
   * @model
   * @generated
   */
  org.eclipse.uml2.uml.Class getType();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLObjectSpecification#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(org.eclipse.uml2.uml.Class value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.UMLAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLObjectSpecification_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<UMLAttribute> getAttributes();

} // UMLObjectSpecification
