package top.zy_finn.zRPC.registry.zookeeper.loadbalance;

import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

import java.util.List;

/**
 * 负载均衡策略接口
 *
 * @author Finn
 * @create 2021/11/21 20:35
 */
public interface LoadBalance {

    /**
     *从服务地址列表中，根据负载均衡策略选择一个地址返回
     *
     * @param serviceAddresses
     * @param rpcRequest
     * @return
     * */
    String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest);
}
