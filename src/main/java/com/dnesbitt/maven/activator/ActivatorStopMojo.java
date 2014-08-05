package com.dnesbitt.maven.activator;

/**
 * Stop the background Activator application.
 *
 * @goal stop
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorStopMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "stop";
	}

}
