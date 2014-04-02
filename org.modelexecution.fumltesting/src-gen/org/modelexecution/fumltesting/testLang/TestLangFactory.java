/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage
 * @generated
 */
public interface TestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestLangFactory eINSTANCE = org.modelexecution.fumltesting.testLang.impl.TestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Test Suite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Suite</em>'.
   * @generated
   */
  TestSuite createTestSuite();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Var Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Declaration</em>'.
   * @generated
   */
  VarDeclaration createVarDeclaration();

  /**
   * Returns a new object of class '<em>Test Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Case</em>'.
   * @generated
   */
  TestCase createTestCase();

  /**
   * Returns a new object of class '<em>Activity Input</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Input</em>'.
   * @generated
   */
  ActivityInput createActivityInput();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Simple Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Value</em>'.
   * @generated
   */
  SimpleValue createSimpleValue();

  /**
   * Returns a new object of class '<em>Object Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Value</em>'.
   * @generated
   */
  ObjectValue createObjectValue();

  /**
   * Returns a new object of class '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scenario</em>'.
   * @generated
   */
  Scenario createScenario();

  /**
   * Returns a new object of class '<em>Object Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Specification</em>'.
   * @generated
   */
  ObjectSpecification createObjectSpecification();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Link</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link</em>'.
   * @generated
   */
  Link createLink();

  /**
   * Returns a new object of class '<em>Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assertion</em>'.
   * @generated
   */
  Assertion createAssertion();

  /**
   * Returns a new object of class '<em>State Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Assertion</em>'.
   * @generated
   */
  StateAssertion createStateAssertion();

  /**
   * Returns a new object of class '<em>Reference Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Point</em>'.
   * @generated
   */
  ReferencePoint createReferencePoint();

  /**
   * Returns a new object of class '<em>Action Reference Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Reference Point</em>'.
   * @generated
   */
  ActionReferencePoint createActionReferencePoint();

  /**
   * Returns a new object of class '<em>Constraint Reference Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Reference Point</em>'.
   * @generated
   */
  ConstraintReferencePoint createConstraintReferencePoint();

  /**
   * Returns a new object of class '<em>Finally State Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Finally State Assertion</em>'.
   * @generated
   */
  FinallyStateAssertion createFinallyStateAssertion();

  /**
   * Returns a new object of class '<em>Check</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check</em>'.
   * @generated
   */
  Check createCheck();

  /**
   * Returns a new object of class '<em>Constraint Check</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Check</em>'.
   * @generated
   */
  ConstraintCheck createConstraintCheck();

  /**
   * Returns a new object of class '<em>State Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Expression</em>'.
   * @generated
   */
  StateExpression createStateExpression();

  /**
   * Returns a new object of class '<em>Object State Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object State Expression</em>'.
   * @generated
   */
  ObjectStateExpression createObjectStateExpression();

  /**
   * Returns a new object of class '<em>Property State Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property State Expression</em>'.
   * @generated
   */
  PropertyStateExpression createPropertyStateExpression();

  /**
   * Returns a new object of class '<em>Order Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Order Assertion</em>'.
   * @generated
   */
  OrderAssertion createOrderAssertion();

  /**
   * Returns a new object of class '<em>Node Order</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Order</em>'.
   * @generated
   */
  NodeOrder createNodeOrder();

  /**
   * Returns a new object of class '<em>Node Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Specification</em>'.
   * @generated
   */
  NodeSpecification createNodeSpecification();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TestLangPackage getTestLangPackage();

} //TestLangFactory
