package top.zy_finn.zRPC.remotinig.transport.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import sun.management.jmxremote.SingleEntryRegistry;
import top.zy_finn.zRPC.facotry.SingletonFactory;
import top.zy_finn.zRPC.remotinig.dto.RpcResponse;

import java.net.InetSocketAddress;

/**
 * 自定义客户端 ChannelHandler 去处理 data from server
 *
 * @author Finn
 * @create 2021/11/24 17:19
 */
@Slf4j
public class NettyRpcClientHandler extends ChannelInboundHandlerAdapter {
    private UnprocessedRequests unprocessedRequests;
    private NettyRpcClient nettyRpcClient;

    public NettyRpcClientHandler() {
        this.unprocessedRequests = SingletonFactory.getInstance(UnprocessedRequests.class);
        this.nettyRpcClient = SingletonFactory.getInstance(NettyRpcClient.class);
    }

    /** 读取从服务端返回的消息 */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            log.info("client receive msg: [{}]",msg);
            if (msg instanceof RpcResponse) {
                RpcResponse<Object> rpcResponse = (RpcResponse<Object>) msg;
                unprocessedRequests.complete(rpcResponse);
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.WRITER_IDLE) {
                log.info("write idle happen [{}]",ctx.channel().remoteAddress());
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("client catch exception：", cause);
        cause.printStackTrace();
        ctx.close();
    }
}
