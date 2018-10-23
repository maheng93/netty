package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.GroupMessageRequestPacket;

import java.util.Scanner;

/**
 * @Author:MH
 * @Date:Created in 11:11 2018/10/23
 */
public class SendToGroupConsoleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
    }
}
