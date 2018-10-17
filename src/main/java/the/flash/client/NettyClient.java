package the.flash.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import the.flash.protocol.PacketCodec;
import the.flash.protocol.request.MessageRequestPacket;
import the.flash.util.LoginUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Author:MH
 * @Date:Created in 18:26 2018/10/12
 */
public class NettyClient {
    public static final Integer MAX_RETRY = 5;
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8000;
    public static void main(String[] args) {

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(workerGroup)
                //2.指定IO类型为Nio
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                //3.IO处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        //4.建立连接
        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

//    private static void connect(Bootstrap bootstrap, String host, int port) {
//        bootstrap.connect(host, port).addListener(future -> {
//            if (future.isSuccess()) {
//                System.out.println(new Date() + "连接成功");
//            } else {
//                System.err.println(new Date() + "连接失败，开始重新连接");
//                connect(bootstrap, host, port, MAX_RETRY);
//            }
//        });
//    }
    //9394511251

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date()+"：连接成功");
                Channel channel = ((ChannelFuture)future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 << order;
                System.err.println(new Date() + ":连接失败，第" + order + "次重连");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port,retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()){
                if (LoginUtil.hasLogin(channel)){
                    System.out.println("输入信息发送至服务器：");
                    Scanner sc = new Scanner(System.in);
                    String line = sc.nextLine();

                    MessageRequestPacket packet = new MessageRequestPacket();
                    packet.setMessage(line);
                    ByteBuf byteBuf = PacketCodec.INSTANCE.encode(channel.alloc(), packet);
                    channel.writeAndFlush(byteBuf);
                }
            }
        }).start();
    }
}
