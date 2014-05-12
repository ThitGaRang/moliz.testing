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

import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLLink;
import org.modelexecution.fumltesting.testLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.testLang.UMLScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLScenarioImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLScenarioImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLScenarioImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLScenarioImpl extends MinimalEObjectImpl.Container implements UMLScenario
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
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<UMLObjectSpecification> objects;

  /**
   * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinks()
   * @generated
   * @ordered
   */
  protected EList<UMLLink> links;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLScenarioImpl()
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
    return TestLangPackage.Literals.UML_SCENARIO;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_SCENARIO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLObjectSpecification> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<UMLObjectSpecification>(UMLObjectSpecification.class, this, TestLangPackage.UML_SCENARIO__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLLink> getLinks()
  {
    if (links == null)
    {
      links = new EObjectContainmentEList<UMLLink>(UMLLink.class, this, TestLangPackage.UML_SCENARIO__LINKS);
    }
    return links;
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
      case TestLangPackage.UML_SCENARIO__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
      case TestLangPackage.UML_SCENARIO__LINKS:
        return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.UML_SCENARIO__NAME:
        return getName();
      case TestLangPackage.UML_SCENARIO__OBJECTS:
        return getObjects();
      case TestLangPackage.UML_SCENARIO__LINKS:
        return getLinks();
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
      case TestLangPackage.UML_SCENARIO__NAME:
        setName((String)newValue);
        return;
      case TestLangPackage.UML_SCENARIO__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends UMLObjectSpecification>)newValue);
        return;
      case TestLangPackage.UML_SCENARIO__LINKS:
        getLinks().clear();
        getLinks().addAll((Collection<? extends UMLLink>)newValue);
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
      case TestLangPackage.UML_SCENARIO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TestLangPackage.UML_SCENARIO__OBJECTS:
        getObjects().clear();
        return;
      case TestLangPackage.UML_SCENARIO__LINKS:
        getLinks().clear();
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
      case TestLangPackage.UML_SCENARIO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TestLangPackage.UML_SCENARIO__OBJECTS:
        return objects != null && !objects.isEmpty();
      case TestLangPackage.UML_SCENARIO__LINKS:
        return links != null && !links.isEmpty();
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

} //UMLScenarioImpl
