package the.flash;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author:MH
 * @Date:Created in 12:35 2018/10/17
 */
public class NettyClient {
    public static final int MAX_RETRY = 5;
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8000;
    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });

        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry){
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()){
                System.out.println("连接成功！");
            }else if (retry == 0){
                System.out.println("重连次数已用完，放弃连接！");
            }else {
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 >> order;
                System.out.println(new Date() + "：连接失败，第" + order + "次重连.....");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry -1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
