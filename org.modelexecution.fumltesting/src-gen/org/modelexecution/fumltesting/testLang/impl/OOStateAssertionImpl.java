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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.testLang.ConstraintCheck;
import org.modelexecution.fumltesting.testLang.OOStateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OO State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getTemporalQuantifier <em>Temporal Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getTemporalOperator <em>Temporal Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getReferenceConstraint <em>Reference Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getUntilConstraint <em>Until Constraint</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getConstraintCheck <em>Constraint Check</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OOStateAssertionImpl extends AssertionImpl implements OOStateAssertion
{
  /**
   * The default value of the '{@link #getTemporalQuantifier() <em>Temporal Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalQuantifier()
   * @generated
   * @ordered
   */
  protected static final TemporalQuantifier TEMPORAL_QUANTIFIER_EDEFAULT = TemporalQuantifier.NEXT;

  /**
   * The cached value of the '{@link #getTemporalQuantifier() <em>Temporal Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalQuantifier()
   * @generated
   * @ordered
   */
  protected TemporalQuantifier temporalQuantifier = TEMPORAL_QUANTIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getTemporalOperator() <em>Temporal Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalOperator()
   * @generated
   * @ordered
   */
  protected static final TemporalOperator TEMPORAL_OPERATOR_EDEFAULT = TemporalOperator.AFTER;

  /**
   * The cached value of the '{@link #getTemporalOperator() <em>Temporal Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalOperator()
   * @generated
   * @ordered
   */
  protected TemporalOperator temporalOperator = TEMPORAL_OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getReferenceConstraint() <em>Reference Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceConstraint()
   * @generated
   * @ordered
   */
  protected XExpression referenceConstraint;

  /**
   * The cached value of the '{@link #getUntilConstraint() <em>Until Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntilConstraint()
   * @generated
   * @ordered
   */
  protected XExpression untilConstraint;

  /**
   * The cached value of the '{@link #getConstraintCheck() <em>Constraint Check</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintCheck()
   * @generated
   * @ordered
   */
  protected EList<ConstraintCheck> constraintCheck;

  /**
   * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressions()
   * @generated
   * @ordered
   */
  protected EList<StateExpression> expressions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OOStateAssertionImpl()
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
    return TestLangPackage.Literals.OO_STATE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemporalQuantifier getTemporalQuantifier()
  {
    return temporalQuantifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemporalQuantifier(TemporalQuantifier newTemporalQuantifier)
  {
    TemporalQuantifier oldTemporalQuantifier = temporalQuantifier;
    temporalQuantifier = newTemporalQuantifier == null ? TEMPORAL_QUANTIFIER_EDEFAULT : newTemporalQuantifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER, oldTemporalQuantifier, temporalQuantifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemporalOperator getTemporalOperator()
  {
    return temporalOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemporalOperator(TemporalOperator newTemporalOperator)
  {
    TemporalOperator oldTemporalOperator = temporalOperator;
    temporalOperator = newTemporalOperator == null ? TEMPORAL_OPERATOR_EDEFAULT : newTemporalOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_OPERATOR, oldTemporalOperator, temporalOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getReferenceConstraint()
  {
    return referenceConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReferenceConstraint(XExpression newReferenceConstraint, NotificationChain msgs)
  {
    XExpression oldReferenceConstraint = referenceConstraint;
    referenceConstraint = newReferenceConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT, oldReferenceConstraint, newReferenceConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceConstraint(XExpression newReferenceConstraint)
  {
    if (newReferenceConstraint != referenceConstraint)
    {
      NotificationChain msgs = null;
      if (referenceConstraint != null)
        msgs = ((InternalEObject)referenceConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT, null, msgs);
      if (newReferenceConstraint != null)
        msgs = ((InternalEObject)newReferenceConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT, null, msgs);
      msgs = basicSetReferenceConstraint(newReferenceConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT, newReferenceConstraint, newReferenceConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getUntilConstraint()
  {
    return untilConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUntilConstraint(XExpression newUntilConstraint, NotificationChain msgs)
  {
    XExpression oldUntilConstraint = untilConstraint;
    untilConstraint = newUntilConstraint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT, oldUntilConstraint, newUntilConstraint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUntilConstraint(XExpression newUntilConstraint)
  {
    if (newUntilConstraint != untilConstraint)
    {
      NotificationChain msgs = null;
      if (untilConstraint != null)
        msgs = ((InternalEObject)untilConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT, null, msgs);
      if (newUntilConstraint != null)
        msgs = ((InternalEObject)newUntilConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT, null, msgs);
      msgs = basicSetUntilConstraint(newUntilConstraint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT, newUntilConstraint, newUntilConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintCheck> getConstraintCheck()
  {
    if (constraintCheck == null)
    {
      constraintCheck = new EObjectContainmentEList<ConstraintCheck>(ConstraintCheck.class, this, TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK);
    }
    return constraintCheck;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateExpression> getExpressions()
  {
    if (expressions == null)
    {
      expressions = new EObjectContainmentEList<StateExpression>(StateExpression.class, this, TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS);
    }
    return expressions;
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
      case TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT:
        return basicSetReferenceConstraint(null, msgs);
      case TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT:
        return basicSetUntilConstraint(null, msgs);
      case TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK:
        return ((InternalEList<?>)getConstraintCheck()).basicRemove(otherEnd, msgs);
      case TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS:
        return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        return getTemporalQuantifier();
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_OPERATOR:
        return getTemporalOperator();
      case TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT:
        return getReferenceConstraint();
      case TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT:
        return getUntilConstraint();
      case TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK:
        return getConstraintCheck();
      case TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS:
        return getExpressions();
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
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        setTemporalQuantifier((TemporalQuantifier)newValue);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_OPERATOR:
        setTemporalOperator((TemporalOperator)newValue);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT:
        setReferenceConstraint((XExpression)newValue);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT:
        setUntilConstraint((XExpression)newValue);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK:
        getConstraintCheck().clear();
        getConstraintCheck().addAll((Collection<? extends ConstraintCheck>)newValue);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS:
        getExpressions().clear();
        getExpressions().addAll((Collection<? extends StateExpression>)newValue);
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
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        setTemporalQuantifier(TEMPORAL_QUANTIFIER_EDEFAULT);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_OPERATOR:
        setTemporalOperator(TEMPORAL_OPERATOR_EDEFAULT);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT:
        setReferenceConstraint((XExpression)null);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT:
        setUntilConstraint((XExpression)null);
        return;
      case TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK:
        getConstraintCheck().clear();
        return;
      case TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS:
        getExpressions().clear();
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
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        return temporalQuantifier != TEMPORAL_QUANTIFIER_EDEFAULT;
      case TestLangPackage.OO_STATE_ASSERTION__TEMPORAL_OPERATOR:
        return temporalOperator != TEMPORAL_OPERATOR_EDEFAULT;
      case TestLangPackage.OO_STATE_ASSERTION__REFERENCE_CONSTRAINT:
        return referenceConstraint != null;
      case TestLangPackage.OO_STATE_ASSERTION__UNTIL_CONSTRAINT:
        return untilConstraint != null;
      case TestLangPackage.OO_STATE_ASSERTION__CONSTRAINT_CHECK:
        return constraintCheck != null && !constraintCheck.isEmpty();
      case TestLangPackage.OO_STATE_ASSERTION__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
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
    result.append(" (TemporalQuantifier: ");
    result.append(temporalQuantifier);
    result.append(", temporalOperator: ");
    result.append(temporalOperator);
    result.append(')');
    return result.toString();
  }

} //OOStateAssertionImpl
