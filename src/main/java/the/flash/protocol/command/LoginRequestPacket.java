package the.flash.protocol.command;

import lombok.Data;

import static the.flash.protocol.command.Command.LOGIN_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 15:43 2018/10/17
 */
@Data
public class LoginRequestPacket extends Packet{

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
