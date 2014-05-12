/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.convert.TestDataConverter;
import org.modelexecution.fumltesting.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.execution.OclExecutor;
import org.modelexecution.fumltesting.results.ConstraintResult;
import org.modelexecution.fumltesting.results.StateAssertionResult;
import org.modelexecution.fumltesting.results.StateExpressionResult;
import org.modelexecution.fumltesting.sequence.State;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.TestLangFactory;
import org.modelexecution.fumltesting.testLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.testLang.UMLArithmeticOperator;
import org.modelexecution.fumltesting.testLang.UMLCheck;
import org.modelexecution.fumltesting.testLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.testLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.testLang.UMLObjectValue;
import org.modelexecution.fumltesting.testLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.testLang.UMLSimpleValue;
import org.modelexecution.fumltesting.testLang.UMLStateAssertion;
import org.modelexecution.fumltesting.testLang.UMLStateExpression;
import org.modelexecution.fumltesting.testLang.UMLTemporalOperator;
import org.modelexecution.fumltesting.testLang.UMLTemporalQuantifier;
import org.modelexecution.fumltesting.testLang.UMLTestCase;
import org.modelexecution.fumltesting.trace.SnapshotUtil;
import org.modelexecution.fumltesting.trace.TraceUtil;

import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fUML.Syntax.Actions.BasicActions.Action;
import fUML.Syntax.Actions.BasicActions.InputPin;
import fUML.Syntax.Actions.BasicActions.OutputPin;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Activities.IntermediateActivities.ActivityParameterNode;
import fUML.Syntax.Activities.IntermediateActivities.ObjectNode;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.ParameterDirectionKind;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * Utility class for state assertion validation.
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class StateAssertionValidator {
	private TestDataConverter testDataConverter;
	private TraceUtil traceUtil;
	private SnapshotUtil snapshotUtil;
	private List<ValueSnapshot> relevantSnapshots;

	private ActivityNodeExecution referenceActionExecution;
	private ActivityNodeExecution untilActionExecution;

	private AssertionPrinter assertionPrinter;

	public StateAssertionValidator(TraceUtil traceUtil, TestDataConverter testDataConverter) {
		this.testDataConverter = testDataConverter;
		this.traceUtil = traceUtil;
		snapshotUtil = new SnapshotUtil(traceUtil);
		assertionPrinter = new AssertionPrinter(traceUtil.getModelConverter());
	}

	public StateAssertionResult check(UMLStateAssertion assertion) {
		assertionPrinter.printStateAssertion(assertion);
		StateAssertionResult result = new StateAssertionResult(assertion);
		List<State> states = new ArrayList<State>();

		try {
			referenceActionExecution = traceUtil.getReferenceActionExecution(assertion);
			untilActionExecution = traceUtil.getUntilActionExecution(assertion);
			states = traceUtil.getStates(assertion);
		} catch (ConstraintNotFoundException e) {
			System.out.println(e.getMessage());
			result.setError(e.getMessage());
			return result;
		}

		if (states.size() == 0) {
			System.out.println("There are no states for a given constraint.");
			result.setError("There are no states for a given constraint.");
			return result;
		}

		if (assertion.getChecks() != null && assertion.getChecks().size() > 0) {
			for (UMLCheck check : assertion.getChecks()) {
				if (check instanceof UMLConstraintCheck) {
					ArrayList<Boolean> results = new ArrayList<Boolean>();
					for (XExpression constraintName : ((UMLConstraintCheck) check).getConstraintNames()) {
						String name = ((XStringLiteral) constraintName).getValue();
						ValueInstance context = null;
						if (((UMLConstraintCheck) check).getObject() != null) {
							Object nodeExecution = traceUtil.getExecution(((UMLConstraintCheck) check).getObject().eContainer());
							ObjectNode objectNode = traceUtil.getModelConverter().convertPin(((UMLConstraintCheck) check).getObject());
							context = traceUtil.getValueInstance(objectNode, nodeExecution);
						}
						ConstraintResult constraintResult = new ConstraintResult(name, assertion);
						for (State state : states) {
							boolean constraintResultInSingleState = false;
							try {
								constraintResultInSingleState = OclExecutor.getInstance().checkConstraint(name, context, state);
							} catch (ConstraintNotFoundException e) {
								System.out.println(e.getMessage());
								result.setError(e.getMessage());
								constraintResult.setValidationResult(false);
								return result;
							}
							results.add(constraintResultInSingleState);
							constraintResult.putStateResult(state, constraintResultInSingleState);
						}
						boolean overallResult = compileResult(results, assertion.getQuantifier());
						results.removeAll(results);
						constraintResult.setValidationResult(overallResult);
						result.addConstraintResult(constraintResult);

						if (overallResult == false) {
							System.out.println("Constraint " + ((XStringLiteral) constraintName).getValue() + " validation failed!");
						} else {
							System.out.println("Constraint validation success.");
						}
					}
				}
			}
		}

		for (UMLCheck check : assertion.getChecks()) {
			if (check instanceof UMLStateExpression) {
				result.addExpressionResult(checkExpression((UMLStateExpression) check));
			}
		}

		assertionPrinter.printStartEnd();
		return result;
	}

	public StateAssertionResult check(FinallyStateAssertion assertion) {
		System.out.println("Finally state assertion validation..");
		UMLStateAssertion stateAssertion = TestLangFactory.eINSTANCE.createUMLStateAssertion();

		stateAssertion.setQuantifier(UMLTemporalQuantifier.ALWAYS);
		stateAssertion.setOperator(UMLTemporalOperator.AFTER);

		UMLActionReferencePoint point = TestLangFactory.eINSTANCE.createUMLActionReferencePoint();
		// TODO abstract from UML
		point.setAction((org.eclipse.uml2.uml.Action) traceUtil.getModelConverter().getOriginal(traceUtil.getLastExecutedAction()));
		stateAssertion.setReferencePoint(point);

		stateAssertion.getChecks().addAll(assertion.getChecks());
		// add the replacement state assertion instead of the finally assertion
		((UMLTestCase) assertion.eContainer()).getAssertions().add(stateAssertion);
		((UMLTestCase) assertion.eContainer()).getAssertions().remove(assertion);

		return check(stateAssertion);
	}

	private StateExpressionResult checkExpression(UMLStateExpression expression) {
		StateExpressionResult result = new StateExpressionResult(expression);
		relevantSnapshots = snapshotUtil.getRelevantSnapshots(expression, referenceActionExecution, untilActionExecution);

		if (expression.getValue() instanceof UMLSimpleValue) {
			// special case
			if (expression instanceof UMLPropertyStateExpression
					&& ((Property) convertElement(((UMLPropertyStateExpression) expression).getProperty())).owner != ((ObjectNode) convertElement(expression
							.getPin())).typedElement.type) {
				result.setValidationResult(processObject(expression));
			} else {
				result.setValidationResult(processValue(expression));
			}
			assertionPrinter.print(expression, result.getValidationResult());
			return result;
		} else if (expression.getValue() instanceof UMLObjectValue) {
			result.setValidationResult(processObject(expression));
			assertionPrinter.print(expression, result.getValidationResult());
			return result;
		} else {
			result.setValidationResult(false);
			result.setError("Type of specified value is not allowed!");
			assertionPrinter.print(expression, result.getValidationResult());
			return result;
		}

	}

	private boolean processValue(UMLStateExpression expression) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		UMLSimpleValue simpleValue = (UMLSimpleValue) expression.getValue();

		if (relevantSnapshots.size() == 0) {
			if (simpleValue.getValue() instanceof XNullLiteral && expression.getOperator() == UMLArithmeticOperator.EQUAL)
				results.add(true);
			else
				return false;
		}

		for (ValueSnapshot snapshot : relevantSnapshots) {
			if (expression instanceof UMLPropertyStateExpression) {
				Object_ object = (Object_) snapshot.getValue();
				for (FeatureValue featureValue : object.featureValues) {
					String featureName = featureValue.feature.name;
					Property property = (Property) convertElement(((UMLPropertyStateExpression) expression).getProperty());
					String targetFeatureName = property.name;
					if (featureName.equals(targetFeatureName)) {
						if (featureValue.values.size() > 0) {
							if (simpleValue.getValue() instanceof XStringLiteral) {
								String target = ((XStringLiteral) simpleValue.getValue()).getValue();
								String value = ((StringValue) featureValue.values.get(0)).value;
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								break;
							}
							if (simpleValue.getValue() instanceof XBooleanLiteral) {
								Boolean target = ((XBooleanLiteral) simpleValue.getValue()).isIsTrue();
								Boolean value = ((BooleanValue) featureValue.values.get(0)).value;
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								break;
							}
							if (simpleValue.getValue() instanceof XNumberLiteral) {
								Double target = Double.valueOf(((XNumberLiteral) simpleValue.getValue()).getValue());
								Double value = 0.0;
								if (featureValue.values.get(0) instanceof IntegerValue)
									value = Double.valueOf(((IntegerValue) featureValue.values.get(0)).value);
								if (featureValue.values.get(0) instanceof UnlimitedNaturalValue)
									value = Double.valueOf(((UnlimitedNaturalValue) featureValue.values.get(0)).value.naturalValue);
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								break;
							}
						} else {
							if (simpleValue.getValue() instanceof XNullLiteral) {
								if (expression.getOperator() == UMLArithmeticOperator.EQUAL)
									if (featureValue.values.size() != 0) {
										results.add(false);
									} else {
										results.add(true);
									}
								if (expression.getOperator() == UMLArithmeticOperator.NOT_EQUAL)
									if (featureValue.values.size() == 0) {
										results.add(false);
									} else {
										results.add(true);
									}
							} else {
								results.add(false);
							}
						}
					}
				}
			}
			if (expression instanceof UMLObjectStateExpression) {
				if (simpleValue.getValue() instanceof XStringLiteral) {
					String target = ((XStringLiteral) simpleValue.getValue()).getValue();
					String value = ((StringValue) snapshot.getValue()).value;
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
				}
				if (simpleValue.getValue() instanceof XBooleanLiteral) {
					Boolean target = ((XBooleanLiteral) simpleValue.getValue()).isIsTrue();
					Boolean value = ((BooleanValue) snapshot.getValue()).value;
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
				}
				if (simpleValue.getValue() instanceof XNumberLiteral) {
					Double target = Double.valueOf(((XNumberLiteral) simpleValue.getValue()).getValue());
					Double value = 0.0;
					if (snapshot.getValue() instanceof IntegerValue)
						value = Double.valueOf(((IntegerValue) snapshot.getValue()).value);
					if (snapshot.getValue() instanceof UnlimitedNaturalValue)
						value = Double.valueOf(((UnlimitedNaturalValue) snapshot.getValue()).value.naturalValue);
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
				}
				if (simpleValue.getValue() instanceof XNullLiteral) {
					if (expression.getOperator() == UMLArithmeticOperator.EQUAL)
						if (relevantSnapshots.size() != 0) {// at the beginning
															// everything
							// was equal to null
							if (((UMLStateAssertion) expression.eContainer()).getQuantifier() == UMLTemporalQuantifier.SOMETIMES
									&& ((UMLStateAssertion) expression.eContainer()).getOperator() == UMLTemporalOperator.UNTIL)
								results.add(true);
							else
								results.add(false);
						} else {
							results.add(true);
						}
					if (expression.getOperator() == UMLArithmeticOperator.NOT_EQUAL)
						if (relevantSnapshots.size() == 0) {
							results.add(false);
						} else {
							results.add(true);
						}
				}
			}
		}
		return compileResult(results, ((UMLStateAssertion) expression.eContainer()).getQuantifier());
	}

	private boolean processObject(UMLStateExpression expression) {
		if (expression.getOperator() != UMLArithmeticOperator.EQUAL && expression.getOperator() != UMLArithmeticOperator.NOT_EQUAL
				&& expression.getOperator() != UMLArithmeticOperator.INCLUDES && expression.getOperator() != UMLArithmeticOperator.EXCLUDES) {
			System.out.println("Operator <, >, <=, and => not allowed!");
			return false;
		}
		Object_ fumlTarget = (Object_) testDataConverter.getFUMLElement(expression.getValue());

		if (expression instanceof UMLObjectStateExpression) {
			return processStateExpression((UMLObjectStateExpression) expression, fumlTarget);
		}
		// link validation
		if (expression instanceof UMLPropertyStateExpression) {
			return processStateExpression((UMLPropertyStateExpression) expression, fumlTarget);
		}
		return false;
	}

	private boolean processStateExpression(UMLObjectStateExpression expression, Object_ fumlTarget) {
		boolean sameType = false;
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		for (ValueSnapshot snapshot : relevantSnapshots) {
			Object_ object_ = (Object_) snapshot.getValue();

			// compare types
			search: for (Class_ class_ : object_.types) {
				for (Class_ targetClass_ : fumlTarget.types) {
					if (class_.qualifiedName.equals(targetClass_.qualifiedName))
						sameType = true;
					break search;
				}
			}
			if (sameType == false)
				return false;

			// compare each feature
			for (FeatureValue featureValue : object_.featureValues) {
				if (expression.getOperator() == UMLArithmeticOperator.EQUAL) {
					for (FeatureValue targetFeatureValue : fumlTarget.featureValues) {
						if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
							boolean result = compare(targetFeatureValue, featureValue);
							results.add(result);
						}
					}
				}
				if (expression.getOperator() == UMLArithmeticOperator.NOT_EQUAL) {
					for (FeatureValue targetFeatureValue : fumlTarget.featureValues) {
						if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
							boolean result = compare(targetFeatureValue, featureValue) == false;
							results.add(result);
						}
					}
				}
			}
		}
		return compileResult(results, ((UMLStateAssertion) expression.eContainer()).getQuantifier());
	}

	private boolean processStateExpression(UMLPropertyStateExpression expression, Object_ fumlTarget) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		List<ValueInstance> links = new ArrayList<ValueInstance>();

		UMLStateAssertion assertion = (UMLStateAssertion) expression.eContainer();
		UMLTemporalOperator operator = assertion.getOperator();

		UMLPropertyStateExpression propertyExpression = (UMLPropertyStateExpression) expression;
		Property property = (Property) convertElement(propertyExpression.getProperty());
		if (property.typedElement.type instanceof Class_) {

			ValueInstance source = null;
			ObjectNode pin = traceUtil.getModelConverter().convertPin(propertyExpression.getPin());
			Object pinOwner = traceUtil.getModelConverter().convertElement(propertyExpression.getPin().eContainer());

			if (pinOwner instanceof Action) {
				ActionExecution execution = (ActionExecution) traceUtil.getExecution(pinOwner);
				if (pin instanceof InputPin) {
					for (Input input : execution.getInputs()) {
						if (input.getInputPin().name.equals(pin.name))
							source = (ValueInstance) ((ValueSnapshot) input.getInputValues().get(0).getInputValueSnapshot()).eContainer();
					}
				}
				if (pin instanceof OutputPin) {
					for (Output output : execution.getOutputs()) {
						if (output.getOutputPin().name.equals(pin.name))
							source = (ValueInstance) ((ValueSnapshot) output.getOutputValues().get(0).getOutputValueSnapshot()).eContainer();
					}
				}
			}
			if (pinOwner instanceof Activity) {
				ActivityExecution execution = (ActivityExecution) traceUtil.getExecution(pinOwner);
				ActivityParameterNode parameterNode = (ActivityParameterNode) traceUtil.getModelConverter().convertElement(
						propertyExpression.getPin());
				if (parameterNode.parameter.direction == ParameterDirectionKind.out) {
					for (OutputParameterSetting output : execution.getActivityOutputs()) {
						if (output.getParameter().name.equals(parameterNode.name))
							source = (ValueInstance) ((ValueSnapshot) output.getParameterValues().get(0).getValueSnapshot()).eContainer();
					}
				}
				if (parameterNode.parameter.direction == ParameterDirectionKind.in) {
					for (InputParameterSetting input : execution.getActivityInputs()) {
						if (input.getParameter().name.equals(parameterNode.name))
							source = (ValueInstance) ((ValueSnapshot) input.getParameterValues().get(0).getValueSnapshot()).eContainer();
					}
				}
			}

			if (propertyExpression.getValue() instanceof UMLSimpleValue) {
				// this is the case where we might compare null to a link
				UMLSimpleValue value = (UMLSimpleValue) propertyExpression.getValue();
				if (!(value.getValue() instanceof XNullLiteral)) {
					System.out.println("For links only null is allowed!");
					return false;
				}
			}

			for (ValueInstance linkValueInstance : traceUtil.getAllLinks()) {
				Link link = (Link) linkValueInstance.getRuntimeValue();
				boolean sourceContained = false;
				if (link.type == property.association) {
					for (FeatureValue value : link.getFeatureValues()) {
						Reference reference = (Reference) value.values.get(0);
						for (ValueSnapshot snapshot : source.getSnapshots()) {
							if (snapshot.getValue() == reference.referent)
								sourceContained = true;
						}
					}
				}
				boolean isRelevantLink = true;
				switch (operator) {
				case AFTER:
					if (linkValueInstance.getDestroyer() != null && !traceUtil.isAfter(linkValueInstance.getDestroyer(), referenceActionExecution))
						isRelevantLink = false;
					if (linkValueInstance.getCreator() == untilActionExecution) {
						isRelevantLink = false;
					} else if (untilActionExecution != null && traceUtil.isAfter(linkValueInstance.getCreator(), untilActionExecution))
						isRelevantLink = false;
					break;
				case UNTIL:
					if (linkValueInstance.getCreator() == referenceActionExecution) {
						isRelevantLink = false;
					} else if (traceUtil.isAfter(linkValueInstance.getCreator(), referenceActionExecution))
						isRelevantLink = false;
					break;
				}
				if (sourceContained && isRelevantLink) {
					links.add(linkValueInstance);
				}
			}
		}

		if (fumlTarget != null) {
			if (links.size() == 0) {
				if (propertyExpression.getOperator() == UMLArithmeticOperator.INCLUDES)
					results.add(false);
				if (propertyExpression.getOperator() == UMLArithmeticOperator.EXCLUDES)
					results.add(true);
			} else {
				for (ValueInstance link : links) {
					Link theLink = (Link) link.getRuntimeValue();
					for (FeatureValue featureValue : theLink.featureValues) {
						if (featureValue.feature.name.equals(property.name)) {
							Object_ realValue = ((Reference) featureValue.values.get(0)).referent;
							for (FeatureValue targetValue : fumlTarget.featureValues) {
								for (FeatureValue checkedFeature : realValue.featureValues) {
									if (targetValue.feature.name.equals(checkedFeature.feature.name)) {
										if (expression.getOperator() == UMLArithmeticOperator.EQUAL
												|| expression.getOperator() == UMLArithmeticOperator.INCLUDES) {
											boolean result = compare(targetValue, checkedFeature);
											results.add(result);
										}
										if (expression.getOperator() == UMLArithmeticOperator.NOT_EQUAL
												|| expression.getOperator() == UMLArithmeticOperator.EXCLUDES) {
											boolean result = !compare(targetValue, checkedFeature);
											results.add(result);
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			UMLTemporalQuantifier quantifier = ((UMLStateAssertion) expression.eContainer()).getQuantifier();
			if (propertyExpression.getOperator() == UMLArithmeticOperator.EQUAL) {
				switch (quantifier) {
				case ALWAYS:
					if (links.size() > 0) {
						results.add(false);
					} else {
						results.add(true);
					}
					break;
				case EVENTUALLY:
					if (links.size() > 0) {
						for (ValueInstance linkInstance : links) {
							if (linkInstance.getDestroyer() != null
									&& (!traceUtil.isAfter(linkInstance.getDestroyer(), referenceActionExecution) || (untilActionExecution != null && !traceUtil
											.isAfter(linkInstance.getDestroyer(), untilActionExecution))))
								results.add(true);
							else {
								results.add(false);
							}
						}
					} else {
						results.add(true);
					}
					break;
				case IMMEDIATELY:
					if (links.size() > 0) {
						for (ValueInstance linkInstance : links) {
							if (traceUtil.isAfter(linkInstance.getCreator(), referenceActionExecution)
									|| (untilActionExecution != null && traceUtil.isAfter(linkInstance.getCreator(), untilActionExecution)))
								results.add(true);
							else {
								results.add(false);
							}
						}
					} else {
						results.add(true);
					}
					break;
				case SOMETIMES:
					if (links.size() > 0) {
						for (ValueInstance linkInstance : links) {
							if (traceUtil.isAfter(linkInstance.getCreator(), referenceActionExecution)
									|| (linkInstance.getDestroyer() != null && untilActionExecution != null && !traceUtil.isAfter(
											linkInstance.getDestroyer(), untilActionExecution)))
								results.add(true);
							else {
								results.add(false);
							}
						}
					} else {
						results.add(true);
					}
					break;
				}
			} else if (propertyExpression.getOperator() == UMLArithmeticOperator.NOT_EQUAL) {
				if (links.size() == 0)
					results.add(false);
				else
					results.add(true);
			}
		}
		return compileResult(results, ((UMLStateAssertion) expression.eContainer()).getQuantifier());
	}

	/**
	 * Compares all values for target and real feature values, and returns a
	 * result.
	 */
	private boolean compare(FeatureValue targetFeatureValue, FeatureValue featureValue) {
		if (targetFeatureValue.values.size() != featureValue.values.size()) {
			System.out.println("Feature " + targetFeatureValue.feature.name + " of compared objects contain different values!");
			return false;
		}
		Property property = (Property) targetFeatureValue.feature;
		if (property.association == null) {
			if (targetFeatureValue.values.size() == 0 && featureValue.values.size() == 0)
				return true;
			for (int i = 0; i < targetFeatureValue.values.size(); i++) {
				if (targetFeatureValue.values.get(i) instanceof StringValue) {
					StringValue targetValue = (StringValue) targetFeatureValue.values.get(i);
					StringValue value = (StringValue) featureValue.values.get(i);
					if (targetValue.equals(value))
						return true;
					else {
						System.out.println("Expected: " + targetValue + " Real value: " + value);
						return false;
					}
				}
				if (targetFeatureValue.values.get(i) instanceof IntegerValue) {
					IntegerValue targetValue = (IntegerValue) targetFeatureValue.values.get(i);
					IntegerValue value = (IntegerValue) featureValue.values.get(i);
					if (targetValue.value == value.value)
						return true;
					else {
						System.out.println("Expected: " + targetValue.value + " Real value: " + value.value);
						return false;
					}
				}
				if (targetFeatureValue.values.get(i) instanceof UnlimitedNaturalValue) {
					UnlimitedNaturalValue targetValue = (UnlimitedNaturalValue) targetFeatureValue.values.get(i);
					UnlimitedNaturalValue value = null;
					if (featureValue.values.get(i) instanceof UnlimitedNaturalValue) {
						value = (UnlimitedNaturalValue) featureValue.values.get(i);
					} else if (featureValue.values.get(i) instanceof IntegerValue) {
						value = new UnlimitedNaturalValue();
						value.type = ((IntegerValue) featureValue.values.get(i)).type;
						value.value = new UnlimitedNatural(((IntegerValue) featureValue.values.get(i)).value);
					}
					if (targetValue.value.naturalValue == value.value.naturalValue)
						return true;
					else {
						System.out.println("Expected: " + targetValue.value.naturalValue + " Real value: " + value.value.naturalValue);
						return false;
					}
				}
				if (targetFeatureValue.values.get(i) instanceof BooleanValue) {
					BooleanValue targetValue = (BooleanValue) targetFeatureValue.values.get(i);
					BooleanValue value = (BooleanValue) featureValue.values.get(i);
					if (targetValue.value == value.value)
						return true;
					else {
						System.out.println("Expected: " + targetValue.value + " Real value: " + value.value);
						return false;
					}
				}
			}
		} else {
			// link empty features are skipped
			return true;
		}
		return false;
	}

	/** Comparison of simple values: String, Boolean, Double */
	private boolean compareValues(UMLArithmeticOperator operator, Object value, Object target) {
		System.out.println("Expected value: " + target + " Real value: " + value);
		if (value instanceof String || value instanceof Boolean) {
			if (operator == UMLArithmeticOperator.EQUAL)
				if (!value.equals(target))
					return false;
			if (operator == UMLArithmeticOperator.NOT_EQUAL)
				if (value.equals(target))
					return false;
		}
		if (value instanceof Double) {
			if (operator == UMLArithmeticOperator.EQUAL)
				if (!value.equals(target))
					return false;
			if (operator ==UMLArithmeticOperator.NOT_EQUAL)
				if (value.equals(target))
					return false;
			if (operator == UMLArithmeticOperator.GREATER)
				if ((Double) value <= (Double) target)
					return false;
			if (operator == UMLArithmeticOperator.GREATER_EQUAL)
				if ((Double) value < (Double) target)
					return false;
			if (operator == UMLArithmeticOperator.SMALLER)
				if ((Double) value >= (Double) target)
					return false;
			if (operator == UMLArithmeticOperator.SMALLER_EQUAL)
				if ((Double) value > (Double) target)
					return false;
		}
		return true;
	}

	private boolean compileResult(ArrayList<Boolean> results, UMLTemporalQuantifier quantifier) {
		switch (quantifier) {
		case ALWAYS:
			for (boolean result : results) {
				if (result == false)
					return false;
			}
			return true;
		case EVENTUALLY:
			for (int i = results.size() - 1; i >= 0; i--) {
				if (results.get(i) == false) {
					for (int j = i + 1; j < results.size(); j++) {
						if (results.get(j) == false)
							return false;
					}
					return true;
				}
			}
		case IMMEDIATELY:
			return results.get(0);
		case SOMETIMES:
			for (boolean result : results) {
				if (result)
					return true;
			}
			return false;
		}
		return false;
	}

	private Object convertElement(Object element) {
		return traceUtil.getModelConverter().convertElement(element);
	}
}