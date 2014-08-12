package com.dnesbitt.maven.activator.util;

import com.dnesbitt.util.OS;
import com.dnesbitt.util.Zip;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.http.client.fluent.Request;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author Daniel Nesbitt
 */
public final class Activator {

	// ------------- Version -------------

	private final String version;
	private final Map<String, String> systemProperties;

	// ------------- Constructor -------------

	public Activator(String version, Map<String, String> systemProperties) {
		this.version = version;
		this.systemProperties = systemProperties;
	}

	// ------------- Public -------------

	public final void execute(File basedir, String command, Log log) throws MojoExecutionException {
		downloadActivatorIfNeeded();

		CommandLine cmd = getInitialCommand();

		systemProperties.forEach((k, v) -> cmd.addArgument("-D" + k + "=" + v));

		String ivyHome = System.getProperty("activator.ivy.home");
		if (ivyHome != null) {
			cmd.addArgument("-D" + "sbt.ivy.home" + "=" + ivyHome);
			cmd.addArgument("-D" + "ivy.home" + "=" + ivyHome);
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

	private final CommandLine getInitialCommand() {
		String scriptPath = getActivatorScript().getAbsolutePath();
		if (OS.isWindows()) {
			return CommandLine.parse(scriptPath);
		}
		CommandLine cmd = CommandLine.parse("/bin/bash");
		cmd.addArgument(scriptPath);
		return cmd;
	}

	private void downloadActivatorIfNeeded() throws MojoExecutionException {
		if (!getActivatorScript().exists()) {
			File outputDir = getActivatorDirectory().toFile();

			String url = "http://downloads.typesafe.com/typesafe-activator/${version}/typesafe-activator-${version}-minimal.zip".replace("${version}", version);
			try (InputStream is = Request.Get(url)
					.execute()
					.returnContent()
					.asStream()
			) {
				Zip.unzipToDirectory(is, outputDir);
			} catch (IOException e) {
				throw new MojoExecutionException("Failed to download activator.", e);
			}
		}
	}

	private File getActivatorScript() {
		return getActivatorDirectory()
				.resolve("activator-" + version + "-minimal")
				.resolve(OS.isWindows() ? "activator.bat" : "activator")
				.toFile();
	}

	private Path getActivatorDirectory() {
		return Paths.get(System.getProperty("user.home"))
				.resolve(".activator");
	}

}
