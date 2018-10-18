package the.flash.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import the.flash.protocol.PackerCodec;
import the.flash.protocol.Packet;

/**
 * @Author:MH
 * @Date:Created in 14:22 2018/10/18
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        PackerCodec.INSTANCE.encode(out, packet);
    }
}
