package the.flash.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author:MH
 * @Date:Created in 14:23 2018/10/17
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println(new Date() + "：服务端读到数据->" +byteBuf.toString(Charset.forName("utf-8")));

        System.out.println(new Date() + "：服务端写出数据");
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes ="你好，现在已经连接上了，你有什么话想对我说的吗 ？".getBytes(Charset.forName("utf-8"));

        ByteBuf buffer = ctx.alloc().buffer();

        buffer.writeBytes(bytes);

        return buffer;
    }
}
