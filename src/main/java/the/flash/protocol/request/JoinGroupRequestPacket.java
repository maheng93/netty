package the.flash.protocol.request;

import lombok.Data;
import the.flash.protocol.Packet;

/**
 * @Author:MH
 * @Date:Created in 9:35 2018/10/22
 */
@Data
public class JoinGroupRequestPacket extends Packet {
    private String groupId;

    @Override
    public Byte getCommand() {
        return null;
    }
}
