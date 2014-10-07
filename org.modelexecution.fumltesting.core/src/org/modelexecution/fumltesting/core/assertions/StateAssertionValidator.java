/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.assertions;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.InputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.core.convert.TestDataConverter;
import org.modelexecution.fumltesting.core.exceptions.ActionNotExecutedException;
import org.modelexecution.fumltesting.core.exceptions.ConstraintNotFoundException;
import org.modelexecution.fumltesting.core.exceptions.ConstraintStateNotFoundException;
import org.modelexecution.fumltesting.core.exceptions.ConstraintsNotLoadedException;
import org.modelexecution.fumltesting.core.exceptions.ExpectedLinkValueException;
import org.modelexecution.fumltesting.core.execution.OclExecutor;
import org.modelexecution.fumltesting.core.results.ConstraintResult;
import org.modelexecution.fumltesting.core.results.StateAssertionResult;
import org.modelexecution.fumltesting.core.results.StateExpressionResult;
import org.modelexecution.fumltesting.core.sequence.State;
import org.modelexecution.fumltesting.core.testlang.ActionReferencePoint;
import org.modelexecution.fumltesting.core.testlang.ArithmeticOperator;
import org.modelexecution.fumltesting.core.testlang.Check;
import org.modelexecution.fumltesting.core.testlang.ConstraintCheck;
import org.modelexecution.fumltesting.core.testlang.FinallyStateAssertion;
import org.modelexecution.fumltesting.core.testlang.NullValue;
import org.modelexecution.fumltesting.core.testlang.ObjectStateExpression;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.PropertyStateExpression;
import org.modelexecution.fumltesting.core.testlang.StateAssertion;
import org.modelexecution.fumltesting.core.testlang.StateExpression;
import org.modelexecution.fumltesting.core.testlang.TemporalOperator;
import org.modelexecution.fumltesting.core.testlang.TemporalQuantifier;
import org.modelexecution.fumltesting.core.testlang.Value;
import org.modelexecution.fumltesting.core.trace.SnapshotUtil;
import org.modelexecution.fumltesting.core.trace.TraceUtil;

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
public class StateAssertionValidator {
	private TestDataConverter testDataConverter;
	private TraceUtil traceUtil;
	private SnapshotUtil snapshotUtil;
	private List<ValueSnapshot> relevantSnapshots;

	private ActivityNodeExecution referenceActionExecution;
	private ActivityNodeExecution untilActionExecution;

	private String actualValueAsserted;

	public StateAssertionValidator(TraceUtil traceUtil, TestDataConverter testDataConverter) {
		this.testDataConverter = testDataConverter;
		this.traceUtil = traceUtil;
		snapshotUtil = new SnapshotUtil(traceUtil);
	}

	public StateAssertionResult check(StateAssertion assertion) {
		StateAssertionResult result = new StateAssertionResult(assertion);
		List<State> states = new ArrayList<State>();

		try {
			referenceActionExecution = traceUtil.getReferenceActionExecution(assertion);
			untilActionExecution = traceUtil.getUntilActionExecution(assertion);
			states = traceUtil.getStates(assertion);
		} catch (ActionNotExecutedException | ConstraintNotFoundException | ConstraintStateNotFoundException | ConstraintsNotLoadedException e) {
			result.setError(e.getMessage());
			return result;
		}

		if (states.size() == 0) {
			result.setError("There are no states for a given constraint.");
			return result;
		}

		if (assertion.getAllChecks() != null && assertion.getAllChecks().size() > 0) {
			for (Check check : assertion.getAllChecks()) {
				if (check instanceof ConstraintCheck) {
					ArrayList<Boolean> results = new ArrayList<Boolean>();
					for (String constraintName : ((ConstraintCheck) check).getConstraintNames()) {
						ArrayList<ValueInstance> contextObjects = new ArrayList<ValueInstance>();
						if (((ConstraintCheck) check).getObject() != null) {
							try {
								Object nodeExecution = traceUtil.getExecution(((ConstraintCheck) check).getObject().owner);
								ObjectNode objectNode = ((ConstraintCheck) check).getObject();
								contextObjects = new ArrayList<ValueInstance>(traceUtil.getValueInstances(objectNode, nodeExecution));
							} catch (ActionNotExecutedException e) {
								result.setError(e.getMessage());
								return result;
							}
						}
						ConstraintResult constraintResult = new ConstraintResult(constraintName, assertion);
						for (State state : states) {
							boolean constraintResultInSingleState = false;
							try {
								if (contextObjects.size() > 0) {
									for (ValueInstance contextObject : contextObjects) {
										constraintResultInSingleState = OclExecutor.getInstance().checkConstraint(constraintName, contextObject, state);
										results.add(constraintResultInSingleState);
										constraintResult.putStateResult(state, constraintResultInSingleState);
									}
								} else {
									constraintResultInSingleState = OclExecutor.getInstance().checkConstraint(constraintName, null, state);
									results.add(constraintResultInSingleState);
									constraintResult.putStateResult(state, constraintResultInSingleState);
								}
							} catch (ConstraintNotFoundException e) {
								result.setError(e.getMessage());
								constraintResult.setValidationResult(false);
								return result;
							} catch (ConstraintsNotLoadedException e) {
								result.setError(e.getMessage());
								constraintResult.setValidationResult(false);
								return result;
							}
						}
						boolean overallResult = compileResult(results, assertion.getQuantifier());
						results.clear();
						constraintResult.setValidationResult(overallResult);
						result.addConstraintResult(constraintResult);
					}
				}
				if (check instanceof StateExpression) {
					result.addExpressionResult(checkExpression((StateExpression) check));
				}
			}
		}
		return result;
	}

