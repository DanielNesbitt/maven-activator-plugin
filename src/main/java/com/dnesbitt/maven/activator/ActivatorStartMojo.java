package com.dnesbitt.maven.activator;

/**
 * Starts the Activator application as a separate process.
 * The corresponding <code>stop</code> goal will end the
 * background process.
 *
 * @goal start
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorStartMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "start";
	}

}
