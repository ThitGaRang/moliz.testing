/**
 */
package org.modelexecution.fumltesting.testLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.ActivityNode;

import org.eclipse.xtext.xbase.XExpression;

import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.TestLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl#getSubOrder <em>Sub Order</em>}</li>
 *   <li>{@link org.modelexecution.fumltesting.testLang.impl.NodeSpecificationImpl#getJoker <em>Joker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeSpecificationImpl extends MinimalEObjectImpl.Container implements NodeSpecification
{
  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected ActivityNode node;

  /**
   * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSize()
   * @generated
   * @ordered
   */
  protected XExpression size;

  /**
   * The cached value of the '{@link #getSubOrder() <em>Sub Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubOrder()
   * @generated
   * @ordered
   */
  protected NodeOrder subOrder;

  /**
   * The default value of the '{@link #getJoker() <em>Joker</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJoker()
   * @generated
   * @ordered
   */
  protected static final String JOKER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJoker() <em>Joker</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJoker()
   * @generated
   * @ordered
   */
  protected String joker = JOKER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeSpecificationImpl()
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
    return TestLangPackage.Literals.NODE_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityNode getNode()
  {
    if (node != null && node.eIsProxy())
    {
      InternalEObject oldNode = (InternalEObject)node;
      node = (ActivityNode)eResolveProxy(oldNode);
      if (node != oldNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestLangPackage.NODE_SPECIFICATION__NODE, oldNode, node));
      }
    }
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityNode basicGetNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(ActivityNode newNode)
  {
    ActivityNode oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__NODE, oldNode, node));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getSize()
  {
    return size;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSize(XExpression newSize, NotificationChain msgs)
  {
    XExpression oldSize = size;
    size = newSize;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__SIZE, oldSize, newSize);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSize(XExpression newSize)
  {
    if (newSize != size)
    {
      NotificationChain msgs = null;
      if (size != null)
        msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.NODE_SPECIFICATION__SIZE, null, msgs);
      if (newSize != null)
        msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.NODE_SPECIFICATION__SIZE, null, msgs);
      msgs = basicSetSize(newSize, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__SIZE, newSize, newSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeOrder getSubOrder()
  {
    return subOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubOrder(NodeOrder newSubOrder, NotificationChain msgs)
  {
    NodeOrder oldSubOrder = subOrder;
    subOrder = newSubOrder;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__SUB_ORDER, oldSubOrder, newSubOrder);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubOrder(NodeOrder newSubOrder)
  {
    if (newSubOrder != subOrder)
    {
      NotificationChain msgs = null;
      if (subOrder != null)
        msgs = ((InternalEObject)subOrder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.NODE_SPECIFICATION__SUB_ORDER, null, msgs);
      if (newSubOrder != null)
        msgs = ((InternalEObject)newSubOrder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestLangPackage.NODE_SPECIFICATION__SUB_ORDER, null, msgs);
      msgs = basicSetSubOrder(newSubOrder, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__SUB_ORDER, newSubOrder, newSubOrder));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJoker()
  {
    return joker;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJoker(String newJoker)
  {
    String oldJoker = joker;
    joker = newJoker;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestLangPackage.NODE_SPECIFICATION__JOKER, oldJoker, joker));
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
      case TestLangPackage.NODE_SPECIFICATION__SIZE:
        return basicSetSize(null, msgs);
      case TestLangPackage.NODE_SPECIFICATION__SUB_ORDER:
        return basicSetSubOrder(null, msgs);
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
      case TestLangPackage.NODE_SPECIFICATION__NODE:
        if (resolve) return getNode();
        return basicGetNode();
      case TestLangPackage.NODE_SPECIFICATION__SIZE:
        return getSize();
      case TestLangPackage.NODE_SPECIFICATION__SUB_ORDER:
        return getSubOrder();
      case TestLangPackage.NODE_SPECIFICATION__JOKER:
        return getJoker();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TestLangPackage.NODE_SPECIFICATION__NODE:
        setNode((ActivityNode)newValue);
        return;
      case TestLangPackage.NODE_SPECIFICATION__SIZE:
        setSize((XExpression)newValue);
        return;
      case TestLangPackage.NODE_SPECIFICATION__SUB_ORDER:
        setSubOrder((NodeOrder)newValue);
        return;
      case TestLangPackage.NODE_SPECIFICATION__JOKER:
        setJoker((String)newValue);
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
      case TestLangPackage.NODE_SPECIFICATION__NODE:
        setNode((ActivityNode)null);
        return;
      case TestLangPackage.NODE_SPECIFICATION__SIZE:
        setSize((XExpression)null);
        return;
      case TestLangPackage.NODE_SPECIFICATION__SUB_ORDER:
        setSubOrder((NodeOrder)null);
        return;
      case TestLangPackage.NODE_SPECIFICATION__JOKER:
        setJoker(JOKER_EDEFAULT);
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
      case TestLangPackage.NODE_SPECIFICATION__NODE:
        return node != null;
      case TestLangPackage.NODE_SPECIFICATION__SIZE:
        return size != null;
      case TestLangPackage.NODE_SPECIFICATION__SUB_ORDER:
        return subOrder != null;
      case TestLangPackage.NODE_SPECIFICATION__JOKER:
        return JOKER_EDEFAULT == null ? joker != null : !JOKER_EDEFAULT.equals(joker);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (joker: ");
    result.append(joker);
    result.append(')');
    return result.toString();
  }

} //NodeSpecificationImpl
