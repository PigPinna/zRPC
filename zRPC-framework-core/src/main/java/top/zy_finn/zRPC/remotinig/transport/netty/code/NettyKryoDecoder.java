package top.zy_finn.zRPC.remotinig.transport.netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.zy_finn.zRPC.serialize.Serializer;

import java.util.List;

/**
 * 自定义解码器
 *
 * @author Finn
 * @create 2021/11/24 16:39
 */
@AllArgsConstructor
@Slf4j
public class NettyKryoDecoder extends ByteToMessageDecoder {
    private final Serializer serializer;
    private final Class<?> genericClass;
    /**
     *  Netty 传输的消息长度，即对象序列化后对应的字节数组大小
     */
    private static final int BODY_LENGTH = 4;

    /**
     *
     *  解码 byteBuf
     *
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() >= BODY_LENGTH) {
            byteBuf.markReaderIndex();
            int dataLength = byteBuf.readInt();

            if (dataLength < 0 || byteBuf.readableBytes() < 0) {
                log.error("data length or byteBuf readableBytes is not valid");
                return;
            }

            if (byteBuf.readableBytes() < dataLength) {
                byteBuf.resetReaderIndex();
                return;
            }

            byte[] body = new byte[dataLength];
            byteBuf.readBytes(body);
            Object obj = serializer.deserialize(body, genericClass);
            list.add(obj);
            log.info("successfully decode byteBuf to Object");
        }
    }
}
