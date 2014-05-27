/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.xmof.Syntax.Activities.IntermediateActivities.ObjectNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Constraint Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getConstraintNames <em>Constraint Names</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFConstraintCheck()
 * @model
 * @generated
 */
public interface XMOFConstraintCheck extends XMOFCheck
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
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFConstraintCheck_ConstraintNames()
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
   * @see #setObject(ObjectNode)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFConstraintCheck_Object()
   * @model
   * @generated
   */
  ObjectNode getObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getObject <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object</em>' reference.
   * @see #getObject()
   * @generated
   */
  void setObject(ObjectNode value);

} // XMOFConstraintCheck
