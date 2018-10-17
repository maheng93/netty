package the.flash.protocol.response;

import lombok.Data;
import the.flash.protocol.command.Command;
import the.flash.protocol.Packet;

/**
 * @Author:MH
 * @Date:Created in 17:04 2018/10/17
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
