package the.flash.serialize;

import the.flash.serialize.impl.JSONSerializer;

/**
 * @Author:MH
 * @Date:Created in 15:46 2018/10/17
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlogrithm();
    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);
    /**
     * 二进制转换成java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}

