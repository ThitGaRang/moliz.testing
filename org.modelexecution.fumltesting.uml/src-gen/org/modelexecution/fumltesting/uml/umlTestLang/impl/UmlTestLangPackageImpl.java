/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.Import;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLLink;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangFactory;
import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlTestLangPackageImpl extends EPackageImpl implements UmlTestLangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTestSuiteEClass = null;

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
  private EClass umlTestCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlActivityInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlSimpleValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlObjectValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlScenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlObjectSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlStateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlActionReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlConstraintReferencePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlFinallyStateAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlCheckEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlConstraintCheckEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlObjectStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlPropertyStateExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlOrderAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlNodeOrderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlNodeSpecificationEClass = null;

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
  private EEnum umlArithmeticOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum umlTemporalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum umlTemporalQuantifierEEnum = null;

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
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UmlTestLangPackageImpl()
  {
    super(eNS_URI, UmlTestLangFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link UmlTestLangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UmlTestLangPackage init()
  {
    if (isInited) return (UmlTestLangPackage)EPackage.Registry.INSTANCE.getEPackage(UmlTestLangPackage.eNS_URI);

    // Obtain or create and register package
    UmlTestLangPackageImpl theUmlTestLangPackage = (UmlTestLangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlTestLangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlTestLangPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    UMLPackage.eINSTANCE.eClass();
    XbasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theUmlTestLangPackage.createPackageContents();

    // Initialize created meta-data
    theUmlTestLangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUmlTestLangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UmlTestLangPackage.eNS_URI, theUmlTestLangPackage);
    return theUmlTestLangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLTestSuite()
  {
    return umlTestSuiteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestSuite_Imports()
  {
    return (EReference)umlTestSuiteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestSuite_Scenarios()
  {
    return (EReference)umlTestSuiteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestSuite_Tests()
  {
    return (EReference)umlTestSuiteEClass.getEStructuralFeatures().get(2);
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
  public EClass getUMLTestCase()
  {
    return umlTestCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLTestCase_Name()
  {
    return (EAttribute)umlTestCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestCase_ActivityUnderTest()
  {
    return (EReference)umlTestCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestCase_Inputs()
  {
    return (EReference)umlTestCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestCase_ContextObject()
  {
    return (EReference)umlTestCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestCase_InitScenarios()
  {
    return (EReference)umlTestCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTestCase_Assertions()
  {
    return (EReference)umlTestCaseEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLActivityInput()
  {
    return umlActivityInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLActivityInput_Parameter()
  {
    return (EReference)umlActivityInputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLActivityInput_Value()
  {
    return (EReference)umlActivityInputEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLValue()
  {
    return umlValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLSimpleValue()
  {
    return umlSimpleValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLSimpleValue_Value()
  {
    return (EReference)umlSimpleValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLObjectValue()
  {
    return umlObjectValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLObjectValue_Value()
  {
    return (EReference)umlObjectValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLScenario()
  {
    return umlScenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLScenario_Name()
  {
    return (EAttribute)umlScenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLScenario_Objects()
  {
    return (EReference)umlScenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLScenario_Links()
  {
    return (EReference)umlScenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLObjectSpecification()
  {
    return umlObjectSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLObjectSpecification_Name()
  {
    return (EAttribute)umlObjectSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLObjectSpecification_Type()
  {
    return (EReference)umlObjectSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLObjectSpecification_Attributes()
  {
    return (EReference)umlObjectSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAttribute()
  {
    return umlAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAttribute_Att()
  {
    return (EReference)umlAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAttribute_Value()
  {
    return (EReference)umlAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLLink()
  {
    return umlLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLink_Assoc()
  {
    return (EReference)umlLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLink_SourceProperty()
  {
    return (EReference)umlLinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLink_SourceValue()
  {
    return (EReference)umlLinkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLink_TargetProperty()
  {
    return (EReference)umlLinkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLink_TargetValue()
  {
    return (EReference)umlLinkEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAssertion()
  {
    return umlAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLStateAssertion()
  {
    return umlStateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLStateAssertion_Quantifier()
  {
    return (EAttribute)umlStateAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLStateAssertion_Operator()
  {
    return (EAttribute)umlStateAssertionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStateAssertion_ReferencePoint()
  {
    return (EReference)umlStateAssertionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStateAssertion_UntilPoint()
  {
    return (EReference)umlStateAssertionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStateAssertion_Checks()
  {
    return (EReference)umlStateAssertionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLReferencePoint()
  {
    return umlReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLActionReferencePoint()
  {
    return umlActionReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLActionReferencePoint_Action()
  {
    return (EReference)umlActionReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLConstraintReferencePoint()
  {
    return umlConstraintReferencePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLConstraintReferencePoint_ConstraintName()
  {
    return (EReference)umlConstraintReferencePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLFinallyStateAssertion()
  {
    return umlFinallyStateAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLCheck()
  {
    return umlCheckEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLConstraintCheck()
  {
    return umlConstraintCheckEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLConstraintCheck_ConstraintNames()
  {
    return (EReference)umlConstraintCheckEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLConstraintCheck_Object()
  {
    return (EReference)umlConstraintCheckEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLStateExpression()
  {
    return umlStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStateExpression_Pin()
  {
    return (EReference)umlStateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLStateExpression_Operator()
  {
    return (EAttribute)umlStateExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStateExpression_Value()
  {
    return (EReference)umlStateExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLObjectStateExpression()
  {
    return umlObjectStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLPropertyStateExpression()
  {
    return umlPropertyStateExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPropertyStateExpression_Property()
  {
    return (EReference)umlPropertyStateExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLOrderAssertion()
  {
    return umlOrderAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLOrderAssertion_Order()
  {
    return (EReference)umlOrderAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLNodeOrder()
  {
    return umlNodeOrderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNodeOrder_Nodes()
  {
    return (EReference)umlNodeOrderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLNodeSpecification()
  {
    return umlNodeSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNodeSpecification_Node()
  {
    return (EReference)umlNodeSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNodeSpecification_Size()
  {
    return (EReference)umlNodeSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNodeSpecification_SubOrder()
  {
    return (EReference)umlNodeSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLNodeSpecification_Joker()
  {
    return (EAttribute)umlNodeSpecificationEClass.getEStructuralFeatures().get(3);
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
  public EEnum getUMLArithmeticOperator()
  {
    return umlArithmeticOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUMLTemporalOperator()
  {
    return umlTemporalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUMLTemporalQuantifier()
  {
    return umlTemporalQuantifierEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlTestLangFactory getUmlTestLangFactory()
  {
    return (UmlTestLangFactory)getEFactoryInstance();
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
    umlTestSuiteEClass = createEClass(UML_TEST_SUITE);
    createEReference(umlTestSuiteEClass, UML_TEST_SUITE__IMPORTS);
    createEReference(umlTestSuiteEClass, UML_TEST_SUITE__SCENARIOS);
    createEReference(umlTestSuiteEClass, UML_TEST_SUITE__TESTS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    umlTestCaseEClass = createEClass(UML_TEST_CASE);
    createEAttribute(umlTestCaseEClass, UML_TEST_CASE__NAME);
    createEReference(umlTestCaseEClass, UML_TEST_CASE__ACTIVITY_UNDER_TEST);
    createEReference(umlTestCaseEClass, UML_TEST_CASE__INPUTS);
    createEReference(umlTestCaseEClass, UML_TEST_CASE__CONTEXT_OBJECT);
    createEReference(umlTestCaseEClass, UML_TEST_CASE__INIT_SCENARIOS);
    createEReference(umlTestCaseEClass, UML_TEST_CASE__ASSERTIONS);

    umlActivityInputEClass = createEClass(UML_ACTIVITY_INPUT);
    createEReference(umlActivityInputEClass, UML_ACTIVITY_INPUT__PARAMETER);
    createEReference(umlActivityInputEClass, UML_ACTIVITY_INPUT__VALUE);

    umlValueEClass = createEClass(UML_VALUE);

    umlSimpleValueEClass = createEClass(UML_SIMPLE_VALUE);
    createEReference(umlSimpleValueEClass, UML_SIMPLE_VALUE__VALUE);

    umlObjectValueEClass = createEClass(UML_OBJECT_VALUE);
    createEReference(umlObjectValueEClass, UML_OBJECT_VALUE__VALUE);

    umlScenarioEClass = createEClass(UML_SCENARIO);
    createEAttribute(umlScenarioEClass, UML_SCENARIO__NAME);
    createEReference(umlScenarioEClass, UML_SCENARIO__OBJECTS);
    createEReference(umlScenarioEClass, UML_SCENARIO__LINKS);

    umlObjectSpecificationEClass = createEClass(UML_OBJECT_SPECIFICATION);
    createEAttribute(umlObjectSpecificationEClass, UML_OBJECT_SPECIFICATION__NAME);
    createEReference(umlObjectSpecificationEClass, UML_OBJECT_SPECIFICATION__TYPE);
    createEReference(umlObjectSpecificationEClass, UML_OBJECT_SPECIFICATION__ATTRIBUTES);

    umlAttributeEClass = createEClass(UML_ATTRIBUTE);
    createEReference(umlAttributeEClass, UML_ATTRIBUTE__ATT);
    createEReference(umlAttributeEClass, UML_ATTRIBUTE__VALUE);

    umlLinkEClass = createEClass(UML_LINK);
    createEReference(umlLinkEClass, UML_LINK__ASSOC);
    createEReference(umlLinkEClass, UML_LINK__SOURCE_PROPERTY);
    createEReference(umlLinkEClass, UML_LINK__SOURCE_VALUE);
    createEReference(umlLinkEClass, UML_LINK__TARGET_PROPERTY);
    createEReference(umlLinkEClass, UML_LINK__TARGET_VALUE);

    umlAssertionEClass = createEClass(UML_ASSERTION);

    umlStateAssertionEClass = createEClass(UML_STATE_ASSERTION);
    createEAttribute(umlStateAssertionEClass, UML_STATE_ASSERTION__QUANTIFIER);
    createEAttribute(umlStateAssertionEClass, UML_STATE_ASSERTION__OPERATOR);
    createEReference(umlStateAssertionEClass, UML_STATE_ASSERTION__REFERENCE_POINT);
    createEReference(umlStateAssertionEClass, UML_STATE_ASSERTION__UNTIL_POINT);
    createEReference(umlStateAssertionEClass, UML_STATE_ASSERTION__CHECKS);

    umlReferencePointEClass = createEClass(UML_REFERENCE_POINT);

    umlActionReferencePointEClass = createEClass(UML_ACTION_REFERENCE_POINT);
    createEReference(umlActionReferencePointEClass, UML_ACTION_REFERENCE_POINT__ACTION);

    umlConstraintReferencePointEClass = createEClass(UML_CONSTRAINT_REFERENCE_POINT);
    createEReference(umlConstraintReferencePointEClass, UML_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME);

    umlFinallyStateAssertionEClass = createEClass(UML_FINALLY_STATE_ASSERTION);

    umlCheckEClass = createEClass(UML_CHECK);

    umlConstraintCheckEClass = createEClass(UML_CONSTRAINT_CHECK);
    createEReference(umlConstraintCheckEClass, UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES);
    createEReference(umlConstraintCheckEClass, UML_CONSTRAINT_CHECK__OBJECT);

    umlStateExpressionEClass = createEClass(UML_STATE_EXPRESSION);
    createEReference(umlStateExpressionEClass, UML_STATE_EXPRESSION__PIN);
    createEAttribute(umlStateExpressionEClass, UML_STATE_EXPRESSION__OPERATOR);
    createEReference(umlStateExpressionEClass, UML_STATE_EXPRESSION__VALUE);

    umlObjectStateExpressionEClass = createEClass(UML_OBJECT_STATE_EXPRESSION);

    umlPropertyStateExpressionEClass = createEClass(UML_PROPERTY_STATE_EXPRESSION);
    createEReference(umlPropertyStateExpressionEClass, UML_PROPERTY_STATE_EXPRESSION__PROPERTY);

    umlOrderAssertionEClass = createEClass(UML_ORDER_ASSERTION);
    createEReference(umlOrderAssertionEClass, UML_ORDER_ASSERTION__ORDER);

    umlNodeOrderEClass = createEClass(UML_NODE_ORDER);
    createEReference(umlNodeOrderEClass, UML_NODE_ORDER__NODES);

    umlNodeSpecificationEClass = createEClass(UML_NODE_SPECIFICATION);
    createEReference(umlNodeSpecificationEClass, UML_NODE_SPECIFICATION__NODE);
    createEReference(umlNodeSpecificationEClass, UML_NODE_SPECIFICATION__SIZE);
    createEReference(umlNodeSpecificationEClass, UML_NODE_SPECIFICATION__SUB_ORDER);
    createEAttribute(umlNodeSpecificationEClass, UML_NODE_SPECIFICATION__JOKER);

    finallyStateAssertionEClass = createEClass(FINALLY_STATE_ASSERTION);
    createEReference(finallyStateAssertionEClass, FINALLY_STATE_ASSERTION__CHECKS);

    // Create enums
    umlArithmeticOperatorEEnum = createEEnum(UML_ARITHMETIC_OPERATOR);
    umlTemporalOperatorEEnum = createEEnum(UML_TEMPORAL_OPERATOR);
    umlTemporalQuantifierEEnum = createEEnum(UML_TEMPORAL_QUANTIFIER);
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
    umlSimpleValueEClass.getESuperTypes().add(this.getUMLValue());
    umlObjectValueEClass.getESuperTypes().add(this.getUMLValue());
    umlStateAssertionEClass.getESuperTypes().add(this.getUMLAssertion());
    umlActionReferencePointEClass.getESuperTypes().add(this.getUMLReferencePoint());
    umlConstraintReferencePointEClass.getESuperTypes().add(this.getUMLReferencePoint());
    umlFinallyStateAssertionEClass.getESuperTypes().add(this.getUMLAssertion());
    umlConstraintCheckEClass.getESuperTypes().add(this.getUMLCheck());
    umlStateExpressionEClass.getESuperTypes().add(this.getUMLCheck());
    umlObjectStateExpressionEClass.getESuperTypes().add(this.getUMLStateExpression());
    umlPropertyStateExpressionEClass.getESuperTypes().add(this.getUMLStateExpression());
    umlOrderAssertionEClass.getESuperTypes().add(this.getUMLAssertion());
    finallyStateAssertionEClass.getESuperTypes().add(this.getUMLFinallyStateAssertion());

    // Initialize classes and features; add operations and parameters
    initEClass(umlTestSuiteEClass, UMLTestSuite.class, "UMLTestSuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLTestSuite_Imports(), this.getImport(), null, "imports", null, 0, -1, UMLTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestSuite_Scenarios(), this.getUMLScenario(), null, "scenarios", null, 0, -1, UMLTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestSuite_Tests(), this.getUMLTestCase(), null, "tests", null, 0, -1, UMLTestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), theEcorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlTestCaseEClass, UMLTestCase.class, "UMLTestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLTestCase_Name(), theEcorePackage.getEString(), "name", null, 0, 1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestCase_ActivityUnderTest(), theUMLPackage.getActivity(), null, "activityUnderTest", null, 0, 1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestCase_Inputs(), this.getUMLActivityInput(), null, "inputs", null, 0, -1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestCase_ContextObject(), this.getUMLObjectSpecification(), null, "contextObject", null, 0, 1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestCase_InitScenarios(), this.getUMLScenario(), null, "initScenarios", null, 0, -1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLTestCase_Assertions(), this.getUMLAssertion(), null, "assertions", null, 0, -1, UMLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlActivityInputEClass, UMLActivityInput.class, "UMLActivityInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLActivityInput_Parameter(), theUMLPackage.getActivityParameterNode(), null, "parameter", null, 0, 1, UMLActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLActivityInput_Value(), this.getUMLValue(), null, "value", null, 0, 1, UMLActivityInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlValueEClass, UMLValue.class, "UMLValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlSimpleValueEClass, UMLSimpleValue.class, "UMLSimpleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLSimpleValue_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, UMLSimpleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlObjectValueEClass, UMLObjectValue.class, "UMLObjectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLObjectValue_Value(), this.getUMLObjectSpecification(), null, "value", null, 0, 1, UMLObjectValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlScenarioEClass, UMLScenario.class, "UMLScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLScenario_Name(), theEcorePackage.getEString(), "name", null, 0, 1, UMLScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLScenario_Objects(), this.getUMLObjectSpecification(), null, "objects", null, 0, -1, UMLScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLScenario_Links(), this.getUMLLink(), null, "links", null, 0, -1, UMLScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlObjectSpecificationEClass, UMLObjectSpecification.class, "UMLObjectSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLObjectSpecification_Name(), theEcorePackage.getEString(), "name", null, 0, 1, UMLObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLObjectSpecification_Type(), theUMLPackage.getClass_(), null, "type", null, 0, 1, UMLObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLObjectSpecification_Attributes(), this.getUMLAttribute(), null, "attributes", null, 0, -1, UMLObjectSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlAttributeEClass, UMLAttribute.class, "UMLAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLAttribute_Att(), theUMLPackage.getProperty(), null, "att", null, 0, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLAttribute_Value(), this.getUMLValue(), null, "value", null, 0, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlLinkEClass, UMLLink.class, "UMLLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLLink_Assoc(), theUMLPackage.getAssociation(), null, "assoc", null, 0, 1, UMLLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLLink_SourceProperty(), theUMLPackage.getProperty(), null, "sourceProperty", null, 0, 1, UMLLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLLink_SourceValue(), this.getUMLObjectSpecification(), null, "sourceValue", null, 0, 1, UMLLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLLink_TargetProperty(), theUMLPackage.getProperty(), null, "targetProperty", null, 0, 1, UMLLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLLink_TargetValue(), this.getUMLObjectSpecification(), null, "targetValue", null, 0, 1, UMLLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlAssertionEClass, UMLAssertion.class, "UMLAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlStateAssertionEClass, UMLStateAssertion.class, "UMLStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLStateAssertion_Quantifier(), this.getUMLTemporalQuantifier(), "quantifier", null, 0, 1, UMLStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUMLStateAssertion_Operator(), this.getUMLTemporalOperator(), "operator", null, 0, 1, UMLStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLStateAssertion_ReferencePoint(), this.getUMLReferencePoint(), null, "referencePoint", null, 0, 1, UMLStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLStateAssertion_UntilPoint(), this.getUMLReferencePoint(), null, "untilPoint", null, 0, 1, UMLStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLStateAssertion_Checks(), this.getUMLCheck(), null, "checks", null, 0, -1, UMLStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlReferencePointEClass, UMLReferencePoint.class, "UMLReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlActionReferencePointEClass, UMLActionReferencePoint.class, "UMLActionReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLActionReferencePoint_Action(), theUMLPackage.getAction(), null, "action", null, 0, 1, UMLActionReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlConstraintReferencePointEClass, UMLConstraintReferencePoint.class, "UMLConstraintReferencePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLConstraintReferencePoint_ConstraintName(), theXbasePackage.getXExpression(), null, "constraintName", null, 0, 1, UMLConstraintReferencePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlFinallyStateAssertionEClass, UMLFinallyStateAssertion.class, "UMLFinallyStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlCheckEClass, UMLCheck.class, "UMLCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlConstraintCheckEClass, UMLConstraintCheck.class, "UMLConstraintCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLConstraintCheck_ConstraintNames(), theXbasePackage.getXExpression(), null, "constraintNames", null, 0, -1, UMLConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLConstraintCheck_Object(), theUMLPackage.getObjectNode(), null, "object", null, 0, 1, UMLConstraintCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlStateExpressionEClass, UMLStateExpression.class, "UMLStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLStateExpression_Pin(), theUMLPackage.getObjectNode(), null, "pin", null, 0, 1, UMLStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUMLStateExpression_Operator(), this.getUMLArithmeticOperator(), "operator", null, 0, 1, UMLStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLStateExpression_Value(), this.getUMLValue(), null, "value", null, 0, 1, UMLStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlObjectStateExpressionEClass, UMLObjectStateExpression.class, "UMLObjectStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlPropertyStateExpressionEClass, UMLPropertyStateExpression.class, "UMLPropertyStateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLPropertyStateExpression_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, UMLPropertyStateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlOrderAssertionEClass, UMLOrderAssertion.class, "UMLOrderAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLOrderAssertion_Order(), this.getUMLNodeOrder(), null, "order", null, 0, 1, UMLOrderAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlNodeOrderEClass, UMLNodeOrder.class, "UMLNodeOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLNodeOrder_Nodes(), this.getUMLNodeSpecification(), null, "nodes", null, 0, -1, UMLNodeOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlNodeSpecificationEClass, UMLNodeSpecification.class, "UMLNodeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLNodeSpecification_Node(), theUMLPackage.getActivityNode(), null, "node", null, 0, 1, UMLNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLNodeSpecification_Size(), theXbasePackage.getXExpression(), null, "size", null, 0, 1, UMLNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUMLNodeSpecification_SubOrder(), this.getUMLNodeOrder(), null, "subOrder", null, 0, 1, UMLNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUMLNodeSpecification_Joker(), theEcorePackage.getEString(), "joker", null, 0, 1, UMLNodeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(finallyStateAssertionEClass, FinallyStateAssertion.class, "FinallyStateAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFinallyStateAssertion_Checks(), this.getUMLCheck(), null, "checks", null, 0, -1, FinallyStateAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(umlArithmeticOperatorEEnum, UMLArithmeticOperator.class, "UMLArithmeticOperator");
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.EQUAL);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.NOT_EQUAL);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.GREATER);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.SMALLER);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.GREATER_EQUAL);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.SMALLER_EQUAL);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.INCLUDES);
    addEEnumLiteral(umlArithmeticOperatorEEnum, UMLArithmeticOperator.EXCLUDES);

    initEEnum(umlTemporalOperatorEEnum, UMLTemporalOperator.class, "UMLTemporalOperator");
    addEEnumLiteral(umlTemporalOperatorEEnum, UMLTemporalOperator.AFTER);
    addEEnumLiteral(umlTemporalOperatorEEnum, UMLTemporalOperator.UNTIL);

    initEEnum(umlTemporalQuantifierEEnum, UMLTemporalQuantifier.class, "UMLTemporalQuantifier");
    addEEnumLiteral(umlTemporalQuantifierEEnum, UMLTemporalQuantifier.ALWAYS);
    addEEnumLiteral(umlTemporalQuantifierEEnum, UMLTemporalQuantifier.SOMETIMES);
    addEEnumLiteral(umlTemporalQuantifierEEnum, UMLTemporalQuantifier.EVENTUALLY);
    addEEnumLiteral(umlTemporalQuantifierEEnum, UMLTemporalQuantifier.IMMEDIATELY);

    // Create resource
    createResource(eNS_URI);
  }

} //UmlTestLangPackageImpl
