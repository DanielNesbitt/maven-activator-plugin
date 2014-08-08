package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Compile the project.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "compile", defaultPhase = LifecyclePhase.COMPILE, requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorCompileMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "compile";
	}

}
