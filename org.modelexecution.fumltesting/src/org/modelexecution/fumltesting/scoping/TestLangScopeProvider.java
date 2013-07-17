package org.modelexecution.fumltesting.scoping;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.modelexecution.fumltesting.testLang.NodeOrder;
import org.modelexecution.fumltesting.testLang.OrderAssertion;
import org.modelexecution.fumltesting.testLang.TestCase;

import com.google.common.base.Predicate;

public class TestLangScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Override
	protected Predicate<Method> getPredicate(EObject context, EClass type) {
		return super.getPredicate(context, type);
	}
	
	IScope scope_NodeOrder_nodes(NodeOrder context, EReference ref) {
		System.out.println("Scope for OrderAssertion called!");
		OrderAssertion assertion = (OrderAssertion)context.eContainer();
		TestCase test = (TestCase)assertion.eContainer();
		Activity activity = test.getActivityUnderTest();
		return Scopes.scopeFor(activity.getNodes());
	}
}