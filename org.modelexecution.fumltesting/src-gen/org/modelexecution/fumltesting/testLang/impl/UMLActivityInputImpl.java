/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.ActivityParameterNode;

import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLActivityInput;
import org.modelexecution.fumltesting.testLang.UMLValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Activity Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLActivityInputImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLActivityInputImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLActivityInputImpl extends MinimalEObjectImpl.Container implements UMLActivityInput
{
  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected ActivityParameterNode parameter;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected UMLValue value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLActivityInputImpl()
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
    return TestLangPackage.Literals.UML_ACTIVITY_INPUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityParameterNode getParameter()
  {
    if (parameter != null && parameter.eIsProxy())
    {
      InternalEObject oldParameter = (InternalEObject)parameter;
      parameter = (ActivityParameterNode)eResolveProxy(oldParameter);
      if (parameter != oldParameter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER, oldParameter, parameter));
      }
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityParameterNode basicGetParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(ActivityParameterNode newParameter)
  {
    ActivityParameterNode oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(UMLValue newValue, NotificationChain msgs)
  {
    UMLValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_ACTIVITY_INPUT__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(UMLValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.UML_ACTIVITY_INPUT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.UML_ACTIVITY_INPUT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_ACTIVITY_INPUT__VALUE, newValue, newValue));
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
      case TestLangPackage.UML_ACTIVITY_INPUT__VALUE:
        return basicSetValue(null, msgs);
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
      case TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case TestLangPackage.UML_ACTIVITY_INPUT__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER:
        setParameter((ActivityParameterNode)newValue);
        return;
      case TestLangPackage.UML_ACTIVITY_INPUT__VALUE:
        setValue((UMLValue)newValue);
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
      case TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER:
        setParameter((ActivityParameterNode)null);
        return;
      case TestLangPackage.UML_ACTIVITY_INPUT__VALUE:
        setValue((UMLValue)null);
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
      case TestLangPackage.UML_ACTIVITY_INPUT__PARAMETER:
        return parameter != null;
      case TestLangPackage.UML_ACTIVITY_INPUT__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //UMLActivityInputImpl
