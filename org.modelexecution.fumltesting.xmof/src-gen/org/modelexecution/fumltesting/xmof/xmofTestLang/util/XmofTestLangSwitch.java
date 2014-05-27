/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.modelexecution.fumltesting.xmof.xmofTestLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage
 * @generated
 */
public class XmofTestLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XmofTestLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmofTestLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = XmofTestLangPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case XmofTestLangPackage.XMOF_TEST_SUITE:
      {
        XMOFTestSuite xmofTestSuite = (XMOFTestSuite)theEObject;
        T result = caseXMOFTestSuite(xmofTestSuite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_TEST_CASE:
      {
        XMOFTestCase xmofTestCase = (XMOFTestCase)theEObject;
        T result = caseXMOFTestCase(xmofTestCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT:
      {
        XMOFActivityInput xmofActivityInput = (XMOFActivityInput)theEObject;
        T result = caseXMOFActivityInput(xmofActivityInput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_VALUE:
      {
        XMOFValue xmofValue = (XMOFValue)theEObject;
        T result = caseXMOFValue(xmofValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_SIMPLE_VALUE:
      {
        XMOFSimpleValue xmofSimpleValue = (XMOFSimpleValue)theEObject;
        T result = caseXMOFSimpleValue(xmofSimpleValue);
        if (result == null) result = caseXMOFValue(xmofSimpleValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_OBJECT_VALUE:
      {
        XMOFObjectValue xmofObjectValue = (XMOFObjectValue)theEObject;
        T result = caseXMOFObjectValue(xmofObjectValue);
        if (result == null) result = caseXMOFValue(xmofObjectValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_SCENARIO:
      {
        XMOFScenario xmofScenario = (XMOFScenario)theEObject;
        T result = caseXMOFScenario(xmofScenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_OBJECT_SPECIFICATION:
      {
        XMOFObjectSpecification xmofObjectSpecification = (XMOFObjectSpecification)theEObject;
        T result = caseXMOFObjectSpecification(xmofObjectSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_ATTRIBUTE:
      {
        XMOFAttribute xmofAttribute = (XMOFAttribute)theEObject;
        T result = caseXMOFAttribute(xmofAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_LINK:
      {
        XMOFLink xmofLink = (XMOFLink)theEObject;
        T result = caseXMOFLink(xmofLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_ASSERTION:
      {
        XMOFAssertion xmofAssertion = (XMOFAssertion)theEObject;
        T result = caseXMOFAssertion(xmofAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_STATE_ASSERTION:
      {
        XMOFStateAssertion xmofStateAssertion = (XMOFStateAssertion)theEObject;
        T result = caseXMOFStateAssertion(xmofStateAssertion);
        if (result == null) result = caseXMOFAssertion(xmofStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_REFERENCE_POINT:
      {
        XMOFReferencePoint xmofReferencePoint = (XMOFReferencePoint)theEObject;
        T result = caseXMOFReferencePoint(xmofReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_ACTION_REFERENCE_POINT:
      {
        XMOFActionReferencePoint xmofActionReferencePoint = (XMOFActionReferencePoint)theEObject;
        T result = caseXMOFActionReferencePoint(xmofActionReferencePoint);
        if (result == null) result = caseXMOFReferencePoint(xmofActionReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT:
      {
        XMOFConstraintReferencePoint xmofConstraintReferencePoint = (XMOFConstraintReferencePoint)theEObject;
        T result = caseXMOFConstraintReferencePoint(xmofConstraintReferencePoint);
        if (result == null) result = caseXMOFReferencePoint(xmofConstraintReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_FINALLY_STATE_ASSERTION:
      {
        XMOFFinallyStateAssertion xmofFinallyStateAssertion = (XMOFFinallyStateAssertion)theEObject;
        T result = caseXMOFFinallyStateAssertion(xmofFinallyStateAssertion);
        if (result == null) result = caseXMOFAssertion(xmofFinallyStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_CHECK:
      {
        XMOFCheck xmofCheck = (XMOFCheck)theEObject;
        T result = caseXMOFCheck(xmofCheck);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_CONSTRAINT_CHECK:
      {
        XMOFConstraintCheck xmofConstraintCheck = (XMOFConstraintCheck)theEObject;
        T result = caseXMOFConstraintCheck(xmofConstraintCheck);
        if (result == null) result = caseXMOFCheck(xmofConstraintCheck);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_STATE_EXPRESSION:
      {
        XMOFStateExpression xmofStateExpression = (XMOFStateExpression)theEObject;
        T result = caseXMOFStateExpression(xmofStateExpression);
        if (result == null) result = caseXMOFCheck(xmofStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_OBJECT_STATE_EXPRESSION:
      {
        XMOFObjectStateExpression xmofObjectStateExpression = (XMOFObjectStateExpression)theEObject;
        T result = caseXMOFObjectStateExpression(xmofObjectStateExpression);
        if (result == null) result = caseXMOFStateExpression(xmofObjectStateExpression);
        if (result == null) result = caseXMOFCheck(xmofObjectStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_PROPERTY_STATE_EXPRESSION:
      {
        XMOFPropertyStateExpression xmofPropertyStateExpression = (XMOFPropertyStateExpression)theEObject;
        T result = caseXMOFPropertyStateExpression(xmofPropertyStateExpression);
        if (result == null) result = caseXMOFStateExpression(xmofPropertyStateExpression);
        if (result == null) result = caseXMOFCheck(xmofPropertyStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_ORDER_ASSERTION:
      {
        XMOFOrderAssertion xmofOrderAssertion = (XMOFOrderAssertion)theEObject;
        T result = caseXMOFOrderAssertion(xmofOrderAssertion);
        if (result == null) result = caseXMOFAssertion(xmofOrderAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_NODE_ORDER:
      {
        XMOFNodeOrder xmofNodeOrder = (XMOFNodeOrder)theEObject;
        T result = caseXMOFNodeOrder(xmofNodeOrder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.XMOF_NODE_SPECIFICATION:
      {
        XMOFNodeSpecification xmofNodeSpecification = (XMOFNodeSpecification)theEObject;
        T result = caseXMOFNodeSpecification(xmofNodeSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XmofTestLangPackage.FINALLY_STATE_ASSERTION:
      {
        FinallyStateAssertion finallyStateAssertion = (FinallyStateAssertion)theEObject;
        T result = caseFinallyStateAssertion(finallyStateAssertion);
        if (result == null) result = caseXMOFFinallyStateAssertion(finallyStateAssertion);
        if (result == null) result = caseXMOFAssertion(finallyStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Test Suite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Test Suite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFTestSuite(XMOFTestSuite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Test Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Test Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFTestCase(XMOFTestCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Activity Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Activity Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFActivityInput(XMOFActivityInput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFValue(XMOFValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Simple Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Simple Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFSimpleValue(XMOFSimpleValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Object Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Object Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFObjectValue(XMOFObjectValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Scenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Scenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFScenario(XMOFScenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Object Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Object Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFObjectSpecification(XMOFObjectSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFAttribute(XMOFAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFLink(XMOFLink object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFAssertion(XMOFAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF State Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF State Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFStateAssertion(XMOFStateAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFReferencePoint(XMOFReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Action Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Action Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFActionReferencePoint(XMOFActionReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Constraint Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Constraint Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFConstraintReferencePoint(XMOFConstraintReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Finally State Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Finally State Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFFinallyStateAssertion(XMOFFinallyStateAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFCheck(XMOFCheck object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Constraint Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Constraint Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFConstraintCheck(XMOFConstraintCheck object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFStateExpression(XMOFStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Object State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Object State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFObjectStateExpression(XMOFObjectStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Property State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Property State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFPropertyStateExpression(XMOFPropertyStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Order Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Order Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFOrderAssertion(XMOFOrderAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Node Order</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Node Order</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFNodeOrder(XMOFNodeOrder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XMOF Node Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XMOF Node Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXMOFNodeSpecification(XMOFNodeSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Finally State Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Finally State Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFinallyStateAssertion(FinallyStateAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //XmofTestLangSwitch
