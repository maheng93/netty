package the.flash.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @Author:MH
 * @Date:Created in 14:09 2018/10/17
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i =0; i<1000; i++){
            ByteBuf buffer = getByteBuf(ctx);
            ctx.channel().writeAndFlush(buffer);
        }
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        //1.获取二进制抽象buffer

        //2.准备数据，指定字符串的字符集为UTF-8
        byte[] bytes ="你好，陌小歌！你好，陌小歌！你好，陌小歌！你好，陌小歌！你好，陌小歌！你好，陌小歌！你好，陌小歌！".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        //3.填充数据到 ByteBuf
        buffer.writeBytes(bytes);

        return buffer;
    }


}
