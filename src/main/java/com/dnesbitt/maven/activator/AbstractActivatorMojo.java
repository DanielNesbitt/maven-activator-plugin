package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.Map;

/**
 * @author Daniel Nesbitt
 */
abstract class AbstractActivatorMojo extends AbstractMojo {

	/**
	 * Specify additional system properties for running the activator command.
	 */
	@Parameter
	private Map<String,String> activatorProperties;

	/**
	 * The Maven project.
	 */
	@Parameter(required = true, readonly = true, defaultValue = "${project}")
	private MavenProject project;

	abstract String command();

	@Override
	public final void execute() throws MojoExecutionException {
		String activatorHome = System.getProperty("activator.home");
		if (activatorHome == null) {
			throw new MojoExecutionException("No activator.home set.");
		}
		activatorProperties.forEach((k,v) -> getLog().info("Using system property: " + k + "=" + v));

		Activator activator = new Activator(activatorHome, activatorProperties);
		activator.execute(project.getBasedir(), command(), getLog());
	}

}
