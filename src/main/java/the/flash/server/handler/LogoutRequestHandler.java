package the.flash.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.request.LoginRequestPacket;
import the.flash.protocol.response.LogoutResponsePacket;
import the.flash.util.SessionUtil;

/**
 * @Author:MH
 * @Date:Created in 18:22 2018/10/20
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    private LogoutRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(logoutResponsePacket);
    }
}
