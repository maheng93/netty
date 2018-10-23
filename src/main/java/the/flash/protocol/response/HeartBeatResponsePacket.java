package the.flash.protocol.response;

import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @Author:MH
 * @Date:Created in 16:20 2018/10/23
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
