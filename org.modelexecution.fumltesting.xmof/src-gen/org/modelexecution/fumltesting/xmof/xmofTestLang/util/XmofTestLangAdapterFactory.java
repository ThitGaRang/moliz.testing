/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.modelexecution.fumltesting.xmof.xmofTestLang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage
 * @generated
 */
public class XmofTestLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XmofTestLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmofTestLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XmofTestLangPackage.eINSTANCE;
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
  protected XmofTestLangSwitch<Adapter> modelSwitch =
    new XmofTestLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseXMOFTestSuite(XMOFTestSuite object)
      {
        return createXMOFTestSuiteAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseXMOFTestCase(XMOFTestCase object)
      {
        return createXMOFTestCaseAdapter();
      }
      @Override
      public Adapter caseXMOFActivityInput(XMOFActivityInput object)
      {
        return createXMOFActivityInputAdapter();
      }
      @Override
      public Adapter caseXMOFValue(XMOFValue object)
      {
        return createXMOFValueAdapter();
      }
      @Override
      public Adapter caseXMOFSimpleValue(XMOFSimpleValue object)
      {
        return createXMOFSimpleValueAdapter();
      }
      @Override
      public Adapter caseXMOFObjectValue(XMOFObjectValue object)
      {
        return createXMOFObjectValueAdapter();
      }
      @Override
      public Adapter caseXMOFScenario(XMOFScenario object)
      {
        return createXMOFScenarioAdapter();
      }
      @Override
      public Adapter caseXMOFObjectSpecification(XMOFObjectSpecification object)
      {
        return createXMOFObjectSpecificationAdapter();
      }
      @Override
      public Adapter caseXMOFAttribute(XMOFAttribute object)
      {
        return createXMOFAttributeAdapter();
      }
      @Override
      public Adapter caseXMOFLink(XMOFLink object)
      {
        return createXMOFLinkAdapter();
      }
      @Override
      public Adapter caseXMOFAssertion(XMOFAssertion object)
      {
        return createXMOFAssertionAdapter();
      }
      @Override
      public Adapter caseXMOFStateAssertion(XMOFStateAssertion object)
      {
        return createXMOFStateAssertionAdapter();
      }
      @Override
      public Adapter caseXMOFReferencePoint(XMOFReferencePoint object)
      {
        return createXMOFReferencePointAdapter();
      }
      @Override
      public Adapter caseXMOFActionReferencePoint(XMOFActionReferencePoint object)
      {
        return createXMOFActionReferencePointAdapter();
      }
      @Override
      public Adapter caseXMOFConstraintReferencePoint(XMOFConstraintReferencePoint object)
      {
        return createXMOFConstraintReferencePointAdapter();
      }
      @Override
      public Adapter caseXMOFFinallyStateAssertion(XMOFFinallyStateAssertion object)
      {
        return createXMOFFinallyStateAssertionAdapter();
      }
      @Override
      public Adapter caseXMOFCheck(XMOFCheck object)
      {
        return createXMOFCheckAdapter();
      }
      @Override
      public Adapter caseXMOFConstraintCheck(XMOFConstraintCheck object)
      {
        return createXMOFConstraintCheckAdapter();
      }
      @Override
      public Adapter caseXMOFStateExpression(XMOFStateExpression object)
      {
        return createXMOFStateExpressionAdapter();
      }
      @Override
      public Adapter caseXMOFObjectStateExpression(XMOFObjectStateExpression object)
      {
        return createXMOFObjectStateExpressionAdapter();
      }
      @Override
      public Adapter caseXMOFPropertyStateExpression(XMOFPropertyStateExpression object)
      {
        return createXMOFPropertyStateExpressionAdapter();
      }
      @Override
      public Adapter caseXMOFOrderAssertion(XMOFOrderAssertion object)
      {
        return createXMOFOrderAssertionAdapter();
      }
      @Override
      public Adapter caseXMOFNodeOrder(XMOFNodeOrder object)
      {
        return createXMOFNodeOrderAdapter();
      }
      @Override
      public Adapter caseXMOFNodeSpecification(XMOFNodeSpecification object)
      {
        return createXMOFNodeSpecificationAdapter();
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
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite <em>XMOF Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite
   * @generated
   */
  public Adapter createXMOFTestSuiteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase <em>XMOF Test Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase
   * @generated
   */
  public Adapter createXMOFTestCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput <em>XMOF Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput
   * @generated
   */
  public Adapter createXMOFActivityInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue <em>XMOF Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue
   * @generated
   */
  public Adapter createXMOFValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue <em>XMOF Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue
   * @generated
   */
  public Adapter createXMOFSimpleValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue <em>XMOF Object Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue
   * @generated
   */
  public Adapter createXMOFObjectValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario <em>XMOF Scenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario
   * @generated
   */
  public Adapter createXMOFScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification <em>XMOF Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification
   * @generated
   */
  public Adapter createXMOFObjectSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute <em>XMOF Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute
   * @generated
   */
  public Adapter createXMOFAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink <em>XMOF Link</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink
   * @generated
   */
  public Adapter createXMOFLinkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion <em>XMOF Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion
   * @generated
   */
  public Adapter createXMOFAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion <em>XMOF State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion
   * @generated
   */
  public Adapter createXMOFStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint <em>XMOF Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint
   * @generated
   */
  public Adapter createXMOFReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint <em>XMOF Action Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint
   * @generated
   */
  public Adapter createXMOFActionReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint <em>XMOF Constraint Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint
   * @generated
   */
  public Adapter createXMOFConstraintReferencePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFFinallyStateAssertion <em>XMOF Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFFinallyStateAssertion
   * @generated
   */
  public Adapter createXMOFFinallyStateAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck <em>XMOF Check</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck
   * @generated
   */
  public Adapter createXMOFCheckAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck <em>XMOF Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck
   * @generated
   */
  public Adapter createXMOFConstraintCheckAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression <em>XMOF State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression
   * @generated
   */
  public Adapter createXMOFStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectStateExpression <em>XMOF Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectStateExpression
   * @generated
   */
  public Adapter createXMOFObjectStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression <em>XMOF Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression
   * @generated
   */
  public Adapter createXMOFPropertyStateExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion <em>XMOF Order Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion
   * @generated
   */
  public Adapter createXMOFOrderAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder <em>XMOF Node Order</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder
   * @generated
   */
  public Adapter createXMOFNodeOrderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification <em>XMOF Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification
   * @generated
   */
  public Adapter createXMOFNodeSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion <em>Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion
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

} //XmofTestLangAdapterFactory
