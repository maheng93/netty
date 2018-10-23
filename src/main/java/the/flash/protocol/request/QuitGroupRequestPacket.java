package the.flash.protocol.request;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 11:19 2018/10/22
 */
@Data
public class QuitGroupRequestPacket extends Packet {
    private String groupId;
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
