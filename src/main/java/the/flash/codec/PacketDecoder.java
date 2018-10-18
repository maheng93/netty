package the.flash.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import the.flash.protocol.PackerCodec;

import java.util.List;

/**
 * @Author:MH
 * @Date:Created in 14:21 2018/10/18
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PackerCodec.INSTANCE.decode(in));
    }
}
