/**
 * 
 */
package com.github.sfragata.docker.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.sfragata.docker.client.message.Container;
import com.github.sfragata.docker.client.message.Image;
import com.github.sfragata.docker.client.message.MetaData;
import com.github.sfragata.docker.client.message.ProcessResult;
import com.github.sfragata.docker.client.message.Version;

/**
 * @author sfragata
 */
public class DockerClientImpl implements DockerClient {

	private static final String RESTART_PATH = "restart";
	private static final String STOP_PATH = "stop";
	private static final String START_PATH = "start";
	private static final String ALL_QUERY_PARAM = "all";
	private static final String JSON_PATH = "json";
	private static final String CONTAINERS_PATH = "containers";
	private static final String RESP_OK = "OK";
	private static final String PING_PATH = "_ping";
	private static final String VERSION_PATH = "version";
	private URI dockerURL;
	private Client webClient;

	private enum HttpMethod {
		GET, POST
	}

	public DockerClientImpl(String url) {
		dockerURL = URI.create(url);
		webClient = ClientBuilder.newClient();
	}

	private WebTarget getWebTarget() {
		return webClient.target(dockerURL);
	}

	private <T> T request(WebTarget target, HttpMethod method, Class<T> clazz,
			MediaType mediaType) {
		Response response = send(target, method, mediaType);

		return response.readEntity(clazz);
	}

	private Response send(WebTarget target, HttpMethod method,
			MediaType mediaType) {
		Invocation.Builder builder = null;
		if (mediaType != null) {
			builder = target.request(mediaType);
		} else {
			builder = target.request();
		}
		return builder.method(method.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#version()
	 */
	@Override
	public Version version() {
		return request(getWebTarget().path(VERSION_PATH), HttpMethod.GET,
				Version.class, MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#ping()
	 */
	@Override
	public boolean ping() {

		String response = request(getWebTarget().path(PING_PATH),
				HttpMethod.GET, String.class, null);
		return RESP_OK.equals(response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#images()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> images() {

		return request(getWebTarget().path("images").path(JSON_PATH),
				HttpMethod.GET, List.class, MediaType.APPLICATION_JSON_TYPE);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#containers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Container> containers() {

		return request(getWebTarget().path(CONTAINERS_PATH).path(JSON_PATH)
				.queryParam(ALL_QUERY_PARAM, 1), HttpMethod.GET, List.class,
				MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#inspect(java.lang.String)
	 */
	@Override
	public MetaData inspect(String containerId) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#top(java.lang.String)
	 */
	@Override
	public List<ProcessResult> top(String containerId) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#start(java.lang.String)
	 */
	@Override
	public boolean start(String containerId) {

		return executeAction(containerId, START_PATH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#stop(java.lang.String)
	 */
	@Override
	public boolean stop(String containerId) {

		return executeAction(containerId, STOP_PATH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#restart(java.lang.String)
	 */
	@Override
	public boolean restart(String containerId) {

		return executeAction(containerId, RESTART_PATH);
	}

	private boolean executeAction(String containerId, String action) {
		Response response = send(
				getWebTarget().path(CONTAINERS_PATH).path(containerId)
						.path(action), HttpMethod.POST, null);
		return 204 == response.getStatus();
		/**
		 * 204 – no error 304 – container already started 404 – no such
		 * container 500 – server error
		 */
	}
}
