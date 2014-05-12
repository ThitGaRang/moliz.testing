/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.modelexecution.fumltesting.testLang.Import;
import org.modelexecution.fumltesting.testLang.TestLangPackage;
import org.modelexecution.fumltesting.testLang.UMLScenario;
import org.modelexecution.fumltesting.testLang.UMLTestCase;
import org.modelexecution.fumltesting.testLang.UMLTestSuite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLTestSuiteImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLTestSuiteImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.UMLTestSuiteImpl#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLTestSuiteImpl extends MinimalEObjectImpl.Container implements UMLTestSuite
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarios()
   * @generated
   * @ordered
   */
  protected EList<UMLScenario> scenarios;

  /**
   * The cached value of the '{@link #getTests() <em>Tests</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTests()
   * @generated
   * @ordered
   */
  protected EList<UMLTestCase> tests;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLTestSuiteImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TestLangPackage.Literals.UML_TEST_SUITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, TestLangPackage.UML_TEST_SUITE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLScenario> getScenarios()
  {
    if (scenarios == null)
    {
      scenarios = new EObjectContainmentEList<UMLScenario>(UMLScenario.class, this, TestLangPackage.UML_TEST_SUITE__SCENARIOS);
    }
    return scenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTestCase> getTests()
  {
    if (tests == null)
    {
      tests = new EObjectContainmentEList<UMLTestCase>(UMLTestCase.class, this, TestLangPackage.UML_TEST_SUITE__TESTS);
    }
    return tests;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_TEST_SUITE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case TestLangPackage.UML_TEST_SUITE__SCENARIOS:
        return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
      case TestLangPackage.UML_TEST_SUITE__TESTS:
        return ((InternalEList<?>)getTests()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_TEST_SUITE__IMPORTS:
        return getImports();
      case TestLangPackage.UML_TEST_SUITE__SCENARIOS:
        return getScenarios();
      case TestLangPackage.UML_TEST_SUITE__TESTS:
        return getTests();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_TEST_SUITE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case TestLangPackage.UML_TEST_SUITE__SCENARIOS:
        getScenarios().clear();
        getScenarios().addAll((Collection<? extends UMLScenario>)newValue);
        return;
      case TestLangPackage.UML_TEST_SUITE__TESTS:
        getTests().clear();
        getTests().addAll((Collection<? extends UMLTestCase>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_TEST_SUITE__IMPORTS:
        getImports().clear();
        return;
      case TestLangPackage.UML_TEST_SUITE__SCENARIOS:
        getScenarios().clear();
        return;
      case TestLangPackage.UML_TEST_SUITE__TESTS:
        getTests().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TestLangPackage.UML_TEST_SUITE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case TestLangPackage.UML_TEST_SUITE__SCENARIOS:
        return scenarios != null && !scenarios.isEmpty();
      case TestLangPackage.UML_TEST_SUITE__TESTS:
        return tests != null && !tests.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLTestSuiteImpl
