package top.zy_finn.zRPC.remotinig.transport.netty;

import lombok.extern.slf4j.Slf4j;
import top.zy_finn.zRPC.remotinig.dto.RpcRequest;
import top.zy_finn.zRPC.remotinig.transport.RpcRequestTransport;

/**
 * @author Finn
 * @create 2021/11/17 16:42
 */
@Slf4j
public final class NettyRpcClient implements RpcRequestTransport {

    @Override
    public Object sendRpcRequest(RpcRequest rpcRequest) {
        return null;
    }
}
