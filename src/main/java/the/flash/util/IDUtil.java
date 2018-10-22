package the.flash.util;

import java.util.UUID;

/**
 * @Author:MH
 * @Date:Created in 18:18 2018/10/20
 */
public class IDUtil {
    public static  String randomId(){
        return UUID.randomUUID().toString().split("-")[0];
    }
}
