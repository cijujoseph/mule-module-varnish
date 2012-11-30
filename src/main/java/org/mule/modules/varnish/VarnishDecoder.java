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
