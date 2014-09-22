package org.modelexecution.fumltesting.uml.ui.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class TestSuiteLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {
	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { new TestSuiteSelectionTab(), new EnvironmentTab(), new CommonTab() };
		setTabs(tabs);
	}
}