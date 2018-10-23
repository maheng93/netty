package the.flash.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.response.QuitGroupResponsePacket;

/**
 * @Author:MH
 * @Date:Created in 11:29 2018/10/22
 */
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()){
            System.out.println("退出群聊["+ responsePacket.getGroupId() +"]成功！");
        } else {
            System.out.println("退出群聊["+ responsePacket.getGroupId() +"]失败");
        }
    }
}
