package the.flash.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @Author:MH
 * @Date:Created in 18:20 2018/10/17
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String message;

    public MessageRequestPacket(String message){
        this.message = message;
    }
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
