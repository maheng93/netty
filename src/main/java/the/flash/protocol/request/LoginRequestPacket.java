package the.flash.protocol.request;

import lombok.Data;
import the.flash.protocol.command.Command;
import the.flash.protocol.Packet;

/**
 * @Author:MH
 * @Date:Created in 15:43 2018/10/17
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
