/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.modelexecution.xmof.Syntax.Actions.BasicActions.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Action Reference Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFActionReferencePoint()
 * @model
 * @generated
 */
public interface XMOFActionReferencePoint extends XMOFReferencePoint
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(Action)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFActionReferencePoint_Action()
   * @model
   * @generated
   */
  Action getAction();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(Action value);

} // XMOFActionReferencePoint
