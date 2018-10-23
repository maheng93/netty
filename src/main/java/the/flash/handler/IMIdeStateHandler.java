package the.flash.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author:MH
 * @Date:Created in 15:55 2018/10/23
 */
public class IMIdeStateHandler extends IdleStateHandler {
    private static final int READER_IDELE_TIME = 15;

    public IMIdeStateHandler(){
        super(READER_IDELE_TIME,0, 0, TimeUnit.SECONDS);
    }

    protected void channelIdel(ChannelHandlerContext ctx, IdleStateHandler evt){
        System.out.println(READER_IDELE_TIME + "秒内未读到数据，关闭连接");
        ctx.channel().close();
    }
}
