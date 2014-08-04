package com.dnesbitt.maven.activator;

import com.dnesbitt.maven.activator.util.Activator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Compile the project.
 *
 * @goal compile
 * @phase compile
 *
 * @author Daniel Nesbitt
 */
public final class ActivatorCompileMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Activator.execute("compile");
    }

}
