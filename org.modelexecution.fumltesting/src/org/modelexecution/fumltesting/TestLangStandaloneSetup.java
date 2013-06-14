
package org.modelexecution.fumltesting;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TestLangStandaloneSetup extends TestLangStandaloneSetupGenerated{

	public static void doSetup() {
		new TestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

