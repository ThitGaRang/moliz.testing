/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

import org.modelexecution.xmof.Syntax.Activities.IntermediateActivities.Activity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getActivityUnderTest <em>Activity Under Test</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getContextObject <em>Context Object</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getInitScenarios <em>Init Scenarios</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl#getAssertions <em>Assertions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFTestCaseImpl extends MinimalEObjectImpl.Container implements XMOFTestCase
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getActivityUnderTest() <em>Activity Under Test</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActivityUnderTest()
   * @generated
   * @ordered
   */
  protected Activity activityUnderTest;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<XMOFActivityInput> inputs;

  /**
   * The cached value of the '{@link #getContextObject() <em>Context Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextObject()
   * @generated
   * @ordered
   */
  protected XMOFObjectSpecification contextObject;

  /**
   * The cached value of the '{@link #getInitScenarios() <em>Init Scenarios</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitScenarios()
   * @generated
   * @ordered
   */
  protected EList<XMOFScenario> initScenarios;

  /**
   * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertions()
   * @generated
   * @ordered
   */
  protected EList<XMOFAssertion> assertions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFTestCaseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return XmofTestLangPackage.Literals.XMOF_TEST_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_TEST_CASE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity getActivityUnderTest()
  {
    if (activityUnderTest != null && activityUnderTest.eIsProxy())
    {
      InternalEObject oldActivityUnderTest = (InternalEObject)activityUnderTest;
      activityUnderTest = (Activity)eResolveProxy(oldActivityUnderTest);
      if (activityUnderTest != oldActivityUnderTest)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST, oldActivityUnderTest, activityUnderTest));
      }
    }
    return activityUnderTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity basicGetActivityUnderTest()
  {
    return activityUnderTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActivityUnderTest(Activity newActivityUnderTest)
  {
    Activity oldActivityUnderTest = activityUnderTest;
    activityUnderTest = newActivityUnderTest;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST, oldActivityUnderTest, activityUnderTest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFActivityInput> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<XMOFActivityInput>(XMOFActivityInput.class, this, XmofTestLangPackage.XMOF_TEST_CASE__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification getContextObject()
  {
    if (contextObject != null && contextObject.eIsProxy())
    {
      InternalEObject oldContextObject = (InternalEObject)contextObject;
      contextObject = (XMOFObjectSpecification)eResolveProxy(oldContextObject);
      if (contextObject != oldContextObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT, oldContextObject, contextObject));
      }
    }
    return contextObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification basicGetContextObject()
  {
    return contextObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContextObject(XMOFObjectSpecification newContextObject)
  {
    XMOFObjectSpecification oldContextObject = contextObject;
    contextObject = newContextObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT, oldContextObject, contextObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFScenario> getInitScenarios()
  {
    if (initScenarios == null)
    {
      initScenarios = new EObjectResolvingEList<XMOFScenario>(XMOFScenario.class, this, XmofTestLangPackage.XMOF_TEST_CASE__INIT_SCENARIOS);
    }
    return initScenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFAssertion> getAssertions()
  {
    if (assertions == null)
    {
      assertions = new EObjectContainmentEList<XMOFAssertion>(XMOFAssertion.class, this, XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS);
    }
    return assertions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case XmofTestLangPackage.XMOF_TEST_CASE__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS:
        return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case XmofTestLangPackage.XMOF_TEST_CASE__NAME:
        return getName();
      case XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST:
        if (resolve) return getActivityUnderTest();
        return basicGetActivityUnderTest();
      case XmofTestLangPackage.XMOF_TEST_CASE__INPUTS:
        return getInputs();
      case XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT:
        if (resolve) return getContextObject();
        return basicGetContextObject();
      case XmofTestLangPackage.XMOF_TEST_CASE__INIT_SCENARIOS:
        return getInitScenarios();
      case XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS:
        return getAssertions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XmofTestLangPackage.XMOF_TEST_CASE__NAME:
        setName((String)newValue);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST:
        setActivityUnderTest((Activity)newValue);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends XMOFActivityInput>)newValue);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT:
        setContextObject((XMOFObjectSpecification)newValue);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__INIT_SCENARIOS:
        getInitScenarios().clear();
        getInitScenarios().addAll((Collection<? extends XMOFScenario>)newValue);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS:
        getAssertions().clear();
        getAssertions().addAll((Collection<? extends XMOFAssertion>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case XmofTestLangPackage.XMOF_TEST_CASE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST:
        setActivityUnderTest((Activity)null);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__INPUTS:
        getInputs().clear();
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT:
        setContextObject((XMOFObjectSpecification)null);
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__INIT_SCENARIOS:
        getInitScenarios().clear();
        return;
      case XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS:
        getAssertions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case XmofTestLangPackage.XMOF_TEST_CASE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XmofTestLangPackage.XMOF_TEST_CASE__ACTIVITY_UNDER_TEST:
        return activityUnderTest != null;
      case XmofTestLangPackage.XMOF_TEST_CASE__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case XmofTestLangPackage.XMOF_TEST_CASE__CONTEXT_OBJECT:
        return contextObject != null;
      case XmofTestLangPackage.XMOF_TEST_CASE__INIT_SCENARIOS:
        return initScenarios != null && !initScenarios.isEmpty();
      case XmofTestLangPackage.XMOF_TEST_CASE__ASSERTIONS:
        return assertions != null && !assertions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //XMOFTestCaseImpl
