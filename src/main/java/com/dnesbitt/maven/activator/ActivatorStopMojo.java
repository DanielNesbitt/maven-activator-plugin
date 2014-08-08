package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Stop the background Activator application.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "stop", requiresProject = false, requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorStopMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "stop";
	}

}
