package org.modelexecution.fumltesting.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

@SuppressWarnings("restriction")
public class TestLangScopeProvider extends XbaseScopeProvider {
//	@Override
//	public IScope getScope(EObject context, EReference reference) {
//		
//		if(context instanceof VarDeclaration && reference.getName().equals("ref")){
//			Activity activity = ((TestCase)context.eContainer()).getActivityUnderTest();
//			List<ObjectNode> nodes = new ArrayList<ObjectNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof ObjectNode){
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
//		
//		if(context instanceof TestCase && reference.getName().equals("parameter")){
//			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
//			Activity activity = ((TestCase)context).getActivityUnderTest();			
//			for(ActivityNode node: activity.getNodes()){
//				if(node.getOwner().equals(activity) && node instanceof ActivityParameterNode)nodes.add(node);
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		
//		if(context instanceof ObjectSpecification && reference.getName().equals("att")){
//			ObjectSpecification specification = (ObjectSpecification)context;
//			ArrayList<Property> properties = new ArrayList<Property>();
//			for(Property property: specification.getType().getAttributes()){
//				if(property.getType() instanceof PrimitiveType)properties.add(property);
//			}
//			return Scopes.scopeFor(properties);
//		}
//		
//		if(context instanceof NodeOrder && reference.getName().equals("node")){
//			TestCase testCase = (TestCase)context.eContainer().eContainer();
//			Activity activity = testCase.getActivityUnderTest();
//			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)nodes.add(node);
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		
//		if(context instanceof Link && (reference.getName().equals("sourceProperty")||reference.getName().equals("targetProperty"))){
//			ArrayList<Property> properties = new ArrayList<Property>();
//			for(Property property: ((Link)context).getAssoc().getMemberEnds()){
//				properties.add(property);
//			}			
//			return Scopes.scopeFor(properties);
//		}
//		
//		if(context instanceof StateAssertion && reference.getName().equals("referenceAction")){
//			Activity activity = ((TestCase)((StateAssertion)context).eContainer()).getActivityUnderTest();
//			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
//			for(ActivityNode node: activity.getNodes()){
//				if(node instanceof Action)nodes.add(node);
//			}
//			return Scopes.scopeFor(nodes);
//		}
//		
//		return super.getScope(context, reference);		
//	}
}