/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.uml2.uml.ObjectNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateExpression#getPin <em>Pin</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.StateExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateExpression()
 * @model
 * @generated
 */
public interface StateExpression extends Check
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateExpression_Pin()
   * @model
   * @generated
   */
  ObjectNode getPin();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateExpression#getPin <em>Pin</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pin</em>' reference.
   * @see #getPin()
   * @generated
   */
  void setPin(ObjectNode value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.modelexecution.fumltesting.testLang.ArithmeticOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.ArithmeticOperator
   * @see #setOperator(ArithmeticOperator)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateExpression_Operator()
   * @model
   * @generated
   */
  ArithmeticOperator getOperator();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.modelexecution.fumltesting.testLang.ArithmeticOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(ArithmeticOperator value);

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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getStateExpression_Value()
   * @model containment="true"
   * @generated
   */
  Value getValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.StateExpression#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Value value);

} // StateExpression
