/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Node Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLNodeOrder#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeOrder()
 * @model
 * @generated
 */
public interface UMLNodeOrder extends EObject
{
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeOrder_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<UMLNodeSpecification> getNodes();

} // UMLNodeOrder
