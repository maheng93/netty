package the.flash.protocol.request;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 10:43 2018/10/22
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {
    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
