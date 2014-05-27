/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangFactory
 * @model kind="package"
 * @generated
 */
public interface XmofTestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xmofTestLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.modelexecution.org/fumltesting/xmof/XmofTestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xmofTestLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XmofTestLangPackage eINSTANCE = org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestSuiteImpl <em>XMOF Test Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestSuiteImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTestSuite()
   * @generated
   */
  int XMOF_TEST_SUITE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_SUITE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_SUITE__SCENARIOS = 1;

  /**
   * The feature id for the '<em><b>Tests</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_SUITE__TESTS = 2;

  /**
   * The number of structural features of the '<em>XMOF Test Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_SUITE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.ImportImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl <em>XMOF Test Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTestCase()
   * @generated
   */
  int XMOF_TEST_CASE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__NAME = 0;

  /**
   * The feature id for the '<em><b>Activity Under Test</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__ACTIVITY_UNDER_TEST = 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__INPUTS = 2;

  /**
   * The feature id for the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__CONTEXT_OBJECT = 3;

  /**
   * The feature id for the '<em><b>Init Scenarios</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__INIT_SCENARIOS = 4;

  /**
   * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE__ASSERTIONS = 5;

  /**
   * The number of structural features of the '<em>XMOF Test Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_TEST_CASE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl <em>XMOF Activity Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFActivityInput()
   * @generated
   */
  int XMOF_ACTIVITY_INPUT = 3;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ACTIVITY_INPUT__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ACTIVITY_INPUT__VALUE = 1;

  /**
   * The number of structural features of the '<em>XMOF Activity Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ACTIVITY_INPUT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFValueImpl <em>XMOF Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFValueImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFValue()
   * @generated
   */
  int XMOF_VALUE = 4;

  /**
   * The number of structural features of the '<em>XMOF Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFSimpleValueImpl <em>XMOF Simple Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFSimpleValueImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFSimpleValue()
   * @generated
   */
  int XMOF_SIMPLE_VALUE = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SIMPLE_VALUE__VALUE = XMOF_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Simple Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SIMPLE_VALUE_FEATURE_COUNT = XMOF_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectValueImpl <em>XMOF Object Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectValueImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectValue()
   * @generated
   */
  int XMOF_OBJECT_VALUE = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_VALUE__VALUE = XMOF_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Object Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_VALUE_FEATURE_COUNT = XMOF_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl <em>XMOF Scenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFScenario()
   * @generated
   */
  int XMOF_SCENARIO = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SCENARIO__NAME = 0;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SCENARIO__OBJECTS = 1;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SCENARIO__LINKS = 2;

  /**
   * The number of structural features of the '<em>XMOF Scenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_SCENARIO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectSpecificationImpl <em>XMOF Object Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectSpecificationImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectSpecification()
   * @generated
   */
  int XMOF_OBJECT_SPECIFICATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_SPECIFICATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_SPECIFICATION__ATTRIBUTES = 2;

  /**
   * The number of structural features of the '<em>XMOF Object Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAttributeImpl <em>XMOF Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAttributeImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFAttribute()
   * @generated
   */
  int XMOF_ATTRIBUTE = 9;

  /**
   * The feature id for the '<em><b>Att</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ATTRIBUTE__ATT = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>XMOF Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl <em>XMOF Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFLink()
   * @generated
   */
  int XMOF_LINK = 10;

  /**
   * The feature id for the '<em><b>Assoc</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK__ASSOC = 0;

  /**
   * The feature id for the '<em><b>Source Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK__SOURCE_PROPERTY = 1;

  /**
   * The feature id for the '<em><b>Source Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK__SOURCE_VALUE = 2;

  /**
   * The feature id for the '<em><b>Target Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK__TARGET_PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Target Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK__TARGET_VALUE = 4;

  /**
   * The number of structural features of the '<em>XMOF Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_LINK_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAssertionImpl <em>XMOF Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAssertionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFAssertion()
   * @generated
   */
  int XMOF_ASSERTION = 11;

  /**
   * The number of structural features of the '<em>XMOF Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ASSERTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl <em>XMOF State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFStateAssertion()
   * @generated
   */
  int XMOF_STATE_ASSERTION = 12;

  /**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION__QUANTIFIER = XMOF_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION__OPERATOR = XMOF_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reference Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION__REFERENCE_POINT = XMOF_ASSERTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Until Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION__UNTIL_POINT = XMOF_ASSERTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Checks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION__CHECKS = XMOF_ASSERTION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>XMOF State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_ASSERTION_FEATURE_COUNT = XMOF_ASSERTION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFReferencePointImpl <em>XMOF Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFReferencePointImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFReferencePoint()
   * @generated
   */
  int XMOF_REFERENCE_POINT = 13;

  /**
   * The number of structural features of the '<em>XMOF Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_REFERENCE_POINT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActionReferencePointImpl <em>XMOF Action Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActionReferencePointImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFActionReferencePoint()
   * @generated
   */
  int XMOF_ACTION_REFERENCE_POINT = 14;

  /**
   * The feature id for the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ACTION_REFERENCE_POINT__ACTION = XMOF_REFERENCE_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Action Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ACTION_REFERENCE_POINT_FEATURE_COUNT = XMOF_REFERENCE_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintReferencePointImpl <em>XMOF Constraint Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintReferencePointImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFConstraintReferencePoint()
   * @generated
   */
  int XMOF_CONSTRAINT_REFERENCE_POINT = 15;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME = XMOF_REFERENCE_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Constraint Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CONSTRAINT_REFERENCE_POINT_FEATURE_COUNT = XMOF_REFERENCE_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFFinallyStateAssertionImpl <em>XMOF Finally State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFFinallyStateAssertionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFFinallyStateAssertion()
   * @generated
   */
  int XMOF_FINALLY_STATE_ASSERTION = 16;

  /**
   * The number of structural features of the '<em>XMOF Finally State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_FINALLY_STATE_ASSERTION_FEATURE_COUNT = XMOF_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFCheckImpl <em>XMOF Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFCheckImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFCheck()
   * @generated
   */
  int XMOF_CHECK = 17;

  /**
   * The number of structural features of the '<em>XMOF Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CHECK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintCheckImpl <em>XMOF Constraint Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintCheckImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFConstraintCheck()
   * @generated
   */
  int XMOF_CONSTRAINT_CHECK = 18;

  /**
   * The feature id for the '<em><b>Constraint Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CONSTRAINT_CHECK__CONSTRAINT_NAMES = XMOF_CHECK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CONSTRAINT_CHECK__OBJECT = XMOF_CHECK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XMOF Constraint Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_CONSTRAINT_CHECK_FEATURE_COUNT = XMOF_CHECK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateExpressionImpl <em>XMOF State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateExpressionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFStateExpression()
   * @generated
   */
  int XMOF_STATE_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_EXPRESSION__PIN = XMOF_CHECK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_EXPRESSION__OPERATOR = XMOF_CHECK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_EXPRESSION__VALUE = XMOF_CHECK_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>XMOF State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_STATE_EXPRESSION_FEATURE_COUNT = XMOF_CHECK_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectStateExpressionImpl <em>XMOF Object State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectStateExpressionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectStateExpression()
   * @generated
   */
  int XMOF_OBJECT_STATE_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_STATE_EXPRESSION__PIN = XMOF_STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_STATE_EXPRESSION__OPERATOR = XMOF_STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_STATE_EXPRESSION__VALUE = XMOF_STATE_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>XMOF Object State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_OBJECT_STATE_EXPRESSION_FEATURE_COUNT = XMOF_STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFPropertyStateExpressionImpl <em>XMOF Property State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFPropertyStateExpressionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFPropertyStateExpression()
   * @generated
   */
  int XMOF_PROPERTY_STATE_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_PROPERTY_STATE_EXPRESSION__PIN = XMOF_STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_PROPERTY_STATE_EXPRESSION__OPERATOR = XMOF_STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_PROPERTY_STATE_EXPRESSION__VALUE = XMOF_STATE_EXPRESSION__VALUE;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_PROPERTY_STATE_EXPRESSION__PROPERTY = XMOF_STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Property State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_PROPERTY_STATE_EXPRESSION_FEATURE_COUNT = XMOF_STATE_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFOrderAssertionImpl <em>XMOF Order Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFOrderAssertionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFOrderAssertion()
   * @generated
   */
  int XMOF_ORDER_ASSERTION = 22;

  /**
   * The feature id for the '<em><b>Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ORDER_ASSERTION__ORDER = XMOF_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XMOF Order Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_ORDER_ASSERTION_FEATURE_COUNT = XMOF_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeOrderImpl <em>XMOF Node Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeOrderImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFNodeOrder()
   * @generated
   */
  int XMOF_NODE_ORDER = 23;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_ORDER__NODES = 0;

  /**
   * The number of structural features of the '<em>XMOF Node Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_ORDER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeSpecificationImpl <em>XMOF Node Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeSpecificationImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFNodeSpecification()
   * @generated
   */
  int XMOF_NODE_SPECIFICATION = 24;

  /**
   * The feature id for the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_SPECIFICATION__NODE = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_SPECIFICATION__SIZE = 1;

  /**
   * The feature id for the '<em><b>Sub Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_SPECIFICATION__SUB_ORDER = 2;

  /**
   * The feature id for the '<em><b>Joker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_SPECIFICATION__JOKER = 3;

  /**
   * The number of structural features of the '<em>XMOF Node Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XMOF_NODE_SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.FinallyStateAssertionImpl <em>Finally State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.FinallyStateAssertionImpl
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getFinallyStateAssertion()
   * @generated
   */
  int FINALLY_STATE_ASSERTION = 25;

  /**
   * The feature id for the '<em><b>Checks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINALLY_STATE_ASSERTION__CHECKS = XMOF_FINALLY_STATE_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Finally State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINALLY_STATE_ASSERTION_FEATURE_COUNT = XMOF_FINALLY_STATE_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator <em>XMOF Arithmetic Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFArithmeticOperator()
   * @generated
   */
  int XMOF_ARITHMETIC_OPERATOR = 26;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator <em>XMOF Temporal Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTemporalOperator()
   * @generated
   */
  int XMOF_TEMPORAL_OPERATOR = 27;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier <em>XMOF Temporal Quantifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTemporalQuantifier()
   * @generated
   */
  int XMOF_TEMPORAL_QUANTIFIER = 28;


  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite <em>XMOF Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Test Suite</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite
   * @generated
   */
  EClass getXMOFTestSuite();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getImports()
   * @see #getXMOFTestSuite()
   * @generated
   */
  EReference getXMOFTestSuite_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getScenarios <em>Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenarios</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getScenarios()
   * @see #getXMOFTestSuite()
   * @generated
   */
  EReference getXMOFTestSuite_Scenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getTests <em>Tests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tests</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestSuite#getTests()
   * @see #getXMOFTestSuite()
   * @generated
   */
  EReference getXMOFTestSuite_Tests();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase <em>XMOF Test Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Test Case</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase
   * @generated
   */
  EClass getXMOFTestCase();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getName()
   * @see #getXMOFTestCase()
   * @generated
   */
  EAttribute getXMOFTestCase_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getActivityUnderTest <em>Activity Under Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Activity Under Test</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getActivityUnderTest()
   * @see #getXMOFTestCase()
   * @generated
   */
  EReference getXMOFTestCase_ActivityUnderTest();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInputs()
   * @see #getXMOFTestCase()
   * @generated
   */
  EReference getXMOFTestCase_Inputs();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getContextObject <em>Context Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context Object</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getContextObject()
   * @see #getXMOFTestCase()
   * @generated
   */
  EReference getXMOFTestCase_ContextObject();

  /**
   * Returns the meta object for the reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInitScenarios <em>Init Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Init Scenarios</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getInitScenarios()
   * @see #getXMOFTestCase()
   * @generated
   */
  EReference getXMOFTestCase_InitScenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getAssertions <em>Assertions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assertions</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTestCase#getAssertions()
   * @see #getXMOFTestCase()
   * @generated
   */
  EReference getXMOFTestCase_Assertions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput <em>XMOF Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Activity Input</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput
   * @generated
   */
  EClass getXMOFActivityInput();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput#getParameter()
   * @see #getXMOFActivityInput()
   * @generated
   */
  EReference getXMOFActivityInput_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActivityInput#getValue()
   * @see #getXMOFActivityInput()
   * @generated
   */
  EReference getXMOFActivityInput_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue <em>XMOF Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFValue
   * @generated
   */
  EClass getXMOFValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue <em>XMOF Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Simple Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue
   * @generated
   */
  EClass getXMOFSimpleValue();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFSimpleValue#getValue()
   * @see #getXMOFSimpleValue()
   * @generated
   */
  EReference getXMOFSimpleValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue <em>XMOF Object Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Object Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue
   * @generated
   */
  EClass getXMOFObjectValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectValue#getValue()
   * @see #getXMOFObjectValue()
   * @generated
   */
  EReference getXMOFObjectValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario <em>XMOF Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Scenario</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario
   * @generated
   */
  EClass getXMOFScenario();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getName()
   * @see #getXMOFScenario()
   * @generated
   */
  EAttribute getXMOFScenario_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getObjects <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getObjects()
   * @see #getXMOFScenario()
   * @generated
   */
  EReference getXMOFScenario_Objects();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Links</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFScenario#getLinks()
   * @see #getXMOFScenario()
   * @generated
   */
  EReference getXMOFScenario_Links();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification <em>XMOF Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Object Specification</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification
   * @generated
   */
  EClass getXMOFObjectSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getName()
   * @see #getXMOFObjectSpecification()
   * @generated
   */
  EAttribute getXMOFObjectSpecification_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getType()
   * @see #getXMOFObjectSpecification()
   * @generated
   */
  EReference getXMOFObjectSpecification_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getAttributes()
   * @see #getXMOFObjectSpecification()
   * @generated
   */
  EReference getXMOFObjectSpecification_Attributes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute <em>XMOF Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Attribute</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute
   * @generated
   */
  EClass getXMOFAttribute();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute#getAtt <em>Att</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Att</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute#getAtt()
   * @see #getXMOFAttribute()
   * @generated
   */
  EReference getXMOFAttribute_Att();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute#getValue()
   * @see #getXMOFAttribute()
   * @generated
   */
  EReference getXMOFAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink <em>XMOF Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Link</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink
   * @generated
   */
  EClass getXMOFLink();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getAssoc <em>Assoc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Assoc</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getAssoc()
   * @see #getXMOFLink()
   * @generated
   */
  EReference getXMOFLink_Assoc();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceProperty <em>Source Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Property</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceProperty()
   * @see #getXMOFLink()
   * @generated
   */
  EReference getXMOFLink_SourceProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceValue <em>Source Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceValue()
   * @see #getXMOFLink()
   * @generated
   */
  EReference getXMOFLink_SourceValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetProperty <em>Target Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Property</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetProperty()
   * @see #getXMOFLink()
   * @generated
   */
  EReference getXMOFLink_TargetProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetValue <em>Target Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetValue()
   * @see #getXMOFLink()
   * @generated
   */
  EReference getXMOFLink_TargetValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion <em>XMOF Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Assertion</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAssertion
   * @generated
   */
  EClass getXMOFAssertion();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion <em>XMOF State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF State Assertion</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion
   * @generated
   */
  EClass getXMOFStateAssertion();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getQuantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quantifier</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getQuantifier()
   * @see #getXMOFStateAssertion()
   * @generated
   */
  EAttribute getXMOFStateAssertion_Quantifier();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getOperator()
   * @see #getXMOFStateAssertion()
   * @generated
   */
  EAttribute getXMOFStateAssertion_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getReferencePoint <em>Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Point</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getReferencePoint()
   * @see #getXMOFStateAssertion()
   * @generated
   */
  EReference getXMOFStateAssertion_ReferencePoint();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getUntilPoint <em>Until Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Until Point</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getUntilPoint()
   * @see #getXMOFStateAssertion()
   * @generated
   */
  EReference getXMOFStateAssertion_UntilPoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getChecks <em>Checks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Checks</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateAssertion#getChecks()
   * @see #getXMOFStateAssertion()
   * @generated
   */
  EReference getXMOFStateAssertion_Checks();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint <em>XMOF Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Reference Point</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFReferencePoint
   * @generated
   */
  EClass getXMOFReferencePoint();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint <em>XMOF Action Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Action Reference Point</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint
   * @generated
   */
  EClass getXMOFActionReferencePoint();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Action</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFActionReferencePoint#getAction()
   * @see #getXMOFActionReferencePoint()
   * @generated
   */
  EReference getXMOFActionReferencePoint_Action();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint <em>XMOF Constraint Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Constraint Reference Point</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint
   * @generated
   */
  EClass getXMOFConstraintReferencePoint();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint Name</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintReferencePoint#getConstraintName()
   * @see #getXMOFConstraintReferencePoint()
   * @generated
   */
  EReference getXMOFConstraintReferencePoint_ConstraintName();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFFinallyStateAssertion <em>XMOF Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Finally State Assertion</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFFinallyStateAssertion
   * @generated
   */
  EClass getXMOFFinallyStateAssertion();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck <em>XMOF Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Check</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFCheck
   * @generated
   */
  EClass getXMOFCheck();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck <em>XMOF Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck
   * @generated
   */
  EClass getXMOFConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getConstraintNames <em>Constraint Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Names</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getConstraintNames()
   * @see #getXMOFConstraintCheck()
   * @generated
   */
  EReference getXMOFConstraintCheck_ConstraintNames();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFConstraintCheck#getObject()
   * @see #getXMOFConstraintCheck()
   * @generated
   */
  EReference getXMOFConstraintCheck_Object();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression <em>XMOF State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF State Expression</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression
   * @generated
   */
  EClass getXMOFStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getPin <em>Pin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pin</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getPin()
   * @see #getXMOFStateExpression()
   * @generated
   */
  EReference getXMOFStateExpression_Pin();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getOperator()
   * @see #getXMOFStateExpression()
   * @generated
   */
  EAttribute getXMOFStateExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFStateExpression#getValue()
   * @see #getXMOFStateExpression()
   * @generated
   */
  EReference getXMOFStateExpression_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectStateExpression <em>XMOF Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Object State Expression</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectStateExpression
   * @generated
   */
  EClass getXMOFObjectStateExpression();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression <em>XMOF Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Property State Expression</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression
   * @generated
   */
  EClass getXMOFPropertyStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFPropertyStateExpression#getProperty()
   * @see #getXMOFPropertyStateExpression()
   * @generated
   */
  EReference getXMOFPropertyStateExpression_Property();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion <em>XMOF Order Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Order Assertion</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion
   * @generated
   */
  EClass getXMOFOrderAssertion();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Order</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFOrderAssertion#getOrder()
   * @see #getXMOFOrderAssertion()
   * @generated
   */
  EReference getXMOFOrderAssertion_Order();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder <em>XMOF Node Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Node Order</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder
   * @generated
   */
  EClass getXMOFNodeOrder();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeOrder#getNodes()
   * @see #getXMOFNodeOrder()
   * @generated
   */
  EReference getXMOFNodeOrder_Nodes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification <em>XMOF Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XMOF Node Specification</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification
   * @generated
   */
  EClass getXMOFNodeSpecification();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getNode()
   * @see #getXMOFNodeSpecification()
   * @generated
   */
  EReference getXMOFNodeSpecification_Node();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getSize()
   * @see #getXMOFNodeSpecification()
   * @generated
   */
  EReference getXMOFNodeSpecification_Size();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getSubOrder <em>Sub Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Order</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getSubOrder()
   * @see #getXMOFNodeSpecification()
   * @generated
   */
  EReference getXMOFNodeSpecification_SubOrder();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getJoker <em>Joker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Joker</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFNodeSpecification#getJoker()
   * @see #getXMOFNodeSpecification()
   * @generated
   */
  EAttribute getXMOFNodeSpecification_Joker();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion <em>Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Finally State Assertion</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion
   * @generated
   */
  EClass getFinallyStateAssertion();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion#getChecks <em>Checks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Checks</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.FinallyStateAssertion#getChecks()
   * @see #getFinallyStateAssertion()
   * @generated
   */
  EReference getFinallyStateAssertion_Checks();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator <em>XMOF Arithmetic Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>XMOF Arithmetic Operator</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator
   * @generated
   */
  EEnum getXMOFArithmeticOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator <em>XMOF Temporal Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>XMOF Temporal Operator</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator
   * @generated
   */
  EEnum getXMOFTemporalOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier <em>XMOF Temporal Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>XMOF Temporal Quantifier</em>'.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier
   * @generated
   */
  EEnum getXMOFTemporalQuantifier();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XmofTestLangFactory getXmofTestLangFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestSuiteImpl <em>XMOF Test Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestSuiteImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTestSuite()
     * @generated
     */
    EClass XMOF_TEST_SUITE = eINSTANCE.getXMOFTestSuite();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_SUITE__IMPORTS = eINSTANCE.getXMOFTestSuite_Imports();

    /**
     * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_SUITE__SCENARIOS = eINSTANCE.getXMOFTestSuite_Scenarios();

    /**
     * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_SUITE__TESTS = eINSTANCE.getXMOFTestSuite_Tests();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.ImportImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl <em>XMOF Test Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFTestCaseImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTestCase()
     * @generated
     */
    EClass XMOF_TEST_CASE = eINSTANCE.getXMOFTestCase();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_TEST_CASE__NAME = eINSTANCE.getXMOFTestCase_Name();

    /**
     * The meta object literal for the '<em><b>Activity Under Test</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_CASE__ACTIVITY_UNDER_TEST = eINSTANCE.getXMOFTestCase_ActivityUnderTest();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_CASE__INPUTS = eINSTANCE.getXMOFTestCase_Inputs();

    /**
     * The meta object literal for the '<em><b>Context Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_CASE__CONTEXT_OBJECT = eINSTANCE.getXMOFTestCase_ContextObject();

    /**
     * The meta object literal for the '<em><b>Init Scenarios</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_CASE__INIT_SCENARIOS = eINSTANCE.getXMOFTestCase_InitScenarios();

    /**
     * The meta object literal for the '<em><b>Assertions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_TEST_CASE__ASSERTIONS = eINSTANCE.getXMOFTestCase_Assertions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl <em>XMOF Activity Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActivityInputImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFActivityInput()
     * @generated
     */
    EClass XMOF_ACTIVITY_INPUT = eINSTANCE.getXMOFActivityInput();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ACTIVITY_INPUT__PARAMETER = eINSTANCE.getXMOFActivityInput_Parameter();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ACTIVITY_INPUT__VALUE = eINSTANCE.getXMOFActivityInput_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFValueImpl <em>XMOF Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFValueImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFValue()
     * @generated
     */
    EClass XMOF_VALUE = eINSTANCE.getXMOFValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFSimpleValueImpl <em>XMOF Simple Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFSimpleValueImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFSimpleValue()
     * @generated
     */
    EClass XMOF_SIMPLE_VALUE = eINSTANCE.getXMOFSimpleValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_SIMPLE_VALUE__VALUE = eINSTANCE.getXMOFSimpleValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectValueImpl <em>XMOF Object Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectValueImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectValue()
     * @generated
     */
    EClass XMOF_OBJECT_VALUE = eINSTANCE.getXMOFObjectValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_OBJECT_VALUE__VALUE = eINSTANCE.getXMOFObjectValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl <em>XMOF Scenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFScenarioImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFScenario()
     * @generated
     */
    EClass XMOF_SCENARIO = eINSTANCE.getXMOFScenario();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_SCENARIO__NAME = eINSTANCE.getXMOFScenario_Name();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_SCENARIO__OBJECTS = eINSTANCE.getXMOFScenario_Objects();

    /**
     * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_SCENARIO__LINKS = eINSTANCE.getXMOFScenario_Links();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectSpecificationImpl <em>XMOF Object Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectSpecificationImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectSpecification()
     * @generated
     */
    EClass XMOF_OBJECT_SPECIFICATION = eINSTANCE.getXMOFObjectSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_OBJECT_SPECIFICATION__NAME = eINSTANCE.getXMOFObjectSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_OBJECT_SPECIFICATION__TYPE = eINSTANCE.getXMOFObjectSpecification_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_OBJECT_SPECIFICATION__ATTRIBUTES = eINSTANCE.getXMOFObjectSpecification_Attributes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAttributeImpl <em>XMOF Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAttributeImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFAttribute()
     * @generated
     */
    EClass XMOF_ATTRIBUTE = eINSTANCE.getXMOFAttribute();

    /**
     * The meta object literal for the '<em><b>Att</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ATTRIBUTE__ATT = eINSTANCE.getXMOFAttribute_Att();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ATTRIBUTE__VALUE = eINSTANCE.getXMOFAttribute_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl <em>XMOF Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFLinkImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFLink()
     * @generated
     */
    EClass XMOF_LINK = eINSTANCE.getXMOFLink();

    /**
     * The meta object literal for the '<em><b>Assoc</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_LINK__ASSOC = eINSTANCE.getXMOFLink_Assoc();

    /**
     * The meta object literal for the '<em><b>Source Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_LINK__SOURCE_PROPERTY = eINSTANCE.getXMOFLink_SourceProperty();

    /**
     * The meta object literal for the '<em><b>Source Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_LINK__SOURCE_VALUE = eINSTANCE.getXMOFLink_SourceValue();

    /**
     * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_LINK__TARGET_PROPERTY = eINSTANCE.getXMOFLink_TargetProperty();

    /**
     * The meta object literal for the '<em><b>Target Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_LINK__TARGET_VALUE = eINSTANCE.getXMOFLink_TargetValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAssertionImpl <em>XMOF Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFAssertionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFAssertion()
     * @generated
     */
    EClass XMOF_ASSERTION = eINSTANCE.getXMOFAssertion();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl <em>XMOF State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateAssertionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFStateAssertion()
     * @generated
     */
    EClass XMOF_STATE_ASSERTION = eINSTANCE.getXMOFStateAssertion();

    /**
     * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_STATE_ASSERTION__QUANTIFIER = eINSTANCE.getXMOFStateAssertion_Quantifier();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_STATE_ASSERTION__OPERATOR = eINSTANCE.getXMOFStateAssertion_Operator();

    /**
     * The meta object literal for the '<em><b>Reference Point</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_STATE_ASSERTION__REFERENCE_POINT = eINSTANCE.getXMOFStateAssertion_ReferencePoint();

    /**
     * The meta object literal for the '<em><b>Until Point</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_STATE_ASSERTION__UNTIL_POINT = eINSTANCE.getXMOFStateAssertion_UntilPoint();

    /**
     * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_STATE_ASSERTION__CHECKS = eINSTANCE.getXMOFStateAssertion_Checks();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFReferencePointImpl <em>XMOF Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFReferencePointImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFReferencePoint()
     * @generated
     */
    EClass XMOF_REFERENCE_POINT = eINSTANCE.getXMOFReferencePoint();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActionReferencePointImpl <em>XMOF Action Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFActionReferencePointImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFActionReferencePoint()
     * @generated
     */
    EClass XMOF_ACTION_REFERENCE_POINT = eINSTANCE.getXMOFActionReferencePoint();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ACTION_REFERENCE_POINT__ACTION = eINSTANCE.getXMOFActionReferencePoint_Action();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintReferencePointImpl <em>XMOF Constraint Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintReferencePointImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFConstraintReferencePoint()
     * @generated
     */
    EClass XMOF_CONSTRAINT_REFERENCE_POINT = eINSTANCE.getXMOFConstraintReferencePoint();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME = eINSTANCE.getXMOFConstraintReferencePoint_ConstraintName();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFFinallyStateAssertionImpl <em>XMOF Finally State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFFinallyStateAssertionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFFinallyStateAssertion()
     * @generated
     */
    EClass XMOF_FINALLY_STATE_ASSERTION = eINSTANCE.getXMOFFinallyStateAssertion();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFCheckImpl <em>XMOF Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFCheckImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFCheck()
     * @generated
     */
    EClass XMOF_CHECK = eINSTANCE.getXMOFCheck();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintCheckImpl <em>XMOF Constraint Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFConstraintCheckImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFConstraintCheck()
     * @generated
     */
    EClass XMOF_CONSTRAINT_CHECK = eINSTANCE.getXMOFConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Constraint Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_CONSTRAINT_CHECK__CONSTRAINT_NAMES = eINSTANCE.getXMOFConstraintCheck_ConstraintNames();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_CONSTRAINT_CHECK__OBJECT = eINSTANCE.getXMOFConstraintCheck_Object();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateExpressionImpl <em>XMOF State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFStateExpressionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFStateExpression()
     * @generated
     */
    EClass XMOF_STATE_EXPRESSION = eINSTANCE.getXMOFStateExpression();

    /**
     * The meta object literal for the '<em><b>Pin</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_STATE_EXPRESSION__PIN = eINSTANCE.getXMOFStateExpression_Pin();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_STATE_EXPRESSION__OPERATOR = eINSTANCE.getXMOFStateExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_STATE_EXPRESSION__VALUE = eINSTANCE.getXMOFStateExpression_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectStateExpressionImpl <em>XMOF Object State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFObjectStateExpressionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFObjectStateExpression()
     * @generated
     */
    EClass XMOF_OBJECT_STATE_EXPRESSION = eINSTANCE.getXMOFObjectStateExpression();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFPropertyStateExpressionImpl <em>XMOF Property State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFPropertyStateExpressionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFPropertyStateExpression()
     * @generated
     */
    EClass XMOF_PROPERTY_STATE_EXPRESSION = eINSTANCE.getXMOFPropertyStateExpression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_PROPERTY_STATE_EXPRESSION__PROPERTY = eINSTANCE.getXMOFPropertyStateExpression_Property();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFOrderAssertionImpl <em>XMOF Order Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFOrderAssertionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFOrderAssertion()
     * @generated
     */
    EClass XMOF_ORDER_ASSERTION = eINSTANCE.getXMOFOrderAssertion();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_ORDER_ASSERTION__ORDER = eINSTANCE.getXMOFOrderAssertion_Order();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeOrderImpl <em>XMOF Node Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeOrderImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFNodeOrder()
     * @generated
     */
    EClass XMOF_NODE_ORDER = eINSTANCE.getXMOFNodeOrder();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_NODE_ORDER__NODES = eINSTANCE.getXMOFNodeOrder_Nodes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeSpecificationImpl <em>XMOF Node Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XMOFNodeSpecificationImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFNodeSpecification()
     * @generated
     */
    EClass XMOF_NODE_SPECIFICATION = eINSTANCE.getXMOFNodeSpecification();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_NODE_SPECIFICATION__NODE = eINSTANCE.getXMOFNodeSpecification_Node();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_NODE_SPECIFICATION__SIZE = eINSTANCE.getXMOFNodeSpecification_Size();

    /**
     * The meta object literal for the '<em><b>Sub Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XMOF_NODE_SPECIFICATION__SUB_ORDER = eINSTANCE.getXMOFNodeSpecification_SubOrder();

    /**
     * The meta object literal for the '<em><b>Joker</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XMOF_NODE_SPECIFICATION__JOKER = eINSTANCE.getXMOFNodeSpecification_Joker();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.impl.FinallyStateAssertionImpl <em>Finally State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.FinallyStateAssertionImpl
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getFinallyStateAssertion()
     * @generated
     */
    EClass FINALLY_STATE_ASSERTION = eINSTANCE.getFinallyStateAssertion();

    /**
     * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINALLY_STATE_ASSERTION__CHECKS = eINSTANCE.getFinallyStateAssertion_Checks();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator <em>XMOF Arithmetic Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFArithmeticOperator
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFArithmeticOperator()
     * @generated
     */
    EEnum XMOF_ARITHMETIC_OPERATOR = eINSTANCE.getXMOFArithmeticOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator <em>XMOF Temporal Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalOperator
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTemporalOperator()
     * @generated
     */
    EEnum XMOF_TEMPORAL_OPERATOR = eINSTANCE.getXMOFTemporalOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier <em>XMOF Temporal Quantifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFTemporalQuantifier
     * @see org.modelexecution.fumltesting.xmof.xmofTestLang.impl.XmofTestLangPackageImpl#getXMOFTemporalQuantifier()
     * @generated
     */
    EEnum XMOF_TEMPORAL_QUANTIFIER = eINSTANCE.getXMOFTemporalQuantifier();

  }

} //XmofTestLangPackage
