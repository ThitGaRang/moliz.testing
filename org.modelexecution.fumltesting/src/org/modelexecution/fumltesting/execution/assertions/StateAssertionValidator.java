package org.modelexecution.fumltesting.execution.assertions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActionExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.Input;
import org.modelexecution.fumldebug.core.trace.tracemodel.Output;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueSnapshot;
import org.modelexecution.fumltesting.execution.TestDataConverter;
import org.modelexecution.fumltesting.execution.TraceUtil;
import org.modelexecution.fumltesting.testLang.ArithmeticOperator;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TemporalOperator;
import org.modelexecution.fumltesting.testLang.TemporalQuantifier;

import UMLPrimitiveTypes.UnlimitedNatural;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Property;
/**
 * Utility class for state assertion validation.
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
	
	private ArrayList<ValueSnapshot> predecessors = new ArrayList<ValueSnapshot>();
	private ArrayList<ValueSnapshot> successors = new ArrayList<ValueSnapshot>();
	private ArrayList<ValueInstance> links = new ArrayList<ValueInstance>();
	
	private StateAssertion assertion;
	private TemporalOperator operator;
	private TemporalQuantifier quantifier;
	
	private ActionExecution referredNodeExecution;
	private ActionExecution expressionNodeExecution;
	
	public StateAssertionValidator(TraceUtil traceUtil, IConversionResult model){
		testDataConverter = new TestDataConverter(model);
		this.traceUtil = traceUtil;
	}
	
	public boolean check(StateAssertion assertion){
		AssertionPrinter.printStateAssertion(assertion);
		boolean result = true;
		for(StateExpression expression: assertion.getExpressions()){
			result = check(expression);
		}
		AssertionPrinter.printStartEnd();
		return result;
	}
	
	private boolean check(StateExpression expression){		
		assertion = (StateAssertion)expression.eContainer();
		operator = assertion.getTemporalOperator();
		quantifier = assertion.getTemporalQuantifier();
		
		Action referredAction = assertion.getReferenceAction();
		Action expressionAction = (Action)expression.getPin().getRef().eContainer();
		
		referredNodeExecution = (ActionExecution)traceUtil.getNodeExecution(referredAction);		
		expressionNodeExecution = (ActionExecution)traceUtil.getNodeExecution(expressionAction);
		
		if(expressionNodeExecution != null){
			
			if(expression.getPin().getRef() instanceof OutputPin){
				for(Output output: expressionNodeExecution.getOutputs()){
					if(output.getOutputPin().name.equals(expression.getPin().getRef().getName())){
						valueInstance = (ValueInstance)output.getOutputValues().get(0).getOutputValueSnapshot().eContainer();
					}
				}
			}
			
			if(expression.getPin().getRef() instanceof InputPin){
				for(Input input: expressionNodeExecution.getInputs()){
					if(input.getInputPin().name.equals(expression.getPin().getRef().getName())){
						valueInstance = (ValueInstance)input.getInputValues().get(0).getInputValueSnapshot().eContainer();
					}
				}
			}
			
			for(Output output: referredNodeExecution.getOutputs()){
				ValueInstance referredValueInstance = (ValueInstance)output.getOutputValues().get(0).getOutputValueSnapshot().eContainer();
				if(referredValueInstance == valueInstance && operator == TemporalOperator.AFTER)
					if(successors.contains(output.getOutputValues().get(0).getOutputValueSnapshot()) == false)
						successors.add(output.getOutputValues().get(0).getOutputValueSnapshot());
			}
			
			for(Input input: referredNodeExecution.getInputs()){
				ValueInstance referredValueInstance = (ValueInstance)input.getInputValues().get(0).getInputValueSnapshot().eContainer();
				if(referredValueInstance == valueInstance && operator == TemporalOperator.BEFORE){
					if(predecessors.contains(input.getInputValues().get(0).getInputValueSnapshot()))
						predecessors.add(input.getInputValues().get(0).getInputValueSnapshot());
				}
			}
			
			//adding snapshots of the valueInstance created before-after the referred one
			initializePredecessorSnapshots(referredNodeExecution, predecessors);
			initializeSuccessorSnapshots(referredNodeExecution, successors);
			initializeLinks();
			
			ArrayList<ValueSnapshot> list = new ArrayList<ValueSnapshot>();
			if(operator == TemporalOperator.BEFORE){
				if(quantifier == TemporalQuantifier.ALWAYS)
					list = predecessors;
				if(quantifier == TemporalQuantifier.EXACTLY){
					if(predecessors.size()>0){
						list.add(predecessors.get(0));
					}
				}
			}	
			if(operator == TemporalOperator.AFTER){
				if(quantifier == TemporalQuantifier.ALWAYS)
					list = successors;
				if(quantifier == TemporalQuantifier.EXACTLY)
					if(successors.size()>0){
						list.add(successors.get(0));
					}
			}
			
			boolean result = false;
			
			if(expression.getValue() instanceof SimpleValue){
				result = processSimple(expression, list);
				AssertionPrinter.print(expression, result);
				return result;
			}
			if(expression.getValue() instanceof ObjectValue){
				result = processObject(expression, list);
				AssertionPrinter.print(expression, result);
				return result;
			}
		}
		return false;
	}
	
	private boolean processSimple(StateExpression expression, List<ValueSnapshot> list){
		SimpleValue simpleValue = (SimpleValue)expression.getValue();
		
		for(ValueSnapshot snapshot: list){
			if(expression instanceof PropertyStateExpression){
				Object_ object = (Object_)snapshot.getValue();
				for(FeatureValue featureValue: object.featureValues){
					String featureName = featureValue.feature.name;
					String targetFeatureName = ((PropertyStateExpression)expression).getProperty().getName();
					if(featureName.equals(targetFeatureName)){
						if(featureValue.values.size() > 0){
							if(simpleValue.getValue() instanceof XStringLiteral){
								String target = ((XStringLiteral)simpleValue.getValue()).getValue();
								String value = ((StringValue)featureValue.values.get(0)).value;
								return compareValues(expression.getOperator(), value, target);
							}
							if(simpleValue.getValue() instanceof XBooleanLiteral){
								Boolean target = ((XBooleanLiteral)simpleValue.getValue()).isIsTrue();
								Boolean value = ((BooleanValue)featureValue.values.get(0)).value;
								return compareValues(expression.getOperator(), value, target);
							}
							if(simpleValue.getValue() instanceof XNumberLiteral){
								Double target = Double.valueOf(((XNumberLiteral)simpleValue.getValue()).getValue());
								Double value = 0.0;
								if(featureValue.values.get(0) instanceof IntegerValue)
									value = Double.valueOf(((IntegerValue)featureValue.values.get(0)).value);
								if(featureValue.values.get(0) instanceof UnlimitedNaturalValue)
									value = Double.valueOf(((UnlimitedNaturalValue)featureValue.values.get(0)).value.naturalValue);
								return compareValues(expression.getOperator(), value, target);
							}
							if(simpleValue.getValue() instanceof XNullLiteral){
								if(expression.getOperator() == ArithmeticOperator.EQUAL)
									if(featureValue.values.size() != 0)return false;
								if(expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
									if(featureValue.values.size() == 0)return false;
							}
						}
					}
				}
			}
			if(expression instanceof ObjectStateExpression){
				if(simpleValue.getValue() instanceof XStringLiteral){
					String target = ((XStringLiteral)simpleValue.getValue()).getValue();
					String value = ((StringValue)snapshot.getValue()).value;
					return compareValues(expression.getOperator(), value, target);
				}
				if(simpleValue.getValue() instanceof XBooleanLiteral){
					Boolean target = ((XBooleanLiteral)simpleValue.getValue()).isIsTrue();
					Boolean value = ((BooleanValue)snapshot.getValue()).value;
					return compareValues(expression.getOperator(), value, target);
				}
				if(simpleValue.getValue() instanceof XNumberLiteral){
					Double target = Double.valueOf(((XNumberLiteral)simpleValue.getValue()).getValue());
					Double value = 0.0;
					if(snapshot.getValue() instanceof IntegerValue)
						value = Double.valueOf(((IntegerValue)snapshot.getValue()).value);
					if(snapshot.getValue() instanceof UnlimitedNaturalValue)
						value = Double.valueOf(((UnlimitedNaturalValue)snapshot.getValue()).value.naturalValue);
					return compareValues(expression.getOperator(), value, target);
				}
				if(simpleValue.getValue() instanceof XNullLiteral){
					if(expression.getOperator() == ArithmeticOperator.EQUAL)
						if(list.size() != 0)return false;
					if(expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
						if(list.size() == 0)return false;
				}
			}
		}
		return true;
	}
	
	private boolean processObject(StateExpression expression, List<ValueSnapshot> list){
		if(expression.getOperator() != ArithmeticOperator.EQUAL && expression.getOperator() != ArithmeticOperator.NOT_EQUAL){
			System.out.println("Operator <, >, <=, and => not allowed!");
			return false;
		}
		
		Object_ fumlTarget = (Object_)testDataConverter.getFUMLElement(expression.getValue());
		boolean sameType = false;
		
		if(expression instanceof ObjectStateExpression){
			for(ValueSnapshot snapshot: list){
				Object_ object_ = (Object_)snapshot.getValue();
				
				//compare types
				search:
				for(Class_ class_: object_.types){
					for(Class_ targetClass_: fumlTarget.types){
						if(class_.qualifiedName.equals(targetClass_.qualifiedName))
							sameType = true;
							break search;
					}
				}
				if(sameType == false)return false;
				
				//compare each feature
				for(FeatureValue featureValue: object_.featureValues){
					for(FeatureValue targetFeatureValue: fumlTarget.featureValues){
						if(targetFeatureValue.feature.name.equals(featureValue.feature.name)){
							if(expression.getOperator() == ArithmeticOperator.EQUAL)
								if(compare(targetFeatureValue, featureValue) == false)return false;
							if(expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
								if(compare(targetFeatureValue, featureValue) == true)return false;
						}
					}
				}
			}
		}
		
		if(expression instanceof PropertyStateExpression){
			PropertyStateExpression propertyExpression = (PropertyStateExpression)expression;
			for(ValueSnapshot snapshot: list){
				Object_ object_ = (Object_)snapshot.getValue();
				FeatureValue featureValue = null;
				for(FeatureValue value: object_.featureValues){
					if(value.feature.name.equals(propertyExpression.getProperty().getName())){
						featureValue = value;
						break;
					}
				}
				if(featureValue == null){
					System.out.println("No such feature!");
					return false;
				}
				for(FeatureValue targetValue: fumlTarget.featureValues){
					if(targetValue.feature.name.equals(propertyExpression.getProperty().getName())){
						if(expression.getOperator() == ArithmeticOperator.EQUAL)
							if(compare(targetValue, featureValue) == false)return false;
						if(expression.getOperator() == ArithmeticOperator.NOT_EQUAL)
							if(compare(targetValue, featureValue) == true)return false;
					}
				}
			}
		}		
		return true;
	}
	
	/** Compares all values for target and real feature values, and returns a result. */
	private boolean compare(FeatureValue targetFeatureValue, FeatureValue featureValue){
		if(targetFeatureValue.values.size() != featureValue.values.size())return false;
		Property property = (Property)targetFeatureValue.feature;
		if(property.association == null){
			for(int i=0;i<targetFeatureValue.values.size();i++){
				if(targetFeatureValue.values.get(i) instanceof StringValue){
					StringValue targetValue = (StringValue)targetFeatureValue.values.get(i);
					StringValue value = (StringValue)featureValue.values.get(i);
					if(targetValue.equals(value))return true;
				}
				if(targetFeatureValue.values.get(i) instanceof IntegerValue){
					IntegerValue targetValue = (IntegerValue)targetFeatureValue.values.get(i);
					IntegerValue value = (IntegerValue)featureValue.values.get(i);
					if(targetValue.value == value.value)return true;
				}
				if(targetFeatureValue.values.get(i) instanceof UnlimitedNaturalValue){
					UnlimitedNaturalValue targetValue = (UnlimitedNaturalValue)targetFeatureValue.values.get(i);
					UnlimitedNaturalValue value = null;
					if(featureValue.values.get(i) instanceof UnlimitedNaturalValue){
						value = (UnlimitedNaturalValue)featureValue.values.get(i);
					}else if(featureValue.values.get(i) instanceof IntegerValue){
						value = new UnlimitedNaturalValue();
						value.type = ((IntegerValue)featureValue.values.get(i)).type;
						value.value = new UnlimitedNatural(((IntegerValue)featureValue.values.get(i)).value);
					}
					if(targetValue.value.naturalValue == value.value.naturalValue)return true;
				}
				if(targetFeatureValue.values.get(i) instanceof BooleanValue){
					BooleanValue targetValue = (BooleanValue)targetFeatureValue.values.get(i);
					BooleanValue value = (BooleanValue)featureValue.values.get(i);
					if(targetValue.value == value.value)return true;
				}
			}
		}else{
			//for links, there are features without any values that we want to skip
			return true;
		}
		return false;
	}
	
	private void initializeLinks(){
		links = new ArrayList<ValueInstance>();
		ArrayList<ValueInstance> allLinks = traceUtil.getAllLinks();
		switch (operator) {
		case AFTER:
			for(ValueInstance instance: allLinks){
				if(predecessors.contains(instance.getCreator()) && instance.getDestroyer() == null){
					links.add(instance);
				}
			}
			break;
		case BEFORE:
			for(ValueInstance instance: allLinks){
				if(!successors.contains(instance.getCreator()) && !predecessors.contains(instance.getDestroyer())){
					links.add(instance);
				}
			}
		default:
			break;		
		}
	}
	
	/**
	 * Initialize predecessor snapshots of valueInstance referred by expression.
	 * @param referredNodeExecution
	 * @param previousSnapshots
	 */
	private void initializePredecessorSnapshots(ActivityNodeExecution referredNodeExecution, List<ValueSnapshot> predecessorSnapshots){
		ActivityNodeExecution predecessor = referredNodeExecution.getChronologicalPredecessor();
		if(predecessor == null)return;
		
		if(assertion.getUntilAction() != null && assertion.getUntilAction().getName().equals(predecessor.getNode().name))
			return;
		
		if(predecessor instanceof ActionExecution){
			for(Input predecesorsInput: ((ActionExecution) predecessor).getInputs()){
				if(predecesorsInput.getInputValues().get(0).getInputValueSnapshot().eContainer() == valueInstance)
					if(predecessorSnapshots.contains(predecesorsInput.getInputValues().get(0).getInputValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsInput.getInputValues().get(0).getInputValueSnapshot());
			}
			for(Output predecesorsOutput: ((ActionExecution) predecessor).getOutputs()){
				if(predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot().eContainer() == valueInstance)
					if(predecessorSnapshots.contains(predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot()) == false)
						predecessorSnapshots.add(predecesorsOutput.getOutputValues().get(0).getOutputValueSnapshot());						
			}
		}
		initializePredecessorSnapshots(predecessor, predecessorSnapshots);
	}
	
	/**
	 * Initialize successor snapshots of valueInstance referred by expression.
	 * @param referredNodeExecution
	 * @param previousSnapshots
	 */
	private void initializeSuccessorSnapshots(ActivityNodeExecution referredNodeExecution, List<ValueSnapshot> successorSnapshots){
		ActivityNodeExecution successor = referredNodeExecution.getChronologicalSuccessor();
		if(successor == null)return;
		
		if(assertion.getUntilAction() != null && assertion.getUntilAction().getName().equals(successor.getNode().name))
			return;
		
		if(successor instanceof ActionExecution){
			for(Input successorsInput: ((ActionExecution) successor).getInputs()){
				if(successorsInput.getInputValues().get(0).getInputValueSnapshot().eContainer() == valueInstance)
					if(successorSnapshots.contains(successorsInput.getInputValues().get(0).getInputValueSnapshot()) == false)
						successorSnapshots.add(successorsInput.getInputValues().get(0).getInputValueSnapshot());
			}
			for(Output successorsOutput: ((ActionExecution) successor).getOutputs()){
				if(successorsOutput.getOutputValues().get(0).getOutputValueSnapshot().eContainer() == valueInstance)
					if(successorSnapshots.contains(successorsOutput.getOutputValues().get(0).getOutputValueSnapshot()) == false)
						successorSnapshots.add(successorsOutput.getOutputValues().get(0).getOutputValueSnapshot());
			}
		}
		initializeSuccessorSnapshots(successor, successorSnapshots);
	}
	
	/** Comparison of simple values: String, Boolean, Double */
	private boolean compareValues(ArithmeticOperator operator, Object value, Object target){
		if(value instanceof String || value instanceof Boolean){
			if(operator == ArithmeticOperator.EQUAL)
				if(!value.equals(target))return false;
			if(operator == ArithmeticOperator.NOT_EQUAL)
				if(value.equals(target))return false;
		}
		if(value instanceof Double){
			if(operator == ArithmeticOperator.EQUAL)
				if(!value.equals(target))return false;
			if(operator == ArithmeticOperator.NOT_EQUAL)
				if(value.equals(target))return false;
			if(operator == ArithmeticOperator.GREATER)
				if((Double)value <= (Double)target)return false;
			if(operator == ArithmeticOperator.GREATER_EQUAL)
				if((Double)value < (Double)target)return false;
			if(operator == ArithmeticOperator.SMALLER)
				if((Double)value >= (Double)target)return false;
			if(operator == ArithmeticOperator.SMALLER_EQUAL)
				if((Double)value > (Double)target)return false;
		}
		return true;
	}
}