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

import org.modelexecution.fumltesting.testLang.ActionReferencePoint;
import org.modelexecution.fumltesting.testLang.ActivityInput;
import org.modelexecution.fumltesting.testLang.ArithmeticOperator;
import org.modelexecution.fumltesting.testLang.Assertion;
import org.modelexecution.fumltesting.testLang.Attribute;
import org.modelexecution.fumltesting.testLang.Check;
import org.modelexecution.fumltesting.testLang.ConstraintCheck;
import org.modelexecution.fumltesting.testLang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.Import;
import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.ReferencePoint;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.SimpleValue;
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
  private EClass referencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass finallyStateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass checkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintCheckEClass = null;

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
  private EClass orderAssertionEClass = null;

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
  public EReference getTestCase_ContextObject()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_InitScenarios()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_Variables()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestCase_Assertions()
  {
    return (EReference)testCaseEClass.getEStructuralFeatures().get(6);
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
  public EReference getScenario_Links()
  {
    return (EReference)scenarioEClass.getEStructuralFeatures().get(2);
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
  public EReference getObjectSpecification_Attributes()
  {
    return (EReference)objectSpecificationEClass.getEStructuralFeatures().get(2);
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
  public EReference getLink_Assoc()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLink_SourceProperty()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLink_SourceValue()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLink_TargetProperty()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLink_TargetValue()
  {
    return (EReference)linkEClass.getEStructuralFeatures().get(4);
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
  public EAttribute getStateAssertion_Quantifier()
  {
    return (EAttribute)stateAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateAssertion_Operator()
  {
    return (EAttribute)stateAssertionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_ReferencePoint()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_UntilPoint()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateAssertion_Checks()
  {
    return (EReference)stateAssertionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferencePoint()
  {
    return referencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionReferencePoint()
  {
    return actionReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionReferencePoint_Action()
  {
    return (EReference)actionReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintReferencePoint()
  {
    return constraintReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintReferencePoint_ConstraintName()
  {
    return (EReference)constraintReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFinallyStateAssertion()
  {
    return finallyStateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinallyStateAssertion_Checks()
  {
    return (EReference)finallyStateAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCheck()
  {
    return checkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintCheck()
  {
    return constraintCheckEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintCheck_ConstraintNames()
  {
    return (EReference)constraintCheckEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintCheck_Object()
  {
    return (EReference)constraintCheckEClass.getEStructuralFeatures().get(1);
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
  public EClass getOrderAssertion()
  {
    return orderAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrderAssertion_Order()
  {
    return (EReference)orderAssertionEClass.getEStructuralFeatures().get(0);
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
    createEReference(testCaseEClass, TEST_CASE__CONTEXT_OBJECT);
    createEReference(testCaseEClass, TEST_CASE__INIT_SCENARIOS);
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
    createEReference(scenarioEClass, SCENARIO__LINKS);

    objectSpecificationEClass = createEClass(OBJECT_SPECIFICATION);
    createEAttribute(objectSpecificationEClass, OBJECT_SPECIFICATION__NAME);
    createEReference(objectSpecificationEClass, OBJECT_SPECIFICATION__TYPE);
    createEReference(objectSpecificationEClass, OBJECT_SPECIFICATION__ATTRIBUTES);

    attributeEClass = createEClass(ATTRIBUTE);
    createEReference(attributeEClass, ATTRIBUTE__ATT);
    createEReference(attributeEClass, ATTRIBUTE__VALUE);

    linkEClass = createEClass(LINK);
    createEReference(linkEClass, LINK__ASSOC);
    createEReference(linkEClass, LINK__SOURCE_PROPERTY);
    createEReference(linkEClass, LINK__SOURCE_VALUE);
    createEReference(linkEClass, LINK__TARGET_PROPERTY);
    createEReference(linkEClass, LINK__TARGET_VALUE);

    assertionEClass = createEClass(ASSERTION);

    stateAssertionEClass = createEClass(STATE_ASSERTION);
    createEAttribute(stateAssertionEClass, STATE_ASSERTION__QUANTIFIER);
    createEAttribute(stateAssertionEClass, STATE_ASSERTION__OPERATOR);
    createEReference(stateAssertionEClass, STATE_ASSERTION__REFERENCE_POINT);
    createEReference(stateAssertionEClass, STATE_ASSERTION__UNTIL_POINT);
    createEReference(stateAssertionEClass, STATE_ASSERTION__CHECKS);

    referencePointEClass = createEClass(REFERENCE_POINT);

    actionReferencePointEClass = createEClass(ACTION_REFERENCE_POINT);
    createEReference(actionReferencePointEClass, ACTION_REFERENCE_POINT__ACTION);

    constraintReferencePointEClass = createEClass(CONSTRAINT_REFERENCE_POINT);
    createEReference(constraintReferencePointEClass, CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME);

    finallyStateAssertionEClass = createEClass(FINALLY_STATE_ASSERTION);
    createEReference(finallyStateAssertionEClass, FINALLY_STATE_ASSERTION__CHECKS);

    checkEClass = createEClass(CHECK);

    constraintCheckEClass = createEClass(CONSTRAINT_CHECK);
    createEReference(constraintCheckEClass, CONSTRAINT_CHECK__CONSTRAINT_NAMES);
    createEReference(constraintCheckEClass, CONSTRAINT_CHECK__OBJECT);

    stateExpressionEClass = createEClass(STATE_EXPRESSION);
    createEReference(stateExpressionEClass, STATE_EXPRESSION__PIN);
    createEAttribute(stateExpressionEClass, STATE_EXPRESSION__OPERATOR);
    createEReference(stateExpressionEClass, STATE_EXPRESSION__VALUE);

    objectStateExpressionEClass = createEClass(OBJECT_STATE_EXPRESSION);

    propertyStateExpressionEClass = createEClass(PROPERTY_STATE_EXPRESSION);
    createEReference(propertyStateExpressionEClass, PROPERTY_STATE_EXPRESSION__PROPERTY);

    orderAssertionEClass = createEClass(ORDER_ASSERTION);
    createEReference(orderAssertionEClass, ORDER_ASSERTION__ORDER);

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
    stateAssertionEClass.getESuperTypes().add(this.getAssertion());
    actionReferencePointEClass.getESuperTypes().add(this.getReferencePoint());
    constraintReferencePointEClass.getESuperTypes().add(this.getReferencePoint());
    finallyStateAssertionEClass.getESuperTypes().add(this.getAssertion());
    constraintCheckEClass.getESuperTypes().add(this.getCheck());
    stateExpressionEClass.getESuperTypes().add(this.getCheck());
    objectStateExpressionEClass.getESuperTypes().add(this.getStateExpression());
    propertyStateExpressionEClass.getESuperTypes().add(this.getStateExpression());
    orderAssertionEClass.getESuperTypes().add(this.getAssertion());

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
    initEReference(getTestCase_ContextObject(), this.getObjectSpecification(), null, "contextObject", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestCase_InitScenarios(), this.getScenario(), null, "initScenarios", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
    initEReference(getScenario_Links(), this.getLink(), null, "links", null, 0, -1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectSpecificationEClass, ObjectSpecification.class, "ObjectSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObjectSpecification_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectSpecification_Type(), theUMLPackage.getClass_(), null, "type", null, 0, 1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectSpecification_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttribute_Att(), theUMLPackage.getProperty(), null, "att", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Value(), this.getValue(), null, "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLink_Assoc(), theUMLPackage.getAssociation(), null, "assoc", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLink_SourceProperty(), theUMLPackage.getProperty(), null, "sourceProperty", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLink_SourceValue(), this.getObjectSpecification(), null, "sourceValue", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLink_TargetProperty(), theUMLPackage.getProperty(), null, "targetProperty", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLink_TargetValue(), this.getObjectSpecification(), null, "targetValue", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateAssertionEClass, StateAssertion.class, "StateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStateAssertion_Quantifier(), this.getTemporalQuantifier(), "quantifier", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStateAssertion_Operator(), this.getTemporalOperator(), "operator", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_ReferencePoint(), this.getReferencePoint(), null, "referencePoint", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_UntilPoint(), this.getReferencePoint(), null, "untilPoint", null, 0, 1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateAssertion_Checks(), this.getCheck(), null, "checks", null, 0, -1, StateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referencePointEClass, ReferencePoint.class, "ReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actionReferencePointEClass, ActionReferencePoint.class, "ActionReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActionReferencePoint_Action(), theUMLPackage.getAction(), null, "action", null, 0, 1, ActionReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintReferencePointEClass, ConstraintReferencePoint.class, "ConstraintReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintReferencePoint_ConstraintName(), theXbasePackage.getXExpression(), null, "constraintName", null, 0, 1, ConstraintReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(finallyStateAssertionEClass, FinallyStateAssertion.class, "FinallyStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFinallyStateAssertion_Checks(), this.getCheck(), null, "checks", null, 0, -1, FinallyStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(checkEClass, Check.class, "Check", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constraintCheckEClass, ConstraintCheck.class, "ConstraintCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintCheck_ConstraintNames(), theXbasePackage.getXExpression(), null, "constraintNames", null, 0, -1, ConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstraintCheck_Object(), this.getVarDeclaration(), null, "object", null, 0, 1, ConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateExpressionEClass, StateExpression.class, "StateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateExpression_Pin(), this.getVarDeclaration(), null, "pin", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStateExpression_Operator(), this.getArithmeticOperator(), "operator", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateExpression_Value(), this.getValue(), null, "value", null, 0, 1, StateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectStateExpressionEClass, ObjectStateExpression.class, "ObjectStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyStateExpressionEClass, PropertyStateExpression.class, "PropertyStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyStateExpression_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, PropertyStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orderAssertionEClass, OrderAssertion.class, "OrderAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrderAssertion_Order(), this.getNodeOrder(), null, "order", null, 0, 1, OrderAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.INCLUDES);
    addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.EXCLUDES);

    initEEnum(temporalOperatorEEnum, TemporalOperator.class, "TemporalOperator");
    addEEnumLiteral(temporalOperatorEEnum, TemporalOperator.AFTER);
    addEEnumLiteral(temporalOperatorEEnum, TemporalOperator.UNTIL);

    initEEnum(temporalQuantifierEEnum, TemporalQuantifier.class, "TemporalQuantifier");
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.ALWAYS);
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.SOMETIMES);
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.EVENTUALLY);
    addEEnumLiteral(temporalQuantifierEEnum, TemporalQuantifier.IMMEDIATELY);

    // Create resource
    createResource(eNS_URI);
  }

} //TestLangPackageImpl
