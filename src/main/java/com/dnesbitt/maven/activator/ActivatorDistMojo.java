package com.dnesbitt.maven.activator;

/**
 * Package the Activator application using the native <code>dist</code>
 * command. A zip file with everything necessary to run the application.
 *
 * @goal package
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorDistMojo extends AbstractActivatorMojo {

	@Override
	String command() {
		return "dist";
	}

}
