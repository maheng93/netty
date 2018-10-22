package the.flash.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.request.JoinGroupRequestPacket;
import the.flash.util.SessionUtil;

/**
 * @Author:MH
 * @Date:Created in 9:45 2018/10/22
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket requestPacket) throws Exception {
        // 1. 获取群对应的channelGroup，然后将当前用户的channel添加进去
        String groupId = requestPacket.getGroupId();
    }
}
