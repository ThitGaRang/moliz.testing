/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.convert;

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
import org.modelexecution.fumltesting.core.testlang.TestSuite;
import org.modelexecution.fumltesting.core.testlang.Value;
import org.modelexecution.fumltesting.testLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLActivityInput;
import org.modelexecution.fumltesting.testLang.UMLAssertion;
import org.modelexecution.fumltesting.testLang.UMLAttribute;
import org.modelexecution.fumltesting.testLang.UMLCheck;
import org.modelexecution.fumltesting.testLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.testLang.UMLConstraintReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLFinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.UMLLink;
import org.modelexecution.fumltesting.testLang.UMLNodeOrder;
import org.modelexecution.fumltesting.testLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.testLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.testLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.testLang.UMLObjectValue;
import org.modelexecution.fumltesting.testLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.testLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.testLang.UMLReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLScenario;
import org.modelexecution.fumltesting.testLang.UMLSimpleValue;
import org.modelexecution.fumltesting.testLang.UMLStateAssertion;
import org.modelexecution.fumltesting.testLang.UMLStateExpression;
import org.modelexecution.fumltesting.testLang.UMLTestCase;
import org.modelexecution.fumltesting.testLang.UMLTestSuite;

import fUML.Syntax.Activities.IntermediateActivities.Activity;

