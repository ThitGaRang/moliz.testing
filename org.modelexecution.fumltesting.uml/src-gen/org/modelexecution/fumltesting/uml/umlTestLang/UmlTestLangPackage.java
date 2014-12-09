/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

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
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangFactory
 * @model kind="package"
 * @generated
 */
public interface UmlTestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umlTestLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.modelexecution.org/fumltesting/uml/UmlTestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umlTestLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlTestLangPackage eINSTANCE = org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestSuiteImpl <em>UML Test Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestSuiteImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTestSuite()
   * @generated
   */
  int UML_TEST_SUITE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_SUITE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Scenarios</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_SUITE__SCENARIOS = 1;

  /**
   * The feature id for the '<em><b>Tests</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_SUITE__TESTS = 2;

  /**
   * The number of structural features of the '<em>UML Test Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_SUITE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.ImportImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getImport()
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
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestCaseImpl <em>UML Test Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestCaseImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTestCase()
   * @generated
   */
  int UML_TEST_CASE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__NAME = 0;

  /**
   * The feature id for the '<em><b>Activity Under Test</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__ACTIVITY_UNDER_TEST = 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__INPUTS = 2;

  /**
   * The feature id for the '<em><b>Context Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__CONTEXT_OBJECT = 3;

  /**
   * The feature id for the '<em><b>Init Scenarios</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__INIT_SCENARIOS = 4;

  /**
   * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE__ASSERTIONS = 5;

  /**
   * The number of structural features of the '<em>UML Test Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEST_CASE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActivityInputImpl <em>UML Activity Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActivityInputImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLActivityInput()
   * @generated
   */
  int UML_ACTIVITY_INPUT = 3;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ACTIVITY_INPUT__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ACTIVITY_INPUT__VALUE = 1;

  /**
   * The number of structural features of the '<em>UML Activity Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ACTIVITY_INPUT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLValueImpl <em>UML Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLValueImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLValue()
   * @generated
   */
  int UML_VALUE = 4;

  /**
   * The number of structural features of the '<em>UML Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLSimpleValueImpl <em>UML Simple Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLSimpleValueImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLSimpleValue()
   * @generated
   */
  int UML_SIMPLE_VALUE = 5;

  /**
   * The feature id for the '<em><b>Negative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SIMPLE_VALUE__NEGATIVE = UML_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SIMPLE_VALUE__VALUE = UML_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>UML Simple Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SIMPLE_VALUE_FEATURE_COUNT = UML_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectValueImpl <em>UML Object Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectValueImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectValue()
   * @generated
   */
  int UML_OBJECT_VALUE = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_VALUE__VALUE = UML_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Object Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_VALUE_FEATURE_COUNT = UML_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLScenarioImpl <em>UML Scenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLScenarioImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLScenario()
   * @generated
   */
  int UML_SCENARIO = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SCENARIO__NAME = 0;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SCENARIO__OBJECTS = 1;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SCENARIO__LINKS = 2;

  /**
   * The number of structural features of the '<em>UML Scenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_SCENARIO_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectSpecificationImpl <em>UML Object Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectSpecificationImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectSpecification()
   * @generated
   */
  int UML_OBJECT_SPECIFICATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_SPECIFICATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_SPECIFICATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_SPECIFICATION__ATTRIBUTES = 2;

  /**
   * The number of structural features of the '<em>UML Object Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl <em>UML Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLAttribute()
   * @generated
   */
  int UML_ATTRIBUTE = 9;

  /**
   * The feature id for the '<em><b>Att</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__ATT = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>UML Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLLinkImpl <em>UML Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLLinkImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLLink()
   * @generated
   */
  int UML_LINK = 10;

  /**
   * The feature id for the '<em><b>Assoc</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK__ASSOC = 0;

  /**
   * The feature id for the '<em><b>Source Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK__SOURCE_PROPERTY = 1;

  /**
   * The feature id for the '<em><b>Source Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK__SOURCE_VALUE = 2;

  /**
   * The feature id for the '<em><b>Target Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK__TARGET_PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Target Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK__TARGET_VALUE = 4;

  /**
   * The number of structural features of the '<em>UML Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LINK_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAssertionImpl <em>UML Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAssertionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLAssertion()
   * @generated
   */
  int UML_ASSERTION = 11;

  /**
   * The number of structural features of the '<em>UML Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSERTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateAssertionImpl <em>UML State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateAssertionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLStateAssertion()
   * @generated
   */
  int UML_STATE_ASSERTION = 12;

  /**
   * The feature id for the '<em><b>Quantifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION__QUANTIFIER = UML_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION__OPERATOR = UML_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reference Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION__REFERENCE_POINT = UML_ASSERTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Until Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION__UNTIL_POINT = UML_ASSERTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Checks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION__CHECKS = UML_ASSERTION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>UML State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_ASSERTION_FEATURE_COUNT = UML_ASSERTION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLReferencePointImpl <em>UML Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLReferencePointImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLReferencePoint()
   * @generated
   */
  int UML_REFERENCE_POINT = 13;

  /**
   * The number of structural features of the '<em>UML Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_REFERENCE_POINT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActionReferencePointImpl <em>UML Action Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActionReferencePointImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLActionReferencePoint()
   * @generated
   */
  int UML_ACTION_REFERENCE_POINT = 14;

  /**
   * The feature id for the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ACTION_REFERENCE_POINT__ACTION = UML_REFERENCE_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Action Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ACTION_REFERENCE_POINT_FEATURE_COUNT = UML_REFERENCE_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintReferencePointImpl <em>UML Constraint Reference Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintReferencePointImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLConstraintReferencePoint()
   * @generated
   */
  int UML_CONSTRAINT_REFERENCE_POINT = 15;

  /**
   * The feature id for the '<em><b>Constraint Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME = UML_REFERENCE_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Constraint Reference Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CONSTRAINT_REFERENCE_POINT_FEATURE_COUNT = UML_REFERENCE_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLFinallyStateAssertionImpl <em>UML Finally State Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLFinallyStateAssertionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLFinallyStateAssertion()
   * @generated
   */
  int UML_FINALLY_STATE_ASSERTION = 16;

  /**
   * The feature id for the '<em><b>Checks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_FINALLY_STATE_ASSERTION__CHECKS = UML_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Finally State Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_FINALLY_STATE_ASSERTION_FEATURE_COUNT = UML_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLCheckImpl <em>UML Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLCheckImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLCheck()
   * @generated
   */
  int UML_CHECK = 17;

  /**
   * The number of structural features of the '<em>UML Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CHECK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl <em>UML Constraint Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLConstraintCheck()
   * @generated
   */
  int UML_CONSTRAINT_CHECK = 18;

  /**
   * The feature id for the '<em><b>Constraint Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES = UML_CHECK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CONSTRAINT_CHECK__OBJECT = UML_CHECK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>UML Constraint Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CONSTRAINT_CHECK_FEATURE_COUNT = UML_CHECK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateExpressionImpl <em>UML State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateExpressionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLStateExpression()
   * @generated
   */
  int UML_STATE_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_EXPRESSION__PIN = UML_CHECK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_EXPRESSION__OPERATOR = UML_CHECK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_EXPRESSION__VALUE = UML_CHECK_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STATE_EXPRESSION_FEATURE_COUNT = UML_CHECK_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectStateExpressionImpl <em>UML Object State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectStateExpressionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectStateExpression()
   * @generated
   */
  int UML_OBJECT_STATE_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_STATE_EXPRESSION__PIN = UML_STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_STATE_EXPRESSION__OPERATOR = UML_STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_STATE_EXPRESSION__VALUE = UML_STATE_EXPRESSION__VALUE;

  /**
   * The number of structural features of the '<em>UML Object State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OBJECT_STATE_EXPRESSION_FEATURE_COUNT = UML_STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLPropertyStateExpressionImpl <em>UML Property State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLPropertyStateExpressionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLPropertyStateExpression()
   * @generated
   */
  int UML_PROPERTY_STATE_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Pin</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PROPERTY_STATE_EXPRESSION__PIN = UML_STATE_EXPRESSION__PIN;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PROPERTY_STATE_EXPRESSION__OPERATOR = UML_STATE_EXPRESSION__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PROPERTY_STATE_EXPRESSION__VALUE = UML_STATE_EXPRESSION__VALUE;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PROPERTY_STATE_EXPRESSION__PROPERTY = UML_STATE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Property State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PROPERTY_STATE_EXPRESSION_FEATURE_COUNT = UML_STATE_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLOrderAssertionImpl <em>UML Order Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLOrderAssertionImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLOrderAssertion()
   * @generated
   */
  int UML_ORDER_ASSERTION = 22;

  /**
   * The feature id for the '<em><b>Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ORDER_ASSERTION__ORDER = UML_ASSERTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Order Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ORDER_ASSERTION_FEATURE_COUNT = UML_ASSERTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeOrderImpl <em>UML Node Order</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeOrderImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLNodeOrder()
   * @generated
   */
  int UML_NODE_ORDER = 23;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_ORDER__NODES = 0;

  /**
   * The number of structural features of the '<em>UML Node Order</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_ORDER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeSpecificationImpl <em>UML Node Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeSpecificationImpl
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLNodeSpecification()
   * @generated
   */
  int UML_NODE_SPECIFICATION = 24;

  /**
   * The feature id for the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_SPECIFICATION__NODE = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_SPECIFICATION__SIZE = 1;

  /**
   * The feature id for the '<em><b>Sub Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_SPECIFICATION__SUB_ORDER = 2;

  /**
   * The feature id for the '<em><b>Joker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_SPECIFICATION__JOKER = 3;

  /**
   * The number of structural features of the '<em>UML Node Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NODE_SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator <em>UML Arithmetic Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLArithmeticOperator()
   * @generated
   */
  int UML_ARITHMETIC_OPERATOR = 25;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator <em>UML Temporal Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTemporalOperator()
   * @generated
   */
  int UML_TEMPORAL_OPERATOR = 26;

  /**
   * The meta object id for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier <em>UML Temporal Quantifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier
   * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTemporalQuantifier()
   * @generated
   */
  int UML_TEMPORAL_QUANTIFIER = 27;


  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite <em>UML Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Test Suite</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite
   * @generated
   */
  EClass getUMLTestSuite();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getImports()
   * @see #getUMLTestSuite()
   * @generated
   */
  EReference getUMLTestSuite_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getScenarios <em>Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenarios</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getScenarios()
   * @see #getUMLTestSuite()
   * @generated
   */
  EReference getUMLTestSuite_Scenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getTests <em>Tests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tests</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestSuite#getTests()
   * @see #getUMLTestSuite()
   * @generated
   */
  EReference getUMLTestSuite_Tests();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase <em>UML Test Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Test Case</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase
   * @generated
   */
  EClass getUMLTestCase();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getName()
   * @see #getUMLTestCase()
   * @generated
   */
  EAttribute getUMLTestCase_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getActivityUnderTest <em>Activity Under Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Activity Under Test</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getActivityUnderTest()
   * @see #getUMLTestCase()
   * @generated
   */
  EReference getUMLTestCase_ActivityUnderTest();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInputs()
   * @see #getUMLTestCase()
   * @generated
   */
  EReference getUMLTestCase_Inputs();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getContextObject <em>Context Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Context Object</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getContextObject()
   * @see #getUMLTestCase()
   * @generated
   */
  EReference getUMLTestCase_ContextObject();

  /**
   * Returns the meta object for the reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInitScenarios <em>Init Scenarios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Init Scenarios</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getInitScenarios()
   * @see #getUMLTestCase()
   * @generated
   */
  EReference getUMLTestCase_InitScenarios();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getAssertions <em>Assertions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assertions</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase#getAssertions()
   * @see #getUMLTestCase()
   * @generated
   */
  EReference getUMLTestCase_Assertions();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput <em>UML Activity Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Activity Input</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput
   * @generated
   */
  EClass getUMLActivityInput();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getParameter()
   * @see #getUMLActivityInput()
   * @generated
   */
  EReference getUMLActivityInput_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput#getValue()
   * @see #getUMLActivityInput()
   * @generated
   */
  EReference getUMLActivityInput_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLValue <em>UML Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLValue
   * @generated
   */
  EClass getUMLValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue <em>UML Simple Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Simple Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue
   * @generated
   */
  EClass getUMLSimpleValue();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue#isNegative <em>Negative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negative</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue#isNegative()
   * @see #getUMLSimpleValue()
   * @generated
   */
  EAttribute getUMLSimpleValue_Negative();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue#getValue()
   * @see #getUMLSimpleValue()
   * @generated
   */
  EReference getUMLSimpleValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue <em>UML Object Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Object Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue
   * @generated
   */
  EClass getUMLObjectValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue#getValue()
   * @see #getUMLObjectValue()
   * @generated
   */
  EReference getUMLObjectValue_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario <em>UML Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Scenario</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario
   * @generated
   */
  EClass getUMLScenario();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getName()
   * @see #getUMLScenario()
   * @generated
   */
  EAttribute getUMLScenario_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getObjects <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getObjects()
   * @see #getUMLScenario()
   * @generated
   */
  EReference getUMLScenario_Objects();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Links</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario#getLinks()
   * @see #getUMLScenario()
   * @generated
   */
  EReference getUMLScenario_Links();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification <em>UML Object Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Object Specification</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification
   * @generated
   */
  EClass getUMLObjectSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getName()
   * @see #getUMLObjectSpecification()
   * @generated
   */
  EAttribute getUMLObjectSpecification_Name();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getType()
   * @see #getUMLObjectSpecification()
   * @generated
   */
  EReference getUMLObjectSpecification_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification#getAttributes()
   * @see #getUMLObjectSpecification()
   * @generated
   */
  EReference getUMLObjectSpecification_Attributes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute <em>UML Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Attribute</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute
   * @generated
   */
  EClass getUMLAttribute();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute#getAtt <em>Att</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Att</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute#getAtt()
   * @see #getUMLAttribute()
   * @generated
   */
  EReference getUMLAttribute_Att();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute#getValue()
   * @see #getUMLAttribute()
   * @generated
   */
  EReference getUMLAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink <em>UML Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Link</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink
   * @generated
   */
  EClass getUMLLink();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getAssoc <em>Assoc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Assoc</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getAssoc()
   * @see #getUMLLink()
   * @generated
   */
  EReference getUMLLink_Assoc();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getSourceProperty <em>Source Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Property</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getSourceProperty()
   * @see #getUMLLink()
   * @generated
   */
  EReference getUMLLink_SourceProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getSourceValue <em>Source Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getSourceValue()
   * @see #getUMLLink()
   * @generated
   */
  EReference getUMLLink_SourceValue();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getTargetProperty <em>Target Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Property</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getTargetProperty()
   * @see #getUMLLink()
   * @generated
   */
  EReference getUMLLink_TargetProperty();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getTargetValue <em>Target Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLLink#getTargetValue()
   * @see #getUMLLink()
   * @generated
   */
  EReference getUMLLink_TargetValue();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion <em>UML Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Assertion</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion
   * @generated
   */
  EClass getUMLAssertion();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion <em>UML State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML State Assertion</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion
   * @generated
   */
  EClass getUMLStateAssertion();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getQuantifier <em>Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quantifier</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getQuantifier()
   * @see #getUMLStateAssertion()
   * @generated
   */
  EAttribute getUMLStateAssertion_Quantifier();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getOperator()
   * @see #getUMLStateAssertion()
   * @generated
   */
  EAttribute getUMLStateAssertion_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getReferencePoint <em>Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Point</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getReferencePoint()
   * @see #getUMLStateAssertion()
   * @generated
   */
  EReference getUMLStateAssertion_ReferencePoint();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getUntilPoint <em>Until Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Until Point</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getUntilPoint()
   * @see #getUMLStateAssertion()
   * @generated
   */
  EReference getUMLStateAssertion_UntilPoint();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getChecks <em>Checks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Checks</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion#getChecks()
   * @see #getUMLStateAssertion()
   * @generated
   */
  EReference getUMLStateAssertion_Checks();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLReferencePoint <em>UML Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Reference Point</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLReferencePoint
   * @generated
   */
  EClass getUMLReferencePoint();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint <em>UML Action Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Action Reference Point</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint
   * @generated
   */
  EClass getUMLActionReferencePoint();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Action</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint#getAction()
   * @see #getUMLActionReferencePoint()
   * @generated
   */
  EReference getUMLActionReferencePoint_Action();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint <em>UML Constraint Reference Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Constraint Reference Point</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint
   * @generated
   */
  EClass getUMLConstraintReferencePoint();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint#getConstraintName <em>Constraint Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint Name</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint#getConstraintName()
   * @see #getUMLConstraintReferencePoint()
   * @generated
   */
  EReference getUMLConstraintReferencePoint_ConstraintName();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion <em>UML Finally State Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Finally State Assertion</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion
   * @generated
   */
  EClass getUMLFinallyStateAssertion();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion#getChecks <em>Checks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Checks</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion#getChecks()
   * @see #getUMLFinallyStateAssertion()
   * @generated
   */
  EReference getUMLFinallyStateAssertion_Checks();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck <em>UML Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Check</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck
   * @generated
   */
  EClass getUMLCheck();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck <em>UML Constraint Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Constraint Check</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck
   * @generated
   */
  EClass getUMLConstraintCheck();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck#getConstraintNames <em>Constraint Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Names</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck#getConstraintNames()
   * @see #getUMLConstraintCheck()
   * @generated
   */
  EReference getUMLConstraintCheck_ConstraintNames();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck#getObject()
   * @see #getUMLConstraintCheck()
   * @generated
   */
  EReference getUMLConstraintCheck_Object();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression <em>UML State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML State Expression</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression
   * @generated
   */
  EClass getUMLStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getPin <em>Pin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Pin</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getPin()
   * @see #getUMLStateExpression()
   * @generated
   */
  EReference getUMLStateExpression_Pin();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getOperator()
   * @see #getUMLStateExpression()
   * @generated
   */
  EAttribute getUMLStateExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression#getValue()
   * @see #getUMLStateExpression()
   * @generated
   */
  EReference getUMLStateExpression_Value();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression <em>UML Object State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Object State Expression</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression
   * @generated
   */
  EClass getUMLObjectStateExpression();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression <em>UML Property State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Property State Expression</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression
   * @generated
   */
  EClass getUMLPropertyStateExpression();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression#getProperty()
   * @see #getUMLPropertyStateExpression()
   * @generated
   */
  EReference getUMLPropertyStateExpression_Property();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion <em>UML Order Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Order Assertion</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion
   * @generated
   */
  EClass getUMLOrderAssertion();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Order</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion#getOrder()
   * @see #getUMLOrderAssertion()
   * @generated
   */
  EReference getUMLOrderAssertion_Order();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder <em>UML Node Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Node Order</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder
   * @generated
   */
  EClass getUMLNodeOrder();

  /**
   * Returns the meta object for the containment reference list '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder#getNodes()
   * @see #getUMLNodeOrder()
   * @generated
   */
  EReference getUMLNodeOrder_Nodes();

  /**
   * Returns the meta object for class '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification <em>UML Node Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Node Specification</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification
   * @generated
   */
  EClass getUMLNodeSpecification();

  /**
   * Returns the meta object for the reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getNode()
   * @see #getUMLNodeSpecification()
   * @generated
   */
  EReference getUMLNodeSpecification_Node();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getSize()
   * @see #getUMLNodeSpecification()
   * @generated
   */
  EReference getUMLNodeSpecification_Size();

  /**
   * Returns the meta object for the containment reference '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getSubOrder <em>Sub Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Order</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getSubOrder()
   * @see #getUMLNodeSpecification()
   * @generated
   */
  EReference getUMLNodeSpecification_SubOrder();

  /**
   * Returns the meta object for the attribute '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getJoker <em>Joker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Joker</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification#getJoker()
   * @see #getUMLNodeSpecification()
   * @generated
   */
  EAttribute getUMLNodeSpecification_Joker();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator <em>UML Arithmetic Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Arithmetic Operator</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator
   * @generated
   */
  EEnum getUMLArithmeticOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator <em>UML Temporal Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Temporal Operator</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator
   * @generated
   */
  EEnum getUMLTemporalOperator();

  /**
   * Returns the meta object for enum '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier <em>UML Temporal Quantifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Temporal Quantifier</em>'.
   * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier
   * @generated
   */
  EEnum getUMLTemporalQuantifier();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmlTestLangFactory getUmlTestLangFactory();

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
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestSuiteImpl <em>UML Test Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestSuiteImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTestSuite()
     * @generated
     */
    EClass UML_TEST_SUITE = eINSTANCE.getUMLTestSuite();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_SUITE__IMPORTS = eINSTANCE.getUMLTestSuite_Imports();

    /**
     * The meta object literal for the '<em><b>Scenarios</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_SUITE__SCENARIOS = eINSTANCE.getUMLTestSuite_Scenarios();

    /**
     * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_SUITE__TESTS = eINSTANCE.getUMLTestSuite_Tests();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.ImportImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getImport()
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
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestCaseImpl <em>UML Test Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLTestCaseImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTestCase()
     * @generated
     */
    EClass UML_TEST_CASE = eINSTANCE.getUMLTestCase();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_TEST_CASE__NAME = eINSTANCE.getUMLTestCase_Name();

    /**
     * The meta object literal for the '<em><b>Activity Under Test</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_CASE__ACTIVITY_UNDER_TEST = eINSTANCE.getUMLTestCase_ActivityUnderTest();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_CASE__INPUTS = eINSTANCE.getUMLTestCase_Inputs();

    /**
     * The meta object literal for the '<em><b>Context Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_CASE__CONTEXT_OBJECT = eINSTANCE.getUMLTestCase_ContextObject();

    /**
     * The meta object literal for the '<em><b>Init Scenarios</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_CASE__INIT_SCENARIOS = eINSTANCE.getUMLTestCase_InitScenarios();

    /**
     * The meta object literal for the '<em><b>Assertions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEST_CASE__ASSERTIONS = eINSTANCE.getUMLTestCase_Assertions();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActivityInputImpl <em>UML Activity Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActivityInputImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLActivityInput()
     * @generated
     */
    EClass UML_ACTIVITY_INPUT = eINSTANCE.getUMLActivityInput();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ACTIVITY_INPUT__PARAMETER = eINSTANCE.getUMLActivityInput_Parameter();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ACTIVITY_INPUT__VALUE = eINSTANCE.getUMLActivityInput_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLValueImpl <em>UML Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLValueImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLValue()
     * @generated
     */
    EClass UML_VALUE = eINSTANCE.getUMLValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLSimpleValueImpl <em>UML Simple Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLSimpleValueImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLSimpleValue()
     * @generated
     */
    EClass UML_SIMPLE_VALUE = eINSTANCE.getUMLSimpleValue();

    /**
     * The meta object literal for the '<em><b>Negative</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_SIMPLE_VALUE__NEGATIVE = eINSTANCE.getUMLSimpleValue_Negative();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_SIMPLE_VALUE__VALUE = eINSTANCE.getUMLSimpleValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectValueImpl <em>UML Object Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectValueImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectValue()
     * @generated
     */
    EClass UML_OBJECT_VALUE = eINSTANCE.getUMLObjectValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OBJECT_VALUE__VALUE = eINSTANCE.getUMLObjectValue_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLScenarioImpl <em>UML Scenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLScenarioImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLScenario()
     * @generated
     */
    EClass UML_SCENARIO = eINSTANCE.getUMLScenario();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_SCENARIO__NAME = eINSTANCE.getUMLScenario_Name();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_SCENARIO__OBJECTS = eINSTANCE.getUMLScenario_Objects();

    /**
     * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_SCENARIO__LINKS = eINSTANCE.getUMLScenario_Links();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectSpecificationImpl <em>UML Object Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectSpecificationImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectSpecification()
     * @generated
     */
    EClass UML_OBJECT_SPECIFICATION = eINSTANCE.getUMLObjectSpecification();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_OBJECT_SPECIFICATION__NAME = eINSTANCE.getUMLObjectSpecification_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OBJECT_SPECIFICATION__TYPE = eINSTANCE.getUMLObjectSpecification_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OBJECT_SPECIFICATION__ATTRIBUTES = eINSTANCE.getUMLObjectSpecification_Attributes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl <em>UML Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAttributeImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLAttribute()
     * @generated
     */
    EClass UML_ATTRIBUTE = eINSTANCE.getUMLAttribute();

    /**
     * The meta object literal for the '<em><b>Att</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ATTRIBUTE__ATT = eINSTANCE.getUMLAttribute_Att();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ATTRIBUTE__VALUE = eINSTANCE.getUMLAttribute_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLLinkImpl <em>UML Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLLinkImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLLink()
     * @generated
     */
    EClass UML_LINK = eINSTANCE.getUMLLink();

    /**
     * The meta object literal for the '<em><b>Assoc</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LINK__ASSOC = eINSTANCE.getUMLLink_Assoc();

    /**
     * The meta object literal for the '<em><b>Source Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LINK__SOURCE_PROPERTY = eINSTANCE.getUMLLink_SourceProperty();

    /**
     * The meta object literal for the '<em><b>Source Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LINK__SOURCE_VALUE = eINSTANCE.getUMLLink_SourceValue();

    /**
     * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LINK__TARGET_PROPERTY = eINSTANCE.getUMLLink_TargetProperty();

    /**
     * The meta object literal for the '<em><b>Target Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LINK__TARGET_VALUE = eINSTANCE.getUMLLink_TargetValue();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAssertionImpl <em>UML Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLAssertionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLAssertion()
     * @generated
     */
    EClass UML_ASSERTION = eINSTANCE.getUMLAssertion();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateAssertionImpl <em>UML State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateAssertionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLStateAssertion()
     * @generated
     */
    EClass UML_STATE_ASSERTION = eINSTANCE.getUMLStateAssertion();

    /**
     * The meta object literal for the '<em><b>Quantifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_STATE_ASSERTION__QUANTIFIER = eINSTANCE.getUMLStateAssertion_Quantifier();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_STATE_ASSERTION__OPERATOR = eINSTANCE.getUMLStateAssertion_Operator();

    /**
     * The meta object literal for the '<em><b>Reference Point</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STATE_ASSERTION__REFERENCE_POINT = eINSTANCE.getUMLStateAssertion_ReferencePoint();

    /**
     * The meta object literal for the '<em><b>Until Point</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STATE_ASSERTION__UNTIL_POINT = eINSTANCE.getUMLStateAssertion_UntilPoint();

    /**
     * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STATE_ASSERTION__CHECKS = eINSTANCE.getUMLStateAssertion_Checks();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLReferencePointImpl <em>UML Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLReferencePointImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLReferencePoint()
     * @generated
     */
    EClass UML_REFERENCE_POINT = eINSTANCE.getUMLReferencePoint();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActionReferencePointImpl <em>UML Action Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLActionReferencePointImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLActionReferencePoint()
     * @generated
     */
    EClass UML_ACTION_REFERENCE_POINT = eINSTANCE.getUMLActionReferencePoint();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ACTION_REFERENCE_POINT__ACTION = eINSTANCE.getUMLActionReferencePoint_Action();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintReferencePointImpl <em>UML Constraint Reference Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintReferencePointImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLConstraintReferencePoint()
     * @generated
     */
    EClass UML_CONSTRAINT_REFERENCE_POINT = eINSTANCE.getUMLConstraintReferencePoint();

    /**
     * The meta object literal for the '<em><b>Constraint Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CONSTRAINT_REFERENCE_POINT__CONSTRAINT_NAME = eINSTANCE.getUMLConstraintReferencePoint_ConstraintName();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLFinallyStateAssertionImpl <em>UML Finally State Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLFinallyStateAssertionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLFinallyStateAssertion()
     * @generated
     */
    EClass UML_FINALLY_STATE_ASSERTION = eINSTANCE.getUMLFinallyStateAssertion();

    /**
     * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_FINALLY_STATE_ASSERTION__CHECKS = eINSTANCE.getUMLFinallyStateAssertion_Checks();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLCheckImpl <em>UML Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLCheckImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLCheck()
     * @generated
     */
    EClass UML_CHECK = eINSTANCE.getUMLCheck();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl <em>UML Constraint Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLConstraintCheckImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLConstraintCheck()
     * @generated
     */
    EClass UML_CONSTRAINT_CHECK = eINSTANCE.getUMLConstraintCheck();

    /**
     * The meta object literal for the '<em><b>Constraint Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CONSTRAINT_CHECK__CONSTRAINT_NAMES = eINSTANCE.getUMLConstraintCheck_ConstraintNames();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CONSTRAINT_CHECK__OBJECT = eINSTANCE.getUMLConstraintCheck_Object();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateExpressionImpl <em>UML State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLStateExpressionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLStateExpression()
     * @generated
     */
    EClass UML_STATE_EXPRESSION = eINSTANCE.getUMLStateExpression();

    /**
     * The meta object literal for the '<em><b>Pin</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STATE_EXPRESSION__PIN = eINSTANCE.getUMLStateExpression_Pin();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_STATE_EXPRESSION__OPERATOR = eINSTANCE.getUMLStateExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STATE_EXPRESSION__VALUE = eINSTANCE.getUMLStateExpression_Value();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectStateExpressionImpl <em>UML Object State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLObjectStateExpressionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLObjectStateExpression()
     * @generated
     */
    EClass UML_OBJECT_STATE_EXPRESSION = eINSTANCE.getUMLObjectStateExpression();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLPropertyStateExpressionImpl <em>UML Property State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLPropertyStateExpressionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLPropertyStateExpression()
     * @generated
     */
    EClass UML_PROPERTY_STATE_EXPRESSION = eINSTANCE.getUMLPropertyStateExpression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PROPERTY_STATE_EXPRESSION__PROPERTY = eINSTANCE.getUMLPropertyStateExpression_Property();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLOrderAssertionImpl <em>UML Order Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLOrderAssertionImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLOrderAssertion()
     * @generated
     */
    EClass UML_ORDER_ASSERTION = eINSTANCE.getUMLOrderAssertion();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ORDER_ASSERTION__ORDER = eINSTANCE.getUMLOrderAssertion_Order();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeOrderImpl <em>UML Node Order</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeOrderImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLNodeOrder()
     * @generated
     */
    EClass UML_NODE_ORDER = eINSTANCE.getUMLNodeOrder();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NODE_ORDER__NODES = eINSTANCE.getUMLNodeOrder_Nodes();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeSpecificationImpl <em>UML Node Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UMLNodeSpecificationImpl
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLNodeSpecification()
     * @generated
     */
    EClass UML_NODE_SPECIFICATION = eINSTANCE.getUMLNodeSpecification();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NODE_SPECIFICATION__NODE = eINSTANCE.getUMLNodeSpecification_Node();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NODE_SPECIFICATION__SIZE = eINSTANCE.getUMLNodeSpecification_Size();

    /**
     * The meta object literal for the '<em><b>Sub Order</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NODE_SPECIFICATION__SUB_ORDER = eINSTANCE.getUMLNodeSpecification_SubOrder();

    /**
     * The meta object literal for the '<em><b>Joker</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_NODE_SPECIFICATION__JOKER = eINSTANCE.getUMLNodeSpecification_Joker();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator <em>UML Arithmetic Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLArithmeticOperator
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLArithmeticOperator()
     * @generated
     */
    EEnum UML_ARITHMETIC_OPERATOR = eINSTANCE.getUMLArithmeticOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator <em>UML Temporal Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalOperator
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTemporalOperator()
     * @generated
     */
    EEnum UML_TEMPORAL_OPERATOR = eINSTANCE.getUMLTemporalOperator();

    /**
     * The meta object literal for the '{@link org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier <em>UML Temporal Quantifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.modelexecution.fumltesting.uml.umlTestLang.UMLTemporalQuantifier
     * @see org.modelexecution.fumltesting.uml.umlTestLang.impl.UmlTestLangPackageImpl#getUMLTemporalQuantifier()
     * @generated
     */
    EEnum UML_TEMPORAL_QUANTIFIER = eINSTANCE.getUMLTemporalQuantifier();

  }

} //UmlTestLangPackage
