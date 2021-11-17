package top.zy_finn.zRPC.serialize;

/**
 * @author Finn
 * @create 2021/11/17 15:04
 */
public interface Serializer {

    /**
     * 序列化
     * @param object 序列化对象
     * @return 字节数组
     * */
    byte[] serialize(Object object);


    /**
     * 反序列化
     * @param bytes 反序列化字节数组
     * @param clazz 目标类
     * @return 反序列化生成的对象
     * */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
