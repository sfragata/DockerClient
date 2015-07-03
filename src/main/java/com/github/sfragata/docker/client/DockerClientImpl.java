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
import com.github.sfragata.docker.client.message.ContainerMetaData;
import com.github.sfragata.docker.client.message.Image;
import com.github.sfragata.docker.client.message.ProcessResult;
import com.github.sfragata.docker.client.message.Version;

/**
 * @author sfragata
 */
public class DockerClientImpl implements DockerClient {

	private static final String RESP_OK = "OK";

	private URI dockerURL;
	private Client webClient;

	private enum Path {
		RESTART, STOP, START, JSON, CONTAINERS, VERSION, _PING, IMAGES, TOP;

		public String path() {
			return name().toLowerCase();
		}
	}

	private enum QueryParam {
		ALL, STOP, PS_ARGS;

		public String queryParam() {
			return name().toLowerCase();
		}
	}

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

		/*
		 * 200 – no error 500 – server error
		 */
		return request(getWebTarget().path(Path.VERSION.path()),
				HttpMethod.GET, Version.class, MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#ping()
	 */
	@Override
	public boolean ping() {
		/*
		 * 200 – no error 500 – server error
		 */

		String response = request(getWebTarget().path(Path._PING.path()),
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

		return request(
				getWebTarget().path(Path.IMAGES.path()).path(Path.JSON.path()),
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

		/*
		 * 200 – no error 400 – bad parameter 500 – server error
		 */
		return request(
				getWebTarget().path(Path.CONTAINERS.path())
						.path(Path.JSON.path())
						.queryParam(QueryParam.ALL.queryParam(), 1),
				HttpMethod.GET, List.class, MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#inspect(java.lang.String)
	 */
	@Override
	public ContainerMetaData inspect(String containerId) {
		/*
		 * 200 – no error 404 – no such container 500 – server error
		 */
		return request(
				getWebTarget().path(Path.CONTAINERS.path()).path(containerId)
						.path(Path.JSON.path()), HttpMethod.GET,
				ContainerMetaData.class, MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#top(java.lang.String)
	 */
	@Override
	public ProcessResult top(String containerId) {
		/*
		 * 200 – no error 404 – no such container 500 – server error
		 */
		return request(
				getWebTarget().path(Path.CONTAINERS.path()).path(containerId)
						.path(Path.TOP.path())
						.queryParam(QueryParam.PS_ARGS.queryParam(), "aux"),
				HttpMethod.GET, ProcessResult.class,
				MediaType.APPLICATION_JSON_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#start(java.lang.String)
	 */
	@Override
	public boolean start(String containerId) {

		/*
		 * 204 – no error 304 – container already started 404 – no such
		 * container 500 – server error
		 */
		return executeAction(containerId, Path.START.path());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#stop(java.lang.String)
	 */
	@Override
	public boolean stop(String containerId) {
		/*
		 * 204 – no error 304 – container already stopped 404 – no such
		 * container 500 – server error
		 */
		return executeAction(containerId, Path.STOP.path());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sfragata.docker.client.DockerClient#restart(java.lang.String)
	 */
	@Override
	public boolean restart(String containerId) {
		/*
		 * 204 – no error 404 – no such container 500 – server error
		 */
		return executeAction(containerId, Path.RESTART.path());
	}

	private boolean executeAction(String containerId, String action) {
		Response response = send(getWebTarget().path(Path.CONTAINERS.path())
				.path(containerId).path(action), HttpMethod.POST, null);
		return 204 == response.getStatus();
		/**
		 * 204 – no error 304 – container already started 404 – no such
		 * container 500 – server error
		 */
	}
}
