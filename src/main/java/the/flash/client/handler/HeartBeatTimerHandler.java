package the.flash.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @Author:MH
 * @Date:Created in 16:05 2018/10/23
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {
    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().scheduleAtFixedRate(()->{
            ctx.writeAndFlush(new HeartBeatTimerHandler());
        }, HEARTBEAT_INTERVAL,HEARTBEAT_INTERVAL,TimeUnit.SECONDS);
        super.channelActive(ctx);
    }
}
