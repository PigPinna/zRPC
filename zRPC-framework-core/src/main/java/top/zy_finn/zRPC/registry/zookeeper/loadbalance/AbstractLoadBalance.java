package top.zy_finn.zRPC.registry.zookeeper.loadbalance;

import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

import java.util.List;

/**
 * 负载均衡的抽象类，排除无效筛选
 *
 * @author Finn
 * @create 2021/11/21 20:40
 */
public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest) {
        if (serviceAddresses == null || serviceAddresses.size() == 0) {
            return null;
        }

        if (serviceAddresses.size() == 1) {
            return serviceAddresses.get(0);
        }

        return doSelect(serviceAddresses, rpcRequest);
    }

    /**
     *选择服务地址
     *
     * @param serviceAddresses
     * @param rpcRequest
     * @return
     * */
    protected abstract String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest);

}
