/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFLinkImpl extends MinimalEObjectImpl.Container implements XMOFLink
{
  /**
   * The cached value of the '{@link #getAssoc() <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssoc()
   * @generated
   * @ordered
   */
  protected EReference assoc;

  /**
   * The cached value of the '{@link #getSourceProperty() <em>Source Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceProperty()
   * @generated
   * @ordered
   */
  protected EAttribute sourceProperty;

  /**
   * The cached value of the '{@link #getSourceValue() <em>Source Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceValue()
   * @generated
   * @ordered
   */
  protected XMOFObjectSpecification sourceValue;

  /**
   * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetProperty()
   * @generated
   * @ordered
   */
  protected EAttribute targetProperty;

  /**
   * The cached value of the '{@link #getTargetValue() <em>Target Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetValue()
   * @generated
   * @ordered
   */
  protected XMOFObjectSpecification targetValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFLinkImpl()
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
    return XmofTestLangPackage.Literals.XMOF_LINK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssoc()
  {
    if (assoc != null && assoc.eIsProxy())
    {
      InternalEObject oldAssoc = (InternalEObject)assoc;
      assoc = (EReference)eResolveProxy(oldAssoc);
      if (assoc != oldAssoc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_LINK__ASSOC, oldAssoc, assoc));
      }
    }
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference basicGetAssoc()
  {
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssoc(EReference newAssoc)
  {
    EReference oldAssoc = assoc;
    assoc = newAssoc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_LINK__ASSOC, oldAssoc, assoc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSourceProperty()
  {
    if (sourceProperty != null && sourceProperty.eIsProxy())
    {
      InternalEObject oldSourceProperty = (InternalEObject)sourceProperty;
      sourceProperty = (EAttribute)eResolveProxy(oldSourceProperty);
      if (sourceProperty != oldSourceProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
      }
    }
    return sourceProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetSourceProperty()
  {
    return sourceProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceProperty(EAttribute newSourceProperty)
  {
    EAttribute oldSourceProperty = sourceProperty;
    sourceProperty = newSourceProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification getSourceValue()
  {
    if (sourceValue != null && sourceValue.eIsProxy())
    {
      InternalEObject oldSourceValue = (InternalEObject)sourceValue;
      sourceValue = (XMOFObjectSpecification)eResolveProxy(oldSourceValue);
      if (sourceValue != oldSourceValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE, oldSourceValue, sourceValue));
      }
    }
    return sourceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification basicGetSourceValue()
  {
    return sourceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceValue(XMOFObjectSpecification newSourceValue)
  {
    XMOFObjectSpecification oldSourceValue = sourceValue;
    sourceValue = newSourceValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE, oldSourceValue, sourceValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTargetProperty()
  {
    if (targetProperty != null && targetProperty.eIsProxy())
    {
      InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
      targetProperty = (EAttribute)eResolveProxy(oldTargetProperty);
      if (targetProperty != oldTargetProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY, oldTargetProperty, targetProperty));
      }
    }
    return targetProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetTargetProperty()
  {
    return targetProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetProperty(EAttribute newTargetProperty)
  {
    EAttribute oldTargetProperty = targetProperty;
    targetProperty = newTargetProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY, oldTargetProperty, targetProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification getTargetValue()
  {
    if (targetValue != null && targetValue.eIsProxy())
    {
      InternalEObject oldTargetValue = (InternalEObject)targetValue;
      targetValue = (XMOFObjectSpecification)eResolveProxy(oldTargetValue);
      if (targetValue != oldTargetValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmofTestLangPackage.XMOF_LINK__TARGET_VALUE, oldTargetValue, targetValue));
      }
    }
    return targetValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification basicGetTargetValue()
  {
    return targetValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetValue(XMOFObjectSpecification newTargetValue)
  {
    XMOFObjectSpecification oldTargetValue = targetValue;
    targetValue = newTargetValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_LINK__TARGET_VALUE, oldTargetValue, targetValue));
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
      case XmofTestLangPackage.XMOF_LINK__ASSOC:
        if (resolve) return getAssoc();
        return basicGetAssoc();
      case XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY:
        if (resolve) return getSourceProperty();
        return basicGetSourceProperty();
      case XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE:
        if (resolve) return getSourceValue();
        return basicGetSourceValue();
      case XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY:
        if (resolve) return getTargetProperty();
        return basicGetTargetProperty();
      case XmofTestLangPackage.XMOF_LINK__TARGET_VALUE:
        if (resolve) return getTargetValue();
        return basicGetTargetValue();
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
      case XmofTestLangPackage.XMOF_LINK__ASSOC:
        setAssoc((EReference)newValue);
        return;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY:
        setSourceProperty((EAttribute)newValue);
        return;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE:
        setSourceValue((XMOFObjectSpecification)newValue);
        return;
      case XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY:
        setTargetProperty((EAttribute)newValue);
        return;
      case XmofTestLangPackage.XMOF_LINK__TARGET_VALUE:
        setTargetValue((XMOFObjectSpecification)newValue);
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
      case XmofTestLangPackage.XMOF_LINK__ASSOC:
        setAssoc((EReference)null);
        return;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY:
        setSourceProperty((EAttribute)null);
        return;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE:
        setSourceValue((XMOFObjectSpecification)null);
        return;
      case XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY:
        setTargetProperty((EAttribute)null);
        return;
      case XmofTestLangPackage.XMOF_LINK__TARGET_VALUE:
        setTargetValue((XMOFObjectSpecification)null);
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
      case XmofTestLangPackage.XMOF_LINK__ASSOC:
        return assoc != null;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_PROPERTY:
        return sourceProperty != null;
      case XmofTestLangPackage.XMOF_LINK__SOURCE_VALUE:
        return sourceValue != null;
      case XmofTestLangPackage.XMOF_LINK__TARGET_PROPERTY:
        return targetProperty != null;
      case XmofTestLangPackage.XMOF_LINK__TARGET_VALUE:
        return targetValue != null;
    }
    return super.eIsSet(featureID);
  }

} //XMOFLinkImpl
