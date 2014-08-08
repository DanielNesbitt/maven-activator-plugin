package com.dnesbitt.maven.activator;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Clean the project.
 *
 * @author Daniel Nesbitt
 */
@Mojo(name = "clean", defaultPhase = LifecyclePhase.CLEAN)
public final class ActivatorCleanMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "clean";
	}

}
