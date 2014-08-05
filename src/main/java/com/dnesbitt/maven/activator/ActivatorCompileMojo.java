package com.dnesbitt.maven.activator;

/**
 * Compile the project.
 *
 * @goal compile
 * @phase compile
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorCompileMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "compile";
	}

}
