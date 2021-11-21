package top.zy_finn.zRPC.registry;

import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * 服务发现接口
 *
 * @author Finn
 * @create 2021/11/19 20:55
 */
public interface ServiceDiscovery {

    /**
     * 寻找服务
     * @param rpcRequest 完整服务名 class name + group + version
     * @return 寻找的服务的远程地址
     * */
    InetSocketAddress findService(RpcRequest rpcRequest);
}
