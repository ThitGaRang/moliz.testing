/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Finally State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLFinallyStateAssertionImpl#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLFinallyStateAssertionImpl extends UMLAssertionImpl implements UMLFinallyStateAssertion
{
  /**
   * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChecks()
   * @generated
   * @ordered
   */
  protected EList<UMLCheck> checks;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLFinallyStateAssertionImpl()
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
    return UmlTestLangPackage.Literals.UML_FINALLY_STATE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLCheck> getChecks()
  {
    if (checks == null)
    {
      checks = new EObjectContainmentEList<UMLCheck>(UMLCheck.class, this, UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS);
    }
    return checks;
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
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS:
        return ((InternalEList<?>)getChecks()).basicRemove(otherEnd, msgs);
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
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS:
        return getChecks();
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
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS:
        getChecks().clear();
        getChecks().addAll((Collection<? extends UMLCheck>)newValue);
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
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS:
        getChecks().clear();
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
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION__CHECKS:
        return checks != null && !checks.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLFinallyStateAssertionImpl
