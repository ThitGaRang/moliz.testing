/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.uml.ObjectNode;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Constraint Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl#getConstraintNames <em>Constraint Names</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLConstraintCheckImpl extends UMLCheckImpl implements UMLConstraintCheck
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
  protected ObjectNode object;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLConstraintCheckImpl()
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
    return UmlTestLangPackage.Literals.UML_CONSTRAINT_CHECK;
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
      constraintNames = new EObjectContainmentEList<XExpression>(XExpression.class, this, UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES);
    }
    return constraintNames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectNode getObject()
  {
    if (object != null && object.eIsProxy())
    {
      InternalEObject oldObject = (InternalEObject)object;
      object = (ObjectNode)eResolveProxy(oldObject);
      if (object != oldObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT, oldObject, object));
      }
    }
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectNode basicGetObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(ObjectNode newObject)
  {
    ObjectNode oldObject = object;
    object = newObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT, oldObject, object));
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
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES:
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
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        return getConstraintNames();
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT:
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
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        getConstraintNames().clear();
        getConstraintNames().addAll((Collection<? extends XExpression>)newValue);
        return;
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT:
        setObject((ObjectNode)newValue);
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
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        getConstraintNames().clear();
        return;
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT:
        setObject((ObjectNode)null);
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
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES:
        return constraintNames != null && !constraintNames.isEmpty();
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK__OBJECT:
        return object != null;
    }
    return super.eIsSet(featureID);
  }

} //UMLConstraintCheckImpl
