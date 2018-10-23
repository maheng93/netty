package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * @Author:MH
 * @Date:Created in 11:22 2018/10/22
 */
@Data
public class QuitGroupResponsePacket extends Packet {
    private String groupId;

    private boolean success;

    private String reason;
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
