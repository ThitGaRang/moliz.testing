/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLNodeOrder;
import org.modelexecution.fumltesting.testLang.UMLNodeSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Node Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLNodeOrderImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLNodeOrderImpl extends MinimalEObjectImpl.Container implements UMLNodeOrder
{
  /**
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
  protected EList<UMLNodeSpecification> nodes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLNodeOrderImpl()
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
    return TestLangPackage.Literals.UML_NODE_ORDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLNodeSpecification> getNodes()
  {
    if (nodes == null)
    {
      nodes = new EObjectContainmentEList<UMLNodeSpecification>(UMLNodeSpecification.class, this, TestLangPackage.UML_NODE_ORDER__NODES);
    }
    return nodes;
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
      case TestLangPackage.UML_NODE_ORDER__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.UML_NODE_ORDER__NODES:
        return getNodes();
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
      case TestLangPackage.UML_NODE_ORDER__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends UMLNodeSpecification>)newValue);
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
      case TestLangPackage.UML_NODE_ORDER__NODES:
        getNodes().clear();
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
      case TestLangPackage.UML_NODE_ORDER__NODES:
        return nodes != null && !nodes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLNodeOrderImpl
