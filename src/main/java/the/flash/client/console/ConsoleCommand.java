package the.flash.client.console;


import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author:MH
 * @Date:Created in 16:16 2018/10/20
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
