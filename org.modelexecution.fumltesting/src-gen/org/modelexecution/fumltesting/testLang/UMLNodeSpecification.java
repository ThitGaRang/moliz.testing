/**
 */
package org.modelexecution.fumltesting.testLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.ActivityNode;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Node Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getNode <em>Node</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getSize <em>Size</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getSubOrder <em>Sub Order</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getJoker <em>Joker</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeSpecification()
 * @model
 * @generated
 */
public interface UMLNodeSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' reference.
   * @see #setNode(ActivityNode)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeSpecification_Node()
   * @model
   * @generated
   */
  ActivityNode getNode();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(ActivityNode value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' containment reference.
   * @see #setSize(XExpression)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeSpecification_Size()
   * @model containment="true"
   * @generated
   */
  XExpression getSize();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getSize <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' containment reference.
   * @see #getSize()
   * @generated
   */
  void setSize(XExpression value);

  /**
   * Returns the value of the '<em><b>Sub Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Order</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Order</em>' containment reference.
   * @see #setSubOrder(UMLNodeOrder)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeSpecification_SubOrder()
   * @model containment="true"
   * @generated
   */
  UMLNodeOrder getSubOrder();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getSubOrder <em>Sub Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Order</em>' containment reference.
   * @see #getSubOrder()
   * @generated
   */
  void setSubOrder(UMLNodeOrder value);

  /**
   * Returns the value of the '<em><b>Joker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Joker</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Joker</em>' attribute.
   * @see #setJoker(String)
   * @see org.modelexecution.fumltesting.testLang.TestLangPackage#getUMLNodeSpecification_Joker()
   * @model
   * @generated
   */
  String getJoker();

  /**
   * Sets the value of the '{@link org.modelexecution.fumltesting.testLang.UMLNodeSpecification#getJoker <em>Joker</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Joker</em>' attribute.
   * @see #getJoker()
   * @generated
   */
  void setJoker(String value);

} // UMLNodeSpecification
