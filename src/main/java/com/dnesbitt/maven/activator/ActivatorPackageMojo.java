package com.dnesbitt.maven.activator;

/**
 * Package the Activator application using the native <code>dist</code>
 * command. A zip file with everything necessary to run the application.
 *
 * @goal package
 * @phase package
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorPackageMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "dist";
	}

}
