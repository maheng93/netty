package the.flash.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:MH
 * @Date:Created in 16:53 2018/10/13
 */
@Data
public abstract class Packet{
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;
    /**
     * 指令
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();
}

