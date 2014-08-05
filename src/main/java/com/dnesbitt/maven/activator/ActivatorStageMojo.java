package com.dnesbitt.maven.activator;

/**
 * Package the Activator application using the native <code>dist</code>
 * command. A zip file with everything necessary to run the application.
 *
 * @goal stage
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorStageMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "stage";
	}

}
