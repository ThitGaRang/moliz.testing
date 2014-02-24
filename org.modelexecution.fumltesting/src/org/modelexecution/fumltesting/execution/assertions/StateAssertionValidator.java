package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.xtext.xbase.XBooleanLiteral;
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
import org.modelexecution.fumltesting.execution.FumlOclInterpreter;
import org.modelexecution.fumltesting.execution.TestDataConverter;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.sequence.State;
import org.modelexecution.fumltesting.testLang.ArithmeticOperator;
import org.modelexecution.fumltesting.testLang.Constraint;
import org.modelexecution.fumltesting.testLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;
import org.modelexecution.fumltesting.testLang.TestLangFactory;

import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fUML.Syntax.Actions.BasicActions.CallBehaviorAction;
import fUML.Syntax.Actions.BasicActions.CallOperationAction;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNode;
import fUML.Syntax.Activities.IntermediateActivities.ActivityNodeList;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Property;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

/**
 * Utility class for state assertion validation.
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class StateAssertionValidator {
	/** Utility class for converting input data for activity under test. */
	private TestDataConverter testDataConverter;
	/** Object under consideration used for validation of state assertions. */
	private ValueInstance valueInstance;
	/** Utility class for managing the execution trace. */
	private TraceUtil traceUtil;

	private ArrayList<ValueSnapshot> predecessors;
	private ArrayList<ValueSnapshot> successors;

	private StateAssertion assertion;
	private TemporalOperator operator;
	private TemporalQuantifier quantifier;

	private ActionExecution referredNodeExecution;
	private Object expressionNodeExecution;

	public StateAssertionValidator(TraceUtil traceUtil) {
		testDataConverter = TestDataConverter.getInstance();
		this.traceUtil = traceUtil;
		predecessors = new ArrayList<ValueSnapshot>();
		successors = new ArrayList<ValueSnapshot>();
	}

	public boolean check(StateAssertion assertion) {
		AssertionPrinter.printStateAssertion(assertion);
		boolean result = true;

		// action of the state assertion and its execution
		Action referredAction = assertion.getReferenceAction();
		referredNodeExecution = (ActionExecution) traceUtil.getExecution(referredAction);

		operator = assertion.getTemporalOperator();
		quantifier = assertion.getTemporalQuantifier();

		if (assertion.getConstraints().size() > 0) {
			for (Constraint constraint : assertion.getConstraints()) {
				List<State> states = traceUtil.getStates(quantifier, operator, referredNodeExecution);
				result = check(((XStringLiteral)constraint.getSpecification()).getValue(), states);
			}
		}

		for (StateExpression expression : assertion.getExpressions()) {
			result = check(expression, referredAction);
		}

		AssertionPrinter.printStartEnd();
		return result;
	}

	public boolean check(FinallyStateAssertion assertion) {
		StateAssertion stateAssertion = TestLangFactory.eINSTANCE.createStateAssertion();

		stateAssertion.setTemporalQuantifier(TemporalQuantifier.ALWAYS);
		stateAssertion.setTemporalOperator(TemporalOperator.AFTER);

		stateAssertion.setReferenceAction((Action) traceUtil.getLastExecutedAction());
		stateAssertion.getExpressions().addAll(assertion.getExpressions());

		stateAssertion.getConstraints().addAll(assertion.getConstraints());

		return check(stateAssertion);
	}

	private boolean check(String constraintName, List<State> states) {		
		for (State state : states) {
			IModelInstance modelInstance = FumlOclInterpreter.getInstance().getEmptyModelInstance();

			try {
				for (org.modelexecution.fuml.Semantics.Classes.Kernel.Object object : state.getObjects()) {					
					modelInstance.addModelInstanceElement(object);
				}
				for (org.modelexecution.fuml.Semantics.Classes.Kernel.Link link : state.getLinks()) {					
					modelInstance.addModelInstanceElement(link);
				}
			} catch (TypeNotFoundInModelException e) {
				e.printStackTrace();
			}
			boolean result = FumlOclInterpreter.getInstance().evaluateConstraint(constraintName, modelInstance);
			if (result == false) {
				System.out.println("Constraint " + " failed for state created by action " + state.getNodeExecution().getNode().name);
				return false;
			}else{
				System.out.println("Constraint validation success.");
			}
		}
		return true;
	}

	private boolean check(StateExpression expression, Action referredAction) {

		// Clean up from other test executions
		predecessors.removeAll(predecessors);
		successors.removeAll(successors);

		// setup the parts of expression
		assertion = (StateAssertion) expression.eContainer();

		// action of the state expression
		Object expressionAction = expression.getPin().getRef().eContainer();

		// execution of the node from the expression specifying the object under
		// consideration
		if (expressionAction instanceof Action)
			expressionNodeExecution = (ActionExecution) traceUtil.getExecution((Action) expressionAction);
		if (expressionAction instanceof Activity) {
			expressionNodeExecution = (ActivityExecution) traceUtil.getExecution((Activity) expressionAction);
		}

		if (expressionNodeExecution != null && referredNodeExecution != null) {

			// Get the value instance from the trace based on expression
			setupValueInstance(expression);
			// initialize the successors and predecessors of the value instance
			setupSucessorsPredecessors();

			ArrayList<ValueSnapshot> list = new ArrayList<ValueSnapshot>();
			if (operator == TemporalOperator.BEFORE) {
				if (quantifier == TemporalQuantifier.ALWAYS)
					list = predecessors;
				if (quantifier == TemporalQuantifier.EXACTLY) {
					if (predecessors.size() > 0) {
						list.add(predecessors.get(0));
					}
				}
			}
			if (operator == TemporalOperator.AFTER) {
				if (referredAction != expressionAction && successors.size() == 0 && predecessors.size() > 0) {
					// the value was not changed after the referredAction
					// we need to add last predecessor to successors to make it
					// work
					successors.add(predecessors.get(predecessors.size() - 1));
				}
				if (quantifier == TemporalQuantifier.ALWAYS)
					list = successors;
				if (quantifier == TemporalQuantifier.EXACTLY)
					if (successors.size() > 0) {
						list.add(successors.get(0));
					}
			}

			boolean result = false;

			if (expression.getValue() instanceof SimpleValue) {
				// special case
				if (expression instanceof PropertyStateExpression && ((SimpleValue) expression.getValue()).getValue() instanceof XNullLiteral)
					result = processObject(expression, list);
				else
					result = processSimple(expression, list);
				AssertionPrinter.print(expression, result);
				return result;
			}
			if (expression.getValue() instanceof ObjectValue) {
				result = processObject(expression, list);
				AssertionPrinter.print(expression, result);
				return result;
			}
		} else {
			AssertionPrinter.print(expression, false);
			if (expressionNodeExecution == null) {
				System.out.println(((Action) expressionAction).getName() + " was never executed!");
			}
			if (referredNodeExecution == null) {
				System.out.println(referredAction.getName() + " was never executed!");
			}
		}
		return false;
	}

	/**
	 * Getting the value instance from the trace based on the expression.
	 * 
	 * @param expression
	 */
	private void setupValueInstance(StateExpression expression) {
		if (expression.getPin().getRef() instanceof OutputPin || expression.getPin().getRef() instanceof ActivityParameterNode) {
			if (expressionNodeExecution instanceof ActionExecution) {
				for (Output output : ((ActionExecution) expressionNodeExecution).getOutputs()) {
					if (output.getOutputPin().name.equals(expression.getPin().getRef().getName())) {
						if (output.getOutputValues().size() > 0)
							valueInstance = (ValueInstance) output.getOutputValues().get(0).getOutputValueSnapshot().eContainer();
					}
				}
			}
			if (expressionNodeExecution instanceof ActivityExecution) {
				for (OutputParameterSetting output : ((ActivityExecution) expressionNodeExecution).getActivityOutputs()) {
					if (output.getParameter().name.equals(expression.getPin().getRef().getName())) {
						if (output.getParameterValues().size() > 0)
							valueInstance = (ValueInstance) output.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}

		if (expression.getPin().getRef() instanceof InputPin || expression.getPin().getRef() instanceof ActivityParameterNode) {
			if (expressionNodeExecution instanceof ActionExecution) {
				for (Input input : ((ActionExecution) expressionNodeExecution).getInputs()) {
					if (input.getInputPin().name.equals(expression.getPin().getRef().getName())) {
						if (input.getInputValues().size() > 0)
							valueInstance = (ValueInstance) input.getInputValues().get(0).getInputValueSnapshot().eContainer();
					}
				}
			}
			if (expressionNodeExecution instanceof ActivityExecution) {
				for (InputParameterSetting input : ((ActivityExecution) expressionNodeExecution).getActivityInputs()) {
					if (input.getParameter().name.equals(expression.getPin().getRef().getName())) {
						if (input.getParameterValues().size() > 0)
							valueInstance = (ValueInstance) input.getParameterValues().get(0).getValueSnapshot().eContainer();
					}
				}
			}
		}
	}

	private boolean processSimple(StateExpression expression, List<ValueSnapshot> list) {
		SimpleValue simpleValue = (SimpleValue) expression.getValue();

		if (list.size() == 0) {
			if (simpleValue.getValue() instanceof XNullLiteral)
				;
			else
				return false;
		}

		for (ValueSnapshot snapshot : list) {
			if (expression instanceof PropertyStateExpression) {
				Object_ object = (Object_) snapshot.getValue();
				for (FeatureValue featureValue : object.featureValues) {
					String featureName = featureValue.feature.name;
					String targetFeatureName = ((PropertyStateExpression) expression).getProperty().getName();
					if (featureName.equals(targetFeatureName)) {
						if (featureValue.values.size() > 0) {
							if (simpleValue.getValue() instanceof XStringLiteral) {
								String target = ((XStringLiteral) simpleValue.getValue()).getValue();
								String value = ((StringValue) featureValue.values.get(0)).value;
								return compareValues(expression.getOperator(), value, target);
							}
							if (simpleValue.getValue() instanceof XBooleanLiteral) {
								Boolean target = ((XBooleanLiteral) simpleValue.getValue()).isIsTrue();
								Boolean value = ((BooleanValue) featureValue.values.get(0)).value;
								return compareValues(expression.getOperator(), value, target);
							}
							if (simpleValue.getValue() instanceof XNumberLiteral) {
								Double target = Double.valueOf(((XNumberLiteral) simpleValue.getValue()).getValue());
								Double value = 0.0;
								if (featureValue.values.get(0) instanceof IntegerValue)
									value = Double.valueOf(((IntegerValue) featureValue.values.get(0)).value);
								if (featureValue.values.get(0) instanceof UnlimitedNaturalValue)
									value = Double.valueOf(((UnlimitedNaturalValue) featureValue.values.get(0)).value.naturalValue);
								return compareValues(expression.getOperator(), value, target);
							}
							if (simpleValue.getValue() instanceof XNullLiteral) {
								if (expression.getOperator() == ArithmeticOperator.EQUAL)
									if (featureValue.values.size() != 0)
										return false;
								if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
									if (featureValue.values.size() == 0)
										return false;
							}
						}
					}
				}
			}
			if (expression instanceof ObjectStateExpression) {
				if (simpleValue.getValue() instanceof XStringLiteral) {
					String target = ((XStringLiteral) simpleValue.getValue()).getValue();
					String value = ((StringValue) snapshot.getValue()).value;
					return compareValues(expression.getOperator(), value, target);
				}
				if (simpleValue.getValue() instanceof XBooleanLiteral) {
					Boolean target = ((XBooleanLiteral) simpleValue.getValue()).isIsTrue();
					Boolean value = ((BooleanValue) snapshot.getValue()).value;
					return compareValues(expression.getOperator(), value, target);
				}
				if (simpleValue.getValue() instanceof XNumberLiteral) {
					Double target = Double.valueOf(((XNumberLiteral) simpleValue.getValue()).getValue());
					Double value = 0.0;
					if (snapshot.getValue() instanceof IntegerValue)
						value = Double.valueOf(((IntegerValue) snapshot.getValue()).value);
					if (snapshot.getValue() instanceof UnlimitedNaturalValue)
						value = Double.valueOf(((UnlimitedNaturalValue) snapshot.getValue()).value.naturalValue);
					return compareValues(expression.getOperator(), value, target);
				}
				if (simpleValue.getValue() instanceof XNullLiteral) {
					if (expression.getOperator() == ArithmeticOperator.EQUAL)
						if (list.size() != 0)
							return false;
					if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
						if (list.size() == 0)
							return false;
				}
			}
		}
		return true;
	}

	private boolean processObject(StateExpression expression, List<ValueSnapshot> list) {
		if (expression.getOperator() != ArithmeticOperator.EQUAL && expression.getOperator() != ArithmeticOperator.NOT_EQUAL
				&& expression.getOperator() != ArithmeticOperator.INCLUDES && expression.getOperator() != ArithmeticOperator.EXCLUDES) {
			System.out.println("Operator <, >, <=, and => not allowed!");
			return false;
		}

		Object_ fumlTarget = (Object_) testDataConverter.getFUMLElement(expression.getValue());
		boolean sameType = false;

		if (expression instanceof ObjectStateExpression) {
			for (ValueSnapshot snapshot : list) {
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
					if (expression.getOperator() == ArithmeticOperator.EQUAL) {
						for (FeatureValue targetFeatureValue : fumlTarget.featureValues) {
							if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
								if (compare(targetFeatureValue, featureValue) == false)
									return false;
							}
						}
					}
					if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL) {
						for (FeatureValue targetFeatureValue : fumlTarget.featureValues) {
							if (targetFeatureValue.feature.name.equals(featureValue.feature.name)) {
								if (compare(targetFeatureValue, featureValue) == false)
									return true;
							}
						}
					}
				}
			}
		}

		// link validation
		if (expression instanceof PropertyStateExpression) {
			PropertyStateExpression propertyExpression = (PropertyStateExpression) expression;
			if (propertyExpression.getProperty().getType() instanceof org.eclipse.uml2.uml.Class) {
				Object variableAction = propertyExpression.getPin().getRef().eContainer();
				Object_ source = null;
				if (propertyExpression.getPin().getRef().eContainer() instanceof Action) {
					ActionExecution execution = (ActionExecution) traceUtil.getExecution(variableAction);
					if (propertyExpression.getPin().getRef() instanceof InputPin) {
						for (Input input : execution.getInputs()) {
							if (input.getInputPin().name.equals(propertyExpression.getPin().getRef().getName()))
								source = (Object_) input.getInputValues().get(0).getInputValueSnapshot().getValue();
						}
					}
					if (propertyExpression.getPin().getRef() instanceof OutputPin) {
						for (Output output : execution.getOutputs()) {
							if (output.getOutputPin().name.equals(propertyExpression.getPin().getRef().getName()))
								source = (Object_) output.getOutputValues().get(0).getOutputValueSnapshot().getValue();
						}
					}
				}
				if (propertyExpression.getPin().getRef().eContainer() instanceof Activity) {
					ActivityExecution execution = (ActivityExecution) traceUtil.getExecution(variableAction);
					ActivityParameterNode parameterNode = (ActivityParameterNode) propertyExpression.getPin().getRef();
					if (parameterNode.getParameter().getDirection().getValue() == ParameterDirectionKind.OUT) {
						for (OutputParameterSetting output : execution.getActivityOutputs()) {
							if (output.getParameter().name.equals(parameterNode.getName()))
								source = (Object_) output.getParameterValues().get(0).getValueSnapshot().getValue();
						}
					}
					if (parameterNode.getParameter().getDirection().getValue() == ParameterDirectionKind.IN) {
						for (InputParameterSetting input : execution.getActivityInputs()) {
							if (input.getParameter().name.equals(parameterNode.getName()))
								source = (Object_) input.getParameterValues().get(0).getValueSnapshot().getValue();
						}
					}
				}

				Object_ target = null;
				if (propertyExpression.getValue() instanceof SimpleValue) {
					// this is the case where we might compare null to a link
					SimpleValue value = (SimpleValue) propertyExpression.getValue();
					if (!(value.getValue() instanceof XNullLiteral))
						System.out.println("For links only null is allowed!");
					;
				} else {
					target = (Object_) testDataConverter.getFUMLElement(propertyExpression.getValue());
				}

				List<ValueInstance> links = new ArrayList<ValueInstance>();
				for (ValueInstance linkValueInstance : traceUtil.getAllLinks()) {
					Link link = (Link) linkValueInstance.getRuntimeValue();
					boolean sourceContained = false;
					boolean targetContained = false;
					for (FeatureValue value : link.getFeatureValues()) {
						Reference reference = (Reference) value.values.get(0);

						if (reference.referent.equals(source))
							sourceContained = true;
						if (reference.referent.equals(target))
							targetContained = true;
					}
					if (sourceContained && targetContained) {
						links.add(linkValueInstance);
					}
				}

				// for each temporal constraint it is enough to remove all those
				// links that the destroyer is not null and is before the
				// referenced action
				List<ValueInstance> linksToRemove = new ArrayList<ValueInstance>();

				for (ValueInstance link : links) {
					if (link.getDestroyer() != null && !traceUtil.isAfter(link.getDestroyer(), referredNodeExecution)) {
						linksToRemove.add(link);
					}
				}
				links.removeAll(linksToRemove);

				if (target == null) {
					if (links.size() > 0)
						return false;
					if (links.size() == 0)
						return true;
				} else {
					if (links.size() == 0)
						return false;
					if (links.size() > 0)
						return true;
				}
				return false;
			}
			for (ValueSnapshot snapshot : list) {
				Object_ object_ = (Object_) snapshot.getValue();
				FeatureValue featureValue = null;
				for (FeatureValue value : object_.featureValues) {
					if (value.feature.name.equals(propertyExpression.getProperty().getName())) {
						featureValue = value;
						break;
					}
				}
				if (featureValue == null) {
					System.out.println("No such feature!");
					return false;
				}
				if (fumlTarget != null) {
					for (FeatureValue targetValue : fumlTarget.featureValues) {
						if (targetValue.feature.name.equals(propertyExpression.getProperty().getName())) {
							if (expression.getOperator() == ArithmeticOperator.EQUAL)
								if (compare(targetValue, featureValue) == false)
									return false;
							if (expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
								if (compare(targetValue, featureValue) == true)
									return false;
						}
					}
				}
				if (fumlTarget == null && featureValue.values.size() != 0) {
					return false;
				}
			}
		}
		return true;
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
			// for links, there are features without any values that
			// we want to skip
			return true;
		}
		return false;
	}

	/**
	 * Initialize predecessor snapshots of valueInstance referred by expression.
	 * 
	 * @param referredNodeExecution
	 * @param previousSnapshots
	 */
	private void initializePredecessorSnapshots(ActivityNodeExecution referredNodeExecution, List<ValueSnapshot> predecessorSnapshots) {
		ActivityNodeExecution predecessor = referredNodeExecution.getChronologicalPredecessor();
		if (predecessor == null)
			return;
		if (assertion.getUntilAction() != null && assertion.getUntilAction().getName().equals(predecessor.getNode().name))
			return;

		if (predecessor instanceof ActionExecution) {
			for (Input predecesorsInput : ((ActionExecution) predecessor).getInputs()) {
				if (predecesorsInput.getInputValues().get(0).getInputValueSnapshot() != null
						&& predecesorsInput.getInputValues().get(0).getInputValueSnapshot().eContainer() == valueInstance)
					if (predecessorSnapshots.contains(predecesorsInput.getInputValues().get(0).getInputValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsInput.getInputValues().get(0).getInputValueSnapshot());
			}
			for (Output predecesorsOutput : ((ActionExecution) predecessor).getOutputs()) {
				if (predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot() != null
						&& predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot().eContainer() == valueInstance)
					if (predecessorSnapshots.contains(predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot());
			}
		}
		initializePredecessorSnapshots(predecessor, predecessorSnapshots);
	}

	/**
	 * Initialize successor snapshots of valueInstance referred by expression.
	 * 
	 * @param referredNodeExecution
	 * @param previousSnapshots
	 */
	private void initializeSuccessorSnapshots(ActivityNodeExecution referredNodeExecution, List<ValueSnapshot> successorSnapshots) {
		ActivityNodeExecution successor = referredNodeExecution.getChronologicalSuccessor();
		if (successor == null)
			return;
		if (assertion.getUntilAction() != null && assertion.getUntilAction().getName().equals(successor.getNode().name))
			return;
		if (successor instanceof ActionExecution) {
			for (Input successorsInput : ((ActionExecution) successor).getInputs()) {
				if (successorsInput.getInputValues().get(0).getInputValueSnapshot() != null
						&& successorsInput.getInputValues().get(0).getInputValueSnapshot().eContainer() == valueInstance)
					if (successorSnapshots.contains(successorsInput.getInputValues().get(0).getInputValueSnapshot()) == false)
						successorSnapshots.add(successorsInput.getInputValues().get(0).getInputValueSnapshot());
			}
			for (Output successorsOutput : ((ActionExecution) successor).getOutputs()) {
				if (successorsOutput.getOutputValues().get(0).getOutputValueSnapshot() != null
						&& successorsOutput.getOutputValues().get(0).getOutputValueSnapshot().eContainer() == valueInstance)
					if (successorSnapshots.contains(successorsOutput.getOutputValues().get(0).getOutputValueSnapshot()) == false)
						successorSnapshots.add(successorsOutput.getOutputValues().get(0).getOutputValueSnapshot());
			}
		}
		initializeSuccessorSnapshots(successor, successorSnapshots);
	}

	/**
	 * Initialize successors and predecessors of the value instance.
	 */
	private void setupSucessorsPredecessors() {
		for (Output output : referredNodeExecution.getOutputs()) {
			if (output.getOutputValues().size() == 0)
				continue;
			if (output.getOutputValues().get(0).getOutputValueSnapshot() == null)
				continue;
			ValueInstance referredValueInstance = (ValueInstance) output.getOutputValues().get(0).getOutputValueSnapshot().eContainer();
			if (referredValueInstance == valueInstance && operator == TemporalOperator.AFTER)
				if (successors.contains(output.getOutputValues().get(0).getOutputValueSnapshot()) == false)
					successors.add(output.getOutputValues().get(0).getOutputValueSnapshot());
		}

		for (Input input : referredNodeExecution.getInputs()) {
			if (input.getInputValues().size() == 0)
				continue;
			if (input.getInputValues().get(0).getInputValueSnapshot() == null)
				continue;
			ValueInstance referredValueInstance = (ValueInstance) input.getInputValues().get(0).getInputValueSnapshot().eContainer();
			if (referredValueInstance == valueInstance && operator == TemporalOperator.BEFORE) {
				if (predecessors.contains(input.getInputValues().get(0).getInputValueSnapshot()))
					predecessors.add(input.getInputValues().get(0).getInputValueSnapshot());
			}
		}

		// adding snapshots of the valueInstance created before-after the
		// referred one
		if ((referredNodeExecution.getNode() instanceof CallBehaviorAction && !(((CallBehaviorAction) referredNodeExecution.getNode()).behavior instanceof OpaqueBehavior))
				|| referredNodeExecution.getNode() instanceof CallOperationAction) {
			ActivityNodeList nodes = referredNodeExecution.getNode().activity.node;
			ActivityNodeExecution lastNodeInBehavior = getLastChildNode(referredNodeExecution, nodes);
			initializeSuccessorSnapshots(lastNodeInBehavior, successors);
			initializePredecessorSnapshots(lastNodeInBehavior, predecessors);
		} else {
			initializeSuccessorSnapshots(referredNodeExecution, successors);
			initializePredecessorSnapshots(referredNodeExecution, predecessors);
		}
	}

	private ActivityNodeExecution getLastChildNode(ActivityNodeExecution nodeExecution, ActivityNodeList nodes) {
		ActivityNode successor = nodeExecution.getChronologicalSuccessor().getNode();
		ActivityNode successorOfSuccessor = null;
		if (nodeExecution.getChronologicalSuccessor().getChronologicalSuccessor() != null) {
			successorOfSuccessor = nodeExecution.getChronologicalSuccessor().getChronologicalSuccessor().getNode();
		}

		if (!nodes.contains(successor) && (nodes.contains(successorOfSuccessor) || successorOfSuccessor == null)) {
			return nodeExecution.getChronologicalSuccessor();
		}
		return getLastChildNode(nodeExecution.getChronologicalSuccessor(), nodes);
	}

	/** Comparison of simple values: String, Boolean, Double */
	private boolean compareValues(ArithmeticOperator operator, Object value, Object target) {
		System.out.println("Expected value: " + target + " Real value: " + value);
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
}