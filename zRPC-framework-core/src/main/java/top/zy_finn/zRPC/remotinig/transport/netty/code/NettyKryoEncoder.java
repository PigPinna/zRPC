package top.zy_finn.zRPC.remotinig.transport.netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.AllArgsConstructor;
import top.zy_finn.zRPC.serialize.Serializer;

/**
 * 自定义编码器
 *
 * @author Finn
 * @create 2021/11/24 16:31
 */
@AllArgsConstructor
public class NettyKryoEncoder extends MessageToByteEncoder {
    private final Serializer serializer;
    private final Class<?> genericClass;

    /**
     * 将对象转换为字节码写入 byteBuf
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        if (genericClass.isInstance(o)) {
            byte[] body = serializer.serialize(o);
            int dataLength = body.length;
            byteBuf.writeInt(dataLength);
            byteBuf.writeBytes(body);
        }
    }
}
