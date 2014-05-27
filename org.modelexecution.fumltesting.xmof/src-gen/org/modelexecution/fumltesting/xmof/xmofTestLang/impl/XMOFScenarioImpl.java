/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

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

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFScenarioImpl extends MinimalEObjectImpl.Container implements XMOFScenario
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
  protected EList<XMOFObjectSpecification> objects;

  /**
   * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinks()
   * @generated
   * @ordered
   */
  protected EList<XMOFLink> links;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFScenarioImpl()
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
    return XmofTestLangPackage.Literals.XMOF_SCENARIO;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_SCENARIO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFObjectSpecification> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<XMOFObjectSpecification>(XMOFObjectSpecification.class, this, XmofTestLangPackage.XMOF_SCENARIO__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFLink> getLinks()
  {
    if (links == null)
    {
      links = new EObjectContainmentEList<XMOFLink>(XMOFLink.class, this, XmofTestLangPackage.XMOF_SCENARIO__LINKS);
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
      case XmofTestLangPackage.XMOF_SCENARIO__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
      case XmofTestLangPackage.XMOF_SCENARIO__LINKS:
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
      case XmofTestLangPackage.XMOF_SCENARIO__NAME:
        return getName();
      case XmofTestLangPackage.XMOF_SCENARIO__OBJECTS:
        return getObjects();
      case XmofTestLangPackage.XMOF_SCENARIO__LINKS:
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
      case XmofTestLangPackage.XMOF_SCENARIO__NAME:
        setName((String)newValue);
        return;
      case XmofTestLangPackage.XMOF_SCENARIO__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends XMOFObjectSpecification>)newValue);
        return;
      case XmofTestLangPackage.XMOF_SCENARIO__LINKS:
        getLinks().clear();
        getLinks().addAll((Collection<? extends XMOFLink>)newValue);
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
      case XmofTestLangPackage.XMOF_SCENARIO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XmofTestLangPackage.XMOF_SCENARIO__OBJECTS:
        getObjects().clear();
        return;
      case XmofTestLangPackage.XMOF_SCENARIO__LINKS:
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
      case XmofTestLangPackage.XMOF_SCENARIO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XmofTestLangPackage.XMOF_SCENARIO__OBJECTS:
        return objects != null && !objects.isEmpty();
      case XmofTestLangPackage.XMOF_SCENARIO__LINKS:
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

} //XMOFScenarioImpl
