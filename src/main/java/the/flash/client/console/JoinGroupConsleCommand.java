package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * @Author:MH
 * @Date:Created in 9:35 2018/10/22
 */
public class JoinGroupConsleCommand implements ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入GroupId,加入群聊");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
