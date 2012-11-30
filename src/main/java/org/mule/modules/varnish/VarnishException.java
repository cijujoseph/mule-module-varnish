package org.mule.modules.varnish;

public class VarnishException extends Exception {
    public VarnishException() {
        super();
    }

    public VarnishException(String message) {
        super(message);
    }

    public VarnishException(String message, Throwable cause) {
        super(message, cause);
    }

    public VarnishException(Throwable cause) {
        super(cause);
    }
}
