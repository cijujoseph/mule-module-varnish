package org.mule.modules.varnish;

public class VarnishChannelException extends Exception {
    public VarnishChannelException() {
        super();
    }

    public VarnishChannelException(String message) {
        super(message);
    }

    public VarnishChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public VarnishChannelException(Throwable cause) {
        super(cause);
    }
}
