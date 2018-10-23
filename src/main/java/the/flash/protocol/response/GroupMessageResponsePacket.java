package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.Packet;
import the.flash.session.Session;

import static the.flash.protocol.command.Command.GROUP_MESSAGE_RESPONSE;


/**
 * @Author:MH
 * @Date:Created in 10:50 2018/10/23
 */
@Data
public class GroupMessageResponsePacket extends Packet {
    private String fromGroupId;

    private String message;

    private Session fromUser;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
