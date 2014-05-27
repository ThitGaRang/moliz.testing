/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMOF Object Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getName <em>Name</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getType <em>Type</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFObjectSpecification()
 * @model
 * @generated
 */
public interface XMOFObjectSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFObjectSpecification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFObjectSpecification_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFObjectSpecification#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.modelexecution.fumltesting.xmof.xmofTestLang.XMOFAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage#getXMOFObjectSpecification_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<XMOFAttribute> getAttributes();

} // XMOFObjectSpecification
