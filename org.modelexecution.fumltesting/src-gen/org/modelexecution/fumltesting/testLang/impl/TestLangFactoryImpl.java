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
      case TestLangPackage.TEST_SUITE: return createTestSuite();
      case TestLangPackage.IMPORT: return createImport();
      case TestLangPackage.VAR_DECLARATION: return createVarDeclaration();
      case TestLangPackage.TEST_CASE: return createTestCase();
      case TestLangPackage.ACTIVITY_INPUT: return createActivityInput();
      case TestLangPackage.VALUE: return createValue();
      case TestLangPackage.SIMPLE_VALUE: return createSimpleValue();
      case TestLangPackage.OBJECT_VALUE: return createObjectValue();
      case TestLangPackage.SCENARIO: return createScenario();
      case TestLangPackage.OBJECT_SPECIFICATION: return createObjectSpecification();
      case TestLangPackage.ATTRIBUTE: return createAttribute();
      case TestLangPackage.LINK: return createLink();
      case TestLangPackage.ASSERTION: return createAssertion();
      case TestLangPackage.STATE_ASSERTION: return createStateAssertion();
      case TestLangPackage.FINALLY_STATE_ASSERTION: return createFinallyStateAssertion();
      case TestLangPackage.CONSTRAINTS: return createConstraints();
      case TestLangPackage.STATE_EXPRESSION: return createStateExpression();
      case TestLangPackage.OBJECT_STATE_EXPRESSION: return createObjectStateExpression();
      case TestLangPackage.PROPERTY_STATE_EXPRESSION: return createPropertyStateExpression();
      case TestLangPackage.ORDER_ASSERTION: return createOrderAssertion();
      case TestLangPackage.NODE_ORDER: return createNodeOrder();
      case TestLangPackage.NODE_SPECIFICATION: return createNodeSpecification();
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
      case TestLangPackage.ARITHMETIC_OPERATOR:
        return createArithmeticOperatorFromString(eDataType, initialValue);
      case TestLangPackage.TEMPORAL_OPERATOR:
        return createTemporalOperatorFromString(eDataType, initialValue);
      case TestLangPackage.TEMPORAL_QUANTIFIER:
        return createTemporalQuantifierFromString(eDataType, initialValue);
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
      case TestLangPackage.ARITHMETIC_OPERATOR:
        return convertArithmeticOperatorToString(eDataType, instanceValue);
      case TestLangPackage.TEMPORAL_OPERATOR:
        return convertTemporalOperatorToString(eDataType, instanceValue);
      case TestLangPackage.TEMPORAL_QUANTIFIER:
        return convertTemporalQuantifierToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestSuite createTestSuite()
  {
    TestSuiteImpl testSuite = new TestSuiteImpl();
    return testSuite;
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
  public VarDeclaration createVarDeclaration()
  {
    VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
    return varDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestCase createTestCase()
  {
    TestCaseImpl testCase = new TestCaseImpl();
    return testCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityInput createActivityInput()
  {
    ActivityInputImpl activityInput = new ActivityInputImpl();
    return activityInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleValue createSimpleValue()
  {
    SimpleValueImpl simpleValue = new SimpleValueImpl();
    return simpleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectValue createObjectValue()
  {
    ObjectValueImpl objectValue = new ObjectValueImpl();
    return objectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scenario createScenario()
  {
    ScenarioImpl scenario = new ScenarioImpl();
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectSpecification createObjectSpecification()
  {
    ObjectSpecificationImpl objectSpecification = new ObjectSpecificationImpl();
    return objectSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Link createLink()
  {
    LinkImpl link = new LinkImpl();
    return link;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assertion createAssertion()
  {
    AssertionImpl assertion = new AssertionImpl();
    return assertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateAssertion createStateAssertion()
  {
    StateAssertionImpl stateAssertion = new StateAssertionImpl();
    return stateAssertion;
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
  public Constraints createConstraints()
  {
    ConstraintsImpl constraints = new ConstraintsImpl();
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateExpression createStateExpression()
  {
    StateExpressionImpl stateExpression = new StateExpressionImpl();
    return stateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectStateExpression createObjectStateExpression()
  {
    ObjectStateExpressionImpl objectStateExpression = new ObjectStateExpressionImpl();
    return objectStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyStateExpression createPropertyStateExpression()
  {
    PropertyStateExpressionImpl propertyStateExpression = new PropertyStateExpressionImpl();
    return propertyStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderAssertion createOrderAssertion()
  {
    OrderAssertionImpl orderAssertion = new OrderAssertionImpl();
    return orderAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeOrder createNodeOrder()
  {
    NodeOrderImpl nodeOrder = new NodeOrderImpl();
    return nodeOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeSpecification createNodeSpecification()
  {
    NodeSpecificationImpl nodeSpecification = new NodeSpecificationImpl();
    return nodeSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArithmeticOperator createArithmeticOperatorFromString(EDataType eDataType, String initialValue)
  {
    ArithmeticOperator result = ArithmeticOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertArithmeticOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemporalOperator createTemporalOperatorFromString(EDataType eDataType, String initialValue)
  {
    TemporalOperator result = TemporalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTemporalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemporalQuantifier createTemporalQuantifierFromString(EDataType eDataType, String initialValue)
  {
    TemporalQuantifier result = TemporalQuantifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTemporalQuantifierToString(EDataType eDataType, Object instanceValue)
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
