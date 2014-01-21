package org.modelexecution.fumltesting;

public class TestLangStandaloneSetup extends TestLangStandaloneSetupGenerated {
	public static void doSetup() {
		new TestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}