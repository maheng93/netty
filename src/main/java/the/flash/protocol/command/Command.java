package the.flash.protocol.command;

/**
 * @Author:MH
 * @Date:Created in 17:04 2018/10/13
 */
public interface Command {
    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST =3;

    Byte MESSAGE_RESPONSE = 4;
}
