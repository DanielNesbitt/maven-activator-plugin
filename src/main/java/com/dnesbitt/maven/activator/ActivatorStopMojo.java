package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Stop the background Activator application.
 *
 * @goal stop
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorStopMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        Activator.execute("stop");
    }

}
