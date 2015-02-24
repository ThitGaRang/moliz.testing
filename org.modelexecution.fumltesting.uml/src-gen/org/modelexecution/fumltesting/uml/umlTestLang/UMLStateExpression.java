/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import org.eclipse.uml2.uml.ObjectNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML State Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getPin <em>Pin</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLStateExpression()
 * @model
 * @generated
 */
public interface UMLStateExpression extends UMLCheck
{
  /**
   * Returns the value of the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pin</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pin</em>' reference.
   * @see #setPin(ObjectNode)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLStateExpression_Pin()
   * @model
   * @generated
   */
  ObjectNode getPin();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getPin <em>Pin</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pin</em>' reference.
   * @see #getPin()
   * @generated
   */
  void setPin(ObjectNode value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator
   * @see #setOperator(UMLArithmeticOperator)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLStateExpression_Operator()
   * @model
   * @generated
   */
  UMLArithmeticOperator getOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UMLArithmeticOperator value);

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
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLStateExpression_Value()
   * @model containment="true"
   * @generated
   */
  UMLValue getValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(UMLValue value);

} // UMLStateExpression