	public StateAssertionResult check(FinallyStateAssertion assertion) throws ActionNotExecutedException {
		StateAssertion stateAssertion = new StateAssertion();

		stateAssertion.setQuantifier(TemporalQuantifier.ALWAYS);
		stateAssertion.setOperator(TemporalOperator.AFTER);

		ActionReferencePoint point = new ActionReferencePoint();
		String activityName = assertion.getContainer().getActivityUnderTest().name;
		point.setAction((Action) traceUtil.getLastExecutedActionOfActivity(activityName));
		stateAssertion.setReferencePoint(point);

		for (Check check : assertion.getAllChecks()) {
			stateAssertion.addCheck(check);
		}

		// add the replacement state assertion instead of the finally assertion
		assertion.getContainer().addAssertion(stateAssertion);
		assertion.getContainer().removeAssertion(assertion);

		return check(stateAssertion);
	}

	private StateExpressionResult checkExpression(StateExpression expression) {
		StateExpressionResult result = new StateExpressionResult(expression);
		try {
			relevantSnapshots = snapshotUtil.getRelevantSnapshots(expression, referenceActionExecution, untilActionExecution);
			if (expression instanceof ObjectStateExpression) {
				if (expression.getValue() instanceof ObjectValue || expression.getValue() instanceof NullValue) {
					result.setValidationResult(processObject((ObjectStateExpression) expression));
				} else {
					result.setValidationResult(processValue((ObjectStateExpression) expression));
				}
			} else if (expression instanceof PropertyStateExpression) {
				if (expression.getValue() instanceof ObjectValue || expression.getValue() instanceof NullValue) {
					result.setValidationResult(processObject((PropertyStateExpression) expression));
				} else {
					result.setValidationResult(processValue((PropertyStateExpression) expression));
				}
			}
		} catch (ActionNotExecutedException | ExpectedLinkValueException e) {
			result.setError(e.getMessage());
		}
		result.setActual(actualValueAsserted);
		return result;
	}

	private boolean processValue(ObjectStateExpression expression) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		Value simpleValue = (Value) expression.getValue();

