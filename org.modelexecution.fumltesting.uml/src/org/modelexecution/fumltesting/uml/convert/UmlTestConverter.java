/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.uml.convert;

import java.util.HashMap;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumltesting.core.convert.ModelConverter;
import org.modelexecution.fumltesting.core.convert.TestConverter;
import org.modelexecution.fumltesting.core.testlang.ActionReferencePoint;
import org.modelexecution.fumltesting.core.testlang.ActivityInput;
import org.modelexecution.fumltesting.core.testlang.ArithmeticOperator;
import org.modelexecution.fumltesting.core.testlang.Assertion;
import org.modelexecution.fumltesting.core.testlang.Attribute;
import org.modelexecution.fumltesting.core.testlang.BooleanValue;
import org.modelexecution.fumltesting.core.testlang.Check;
import org.modelexecution.fumltesting.core.testlang.ConstraintCheck;
import org.modelexecution.fumltesting.core.testlang.ConstraintReferencePoint;
import org.modelexecution.fumltesting.core.testlang.DoubleValue;
import org.modelexecution.fumltesting.core.testlang.FinallyStateAssertion;
import org.modelexecution.fumltesting.core.testlang.IntegerValue;
import org.modelexecution.fumltesting.core.testlang.Link;
import org.modelexecution.fumltesting.core.testlang.NodeOrder;
import org.modelexecution.fumltesting.core.testlang.NodeSpecification;
import org.modelexecution.fumltesting.core.testlang.NullValue;
import org.modelexecution.fumltesting.core.testlang.ObjectSpecification;
import org.modelexecution.fumltesting.core.testlang.ObjectStateExpression;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.OrderAssertion;
import org.modelexecution.fumltesting.core.testlang.PropertyStateExpression;
import org.modelexecution.fumltesting.core.testlang.ReferencePoint;
import org.modelexecution.fumltesting.core.testlang.Scenario;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.StringValue;
import org.modelexecution.fumltesting.core.testlang.TemporalOperator;
import org.modelexecution.fumltesting.core.testlang.TemporalQuantifier;
import org.modelexecution.fumltesting.core.testlang.TestCase;
import org.modelexecution.fumltesting.core.testlang.Value;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLLink;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLSimpleValue;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase;

import fUML.Syntax.Activities.IntermediateActivities.Activity;

