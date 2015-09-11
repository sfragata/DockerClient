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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.Validate;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.github.sfragata.docker.client.message.Container;
import com.github.sfragata.docker.client.message.ContainerMetaData;
import com.github.sfragata.docker.client.message.Image;
import com.github.sfragata.docker.client.message.ProcessResult;
import com.github.sfragata.docker.client.message.Version;
import com.github.sfragata.docker.client.unix.UnixSocketFactory;

/**
 * @author sfragata
 */
public class DockerClientImpl
    implements DockerClient {

    private static final int CONNECTION_POOL_SIZE = 50;

    private static final int CONNECTION_TIMEOUT = 5000;

    private static final String SCHEME_UNIX = "unix";

    private static final String RESP_OK = "OK";

    public static final String UNIX_ENDPOINT = "unix:///var/run/docker.sock";

    private URI dockerURL;

    private final Client webClient;

    private static final ClientConfig DEFAULT_CONFIG = new ClientConfig(JacksonFeature.class);

    private static final GenericType<List<Container>> CONTAINER_LIST_TYPE = new GenericType<List<Container>>() {
        // do nothing
    };

    private static final GenericType<List<Image>> IMAGE_LIST_TYPE = new GenericType<List<Image>>() {
        // do nothing
    };

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

    public DockerClientImpl(final String url) {

        Validate.notBlank(url);
        if (UNIX_ENDPOINT.equals(url)) {
            this.dockerURL = URI.create(UNIX_ENDPOINT);
        } else {
            this.dockerURL = URI.create(url);
        }

        this.dockerURL = UnixSocketFactory.sanitizeUri(this.dockerURL);

        this.webClient = ClientBuilder.newClient(createClientConfig());
    }

    public DockerClientImpl() {

        this(UNIX_ENDPOINT);
    }

    private ClientConfig createClientConfig() {

        final RequestConfig requestConfig =
            RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();

        final RegistryBuilder<ConnectionSocketFactory> registryBuilder =
            RegistryBuilder.<ConnectionSocketFactory> create().register("http",
                PlainConnectionSocketFactory.getSocketFactory());

        // if unix endpoint
        if (this.dockerURL.getScheme().equals(SCHEME_UNIX)) {
            registryBuilder.register(SCHEME_UNIX, new UnixSocketFactory(UNIX_ENDPOINT));
        }
        final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager =
            new PoolingHttpClientConnectionManager(registryBuilder.build());
        poolingHttpClientConnectionManager.setMaxTotal(CONNECTION_POOL_SIZE);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(CONNECTION_POOL_SIZE);

        final ClientConfig config =
            DEFAULT_CONFIG.connectorProvider(new ApacheConnectorProvider())
                .property(ApacheClientProperties.CONNECTION_MANAGER, poolingHttpClientConnectionManager)
                .property(ApacheClientProperties.REQUEST_CONFIG, requestConfig);
        return config;
    }

    private WebTarget getWebTarget() {

        return this.webClient.target(this.dockerURL);
    }

    private <T> T request(
        final WebTarget target,
        final HttpMethod method,
        final Class<T> clazz,
        final MediaType mediaType) {

        final Response response = send(target, method, mediaType);

        return response.readEntity(clazz);
    }

    private <T> T request(
        final WebTarget target,
        final HttpMethod method,
        final GenericType<T> genericType,
        final MediaType mediaType) {

        final Response response = send(target, method, mediaType);

        return response.readEntity(genericType);
    }

    private Response send(
        final WebTarget target,
        final HttpMethod method,
        final MediaType mediaType) {

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
     * @see com.sfragata.docker.client.DockerClient#version()
     */
    @Override
    public Version version() {

        /*
         * 200 – no error 500 – server error
         */
        return request(getWebTarget().path(Path.VERSION.path()), HttpMethod.GET, Version.class,
            MediaType.APPLICATION_JSON_TYPE);
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#ping()
     */
    @Override
    public boolean ping() {

        /*
         * 200 – no error 500 – server error
         */

        final String response = request(getWebTarget().path(Path._PING.path()), HttpMethod.GET, String.class, null);
        return RESP_OK.equals(response);
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#images()
     */
    @Override
    public List<Image> images() {

        return request(getWebTarget().path(Path.IMAGES.path()).path(Path.JSON.path()), HttpMethod.GET, IMAGE_LIST_TYPE,
            MediaType.APPLICATION_JSON_TYPE);

    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#containers()
     */
    @Override
    public List<Container> containers() {

        /*
         * 200 – no error 400 – bad parameter 500 – server error
         */
        return request(
            getWebTarget().path(Path.CONTAINERS.path()).path(Path.JSON.path())
                .queryParam(QueryParam.ALL.queryParam(), 1), HttpMethod.GET, CONTAINER_LIST_TYPE,
            MediaType.APPLICATION_JSON_TYPE);
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#inspect(java.lang.String)
     */
    @Override
    public ContainerMetaData inspect(
        final String containerId) {

        /*
         * 200 – no error 404 – no such container 500 – server error
         */
        return request(getWebTarget().path(Path.CONTAINERS.path()).path(containerId).path(Path.JSON.path()),
            HttpMethod.GET, ContainerMetaData.class, MediaType.APPLICATION_JSON_TYPE);
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#top(java.lang.String)
     */
    @Override
    public ProcessResult top(
        final String containerId) {

        /*
         * 200 – no error 404 – no such container 500 – server error
         */
        return request(
            getWebTarget().path(Path.CONTAINERS.path()).path(containerId).path(Path.TOP.path())
                .queryParam(QueryParam.PS_ARGS.queryParam(), "aux"), HttpMethod.GET, ProcessResult.class,
            MediaType.APPLICATION_JSON_TYPE);
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#start(java.lang.String)
     */
    @Override
    public boolean start(
        final String containerId) {

        /*
         * 204 – no error 304 – container already started 404 – no such container 500 – server error
         */
        return executeAction(containerId, Path.START.path());
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#stop(java.lang.String)
     */
    @Override
    public boolean stop(
        final String containerId) {

        /*
         * 204 – no error 304 – container already stopped 404 – no such container 500 – server error
         */
        return executeAction(containerId, Path.STOP.path());
    }

    /*
     * (non-Javadoc)
     * @see com.sfragata.docker.client.DockerClient#restart(java.lang.String)
     */
    @Override
    public boolean restart(
        final String containerId) {

        /*
         * 204 – no error 404 – no such container 500 – server error
         */
        return executeAction(containerId, Path.RESTART.path());
    }

    private boolean executeAction(
        final String containerId,
        final String action) {

        final Response response =
            send(getWebTarget().path(Path.CONTAINERS.path()).path(containerId).path(action), HttpMethod.POST, null);
        return 204 == response.getStatus();
        /**
         * 204 – no error 304 – container already started 404 – no such
         * container 500 – server error
         */
    }

    @Override
    public String toString() {

        return this.getClass().getName().concat(": ").concat(this.dockerURL.toString());
    }
}
