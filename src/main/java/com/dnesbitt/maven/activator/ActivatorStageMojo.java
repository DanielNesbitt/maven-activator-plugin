package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Package the Activator application using the native <code>stage</code>
 * command. Generates jar files in the <code>target/universal/stage/lib</code>
 * directory.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "stage", defaultPhase = LifecyclePhase.PACKAGE, requiresDependencyResolution = ResolutionScope.COMPILE)
public final class ActivatorStageMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "stage";
	}

}
