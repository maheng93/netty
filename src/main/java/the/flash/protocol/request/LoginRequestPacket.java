package the.flash.protocol.request;

import lombok.Data;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.LOGIN_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 17:18 2018/10/18
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userName;

    private String password;

    @Override
    public Byte getCommand(){
        return LOGIN_REQUEST;
    }
}
