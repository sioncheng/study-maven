package com.github.sioncheng.maven.plugins;

import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "buildinfo",
    defaultPhase = LifecyclePhase.COMPILE)
public class BuildInfoMojo extends AbstractMojo {

    @Parameter(property = "project")
    private MavenProject project;

    @Parameter(property = "buildinfo.prefix", defaultValue = "////////")
    private String prefix;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Build build = project.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String testOutputDirectory = build.getTestOutputDirectory();
        String testSourceDirectory = build.getTestSourceDirectory();
        getLog().info("\n==========================\nProject build info:");
        String[] info = {outputDirectory, sourceDirectory, testOutputDirectory, testSourceDirectory};
        for (String item : info) {
            getLog().info("\t" + prefix + "   " + item);
        }
        getLog().info("=======================");
    }
}
