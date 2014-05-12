package org.modelexecution.fumltesting.jvmmodel

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.modelexecution.fumltesting.testLang.UMLTestSuite

class TestLangJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder

	def dispatch void infer(UMLTestSuite element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
	}
}
