package the.flash.attributes;

import io.netty.util.AttributeKey;

/**
 * @Author:MH
 * @Date:Created in 17:04 2018/10/15
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