		if (relevantSnapshots.size() == 0) {
			if (simpleValue instanceof NullValue) {
				if (expression.getOperator() == ArithmeticOperator.EQUAL) {
					return true;
				} else {
					return false;
				}
			} else {
				if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			for (ValueSnapshot snapshot : relevantSnapshots) {
				if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.StringValue) {
					String target = ((org.modelexecution.fumltesting.core.testlang.StringValue) simpleValue).getValue();
					String value = ((StringValue) snapshot.getValue()).value;
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
					actualValueAsserted = value;
				}
				if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.BooleanValue) {
					Boolean target = ((org.modelexecution.fumltesting.core.testlang.BooleanValue) simpleValue).getValue();
					Boolean value = ((BooleanValue) snapshot.getValue()).value;
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
					actualValueAsserted = value.toString();
				}
				if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.IntegerValue) {
					Double target = Double.valueOf(((org.modelexecution.fumltesting.core.testlang.IntegerValue) simpleValue).getValue());
					Double value = 0.0;
					if (snapshot.getValue() instanceof IntegerValue)
						value = Double.valueOf(((IntegerValue) snapshot.getValue()).value);
					if (snapshot.getValue() instanceof UnlimitedNaturalValue)
						value = Double.valueOf(((UnlimitedNaturalValue) snapshot.getValue()).value.naturalValue);
					boolean result = compareValues(expression.getOperator(), value, target);
					results.add(result);
					actualValueAsserted = value.toString();
				}
				if (simpleValue instanceof NullValue) {
					if (expression.getOperator() == ArithmeticOperator.EQUAL)
						if (relevantSnapshots.size() != 0) {
							// at the beginning everything was equal to null
							if (expression.getContainer().getQuantifier() == TemporalQuantifier.SOMETIMES
									&& expression.getContainer().getOperator() == TemporalOperator.UNTIL)
								results.add(true);
							else {
								results.add(false);
								actualValueAsserted = "NOT NULL";
							}
						} else {
							results.add(true);
						}
					if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
						if (relevantSnapshots.size() == 0) {
							results.add(false);
							actualValueAsserted = "NOT NULL";
						} else {
							results.add(true);
						}
				}
			}
		}
		return compileResult(results, (expression.getContainer()).getQuantifier());
	}

	private boolean processValue(PropertyStateExpression expression) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		Value simpleValue = (Value) expression.getValue();

		if (relevantSnapshots.size() == 0) {
			if (simpleValue instanceof NullValue && expression.getOperator() == ArithmeticOperator.EQUAL)
				results.add(true);
			else
				return false;
		} else {
			for (ValueSnapshot snapshot : relevantSnapshots) {
				Object_ object = (Object_) snapshot.getValue();
				for (FeatureValue featureValue : object.featureValues) {
					String featureName = featureValue.feature.name;
					Property property = ((PropertyStateExpression) expression).getProperty();
					String targetFeatureName = property.name;
					if (featureName.equals(targetFeatureName)) {
						if (featureValue.values.size() > 0) {
							if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.StringValue) {
								String target = ((org.modelexecution.fumltesting.core.testlang.StringValue) simpleValue).getValue();
								String value = ((StringValue) featureValue.values.get(0)).value;
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								actualValueAsserted = value;
								break;
							}
							if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.BooleanValue) {
								Boolean target = ((org.modelexecution.fumltesting.core.testlang.BooleanValue) simpleValue).getValue();
								Boolean value = ((BooleanValue) featureValue.values.get(0)).value;
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								actualValueAsserted = value.toString();
								break;
							}
							if (simpleValue instanceof org.modelexecution.fumltesting.core.testlang.IntegerValue) {
								Double target = Double.valueOf(((org.modelexecution.fumltesting.core.testlang.IntegerValue) simpleValue).getValue());
								Double value = 0.0;
								if (featureValue.values.get(0) instanceof IntegerValue)
									value = Double.valueOf(((IntegerValue) featureValue.values.get(0)).value);
								if (featureValue.values.get(0) instanceof UnlimitedNaturalValue)
									value = Double.valueOf(((UnlimitedNaturalValue) featureValue.values.get(0)).value.naturalValue);
								boolean result = compareValues(expression.getOperator(), value, target);
								results.add(result);
								actualValueAsserted = value.toString();
								break;
							}
						} else {
							if (simpleValue instanceof NullValue) {
								actualValueAsserted = "NULL";
								if (expression.getOperator() == ArithmeticOperator.EQUAL)
									if (featureValue.values.size() != 0) {
										results.add(false);
									} else {
										results.add(true);
									}
								if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
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
		}
		return compileResult(results, (expression.getContainer()).getQuantifier());
	}

	private boolean processObject(ObjectStateExpression expression) throws ActionNotExecutedException, ExpectedLinkValueException {
		Object_ target = null;
		if (expression.getValue() instanceof ObjectValue) {
			target = testDataConverter.convertObject((ObjectValue) expression.getValue());
		}
		boolean sameType = false;
		boolean objectFound = false;
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		ArrayList<Boolean> resultListCheck = new ArrayList<Boolean>();

		if (expression.getValue() instanceof ObjectValue) {
			ValueInstance instance = testDataConverter.getValueInstance(((ObjectValue) expression.getValue()).getValue());
			for (ValueSnapshot snapshot : relevantSnapshots) {
				if (snapshot.getValueInstance() != instance)
					continue;
				Object_ object_ = (Object_) snapshot.getValue();
				objectFound = true;

				// compare types
				search: for (Class_ class_ : object_.types) {
					for (Class_ targetClass_ : target.types) {
						if (class_.qualifiedName.equals(targetClass_.qualifiedName))
							sameType = true;
						break search;
					}
				}
				if (sameType == false)
					return false;

				// if there are no features
				if (object_.featureValues.size() == 0) {
					if (expression.getOperator() == ArithmeticOperator.EQUAL) {
						results.add(true);
					}
					if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
						results.add(false);
					}
				}
				// compare each feature
				for (FeatureValue featureValue : object_.featureValues) {
					if (expression.getOperator() == ArithmeticOperator.EQUAL || expression.getOperator() == ArithmeticOperator.INCLUDES
							|| expression.getOperator() == ArithmeticOperator.EXCLUDES) {
						for (FeatureValue targetFeatureValue : target.featureValues) {
							if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
								boolean result = compare(targetFeatureValue, featureValue);
								results.add(result);
							}
						}
						if (expression.getOperator() == ArithmeticOperator.INCLUDES) {
							if (!results.contains(false))
								resultListCheck.add(true);
						}
						if (expression.getOperator() == ArithmeticOperator.EXCLUDES) {
							if (!results.contains(false))
								resultListCheck.add(false);
						}
					}
					if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
						for (FeatureValue targetFeatureValue : target.featureValues) {
							if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
								boolean result = compare(targetFeatureValue, featureValue) == false;
								results.add(result);
							}
						}
					}
				}
			}
			if (!objectFound) {
				if (expression.getOperator() == ArithmeticOperator.EQUAL)
					return false;
				if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
					return true;
			}
			if (expression.getOperator() == ArithmeticOperator.INCLUDES) {
				if (resultListCheck.size() == 0)
					return false;
				else
					return true;
			} else if (expression.getOperator() == ArithmeticOperator.EXCLUDES) {
				if (resultListCheck.size() == 0)
					return true;
				else
					return false;
			}
			if (objectFound) {
				actualValueAsserted = "NOT NULL";
			} else {
				actualValueAsserted = "NULL";
			}
			return compileResult(results, expression.getContainer().getQuantifier());
		} else if (expression.getValue() instanceof NullValue) {
			if (expression.getOperator() == ArithmeticOperator.EQUAL)
				if (relevantSnapshots.size() == 0) {
					return true;
				} else {
					return false;
				}
			if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
				if (relevantSnapshots.size() == 0) {
					return false;
				} else {
					return true;
				}
		}
		return false;
	}

	private boolean processObject(PropertyStateExpression expression) throws ActionNotExecutedException, ExpectedLinkValueException {
		ArrayList<ValueInstance> links;
		Object_ target = null;
		if (expression.getValue() instanceof ObjectValue) {
			target = testDataConverter.convertObject((ObjectValue) expression.getValue());
		}
		if (target != null) {
			links = resolveLinks(expression, target);
			return checkLinks(expression, links, target);
		} else {
			links = resolveLinks(expression);
			return checkLinks(expression, links);
		}
	}

	private ValueInstance resolveSource(PropertyStateExpression expression) throws ActionNotExecutedException {
		ValueInstance source = null;
		ObjectNode pin = expression.getPin();
		Object pinOwner = expression.getPin().owner;

		if (pinOwner instanceof Action) {
			ActionExecution execution = (ActionExecution) traceUtil.getExecution(pinOwner);
			if (pin instanceof InputPin) {
				for (Input input : execution.getInputs()) {
					if (input.getInputPin().name.equals(pin.name))
						source = (ValueInstance) ((ValueSnapshot) input.getInputValues().get(0).getValueSnapshot()).eContainer();
				}
			}
			if (pin instanceof OutputPin) {
				for (Output output : execution.getOutputs()) {
					if (output.getOutputPin().name.equals(pin.name))
						source = (ValueInstance) ((ValueSnapshot) output.getOutputValues().get(0).getValueSnapshot()).eContainer();
				}
			}
		}
		if (pinOwner instanceof Activity) {
			ActivityExecution execution = (ActivityExecution) traceUtil.getExecution(pinOwner);
			ActivityParameterNode parameterNode = (ActivityParameterNode) expression.getPin();
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
		return source;
	}

	private ArrayList<ValueInstance> resolveLinks(PropertyStateExpression expression, Object_ target) throws ActionNotExecutedException {
		ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();

		StateAssertion assertion = expression.getContainer();
		TemporalOperator operator = assertion.getOperator();
		Property property = expression.getProperty();

		ValueInstance source = resolveSource(expression);

		for (ValueInstance linkValueInstance : traceUtil.getAllLinks()) {
			Link link = (Link) linkValueInstance.getRuntimeValue();
			boolean sourceContained = false;
			boolean targetContained = false;
			if (link.type == property.association) {
				for (FeatureValue value : link.getFeatureValues()) {
					Object_ referencedObject = ((Reference) value.values.get(0)).referent;
					for (ValueSnapshot snapshot : source.getSnapshots()) {
						if (snapshot.getValue().equals(referencedObject))
							sourceContained = true;
						if (target != null && target.equals(referencedObject))
							targetContained = true;
					}
					if (source.getRuntimeValue().equals(referencedObject)) {
						sourceContained = true;
					}
				}
			}
			boolean isRelevantLink = true;
			switch (operator) {
			case AFTER:
				if (linkValueInstance.getDestroyer() != null && !traceUtil.isAfter(linkValueInstance.getDestroyer(), referenceActionExecution))
					isRelevantLink = false;
				if (linkValueInstance.getCreator() == untilActionExecution && untilActionExecution != null) {
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
			if (sourceContained && targetContained && isRelevantLink) {
				links.add(linkValueInstance);
			}
		}
		return links;
	}

	private ArrayList<ValueInstance> resolveLinks(PropertyStateExpression expression) throws ActionNotExecutedException {
		ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();

		StateAssertion assertion = expression.getContainer();
		TemporalOperator operator = assertion.getOperator();
		Property property = expression.getProperty();

		ValueInstance source = resolveSource(expression);

		for (ValueInstance linkValueInstance : traceUtil.getAllLinks()) {
			Link link = (Link) linkValueInstance.getRuntimeValue();
			boolean sourceContained = false;
			if (link.type == property.association) {
				for (FeatureValue value : link.getFeatureValues()) {
					Object_ referencedObject = ((Reference) value.values.get(0)).referent;
					for (ValueSnapshot snapshot : source.getSnapshots()) {
						if (snapshot.getValue().equals(referencedObject))
							sourceContained = true;

					}
					if (source.getRuntimeValue().equals(referencedObject)) {
						sourceContained = true;
					}
				}
			}
			boolean isRelevantLink = true;
			switch (operator) {
			case AFTER:
				if (linkValueInstance.getDestroyer() != null && !traceUtil.isAfter(linkValueInstance.getDestroyer(), referenceActionExecution))
					isRelevantLink = false;
				if (linkValueInstance.getCreator() == untilActionExecution && untilActionExecution != null) {
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
		return links;
	}

	private boolean checkLinks(PropertyStateExpression expression, ArrayList<ValueInstance> links, Object_ target) {
		Property property = expression.getProperty();
		ArrayList<Boolean> results = new ArrayList<Boolean>();

		if (links.size() == 0) {
			if (expression.getOperator() == ArithmeticOperator.INCLUDES)
				results.add(false);
			if (expression.getOperator() == ArithmeticOperator.EXCLUDES)
				results.add(true);
		} else {
			if (expression.getOperator() == ArithmeticOperator.EQUAL || expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
				for (ValueInstance link : links) {
					Link theLink = (Link) link.getRuntimeValue();

					for (FeatureValue featureValue : theLink.featureValues) {
						if (featureValue.feature.name.equals(property.name)) {
							Object_ realValue = ((Reference) featureValue.values.get(0)).referent;
							for (FeatureValue targetValue : target.featureValues) {
								for (FeatureValue checkedFeature : realValue.featureValues) {
									if (targetValue.feature.name.equals(checkedFeature.feature.name)) {
										if (expression.getOperator() == ArithmeticOperator.EQUAL) {
											boolean result = compare(targetValue, checkedFeature);
											results.add(result);
										}
										if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
											boolean result = !compare(targetValue, checkedFeature);
											results.add(result);
										}
									}
								}
							}
						}
					}
				}
			} else if (expression.getOperator() == ArithmeticOperator.INCLUDES || expression.getOperator() == ArithmeticOperator.EXCLUDES) {
				outter: for (ValueInstance link : links) {
					Link theLink = (Link) link.getRuntimeValue();
					ArrayList<Boolean> resultsSingleObject = new ArrayList<Boolean>();

					for (FeatureValue featureValue : theLink.featureValues) {
						if (featureValue.feature.name.equals(property.name)) {
							Object_ realValue = ((Reference) featureValue.values.get(0)).referent;
							for (FeatureValue targetValue : target.featureValues) {
								for (FeatureValue checkedFeature : realValue.featureValues) {
									if (targetValue.feature.name.equals(checkedFeature.feature.name)) {
										boolean result = compare(targetValue, checkedFeature);
										resultsSingleObject.add(result);
									}
								}
							}
							if (resultsSingleObject.contains(false)) {
								continue outter;
							} else {
								if (expression.getOperator() == ArithmeticOperator.INCLUDES)
									results.add(true);
								if (expression.getOperator() == ArithmeticOperator.EXCLUDES)
									results.add(false);
								break outter;
							}
						}
					}
				}
				if (results.size() == 0) {
					if (expression.getOperator() == ArithmeticOperator.INCLUDES)
						results.add(false);
					if (expression.getOperator() == ArithmeticOperator.EXCLUDES)
						results.add(true);
				}
			}
		}
		return compileResult(results, expression.getContainer().getQuantifier());
	}

	private boolean checkLinks(PropertyStateExpression expression, ArrayList<ValueInstance> links) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		TemporalQuantifier quantifier = expression.getContainer().getQuantifier();

		if (expression.getOperator() == ArithmeticOperator.EQUAL) {
			switch (quantifier) {
			case ALWAYS:
				if (links.size() > 0) {
					for (ValueInstance linkInstance : links) {
						if (linkInstance.getDestroyer() != null
								&& (!traceUtil.isAfter(linkInstance.getDestroyer(), referenceActionExecution) || (untilActionExecution != null && !traceUtil
										.isAfter(linkInstance.getDestroyer(), untilActionExecution))))
							results.add(false);
					}
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
								|| (linkInstance.getDestroyer() != null && untilActionExecution != null && !traceUtil.isAfter(linkInstance.getDestroyer(),
										untilActionExecution)))
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
		} else if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
			if (links.size() == 0)
				results.add(false);
			else
				results.add(true);
		}
		return compileResult(results, expression.getContainer().getQuantifier());
	}

	/**
	 * Compares all values for target and real feature values, and returns a
	 * result.
	 */
	private boolean compare(FeatureValue targetFeatureValue, FeatureValue featureValue) {
		if (targetFeatureValue.values.size() != featureValue.values.size()) {
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
						return false;
					}
				}
				if (targetFeatureValue.values.get(i) instanceof IntegerValue) {
					IntegerValue targetValue = (IntegerValue) targetFeatureValue.values.get(i);
					IntegerValue value = (IntegerValue) featureValue.values.get(i);
					if (targetValue.value == value.value)
						return true;
					else {
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
						return false;
					}
				}
				if (targetFeatureValue.values.get(i) instanceof BooleanValue) {
					BooleanValue targetValue = (BooleanValue) targetFeatureValue.values.get(i);
					BooleanValue value = (BooleanValue) featureValue.values.get(i);
					if (targetValue.value == value.value)
						return true;
					else {
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
	private boolean compareValues(ArithmeticOperator operator, Object value, Object target) {
		if (value instanceof String || value instanceof Boolean) {
			if (operator == ArithmeticOperator.EQUAL)
				if (!value.equals(target))
					return false;
			if (operator == ArithmeticOperator.NOT_EQUAL)
				if (value.equals(target))
					return false;
		}
		if (value instanceof Double) {
			if (operator == ArithmeticOperator.EQUAL)
				if (!value.equals(target))
					return false;
			if (operator == ArithmeticOperator.NOT_EQUAL)
				if (value.equals(target))
					return false;
			if (operator == ArithmeticOperator.GREATER)
				if ((Double) value <= (Double) target)
					return false;
			if (operator == ArithmeticOperator.GREATER_EQUAL)
				if ((Double) value < (Double) target)
					return false;
			if (operator == ArithmeticOperator.SMALLER)
				if ((Double) value >= (Double) target)
					return false;
			if (operator == ArithmeticOperator.SMALLER_EQUAL)
				if ((Double) value > (Double) target)
					return false;
		}
		return true;
	}

	private boolean compileResult(ArrayList<Boolean> results, TemporalQuantifier quantifier) {
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
}