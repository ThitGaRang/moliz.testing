/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.testLang.ConstraintCheck;
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
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl#getConstraintCheck <em>Constraint Check</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinallyStateAssertionImpl extends AssertionImpl implements FinallyStateAssertion
{
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
  public EList<ConstraintCheck> getConstraintCheck()
  {
    if (constraintCheck == null)
    {
      constraintCheck = new EObjectContainmentEList<ConstraintCheck>(ConstraintCheck.class, this, TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK);
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK:
        return ((InternalEList<?>)getConstraintCheck()).basicRemove(otherEnd, msgs);
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK:
        return getConstraintCheck();
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK:
        getConstraintCheck().clear();
        getConstraintCheck().addAll((Collection<? extends ConstraintCheck>)newValue);
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK:
        getConstraintCheck().clear();
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
      case TestLangPackage.FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK:
        return constraintCheck != null && !constraintCheck.isEmpty();
      case TestLangPackage.FINALLY_STATE_ASSERTION__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FinallyStateAssertionImpl
