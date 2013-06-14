package org.modelexecution.fumltesting.execution.assertions;

import java.util.List;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectStateExpression;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.StateExpression;
import org.modelexecution.fumltesting.testLang.TestCase;

@SuppressWarnings("restriction")
public class AssertionPrinter {
	
	public static void print(StateExpression stateExpression, boolean result){
		if(stateExpression instanceof ObjectStateExpression){
			ObjectStateExpression expression = (ObjectStateExpression)stateExpression;
			String valueStr = null;
			if(expression.getValue() instanceof SimpleValue){
				if(((SimpleValue)expression.getValue()).getValue() instanceof XNullLiteral){
					valueStr = "null";
				}
				else if(((SimpleValue)expression.getValue()).getValue() instanceof XNumberLiteral){
					valueStr = ((XNumberLiteral)((SimpleValue)expression.getValue()).getValue()).getValue();
				}
				else if(((SimpleValue)expression.getValue()).getValue() instanceof XBooleanLiteral){
					valueStr = String.valueOf((((XBooleanLiteral)((SimpleValue)expression.getValue())).isIsTrue()));
				}
				else if(((SimpleValue)expression.getValue()).getValue() instanceof XStringLiteral){
					valueStr = ((XStringLiteral)((SimpleValue)expression.getValue())).getValue();
				}
				else{
					valueStr = expression.getValue().toString();
				}
				System.out.println(expression.getPin().getRef().getName() 
						+ " " + expression.getOperator() + " " + valueStr);
			}
			if(expression.getValue() instanceof ObjectValue){
				System.out.println(expression.getPin().getRef().getName() 
						+ " " + expression.getOperator() + " " + ((ObjectValue)expression.getValue()).getValue().getName());
			}
			if(result)
				System.out.println("Assertion success!"); 
			else 
				System.out.println("Assertion failed!");
		}
		if(stateExpression instanceof PropertyStateExpression){
			PropertyStateExpression expression = (PropertyStateExpression)stateExpression;
			String valueStr = null;
			Object literal = ((SimpleValue)expression.getValue()).getValue();
			if(expression.getValue() instanceof SimpleValue){
				if(literal instanceof XNullLiteral){
					valueStr = "null";
				}
				else if(literal instanceof XNumberLiteral){
					valueStr = ((XNumberLiteral)literal).getValue();
				}
				else if(literal instanceof XBooleanLiteral){
					valueStr = String.valueOf(((XBooleanLiteral)literal).isIsTrue());
				}
				else if(literal instanceof XStringLiteral){
					valueStr = ((XStringLiteral)literal).getValue();
				}
				else{
					valueStr = expression.getValue().toString();
				}
				System.out.println(expression.getPin().getRef().getName() + " -> " + expression.getProperty().getName() 
						+ " " + expression.getOperator() + " " + valueStr);
			}
			if(result)
				System.out.println("Assertion success!"); 
			else 
				System.out.println("Assertion failed!");
		}
	}
	
	public static void print(List<NodeSpecification> nodeOrder, boolean result){
		System.out.print("Order assertion: ");
		for(int i=0;i<nodeOrder.size();i++){
			if(nodeOrder.get(i).getNode() != null)System.out.print(nodeOrder.get(i).getNode().getName() + ", ");
			if(nodeOrder.get(i).getJoker() != null)System.out.print(nodeOrder.get(i).getJoker() + ", ");
		}
		System.out.println();
		if(result)
			System.out.println("Assertion success!");
		else
			System.out.println("Assertion failed!");
	}
	
	public static void printStateAssertion(StateAssertion assertion){
		System.out.print("State assertion: " + assertion.getTemporalQuantifier() + " " + assertion.getTemporalOperator() + " " + assertion.getReferenceAction().getName());
		if(assertion.getUntilAction() != null)System.out.print(" until " + assertion.getUntilAction().getName());
		System.out.println();
	}

	public static void print(TestCase testCase){
		System.out.println("Running test: " + testCase.getName());
		System.out.println("Activity under test: " + testCase.getActivityUnderTest().getName());
	}
	
	public static void printStartEnd(){
		System.out.println("*********************");
	}
}