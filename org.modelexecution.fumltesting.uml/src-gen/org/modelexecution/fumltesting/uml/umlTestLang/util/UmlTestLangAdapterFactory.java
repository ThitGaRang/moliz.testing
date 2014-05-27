/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelexecution.fumltesting.uml.umlTestLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage
 * @generated
 */
public class UmlTestLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UmlTestLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlTestLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = UmlTestLangPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmlTestLangSwitch<Adapter> modelSwitch =
    new UmlTestLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseUMLTestSuite(UMLTestSuite object)
      {
        return createUMLTestSuiteAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseUMLTestCase(UMLTestCase object)
      {
        return createUMLTestCaseAdapter();
      }
      @Override
      public Adapter caseUMLActivityInput(UMLActivityInput object)
      {
        return createUMLActivityInputAdapter();
      }
      @Override
      public Adapter caseUMLValue(UMLValue object)
      {
        return createUMLValueAdapter();
      }
      @Override
      public Adapter caseUMLSimpleValue(UMLSimpleValue object)
      {
        return createUMLSimpleValueAdapter();
      }
      @Override
      public Adapter caseUMLObjectValue(UMLObjectValue object)
      {
        return createUMLObjectValueAdapter();
      }
      @Override
      public Adapter caseUMLScenario(UMLScenario object)
      {
        return createUMLScenarioAdapter();
      }
      @Override
      public Adapter caseUMLObjectSpecification(UMLObjectSpecification object)
      {
        return createUMLObjectSpecificationAdapter();
      }
      @Override
      public Adapter caseUMLAttribute(UMLAttribute object)
      {
        return createUMLAttributeAdapter();
      }
      @Override
      public Adapter caseUMLLink(UMLLink object)
      {
        return createUMLLinkAdapter();
      }
      @Override
      public Adapter caseUMLAssertion(UMLAssertion object)
      {
        return createUMLAssertionAdapter();
      }
      @Override
      public Adapter caseUMLStateAssertion(UMLStateAssertion object)
      {
        return createUMLStateAssertionAdapter();
      }
      @Override
      public Adapter caseUMLReferencePoint(UMLReferencePoint object)
      {
        return createUMLReferencePointAdapter();
      }
      @Override
      public Adapter caseUMLActionReferencePoint(UMLActionReferencePoint object)
      {
        return createUMLActionReferencePointAdapter();
      }
      @Override
      public Adapter caseUMLConstraintReferencePoint(UMLConstraintReferencePoint object)
      {
        return createUMLConstraintReferencePointAdapter();
      }
      @Override
      public Adapter caseUMLFinallyStateAssertion(UMLFinallyStateAssertion object)
      {
        return createUMLFinallyStateAssertionAdapter();
      }
      @Override
      public Adapter caseUMLCheck(UMLCheck object)
      {
        return createUMLCheckAdapter();
      }
      @Override
      public Adapter caseUMLConstraintCheck(UMLConstraintCheck object)
      {
        return createUMLConstraintCheckAdapter();
      }
      @Override
      public Adapter caseUMLStateExpression(UMLStateExpression object)
      {
        return createUMLStateExpressionAdapter();
      }
      @Override
      public Adapter caseUMLObjectStateExpression(UMLObjectStateExpression object)
      {
        return createUMLObjectStateExpressionAdapter();
      }
      @Override
      public Adapter caseUMLPropertyStateExpression(UMLPropertyStateExpression object)
      {
        return createUMLPropertyStateExpressionAdapter();
      }
      @Override
      public Adapter caseUMLOrderAssertion(UMLOrderAssertion object)
      {
        return createUMLOrderAssertionAdapter();
      }
      @Override
      public Adapter caseUMLNodeOrder(UMLNodeOrder object)
      {
        return createUMLNodeOrderAdapter();
      }
      @Override
      public Adapter caseUMLNodeSpecification(UMLNodeSpecification object)
      {
        return createUMLNodeSpecificationAdapter();
      }
      @Override
      public Adapter caseFinallyStateAssertion(FinallyStateAssertion object)
      {
        return createFinallyStateAssertionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite <em>UML Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite
   * @generated
   */
  public Adapter createUMLTestSuiteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase <em>UML Test Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase
   * @generated
   */
  public Adapter createUMLTestCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput <em>UML Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput
   * @generated
   */
  public Adapter createUMLActivityInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLValue <em>UML Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLValue
   * @generated
   */
  public Adapter createUMLValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue <em>UML Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue
   * @generated
   */
  public Adapter createUMLSimpleValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue <em>UML Object Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue
   * @generated
   */
  public Adapter createUMLObjectValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario <em>UML Scenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario
   * @generated
   */
  public Adapter createUMLScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification <em>UML Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification
   * @generated
   */
  public Adapter createUMLObjectSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute <em>UML Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute
   * @generated
   */
  public Adapter createUMLAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink <em>UML Link</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink
   * @generated
   */
  public Adapter createUMLLinkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion <em>UML Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion
   * @generated
   */
  public Adapter createUMLAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion <em>UML State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion
   * @generated
   */
  public Adapter createUMLStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLReferencePoint <em>UML Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLReferencePoint
   * @generated
   */
  public Adapter createUMLReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint <em>UML Action Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint
   * @generated
   */
  public Adapter createUMLActionReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint <em>UML Constraint Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint
   * @generated
   */
  public Adapter createUMLConstraintReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion <em>UML Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion
   * @generated
   */
  public Adapter createUMLFinallyStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck <em>UML Check</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck
   * @generated
   */
  public Adapter createUMLCheckAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck <em>UML Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck
   * @generated
   */
  public Adapter createUMLConstraintCheckAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression <em>UML State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression
   * @generated
   */
  public Adapter createUMLStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression <em>UML Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression
   * @generated
   */
  public Adapter createUMLObjectStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression <em>UML Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression
   * @generated
   */
  public Adapter createUMLPropertyStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion <em>UML Order Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion
   * @generated
   */
  public Adapter createUMLOrderAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder <em>UML Node Order</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder
   * @generated
   */
  public Adapter createUMLNodeOrderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification <em>UML Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification
   * @generated
   */
  public Adapter createUMLNodeSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion <em>Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion
   * @generated
   */
  public Adapter createFinallyStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //UmlTestLangAdapterFactory
