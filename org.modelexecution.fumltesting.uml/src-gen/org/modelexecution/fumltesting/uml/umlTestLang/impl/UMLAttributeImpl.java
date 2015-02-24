/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Property;

import org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl#getAtt <em>Att</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLAttributeImpl extends MinimalEObjectImpl.Container implements UMLAttribute
{
  /**
   * The cached value of the '{@link #getAtt() <em>Att</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtt()
   * @generated
   * @ordered
   */
  protected Property att;

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
  protected UMLAttributeImpl()
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
    return UmlTestLangPackage.Literals.UML_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getAtt()
  {
    if (att != null && att.eIsProxy())
    {
      InternalEObject oldAtt = (InternalEObject)att;
      att = (Property)eResolveProxy(oldAtt);
      if (att != oldAtt)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlTestLangPackage.UML_ATTRIBUTE__ATT, oldAtt, att));
      }
    }
    return att;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetAtt()
  {
    return att;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtt(Property newAtt)
  {
    Property oldAtt = att;
    att = newAtt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlTestLangPackage.UML_ATTRIBUTE__ATT, oldAtt, att));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlTestLangPackage.UML_ATTRIBUTE__VALUE, oldValue, newValue);
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
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlTestLangPackage.UML_ATTRIBUTE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlTestLangPackage.UML_ATTRIBUTE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlTestLangPackage.UML_ATTRIBUTE__VALUE, newValue, newValue));
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
      case UmlTestLangPackage.UML_ATTRIBUTE__VALUE:
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
      case UmlTestLangPackage.UML_ATTRIBUTE__ATT:
        if (resolve) return getAtt();
        return basicGetAtt();
      case UmlTestLangPackage.UML_ATTRIBUTE__VALUE:
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
      case UmlTestLangPackage.UML_ATTRIBUTE__ATT:
        setAtt((Property)newValue);
        return;
      case UmlTestLangPackage.UML_ATTRIBUTE__VALUE:
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
      case UmlTestLangPackage.UML_ATTRIBUTE__ATT:
        setAtt((Property)null);
        return;
      case UmlTestLangPackage.UML_ATTRIBUTE__VALUE:
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
      case UmlTestLangPackage.UML_ATTRIBUTE__ATT:
        return att != null;
      case UmlTestLangPackage.UML_ATTRIBUTE__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //UMLAttributeImpl
