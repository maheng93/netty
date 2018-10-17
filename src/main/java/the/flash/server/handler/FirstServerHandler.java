package the.flash.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author:MH
 * @Date:Created in 10:50 2018/10/17
 */
public class FirstServerHandler extends ChannelOutboundHandlerAdapter {
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println(new Date() + ":服务端读到的数据->" + byteBuf.toString(Charset.forName("utf-8")));
    }
}
