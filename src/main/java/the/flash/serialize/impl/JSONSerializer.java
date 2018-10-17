package the.flash.serialize.impl;

import com.alibaba.fastjson.JSON;
import the.flash.serialize.Serializer;
import the.flash.serialize.SerializerAlgorithm;

/**
 * @Author:MH
 * @Date:Created in 15:49 2018/10/17
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
