/**
 */
package org.modelexecution.fumltesting.testLang.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TestLangXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLangXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    TestLangPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the TestLangResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new TestLangResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new TestLangResourceFactoryImpl());
    }
    return registrations;
  }

} //TestLangXMLProcessor
