/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.modelexecution.xmof.Syntax.Activities.IntermediateActivities.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getActivityUnderTest <em>Activity Under Test</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getContextObject <em>Context Object</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInitScenarios <em>Init Scenarios</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getAssertions <em>Assertions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase()
 * @model
 * @generated
 */
public interface XMOFTestCase extends EObject
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
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getName <em>Name</em>}' attribute.
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
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_ActivityUnderTest()
   * @model
   * @generated
   */
  Activity getActivityUnderTest();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getActivityUnderTest <em>Activity Under Test</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Activity Under Test</em>' reference.
   * @see #getActivityUnderTest()
   * @generated
   */
  void setActivityUnderTest(Activity value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<XMOFActivityInput> getInputs();

  /**
   * Returns the value of the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Object</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Object</em>' reference.
   * @see #setContextObject(XMOFObjectSpecification)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_ContextObject()
   * @model
   * @generated
   */
  XMOFObjectSpecification getContextObject();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getContextObject <em>Context Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Object</em>' reference.
   * @see #getContextObject()
   * @generated
   */
  void setContextObject(XMOFObjectSpecification value);

  /**
   * Returns the value of the '<em><b>Init Scenarios</b></em>' reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Scenarios</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Scenarios</em>' reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_InitScenarios()
   * @model
   * @generated
   */
  EList<XMOFScenario> getInitScenarios();

  /**
   * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertions</em>' containment reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFTestCase_Assertions()
   * @model containment="true"
   * @generated
   */
  EList<XMOFAssertion> getAssertions();

} // XMOFTestCase
