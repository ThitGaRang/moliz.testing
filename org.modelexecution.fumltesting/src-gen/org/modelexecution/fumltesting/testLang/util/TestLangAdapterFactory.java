/**
 */
package org.modelexecution.fumltesting.testLang.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelexecution.fumltesting.testLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage
 * @generated
 */
public class TestLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TestLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TestLangPackage.eINSTANCE;
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
  protected TestLangSwitch<Adapter> modelSwitch =
    new TestLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseTestSuite(TestSuite object)
      {
        return createTestSuiteAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseVarDeclaration(VarDeclaration object)
      {
        return createVarDeclarationAdapter();
      }
      @Override
      public Adapter caseTestCase(TestCase object)
      {
        return createTestCaseAdapter();
      }
      @Override
      public Adapter caseActivityInput(ActivityInput object)
      {
        return createActivityInputAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseSimpleValue(SimpleValue object)
      {
        return createSimpleValueAdapter();
      }
      @Override
      public Adapter caseObjectValue(ObjectValue object)
      {
        return createObjectValueAdapter();
      }
      @Override
      public Adapter caseScenario(Scenario object)
      {
        return createScenarioAdapter();
      }
      @Override
      public Adapter caseObjectSpecification(ObjectSpecification object)
      {
        return createObjectSpecificationAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseLink(Link object)
      {
        return createLinkAdapter();
      }
      @Override
      public Adapter caseAssertion(Assertion object)
      {
        return createAssertionAdapter();
      }
      @Override
      public Adapter caseStateAssertion(StateAssertion object)
      {
        return createStateAssertionAdapter();
      }
      @Override
      public Adapter caseStateExpression(StateExpression object)
      {
        return createStateExpressionAdapter();
      }
      @Override
      public Adapter caseObjectStateExpression(ObjectStateExpression object)
      {
        return createObjectStateExpressionAdapter();
      }
      @Override
      public Adapter casePropertyStateExpression(PropertyStateExpression object)
      {
        return createPropertyStateExpressionAdapter();
      }
      @Override
      public Adapter caseOrderExecutionAssertion(OrderExecutionAssertion object)
      {
        return createOrderExecutionAssertionAdapter();
      }
      @Override
      public Adapter caseNodeOrder(NodeOrder object)
      {
        return createNodeOrderAdapter();
      }
      @Override
      public Adapter caseNodeSpecification(NodeSpecification object)
      {
        return createNodeSpecificationAdapter();
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
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.TestSuite <em>Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.TestSuite
   * @generated
   */
  public Adapter createTestSuiteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.VarDeclaration <em>Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.VarDeclaration
   * @generated
   */
  public Adapter createVarDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.TestCase <em>Test Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.TestCase
   * @generated
   */
  public Adapter createTestCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.ActivityInput <em>Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.ActivityInput
   * @generated
   */
  public Adapter createActivityInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.SimpleValue <em>Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.SimpleValue
   * @generated
   */
  public Adapter createSimpleValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.ObjectValue <em>Object Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.ObjectValue
   * @generated
   */
  public Adapter createObjectValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Scenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Scenario
   * @generated
   */
  public Adapter createScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.ObjectSpecification <em>Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.ObjectSpecification
   * @generated
   */
  public Adapter createObjectSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Link <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Link
   * @generated
   */
  public Adapter createLinkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.Assertion
   * @generated
   */
  public Adapter createAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.StateAssertion <em>State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion
   * @generated
   */
  public Adapter createStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.StateExpression <em>State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.StateExpression
   * @generated
   */
  public Adapter createStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.ObjectStateExpression <em>Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.ObjectStateExpression
   * @generated
   */
  public Adapter createObjectStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.PropertyStateExpression <em>Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.PropertyStateExpression
   * @generated
   */
  public Adapter createPropertyStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.OrderExecutionAssertion <em>Order Execution Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.OrderExecutionAssertion
   * @generated
   */
  public Adapter createOrderExecutionAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.NodeOrder <em>Node Order</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.NodeOrder
   * @generated
   */
  public Adapter createNodeOrderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.testLang.NodeSpecification <em>Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification
   * @generated
   */
  public Adapter createNodeSpecificationAdapter()
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

} //TestLangAdapterFactory
