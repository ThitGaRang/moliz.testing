/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.modelexecution.fumltesting.uml.umlTestLang.*;

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
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage
 * @generated
 */
public class UmlTestLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UmlTestLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlTestLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = UmlTestLangPackage.eINSTANCE;
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
      case UmlTestLangPackage.UML_TEST_SUITE:
      {
        UMLTestSuite umlTestSuite = (UMLTestSuite)theEObject;
        T result = caseUMLTestSuite(umlTestSuite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_TEST_CASE:
      {
        UMLTestCase umlTestCase = (UMLTestCase)theEObject;
        T result = caseUMLTestCase(umlTestCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_ACTIVITY_INPUT:
      {
        UMLActivityInput umlActivityInput = (UMLActivityInput)theEObject;
        T result = caseUMLActivityInput(umlActivityInput);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_VALUE:
      {
        UMLValue umlValue = (UMLValue)theEObject;
        T result = caseUMLValue(umlValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_SIMPLE_VALUE:
      {
        UMLSimpleValue umlSimpleValue = (UMLSimpleValue)theEObject;
        T result = caseUMLSimpleValue(umlSimpleValue);
        if (result == null) result = caseUMLValue(umlSimpleValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_OBJECT_VALUE:
      {
        UMLObjectValue umlObjectValue = (UMLObjectValue)theEObject;
        T result = caseUMLObjectValue(umlObjectValue);
        if (result == null) result = caseUMLValue(umlObjectValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_SCENARIO:
      {
        UMLScenario umlScenario = (UMLScenario)theEObject;
        T result = caseUMLScenario(umlScenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_OBJECT_SPECIFICATION:
      {
        UMLObjectSpecification umlObjectSpecification = (UMLObjectSpecification)theEObject;
        T result = caseUMLObjectSpecification(umlObjectSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_ATTRIBUTE:
      {
        UMLAttribute umlAttribute = (UMLAttribute)theEObject;
        T result = caseUMLAttribute(umlAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_LINK:
      {
        UMLLink umlLink = (UMLLink)theEObject;
        T result = caseUMLLink(umlLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_ASSERTION:
      {
        UMLAssertion umlAssertion = (UMLAssertion)theEObject;
        T result = caseUMLAssertion(umlAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_STATE_ASSERTION:
      {
        UMLStateAssertion umlStateAssertion = (UMLStateAssertion)theEObject;
        T result = caseUMLStateAssertion(umlStateAssertion);
        if (result == null) result = caseUMLAssertion(umlStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_REFERENCE_POINT:
      {
        UMLReferencePoint umlReferencePoint = (UMLReferencePoint)theEObject;
        T result = caseUMLReferencePoint(umlReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_ACTION_REFERENCE_POINT:
      {
        UMLActionReferencePoint umlActionReferencePoint = (UMLActionReferencePoint)theEObject;
        T result = caseUMLActionReferencePoint(umlActionReferencePoint);
        if (result == null) result = caseUMLReferencePoint(umlActionReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_CONSTRAINT_REFERENCE_POINT:
      {
        UMLConstraintReferencePoint umlConstraintReferencePoint = (UMLConstraintReferencePoint)theEObject;
        T result = caseUMLConstraintReferencePoint(umlConstraintReferencePoint);
        if (result == null) result = caseUMLReferencePoint(umlConstraintReferencePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_FINALLY_STATE_ASSERTION:
      {
        UMLFinallyStateAssertion umlFinallyStateAssertion = (UMLFinallyStateAssertion)theEObject;
        T result = caseUMLFinallyStateAssertion(umlFinallyStateAssertion);
        if (result == null) result = caseUMLAssertion(umlFinallyStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_CHECK:
      {
        UMLCheck umlCheck = (UMLCheck)theEObject;
        T result = caseUMLCheck(umlCheck);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_CONSTRAINT_CHECK:
      {
        UMLConstraintCheck umlConstraintCheck = (UMLConstraintCheck)theEObject;
        T result = caseUMLConstraintCheck(umlConstraintCheck);
        if (result == null) result = caseUMLCheck(umlConstraintCheck);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_STATE_EXPRESSION:
      {
        UMLStateExpression umlStateExpression = (UMLStateExpression)theEObject;
        T result = caseUMLStateExpression(umlStateExpression);
        if (result == null) result = caseUMLCheck(umlStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_OBJECT_STATE_EXPRESSION:
      {
        UMLObjectStateExpression umlObjectStateExpression = (UMLObjectStateExpression)theEObject;
        T result = caseUMLObjectStateExpression(umlObjectStateExpression);
        if (result == null) result = caseUMLStateExpression(umlObjectStateExpression);
        if (result == null) result = caseUMLCheck(umlObjectStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_PROPERTY_STATE_EXPRESSION:
      {
        UMLPropertyStateExpression umlPropertyStateExpression = (UMLPropertyStateExpression)theEObject;
        T result = caseUMLPropertyStateExpression(umlPropertyStateExpression);
        if (result == null) result = caseUMLStateExpression(umlPropertyStateExpression);
        if (result == null) result = caseUMLCheck(umlPropertyStateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_ORDER_ASSERTION:
      {
        UMLOrderAssertion umlOrderAssertion = (UMLOrderAssertion)theEObject;
        T result = caseUMLOrderAssertion(umlOrderAssertion);
        if (result == null) result = caseUMLAssertion(umlOrderAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_NODE_ORDER:
      {
        UMLNodeOrder umlNodeOrder = (UMLNodeOrder)theEObject;
        T result = caseUMLNodeOrder(umlNodeOrder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.UML_NODE_SPECIFICATION:
      {
        UMLNodeSpecification umlNodeSpecification = (UMLNodeSpecification)theEObject;
        T result = caseUMLNodeSpecification(umlNodeSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmlTestLangPackage.FINALLY_STATE_ASSERTION:
      {
        FinallyStateAssertion finallyStateAssertion = (FinallyStateAssertion)theEObject;
        T result = caseFinallyStateAssertion(finallyStateAssertion);
        if (result == null) result = caseUMLFinallyStateAssertion(finallyStateAssertion);
        if (result == null) result = caseUMLAssertion(finallyStateAssertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Test Suite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Test Suite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTestSuite(UMLTestSuite object)
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
   * Returns the result of interpreting the object as an instance of '<em>UML Test Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Test Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTestCase(UMLTestCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Activity Input</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Activity Input</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLActivityInput(UMLActivityInput object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLValue(UMLValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Simple Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Simple Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLSimpleValue(UMLSimpleValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Object Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Object Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLObjectValue(UMLObjectValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Scenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Scenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLScenario(UMLScenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Object Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Object Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLObjectSpecification(UMLObjectSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAttribute(UMLAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLLink(UMLLink object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAssertion(UMLAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML State Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML State Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLStateAssertion(UMLStateAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLReferencePoint(UMLReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Action Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Action Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLActionReferencePoint(UMLActionReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Constraint Reference Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Constraint Reference Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLConstraintReferencePoint(UMLConstraintReferencePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Finally State Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Finally State Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLFinallyStateAssertion(UMLFinallyStateAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLCheck(UMLCheck object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Constraint Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Constraint Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLConstraintCheck(UMLConstraintCheck object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLStateExpression(UMLStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Object State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Object State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLObjectStateExpression(UMLObjectStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Property State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Property State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLPropertyStateExpression(UMLPropertyStateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Order Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Order Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLOrderAssertion(UMLOrderAssertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Node Order</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Node Order</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLNodeOrder(UMLNodeOrder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Node Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Node Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLNodeSpecification(UMLNodeSpecification object)
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

} //UmlTestLangSwitch
