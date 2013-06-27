/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.ArithmeticOperator;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.Attribute;
import org.modelexecution.fumltesting.testLang.Feature;
import org.modelexecution.fumltesting.testLang.Import;
import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.MultiValueLink;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.OrderExecutionAssertion;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.SingleValueLink;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestLangFactory;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.TestSuite;
import org.modelexecution.fumltesting.testLang.Value;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLangPackageImpl extends EPackageImpl implements TestLangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testSuiteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activityInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleValueLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiValueLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orderExecutionAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeOrderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum arithmeticOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum temporalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum temporalQuantifierEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TestLangPackageImpl()
  {
    super(eNS_URI, TestLangFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TestLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TestLangPackage init()
  {
    if (isInited) return (TestLangPackage)EPackage.Registry.INSTANCE.getEPackage(TestLangPackage.eNS_URI);

    // Obtain or create and register package
    TestLangPackageImpl theTestLangPackage = (TestLangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestLangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestLangPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    UMLPackage.eINSTANCE.eClass();
    XbasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTestLangPackage.createPackageContents();

    // Initialize created meta-data
    theTestLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTestLangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TestLangPackage.eNS_URI, theTestLangPackage);
    return theTestLangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestSuite()
  {
    return testSuiteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestSuite_Imports()
  {
    return (EReference)testSuiteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestSuite_Scenarios()
  {
    return (EReference)testSuiteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestSuite_Tests()
  {
    return (EReference)testSuiteEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarDeclaration()
  {
    return varDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarDeclaration_Name()
  {
    return (EAttribute)varDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarDeclaration_Ref()
  {
    return (EReference)varDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestCase()
  {
    return testCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestCase_Name()
  {
    return (EAttribute)testCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_ActivityUnderTest()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_Inputs()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_Variables()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_Assertions()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivityInput()
  {
    return activityInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityInput_Parameter()
  {
    return (EReference)activityInputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivityInput_Value()
  {
    return (EReference)activityInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleValue()
  {
    return simpleValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleValue_Value()
  {
    return (EReference)simpleValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectValue()
  {
    return objectValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectValue_Value()
  {
    return (EReference)objectValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScenario()
  {
    return scenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScenario_Name()
  {
    return (EAttribute)scenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScenario_Objects()
  {
    return (EReference)scenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectSpecification()
  {
    return objectSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectSpecification_Name()
  {
    return (EAttribute)objectSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectSpecification_Type()
  {
    return (EReference)objectSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectSpecification_Features()
  {
    return (EReference)objectSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Att()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Value()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLink()
  {
    return linkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLink_Link()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleValueLink()
  {
    return singleValueLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleValueLink_Value()
  {
    return (EReference)singleValueLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiValueLink()
  {
    return multiValueLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiValueLink_Values()
  {
    return (EReference)multiValueLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssertion()
  {
    return assertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateAssertion()
  {
    return stateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateAssertion_TemporalQuantifier()
  {
    return (EAttribute)stateAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateAssertion_TemporalOperator()
  {
    return (EAttribute)stateAssertionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_ReferenceAction()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_UntilAction()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_Expressions()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateExpression()
  {
    return stateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExpression_Pin()
  {
    return (EReference)stateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateExpression_Operator()
  {
    return (EAttribute)stateExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateExpression_Value()
  {
    return (EReference)stateExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectStateExpression()
  {
    return objectStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyStateExpression()
  {
    return propertyStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyStateExpression_Property()
  {
    return (EReference)propertyStateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrderExecutionAssertion()
  {
    return orderExecutionAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrderExecutionAssertion_Order()
  {
    return (EReference)orderExecutionAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeOrder()
  {
    return nodeOrderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeOrder_Nodes()
  {
    return (EReference)nodeOrderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeSpecification()
  {
    return nodeSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeSpecification_Node()
  {
    return (EReference)nodeSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeSpecification_Size()
  {
    return (EReference)nodeSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeSpecification_SubOrder()
  {
    return (EReference)nodeSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNodeSpecification_Joker()
  {
    return (EAttribute)nodeSpecificationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getArithmeticOperator()
  {
    return arithmeticOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTemporalOperator()
  {
    return temporalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTemporalQuantifier()
  {
    return temporalQuantifierEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangFactory getTestLangFactory()
  {
    return (TestLangFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    testSuiteEClass = createEClass(TEST_SUITE);
    createEReference(testSuiteEClass, TEST_SUITE__IMPORTS);
    createEReference(testSuiteEClass, TEST_SUITE__SCENARIOS);
    createEReference(testSuiteEClass, TEST_SUITE__TESTS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    varDeclarationEClass = createEClass(VAR_DECLARATION);
    createEAttribute(varDeclarationEClass, VAR_DECLARATION__NAME);
    createEReference(varDeclarationEClass, VAR_DECLARATION__REF);

    testCaseEClass = createEClass(TEST_CASE);
    createEAttribute(testCaseEClass, TEST_CASE__NAME);
    createEReference(testCaseEClass, TEST_CASE__ACTIVITY_UNDER_TEST);
    createEReference(testCaseEClass, TEST_CASE__INPUTS);
    createEReference(testCaseEClass, TEST_CASE__VARIABLES);
    createEReference(testCaseEClass, TEST_CASE__ASSERTIONS);

    activityInputEClass = createEClass(ACTIVITY_INPUT);
    createEReference(activityInputEClass, ACTIVITY_INPUT__PARAMETER);
    createEReference(activityInputEClass, ACTIVITY_INPUT__VALUE);

    valueEClass = createEClass(VALUE);

    simpleValueEClass = createEClass(SIMPLE_VALUE);
    createEReference(simpleValueEClass, SIMPLE_VALUE__VALUE);

    objectValueEClass = createEClass(OBJECT_VALUE);
    createEReference(objectValueEClass, OBJECT_VALUE__VALUE);

    scenarioEClass = createEClass(SCENARIO);
    createEAttribute(scenarioEClass, SCENARIO__NAME);
    createEReference(scenarioEClass, SCENARIO__OBJECTS);

    objectSpecificationEClass = createEClass(OBJECT_SPECIFICATION);
    createEAttribute(objectSpecificationEClass, OBJECT_SPECIFICATION__NAME);
    createEReference(objectSpecificationEClass, OBJECT_SPECIFICATION__TYPE);
    createEReference(objectSpecificationEClass, OBJECT_SPECIFICATION__FEATURES);

    featureEClass = createEClass(FEATURE);

    attributeEClass = createEClass(ATTRIBUTE);
    createEReference(attributeEClass, ATTRIBUTE__ATT);
    createEReference(attributeEClass, ATTRIBUTE__VALUE);

    linkEClass = createEClass(LINK);
    createEReference(linkEClass, LINK__LINK);

    singleValueLinkEClass = createEClass(SINGLE_VALUE_LINK);
    createEReference(singleValueLinkEClass, SINGLE_VALUE_LINK__VALUE);

    multiValueLinkEClass = createEClass(MULTI_VALUE_LINK);
    createEReference(multiValueLinkEClass, MULTI_VALUE_LINK__VALUES);

    assertionEClass = createEClass(ASSERTION);

    stateAssertionEClass = createEClass(STATE_ASSERTION);
    createEAttribute(stateAssertionEClass, STATE_ASSERTION__TEMPORAL_QUANTIFIER);
    createEAttribute(stateAssertionEClass, STATE_ASSERTION__TEMPORAL_OPERATOR);
    createEReference(stateAssertionEClass, STATE_ASSERTION__REFERENCE_ACTION);
    createEReference(stateAssertionEClass, STATE_ASSERTION__UNTIL_ACTION);
    createEReference(stateAssertionEClass, STATE_ASSERTION__EXPRESSIONS);

    stateExpressionEClass = createEClass(STATE_EXPRESSION);
    createEReference(stateExpressionEClass, STATE_EXPRESSION__PIN);
    createEAttribute(stateExpressionEClass, STATE_EXPRESSION__OPERATOR);
    createEReference(stateExpressionEClass, STATE_EXPRESSION__VALUE);

    objectStateExpressionEClass = createEClass(OBJECT_STATE_EXPRESSION);

    propertyStateExpressionEClass = createEClass(PROPERTY_STATE_EXPRESSION);
    createEReference(propertyStateExpressionEClass, PROPERTY_STATE_EXPRESSION__PROPERTY);

    orderExecutionAssertionEClass = createEClass(ORDER_EXECUTION_ASSERTION);
    createEReference(orderExecutionAssertionEClass, ORDER_EXECUTION_ASSERTION__ORDER);

    nodeOrderEClass = createEClass(NODE_ORDER);
    createEReference(nodeOrderEClass, NODE_ORDER__NODES);

    nodeSpecificationEClass = createEClass(NODE_SPECIFICATION);
    createEReference(nodeSpecificationEClass, NODE_SPECIFICATION__NODE);
    createEReference(nodeSpecificationEClass, NODE_SPECIFICATION__SIZE);
    createEReference(nodeSpecificationEClass, NODE_SPECIFICATION__SUB_ORDER);
    createEAttribute(nodeSpecificationEClass, NODE_SPECIFICATION__JOKER);

    // Create enums
    arithmeticOperatorEEnum = createEEnum(ARITHMETIC_OPERATOR);
    temporalOperatorEEnum = createEEnum(TEMPORAL_OPERATOR);
    temporalQuantifierEEnum = createEEnum(TEMPORAL_QUANTIFIER);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    simpleValueEClass.getESuperTypes().add(this.getValue());
    objectValueEClass.getESuperTypes().add(this.getValue());
    attributeEClass.getESuperTypes().add(this.getFeature());
    linkEClass.getESuperTypes().add(this.getFeature());
    singleValueLinkEClass.getESuperTypes().add(this.getLink());
    multiValueLinkEClass.getESuperTypes().add(this.getLink());
    stateAssertionEClass.getESuperTypes().add(this.getAssertion());
    objectStateExpressionEClass.getESuperTypes().add(this.getStateExpression());
    propertyStateExpressionEClass.getESuperTypes().add(this.getStateExpression());
    orderExecutionAssertionEClass.getESuperTypes().add(this.getAssertion());

    // Initialize classes and features; add operations and parameters
    initEClass(testSuiteEClass, TestSuite.class, "TestSuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTestSuite_Imports(), this.getImport(), null, "imports", null, 0, -1, TestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestSuite_Scenarios(), this.getScenario(), null, "scenarios", null, 0, -1, TestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestSuite_Tests(), this.getTestCase(), null, "tests", null, 0, -1, TestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), theEcorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varDeclarationEClass, VarDeclaration.class, "VarDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarDeclaration_Ref(), theUMLPackage.getObjectNode(), null, "ref", null, 0, 1, VarDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testCaseEClass, TestCase.class, "TestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestCase_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestCase_ActivityUnderTest(), theUMLPackage.getActivity(), null, "activityUnderTest", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestCase_Inputs(), this.getActivityInput(), null, "inputs", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestCase_Variables(), this.getVarDeclaration(), null, "variables", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestCase_Assertions(), this.getAssertion(), null, "assertions", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(activityInputEClass, ActivityInput.class, "ActivityInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActivityInput_Parameter(), theUMLPackage.getActivityParameterNode(), null, "parameter", null, 0, 1, ActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActivityInput_Value(), this.getValue(), null, "value", null, 0, 1, ActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simpleValueEClass, SimpleValue.class, "SimpleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSimpleValue_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, SimpleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectValueEClass, ObjectValue.class, "ObjectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectValue_Value(), this.getObjectSpecification(), null, "value", null, 0, 1, ObjectValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScenario_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getScenario_Objects(), this.getObjectSpecification(), null, "objects", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectSpecificationEClass, ObjectSpecification.class, "ObjectSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectSpecification_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectSpecification_Type(), theUMLPackage.getClass_(), null, "type", null, 0, 1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectSpecification_Features(), this.getFeature(), null, "features", null, 0, -1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttribute_Att(), theUMLPackage.getProperty(), null, "att", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Value(), this.getValue(), null, "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLink_Link(), theUMLPackage.getProperty(), null, "link", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleValueLinkEClass, SingleValueLink.class, "SingleValueLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSingleValueLink_Value(), this.getObjectSpecification(), null, "value", null, 0, 1, SingleValueLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiValueLinkEClass, MultiValueLink.class, "MultiValueLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiValueLink_Values(), this.getObjectSpecification(), null, "values", null, 0, -1, MultiValueLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateAssertionEClass, StateAssertion.class, "StateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStateAssertion_TemporalQuantifier(), this.getTemporalQuantifier(), "temporalQuantifier", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStateAssertion_TemporalOperator(), this.getTemporalOperator(), "temporalOperator", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_ReferenceAction(), theUMLPackage.getAction(), null, "referenceAction", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_UntilAction(), theUMLPackage.getAction(), null, "untilAction", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_Expressions(), this.getStateExpression(), null, "expressions", null, 0, -1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateExpressionEClass, StateExpression.class, "StateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateExpression_Pin(), this.getVarDeclaration(), null, "pin", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStateExpression_Operator(), this.getArithmeticOperator(), "operator", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExpression_Value(), this.getValue(), null, "value", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectStateExpressionEClass, ObjectStateExpression.class, "ObjectStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyStateExpressionEClass, PropertyStateExpression.class, "PropertyStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyStateExpression_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, PropertyStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orderExecutionAssertionEClass, OrderExecutionAssertion.class, "OrderExecutionAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrderExecutionAssertion_Order(), this.getNodeOrder(), null, "order", null, 0, 1, OrderExecutionAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeOrderEClass, NodeOrder.class, "NodeOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeOrder_Nodes(), this.getNodeSpecification(), null, "nodes", null, 0, -1, NodeOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeSpecificationEClass, NodeSpecification.class, "NodeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeSpecification_Node(), theUMLPackage.getActivityNode(), null, "node", null, 0, 1, NodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeSpecification_Size(), theXbasePackage.getXExpression(), null, "size", null, 0, 1, NodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeSpecification_SubOrder(), this.getNodeOrder(), null, "subOrder", null, 0, 1, NodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNodeSpecification_Joker(), theEcorePackage.getEString(), "joker", null, 0, 1, NodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(arithmeticOperatorEEnum, ArithmeticOperator.class, "ArithmeticOperator");
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.EQUAL);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.NOT_EQUAL);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.GREATER);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.SMALLER);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.GREATER_EQUAL);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.SMALLER_EQUAL);

    initEEnum(temporalOperatorEEnum, TemporalOperator.class, "TemporalOperator");
    addEEnumLiteral(temporalOperatorEEnum, TemporalOperator.AFTER);
    addEEnumLiteral(temporalOperatorEEnum, TemporalOperator.BEFORE);

    initEEnum(temporalQuantifierEEnum, TemporalQuantifier.class, "TemporalQuantifier");
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.EXACTLY);
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.ALWAYS);

    // Create resource
    createResource(eNS_URI);
  }

} //TestLangPackageImpl