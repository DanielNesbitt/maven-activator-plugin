package com.dnesbitt.maven.activator;

/**
 * Launch the Activator application.
 *
 * @goal run
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorRunMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "run";
	}

}
