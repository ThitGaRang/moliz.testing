/*
* generated by Xtext
*/
package org.modelexecution.fumltesting.uml;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class UmlTestLangUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return org.modelexecution.fumltesting.uml.ui.internal.UmlTestLangActivator.getInstance().getInjector("org.modelexecution.fumltesting.uml.UmlTestLang");
	}
	
}
