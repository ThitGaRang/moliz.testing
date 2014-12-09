/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Finally State Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLFinallyStateAssertion()
 * @model
 * @generated
 */
public interface UMLFinallyStateAssertion extends UMLAssertion
{
  /**
   * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checks</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLFinallyStateAssertion_Checks()
   * @model containment="true"
   * @generated
   */
  EList<UMLCheck> getChecks();

} // UMLFinallyStateAssertion