/**
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class UmlTestConverter implements TestConverter {
	private ModelConverter modelConverter;
	private HashMap<UMLObjectSpecification, ObjectSpecification> mappedObjects;

	public UmlTestConverter(Object model) {
		this.modelConverter = new ModelConverter();
		modelConverter.setModelAndConvert(model);
		this.mappedObjects = new HashMap<UMLObjectSpecification, ObjectSpecification>();
	}

	@Override
	public ModelConverter getModelConverter() {
		return this.modelConverter;
	}

	@Override
	public Scenario convertScenario(Object aScenario) {
		Scenario scenario = new Scenario();
		UMLScenario umlScenario = (UMLScenario) aScenario;

		scenario.setName(umlScenario.getName());

		for (UMLObjectSpecification umlObjectSpecification : umlScenario.getObjects()) {
			ObjectSpecification objectSpecification = (ObjectSpecification) convertValue(umlObjectSpecification);
			objectSpecification.setContainer(scenario);
			scenario.addObject(objectSpecification);
		}

		for (UMLLink umlLink : umlScenario.getLinks()) {
			Link link = convertLink(umlLink);
			link.setContainer(scenario);
			scenario.addLink(convertLink(umlLink));
		}

		return scenario;
	}

	@Override
	public TestCase convertTestCase(Object aTestCase) {
		TestCase testCase = new TestCase();
		UMLTestCase umlTestCase = (UMLTestCase) aTestCase;

		Activity activityUT = modelConverter.convertActivity(umlTestCase.getActivityUnderTest());

		testCase.setName(umlTestCase.getName());
		testCase.setActivityUnderTest(activityUT);

		if (umlTestCase.getContextObject() != null) {
			testCase.setContextObject((ObjectSpecification) convertValue(umlTestCase.getContextObject()));
		}
		
		Scenario scenario = convertScenario(umlTestCase.getInitScenario());
		testCase.getScenarios().add(scenario);

		for (UMLActivityInput umlActivityInput : umlTestCase.getInputs()) {
			ActivityInput activityInput = new ActivityInput();
			activityInput.setParameter(modelConverter.convertActivityParameterNode(umlActivityInput.getParameter()));
			if (umlActivityInput.getValue() instanceof UMLSimpleValue) {
				activityInput.setValue((Value) convertValue((UMLSimpleValue) umlActivityInput.getValue()));
			} else if (umlActivityInput.getValue() instanceof UMLObjectValue) {
				ObjectValue objectValue = new ObjectValue((ObjectSpecification) convertValue(((UMLObjectValue) umlActivityInput.getValue()).getValue()));
				activityInput.setValue(objectValue);
			}
			testCase.addInput(activityInput);
		}

		for (UMLAssertion umlAssertion : umlTestCase.getAssertions()) {
			if (umlAssertion instanceof UMLOrderAssertion) {
				OrderAssertion assertion = (OrderAssertion) convertAssertion(umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
			if (umlAssertion instanceof UMLStateAssertion) {
				StateAssertion assertion = (StateAssertion) convertAssertion(umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
			if (umlAssertion instanceof UMLFinallyStateAssertion) {
				FinallyStateAssertion assertion = (FinallyStateAssertion) convertAssertion(umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
		}

		return testCase;
	}

	@Override
	public Object convertValue(Object aValue) {
		if (aValue instanceof UMLSimpleValue) {
			UMLSimpleValue umlSimpleValue = (UMLSimpleValue) aValue;

			if (umlSimpleValue.getValue() instanceof XNullLiteral) {
				return new NullValue();
			}
			if (umlSimpleValue.getValue() instanceof XStringLiteral) {
				StringValue stringValue = new StringValue();
				stringValue.setValue(((XStringLiteral) umlSimpleValue.getValue()).getValue());
				return stringValue;
			} else if (umlSimpleValue.getValue() instanceof XNumberLiteral) {
				String value = ((XNumberLiteral) umlSimpleValue.getValue()).getValue();
				if (value.contains(".")) {
					DoubleValue doubleValue = new DoubleValue();
					double convertedValue = Double.parseDouble(value);
					if (umlSimpleValue.isNegative())
						convertedValue = (-convertedValue);
					doubleValue.setValue(convertedValue);
					return doubleValue;
				} else {
					IntegerValue integerValue = new IntegerValue();
					int convertedValue = Integer.parseInt(value);
					if (umlSimpleValue.isNegative())
						convertedValue = (-convertedValue);
					integerValue.setValue(convertedValue);
					return integerValue;
				}
			} else if (umlSimpleValue.getValue() instanceof XBooleanLiteral) {
				BooleanValue booleanValue = new BooleanValue();
				booleanValue.setValue(((XBooleanLiteral) umlSimpleValue.getValue()).isIsTrue());
				return booleanValue;
			}
		} else if (aValue instanceof UMLObjectSpecification) {
			UMLObjectSpecification umlObjectSpecification = (UMLObjectSpecification) aValue;

			for (UMLObjectSpecification key : mappedObjects.keySet()) {
				if (key == umlObjectSpecification)
					return mappedObjects.get(key);
			}
			ObjectSpecification objectSpecification = new ObjectSpecification(null);

			objectSpecification.setName(umlObjectSpecification.getName());
			objectSpecification.setType(modelConverter.convertClass(umlObjectSpecification.getType()));

			for (UMLAttribute umlAttribute : umlObjectSpecification.getAttributes()) {
				Attribute attribute = new Attribute();
				attribute.setProperty(modelConverter.convertProperty(umlAttribute.getAtt()));
				if (umlAttribute.getValue() instanceof UMLObjectValue) {
					ObjectSpecification value = (ObjectSpecification) convertValue(((UMLObjectValue) umlAttribute.getValue()).getValue());
					attribute.setValue(new ObjectValue(value));
				} else if (umlAttribute.getValue() instanceof UMLSimpleValue) {
					attribute.setValue((Value) convertValue((UMLSimpleValue) umlAttribute.getValue()));
				}

				objectSpecification.addAttribute(attribute);
			}

			mappedObjects.put(umlObjectSpecification, objectSpecification);
			return objectSpecification;
		}
		return null;
	}

	@Override
	public Link convertLink(Object aLink) {
		Link link = new Link();
		UMLLink umlLink = (UMLLink) aLink;

		link.setAssociation(modelConverter.convertAssociation(umlLink.getAssoc()));

		link.setSourceProperty(modelConverter.convertProperty(umlLink.getSourceProperty()));
		link.setSourceValue((ObjectSpecification) convertValue(umlLink.getSourceValue()));

		link.setTargetProperty(modelConverter.convertProperty(umlLink.getTargetProperty()));
		link.setTargetValue((ObjectSpecification) convertValue(umlLink.getTargetValue()));

		return link;
	}

	@Override
	public Assertion convertAssertion(Object anAssertion) {
		if (anAssertion instanceof UMLOrderAssertion) {
			OrderAssertion orderAssertion = new OrderAssertion();
			UMLOrderAssertion umlOrderAssertion = (UMLOrderAssertion) anAssertion;
			orderAssertion.setOrder(convertNodeOrder(umlOrderAssertion.getOrder()));
			return orderAssertion;
		} else if (anAssertion instanceof UMLStateAssertion) {
			StateAssertion stateAssertion = new StateAssertion();
			UMLStateAssertion umlStateAssertion = (UMLStateAssertion) anAssertion;

			switch (umlStateAssertion.getOperator()) {
			case AFTER:
				stateAssertion.setOperator(TemporalOperator.AFTER);
				break;
			case UNTIL:
				stateAssertion.setOperator(TemporalOperator.UNTIL);
				break;
			}

			switch (umlStateAssertion.getQuantifier()) {
			case ALWAYS:
				stateAssertion.setQuantifier(TemporalQuantifier.ALWAYS);
				break;
			case EVENTUALLY:
				stateAssertion.setQuantifier(TemporalQuantifier.EVENTUALLY);
				break;
			case IMMEDIATELY:
				stateAssertion.setQuantifier(TemporalQuantifier.IMMEDIATELY);
				break;
			case SOMETIMES:
				stateAssertion.setQuantifier(TemporalQuantifier.SOMETIMES);
				break;
			}

			stateAssertion.setReferencePoint(convertReferencePoint(umlStateAssertion.getReferencePoint()));
			stateAssertion.setUntilPoint(convertReferencePoint(umlStateAssertion.getUntilPoint()));

			for (UMLCheck umlCheck : umlStateAssertion.getChecks()) {
				stateAssertion.addCheck(convertCheck(umlCheck));
			}

			return stateAssertion;
		} else if (anAssertion instanceof org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion) {
			FinallyStateAssertion finallyStateAssertion = new FinallyStateAssertion();
			org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion umlFinallyStateAssertion = (org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion) anAssertion;
			for (UMLCheck umlCheck : umlFinallyStateAssertion.getChecks()) {
				finallyStateAssertion.addCheck(convertCheck(umlCheck));
			}
			return finallyStateAssertion;
		}
		return null;
	}

	@Override
	public NodeOrder convertNodeOrder(Object aNodeOrder) {
		NodeOrder nodeOrder = new NodeOrder();
		UMLNodeOrder umlNodeOrder = (UMLNodeOrder) aNodeOrder;
		for (UMLNodeSpecification umlNodeSpecification : umlNodeOrder.getNodes()) {
			NodeSpecification nodeSpecification = new NodeSpecification();
			nodeSpecification.setJoker(umlNodeSpecification.getJoker());
			nodeSpecification.setNode(modelConverter.convertActivityNode(umlNodeSpecification.getNode()));
			if (umlNodeSpecification.getSize() != null)
				nodeSpecification.setSize(Integer.valueOf(((XNumberLiteral) umlNodeSpecification.getSize()).getValue()));
			if (umlNodeSpecification.getSubOrder() != null)
				nodeSpecification.setSubOrder(convertNodeOrder(umlNodeSpecification.getSubOrder()));
			nodeOrder.addNode(nodeSpecification);
		}
		return nodeOrder;
	}

	@Override
	public Check convertCheck(Object aCheck) {
		Check check = null;
		UMLCheck umlCheck = (UMLCheck) aCheck;

		if (umlCheck instanceof UMLStateExpression) {
			if (umlCheck instanceof UMLObjectStateExpression) {
				check = new ObjectStateExpression();
			} else if (umlCheck instanceof UMLPropertyStateExpression) {
				check = new PropertyStateExpression();
				((PropertyStateExpression) check).setProperty(modelConverter.convertProperty(((UMLPropertyStateExpression) umlCheck).getProperty()));
			}
			((StateExpression) check).setPin(modelConverter.convertPin(((UMLStateExpression) umlCheck).getPin()));

			if (((UMLStateExpression) umlCheck).getValue() instanceof UMLSimpleValue) {
				((StateExpression) check).setValue((Value) convertValue((UMLSimpleValue) ((UMLStateExpression) umlCheck).getValue()));
			} else if (((UMLStateExpression) umlCheck).getValue() instanceof UMLObjectValue) {
				ObjectSpecification objectSpecification = (ObjectSpecification) convertValue(((UMLObjectValue) ((UMLStateExpression) umlCheck).getValue())
						.getValue());
				((StateExpression) check).setValue(new ObjectValue(objectSpecification));
			}

			switch (((UMLStateExpression) umlCheck).getOperator()) {
			case EQUAL:
				((StateExpression) check).setOperator(ArithmeticOperator.EQUAL);
				break;
			case EXCLUDES:
				((StateExpression) check).setOperator(ArithmeticOperator.EXCLUDES);
				break;
			case GREATER:
				((StateExpression) check).setOperator(ArithmeticOperator.GREATER);
				break;
			case GREATER_EQUAL:
				((StateExpression) check).setOperator(ArithmeticOperator.GREATER_EQUAL);
				break;
			case INCLUDES:
				((StateExpression) check).setOperator(ArithmeticOperator.INCLUDES);
				break;
			case NOT_EQUAL:
				((StateExpression) check).setOperator(ArithmeticOperator.NOT_EQUAL);
				break;
			case SMALLER:
				((StateExpression) check).setOperator(ArithmeticOperator.SMALLER);
				break;
			case SMALLER_EQUAL:
				((StateExpression) check).setOperator(ArithmeticOperator.SMALLER_EQUAL);
				break;
			}
		} else if (umlCheck instanceof UMLConstraintCheck) {
			check = new ConstraintCheck();
			for (XExpression constraintName : ((UMLConstraintCheck) umlCheck).getConstraintNames()) {
				((ConstraintCheck) check).getConstraintNames().add(((XStringLiteral) constraintName).getValue());
			}
			if (((UMLConstraintCheck) umlCheck).getObject() != null)
				((ConstraintCheck) check).setObject(modelConverter.convertPin(((UMLConstraintCheck) umlCheck).getObject()));
		}
		return check;
	}

	@Override
	public ReferencePoint convertReferencePoint(Object umlReferencePoint) {
		ReferencePoint referencePoint = null;
		if (umlReferencePoint instanceof UMLActionReferencePoint) {
			referencePoint = new ActionReferencePoint();
			((ActionReferencePoint) referencePoint).setAction(modelConverter.convertAction(((UMLActionReferencePoint) umlReferencePoint).getAction()));
		}
		if (umlReferencePoint instanceof UMLConstraintReferencePoint) {
			referencePoint = new ConstraintReferencePoint();
			((ConstraintReferencePoint) referencePoint).setConstraintName(((XStringLiteral) ((UMLConstraintReferencePoint) umlReferencePoint)
					.getConstraintName()).getValue());
		}
		return referencePoint;
	}
}