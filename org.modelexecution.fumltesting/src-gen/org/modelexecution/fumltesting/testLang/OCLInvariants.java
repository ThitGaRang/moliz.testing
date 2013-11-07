/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Invariants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.OCLInvariants#getInvariants <em>Invariants</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOCLInvariants()
 * @model
 * @generated
 */
public interface OCLInvariants extends EObject
{
  /**
   * Returns the value of the '<em><b>Invariants</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invariants</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invariants</em>' reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getOCLInvariants_Invariants()
   * @model
   * @generated
   */
  EList<InvCS> getInvariants();

} // OCLInvariants
