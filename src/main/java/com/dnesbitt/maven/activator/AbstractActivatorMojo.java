package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.util.Map;

/**
 * @author Daniel Nesbitt
 */
abstract class AbstractActivatorMojo extends AbstractMojo {

	/**
	 * Which version of the activator to download.
	 *
	 * @parameter expression="${activatorVersion}" default-value="1.2.3"
	 */
	private String activatorVersion;

	/**
	 * Specify additional system properties for running the activator command.
	 *
	 * @parameter expression="${activatorProperties}"
	 */
	private Map<String,String> activatorProperties;

	abstract String command();

	@Override
	public final void execute() throws MojoExecutionException {
		getLog().info("Running activator version: " + activatorVersion);
		activatorProperties.forEach((k,v) -> getLog().info("Using system property: " + k + "=" + v));

		Activator activator = new Activator(activatorVersion, activatorProperties);
		activator.execute(command(), getLog());
	}

}
