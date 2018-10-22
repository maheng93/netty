package the.flash.protocol.request;

import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.LOGOUT_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 17:24 2018/10/20
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
