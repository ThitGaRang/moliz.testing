/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.ActivityParameterNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Activity Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLActivityInput()
 * @model
 * @generated
 */
public interface UMLActivityInput extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' reference.
   * @see #setParameter(ActivityParameterNode)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLActivityInput_Parameter()
   * @model
   * @generated
   */
  ActivityParameterNode getParameter();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getParameter <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(ActivityParameterNode value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(UMLValue)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLActivityInput_Value()
   * @model containment="true"
   * @generated
   */
  UMLValue getValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(UMLValue value);

} // UMLActivityInput
