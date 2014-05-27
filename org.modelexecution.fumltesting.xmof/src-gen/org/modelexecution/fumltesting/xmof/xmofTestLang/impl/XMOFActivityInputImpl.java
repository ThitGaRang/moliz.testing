/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

import org.modelexecution.xmof.Syntax.Activities.IntermediateActivities.ActivityParameterNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF Activity Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFActivityInputImpl extends MinimalEObjectImpl.Container implements XMOFActivityInput
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
  protected XMOFValue value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFActivityInputImpl()
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
    return XmofTestLangPackage.Literals.XMOF_ACTIVITY_INPUT;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER, oldParameter, parameter));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(XMOFValue newValue, NotificationChain msgs)
  {
    XMOFValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(XMOFValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE, newValue, newValue));
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
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE:
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
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE:
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
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER:
        setParameter((ActivityParameterNode)newValue);
        return;
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE:
        setValue((XMOFValue)newValue);
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
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER:
        setParameter((ActivityParameterNode)null);
        return;
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE:
        setValue((XMOFValue)null);
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
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__PARAMETER:
        return parameter != null;
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //XMOFActivityInputImpl
