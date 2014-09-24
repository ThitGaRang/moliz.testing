/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getActivityUnderTest <em>Activity Under Test</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getContextObject <em>Context Object</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInitScenario <em>Init Scenario</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getAssertions <em>Assertions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase()
 * @model
 * @generated
 */
public interface UMLTestCase extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Activity Under Test</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Activity Under Test</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Activity Under Test</em>' reference.
   * @see #setActivityUnderTest(Activity)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_ActivityUnderTest()
   * @model
   * @generated
   */
  Activity getActivityUnderTest();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getActivityUnderTest <em>Activity Under Test</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Under Test</em>' reference.
   * @see #getActivityUnderTest()
   * @generated
   */
  void setActivityUnderTest(Activity value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<UMLActivityInput> getInputs();

  /**
   * Returns the value of the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Object</em>' reference.
   * @see #setContextObject(UMLObjectSpecification)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_ContextObject()
   * @model
   * @generated
   */
  UMLObjectSpecification getContextObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getContextObject <em>Context Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Object</em>' reference.
   * @see #getContextObject()
   * @generated
   */
  void setContextObject(UMLObjectSpecification value);

  /**
   * Returns the value of the '<em><b>Init Scenario</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Scenario</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Scenario</em>' reference.
   * @see #setInitScenario(UMLScenario)
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_InitScenario()
   * @model
   * @generated
   */
  UMLScenario getInitScenario();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInitScenario <em>Init Scenario</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Scenario</em>' reference.
   * @see #getInitScenario()
   * @generated
   */
  void setInitScenario(UMLScenario value);

  /**
   * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertions</em>' containment reference list.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTestCase_Assertions()
   * @model containment="true"
   * @generated
   */
  EList<UMLAssertion> getAssertions();

} // UMLTestCase
