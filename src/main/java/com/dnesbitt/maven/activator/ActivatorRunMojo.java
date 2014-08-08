package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Launch the Activator application.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "run", requiresProject = false, requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorRunMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "run";
	}

}
