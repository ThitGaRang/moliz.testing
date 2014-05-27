package org.modelexecution.fumltesting;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.modelexecution.fumltesting.scoping.TestLangScopeProvider;
import org.modelexecution.fumltesting.xtext.UmlQualifiedNameProvider;

public class TestLangRuntimeModule extends org.modelexecution.fumltesting.AbstractTestLangRuntimeModule {
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return TestLangScopeProvider.class;
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return UmlQualifiedNameProvider.class;
	}
}