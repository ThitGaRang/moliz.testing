/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlTestLangXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlTestLangXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UmlTestLangPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UmlTestLangResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new UmlTestLangResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UmlTestLangResourceFactoryImpl());
    }
    return registrations;
  }

} //UmlTestLangXMLProcessor
