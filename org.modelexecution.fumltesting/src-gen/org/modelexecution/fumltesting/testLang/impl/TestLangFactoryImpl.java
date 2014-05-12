/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelexecution.fumltesting.testLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLangFactoryImpl extends EFactoryImpl implements TestLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TestLangFactory init()
  {
    try
    {
      TestLangFactory theTestLangFactory = (TestLangFactory)EPackage.Registry.INSTANCE.getEFactory(TestLangPackage.eNS_URI);
      if (theTestLangFactory != null)
      {
        return theTestLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TestLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TestLangPackage.UML_TEST_SUITE: return createUMLTestSuite();
      case TestLangPackage.IMPORT: return createImport();
      case TestLangPackage.UML_TEST_CASE: return createUMLTestCase();
      case TestLangPackage.UML_ACTIVITY_INPUT: return createUMLActivityInput();
      case TestLangPackage.UML_VALUE: return createUMLValue();
      case TestLangPackage.UML_SIMPLE_VALUE: return createUMLSimpleValue();
      case TestLangPackage.UML_OBJECT_VALUE: return createUMLObjectValue();
      case TestLangPackage.UML_SCENARIO: return createUMLScenario();
      case TestLangPackage.UML_OBJECT_SPECIFICATION: return createUMLObjectSpecification();
      case TestLangPackage.UML_ATTRIBUTE: return createUMLAttribute();
      case TestLangPackage.UML_LINK: return createUMLLink();
      case TestLangPackage.UML_ASSERTION: return createUMLAssertion();
      case TestLangPackage.UML_STATE_ASSERTION: return createUMLStateAssertion();
      case TestLangPackage.UML_REFERENCE_POINT: return createUMLReferencePoint();
      case TestLangPackage.UML_ACTION_REFERENCE_POINT: return createUMLActionReferencePoint();
      case TestLangPackage.UML_CONSTRAINT_REFERENCE_POINT: return createUMLConstraintReferencePoint();
      case TestLangPackage.UML_FINALLY_STATE_ASSERTION: return createUMLFinallyStateAssertion();
      case TestLangPackage.UML_CHECK: return createUMLCheck();
      case TestLangPackage.UML_CONSTRAINT_CHECK: return createUMLConstraintCheck();
      case TestLangPackage.UML_STATE_EXPRESSION: return createUMLStateExpression();
      case TestLangPackage.UML_OBJECT_STATE_EXPRESSION: return createUMLObjectStateExpression();
      case TestLangPackage.UML_PROPERTY_STATE_EXPRESSION: return createUMLPropertyStateExpression();
      case TestLangPackage.UML_ORDER_ASSERTION: return createUMLOrderAssertion();
      case TestLangPackage.UML_NODE_ORDER: return createUMLNodeOrder();
      case TestLangPackage.UML_NODE_SPECIFICATION: return createUMLNodeSpecification();
      case TestLangPackage.FINALLY_STATE_ASSERTION: return createFinallyStateAssertion();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TestLangPackage.UML_ARITHMETIC_OPERATOR:
        return createUMLArithmeticOperatorFromString(eDataType, initialValue);
      case TestLangPackage.UML_TEMPORAL_OPERATOR:
        return createUMLTemporalOperatorFromString(eDataType, initialValue);
      case TestLangPackage.UML_TEMPORAL_QUANTIFIER:
        return createUMLTemporalQuantifierFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TestLangPackage.UML_ARITHMETIC_OPERATOR:
        return convertUMLArithmeticOperatorToString(eDataType, instanceValue);
      case TestLangPackage.UML_TEMPORAL_OPERATOR:
        return convertUMLTemporalOperatorToString(eDataType, instanceValue);
      case TestLangPackage.UML_TEMPORAL_QUANTIFIER:
        return convertUMLTemporalQuantifierToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTestSuite createUMLTestSuite()
  {
    UMLTestSuiteImpl umlTestSuite = new UMLTestSuiteImpl();
    return umlTestSuite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTestCase createUMLTestCase()
  {
    UMLTestCaseImpl umlTestCase = new UMLTestCaseImpl();
    return umlTestCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLActivityInput createUMLActivityInput()
  {
    UMLActivityInputImpl umlActivityInput = new UMLActivityInputImpl();
    return umlActivityInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLValue createUMLValue()
  {
    UMLValueImpl umlValue = new UMLValueImpl();
    return umlValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLSimpleValue createUMLSimpleValue()
  {
    UMLSimpleValueImpl umlSimpleValue = new UMLSimpleValueImpl();
    return umlSimpleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLObjectValue createUMLObjectValue()
  {
    UMLObjectValueImpl umlObjectValue = new UMLObjectValueImpl();
    return umlObjectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLScenario createUMLScenario()
  {
    UMLScenarioImpl umlScenario = new UMLScenarioImpl();
    return umlScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLObjectSpecification createUMLObjectSpecification()
  {
    UMLObjectSpecificationImpl umlObjectSpecification = new UMLObjectSpecificationImpl();
    return umlObjectSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAttribute createUMLAttribute()
  {
    UMLAttributeImpl umlAttribute = new UMLAttributeImpl();
    return umlAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLLink createUMLLink()
  {
    UMLLinkImpl umlLink = new UMLLinkImpl();
    return umlLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAssertion createUMLAssertion()
  {
    UMLAssertionImpl umlAssertion = new UMLAssertionImpl();
    return umlAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLStateAssertion createUMLStateAssertion()
  {
    UMLStateAssertionImpl umlStateAssertion = new UMLStateAssertionImpl();
    return umlStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLReferencePoint createUMLReferencePoint()
  {
    UMLReferencePointImpl umlReferencePoint = new UMLReferencePointImpl();
    return umlReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLActionReferencePoint createUMLActionReferencePoint()
  {
    UMLActionReferencePointImpl umlActionReferencePoint = new UMLActionReferencePointImpl();
    return umlActionReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLConstraintReferencePoint createUMLConstraintReferencePoint()
  {
    UMLConstraintReferencePointImpl umlConstraintReferencePoint = new UMLConstraintReferencePointImpl();
    return umlConstraintReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLFinallyStateAssertion createUMLFinallyStateAssertion()
  {
    UMLFinallyStateAssertionImpl umlFinallyStateAssertion = new UMLFinallyStateAssertionImpl();
    return umlFinallyStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLCheck createUMLCheck()
  {
    UMLCheckImpl umlCheck = new UMLCheckImpl();
    return umlCheck;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLConstraintCheck createUMLConstraintCheck()
  {
    UMLConstraintCheckImpl umlConstraintCheck = new UMLConstraintCheckImpl();
    return umlConstraintCheck;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLStateExpression createUMLStateExpression()
  {
    UMLStateExpressionImpl umlStateExpression = new UMLStateExpressionImpl();
    return umlStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLObjectStateExpression createUMLObjectStateExpression()
  {
    UMLObjectStateExpressionImpl umlObjectStateExpression = new UMLObjectStateExpressionImpl();
    return umlObjectStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPropertyStateExpression createUMLPropertyStateExpression()
  {
    UMLPropertyStateExpressionImpl umlPropertyStateExpression = new UMLPropertyStateExpressionImpl();
    return umlPropertyStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLOrderAssertion createUMLOrderAssertion()
  {
    UMLOrderAssertionImpl umlOrderAssertion = new UMLOrderAssertionImpl();
    return umlOrderAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLNodeOrder createUMLNodeOrder()
  {
    UMLNodeOrderImpl umlNodeOrder = new UMLNodeOrderImpl();
    return umlNodeOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLNodeSpecification createUMLNodeSpecification()
  {
    UMLNodeSpecificationImpl umlNodeSpecification = new UMLNodeSpecificationImpl();
    return umlNodeSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinallyStateAssertion createFinallyStateAssertion()
  {
    FinallyStateAssertionImpl finallyStateAssertion = new FinallyStateAssertionImpl();
    return finallyStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLArithmeticOperator createUMLArithmeticOperatorFromString(EDataType eDataType, String initialValue)
  {
    UMLArithmeticOperator result = UMLArithmeticOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUMLArithmeticOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemporalOperator createUMLTemporalOperatorFromString(EDataType eDataType, String initialValue)
  {
    UMLTemporalOperator result = UMLTemporalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUMLTemporalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemporalQuantifier createUMLTemporalQuantifierFromString(EDataType eDataType, String initialValue)
  {
    UMLTemporalQuantifier result = UMLTemporalQuantifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUMLTemporalQuantifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangPackage getTestLangPackage()
  {
    return (TestLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TestLangPackage getPackage()
  {
    return TestLangPackage.eINSTANCE;
  }

} //TestLangFactoryImpl
