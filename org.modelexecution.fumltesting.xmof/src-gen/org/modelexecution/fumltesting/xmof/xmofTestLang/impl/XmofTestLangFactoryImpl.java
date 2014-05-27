/**
 */
package org.modelexecution.fumltesting.xmof.xmofTestLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.modelexecution.fumltesting.xmof.xmofTestLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmofTestLangFactoryImpl extends EFactoryImpl implements XmofTestLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XmofTestLangFactory init()
  {
    try
    {
      XmofTestLangFactory theXmofTestLangFactory = (XmofTestLangFactory)EPackage.Registry.INSTANCE.getEFactory(XmofTestLangPackage.eNS_URI);
      if (theXmofTestLangFactory != null)
      {
        return theXmofTestLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XmofTestLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmofTestLangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XmofTestLangPackage.XMOF_TEST_SUITE: return createXMOFTestSuite();
      case XmofTestLangPackage.IMPORT: return createImport();
      case XmofTestLangPackage.XMOF_TEST_CASE: return createXMOFTestCase();
      case XmofTestLangPackage.XMOF_ACTIVITY_INPUT: return createXMOFActivityInput();
      case XmofTestLangPackage.XMOF_VALUE: return createXMOFValue();
      case XmofTestLangPackage.XMOF_SIMPLE_VALUE: return createXMOFSimpleValue();
      case XmofTestLangPackage.XMOF_OBJECT_VALUE: return createXMOFObjectValue();
      case XmofTestLangPackage.XMOF_SCENARIO: return createXMOFScenario();
      case XmofTestLangPackage.XMOF_OBJECT_SPECIFICATION: return createXMOFObjectSpecification();
      case XmofTestLangPackage.XMOF_ATTRIBUTE: return createXMOFAttribute();
      case XmofTestLangPackage.XMOF_LINK: return createXMOFLink();
      case XmofTestLangPackage.XMOF_ASSERTION: return createXMOFAssertion();
      case XmofTestLangPackage.XMOF_STATE_ASSERTION: return createXMOFStateAssertion();
      case XmofTestLangPackage.XMOF_REFERENCE_POINT: return createXMOFReferencePoint();
      case XmofTestLangPackage.XMOF_ACTION_REFERENCE_POINT: return createXMOFActionReferencePoint();
      case XmofTestLangPackage.XMOF_CONSTRAINT_REFERENCE_POINT: return createXMOFConstraintReferencePoint();
      case XmofTestLangPackage.XMOF_FINALLY_STATE_ASSERTION: return createXMOFFinallyStateAssertion();
      case XmofTestLangPackage.XMOF_CHECK: return createXMOFCheck();
      case XmofTestLangPackage.XMOF_CONSTRAINT_CHECK: return createXMOFConstraintCheck();
      case XmofTestLangPackage.XMOF_STATE_EXPRESSION: return createXMOFStateExpression();
      case XmofTestLangPackage.XMOF_OBJECT_STATE_EXPRESSION: return createXMOFObjectStateExpression();
      case XmofTestLangPackage.XMOF_PROPERTY_STATE_EXPRESSION: return createXMOFPropertyStateExpression();
      case XmofTestLangPackage.XMOF_ORDER_ASSERTION: return createXMOFOrderAssertion();
      case XmofTestLangPackage.XMOF_NODE_ORDER: return createXMOFNodeOrder();
      case XmofTestLangPackage.XMOF_NODE_SPECIFICATION: return createXMOFNodeSpecification();
      case XmofTestLangPackage.FINALLY_STATE_ASSERTION: return createFinallyStateAssertion();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case XmofTestLangPackage.XMOF_ARITHMETIC_OPERATOR:
        return createXMOFArithmeticOperatorFromString(eDataType, initialValue);
      case XmofTestLangPackage.XMOF_TEMPORAL_OPERATOR:
        return createXMOFTemporalOperatorFromString(eDataType, initialValue);
      case XmofTestLangPackage.XMOF_TEMPORAL_QUANTIFIER:
        return createXMOFTemporalQuantifierFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case XmofTestLangPackage.XMOF_ARITHMETIC_OPERATOR:
        return convertXMOFArithmeticOperatorToString(eDataType, instanceValue);
      case XmofTestLangPackage.XMOF_TEMPORAL_OPERATOR:
        return convertXMOFTemporalOperatorToString(eDataType, instanceValue);
      case XmofTestLangPackage.XMOF_TEMPORAL_QUANTIFIER:
        return convertXMOFTemporalQuantifierToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTestSuite createXMOFTestSuite()
  {
    XMOFTestSuiteImpl xmofTestSuite = new XMOFTestSuiteImpl();
    return xmofTestSuite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTestCase createXMOFTestCase()
  {
    XMOFTestCaseImpl xmofTestCase = new XMOFTestCaseImpl();
    return xmofTestCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFActivityInput createXMOFActivityInput()
  {
    XMOFActivityInputImpl xmofActivityInput = new XMOFActivityInputImpl();
    return xmofActivityInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFValue createXMOFValue()
  {
    XMOFValueImpl xmofValue = new XMOFValueImpl();
    return xmofValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFSimpleValue createXMOFSimpleValue()
  {
    XMOFSimpleValueImpl xmofSimpleValue = new XMOFSimpleValueImpl();
    return xmofSimpleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectValue createXMOFObjectValue()
  {
    XMOFObjectValueImpl xmofObjectValue = new XMOFObjectValueImpl();
    return xmofObjectValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFScenario createXMOFScenario()
  {
    XMOFScenarioImpl xmofScenario = new XMOFScenarioImpl();
    return xmofScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectSpecification createXMOFObjectSpecification()
  {
    XMOFObjectSpecificationImpl xmofObjectSpecification = new XMOFObjectSpecificationImpl();
    return xmofObjectSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFAttribute createXMOFAttribute()
  {
    XMOFAttributeImpl xmofAttribute = new XMOFAttributeImpl();
    return xmofAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFLink createXMOFLink()
  {
    XMOFLinkImpl xmofLink = new XMOFLinkImpl();
    return xmofLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFAssertion createXMOFAssertion()
  {
    XMOFAssertionImpl xmofAssertion = new XMOFAssertionImpl();
    return xmofAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFStateAssertion createXMOFStateAssertion()
  {
    XMOFStateAssertionImpl xmofStateAssertion = new XMOFStateAssertionImpl();
    return xmofStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFReferencePoint createXMOFReferencePoint()
  {
    XMOFReferencePointImpl xmofReferencePoint = new XMOFReferencePointImpl();
    return xmofReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFActionReferencePoint createXMOFActionReferencePoint()
  {
    XMOFActionReferencePointImpl xmofActionReferencePoint = new XMOFActionReferencePointImpl();
    return xmofActionReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFConstraintReferencePoint createXMOFConstraintReferencePoint()
  {
    XMOFConstraintReferencePointImpl xmofConstraintReferencePoint = new XMOFConstraintReferencePointImpl();
    return xmofConstraintReferencePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFFinallyStateAssertion createXMOFFinallyStateAssertion()
  {
    XMOFFinallyStateAssertionImpl xmofFinallyStateAssertion = new XMOFFinallyStateAssertionImpl();
    return xmofFinallyStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFCheck createXMOFCheck()
  {
    XMOFCheckImpl xmofCheck = new XMOFCheckImpl();
    return xmofCheck;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFConstraintCheck createXMOFConstraintCheck()
  {
    XMOFConstraintCheckImpl xmofConstraintCheck = new XMOFConstraintCheckImpl();
    return xmofConstraintCheck;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFStateExpression createXMOFStateExpression()
  {
    XMOFStateExpressionImpl xmofStateExpression = new XMOFStateExpressionImpl();
    return xmofStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFObjectStateExpression createXMOFObjectStateExpression()
  {
    XMOFObjectStateExpressionImpl xmofObjectStateExpression = new XMOFObjectStateExpressionImpl();
    return xmofObjectStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFPropertyStateExpression createXMOFPropertyStateExpression()
  {
    XMOFPropertyStateExpressionImpl xmofPropertyStateExpression = new XMOFPropertyStateExpressionImpl();
    return xmofPropertyStateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFOrderAssertion createXMOFOrderAssertion()
  {
    XMOFOrderAssertionImpl xmofOrderAssertion = new XMOFOrderAssertionImpl();
    return xmofOrderAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFNodeOrder createXMOFNodeOrder()
  {
    XMOFNodeOrderImpl xmofNodeOrder = new XMOFNodeOrderImpl();
    return xmofNodeOrder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFNodeSpecification createXMOFNodeSpecification()
  {
    XMOFNodeSpecificationImpl xmofNodeSpecification = new XMOFNodeSpecificationImpl();
    return xmofNodeSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinallyStateAssertion createFinallyStateAssertion()
  {
    FinallyStateAssertionImpl finallyStateAssertion = new FinallyStateAssertionImpl();
    return finallyStateAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFArithmeticOperator createXMOFArithmeticOperatorFromString(EDataType eDataType, String initialValue)
  {
    XMOFArithmeticOperator result = XMOFArithmeticOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXMOFArithmeticOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTemporalOperator createXMOFTemporalOperatorFromString(EDataType eDataType, String initialValue)
  {
    XMOFTemporalOperator result = XMOFTemporalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXMOFTemporalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMOFTemporalQuantifier createXMOFTemporalQuantifierFromString(EDataType eDataType, String initialValue)
  {
    XMOFTemporalQuantifier result = XMOFTemporalQuantifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertXMOFTemporalQuantifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmofTestLangPackage getXmofTestLangPackage()
  {
    return (XmofTestLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XmofTestLangPackage getPackage()
  {
    return XmofTestLangPackage.eINSTANCE;
  }

} //XmofTestLangFactoryImpl
