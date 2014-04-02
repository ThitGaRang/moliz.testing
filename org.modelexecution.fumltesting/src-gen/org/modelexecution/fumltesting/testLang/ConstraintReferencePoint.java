/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Reference Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.ConstraintReferencePoint#getConstraintName <em>Constraint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintReferencePoint()
 * @model
 * @generated
 */
public interface ConstraintReferencePoint extends ReferencePoint
{
  /**
   * Returns the value of the '<em><b>Constraint Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Name</em>' containment reference.
   * @see #setConstraintName(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintReferencePoint_ConstraintName()
   * @model containment="true"
   * @generated
   */
  XExpression getConstraintName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.ConstraintReferencePoint#getConstraintName <em>Constraint Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Name</em>' containment reference.
   * @see #getConstraintName()
   * @generated
   */
  void setConstraintName(XExpression value);

} // ConstraintReferencePoint
