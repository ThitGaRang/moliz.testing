/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finally State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getFinallyStateAssertion()
 * @model
 * @generated
 */
public interface FinallyStateAssertion extends XMOFFinallyStateAssertion
{
  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getFinallyStateAssertion_Checks()
   * @model containment="true"
   * @generated
   */
  EList<XMOFCheck> getChecks();

} // FinallyStateAssertion
