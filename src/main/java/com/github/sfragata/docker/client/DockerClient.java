package com.github.sfragata.docker.client;

import java.util.List;

import com.github.sfragata.docker.client.message.Container;
import com.github.sfragata.docker.client.message.Image;
import com.github.sfragata.docker.client.message.MetaData;
import com.github.sfragata.docker.client.message.ProcessResult;
import com.github.sfragata.docker.client.message.Version;

/**
 * @author sfragata
 *
 */
public interface DockerClient {

	Version version();

	boolean ping();

	List<Image> images();

	List<Container> containers();

	MetaData inspect(String containerId);

	List<ProcessResult> top(String containerId);

	boolean start(String containerId);

	boolean stop(String containerId);

	boolean restart(String containerId);

}
