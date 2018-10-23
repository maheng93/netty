package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.Packet;
import the.flash.session.Session;

import java.util.List;

import static the.flash.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @Author:MH
 * @Date:Created in 10:54 2018/10/22
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {
    private String groupId;

    private List<Session> sessionList;
    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
