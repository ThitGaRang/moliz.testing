/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getActivityUnderTest <em>Activity Under Test</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getContextObject <em>Context Object</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.TestCase#getAssertions <em>Assertions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends EObject
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.TestCase#getName <em>Name</em>}' attribute.
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
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_ActivityUnderTest()
   * @model
   * @generated
   */
  Activity getActivityUnderTest();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.TestCase#getActivityUnderTest <em>Activity Under Test</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Under Test</em>' reference.
   * @see #getActivityUnderTest()
   * @generated
   */
  void setActivityUnderTest(Activity value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.ActivityInput}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<ActivityInput> getInputs();

  /**
   * Returns the value of the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Object</em>' reference.
   * @see #setContextObject(ObjectSpecification)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_ContextObject()
   * @model
   * @generated
   */
  ObjectSpecification getContextObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.TestCase#getContextObject <em>Context Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Object</em>' reference.
   * @see #getContextObject()
   * @generated
   */
  void setContextObject(ObjectSpecification value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.VarDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_Variables()
   * @model containment="true"
   * @generated
   */
  EList<VarDeclaration> getVariables();

  /**
   * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.testLang.Assertion}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertions</em>' containment reference list.
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getTestCase_Assertions()
   * @model containment="true"
   * @generated
   */
  EList<Assertion> getAssertions();

} // TestCase
