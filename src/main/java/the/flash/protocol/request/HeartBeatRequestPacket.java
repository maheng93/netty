package the.flash.protocol.request;

import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 16:17 2018/10/23
 */
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
