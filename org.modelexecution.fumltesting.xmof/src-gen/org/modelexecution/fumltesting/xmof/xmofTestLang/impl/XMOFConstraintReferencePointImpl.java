/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF Constraint Reference Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintReferencePointImpl#getConstraintName <em>Constraint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFConstraintReferencePointImpl extends XMOFReferencePointImpl implements XMOFConstraintReferencePoint
{
  /**
   * The cached value of the '{@link #getConstraintName() <em>Constraint Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintName()
   * @generated
   * @ordered
   */
  protected XExpression constraintName;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFConstraintReferencePointImpl()
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
    return XmofTestLangPackage.Literals.XMOF_CONSTRAINT_REFERENCE_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getConstraintName()
  {
    return constraintName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraintName(XExpression newConstraintName, NotificationChain msgs)
  {
    XExpression oldConstraintName = constraintName;
    constraintName = newConstraintName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME, oldConstraintName, newConstraintName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintName(XExpression newConstraintName)
  {
    if (newConstraintName != constraintName)
    {
      NotificationChain msgs = null;
      if (constraintName != null)
        msgs = ((InternalEObject)constraintName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME, null, msgs);
      if (newConstraintName != null)
        msgs = ((InternalEObject)newConstraintName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME, null, msgs);
      msgs = basicSetConstraintName(newConstraintName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME, newConstraintName, newConstraintName));
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
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME:
        return basicSetConstraintName(null, msgs);
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
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME:
        return getConstraintName();
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
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME:
        setConstraintName((XExpression)newValue);
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
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME:
        setConstraintName((XExpression)null);
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
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME:
        return constraintName != null;
    }
    return super.eIsSet(featureID);
  }

} //XMOFConstraintReferencePointImpl
