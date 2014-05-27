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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMOF State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl#getReferencePoint <em>Reference Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl#getUntilPoint <em>Until Point</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMOFStateAssertionImpl extends XMOFAssertionImpl implements XMOFStateAssertion
{
  /**
   * The default value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected static final XMOFTemporalQuantifier QUANTIFIER_EDEFAULT = XMOFTemporalQuantifier.ALWAYS;

  /**
   * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected XMOFTemporalQuantifier quantifier = QUANTIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final XMOFTemporalOperator OPERATOR_EDEFAULT = XMOFTemporalOperator.AFTER;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected XMOFTemporalOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getReferencePoint() <em>Reference Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencePoint()
   * @generated
   * @ordered
   */
  protected XMOFReferencePoint referencePoint;

  /**
   * The cached value of the '{@link #getUntilPoint() <em>Until Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntilPoint()
   * @generated
   * @ordered
   */
  protected XMOFReferencePoint untilPoint;

  /**
   * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChecks()
   * @generated
   * @ordered
   */
  protected EList<XMOFCheck> checks;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XMOFStateAssertionImpl()
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
    return XmofTestLangPackage.Literals.XMOF_STATE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTemporalQuantifier getQuantifier()
  {
    return quantifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuantifier(XMOFTemporalQuantifier newQuantifier)
  {
    XMOFTemporalQuantifier oldQuantifier = quantifier;
    quantifier = newQuantifier == null ? QUANTIFIER_EDEFAULT : newQuantifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__QUANTIFIER, oldQuantifier, quantifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTemporalOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(XMOFTemporalOperator newOperator)
  {
    XMOFTemporalOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFReferencePoint getReferencePoint()
  {
    return referencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReferencePoint(XMOFReferencePoint newReferencePoint, NotificationChain msgs)
  {
    XMOFReferencePoint oldReferencePoint = referencePoint;
    referencePoint = newReferencePoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT, oldReferencePoint, newReferencePoint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferencePoint(XMOFReferencePoint newReferencePoint)
  {
    if (newReferencePoint != referencePoint)
    {
      NotificationChain msgs = null;
      if (referencePoint != null)
        msgs = ((InternalEObject)referencePoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT, null, msgs);
      if (newReferencePoint != null)
        msgs = ((InternalEObject)newReferencePoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT, null, msgs);
      msgs = basicSetReferencePoint(newReferencePoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT, newReferencePoint, newReferencePoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFReferencePoint getUntilPoint()
  {
    return untilPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUntilPoint(XMOFReferencePoint newUntilPoint, NotificationChain msgs)
  {
    XMOFReferencePoint oldUntilPoint = untilPoint;
    untilPoint = newUntilPoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT, oldUntilPoint, newUntilPoint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUntilPoint(XMOFReferencePoint newUntilPoint)
  {
    if (newUntilPoint != untilPoint)
    {
      NotificationChain msgs = null;
      if (untilPoint != null)
        msgs = ((InternalEObject)untilPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT, null, msgs);
      if (newUntilPoint != null)
        msgs = ((InternalEObject)newUntilPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT, null, msgs);
      msgs = basicSetUntilPoint(newUntilPoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT, newUntilPoint, newUntilPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XMOFCheck> getChecks()
  {
    if (checks == null)
    {
      checks = new EObjectContainmentEList<XMOFCheck>(XMOFCheck.class, this, XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS);
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
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT:
        return basicSetReferencePoint(null, msgs);
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT:
        return basicSetUntilPoint(null, msgs);
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS:
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
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__QUANTIFIER:
        return getQuantifier();
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__OPERATOR:
        return getOperator();
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT:
        return getReferencePoint();
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT:
        return getUntilPoint();
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS:
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
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__QUANTIFIER:
        setQuantifier((XMOFTemporalQuantifier)newValue);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__OPERATOR:
        setOperator((XMOFTemporalOperator)newValue);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT:
        setReferencePoint((XMOFReferencePoint)newValue);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT:
        setUntilPoint((XMOFReferencePoint)newValue);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS:
        getChecks().clear();
        getChecks().addAll((Collection<? extends XMOFCheck>)newValue);
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
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__QUANTIFIER:
        setQuantifier(QUANTIFIER_EDEFAULT);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT:
        setReferencePoint((XMOFReferencePoint)null);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT:
        setUntilPoint((XMOFReferencePoint)null);
        return;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS:
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
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__QUANTIFIER:
        return quantifier != QUANTIFIER_EDEFAULT;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__REFERENCE_POINT:
        return referencePoint != null;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__UNTIL_POINT:
        return untilPoint != null;
      case XmofTestLangPackage.XMOF_STATE_ASSERTION__CHECKS:
        return checks != null && !checks.isEmpty();
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
    result.append(" (quantifier: ");
    result.append(quantifier);
    result.append(", operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //XMOFStateAssertionImpl
