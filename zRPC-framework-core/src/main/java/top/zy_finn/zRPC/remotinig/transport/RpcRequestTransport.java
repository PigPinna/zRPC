package top.zy_finn.zRPC.remotinig.transport;

import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

/**
 * @author Finn
 * @create 2021/11/17 16:15
 */
public interface RpcRequestTransport {

    /**
     * 发送RPC请求顶层接口
     * @param rpcRequest body
     * @return data from server
     * */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
