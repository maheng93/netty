package the.flash.protocol.command;

/**
 * @Author:MH
 * @Date:Created in 15:42 2018/10/17
 */
public interface Command {
    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
