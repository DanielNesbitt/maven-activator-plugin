package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Package the Activator application using the native <code>dist</code>
 * command. A zip file with everything necessary to run the application.
 *
 * @goal package
 * @phase package
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorPackageMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        Activator.execute("dist");
    }

}