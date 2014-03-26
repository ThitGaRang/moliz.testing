/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
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
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.uml.UmlQualifiedNameProvider;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.modelexecution.fumltesting.testLang.Attribute;
import org.modelexecution.fumltesting.testLang.Link;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.NodeSpecification;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.PropertyStateExpression;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.StateAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;
import org.modelexecution.fumltesting.testLang.TestSuite;
import org.modelexecution.fumltesting.testLang.VarDeclaration;

/**
 * Utility class for scoping in TestLang editor.
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class TestLangScopeProvider extends XbaseScopeProvider {
	@Override
	public IScope getScope(EObject context, EReference reference) {

		/** VARIABLE DECLARATION SCOPE */
		if (context instanceof VarDeclaration && reference.getName().equals("ref")) {
			Activity activity = ((TestCase) context.eContainer()).getActivityUnderTest();
			List<ObjectNode> nodes = new ArrayList<ObjectNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof ObjectNode) {
					nodes.add((ObjectNode) node);
				}
				if (node instanceof Action) {
					for (ObjectNode inNode : ((Action) node).getInputs()) {
						nodes.add(inNode);
					}
					for (ObjectNode outNode : ((Action) node).getOutputs()) {
						nodes.add(outNode);
					}
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** INIT SCENARIOS DECLARATION SCOPE */
		if (context instanceof TestCase && reference.getName().equals("initScenarios")) {
			ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
			TestSuite suite = (TestSuite) ((TestCase) context).eContainer();
			for (Scenario scenario : suite.getScenarios()) {
				scenarios.add(scenario);
			}
			return Scopes.scopeFor(scenarios, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ACTIVITY PARAMETER ASSIGNMENT SCOPE */
		if (context instanceof TestCase && reference.getName().equals("parameter")) {
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			Activity activity = ((TestCase) context).getActivityUnderTest();
			for (ActivityNode node : activity.getNodes()) {
				if (node.getOwner().equals(activity) && node instanceof ActivityParameterNode)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ATTRIBUTE DECLARATION SCOPE */
		if (context instanceof ObjectSpecification && reference.getName().equals("att")) {
			ObjectSpecification specification = (ObjectSpecification) context;
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : specification.getType().getAttributes()) {
				if (property.getType() instanceof PrimitiveType)
					properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ATTRIBUTE DECLARATION SCOPE - DEEPER REFERENCE */
		if (context instanceof Attribute && reference.getName().equals("att")) {
			ObjectSpecification specification = (ObjectSpecification) context.eContainer();
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : specification.getType().getAttributes()) {
				if (property.getType() instanceof PrimitiveType)
					properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ORDER NODE DECLARATION SCOPE */
		if (context instanceof OrderAssertion && reference.getName().equals("node")) {
			TestCase testCase = (TestCase) context.eContainer();
			Activity activity = testCase.getActivityUnderTest();
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ORDER NODE DECLARATION SCOPE - DEEPER REFERENCE */
		if (context instanceof NodeOrder && reference.getName().equals("node")) {
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			if (context.eContainer().eContainer() instanceof TestCase) {
				TestCase testCase = (TestCase) context.eContainer().eContainer();
				Activity activity = testCase.getActivityUnderTest();
				for (ActivityNode node : activity.getNodes()) {
					if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)
						nodes.add(node);
				}
			}
			if (context.eContainer().eContainer() instanceof NodeOrder) {
				NodeSpecification nodeSpec = (NodeSpecification) context.eContainer();
				if (nodeSpec.getNode() instanceof CallBehaviorAction) {
					CallBehaviorAction action = (CallBehaviorAction) nodeSpec.getNode();
					for (ActivityNode node : ((Activity) action.getBehavior()).getNodes()) {
						if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)
							nodes.add(node);
					}
				}
				if (nodeSpec.getNode() instanceof CallOperationAction) {
					CallOperationAction action = (CallOperationAction) nodeSpec.getNode();
					for (ActivityNode node : ((Activity) action.getOperation().getMethods().get(0)).getNodes()) {
						if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode)
							nodes.add(node);
					}
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** SUB-ORDER SCOPE */
		if (context instanceof NodeSpecification && reference.getName().equals("node")) {
			ActivityNode node = ((NodeSpecification) context).getNode();
			Activity subActivity = null;
			if (node instanceof CallBehaviorAction) {
				subActivity = (Activity) ((CallBehaviorAction) node).getBehavior();
			}
			if (node instanceof CallOperationAction) {
				subActivity = (Activity) ((CallOperationAction) node).getOperation().getMethods().get(0);
			}
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			if(subActivity != null && subActivity.getNodes() != null){
				for (ActivityNode aNode : subActivity.getNodes()) {
					if (aNode instanceof Action || aNode instanceof ActivityFinalNode || aNode instanceof InitialNode)
						nodes.add(aNode);
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** LINK PROPERTIES DECLARATION SCOPE */
		if (context instanceof Link && (reference.getName().equals("sourceProperty") || reference.getName().equals("targetProperty"))) {
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : ((Link) context).getAssoc().getMemberEnds()) {
				properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** REFERENCE ACTION DECLARATION SCOPE */
		if (context instanceof StateAssertion && reference.getName().equals("referenceAction")) {
			Activity activity = ((TestCase) ((StateAssertion) context).eContainer()).getActivityUnderTest();
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof Action)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** UNTIL ACTION DECLARATION SCOPE */
		if (context instanceof StateAssertion && reference.getName().equals("untilAction")) {
			Activity activity = ((TestCase) ((StateAssertion) context).eContainer()).getActivityUnderTest();
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof Action)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** PROPERTY DECLARATION SCOPE */
		if (context instanceof PropertyStateExpression && reference.getName().equals("property")) {
			Type type = ((PropertyStateExpression) context).getPin().getRef().getType();
			ArrayList<Property> properties = new ArrayList<Property>();

			if (type == null)
				return super.getScope(context, reference);

			properties.addAll(((Class) type).getAllAttributes());
			Package package_ = (Package) type.getOwner();
			for (Element element : package_.getOwnedElements()) {
				if (element instanceof Association && ((Association) element).getEndTypes().contains(type)) {
					for (Property property : (((Association) element).getNavigableOwnedEnds())) {
						if (!property.getType().getName().equals(type.getName()))
							properties.add(property);
					}
				}
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		return super.getScope(context, reference);
	}
}