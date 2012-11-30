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

public enum VarnishStatusCode {
    SYNTAX_ERROR(100),
    UNKNOWN(101),
    NOT_IMPLEMENTED(102),
    TOO_FEW_PARAMETERS(104),
    TOO_MANY_PARAMETERS(105),
    WRONG_PARAMETER(106),
    AUTHENTICATION_REQUIRED(107),
    OK(200),
    TRUNCATED(201),
    CANT(300),
    COMMS(400),
    CLOSE(500);

    private final int statusCode;

    private VarnishStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static VarnishStatusCode fromStatusCode(int statusCode) {
        for( VarnishStatusCode statusCodeEnum : VarnishStatusCode.values() ) {
            if( statusCodeEnum.getStatusCode() == statusCode ) {
                return statusCodeEnum;
            }
        }

        throw new IllegalArgumentException("Invalid status code " + Integer.toString(statusCode));
    }
}
