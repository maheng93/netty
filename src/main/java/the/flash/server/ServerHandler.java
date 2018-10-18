package the.flash.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import the.flash.protocol.request.LoginRequestPacket;
import the.flash.protocol.PackerCodec;
import the.flash.protocol.Packet;
import the.flash.protocol.request.MessageRequestPacket;
import the.flash.protocol.response.LoginResponsePacket;
import the.flash.protocol.response.MessageResponsePacket;

import java.util.Date;

/**
 * @Author:MH
 * @Date:Created in 16:34 2018/10/17
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet packet = PackerCodec.INSTANCE.decode(requestByteBuf);

        //判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket){
            System.out.println(new Date() + "：收到客户端登录请求.....");
            LoginRequestPacket  loginRequestPacket =(LoginRequestPacket ) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            //登录校验
            if (valid(loginRequestPacket)){
                //校验成功
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + "：登录成功");
            } else {
                //校验失败
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + "：登录失败");
            }

            //登录响应
            ByteBuf responseByteBuf = PackerCodec.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }else if (packet instanceof MessageRequestPacket){
            //处理消息
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket)packet);
            System.out.println(new Date() + ":收到客户端消息:"+ messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            System.out.println(new Date() + "：收到客户端消息：" + messageRequestPacket.getMessage());
            messageResponsePacket.setMessage("服务端回复【"+messageRequestPacket.getMessage()+"】");
            ByteBuf responseByteBuf = PackerCodec.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
