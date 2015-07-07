/**
 * 
 */
package com.github.sfragata.docker.client.test;

import org.junit.Test;

import com.github.sfragata.docker.client.DockerClient;
import com.github.sfragata.docker.client.DockerClientImpl;

/**
 * @author sfragata
 *
 */
public class DockerClientTest {

	private DockerClient dockerClient = new DockerClientImpl(
			"http://192.168.1.116:2375");

	@Test
	public void testVersion() {
		System.out.println(dockerClient.version());
	}

	@Test
	public void testPing() {
		System.out.println(dockerClient.ping());
	}

	@Test
	public void testContainers() {
		System.out.println(dockerClient.containers());
	}

	@Test
	public void testImages() {
		System.out.println(dockerClient.images());
	}

	@Test
	public void testStartContainer() {
		System.out.println(dockerClient.start("fe63665f7277"));
	}

	@Test
	public void testStopContainer() {
		System.out.println(dockerClient.stop("fe63665f7277"));
	}

	@Test
	public void testRestartContainer() {
		System.out.println(dockerClient.restart("fe63665f7277"));
	}

	@Test
	public void testInspectContainer() {
		System.out.println(dockerClient.inspect("fe63665f7277"));
	}

	@Test
	public void testTopContainer() {
		System.out.println(dockerClient.top("fe63665f7277"));
	}

}
