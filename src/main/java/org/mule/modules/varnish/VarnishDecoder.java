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

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

public class VarnishDecoder extends OneToOneDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (!(msg instanceof ChannelBuffer)) {
            return msg;
        }

        String message = ((ChannelBuffer) msg).toString("US-ASCII");
        String statusCodeString = message.substring(0, 3);
        VarnishStatusCode statusCode = VarnishStatusCode.fromStatusCode(Integer.parseInt(statusCodeString));

        int newLineIndex = message.indexOf('\n');
        if( newLineIndex != -1 ) {
            String responseContent = message.substring(newLineIndex + 1, message.length());
            return new VarnishResponse(statusCode, responseContent);
        } else {
            return new VarnishResponse(statusCode);
        }
    }
}
