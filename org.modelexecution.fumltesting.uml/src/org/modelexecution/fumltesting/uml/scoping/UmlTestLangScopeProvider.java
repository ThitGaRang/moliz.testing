/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.uml.scoping;

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
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.modelexecution.fumltesting.uml.umlTestLang.FinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActionReferencePoint;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLActivityInput;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLAttribute;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLConstraintCheck;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLFinallyStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLLink;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeOrder;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLNodeSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLObjectStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLOrderAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLPropertyStateExpression;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLScenario;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLStateAssertion;
import org.modelexecution.fumltesting.uml.umlTestLang.UMLTestCase;
import org.modelexecution.fumltesting.xtext.UmlQualifiedNameProvider;

/**
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings({ "deprecation", "restriction" })
public class UmlTestLangScopeProvider extends XbaseScopeProvider {

	private boolean isFilteredOut(ActivityNode node) {
		if (node instanceof Action || node instanceof ActivityFinalNode || node instanceof InitialNode || node instanceof ForkNode || node instanceof JoinNode
				|| node instanceof DecisionNode || node instanceof MergeNode)
			return false;
		return true;
	}

	@Override
	public IScope getScope(EObject context, EReference reference) {

		/** STATE ASSERTION PIN SCOPE */
		if ((context instanceof UMLStateAssertion || context instanceof UMLFinallyStateAssertion) && reference.getName().equals("pin")) {
			Activity activity = (Activity) ((UMLTestCase) context.eContainer()).getActivityUnderTest();
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

		/** ACTIVITY PARAMETER ASSIGNMENT SCOPE */
		if (context instanceof UMLTestCase && reference.getName().equals("parameter")) {
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			Activity activity = (Activity) ((UMLTestCase) context).getActivityUnderTest();
			for (ActivityNode node : activity.getNodes()) {
				if (node.getOwner().equals(activity) && node instanceof ActivityParameterNode
						&& ((ActivityParameterNode) node).getParameter().getDirection() == ParameterDirectionKind.IN_LITERAL)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ACTIVITY CONTEXT OBJECT SCOPE */
		if (context instanceof UMLTestCase && reference.getName().equals("contextObject")) {
			UMLScenario scenario = ((UMLTestCase) context).getInitScenario();
			return Scopes.scopeFor(scenario.getObjects(), new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ATTRIBUTE DECLARATION SCOPE */
		if (context instanceof UMLObjectSpecification && reference.getName().equals("att")) {
			UMLObjectSpecification specification = (UMLObjectSpecification) context;
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : ((Class) specification.getType()).getAttributes()) {
				if (property.getType() instanceof PrimitiveType)
					properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ATTRIBUTE DECLARATION SCOPE - DEEPER REFERENCE */
		if (context instanceof UMLAttribute && reference.getName().equals("att")) {
			UMLObjectSpecification specification = (UMLObjectSpecification) context.eContainer();
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : ((Class) specification.getType()).getAttributes()) {
				if (property.getType() instanceof PrimitiveType)
					properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ORDER NODE DECLARATION SCOPE */
		if (context instanceof UMLOrderAssertion && reference.getName().equals("node")) {
			UMLTestCase testCase = (UMLTestCase) context.eContainer();
			Activity activity = (Activity) testCase.getActivityUnderTest();
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (!isFilteredOut(node))
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** ORDER NODE DECLARATION SCOPE - DEEPER REFERENCE */
		if (context instanceof UMLNodeOrder && reference.getName().equals("node")) {
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			if (context.eContainer().eContainer() instanceof UMLTestCase) {
				UMLTestCase testCase = (UMLTestCase) context.eContainer().eContainer();
				Activity activity = (Activity) testCase.getActivityUnderTest();
				for (ActivityNode node : activity.getNodes()) {
					if (!isFilteredOut(node))
						nodes.add(node);
				}
			}
			if (context.eContainer().eContainer() instanceof UMLNodeOrder) {
				UMLNodeSpecification nodeSpec = (UMLNodeSpecification) context.eContainer();
				if (nodeSpec.getNode() instanceof CallBehaviorAction) {
					CallBehaviorAction action = (CallBehaviorAction) nodeSpec.getNode();
					for (ActivityNode node : ((Activity) action.getBehavior()).getNodes()) {
						if (!isFilteredOut(node))
							nodes.add(node);
					}
				}
				if (nodeSpec.getNode() instanceof CallOperationAction) {
					CallOperationAction action = (CallOperationAction) nodeSpec.getNode();
					for (ActivityNode node : ((Activity) action.getOperation().getMethods().get(0)).getNodes()) {
						if (!isFilteredOut(node))
							nodes.add(node);
					}
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** SUB-ORDER SCOPE */
		if (context instanceof UMLNodeSpecification && reference.getName().equals("node")) {
			ActivityNode node = (ActivityNode) ((UMLNodeSpecification) context).getNode();
			Activity subActivity = null;
			if (node instanceof CallBehaviorAction) {
				subActivity = (Activity) ((CallBehaviorAction) node).getBehavior();
			}
			if (node instanceof CallOperationAction) {
				subActivity = (Activity) ((CallOperationAction) node).getOperation().getMethods().get(0);
			}
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			if (subActivity != null && subActivity.getNodes() != null) {
				for (ActivityNode aNode : subActivity.getNodes()) {
					if (!isFilteredOut(aNode))
						nodes.add(aNode);
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** LINK PROPERTIES DECLARATION SCOPE */
		if (context instanceof UMLLink && (reference.getName().equals("sourceProperty") || reference.getName().equals("targetProperty"))) {
			ArrayList<Property> properties = new ArrayList<Property>();
			for (Property property : ((Association) ((UMLLink) context).getAssoc()).getMemberEnds()) {
				properties.add(property);
			}
			return Scopes.scopeFor(properties, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** LINK VALUES DECLARATION SCOPE */
		if (context instanceof UMLLink && (reference.getName().equals("sourceValue") || reference.getName().equals("targetValue"))) {
			UMLScenario scenario = (UMLScenario) context.eContainer();
			return Scopes.scopeFor(scenario.getObjects(), new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** REFERENCE ACTION AND UNTIL ACTION DECLARATION SCOPE */
		if (context instanceof UMLActionReferencePoint && reference.getName().equals("action")) {
			Activity activity = (Activity) ((UMLTestCase) ((UMLStateAssertion) ((UMLActionReferencePoint) context).eContainer()).eContainer())
					.getActivityUnderTest();
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			for (ActivityNode node : activity.getNodes()) {
				if (node instanceof Action)
					nodes.add(node);
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** PROPERTY DECLARATION SCOPE */
		if (context instanceof UMLPropertyStateExpression && reference.getName().equals("property")) {
			Type type = ((ObjectNode) ((UMLPropertyStateExpression) context).getPin()).getType();
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

		/** ACTIVITY INPUT SCOPE */
		if (context instanceof UMLActivityInput && reference.getName().equals("value")) {
			UMLTestCase testCase = (UMLTestCase) context.eContainer();
			UMLScenario scenario = ((UMLTestCase) testCase).getInitScenario();
			return Scopes.scopeFor(scenario.getObjects(), new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}

		/** PROPERTY AND OBJECT STATE EXPRESSION SCOPE */
		if ((context instanceof UMLObjectStateExpression || context instanceof UMLPropertyStateExpression) && reference.getName().equals("value")) {
			if (context.eContainer() instanceof UMLStateAssertion) {
				UMLStateAssertion stateAssertion = (UMLStateAssertion) context.eContainer();
				UMLTestCase testCase = (UMLTestCase) stateAssertion.eContainer();
				return Scopes.scopeFor(testCase.getInitScenario().getObjects(), new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
			} else if (context.eContainer() instanceof FinallyStateAssertion) {
				FinallyStateAssertion stateAssertion = (FinallyStateAssertion) context.eContainer();
				UMLTestCase testCase = (UMLTestCase) stateAssertion.eContainer();
				return Scopes.scopeFor(testCase.getInitScenario().getObjects(), new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
			}
		}

		/** CONSTRAINT CONTEXT OBJECT SCOPE */
		if (context instanceof UMLConstraintCheck && reference.getName().equals("object")) {
			ArrayList<ActivityNode> nodes = new ArrayList<ActivityNode>();
			UMLTestCase testCase = (UMLTestCase) context.eContainer().eContainer();
			for (ActivityNode node : testCase.getActivityUnderTest().getNodes()) {
				if (node.getOwner() == testCase.getActivityUnderTest() && node instanceof ActivityParameterNode) {
					nodes.add(node);
				}
				if (node instanceof Action) {
					for (OutputPin pin : ((Action) node).getOutputs()) {
						nodes.add(pin);
					}
					for (InputPin pin : ((Action) node).getInputs()) {
						nodes.add(pin);
					}
				}
			}
			return Scopes.scopeFor(nodes, new UmlQualifiedNameProvider(), IScope.NULLSCOPE);
		}
		return super.getScope(context, reference);
	}
}