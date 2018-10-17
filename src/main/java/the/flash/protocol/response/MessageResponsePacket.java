package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @Author:MH
 * @Date:Created in 16:49 2018/10/15
 */
@Data
public class MessageResponsePacket extends Packet {
    private String message;
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
