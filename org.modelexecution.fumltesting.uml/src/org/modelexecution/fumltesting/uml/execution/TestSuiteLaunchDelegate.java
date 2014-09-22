package org.modelexecution.fumltesting.uml.execution;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class TestSuiteLaunchDelegate extends LaunchConfigurationDelegate {
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String modelResource = configuration.getAttribute("model", "");
		String testSuiteResource = configuration.getAttribute("testSuite", "");
		String oclResource = configuration.getAttribute("ocl", "");

		UmlTestExecutor executor = new UmlTestExecutor();
		executor.setModelResource(modelResource);
		executor.setTestSuiteResource(testSuiteResource);
		executor.setOclResource(oclResource);

		MessageConsole myConsole = findConsole("console");
		MessageConsoleStream out = myConsole.newMessageStream();
		myConsole.clearConsole();
		myConsole.activate();

		executor.setOutput(out);
		executor.runTests();
	}

	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
}