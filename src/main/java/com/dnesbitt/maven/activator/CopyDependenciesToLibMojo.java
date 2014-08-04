package com.dnesbitt.maven.activator;

import org.apache.commons.io.FileUtils;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.metadata.ArtifactMetadataSource;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactCollector;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.dependency.CopyDependenciesMojo;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Copy project dependencies to the <tt>lib</tt> folder.
 *
 * @goal copy-dependencies
 * @requiresDependencyResolution test
 */
public final class CopyDependenciesToLibMojo extends AbstractMojo {

	/**
	 * The maven project.
	 *
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;


	/**
	 * Used to look up Artifacts in the remote repository.
	 *
	 * @component
	 */
	protected ArtifactFactory factory;

	/**
	 * Used to look up Artifacts in the remote repository.
	 *
	 * @component
	 */
	protected ArtifactResolver resolver;

	/**
	 * Artifact collector, needed to resolve dependencies.
	 *
	 * @component role="org.apache.maven.artifact.resolver.ArtifactCollector"
	 * @required
	 * @readonly
	 */
	protected ArtifactCollector artifactCollector;

	/**
	 * @component role="org.apache.maven.artifact.metadata.ArtifactMetadataSource"
	 * hint="maven"
	 * @required
	 * @readonly
	 */
	protected ArtifactMetadataSource artifactMetadataSource;

	/**
	 * Location of the local repository.
	 *
	 * @parameter expression="${localRepository}"
	 * @readonly
	 * @required
	 */
	private ArtifactRepository local;

	/**
	 * List of Remote Repositories used by the resolver
	 *
	 * @parameter expression="${project.remoteArtifactRepositories}"
	 * @readonly
	 * @required
	 */
	protected List<ArtifactRepository> remoteRepos;

	/**
	 * Where are the dependencies copied.
	 *
	 * @parameter default-value="lib"
	 */
	private File lib;

	public void execute() throws MojoExecutionException {
		try {
			FileUtils.deleteDirectory(lib);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!lib.exists()) {
			lib.mkdirs();
		}

		CopyDependenciesMojo c = new InternalCopyDependenciesMojo(project);

		c.setFactory(factory);
		c.setResolver(resolver);
		c.setArtifactCollector(artifactCollector);
		c.setArtifactMetadataSource(artifactMetadataSource);
		c.setLocal(local);
		c.setRemoteRepos(remoteRepos);
		c.setLocal(local);
		c.setRemoteRepos(remoteRepos);
		c.setOutputDirectory(lib);
		c.setUseRepositoryLayout(false);
		c.setLog(getLog());
		c.setCopyPom(false);

		c.execute();
	}

	private static final class InternalCopyDependenciesMojo extends CopyDependenciesMojo {
		private InternalCopyDependenciesMojo(MavenProject project) {
			super();
			this.project = project;
			overWriteSnapshots = true;
			overWriteReleases = false;
			excludeScope = "provided";
		}
	}
}
