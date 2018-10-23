package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @Author:MH
 * @Date:Created in 10:08 2018/10/22
 */
@Data
public class JoinGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
