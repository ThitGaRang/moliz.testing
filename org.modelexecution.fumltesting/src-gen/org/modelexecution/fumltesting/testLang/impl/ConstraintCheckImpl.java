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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.testLang.ConstraintCheck;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl#getConstraintNames <em>Constraint Names</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintCheckImpl extends MinimalEObjectImpl.Container implements ConstraintCheck
{
  /**
   * The cached value of the '{@link #getConstraintNames() <em>Constraint Names</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintNames()
   * @generated
   * @ordered
   */
  protected EList<XExpression> constraintNames;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected VarDeclaration object;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintCheckImpl()
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
    return TestLangPackage.Literals.CONSTRAINT_CHECK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getConstraintNames()
  {
    if (constraintNames == null)
    {
      constraintNames = new EObjectContainmentEList<XExpression>(XExpression.class, this, TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES);
    }
    return constraintNames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration getObject()
  {
    if (object != null && object.eIsProxy())
    {
      InternalEObject oldObject = (InternalEObject)object;
      object = (VarDeclaration)eResolveProxy(oldObject);
      if (object != oldObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.CONSTRAINT_CHECK__OBJECT, oldObject, object));
      }
    }
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration basicGetObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(VarDeclaration newObject)
  {
    VarDeclaration oldObject = object;
    object = newObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.CONSTRAINT_CHECK__OBJECT, oldObject, object));
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
      case TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        return ((InternalEList<?>)getConstraintNames()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        return getConstraintNames();
      case TestLangPackage.CONSTRAINT_CHECK__OBJECT:
        if (resolve) return getObject();
        return basicGetObject();
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
      case TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        getConstraintNames().clear();
        getConstraintNames().addAll((Collection<? extends XExpression>)newValue);
        return;
      case TestLangPackage.CONSTRAINT_CHECK__OBJECT:
        setObject((VarDeclaration)newValue);
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
      case TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        getConstraintNames().clear();
        return;
      case TestLangPackage.CONSTRAINT_CHECK__OBJECT:
        setObject((VarDeclaration)null);
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
      case TestLangPackage.CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        return constraintNames != null && !constraintNames.isEmpty();
      case TestLangPackage.CONSTRAINT_CHECK__OBJECT:
        return object != null;
    }
    return super.eIsSet(featureID);
  }

} //ConstraintCheckImpl
