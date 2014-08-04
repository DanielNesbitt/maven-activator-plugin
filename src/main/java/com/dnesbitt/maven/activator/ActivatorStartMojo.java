package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Starts the Activator application as a separate process.
 * The corresponding <code>stop</code> goal will end the
 * background process.
 *
 * @goal start
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorStartMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        Activator.execute("start");
    }

}
