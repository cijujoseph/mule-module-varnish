/**
 * Mule Rest Module
 *
 * Copyright 2011-2012 (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * This software is protected under international copyright law. All use of this software is
 * subject to MuleSoft's Master Subscription Agreement (or other master license agreement)
 * separately entered into in writing between you and MuleSoft. If such an agreement is not
 * in place, you may not use the software.
 */

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
