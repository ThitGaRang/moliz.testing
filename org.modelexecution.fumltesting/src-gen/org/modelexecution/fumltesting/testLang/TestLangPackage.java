/**
 */
package org.modelexecution.fumltesting.testLang;

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
 * @see org.modelexecution.fumltesting.testLang.TestLangFactory
 * @model kind="package"
 * @generated
 */
public interface TestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "testLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.modelexecution.org/fumltesting/TestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "testLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestLangPackage eINSTANCE = org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.TestSuiteImpl <em>Test Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.TestSuiteImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTestSuite()
   * @generated
   */
  int TEST_SUITE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__SCENARIOS = 1;

  /**
   * The feature id for the '<em><b>Tests</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__TESTS = 2;

  /**
   * The number of structural features of the '<em>Test Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ImportImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getImport()
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
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.VarDeclarationImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getVarDeclaration()
   * @generated
   */
  int VAR_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION__REF = 1;

  /**
   * The number of structural features of the '<em>Var Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl <em>Test Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.TestCaseImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTestCase()
   * @generated
   */
  int TEST_CASE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__NAME = 0;

  /**
   * The feature id for the '<em><b>Activity Under Test</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__ACTIVITY_UNDER_TEST = 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__INPUTS = 2;

  /**
   * The feature id for the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__CONTEXT_OBJECT = 3;

  /**
   * The feature id for the '<em><b>Init Scenarios</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__INIT_SCENARIOS = 4;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__VARIABLES = 5;

  /**
   * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__ASSERTIONS = 6;

  /**
   * The number of structural features of the '<em>Test Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ActivityInputImpl <em>Activity Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ActivityInputImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getActivityInput()
   * @generated
   */
  int ACTIVITY_INPUT = 4;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_INPUT__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_INPUT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Activity Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_INPUT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ValueImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getValue()
   * @generated
   */
  int VALUE = 5;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.SimpleValueImpl <em>Simple Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.SimpleValueImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getSimpleValue()
   * @generated
   */
  int SIMPLE_VALUE = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectValueImpl <em>Object Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ObjectValueImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectValue()
   * @generated
   */
  int OBJECT_VALUE = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Object Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ScenarioImpl <em>Scenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ScenarioImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getScenario()
   * @generated
   */
  int SCENARIO = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO__NAME = 0;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO__OBJECTS = 1;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO__LINKS = 2;

  /**
   * The number of structural features of the '<em>Scenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ObjectSpecificationImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectSpecification()
   * @generated
   */
  int OBJECT_SPECIFICATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SPECIFICATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SPECIFICATION__ATTRIBUTES = 2;

  /**
   * The number of structural features of the '<em>Object Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.AttributeImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 10;

  /**
   * The feature id for the '<em><b>Att</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ATT = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl <em>Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.LinkImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getLink()
   * @generated
   */
  int LINK = 11;

  /**
   * The feature id for the '<em><b>Assoc</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__ASSOC = 0;

  /**
   * The feature id for the '<em><b>Source Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__SOURCE_PROPERTY = 1;

  /**
   * The feature id for the '<em><b>Source Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__SOURCE_VALUE = 2;

  /**
   * The feature id for the '<em><b>Target Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__TARGET_PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Target Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__TARGET_VALUE = 4;

  /**
   * The number of structural features of the '<em>Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.AssertionImpl <em>Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.AssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getAssertion()
   * @generated
   */
  int ASSERTION = 12;

  /**
   * The number of structural features of the '<em>Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl <em>State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getStateAssertion()
   * @generated
   */
  int STATE_ASSERTION = 13;

  /**
   * The feature id for the '<em><b>Temporal Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__TEMPORAL_QUANTIFIER = ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Temporal Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__TEMPORAL_OPERATOR = ASSERTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reference Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__REFERENCE_ACTION = ASSERTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Until Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__UNTIL_ACTION = ASSERTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Constraint Check</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__CONSTRAINT_CHECK = ASSERTION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION__EXPRESSIONS = ASSERTION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl <em>OO State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOOStateAssertion()
   * @generated
   */
  int OO_STATE_ASSERTION = 14;

  /**
   * The feature id for the '<em><b>Temporal Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER = ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Temporal Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__TEMPORAL_OPERATOR = ASSERTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reference Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__REFERENCE_CONSTRAINT = ASSERTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Until Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__UNTIL_CONSTRAINT = ASSERTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Constraint Check</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__CONSTRAINT_CHECK = ASSERTION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION__EXPRESSIONS = ASSERTION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>OO State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_STATE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl <em>OO Global State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOOGlobalStateAssertion()
   * @generated
   */
  int OO_GLOBAL_STATE_ASSERTION = 15;

  /**
   * The feature id for the '<em><b>Condition Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT = ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_GLOBAL_STATE_ASSERTION__QUANTIFIER = ASSERTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Evaluated Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT = ASSERTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_GLOBAL_STATE_ASSERTION__OBJECT = ASSERTION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>OO Global State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OO_GLOBAL_STATE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl <em>Finally State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getFinallyStateAssertion()
   * @generated
   */
  int FINALLY_STATE_ASSERTION = 16;

  /**
   * The feature id for the '<em><b>Constraint Check</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK = ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINALLY_STATE_ASSERTION__EXPRESSIONS = ASSERTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Finally State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINALLY_STATE_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl <em>Constraint Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getConstraintCheck()
   * @generated
   */
  int CONSTRAINT_CHECK = 17;

  /**
   * The feature id for the '<em><b>Constraint Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CHECK__CONSTRAINT_NAMES = 0;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CHECK__OBJECT = 1;

  /**
   * The number of structural features of the '<em>Constraint Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CHECK_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.StateExpressionImpl <em>State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.StateExpressionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getStateExpression()
   * @generated
   */
  int STATE_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__PIN = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__VALUE = 2;

  /**
   * The number of structural features of the '<em>State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectStateExpressionImpl <em>Object State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.ObjectStateExpressionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectStateExpression()
   * @generated
   */
  int OBJECT_STATE_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_STATE_EXPRESSION__PIN = STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_STATE_EXPRESSION__OPERATOR = STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_STATE_EXPRESSION__VALUE = STATE_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>Object State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_STATE_EXPRESSION_FEATURE_COUNT = STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.PropertyStateExpressionImpl <em>Property State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.PropertyStateExpressionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getPropertyStateExpression()
   * @generated
   */
  int PROPERTY_STATE_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_STATE_EXPRESSION__PIN = STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_STATE_EXPRESSION__OPERATOR = STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_STATE_EXPRESSION__VALUE = STATE_EXPRESSION__VALUE;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_STATE_EXPRESSION__PROPERTY = STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_STATE_EXPRESSION_FEATURE_COUNT = STATE_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.OrderAssertionImpl <em>Order Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.OrderAssertionImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOrderAssertion()
   * @generated
   */
  int ORDER_ASSERTION = 21;

  /**
   * The feature id for the '<em><b>Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDER_ASSERTION__ORDER = ASSERTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Order Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDER_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.NodeOrderImpl <em>Node Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.NodeOrderImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getNodeOrder()
   * @generated
   */
  int NODE_ORDER = 22;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_ORDER__NODES = 0;

  /**
   * The number of structural features of the '<em>Node Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_ORDER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl <em>Node Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getNodeSpecification()
   * @generated
   */
  int NODE_SPECIFICATION = 23;

  /**
   * The feature id for the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_SPECIFICATION__NODE = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_SPECIFICATION__SIZE = 1;

  /**
   * The feature id for the '<em><b>Sub Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_SPECIFICATION__SUB_ORDER = 2;

  /**
   * The feature id for the '<em><b>Joker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_SPECIFICATION__JOKER = 3;

  /**
   * The number of structural features of the '<em>Node Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.ArithmeticOperator
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getArithmeticOperator()
   * @generated
   */
  int ARITHMETIC_OPERATOR = 24;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.TemporalOperator <em>Temporal Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTemporalOperator()
   * @generated
   */
  int TEMPORAL_OPERATOR = 25;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.testLang.TemporalQuantifier <em>Temporal Quantifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTemporalQuantifier()
   * @generated
   */
  int TEMPORAL_QUANTIFIER = 26;


  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.TestSuite <em>Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Suite</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestSuite
   * @generated
   */
  EClass getTestSuite();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestSuite#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestSuite#getImports()
   * @see #getTestSuite()
   * @generated
   */
  EReference getTestSuite_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestSuite#getScenarios <em>Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenarios</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestSuite#getScenarios()
   * @see #getTestSuite()
   * @generated
   */
  EReference getTestSuite_Scenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestSuite#getTests <em>Tests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tests</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestSuite#getTests()
   * @see #getTestSuite()
   * @generated
   */
  EReference getTestSuite_Tests();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.modelexecution.fumltesting.testLang.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.modelexecution.fumltesting.testLang.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.VarDeclaration <em>Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Declaration</em>'.
   * @see org.modelexecution.fumltesting.testLang.VarDeclaration
   * @generated
   */
  EClass getVarDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.VarDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.testLang.VarDeclaration#getName()
   * @see #getVarDeclaration()
   * @generated
   */
  EAttribute getVarDeclaration_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.VarDeclaration#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.modelexecution.fumltesting.testLang.VarDeclaration#getRef()
   * @see #getVarDeclaration()
   * @generated
   */
  EReference getVarDeclaration_Ref();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.TestCase <em>Test Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Case</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase
   * @generated
   */
  EClass getTestCase();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.TestCase#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getName()
   * @see #getTestCase()
   * @generated
   */
  EAttribute getTestCase_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.TestCase#getActivityUnderTest <em>Activity Under Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Activity Under Test</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getActivityUnderTest()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_ActivityUnderTest();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestCase#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getInputs()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_Inputs();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.TestCase#getContextObject <em>Context Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context Object</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getContextObject()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_ContextObject();

  /**
   * Returns the meta object for the reference list '{@link org.modelexecution.fumltesting.testLang.TestCase#getInitScenarios <em>Init Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Init Scenarios</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getInitScenarios()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_InitScenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestCase#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getVariables()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.TestCase#getAssertions <em>Assertions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assertions</em>'.
   * @see org.modelexecution.fumltesting.testLang.TestCase#getAssertions()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_Assertions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.ActivityInput <em>Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity Input</em>'.
   * @see org.modelexecution.fumltesting.testLang.ActivityInput
   * @generated
   */
  EClass getActivityInput();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.ActivityInput#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.modelexecution.fumltesting.testLang.ActivityInput#getParameter()
   * @see #getActivityInput()
   * @generated
   */
  EReference getActivityInput_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.ActivityInput#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.ActivityInput#getValue()
   * @see #getActivityInput()
   * @generated
   */
  EReference getActivityInput_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.SimpleValue <em>Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.SimpleValue
   * @generated
   */
  EClass getSimpleValue();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.SimpleValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.SimpleValue#getValue()
   * @see #getSimpleValue()
   * @generated
   */
  EReference getSimpleValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.ObjectValue <em>Object Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectValue
   * @generated
   */
  EClass getObjectValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.ObjectValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectValue#getValue()
   * @see #getObjectValue()
   * @generated
   */
  EReference getObjectValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Scenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scenario</em>'.
   * @see org.modelexecution.fumltesting.testLang.Scenario
   * @generated
   */
  EClass getScenario();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.Scenario#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.testLang.Scenario#getName()
   * @see #getScenario()
   * @generated
   */
  EAttribute getScenario_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.Scenario#getObjects <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see org.modelexecution.fumltesting.testLang.Scenario#getObjects()
   * @see #getScenario()
   * @generated
   */
  EReference getScenario_Objects();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.Scenario#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Links</em>'.
   * @see org.modelexecution.fumltesting.testLang.Scenario#getLinks()
   * @see #getScenario()
   * @generated
   */
  EReference getScenario_Links();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.ObjectSpecification <em>Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Specification</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectSpecification
   * @generated
   */
  EClass getObjectSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.ObjectSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectSpecification#getName()
   * @see #getObjectSpecification()
   * @generated
   */
  EAttribute getObjectSpecification_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.ObjectSpecification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectSpecification#getType()
   * @see #getObjectSpecification()
   * @generated
   */
  EReference getObjectSpecification_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.ObjectSpecification#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectSpecification#getAttributes()
   * @see #getObjectSpecification()
   * @generated
   */
  EReference getObjectSpecification_Attributes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.modelexecution.fumltesting.testLang.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Attribute#getAtt <em>Att</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Att</em>'.
   * @see org.modelexecution.fumltesting.testLang.Attribute#getAtt()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Att();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Link <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link
   * @generated
   */
  EClass getLink();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Link#getAssoc <em>Assoc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Assoc</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link#getAssoc()
   * @see #getLink()
   * @generated
   */
  EReference getLink_Assoc();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Link#getSourceProperty <em>Source Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Property</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link#getSourceProperty()
   * @see #getLink()
   * @generated
   */
  EReference getLink_SourceProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Link#getSourceValue <em>Source Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link#getSourceValue()
   * @see #getLink()
   * @generated
   */
  EReference getLink_SourceValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Link#getTargetProperty <em>Target Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Property</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link#getTargetProperty()
   * @see #getLink()
   * @generated
   */
  EReference getLink_TargetProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.Link#getTargetValue <em>Target Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.Link#getTargetValue()
   * @see #getLink()
   * @generated
   */
  EReference getLink_TargetValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.Assertion
   * @generated
   */
  EClass getAssertion();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.StateAssertion <em>State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion
   * @generated
   */
  EClass getStateAssertion();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Temporal Quantifier</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalQuantifier()
   * @see #getStateAssertion()
   * @generated
   */
  EAttribute getStateAssertion_TemporalQuantifier();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalOperator <em>Temporal Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Temporal Operator</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getTemporalOperator()
   * @see #getStateAssertion()
   * @generated
   */
  EAttribute getStateAssertion_TemporalOperator();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getReferenceAction <em>Reference Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference Action</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getReferenceAction()
   * @see #getStateAssertion()
   * @generated
   */
  EReference getStateAssertion_ReferenceAction();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getUntilAction <em>Until Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Until Action</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getUntilAction()
   * @see #getStateAssertion()
   * @generated
   */
  EReference getStateAssertion_UntilAction();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getConstraintCheck <em>Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getConstraintCheck()
   * @see #getStateAssertion()
   * @generated
   */
  EReference getStateAssertion_ConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.StateAssertion#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateAssertion#getExpressions()
   * @see #getStateAssertion()
   * @generated
   */
  EReference getStateAssertion_Expressions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion <em>OO State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>OO State Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion
   * @generated
   */
  EClass getOOStateAssertion();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalQuantifier <em>Temporal Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Temporal Quantifier</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalQuantifier()
   * @see #getOOStateAssertion()
   * @generated
   */
  EAttribute getOOStateAssertion_TemporalQuantifier();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalOperator <em>Temporal Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Temporal Operator</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getTemporalOperator()
   * @see #getOOStateAssertion()
   * @generated
   */
  EAttribute getOOStateAssertion_TemporalOperator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getReferenceConstraint <em>Reference Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Constraint</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getReferenceConstraint()
   * @see #getOOStateAssertion()
   * @generated
   */
  EReference getOOStateAssertion_ReferenceConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getUntilConstraint <em>Until Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Until Constraint</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getUntilConstraint()
   * @see #getOOStateAssertion()
   * @generated
   */
  EReference getOOStateAssertion_UntilConstraint();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getConstraintCheck <em>Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getConstraintCheck()
   * @see #getOOStateAssertion()
   * @generated
   */
  EReference getOOStateAssertion_ConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.OOStateAssertion#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOStateAssertion#getExpressions()
   * @see #getOOStateAssertion()
   * @generated
   */
  EReference getOOStateAssertion_Expressions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion <em>OO Global State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>OO Global State Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion
   * @generated
   */
  EClass getOOGlobalStateAssertion();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getConditionConstraint <em>Condition Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition Constraint</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getConditionConstraint()
   * @see #getOOGlobalStateAssertion()
   * @generated
   */
  EReference getOOGlobalStateAssertion_ConditionConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getQuantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quantifier</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getQuantifier()
   * @see #getOOGlobalStateAssertion()
   * @generated
   */
  EAttribute getOOGlobalStateAssertion_Quantifier();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getEvaluatedConstraint <em>Evaluated Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Evaluated Constraint</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getEvaluatedConstraint()
   * @see #getOOGlobalStateAssertion()
   * @generated
   */
  EReference getOOGlobalStateAssertion_EvaluatedConstraint();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see org.modelexecution.fumltesting.testLang.OOGlobalStateAssertion#getObject()
   * @see #getOOGlobalStateAssertion()
   * @generated
   */
  EReference getOOGlobalStateAssertion_Object();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.FinallyStateAssertion <em>Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Finally State Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.FinallyStateAssertion
   * @generated
   */
  EClass getFinallyStateAssertion();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getConstraintCheck <em>Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getConstraintCheck()
   * @see #getFinallyStateAssertion()
   * @generated
   */
  EReference getFinallyStateAssertion_ConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.modelexecution.fumltesting.testLang.FinallyStateAssertion#getExpressions()
   * @see #getFinallyStateAssertion()
   * @generated
   */
  EReference getFinallyStateAssertion_Expressions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.ConstraintCheck <em>Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.testLang.ConstraintCheck
   * @generated
   */
  EClass getConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.ConstraintCheck#getConstraintNames <em>Constraint Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Names</em>'.
   * @see org.modelexecution.fumltesting.testLang.ConstraintCheck#getConstraintNames()
   * @see #getConstraintCheck()
   * @generated
   */
  EReference getConstraintCheck_ConstraintNames();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.ConstraintCheck#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see org.modelexecution.fumltesting.testLang.ConstraintCheck#getObject()
   * @see #getConstraintCheck()
   * @generated
   */
  EReference getConstraintCheck_Object();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.StateExpression <em>State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Expression</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateExpression
   * @generated
   */
  EClass getStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.StateExpression#getPin <em>Pin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pin</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateExpression#getPin()
   * @see #getStateExpression()
   * @generated
   */
  EReference getStateExpression_Pin();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.StateExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateExpression#getOperator()
   * @see #getStateExpression()
   * @generated
   */
  EAttribute getStateExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.StateExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.testLang.StateExpression#getValue()
   * @see #getStateExpression()
   * @generated
   */
  EReference getStateExpression_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.ObjectStateExpression <em>Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object State Expression</em>'.
   * @see org.modelexecution.fumltesting.testLang.ObjectStateExpression
   * @generated
   */
  EClass getObjectStateExpression();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.PropertyStateExpression <em>Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property State Expression</em>'.
   * @see org.modelexecution.fumltesting.testLang.PropertyStateExpression
   * @generated
   */
  EClass getPropertyStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.PropertyStateExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.modelexecution.fumltesting.testLang.PropertyStateExpression#getProperty()
   * @see #getPropertyStateExpression()
   * @generated
   */
  EReference getPropertyStateExpression_Property();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.OrderAssertion <em>Order Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Order Assertion</em>'.
   * @see org.modelexecution.fumltesting.testLang.OrderAssertion
   * @generated
   */
  EClass getOrderAssertion();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.OrderAssertion#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Order</em>'.
   * @see org.modelexecution.fumltesting.testLang.OrderAssertion#getOrder()
   * @see #getOrderAssertion()
   * @generated
   */
  EReference getOrderAssertion_Order();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.NodeOrder <em>Node Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Order</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeOrder
   * @generated
   */
  EClass getNodeOrder();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.testLang.NodeOrder#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeOrder#getNodes()
   * @see #getNodeOrder()
   * @generated
   */
  EReference getNodeOrder_Nodes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.testLang.NodeSpecification <em>Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Specification</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification
   * @generated
   */
  EClass getNodeSpecification();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.testLang.NodeSpecification#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification#getNode()
   * @see #getNodeSpecification()
   * @generated
   */
  EReference getNodeSpecification_Node();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.NodeSpecification#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification#getSize()
   * @see #getNodeSpecification()
   * @generated
   */
  EReference getNodeSpecification_Size();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.testLang.NodeSpecification#getSubOrder <em>Sub Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Order</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification#getSubOrder()
   * @see #getNodeSpecification()
   * @generated
   */
  EReference getNodeSpecification_SubOrder();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.testLang.NodeSpecification#getJoker <em>Joker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Joker</em>'.
   * @see org.modelexecution.fumltesting.testLang.NodeSpecification#getJoker()
   * @see #getNodeSpecification()
   * @generated
   */
  EAttribute getNodeSpecification_Joker();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.testLang.ArithmeticOperator <em>Arithmetic Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Arithmetic Operator</em>'.
   * @see org.modelexecution.fumltesting.testLang.ArithmeticOperator
   * @generated
   */
  EEnum getArithmeticOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.testLang.TemporalOperator <em>Temporal Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Temporal Operator</em>'.
   * @see org.modelexecution.fumltesting.testLang.TemporalOperator
   * @generated
   */
  EEnum getTemporalOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.testLang.TemporalQuantifier <em>Temporal Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Temporal Quantifier</em>'.
   * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
   * @generated
   */
  EEnum getTemporalQuantifier();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TestLangFactory getTestLangFactory();

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
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.TestSuiteImpl <em>Test Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.TestSuiteImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTestSuite()
     * @generated
     */
    EClass TEST_SUITE = eINSTANCE.getTestSuite();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_SUITE__IMPORTS = eINSTANCE.getTestSuite_Imports();

    /**
     * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_SUITE__SCENARIOS = eINSTANCE.getTestSuite_Scenarios();

    /**
     * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_SUITE__TESTS = eINSTANCE.getTestSuite_Tests();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ImportImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getImport()
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
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.VarDeclarationImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getVarDeclaration()
     * @generated
     */
    EClass VAR_DECLARATION = eINSTANCE.getVarDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_DECLARATION__NAME = eINSTANCE.getVarDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECLARATION__REF = eINSTANCE.getVarDeclaration_Ref();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.TestCaseImpl <em>Test Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.TestCaseImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTestCase()
     * @generated
     */
    EClass TEST_CASE = eINSTANCE.getTestCase();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_CASE__NAME = eINSTANCE.getTestCase_Name();

    /**
     * The meta object literal for the '<em><b>Activity Under Test</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__ACTIVITY_UNDER_TEST = eINSTANCE.getTestCase_ActivityUnderTest();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__INPUTS = eINSTANCE.getTestCase_Inputs();

    /**
     * The meta object literal for the '<em><b>Context Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__CONTEXT_OBJECT = eINSTANCE.getTestCase_ContextObject();

    /**
     * The meta object literal for the '<em><b>Init Scenarios</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__INIT_SCENARIOS = eINSTANCE.getTestCase_InitScenarios();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__VARIABLES = eINSTANCE.getTestCase_Variables();

    /**
     * The meta object literal for the '<em><b>Assertions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__ASSERTIONS = eINSTANCE.getTestCase_Assertions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ActivityInputImpl <em>Activity Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ActivityInputImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getActivityInput()
     * @generated
     */
    EClass ACTIVITY_INPUT = eINSTANCE.getActivityInput();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY_INPUT__PARAMETER = eINSTANCE.getActivityInput_Parameter();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY_INPUT__VALUE = eINSTANCE.getActivityInput_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ValueImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.SimpleValueImpl <em>Simple Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.SimpleValueImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getSimpleValue()
     * @generated
     */
    EClass SIMPLE_VALUE = eINSTANCE.getSimpleValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_VALUE__VALUE = eINSTANCE.getSimpleValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectValueImpl <em>Object Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ObjectValueImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectValue()
     * @generated
     */
    EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_VALUE__VALUE = eINSTANCE.getObjectValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ScenarioImpl <em>Scenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ScenarioImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getScenario()
     * @generated
     */
    EClass SCENARIO = eINSTANCE.getScenario();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCENARIO__NAME = eINSTANCE.getScenario_Name();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCENARIO__OBJECTS = eINSTANCE.getScenario_Objects();

    /**
     * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCENARIO__LINKS = eINSTANCE.getScenario_Links();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectSpecificationImpl <em>Object Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ObjectSpecificationImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectSpecification()
     * @generated
     */
    EClass OBJECT_SPECIFICATION = eINSTANCE.getObjectSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_SPECIFICATION__NAME = eINSTANCE.getObjectSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_SPECIFICATION__TYPE = eINSTANCE.getObjectSpecification_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_SPECIFICATION__ATTRIBUTES = eINSTANCE.getObjectSpecification_Attributes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.AttributeImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Att</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__ATT = eINSTANCE.getAttribute_Att();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.LinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.LinkImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getLink()
     * @generated
     */
    EClass LINK = eINSTANCE.getLink();

    /**
     * The meta object literal for the '<em><b>Assoc</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK__ASSOC = eINSTANCE.getLink_Assoc();

    /**
     * The meta object literal for the '<em><b>Source Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK__SOURCE_PROPERTY = eINSTANCE.getLink_SourceProperty();

    /**
     * The meta object literal for the '<em><b>Source Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK__SOURCE_VALUE = eINSTANCE.getLink_SourceValue();

    /**
     * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK__TARGET_PROPERTY = eINSTANCE.getLink_TargetProperty();

    /**
     * The meta object literal for the '<em><b>Target Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK__TARGET_VALUE = eINSTANCE.getLink_TargetValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.AssertionImpl <em>Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.AssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getAssertion()
     * @generated
     */
    EClass ASSERTION = eINSTANCE.getAssertion();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl <em>State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.StateAssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getStateAssertion()
     * @generated
     */
    EClass STATE_ASSERTION = eINSTANCE.getStateAssertion();

    /**
     * The meta object literal for the '<em><b>Temporal Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_ASSERTION__TEMPORAL_QUANTIFIER = eINSTANCE.getStateAssertion_TemporalQuantifier();

    /**
     * The meta object literal for the '<em><b>Temporal Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_ASSERTION__TEMPORAL_OPERATOR = eINSTANCE.getStateAssertion_TemporalOperator();

    /**
     * The meta object literal for the '<em><b>Reference Action</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ASSERTION__REFERENCE_ACTION = eINSTANCE.getStateAssertion_ReferenceAction();

    /**
     * The meta object literal for the '<em><b>Until Action</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ASSERTION__UNTIL_ACTION = eINSTANCE.getStateAssertion_UntilAction();

    /**
     * The meta object literal for the '<em><b>Constraint Check</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ASSERTION__CONSTRAINT_CHECK = eINSTANCE.getStateAssertion_ConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ASSERTION__EXPRESSIONS = eINSTANCE.getStateAssertion_Expressions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl <em>OO State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.OOStateAssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOOStateAssertion()
     * @generated
     */
    EClass OO_STATE_ASSERTION = eINSTANCE.getOOStateAssertion();

    /**
     * The meta object literal for the '<em><b>Temporal Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OO_STATE_ASSERTION__TEMPORAL_QUANTIFIER = eINSTANCE.getOOStateAssertion_TemporalQuantifier();

    /**
     * The meta object literal for the '<em><b>Temporal Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OO_STATE_ASSERTION__TEMPORAL_OPERATOR = eINSTANCE.getOOStateAssertion_TemporalOperator();

    /**
     * The meta object literal for the '<em><b>Reference Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_STATE_ASSERTION__REFERENCE_CONSTRAINT = eINSTANCE.getOOStateAssertion_ReferenceConstraint();

    /**
     * The meta object literal for the '<em><b>Until Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_STATE_ASSERTION__UNTIL_CONSTRAINT = eINSTANCE.getOOStateAssertion_UntilConstraint();

    /**
     * The meta object literal for the '<em><b>Constraint Check</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_STATE_ASSERTION__CONSTRAINT_CHECK = eINSTANCE.getOOStateAssertion_ConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_STATE_ASSERTION__EXPRESSIONS = eINSTANCE.getOOStateAssertion_Expressions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl <em>OO Global State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.OOGlobalStateAssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOOGlobalStateAssertion()
     * @generated
     */
    EClass OO_GLOBAL_STATE_ASSERTION = eINSTANCE.getOOGlobalStateAssertion();

    /**
     * The meta object literal for the '<em><b>Condition Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_GLOBAL_STATE_ASSERTION__CONDITION_CONSTRAINT = eINSTANCE.getOOGlobalStateAssertion_ConditionConstraint();

    /**
     * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OO_GLOBAL_STATE_ASSERTION__QUANTIFIER = eINSTANCE.getOOGlobalStateAssertion_Quantifier();

    /**
     * The meta object literal for the '<em><b>Evaluated Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_GLOBAL_STATE_ASSERTION__EVALUATED_CONSTRAINT = eINSTANCE.getOOGlobalStateAssertion_EvaluatedConstraint();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OO_GLOBAL_STATE_ASSERTION__OBJECT = eINSTANCE.getOOGlobalStateAssertion_Object();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl <em>Finally State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.FinallyStateAssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getFinallyStateAssertion()
     * @generated
     */
    EClass FINALLY_STATE_ASSERTION = eINSTANCE.getFinallyStateAssertion();

    /**
     * The meta object literal for the '<em><b>Constraint Check</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINALLY_STATE_ASSERTION__CONSTRAINT_CHECK = eINSTANCE.getFinallyStateAssertion_ConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINALLY_STATE_ASSERTION__EXPRESSIONS = eINSTANCE.getFinallyStateAssertion_Expressions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl <em>Constraint Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ConstraintCheckImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getConstraintCheck()
     * @generated
     */
    EClass CONSTRAINT_CHECK = eINSTANCE.getConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Constraint Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_CHECK__CONSTRAINT_NAMES = eINSTANCE.getConstraintCheck_ConstraintNames();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_CHECK__OBJECT = eINSTANCE.getConstraintCheck_Object();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.StateExpressionImpl <em>State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.StateExpressionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getStateExpression()
     * @generated
     */
    EClass STATE_EXPRESSION = eINSTANCE.getStateExpression();

    /**
     * The meta object literal for the '<em><b>Pin</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_EXPRESSION__PIN = eINSTANCE.getStateExpression_Pin();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_EXPRESSION__OPERATOR = eINSTANCE.getStateExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_EXPRESSION__VALUE = eINSTANCE.getStateExpression_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.ObjectStateExpressionImpl <em>Object State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.ObjectStateExpressionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getObjectStateExpression()
     * @generated
     */
    EClass OBJECT_STATE_EXPRESSION = eINSTANCE.getObjectStateExpression();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.PropertyStateExpressionImpl <em>Property State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.PropertyStateExpressionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getPropertyStateExpression()
     * @generated
     */
    EClass PROPERTY_STATE_EXPRESSION = eINSTANCE.getPropertyStateExpression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_STATE_EXPRESSION__PROPERTY = eINSTANCE.getPropertyStateExpression_Property();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.OrderAssertionImpl <em>Order Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.OrderAssertionImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getOrderAssertion()
     * @generated
     */
    EClass ORDER_ASSERTION = eINSTANCE.getOrderAssertion();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORDER_ASSERTION__ORDER = eINSTANCE.getOrderAssertion_Order();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.NodeOrderImpl <em>Node Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.NodeOrderImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getNodeOrder()
     * @generated
     */
    EClass NODE_ORDER = eINSTANCE.getNodeOrder();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_ORDER__NODES = eINSTANCE.getNodeOrder_Nodes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl <em>Node Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getNodeSpecification()
     * @generated
     */
    EClass NODE_SPECIFICATION = eINSTANCE.getNodeSpecification();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_SPECIFICATION__NODE = eINSTANCE.getNodeSpecification_Node();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_SPECIFICATION__SIZE = eINSTANCE.getNodeSpecification_Size();

    /**
     * The meta object literal for the '<em><b>Sub Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_SPECIFICATION__SUB_ORDER = eINSTANCE.getNodeSpecification_SubOrder();

    /**
     * The meta object literal for the '<em><b>Joker</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_SPECIFICATION__JOKER = eINSTANCE.getNodeSpecification_Joker();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.ArithmeticOperator
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getArithmeticOperator()
     * @generated
     */
    EEnum ARITHMETIC_OPERATOR = eINSTANCE.getArithmeticOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.TemporalOperator <em>Temporal Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.TemporalOperator
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTemporalOperator()
     * @generated
     */
    EEnum TEMPORAL_OPERATOR = eINSTANCE.getTemporalOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.testLang.TemporalQuantifier <em>Temporal Quantifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.testLang.TemporalQuantifier
     * @see org.modelexecution.fumltesting.testLang.impl.TestLangPackageImpl#getTemporalQuantifier()
     * @generated
     */
    EEnum TEMPORAL_QUANTIFIER = eINSTANCE.getTemporalQuantifier();

  }

} //TestLangPackage
