package org.mule.modules.varnish;

import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class VarnishPipelineFactory implements ChannelPipelineFactory {
    private final ChannelHandler handler;

    public VarnishPipelineFactory(ChannelHandler handler) {
        this.handler = handler;
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        // Create a default pipeline implementation.
        ChannelPipeline pipeline = new DefaultChannelPipeline();
        // Add the text line codec combination first,
        pipeline.addLast("framer", new VarnishFrameDecoder());
        pipeline.addLast("decoder", new VarnishDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        // and then business logic.
        pipeline.addLast("handler", handler);

        return pipeline;
    }
}
