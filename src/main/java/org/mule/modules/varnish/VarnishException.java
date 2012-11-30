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
