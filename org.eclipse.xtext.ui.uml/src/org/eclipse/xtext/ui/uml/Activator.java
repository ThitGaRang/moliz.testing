package org.eclipse.xtext.ui.uml;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.apache.log4j.Logger;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.uml.UmlRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

public class Activator extends AbstractUIPlugin {

	private static final Logger logger = Logger.getLogger(Activator.class);
	public static final String PLUGIN_ID = "org.eclipse.xtext.ui.uml"; //$NON-NLS-1$
	private static Activator plugin;
	private Injector injector;
	
	public Activator(){}
	
	public Injector getInjector() { return injector; }
	
	private void initializeEcoreInjector() {
		injector = Guice.createInjector(
				Modules.override(Modules.override(new UmlRuntimeModule())
						.with(new UmlUiModule(plugin)))
						.with(new SharedStateModule()));
	}

	@Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        try { initializeEcoreInjector(); } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

	@Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        injector = null;
        super.stop(context);
    }
	
	public static Activator getDefault() {
		return plugin;
	}
}