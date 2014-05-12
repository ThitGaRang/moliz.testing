/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLLink#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLLink#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLLink#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLLink#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLLink#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink()
 * @model
 * @generated
 */
public interface UMLLink extends EObject
{
  /**
   * Returns the value of the '<em><b>Assoc</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assoc</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assoc</em>' reference.
   * @see #setAssoc(Association)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink_Assoc()
   * @model
   * @generated
   */
  Association getAssoc();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLLink#getAssoc <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assoc</em>' reference.
   * @see #getAssoc()
   * @generated
   */
  void setAssoc(Association value);

  /**
   * Returns the value of the '<em><b>Source Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Property</em>' reference.
   * @see #setSourceProperty(Property)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink_SourceProperty()
   * @model
   * @generated
   */
  Property getSourceProperty();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLLink#getSourceProperty <em>Source Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Property</em>' reference.
   * @see #getSourceProperty()
   * @generated
   */
  void setSourceProperty(Property value);

  /**
   * Returns the value of the '<em><b>Source Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Value</em>' reference.
   * @see #setSourceValue(UMLObjectSpecification)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink_SourceValue()
   * @model
   * @generated
   */
  UMLObjectSpecification getSourceValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLLink#getSourceValue <em>Source Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Value</em>' reference.
   * @see #getSourceValue()
   * @generated
   */
  void setSourceValue(UMLObjectSpecification value);

  /**
   * Returns the value of the '<em><b>Target Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Property</em>' reference.
   * @see #setTargetProperty(Property)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink_TargetProperty()
   * @model
   * @generated
   */
  Property getTargetProperty();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLLink#getTargetProperty <em>Target Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Property</em>' reference.
   * @see #getTargetProperty()
   * @generated
   */
  void setTargetProperty(Property value);

  /**
   * Returns the value of the '<em><b>Target Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Value</em>' reference.
   * @see #setTargetValue(UMLObjectSpecification)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLLink_TargetValue()
   * @model
   * @generated
   */
  UMLObjectSpecification getTargetValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLLink#getTargetValue <em>Target Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Value</em>' reference.
   * @see #getTargetValue()
   * @generated
   */
  void setTargetValue(UMLObjectSpecification value);

} // UMLLink
