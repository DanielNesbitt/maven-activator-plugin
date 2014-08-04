package com.dnesbitt.maven.activator.util;

import com.dnesbitt.util.OS;
import com.dnesbitt.util.Zip;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.http.client.fluent.Request;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Daniel Nesbitt
 */
public final class Activator {

	// ------------- Version -------------

	private final String version;

	// ------------- Constructor -------------

	private Activator(String version) {
		this.version = version;
	}

	// ------------- Public -------------

	public static void execute(String command) {
		Activator activator = new Activator("1.2.3");
		activator._execute(command);
	}

	// ------------- Private -------------

	private void _execute(String command) {
		downloadActivatorIfNeeded();
		String pathToScript = getActivatorScript().getAbsolutePath();

		CommandLine cmd = CommandLine.parse(pathToScript);
		cmd.addArgument(command);
		DefaultExecutor executor = new DefaultExecutor();

		executor.setExitValue(0);
		try {
			executor.execute(cmd);
		} catch (IOException e) {
			// Ignore.
		}
	}

	private void downloadActivatorIfNeeded() {
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
				throw new RuntimeException("Failed to download activator.", e);
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

	// -------------------- Main --------------------

	public static final void main(String[] args) throws Exception {
		Activator.execute("clean");
	}

}
