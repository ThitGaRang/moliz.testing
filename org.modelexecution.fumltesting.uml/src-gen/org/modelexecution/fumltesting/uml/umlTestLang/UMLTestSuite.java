/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getImports <em>Imports</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestSuite()
 * @model
 * @generated
 */
public interface UMLTestSuite extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestSuite_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenarios</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenarios</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestSuite_Scenarios()
   * @model containment="true"
   * @generated
   */
  EList<UMLScenario> getScenarios();

  /**
   * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tests</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestSuite_Tests()
   * @model containment="true"
   * @generated
   */
  EList<UMLTestCase> getTests();

} // UMLTestSuite
