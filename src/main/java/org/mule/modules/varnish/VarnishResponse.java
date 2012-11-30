package org.mule.modules.varnish;

public class VarnishResponse {
    private final VarnishStatusCode statusCode;
    private final String message;

    public VarnishResponse(VarnishStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public VarnishResponse(VarnishStatusCode statusCode) {
        this.statusCode = statusCode;
        this.message = null;
    }

    public VarnishStatusCode getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
