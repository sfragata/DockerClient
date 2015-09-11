/**
 *
 */
package com.github.sfragata.docker.client.unix;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;

import jnr.unixsocket.UnixSocketAddress;

import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;

/**
 * @author sfragata
 *
 */
public class UnixSocketFactory
    implements ConnectionSocketFactory {

    private final File socketFile;

    public UnixSocketFactory(final String socketUri) {

        super();
        final String filename =
            socketUri.toString().replaceAll("^unix:///", "unix://localhost/").replaceAll("^unix://localhost", "");

        this.socketFile = new File(filename);
    }

    public static URI sanitizeUri(
        final URI uri) {

        if (uri.getScheme().equals("unix")) {
            return URI.create("unix://localhost:80");
        }
        return uri;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.http.conn.socket.ConnectionSocketFactory#connectSocket(int, java.net.Socket,
     * org.apache.http.HttpHost, java.net.InetSocketAddress, java.net.InetSocketAddress,
     * org.apache.http.protocol.HttpContext)
     */
    @SuppressWarnings("unused")
    @Override
    public Socket connectSocket(
        final int connectTimeout,
        final Socket socket,
        final HttpHost host,
        final InetSocketAddress remoteAddress,
        final InetSocketAddress localAddress,
        final HttpContext context)
        throws IOException {

        try {
            socket.connect(new UnixSocketAddress(this.socketFile), connectTimeout);
            return socket;
        } catch (final SocketTimeoutException e) {
            throw new ConnectTimeoutException(e, null, remoteAddress.getAddress());
        }
    }

    /*
     * (non-Javadoc)
     * @see org.apache.http.conn.socket.ConnectionSocketFactory#createSocket(org. apache.http.protocol.HttpContext)
     */
    @SuppressWarnings("unused")
    @Override
    public Socket createSocket(
        final HttpContext httpContext)
        throws IOException {

        return new UnixSocket();
    }

}
