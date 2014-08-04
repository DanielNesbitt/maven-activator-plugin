package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Clean the project.
 *
 * @goal clean
 * @phase clean
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorCleanMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        Activator.execute("stop");
    }

}
