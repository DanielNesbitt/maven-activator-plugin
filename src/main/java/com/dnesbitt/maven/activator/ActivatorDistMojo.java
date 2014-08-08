package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Package the Activator application using the native <code>dist</code>
 * command. A zip file with everything necessary to run the application.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "dist", requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorDistMojo extends AbstractActivatorMojo {

	@Override
	String command() {
		return "dist";
	}

}
