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

import org.modelexecution.fumltesting.testLang.ConstraintChecking;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finally State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl#getConstraintChecking <em>Constraint Checking</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinallyStateAssertionImpl extends AssertionImpl implements FinallyStateAssertion
{
  /**
   * The cached value of the '{@link #getConstraintChecking() <em>Constraint Checking</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintChecking()
   * @generated
   * @ordered
   */
  protected ConstraintChecking constraintChecking;

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
  protected FinallyStateAssertionImpl()
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
    return TestLangPackage.Literals.FINALLY_STATE_ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintChecking getConstraintChecking()
  {
    return constraintChecking;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraintChecking(ConstraintChecking newConstraintChecking, NotificationChain msgs)
  {
    ConstraintChecking oldConstraintChecking = constraintChecking;
    constraintChecking = newConstraintChecking;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING, oldConstraintChecking, newConstraintChecking);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintChecking(ConstraintChecking newConstraintChecking)
  {
    if (newConstraintChecking != constraintChecking)
    {
      NotificationChain msgs = null;
      if (constraintChecking != null)
        msgs = ((InternalEObject)constraintChecking).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING, null, msgs);
      if (newConstraintChecking != null)
        msgs = ((InternalEObject)newConstraintChecking).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING, null, msgs);
      msgs = basicSetConstraintChecking(newConstraintChecking, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING, newConstraintChecking, newConstraintChecking));
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
      expressions = new EObjectContainmentEList<StateExpression>(StateExpression.class, this, TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS);
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING:
        return basicSetConstraintChecking(null, msgs);
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING:
        return getConstraintChecking();
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING:
        setConstraintChecking((ConstraintChecking)newValue);
        return;
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING:
        setConstraintChecking((ConstraintChecking)null);
        return;
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECKING:
        return constraintChecking != null;
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FinallyStateAssertionImpl
