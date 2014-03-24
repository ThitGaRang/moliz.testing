/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.ConstraintCheck#getConstraintNames <em>Constraint Names</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.ConstraintCheck#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintCheck()
 * @model
 * @generated
 */
public interface ConstraintCheck extends EObject
{
  /**
   * Returns the value of the '<em><b>Constraint Names</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Names</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintCheck_ConstraintNames()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getConstraintNames();

  /**
   * Returns the value of the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object</em>' reference.
   * @see #setObject(VarDeclaration)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getConstraintCheck_Object()
   * @model
   * @generated
   */
  VarDeclaration getObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.ConstraintCheck#getObject <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' reference.
   * @see #getObject()
   * @generated
   */
  void setObject(VarDeclaration value);

} // ConstraintCheck
