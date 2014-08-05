package com.dnesbitt.maven.activator;

/**
 * Clean the project.
 *
 * @goal clean
 * @phase clean
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorCleanMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "clean";
	}

}
