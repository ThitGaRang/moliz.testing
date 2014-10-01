/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Stefan Mijatov
 */
package org.modelexecution.fumltesting.uml.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class TestSuiteSelectionTab extends AbstractLaunchConfigurationTab {
	private Text modelResourceText;
	private Text testSuiteResourceText;
	private Text oclResourceText;

	private Button browseModelResourceButton;
	private Button browseTestSuiteResourceButton;
	private Button browseOclResourceButton;

	private Button bruteForceCheckButton;

	private boolean bruteForceOn = false;

	public void createControl(Composite parent) {
		Font font = parent.getFont();
		Composite comp = createContainerComposite(parent, font);
		createVerticalSpacer(comp, 3);
		createResourceSelectionControls(font, comp);
		createVerticalSpacer(comp, 10);
		createVerticalSpacer(comp, 3);
	}

	private Composite createContainerComposite(Composite parent, Font font) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout();
		topLayout.verticalSpacing = 0;
		topLayout.numColumns = 3;
		comp.setLayout(topLayout);
		comp.setFont(font);
		return comp;
	}

	private void createResourceSelectionControls(Font font, Composite comp) {
		createModelResourceLabel(font, comp);
		createModelResourceTextControl(font, comp);
		createModelResourceBrowseButton(comp);

		createTestSuiteResourceLabel(font, comp);
		createTestSuiteResourceTextControl(font, comp);
		createTestSuiteResourceBrowseButton(comp);

		createOclResourceLabel(font, comp);
		createOclResourceTextControl(font, comp);
		createOclResourceBrowseButton(comp);

		createBruteForceCheckLabel(font, comp);
		createBruteForceCheckButton(comp);
	}

	private void createModelResourceBrowseButton(Composite comp) {
		browseModelResourceButton = createPushButton(comp, "&Browse", null);
		browseModelResourceButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				browseModelResource();
			}
		});
	}

	private void createTestSuiteResourceBrowseButton(Composite comp) {
		browseTestSuiteResourceButton = createPushButton(comp, "&Browse", null);
		browseTestSuiteResourceButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				browseTestSuiteResource();
			}
		});
	}

	private void createOclResourceBrowseButton(Composite comp) {
		browseOclResourceButton = createPushButton(comp, "&Browse", null);
		browseOclResourceButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				browseOclResource();
			}
		});
	}

	private void createBruteForceCheckButton(Composite comp) {
		bruteForceCheckButton = new Button(comp, SWT.CHECK);
		bruteForceCheckButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				bruteForceOn = !bruteForceOn;
				updateLaunchConfigurationDialog();
			}
		});
	}

	private void createModelResourceTextControl(Font font, Composite comp) {
		GridData gd;
		modelResourceText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		modelResourceText.setLayoutData(gd);
		modelResourceText.setFont(font);
		modelResourceText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	private void createTestSuiteResourceTextControl(Font font, Composite comp) {
		GridData gd;
		testSuiteResourceText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		testSuiteResourceText.setLayoutData(gd);
		testSuiteResourceText.setFont(font);
		testSuiteResourceText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	private void createOclResourceTextControl(Font font, Composite comp) {
		GridData gd;
		oclResourceText = new Text(comp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		oclResourceText.setLayoutData(gd);
		oclResourceText.setFont(font);
		oclResourceText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	private void createModelResourceLabel(Font font, Composite comp) {
		Label modelResourceLabel = new Label(comp, SWT.NONE);
		modelResourceLabel.setText("&UML Model Resource:");
		GridData gd = new GridData(GridData.BEGINNING);
		modelResourceLabel.setLayoutData(gd);
		modelResourceLabel.setFont(font);
	}

	private void createTestSuiteResourceLabel(Font font, Composite comp) {
		Label testSuiteResourceLabel = new Label(comp, SWT.NONE);
		testSuiteResourceLabel.setText("&TestSuite Resource:");
		GridData gd = new GridData(GridData.BEGINNING);
		testSuiteResourceLabel.setLayoutData(gd);
		testSuiteResourceLabel.setFont(font);
	}

	private void createOclResourceLabel(Font font, Composite comp) {
		Label oclResourceLabel = new Label(comp, SWT.NONE);
		oclResourceLabel.setText("&OCL Resource:");
		GridData gd = new GridData(GridData.BEGINNING);
		oclResourceLabel.setLayoutData(gd);
		oclResourceLabel.setFont(font);
	}

	private void createBruteForceCheckLabel(Font font, Composite comp) {
		Label bruteForceCheckLabel = new Label(comp, SWT.NONE);
		bruteForceCheckLabel.setText("&Brute Force Check:");
		GridData gd = new GridData(GridData.BEGINNING);
		bruteForceCheckLabel.setLayoutData(gd);
		bruteForceCheckLabel.setFont(font);
	}

	protected void browseModelResource() {
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		dialog.setTitle("UML Model Resource");
		dialog.setMessage("Select a UML Model resource to test");
		if (dialog.open() == Window.OK) {
			Object[] files = dialog.getResult();
			IFile file = (IFile) files[0];
			modelResourceText.setText(file.getLocation().toString());
		}

	}

	protected void browseTestSuiteResource() {
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		dialog.setTitle("Test Suite Resource");
		dialog.setMessage("Select a Test Suite resource to run");
		if (dialog.open() == Window.OK) {
			Object[] files = dialog.getResult();
			IFile file = (IFile) files[0];
			testSuiteResourceText.setText(file.getLocation().toString());
		}

	}

	protected void browseOclResource() {
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		dialog.setTitle("OCL Resource");
		dialog.setMessage("Select a OCL resource containing constraints to be checked");
		if (dialog.open() == Window.OK) {
			Object[] files = dialog.getResult();
			IFile file = (IFile) files[0];
			oclResourceText.setText(file.getLocation().toString());
		}

	}

	protected IResource getModelResource() {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(modelResourceText.getText());
	}

	protected IResource getTestSuiteResource() {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(testSuiteResourceText.getText());
	}

	protected IResource getOclResource() {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(oclResourceText.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if (isModelResourceEmpty()) {
			setErrorMessage("Select a resource containing a UML model.");
			return false;
		}
		if (isTestSuiteResourceEmpty()) {
			setErrorMessage("Select a resource containing a Test Suite.");
			return false;
		}
		return true;
	}

	private boolean isModelResourceEmpty() {
		return modelResourceText.getText().isEmpty();
	}

	private boolean isTestSuiteResourceEmpty() {
		return testSuiteResourceText.getText().isEmpty();
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		String defValModelResourceText = "";
		String defValTestSuiteResourceText = "";
		String defValOclResourceText = "";
		boolean defValBruteForceOn = false;

		try {
			defValModelResourceText = configuration.getAttribute("model", "");
			defValTestSuiteResourceText = configuration.getAttribute("testSuite", "");
			defValOclResourceText = configuration.getAttribute("ocl", "");
			defValBruteForceOn = configuration.getAttribute("bruteForceOn", false);
		} catch (CoreException e) {

		}

		modelResourceText.setText(defValModelResourceText == null ? "" : defValModelResourceText);
		testSuiteResourceText.setText(defValTestSuiteResourceText == null ? "" : defValTestSuiteResourceText);
		oclResourceText.setText(defValOclResourceText == null ? "" : defValOclResourceText);
		if (bruteForceOn) {
			bruteForceCheckButton.setSelection(true);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("model", modelResourceText.getText().trim());
		configuration.setAttribute("testSuite", testSuiteResourceText.getText().trim());
		configuration.setAttribute("ocl", oclResourceText.getText().trim());
		configuration.setAttribute("bruteForceOn", bruteForceOn);
	}

	@Override
	public String getName() {
		return "Test Suite Run";
	}
}