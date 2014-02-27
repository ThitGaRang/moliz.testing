/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal;

import org.apache.log4j.Logger;

import org.eclipse.core.runtime.Plugin;

import org.osgi.framework.BundleContext;

import tudresden.ocl20.logging.LoggingPlugin;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLMetamodelPlugin extends Plugin {
	public static final String ID = "tudresden.ocl20.pivot.metamodels.fuml";
	private static FUMLMetamodelPlugin plugin;

	public FUMLMetamodelPlugin() {
		plugin = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		LoggingPlugin.configureDefaultLogging(plugin);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static FUMLMetamodelPlugin getDefault() {
		return plugin;
	}

	public static Logger getLogger(Class<?> clazz) {
		return LoggingPlugin.getLogManager(plugin).getLogger(clazz);
	}
}