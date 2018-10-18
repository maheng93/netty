package the.flash.attribute;

import io.netty.util.AttributeKey;

/**
 * @Author:MH
 * @Date:Created in 18:28 2018/10/17
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
