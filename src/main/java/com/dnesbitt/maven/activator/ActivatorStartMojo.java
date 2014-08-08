package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Starts the Activator application as a separate process.
 * The corresponding <code>stop</code> goal will end the
 * background process.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "start", requiresProject = false, requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorStartMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "start";
	}

}
