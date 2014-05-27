/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink()
 * @model
 * @generated
 */
public interface XMOFLink extends EObject
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
   * @see #setAssoc(EReference)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink_Assoc()
   * @model
   * @generated
   */
  EReference getAssoc();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getAssoc <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assoc</em>' reference.
   * @see #getAssoc()
   * @generated
   */
  void setAssoc(EReference value);

  /**
   * Returns the value of the '<em><b>Source Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Property</em>' reference.
   * @see #setSourceProperty(EAttribute)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink_SourceProperty()
   * @model
   * @generated
   */
  EAttribute getSourceProperty();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceProperty <em>Source Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Property</em>' reference.
   * @see #getSourceProperty()
   * @generated
   */
  void setSourceProperty(EAttribute value);

  /**
   * Returns the value of the '<em><b>Source Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Value</em>' reference.
   * @see #setSourceValue(XMOFObjectSpecification)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink_SourceValue()
   * @model
   * @generated
   */
  XMOFObjectSpecification getSourceValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getSourceValue <em>Source Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Value</em>' reference.
   * @see #getSourceValue()
   * @generated
   */
  void setSourceValue(XMOFObjectSpecification value);

  /**
   * Returns the value of the '<em><b>Target Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Property</em>' reference.
   * @see #setTargetProperty(EAttribute)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink_TargetProperty()
   * @model
   * @generated
   */
  EAttribute getTargetProperty();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetProperty <em>Target Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Property</em>' reference.
   * @see #getTargetProperty()
   * @generated
   */
  void setTargetProperty(EAttribute value);

  /**
   * Returns the value of the '<em><b>Target Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Value</em>' reference.
   * @see #setTargetValue(XMOFObjectSpecification)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFLink_TargetValue()
   * @model
   * @generated
   */
  XMOFObjectSpecification getTargetValue();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFLink#getTargetValue <em>Target Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Value</em>' reference.
   * @see #getTargetValue()
   * @generated
   */
  void setTargetValue(XMOFObjectSpecification value);

} // XMOFLink
