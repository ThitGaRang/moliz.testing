/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link
{
  /**
   * The cached value of the '{@link #getAssoc() <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssoc()
   * @generated
   * @ordered
   */
  protected Association assoc;

  /**
   * The cached value of the '{@link #getSourceProperty() <em>Source Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceProperty()
   * @generated
   * @ordered
   */
  protected Property sourceProperty;

  /**
   * The cached value of the '{@link #getSourceValue() <em>Source Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceValue()
   * @generated
   * @ordered
   */
  protected ObjectSpecification sourceValue;

  /**
   * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetProperty()
   * @generated
   * @ordered
   */
  protected Property targetProperty;

  /**
   * The cached value of the '{@link #getTargetValue() <em>Target Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetValue()
   * @generated
   * @ordered
   */
  protected ObjectSpecification targetValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkImpl()
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
    return TestLangPackage.Literals.LINK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association getAssoc()
  {
    if (assoc != null && assoc.eIsProxy())
    {
      InternalEObject oldAssoc = (InternalEObject)assoc;
      assoc = (Association)eResolveProxy(oldAssoc);
      if (assoc != oldAssoc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.LINK__ASSOC, oldAssoc, assoc));
      }
    }
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association basicGetAssoc()
  {
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssoc(Association newAssoc)
  {
    Association oldAssoc = assoc;
    assoc = newAssoc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.LINK__ASSOC, oldAssoc, assoc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getSourceProperty()
  {
    if (sourceProperty != null && sourceProperty.eIsProxy())
    {
      InternalEObject oldSourceProperty = (InternalEObject)sourceProperty;
      sourceProperty = (Property)eResolveProxy(oldSourceProperty);
      if (sourceProperty != oldSourceProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.LINK__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
      }
    }
    return sourceProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetSourceProperty()
  {
    return sourceProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceProperty(Property newSourceProperty)
  {
    Property oldSourceProperty = sourceProperty;
    sourceProperty = newSourceProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.LINK__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification getSourceValue()
  {
    if (sourceValue != null && sourceValue.eIsProxy())
    {
      InternalEObject oldSourceValue = (InternalEObject)sourceValue;
      sourceValue = (ObjectSpecification)eResolveProxy(oldSourceValue);
      if (sourceValue != oldSourceValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.LINK__SOURCE_VALUE, oldSourceValue, sourceValue));
      }
    }
    return sourceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification basicGetSourceValue()
  {
    return sourceValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceValue(ObjectSpecification newSourceValue)
  {
    ObjectSpecification oldSourceValue = sourceValue;
    sourceValue = newSourceValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.LINK__SOURCE_VALUE, oldSourceValue, sourceValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property getTargetProperty()
  {
    if (targetProperty != null && targetProperty.eIsProxy())
    {
      InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
      targetProperty = (Property)eResolveProxy(oldTargetProperty);
      if (targetProperty != oldTargetProperty)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.LINK__TARGET_PROPERTY, oldTargetProperty, targetProperty));
      }
    }
    return targetProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property basicGetTargetProperty()
  {
    return targetProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetProperty(Property newTargetProperty)
  {
    Property oldTargetProperty = targetProperty;
    targetProperty = newTargetProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.LINK__TARGET_PROPERTY, oldTargetProperty, targetProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification getTargetValue()
  {
    if (targetValue != null && targetValue.eIsProxy())
    {
      InternalEObject oldTargetValue = (InternalEObject)targetValue;
      targetValue = (ObjectSpecification)eResolveProxy(oldTargetValue);
      if (targetValue != oldTargetValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.LINK__TARGET_VALUE, oldTargetValue, targetValue));
      }
    }
    return targetValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification basicGetTargetValue()
  {
    return targetValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetValue(ObjectSpecification newTargetValue)
  {
    ObjectSpecification oldTargetValue = targetValue;
    targetValue = newTargetValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.LINK__TARGET_VALUE, oldTargetValue, targetValue));
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
      case TestLangPackage.LINK__ASSOC:
        if (resolve) return getAssoc();
        return basicGetAssoc();
      case TestLangPackage.LINK__SOURCE_PROPERTY:
        if (resolve) return getSourceProperty();
        return basicGetSourceProperty();
      case TestLangPackage.LINK__SOURCE_VALUE:
        if (resolve) return getSourceValue();
        return basicGetSourceValue();
      case TestLangPackage.LINK__TARGET_PROPERTY:
        if (resolve) return getTargetProperty();
        return basicGetTargetProperty();
      case TestLangPackage.LINK__TARGET_VALUE:
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
      case TestLangPackage.LINK__ASSOC:
        setAssoc((Association)newValue);
        return;
      case TestLangPackage.LINK__SOURCE_PROPERTY:
        setSourceProperty((Property)newValue);
        return;
      case TestLangPackage.LINK__SOURCE_VALUE:
        setSourceValue((ObjectSpecification)newValue);
        return;
      case TestLangPackage.LINK__TARGET_PROPERTY:
        setTargetProperty((Property)newValue);
        return;
      case TestLangPackage.LINK__TARGET_VALUE:
        setTargetValue((ObjectSpecification)newValue);
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
      case TestLangPackage.LINK__ASSOC:
        setAssoc((Association)null);
        return;
      case TestLangPackage.LINK__SOURCE_PROPERTY:
        setSourceProperty((Property)null);
        return;
      case TestLangPackage.LINK__SOURCE_VALUE:
        setSourceValue((ObjectSpecification)null);
        return;
      case TestLangPackage.LINK__TARGET_PROPERTY:
        setTargetProperty((Property)null);
        return;
      case TestLangPackage.LINK__TARGET_VALUE:
        setTargetValue((ObjectSpecification)null);
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
      case TestLangPackage.LINK__ASSOC:
        return assoc != null;
      case TestLangPackage.LINK__SOURCE_PROPERTY:
        return sourceProperty != null;
      case TestLangPackage.LINK__SOURCE_VALUE:
        return sourceValue != null;
      case TestLangPackage.LINK__TARGET_PROPERTY:
        return targetProperty != null;
      case TestLangPackage.LINK__TARGET_VALUE:
        return targetValue != null;
    }
    return super.eIsSet(featureID);
  }

} //LinkImpl
