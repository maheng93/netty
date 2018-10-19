package the.flash.util;


import io.netty.channel.Channel;
import io.netty.util.Attribute;
import the.flash.attribute.Attributes;


/**
 * @Author:MH
 * @Date:Created in 17:22 2018/10/18
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
