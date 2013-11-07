/**
 */
package org.modelexecution.fumltesting.testLang.impl;

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

import org.eclipse.uml2.uml.Activity;

import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.OCLInvariants;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getActivityUnderTest <em>Activity Under Test</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getContextObject <em>Context Object</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getInitScenarios <em>Init Scenarios</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl#getAssertions <em>Assertions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseImpl extends MinimalEObjectImpl.Container implements TestCase
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
  protected EList<ActivityInput> inputs;

  /**
   * The cached value of the '{@link #getContextObject() <em>Context Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextObject()
   * @generated
   * @ordered
   */
  protected ObjectSpecification contextObject;

  /**
   * The cached value of the '{@link #getInitScenarios() <em>Init Scenarios</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitScenarios()
   * @generated
   * @ordered
   */
  protected EList<Scenario> initScenarios;

  /**
   * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInvariants()
   * @generated
   * @ordered
   */
  protected OCLInvariants invariants;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<VarDeclaration> variables;

  /**
   * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssertions()
   * @generated
   * @ordered
   */
  protected EList<Assertion> assertions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestCaseImpl()
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
    return TestLangPackage.Literals.TEST_CASE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.TEST_CASE__NAME, oldName, name));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST, oldActivityUnderTest, activityUnderTest));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST, oldActivityUnderTest, activityUnderTest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActivityInput> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<ActivityInput>(ActivityInput.class, this, TestLangPackage.TEST_CASE__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification getContextObject()
  {
    if (contextObject != null && contextObject.eIsProxy())
    {
      InternalEObject oldContextObject = (InternalEObject)contextObject;
      contextObject = (ObjectSpecification)eResolveProxy(oldContextObject);
      if (contextObject != oldContextObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.TEST_CASE__CONTEXT_OBJECT, oldContextObject, contextObject));
      }
    }
    return contextObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification basicGetContextObject()
  {
    return contextObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContextObject(ObjectSpecification newContextObject)
  {
    ObjectSpecification oldContextObject = contextObject;
    contextObject = newContextObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.TEST_CASE__CONTEXT_OBJECT, oldContextObject, contextObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Scenario> getInitScenarios()
  {
    if (initScenarios == null)
    {
      initScenarios = new EObjectResolvingEList<Scenario>(Scenario.class, this, TestLangPackage.TEST_CASE__INIT_SCENARIOS);
    }
    return initScenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OCLInvariants getInvariants()
  {
    return invariants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInvariants(OCLInvariants newInvariants, NotificationChain msgs)
  {
    OCLInvariants oldInvariants = invariants;
    invariants = newInvariants;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.TEST_CASE__INVARIANTS, oldInvariants, newInvariants);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInvariants(OCLInvariants newInvariants)
  {
    if (newInvariants != invariants)
    {
      NotificationChain msgs = null;
      if (invariants != null)
        msgs = ((InternalEObject)invariants).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.TEST_CASE__INVARIANTS, null, msgs);
      if (newInvariants != null)
        msgs = ((InternalEObject)newInvariants).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.TEST_CASE__INVARIANTS, null, msgs);
      msgs = basicSetInvariants(newInvariants, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.TEST_CASE__INVARIANTS, newInvariants, newInvariants));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VarDeclaration> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, TestLangPackage.TEST_CASE__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Assertion> getAssertions()
  {
    if (assertions == null)
    {
      assertions = new EObjectContainmentEList<Assertion>(Assertion.class, this, TestLangPackage.TEST_CASE__ASSERTIONS);
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
      case TestLangPackage.TEST_CASE__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case TestLangPackage.TEST_CASE__INVARIANTS:
        return basicSetInvariants(null, msgs);
      case TestLangPackage.TEST_CASE__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case TestLangPackage.TEST_CASE__ASSERTIONS:
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
      case TestLangPackage.TEST_CASE__NAME:
        return getName();
      case TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST:
        if (resolve) return getActivityUnderTest();
        return basicGetActivityUnderTest();
      case TestLangPackage.TEST_CASE__INPUTS:
        return getInputs();
      case TestLangPackage.TEST_CASE__CONTEXT_OBJECT:
        if (resolve) return getContextObject();
        return basicGetContextObject();
      case TestLangPackage.TEST_CASE__INIT_SCENARIOS:
        return getInitScenarios();
      case TestLangPackage.TEST_CASE__INVARIANTS:
        return getInvariants();
      case TestLangPackage.TEST_CASE__VARIABLES:
        return getVariables();
      case TestLangPackage.TEST_CASE__ASSERTIONS:
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
      case TestLangPackage.TEST_CASE__NAME:
        setName((String)newValue);
        return;
      case TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST:
        setActivityUnderTest((Activity)newValue);
        return;
      case TestLangPackage.TEST_CASE__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends ActivityInput>)newValue);
        return;
      case TestLangPackage.TEST_CASE__CONTEXT_OBJECT:
        setContextObject((ObjectSpecification)newValue);
        return;
      case TestLangPackage.TEST_CASE__INIT_SCENARIOS:
        getInitScenarios().clear();
        getInitScenarios().addAll((Collection<? extends Scenario>)newValue);
        return;
      case TestLangPackage.TEST_CASE__INVARIANTS:
        setInvariants((OCLInvariants)newValue);
        return;
      case TestLangPackage.TEST_CASE__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends VarDeclaration>)newValue);
        return;
      case TestLangPackage.TEST_CASE__ASSERTIONS:
        getAssertions().clear();
        getAssertions().addAll((Collection<? extends Assertion>)newValue);
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
      case TestLangPackage.TEST_CASE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST:
        setActivityUnderTest((Activity)null);
        return;
      case TestLangPackage.TEST_CASE__INPUTS:
        getInputs().clear();
        return;
      case TestLangPackage.TEST_CASE__CONTEXT_OBJECT:
        setContextObject((ObjectSpecification)null);
        return;
      case TestLangPackage.TEST_CASE__INIT_SCENARIOS:
        getInitScenarios().clear();
        return;
      case TestLangPackage.TEST_CASE__INVARIANTS:
        setInvariants((OCLInvariants)null);
        return;
      case TestLangPackage.TEST_CASE__VARIABLES:
        getVariables().clear();
        return;
      case TestLangPackage.TEST_CASE__ASSERTIONS:
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
      case TestLangPackage.TEST_CASE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TestLangPackage.TEST_CASE__ACTIVITY_UNDER_TEST:
        return activityUnderTest != null;
      case TestLangPackage.TEST_CASE__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case TestLangPackage.TEST_CASE__CONTEXT_OBJECT:
        return contextObject != null;
      case TestLangPackage.TEST_CASE__INIT_SCENARIOS:
        return initScenarios != null && !initScenarios.isEmpty();
      case TestLangPackage.TEST_CASE__INVARIANTS:
        return invariants != null;
      case TestLangPackage.TEST_CASE__VARIABLES:
        return variables != null && !variables.isEmpty();
      case TestLangPackage.TEST_CASE__ASSERTIONS:
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

} //TestCaseImpl
