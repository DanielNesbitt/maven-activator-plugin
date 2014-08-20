package com.dnesbitt.maven.activator.util;

import com.dnesbitt.util.OS;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author Daniel Nesbitt
 */
public final class Activator {

	// ------------- Version -------------

	private final String activatorHome;
	private final Map<String, String> systemProperties;

	// ------------- Constructor -------------

	public Activator(String activatorHome, Map<String, String> systemProperties) {
		this.activatorHome = activatorHome;
		this.systemProperties = systemProperties;
	}

	// ------------- Public -------------

	public final void execute(File basedir, String command, Log log) throws MojoExecutionException {
		CommandLine cmd = getInitialCommand();

		systemProperties.forEach((k, v) -> cmd.addArgument("-D" + k + "=" + v));

		String ivyHome = System.getProperty("activator.ivy.home");
		if (ivyHome != null) {
			cmd.addArgument("-Dsbt.ivy.home=" + ivyHome);
			cmd.addArgument("-Divy.home=" + ivyHome);
		}

		cmd.addArgument(command);
		DefaultExecutor executor = new DefaultExecutor();
		log.info("Using directory: " + basedir.getAbsolutePath());
		executor.setWorkingDirectory(basedir);

		log.info("Running command: " + cmd);
		executor.setExitValue(0);
		try {
			executor.execute(cmd);
		} catch (Throwable th) {
			throw new MojoExecutionException("Failed invoke activator command.", th);
		}
	}

	// ------------- Private -------------

	private final CommandLine getInitialCommand() throws MojoExecutionException {
		String scriptPath = Paths.get(activatorHome)
				.resolve(OS.isWindows() ? "activator.bat" : "activator")
				.toAbsolutePath().toString();

		if (OS.isWindows()) {
			return CommandLine.parse(scriptPath);
		}

		CommandLine cmd = CommandLine.parse("/bin/bash");
		cmd.addArgument(scriptPath);
		return cmd;
	}

}
