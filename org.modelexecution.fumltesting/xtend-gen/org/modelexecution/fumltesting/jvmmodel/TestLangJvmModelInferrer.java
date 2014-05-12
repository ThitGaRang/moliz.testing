package org.modelexecution.fumltesting.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.modelexecution.fumltesting.testLang.UMLTestSuite;

@SuppressWarnings("all")
public class TestLangJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final UMLTestSuite element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
  }
  
  public void infer(final EObject element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (element instanceof UMLTestSuite) {
      _infer((UMLTestSuite)element, acceptor, isPreIndexingPhase);
      return;
    } else if (element != null) {
      _infer(element, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPreIndexingPhase).toString());
    }
  }
}
