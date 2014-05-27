/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.xbase.XbasePackage;

import org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.Import;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFFinallyStateAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectStateExpression;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangFactory;
import org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage;

import org.modelexecution.xmof.Syntax.Actions.BasicActions.BasicActionsPackage;

import org.modelexecution.xmof.Syntax.Activities.CompleteStructuredActivities.CompleteStructuredActivitiesPackage;

import org.modelexecution.xmof.Syntax.Activities.IntermediateActivities.IntermediateActivitiesPackage;

import org.modelexecution.xmof.Syntax.Classes.Kernel.KernelPackage;

import org.modelexecution.xmof.Syntax.CommonBehaviors.BasicBehaviors.BasicBehaviorsPackage;

import org.modelexecution.xmof.Syntax.CommonBehaviors.Communications.CommunicationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmofTestLangPackageImpl extends EPackageImpl implements XmofTestLangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofTestSuiteEClass = null;

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
  private EClass xmofTestCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofActivityInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofSimpleValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofObjectValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofScenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofObjectSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofStateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofActionReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofConstraintReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofFinallyStateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofCheckEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofConstraintCheckEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofObjectStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofPropertyStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofOrderAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofNodeOrderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmofNodeSpecificationEClass = null;

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
  private EEnum xmofArithmeticOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum xmofTemporalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum xmofTemporalQuantifierEEnum = null;

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
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private XmofTestLangPackageImpl()
  {
    super(eNS_URI, XmofTestLangFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link XmofTestLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static XmofTestLangPackage init()
  {
    if (isInited) return (XmofTestLangPackage)EPackage.Registry.INSTANCE.getEPackage(XmofTestLangPackage.eNS_URI);

    // Obtain or create and register package
    XmofTestLangPackageImpl theXmofTestLangPackage = (XmofTestLangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XmofTestLangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XmofTestLangPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();
    BasicActionsPackage.eINSTANCE.eClass();
    IntermediateActivitiesPackage.eINSTANCE.eClass();
    CompleteStructuredActivitiesPackage.eINSTANCE.eClass();
    CommunicationsPackage.eINSTANCE.eClass();
    BasicBehaviorsPackage.eINSTANCE.eClass();
    KernelPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theXmofTestLangPackage.createPackageContents();

    // Initialize created meta-data
    theXmofTestLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theXmofTestLangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(XmofTestLangPackage.eNS_URI, theXmofTestLangPackage);
    return theXmofTestLangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFTestSuite()
  {
    return xmofTestSuiteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestSuite_Imports()
  {
    return (EReference)xmofTestSuiteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestSuite_Scenarios()
  {
    return (EReference)xmofTestSuiteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestSuite_Tests()
  {
    return (EReference)xmofTestSuiteEClass.getEStructuralFeatures().get(2);
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
  public EClass getXMOFTestCase()
  {
    return xmofTestCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFTestCase_Name()
  {
    return (EAttribute)xmofTestCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestCase_ActivityUnderTest()
  {
    return (EReference)xmofTestCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestCase_Inputs()
  {
    return (EReference)xmofTestCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestCase_ContextObject()
  {
    return (EReference)xmofTestCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestCase_InitScenarios()
  {
    return (EReference)xmofTestCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFTestCase_Assertions()
  {
    return (EReference)xmofTestCaseEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFActivityInput()
  {
    return xmofActivityInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFActivityInput_Parameter()
  {
    return (EReference)xmofActivityInputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFActivityInput_Value()
  {
    return (EReference)xmofActivityInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFValue()
  {
    return xmofValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFSimpleValue()
  {
    return xmofSimpleValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFSimpleValue_Value()
  {
    return (EReference)xmofSimpleValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFObjectValue()
  {
    return xmofObjectValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFObjectValue_Value()
  {
    return (EReference)xmofObjectValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFScenario()
  {
    return xmofScenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFScenario_Name()
  {
    return (EAttribute)xmofScenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFScenario_Objects()
  {
    return (EReference)xmofScenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFScenario_Links()
  {
    return (EReference)xmofScenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFObjectSpecification()
  {
    return xmofObjectSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFObjectSpecification_Name()
  {
    return (EAttribute)xmofObjectSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFObjectSpecification_Type()
  {
    return (EReference)xmofObjectSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFObjectSpecification_Attributes()
  {
    return (EReference)xmofObjectSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFAttribute()
  {
    return xmofAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFAttribute_Att()
  {
    return (EReference)xmofAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFAttribute_Value()
  {
    return (EReference)xmofAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFLink()
  {
    return xmofLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFLink_Assoc()
  {
    return (EReference)xmofLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFLink_SourceProperty()
  {
    return (EReference)xmofLinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFLink_SourceValue()
  {
    return (EReference)xmofLinkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFLink_TargetProperty()
  {
    return (EReference)xmofLinkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFLink_TargetValue()
  {
    return (EReference)xmofLinkEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFAssertion()
  {
    return xmofAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFStateAssertion()
  {
    return xmofStateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFStateAssertion_Quantifier()
  {
    return (EAttribute)xmofStateAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFStateAssertion_Operator()
  {
    return (EAttribute)xmofStateAssertionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFStateAssertion_ReferencePoint()
  {
    return (EReference)xmofStateAssertionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFStateAssertion_UntilPoint()
  {
    return (EReference)xmofStateAssertionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFStateAssertion_Checks()
  {
    return (EReference)xmofStateAssertionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFReferencePoint()
  {
    return xmofReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFActionReferencePoint()
  {
    return xmofActionReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFActionReferencePoint_Action()
  {
    return (EReference)xmofActionReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFConstraintReferencePoint()
  {
    return xmofConstraintReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFConstraintReferencePoint_ConstraintName()
  {
    return (EReference)xmofConstraintReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFFinallyStateAssertion()
  {
    return xmofFinallyStateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFCheck()
  {
    return xmofCheckEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFConstraintCheck()
  {
    return xmofConstraintCheckEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFConstraintCheck_ConstraintNames()
  {
    return (EReference)xmofConstraintCheckEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFConstraintCheck_Object()
  {
    return (EReference)xmofConstraintCheckEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFStateExpression()
  {
    return xmofStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFStateExpression_Pin()
  {
    return (EReference)xmofStateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFStateExpression_Operator()
  {
    return (EAttribute)xmofStateExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFStateExpression_Value()
  {
    return (EReference)xmofStateExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFObjectStateExpression()
  {
    return xmofObjectStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFPropertyStateExpression()
  {
    return xmofPropertyStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFPropertyStateExpression_Property()
  {
    return (EReference)xmofPropertyStateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFOrderAssertion()
  {
    return xmofOrderAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFOrderAssertion_Order()
  {
    return (EReference)xmofOrderAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFNodeOrder()
  {
    return xmofNodeOrderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFNodeOrder_Nodes()
  {
    return (EReference)xmofNodeOrderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMOFNodeSpecification()
  {
    return xmofNodeSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFNodeSpecification_Node()
  {
    return (EReference)xmofNodeSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFNodeSpecification_Size()
  {
    return (EReference)xmofNodeSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMOFNodeSpecification_SubOrder()
  {
    return (EReference)xmofNodeSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMOFNodeSpecification_Joker()
  {
    return (EAttribute)xmofNodeSpecificationEClass.getEStructuralFeatures().get(3);
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
  public EEnum getXMOFArithmeticOperator()
  {
    return xmofArithmeticOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getXMOFTemporalOperator()
  {
    return xmofTemporalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getXMOFTemporalQuantifier()
  {
    return xmofTemporalQuantifierEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmofTestLangFactory getXmofTestLangFactory()
  {
    return (XmofTestLangFactory)getEFactoryInstance();
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
    xmofTestSuiteEClass = createEClass(XMOF_TEST_SUITE);
    createEReference(xmofTestSuiteEClass, XMOF_TEST_SUITE__IMPORTS);
    createEReference(xmofTestSuiteEClass, XMOF_TEST_SUITE__SCENARIOS);
    createEReference(xmofTestSuiteEClass, XMOF_TEST_SUITE__TESTS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    xmofTestCaseEClass = createEClass(XMOF_TEST_CASE);
    createEAttribute(xmofTestCaseEClass, XMOF_TEST_CASE__NAME);
    createEReference(xmofTestCaseEClass, XMOF_TEST_CASE__ACTIVITY_UNDER_TEST);
    createEReference(xmofTestCaseEClass, XMOF_TEST_CASE__INPUTS);
    createEReference(xmofTestCaseEClass, XMOF_TEST_CASE__CONTEXT_OBJECT);
    createEReference(xmofTestCaseEClass, XMOF_TEST_CASE__INIT_SCENARIOS);
    createEReference(xmofTestCaseEClass, XMOF_TEST_CASE__ASSERTIONS);

    xmofActivityInputEClass = createEClass(XMOF_ACTIVITY_INPUT);
    createEReference(xmofActivityInputEClass, XMOF_ACTIVITY_INPUT__PARAMETER);
    createEReference(xmofActivityInputEClass, XMOF_ACTIVITY_INPUT__VALUE);

    xmofValueEClass = createEClass(XMOF_VALUE);

    xmofSimpleValueEClass = createEClass(XMOF_SIMPLE_VALUE);
    createEReference(xmofSimpleValueEClass, XMOF_SIMPLE_VALUE__VALUE);

    xmofObjectValueEClass = createEClass(XMOF_OBJECT_VALUE);
    createEReference(xmofObjectValueEClass, XMOF_OBJECT_VALUE__VALUE);

    xmofScenarioEClass = createEClass(XMOF_SCENARIO);
    createEAttribute(xmofScenarioEClass, XMOF_SCENARIO__NAME);
    createEReference(xmofScenarioEClass, XMOF_SCENARIO__OBJECTS);
    createEReference(xmofScenarioEClass, XMOF_SCENARIO__LINKS);

    xmofObjectSpecificationEClass = createEClass(XMOF_OBJECT_SPECIFICATION);
    createEAttribute(xmofObjectSpecificationEClass, XMOF_OBJECT_SPECIFICATION__NAME);
    createEReference(xmofObjectSpecificationEClass, XMOF_OBJECT_SPECIFICATION__TYPE);
    createEReference(xmofObjectSpecificationEClass, XMOF_OBJECT_SPECIFICATION__ATTRIBUTES);

    xmofAttributeEClass = createEClass(XMOF_ATTRIBUTE);
    createEReference(xmofAttributeEClass, XMOF_ATTRIBUTE__ATT);
    createEReference(xmofAttributeEClass, XMOF_ATTRIBUTE__VALUE);

    xmofLinkEClass = createEClass(XMOF_LINK);
    createEReference(xmofLinkEClass, XMOF_LINK__ASSOC);
    createEReference(xmofLinkEClass, XMOF_LINK__SOURCE_PROPERTY);
    createEReference(xmofLinkEClass, XMOF_LINK__SOURCE_VALUE);
    createEReference(xmofLinkEClass, XMOF_LINK__TARGET_PROPERTY);
    createEReference(xmofLinkEClass, XMOF_LINK__TARGET_VALUE);

    xmofAssertionEClass = createEClass(XMOF_ASSERTION);

    xmofStateAssertionEClass = createEClass(XMOF_STATE_ASSERTION);
    createEAttribute(xmofStateAssertionEClass, XMOF_STATE_ASSERTION__QUANTIFIER);
    createEAttribute(xmofStateAssertionEClass, XMOF_STATE_ASSERTION__OPERATOR);
    createEReference(xmofStateAssertionEClass, XMOF_STATE_ASSERTION__REFERENCE_POINT);
    createEReference(xmofStateAssertionEClass, XMOF_STATE_ASSERTION__UNTIL_POINT);
    createEReference(xmofStateAssertionEClass, XMOF_STATE_ASSERTION__CHECKS);

    xmofReferencePointEClass = createEClass(XMOF_REFERENCE_POINT);

    xmofActionReferencePointEClass = createEClass(XMOF_ACTION_REFERENCE_POINT);
    createEReference(xmofActionReferencePointEClass, XMOF_ACTION_REFERENCE_POINT__ACTION);

    xmofConstraintReferencePointEClass = createEClass(XMOF_CONSTRAINT_REFERENCE_POINT);
    createEReference(xmofConstraintReferencePointEClass, XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME);

    xmofFinallyStateAssertionEClass = createEClass(XMOF_FINALLY_STATE_ASSERTION);

    xmofCheckEClass = createEClass(XMOF_CHECK);

    xmofConstraintCheckEClass = createEClass(XMOF_CONSTRAINT_CHECK);
    createEReference(xmofConstraintCheckEClass, XMOF_CONSTRAINT_CHECK__CONSTRAINT_NAMES);
    createEReference(xmofConstraintCheckEClass, XMOF_CONSTRAINT_CHECK__OBJECT);

    xmofStateExpressionEClass = createEClass(XMOF_STATE_EXPRESSION);
    createEReference(xmofStateExpressionEClass, XMOF_STATE_EXPRESSION__PIN);
    createEAttribute(xmofStateExpressionEClass, XMOF_STATE_EXPRESSION__OPERATOR);
    createEReference(xmofStateExpressionEClass, XMOF_STATE_EXPRESSION__VALUE);

    xmofObjectStateExpressionEClass = createEClass(XMOF_OBJECT_STATE_EXPRESSION);

    xmofPropertyStateExpressionEClass = createEClass(XMOF_PROPERTY_STATE_EXPRESSION);
    createEReference(xmofPropertyStateExpressionEClass, XMOF_PROPERTY_STATE_EXPRESSION__PROPERTY);

    xmofOrderAssertionEClass = createEClass(XMOF_ORDER_ASSERTION);
    createEReference(xmofOrderAssertionEClass, XMOF_ORDER_ASSERTION__ORDER);

    xmofNodeOrderEClass = createEClass(XMOF_NODE_ORDER);
    createEReference(xmofNodeOrderEClass, XMOF_NODE_ORDER__NODES);

    xmofNodeSpecificationEClass = createEClass(XMOF_NODE_SPECIFICATION);
    createEReference(xmofNodeSpecificationEClass, XMOF_NODE_SPECIFICATION__NODE);
    createEReference(xmofNodeSpecificationEClass, XMOF_NODE_SPECIFICATION__SIZE);
    createEReference(xmofNodeSpecificationEClass, XMOF_NODE_SPECIFICATION__SUB_ORDER);
    createEAttribute(xmofNodeSpecificationEClass, XMOF_NODE_SPECIFICATION__JOKER);

    finallyStateAssertionEClass = createEClass(FINALLY_STATE_ASSERTION);
    createEReference(finallyStateAssertionEClass, FINALLY_STATE_ASSERTION__CHECKS);

    // Create enums
    xmofArithmeticOperatorEEnum = createEEnum(XMOF_ARITHMETIC_OPERATOR);
    xmofTemporalOperatorEEnum = createEEnum(XMOF_TEMPORAL_OPERATOR);
    xmofTemporalQuantifierEEnum = createEEnum(XMOF_TEMPORAL_QUANTIFIER);
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
    IntermediateActivitiesPackage theIntermediateActivitiesPackage = (IntermediateActivitiesPackage)EPackage.Registry.INSTANCE.getEPackage(IntermediateActivitiesPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);
    BasicActionsPackage theBasicActionsPackage = (BasicActionsPackage)EPackage.Registry.INSTANCE.getEPackage(BasicActionsPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    xmofSimpleValueEClass.getESuperTypes().add(this.getXMOFValue());
    xmofObjectValueEClass.getESuperTypes().add(this.getXMOFValue());
    xmofStateAssertionEClass.getESuperTypes().add(this.getXMOFAssertion());
    xmofActionReferencePointEClass.getESuperTypes().add(this.getXMOFReferencePoint());
    xmofConstraintReferencePointEClass.getESuperTypes().add(this.getXMOFReferencePoint());
    xmofFinallyStateAssertionEClass.getESuperTypes().add(this.getXMOFAssertion());
    xmofConstraintCheckEClass.getESuperTypes().add(this.getXMOFCheck());
    xmofStateExpressionEClass.getESuperTypes().add(this.getXMOFCheck());
    xmofObjectStateExpressionEClass.getESuperTypes().add(this.getXMOFStateExpression());
    xmofPropertyStateExpressionEClass.getESuperTypes().add(this.getXMOFStateExpression());
    xmofOrderAssertionEClass.getESuperTypes().add(this.getXMOFAssertion());
    finallyStateAssertionEClass.getESuperTypes().add(this.getXMOFFinallyStateAssertion());

    // Initialize classes and features; add operations and parameters
    initEClass(xmofTestSuiteEClass, XMOFTestSuite.class, "XMOFTestSuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFTestSuite_Imports(), this.getImport(), null, "imports", null, 0, -1, XMOFTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestSuite_Scenarios(), this.getXMOFScenario(), null, "scenarios", null, 0, -1, XMOFTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestSuite_Tests(), this.getXMOFTestCase(), null, "tests", null, 0, -1, XMOFTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofTestCaseEClass, XMOFTestCase.class, "XMOFTestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXMOFTestCase_Name(), ecorePackage.getEString(), "name", null, 0, 1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestCase_ActivityUnderTest(), theIntermediateActivitiesPackage.getActivity(), null, "activityUnderTest", null, 0, 1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestCase_Inputs(), this.getXMOFActivityInput(), null, "inputs", null, 0, -1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestCase_ContextObject(), this.getXMOFObjectSpecification(), null, "contextObject", null, 0, 1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestCase_InitScenarios(), this.getXMOFScenario(), null, "initScenarios", null, 0, -1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFTestCase_Assertions(), this.getXMOFAssertion(), null, "assertions", null, 0, -1, XMOFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofActivityInputEClass, XMOFActivityInput.class, "XMOFActivityInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFActivityInput_Parameter(), theIntermediateActivitiesPackage.getActivityParameterNode(), null, "parameter", null, 0, 1, XMOFActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFActivityInput_Value(), this.getXMOFValue(), null, "value", null, 0, 1, XMOFActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofValueEClass, XMOFValue.class, "XMOFValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofSimpleValueEClass, XMOFSimpleValue.class, "XMOFSimpleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFSimpleValue_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, XMOFSimpleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofObjectValueEClass, XMOFObjectValue.class, "XMOFObjectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFObjectValue_Value(), this.getXMOFObjectSpecification(), null, "value", null, 0, 1, XMOFObjectValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofScenarioEClass, XMOFScenario.class, "XMOFScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXMOFScenario_Name(), ecorePackage.getEString(), "name", null, 0, 1, XMOFScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFScenario_Objects(), this.getXMOFObjectSpecification(), null, "objects", null, 0, -1, XMOFScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFScenario_Links(), this.getXMOFLink(), null, "links", null, 0, -1, XMOFScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofObjectSpecificationEClass, XMOFObjectSpecification.class, "XMOFObjectSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXMOFObjectSpecification_Name(), ecorePackage.getEString(), "name", null, 0, 1, XMOFObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFObjectSpecification_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, XMOFObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFObjectSpecification_Attributes(), this.getXMOFAttribute(), null, "attributes", null, 0, -1, XMOFObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofAttributeEClass, XMOFAttribute.class, "XMOFAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFAttribute_Att(), ecorePackage.getEAttribute(), null, "att", null, 0, 1, XMOFAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFAttribute_Value(), this.getXMOFValue(), null, "value", null, 0, 1, XMOFAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofLinkEClass, XMOFLink.class, "XMOFLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFLink_Assoc(), ecorePackage.getEReference(), null, "assoc", null, 0, 1, XMOFLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFLink_SourceProperty(), ecorePackage.getEAttribute(), null, "sourceProperty", null, 0, 1, XMOFLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFLink_SourceValue(), this.getXMOFObjectSpecification(), null, "sourceValue", null, 0, 1, XMOFLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFLink_TargetProperty(), ecorePackage.getEAttribute(), null, "targetProperty", null, 0, 1, XMOFLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFLink_TargetValue(), this.getXMOFObjectSpecification(), null, "targetValue", null, 0, 1, XMOFLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofAssertionEClass, XMOFAssertion.class, "XMOFAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofStateAssertionEClass, XMOFStateAssertion.class, "XMOFStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXMOFStateAssertion_Quantifier(), this.getXMOFTemporalQuantifier(), "quantifier", null, 0, 1, XMOFStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMOFStateAssertion_Operator(), this.getXMOFTemporalOperator(), "operator", null, 0, 1, XMOFStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFStateAssertion_ReferencePoint(), this.getXMOFReferencePoint(), null, "referencePoint", null, 0, 1, XMOFStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFStateAssertion_UntilPoint(), this.getXMOFReferencePoint(), null, "untilPoint", null, 0, 1, XMOFStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFStateAssertion_Checks(), this.getXMOFCheck(), null, "checks", null, 0, -1, XMOFStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofReferencePointEClass, XMOFReferencePoint.class, "XMOFReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofActionReferencePointEClass, XMOFActionReferencePoint.class, "XMOFActionReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFActionReferencePoint_Action(), theBasicActionsPackage.getAction(), null, "action", null, 0, 1, XMOFActionReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofConstraintReferencePointEClass, XMOFConstraintReferencePoint.class, "XMOFConstraintReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFConstraintReferencePoint_ConstraintName(), theXbasePackage.getXExpression(), null, "constraintName", null, 0, 1, XMOFConstraintReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofFinallyStateAssertionEClass, XMOFFinallyStateAssertion.class, "XMOFFinallyStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofCheckEClass, XMOFCheck.class, "XMOFCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofConstraintCheckEClass, XMOFConstraintCheck.class, "XMOFConstraintCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFConstraintCheck_ConstraintNames(), theXbasePackage.getXExpression(), null, "constraintNames", null, 0, -1, XMOFConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFConstraintCheck_Object(), theIntermediateActivitiesPackage.getObjectNode(), null, "object", null, 0, 1, XMOFConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofStateExpressionEClass, XMOFStateExpression.class, "XMOFStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFStateExpression_Pin(), theIntermediateActivitiesPackage.getObjectNode(), null, "pin", null, 0, 1, XMOFStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMOFStateExpression_Operator(), this.getXMOFArithmeticOperator(), "operator", null, 0, 1, XMOFStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFStateExpression_Value(), this.getXMOFValue(), null, "value", null, 0, 1, XMOFStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofObjectStateExpressionEClass, XMOFObjectStateExpression.class, "XMOFObjectStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(xmofPropertyStateExpressionEClass, XMOFPropertyStateExpression.class, "XMOFPropertyStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFPropertyStateExpression_Property(), ecorePackage.getEAttribute(), null, "property", null, 0, 1, XMOFPropertyStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofOrderAssertionEClass, XMOFOrderAssertion.class, "XMOFOrderAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFOrderAssertion_Order(), this.getXMOFNodeOrder(), null, "order", null, 0, 1, XMOFOrderAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofNodeOrderEClass, XMOFNodeOrder.class, "XMOFNodeOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFNodeOrder_Nodes(), this.getXMOFNodeSpecification(), null, "nodes", null, 0, -1, XMOFNodeOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xmofNodeSpecificationEClass, XMOFNodeSpecification.class, "XMOFNodeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXMOFNodeSpecification_Node(), theIntermediateActivitiesPackage.getActivityNode(), null, "node", null, 0, 1, XMOFNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFNodeSpecification_Size(), theXbasePackage.getXExpression(), null, "size", null, 0, 1, XMOFNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMOFNodeSpecification_SubOrder(), this.getXMOFNodeOrder(), null, "subOrder", null, 0, 1, XMOFNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMOFNodeSpecification_Joker(), ecorePackage.getEString(), "joker", null, 0, 1, XMOFNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(finallyStateAssertionEClass, FinallyStateAssertion.class, "FinallyStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFinallyStateAssertion_Checks(), this.getXMOFCheck(), null, "checks", null, 0, -1, FinallyStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.class, "XMOFArithmeticOperator");
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.EQUAL);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.NOT_EQUAL);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.GREATER);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.SMALLER);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.GREATER_EQUAL);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.SMALLER_EQUAL);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.INCLUDES);
    addEEnumLiteral(xmofArithmeticOperatorEEnum, XMOFArithmeticOperator.EXCLUDES);

    initEEnum(xmofTemporalOperatorEEnum, XMOFTemporalOperator.class, "XMOFTemporalOperator");
    addEEnumLiteral(xmofTemporalOperatorEEnum, XMOFTemporalOperator.AFTER);
    addEEnumLiteral(xmofTemporalOperatorEEnum, XMOFTemporalOperator.UNTIL);

    initEEnum(xmofTemporalQuantifierEEnum, XMOFTemporalQuantifier.class, "XMOFTemporalQuantifier");
    addEEnumLiteral(xmofTemporalQuantifierEEnum, XMOFTemporalQuantifier.ALWAYS);
    addEEnumLiteral(xmofTemporalQuantifierEEnum, XMOFTemporalQuantifier.SOMETIMES);
    addEEnumLiteral(xmofTemporalQuantifierEEnum, XMOFTemporalQuantifier.EVENTUALLY);
    addEEnumLiteral(xmofTemporalQuantifierEEnum, XMOFTemporalQuantifier.IMMEDIATELY);

    // Create resource
    createResource(eNS_URI);
  }

} //XmofTestLangPackageImpl
