package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Launch the Activator application.
 *
 * @goal run
 * @requiresProject false
 * @requiresDependencyResolution provided
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorRunMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        Activator.execute("run");
    }

}
