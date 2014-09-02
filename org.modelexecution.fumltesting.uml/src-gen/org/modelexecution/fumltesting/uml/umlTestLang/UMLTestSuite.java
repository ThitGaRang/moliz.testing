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
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getScenario <em>Scenario</em>}</li>
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
   * Returns the value of the '<em><b>Scenario</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario</em>' containment reference.
   * @see #setScenario(UMLScenario)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestSuite_Scenario()
   * @model containment="true"
   * @generated
   */
  UMLScenario getScenario();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getScenario <em>Scenario</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scenario</em>' containment reference.
   * @see #getScenario()
   * @generated
   */
  void setScenario(UMLScenario value);

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
