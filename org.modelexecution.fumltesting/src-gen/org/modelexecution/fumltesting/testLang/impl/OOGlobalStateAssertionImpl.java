/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OO Global State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl#getConditionConstraint <em>Condition Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl#getEvaluatedConstraint <em>Evaluated Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OOGlobalStateAssertionImpl extends AssertionImpl implements OOGlobalStateAssertion
{
  /**
   * The cached value of the '{@link #getConditionConstraint() <em>Condition Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionConstraint()
   * @generated
   * @ordered
   */
  protected XExpression conditionConstraint;

  /**
   * The default value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected static final TemporalQuantifier QUANTIFIER_EDEFAULT = TemporalQuantifier.NEXT;

  /**
   * The cached value of the '{@link #getQuantifier() <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantifier()
   * @generated
   * @ordered
   */
  protected TemporalQuantifier quantifier = QUANTIFIER_EDEFAULT;

  /**
   * The cached value of the '{@link #getEvaluatedConstraint() <em>Evaluated Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluatedConstraint()
   * @generated
   * @ordered
   */
  protected XExpression evaluatedConstraint;

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
  protected OOGlobalStateAssertionImpl()
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
    return TestLangPackage.Literals.OO_GLOBAL_STATE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getConditionConstraint()
  {
    return conditionConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionConstraint(XExpression newConditionConstraint, NotificationChain msgs)
  {
    XExpression oldConditionConstraint = conditionConstraint;
    conditionConstraint = newConditionConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT, oldConditionConstraint, newConditionConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionConstraint(XExpression newConditionConstraint)
  {
    if (newConditionConstraint != conditionConstraint)
    {
      NotificationChain msgs = null;
      if (conditionConstraint != null)
        msgs = ((InternalEObject)conditionConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT, null, msgs);
      if (newConditionConstraint != null)
        msgs = ((InternalEObject)newConditionConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT, null, msgs);
      msgs = basicSetConditionConstraint(newConditionConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT, newConditionConstraint, newConditionConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemporalQuantifier getQuantifier()
  {
    return quantifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuantifier(TemporalQuantifier newQuantifier)
  {
    TemporalQuantifier oldQuantifier = quantifier;
    quantifier = newQuantifier == null ? QUANTIFIER_EDEFAULT : newQuantifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__QUANTIFIER, oldQuantifier, quantifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getEvaluatedConstraint()
  {
    return evaluatedConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEvaluatedConstraint(XExpression newEvaluatedConstraint, NotificationChain msgs)
  {
    XExpression oldEvaluatedConstraint = evaluatedConstraint;
    evaluatedConstraint = newEvaluatedConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT, oldEvaluatedConstraint, newEvaluatedConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluatedConstraint(XExpression newEvaluatedConstraint)
  {
    if (newEvaluatedConstraint != evaluatedConstraint)
    {
      NotificationChain msgs = null;
      if (evaluatedConstraint != null)
        msgs = ((InternalEObject)evaluatedConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT, null, msgs);
      if (newEvaluatedConstraint != null)
        msgs = ((InternalEObject)newEvaluatedConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT, null, msgs);
      msgs = basicSetEvaluatedConstraint(newEvaluatedConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT, newEvaluatedConstraint, newEvaluatedConstraint));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT, oldObject, object));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT, oldObject, object));
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
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT:
        return basicSetConditionConstraint(null, msgs);
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT:
        return basicSetEvaluatedConstraint(null, msgs);
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
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT:
        return getConditionConstraint();
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__QUANTIFIER:
        return getQuantifier();
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT:
        return getEvaluatedConstraint();
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT:
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
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT:
        setConditionConstraint((XExpression)newValue);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__QUANTIFIER:
        setQuantifier((TemporalQuantifier)newValue);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT:
        setEvaluatedConstraint((XExpression)newValue);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT:
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
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT:
        setConditionConstraint((XExpression)null);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__QUANTIFIER:
        setQuantifier(QUANTIFIER_EDEFAULT);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT:
        setEvaluatedConstraint((XExpression)null);
        return;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT:
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
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT:
        return conditionConstraint != null;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__QUANTIFIER:
        return quantifier != QUANTIFIER_EDEFAULT;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT:
        return evaluatedConstraint != null;
      case TestLangPackage.OO_GLOBAL_STATE_ASSERTION__OBJECT:
        return object != null;
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
    result.append(')');
    return result.toString();
  }

} //OOGlobalStateAssertionImpl
