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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

import org.eclipse.uml2.uml.Action;

import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getTemporalQuantifier <em>Temporal Quantifier</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getTemporalOperator <em>Temporal Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getReferenceAction <em>Reference Action</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getUntilAction <em>Until Action</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateAssertionImpl extends AssertionImpl implements StateAssertion
{
  /**
   * The default value of the '{@link #getTemporalQuantifier() <em>Temporal Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalQuantifier()
   * @generated
   * @ordered
   */
  protected static final TemporalQuantifier TEMPORAL_QUANTIFIER_EDEFAULT = TemporalQuantifier.EXACTLY;

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
   * The cached value of the '{@link #getReferenceAction() <em>Reference Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceAction()
   * @generated
   * @ordered
   */
  protected Action referenceAction;

  /**
   * The cached value of the '{@link #getUntilAction() <em>Until Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUntilAction()
   * @generated
   * @ordered
   */
  protected Action untilAction;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<ExpCS> constraints;

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
  protected StateAssertionImpl()
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
    return TestLangPackage.Literals.STATE_ASSERTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.STATE_ASSERTION__TEMPORAL_QUANTIFIER, oldTemporalQuantifier, temporalQuantifier));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.STATE_ASSERTION__TEMPORAL_OPERATOR, oldTemporalOperator, temporalOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action getReferenceAction()
  {
    if (referenceAction != null && referenceAction.eIsProxy())
    {
      InternalEObject oldReferenceAction = (InternalEObject)referenceAction;
      referenceAction = (Action)eResolveProxy(oldReferenceAction);
      if (referenceAction != oldReferenceAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION, oldReferenceAction, referenceAction));
      }
    }
    return referenceAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action basicGetReferenceAction()
  {
    return referenceAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceAction(Action newReferenceAction)
  {
    Action oldReferenceAction = referenceAction;
    referenceAction = newReferenceAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION, oldReferenceAction, referenceAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action getUntilAction()
  {
    if (untilAction != null && untilAction.eIsProxy())
    {
      InternalEObject oldUntilAction = (InternalEObject)untilAction;
      untilAction = (Action)eResolveProxy(oldUntilAction);
      if (untilAction != oldUntilAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.STATE_ASSERTION__UNTIL_ACTION, oldUntilAction, untilAction));
      }
    }
    return untilAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action basicGetUntilAction()
  {
    return untilAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUntilAction(Action newUntilAction)
  {
    Action oldUntilAction = untilAction;
    untilAction = newUntilAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.STATE_ASSERTION__UNTIL_ACTION, oldUntilAction, untilAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExpCS> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectResolvingEList<ExpCS>(ExpCS.class, this, TestLangPackage.STATE_ASSERTION__CONSTRAINTS);
    }
    return constraints;
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
      expressions = new EObjectContainmentEList<StateExpression>(StateExpression.class, this, TestLangPackage.STATE_ASSERTION__EXPRESSIONS);
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
      case TestLangPackage.STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        return getTemporalQuantifier();
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_OPERATOR:
        return getTemporalOperator();
      case TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION:
        if (resolve) return getReferenceAction();
        return basicGetReferenceAction();
      case TestLangPackage.STATE_ASSERTION__UNTIL_ACTION:
        if (resolve) return getUntilAction();
        return basicGetUntilAction();
      case TestLangPackage.STATE_ASSERTION__CONSTRAINTS:
        return getConstraints();
      case TestLangPackage.STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        setTemporalQuantifier((TemporalQuantifier)newValue);
        return;
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_OPERATOR:
        setTemporalOperator((TemporalOperator)newValue);
        return;
      case TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION:
        setReferenceAction((Action)newValue);
        return;
      case TestLangPackage.STATE_ASSERTION__UNTIL_ACTION:
        setUntilAction((Action)newValue);
        return;
      case TestLangPackage.STATE_ASSERTION__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends ExpCS>)newValue);
        return;
      case TestLangPackage.STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        setTemporalQuantifier(TEMPORAL_QUANTIFIER_EDEFAULT);
        return;
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_OPERATOR:
        setTemporalOperator(TEMPORAL_OPERATOR_EDEFAULT);
        return;
      case TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION:
        setReferenceAction((Action)null);
        return;
      case TestLangPackage.STATE_ASSERTION__UNTIL_ACTION:
        setUntilAction((Action)null);
        return;
      case TestLangPackage.STATE_ASSERTION__CONSTRAINTS:
        getConstraints().clear();
        return;
      case TestLangPackage.STATE_ASSERTION__EXPRESSIONS:
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
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_QUANTIFIER:
        return temporalQuantifier != TEMPORAL_QUANTIFIER_EDEFAULT;
      case TestLangPackage.STATE_ASSERTION__TEMPORAL_OPERATOR:
        return temporalOperator != TEMPORAL_OPERATOR_EDEFAULT;
      case TestLangPackage.STATE_ASSERTION__REFERENCE_ACTION:
        return referenceAction != null;
      case TestLangPackage.STATE_ASSERTION__UNTIL_ACTION:
        return untilAction != null;
      case TestLangPackage.STATE_ASSERTION__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
      case TestLangPackage.STATE_ASSERTION__EXPRESSIONS:
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
    result.append(" (temporalQuantifier: ");
    result.append(temporalQuantifier);
    result.append(", temporalOperator: ");
    result.append(temporalOperator);
    result.append(')');
    return result.toString();
  }

} //StateAssertionImpl
