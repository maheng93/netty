package the.flash.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.request.LoginRequestPacket;

import java.util.Date;


/**
 * @Author:MH
 * @Date:Created in 14:09 2018/10/16
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket)  {
        System.out.println(new Date() + ": 收到客户端登录请求......");
        LoginRequestPacket loginResponsePacket = new LoginRequestPacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)){

            System.out.println(new Date() + ":客户端登录成功");
        }

    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
