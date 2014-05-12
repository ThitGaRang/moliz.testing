/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.ObjectNode;

import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLArithmeticOperator;
import org.modelexecution.fumltesting.testLang.UMLStateExpression;
import org.modelexecution.fumltesting.testLang.UMLValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML State Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLStateExpressionImpl#getPin <em>Pin</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLStateExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLStateExpressionImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLStateExpressionImpl extends UMLCheckImpl implements UMLStateExpression
{
  /**
   * The cached value of the '{@link #getPin() <em>Pin</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPin()
   * @generated
   * @ordered
   */
  protected ObjectNode pin;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final UMLArithmeticOperator OPERATOR_EDEFAULT = UMLArithmeticOperator.EQUAL;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected UMLArithmeticOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected UMLValue value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLStateExpressionImpl()
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
    return TestLangPackage.Literals.UML_STATE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectNode getPin()
  {
    if (pin != null && pin.eIsProxy())
    {
      InternalEObject oldPin = (InternalEObject)pin;
      pin = (ObjectNode)eResolveProxy(oldPin);
      if (pin != oldPin)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.UML_STATE_EXPRESSION__PIN, oldPin, pin));
      }
    }
    return pin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectNode basicGetPin()
  {
    return pin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPin(ObjectNode newPin)
  {
    ObjectNode oldPin = pin;
    pin = newPin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_STATE_EXPRESSION__PIN, oldPin, pin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLArithmeticOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(UMLArithmeticOperator newOperator)
  {
    UMLArithmeticOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_STATE_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(UMLValue newValue, NotificationChain msgs)
  {
    UMLValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_STATE_EXPRESSION__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(UMLValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.UML_STATE_EXPRESSION__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.UML_STATE_EXPRESSION__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.UML_STATE_EXPRESSION__VALUE, newValue, newValue));
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
      case TestLangPackage.UML_STATE_EXPRESSION__VALUE:
        return basicSetValue(null, msgs);
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
      case TestLangPackage.UML_STATE_EXPRESSION__PIN:
        if (resolve) return getPin();
        return basicGetPin();
      case TestLangPackage.UML_STATE_EXPRESSION__OPERATOR:
        return getOperator();
      case TestLangPackage.UML_STATE_EXPRESSION__VALUE:
        return getValue();
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
      case TestLangPackage.UML_STATE_EXPRESSION__PIN:
        setPin((ObjectNode)newValue);
        return;
      case TestLangPackage.UML_STATE_EXPRESSION__OPERATOR:
        setOperator((UMLArithmeticOperator)newValue);
        return;
      case TestLangPackage.UML_STATE_EXPRESSION__VALUE:
        setValue((UMLValue)newValue);
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
      case TestLangPackage.UML_STATE_EXPRESSION__PIN:
        setPin((ObjectNode)null);
        return;
      case TestLangPackage.UML_STATE_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case TestLangPackage.UML_STATE_EXPRESSION__VALUE:
        setValue((UMLValue)null);
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
      case TestLangPackage.UML_STATE_EXPRESSION__PIN:
        return pin != null;
      case TestLangPackage.UML_STATE_EXPRESSION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case TestLangPackage.UML_STATE_EXPRESSION__VALUE:
        return value != null;
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //UMLStateExpressionImpl