/**
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class UmlTestConverter implements TestConverter {
	private ModelConverter modelConverter;
	private HashMap<UMLObjectSpecification, ObjectSpecification> mappedObjects;
	private HashMap<UMLScenario, Scenario> mappedScenarios;

	public UmlTestConverter(Object model) {
		this.modelConverter = new ModelConverter();
		modelConverter.setModelAndConvert(model);
		this.mappedObjects = new HashMap<UMLObjectSpecification, ObjectSpecification>();
		this.mappedScenarios = new HashMap<UMLScenario, Scenario>();
	}

	@Override
	public ModelConverter getModelConverter() {
		return this.modelConverter;
	}

	@Override
	public TestSuite convertSuite(Object aSuite) {
		UMLTestSuite umlSuite = (UMLTestSuite) aSuite;
		TestSuite suite = new TestSuite();
		for (UMLScenario umlScenario : umlSuite.getScenarios()) {
			Scenario scenario = convertScenario(umlScenario);
			suite.addScenario(scenario);
			mappedScenarios.put(umlScenario, scenario);
		}
		for (UMLTestCase umlTestCase : umlSuite.getTests()) {
			suite.addTestCase(convertTestCase(umlTestCase));
		}
		return suite;
	}

	private Scenario convertScenario(UMLScenario umlScenario) {
		Scenario scenario = new Scenario();
		scenario.setName(umlScenario.getName());

		for (UMLObjectSpecification umlObjectSpecification : umlScenario.getObjects()) {
			ObjectSpecification objectSpecification = convertValue(umlObjectSpecification);
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

	private TestCase convertTestCase(UMLTestCase umlTestCase) {
		TestCase testCase = new TestCase();
		Activity activityUT = modelConverter.convertActivity(umlTestCase.getActivityUnderTest());

		testCase.setName(umlTestCase.getName());
		testCase.setActivityUnderTest(activityUT);

		if (umlTestCase.getContextObject() != null) {
			testCase.setContextObject(convertValue(umlTestCase.getContextObject()));
		}

		for (UMLActivityInput umlActivityInput : umlTestCase.getInputs()) {
			ActivityInput activityInput = new ActivityInput();
			activityInput.setParameter(modelConverter.convertActivityParameterNode(umlActivityInput.getParameter()));
			if (umlActivityInput.getValue() instanceof UMLSimpleValue) {
				activityInput.setValue(convertValue((UMLSimpleValue) umlActivityInput.getValue()));
			} else if (umlActivityInput.getValue() instanceof UMLObjectValue) {
				ObjectValue objectValue = new ObjectValue(convertValue(((UMLObjectValue) umlActivityInput.getValue()).getValue()));
				activityInput.setValue(objectValue);
			}
			testCase.addInput(activityInput);
		}

		for (UMLAssertion umlAssertion : umlTestCase.getAssertions()) {
			if (umlAssertion instanceof UMLOrderAssertion) {
				OrderAssertion assertion = convertAssertion((UMLOrderAssertion) umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
			if (umlAssertion instanceof UMLStateAssertion) {
				StateAssertion assertion = convertAssertion((UMLStateAssertion) umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
			if (umlAssertion instanceof UMLFinallyStateAssertion) {
				FinallyStateAssertion assertion = convertAssertion((org.modelexecution.fumltesting.testLang.FinallyStateAssertion) umlAssertion);
				assertion.setContainer(testCase);
				testCase.addAssertion(assertion);
			}
		}

		return testCase;
	}

	private Value convertValue(UMLSimpleValue umlSimpleValue) {
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
				doubleValue.setValue(Double.parseDouble(value));
				return doubleValue;
			} else {
				IntegerValue integerValue = new IntegerValue();
				integerValue.setValue(Integer.parseInt(value));
				return integerValue;
			}
		} else if (umlSimpleValue.getValue() instanceof XBooleanLiteral) {
			BooleanValue booleanValue = new BooleanValue();
			booleanValue.setValue(((XBooleanLiteral) umlSimpleValue.getValue()).isIsTrue());
			return booleanValue;
		}
		return null;
	}

	private ObjectSpecification convertValue(UMLObjectSpecification umlObjectSpecification) {
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
				ObjectSpecification value = convertValue(((UMLObjectValue) umlAttribute.getValue()).getValue());
				attribute.setValue(new ObjectValue(value));
			} else if (umlAttribute.getValue() instanceof UMLSimpleValue) {
				attribute.setValue(convertValue((UMLSimpleValue) umlAttribute.getValue()));
			}

			objectSpecification.addAttribute(attribute);
		}

		mappedObjects.put(umlObjectSpecification, objectSpecification);
		return objectSpecification;
	}

	private Link convertLink(UMLLink umlLink) {
		Link link = new Link();

		link.setAssociation(modelConverter.convertAssociation(umlLink.getAssoc()));

		link.setSourceProperty(modelConverter.convertProperty(umlLink.getSourceProperty()));
		link.setSourceValue(convertValue(umlLink.getSourceValue()));

		link.setTargetProperty(modelConverter.convertProperty(umlLink.getTargetProperty()));
		link.setTargetValue(convertValue(umlLink.getTargetValue()));

		return link;
	}

	private OrderAssertion convertAssertion(UMLOrderAssertion umlOrderAssertion) {
		OrderAssertion orderAssertion = new OrderAssertion();
		orderAssertion.setOrder(convertNodeOrder(umlOrderAssertion.getOrder()));
		return orderAssertion;
	}

	private NodeOrder convertNodeOrder(UMLNodeOrder umlNodeOrder) {
		NodeOrder nodeOrder = new NodeOrder();
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

	private StateAssertion convertAssertion(UMLStateAssertion umlStateAssertion) {
		StateAssertion stateAssertion = new StateAssertion();

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
	}

	private FinallyStateAssertion convertAssertion(org.modelexecution.fumltesting.testLang.FinallyStateAssertion umlFinallyStateAssertion) {
		FinallyStateAssertion finallyStateAssertion = new FinallyStateAssertion();
		for (UMLCheck umlCheck : umlFinallyStateAssertion.getChecks()) {
			finallyStateAssertion.addCheck(convertCheck(umlCheck));
		}
		return finallyStateAssertion;
	}

	private Check convertCheck(UMLCheck umlCheck) {
		Check check = null;
		if (umlCheck instanceof UMLStateExpression) {
			if (umlCheck instanceof UMLObjectStateExpression) {
				check = new ObjectStateExpression();
			} else if (umlCheck instanceof UMLPropertyStateExpression) {
				check = new PropertyStateExpression();
				((PropertyStateExpression) check).setProperty(modelConverter.convertProperty(((UMLPropertyStateExpression) umlCheck).getProperty()));
			}
			((StateExpression) check).setPin(modelConverter.convertPin(((UMLStateExpression) umlCheck).getPin()));

			if (((UMLStateExpression) umlCheck).getValue() instanceof UMLSimpleValue) {
				((StateExpression) check).setValue(convertValue((UMLSimpleValue) ((UMLStateExpression) umlCheck).getValue()));
			} else if (((UMLStateExpression) umlCheck).getValue() instanceof UMLObjectValue) {
				ObjectSpecification objectSpecification = convertValue(((UMLObjectValue) ((UMLStateExpression) umlCheck).getValue()).getValue());
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

	private ReferencePoint convertReferencePoint(UMLReferencePoint umlReferencePoint) {
		ReferencePoint referencePoint = null;
		if (umlReferencePoint instanceof UMLActionReferencePoint) {
			referencePoint = new ActionReferencePoint();
			((ActionReferencePoint) referencePoint)
					.setAction(modelConverter.convertAction(((UMLActionReferencePoint) umlReferencePoint).getAction()));
		}
		if (umlReferencePoint instanceof UMLConstraintReferencePoint) {
			referencePoint = new ConstraintReferencePoint();
			((ConstraintReferencePoint) referencePoint).setConstraintName(((XStringLiteral) ((UMLConstraintReferencePoint) umlReferencePoint)
					.getConstraintName()).getValue());
		}
		return referencePoint;
	}
}