package the.flash.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.request.LoginRequestPacket;
import the.flash.protocol.response.LoginResponsePacket;
import the.flash.util.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @Author:MH
 * @Date:Created in 14:03 2018/10/18
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");
        //写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()){
            System.out.println(new Date() + ":客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        }
    }

}
