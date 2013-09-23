package org.modelexecution.fumltesting.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.operations.ActionOperations;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

@SuppressWarnings("restriction")
public class TestLangScopeProvider extends XbaseScopeProvider {
	@Override
	public IScope getScope(EObject context, EReference reference) {
		/** For variable declaration we constraint 
		 * the referenced nodes to those that belong 
		 * to the activity under test. 
		 **/
//		if(context instanceof VarDeclaration && reference.getName().equals("ref")){
//			Activity activity = ((TestCase)context.eContainer()).getActivityUnderTest();
//			List<ObjectNode> nodes = new ArrayList<ObjectNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof InputPin || node instanceof OutputPin || node instanceof ActivityParameterNode){
//					nodes.add((ObjectNode)node);
//				}
//				if(node instanceof Action){
//					for(ObjectNode inNode: ((Action)node).getInputs()){
//						nodes.add(inNode);
//					}
//					for(ObjectNode outNode: ((Action)node).getOutputs()){
//						nodes.add(outNode);
//					}
//				}
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		if(context instanceof ObjectSpecification && reference.getName().equals("att")){
//			ObjectSpecification specification = (ObjectSpecification)context;
//			ArrayList<Property> properties = new ArrayList<Property>();
//			for(Property property: specification.getType().getAllAttributes()){
//				if(property.getType() instanceof PrimitiveType)properties.add(property);
//			}
//			return Scopes.scopeFor(properties);
//		}
//		
//		if(context instanceof OrderAssertion && reference.getName().equals("node")){
//			TestCase testCase = (TestCase)context.eContainer();
//			Activity activity = testCase.getActivityUnderTest();
//			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)nodes.add(node);
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		
//		if(context instanceof TestCase && reference.getName().equals("parameter")){
//			Activity activity = ((TestCase)context).getActivityUnderTest();
//			ArrayList<ActivityParameterNode> nodes = new ArrayList<ActivityParameterNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof ActivityParameterNode && 
//						((ActivityParameterNode)node).getParameter().getDirection().getValue() == ParameterDirectionKind.IN)
//					nodes.add((ActivityParameterNode)node);
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		
//		if(context instanceof Link && (reference.getName().equals("sourceProperty")||reference.getName().equals("targetProperty"))){
//			ArrayList<Property> properties = new ArrayList<Property>();
//			for(ObjectSpecification specification: ((Scenario)context.eContainer()).getObjects()){
//				for(Property property: specification.getType().getAllAttributes()){
//					if(property.getType() instanceof org.eclipse.uml2.uml.Class)properties.add(property);
//				}
//			}			
//			return Scopes.scopeFor(properties);
//		}
		return super.getScope(context, reference);		
	}
}