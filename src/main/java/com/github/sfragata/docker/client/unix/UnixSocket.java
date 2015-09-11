/**
 *
 */
package com.github.sfragata.docker.client.unix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.Channels;

import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

/**
 * @author sfragata
 *
 */
public class UnixSocket
    extends Socket {

    private final UnixSocketChannel socketChannel;

    public UnixSocket() throws IOException {

        super();
        this.socketChannel = UnixSocketChannel.open();
    }

    @Override
    public void connect(
        final SocketAddress endpoint)
        throws IOException {

        this.socketChannel.connect((UnixSocketAddress) endpoint);
    }

    @Override
    public void connect(
        final SocketAddress endpoint,
        final int timeout)
        throws IOException {

        this.socketChannel.connect((UnixSocketAddress) endpoint);
        this.socketChannel.setSoTimeout(timeout);
    }

    @Override
    public synchronized void close()
        throws IOException {

        this.socketChannel.close();
    }

    @Override
    public boolean isClosed() {

        return !this.socketChannel.isOpen();
    }

    @Override
    public void shutdownInput()
        throws IOException {

        this.socketChannel.shutdownInput();
    }

    @Override
    public void shutdownOutput()
        throws IOException {

        this.socketChannel.shutdownOutput();
    }

    @SuppressWarnings("unused")
    @Override
    public InputStream getInputStream()
        throws IOException {

        return Channels.newInputStream(this.socketChannel);
    }

    @SuppressWarnings("unused")
    @Override
    public OutputStream getOutputStream()
        throws IOException {

        return Channels.newOutputStream(this.socketChannel);
    }
}
