/**
 *
 */
package com.github.sfragata.docker.client.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.sfragata.docker.client.DockerClient;
import com.github.sfragata.docker.client.DockerClientImpl;

/**
 * @author sfragata
 *
 */
@RunWith(Parameterized.class)
public class DockerClientTest {

    private final DockerClient dockerClient;

    public DockerClientTest(final DockerClient pDockerClient) {

        this.dockerClient = pDockerClient;
    }

    @Parameters(name = "{index}: {0}")
    public static Collection<DockerClient> createParams() {

        return Arrays.asList(new DockerClientImpl("http://192.168.1.116:2375"), new DockerClientImpl());
    }

    @Test
    public void testVersion() {

        System.out.println(this.dockerClient.version());
    }

    @Test
    public void testPing() {

        System.out.println(this.dockerClient.ping());
    }

    @Test
    public void testContainers() {

        System.out.println(this.dockerClient.containers());
    }

    @Test
    public void testImages() {

        System.out.println(this.dockerClient.images());
    }

    @Test
    public void testStartContainer() {

        System.out.println(this.dockerClient.start("fe63665f7277"));
    }

    @Test
    public void testStopContainer() {

        System.out.println(this.dockerClient.stop("fe63665f7277"));
    }

    @Test
    public void testRestartContainer() {

        System.out.println(this.dockerClient.restart("fe63665f7277"));
    }

    @Test
    public void testInspectContainer() {

        System.out.println(this.dockerClient.inspect("fe63665f7277"));
    }

    @Test
    public void testTopContainer() {

        System.out.println(this.dockerClient.top("fe63665f7277"));
    }

}
