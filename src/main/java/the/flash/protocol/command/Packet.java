package the.flash.protocol.command;

import lombok.Data;

/**
 * @Author:MH
 * @Date:Created in 15:40 2018/10/17
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;
    /**
     * 指令
     */
    public abstract Byte getCommand();
}
