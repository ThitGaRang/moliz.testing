/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLModelMessages extends NLS {
	private static final String BUNDLE_NAME = "tudresden.ocl20.pivot.metamodels.fUML.internal.model.messages";
	public static String FUMLAdapterFactory_CreatingPivotModelAdapter;
	public static String FUMLModel_LoadingFUMLModel;

	static {
		NLS.initializeMessages(BUNDLE_NAME, FUMLModelMessages.class);
	}

	// no implementation necessary
	private FUMLModelMessages() {
	}
}