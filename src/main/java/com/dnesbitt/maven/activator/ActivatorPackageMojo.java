package com.dnesbitt.maven.activator;

/**
 * Package the Activator application using the native <code>stage</code>
 * command. Generates jar files in the <code>target/universal/stage/lib</code>
 * directory.
 *
 * @goal package
 * @phase package
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorPackageMojo extends AbstractActivatorMojo {

	@Override
	final String command() {
		return "stage";
	}

}
