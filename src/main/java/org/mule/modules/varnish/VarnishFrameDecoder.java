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

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class VarnishFrameDecoder extends FrameDecoder {
    private static final Logger LOGGER = Logger.getLogger(VarnishFrameDecoder.class);

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
        LOGGER.debug("Decoding frame [readableBytes=" + buffer.readableBytes() + "]");

        int newlineOffset = 0;
        while( newlineOffset == 0 ) {
            newlineOffset = buffer.bytesBefore((byte)0x0A);
            if( newlineOffset == -1 ) {
                return null;
            } else if( newlineOffset == 0 ) {
                buffer.skipBytes(1);
            }
        }

        LOGGER.debug("Newline found at [newlineOffset=" + newlineOffset + "]");

        int initialReadIndex = buffer.readerIndex();
        int actualLengthFieldOffset = buffer.readerIndex() + 4; // 200 <msgsize>\n
        int actualLengthSize = newlineOffset - actualLengthFieldOffset;
        LOGGER.debug("Length position [actualLengthFieldOffset=" + actualLengthFieldOffset + "] [actualLengthSize=" + actualLengthSize + "]");
        byte[] lenghtBytes = new byte[actualLengthSize];
        for( int i = 0; i < actualLengthSize; i++ ) {
            lenghtBytes[i] = buffer.readByte();
        }
        String asciiLength = new String(lenghtBytes, "US-ASCII");
        LOGGER.debug("Decoded length [length=" + asciiLength + "]");
        int length = Integer.parseInt(asciiLength.substring(4).trim());
        if( length == 0 ) {
            LOGGER.debug("Frame decoded [initialReadIndex=" + initialReadIndex + "] [length=" + (newlineOffset - initialReadIndex) + "]");
            ChannelBuffer frame = extractFrame(buffer, initialReadIndex, newlineOffset - initialReadIndex);
            buffer.readerIndex(newlineOffset - initialReadIndex);
            LOGGER.debug("Frame contents [" + frame.toString("US-ASCII") + "]");
            return frame;
        }

        if( buffer.readableBytes() < length ) {
            buffer.readerIndex(initialReadIndex); // reset reader index
            return null;
        }

        length += newlineOffset + 2;

        LOGGER.debug("Frame decoded [initialReadIndex=" + initialReadIndex + "] [length=" + length + "]");

        ChannelBuffer frame = extractFrame(buffer, initialReadIndex, length);
        buffer.readerIndex(initialReadIndex + length);

        LOGGER.debug("Frame contents [" + frame.toString("US-ASCII") + "]");

        return frame;
    }

    protected ChannelBuffer extractFrame(ChannelBuffer buffer, int index, int length) {
        ChannelBuffer frame = buffer.factory().getBuffer(length);
        frame.writeBytes(buffer, index, length);
        return frame;
    }
}
