package top.zy_finn.zRPC.registry.zookeeper.loadbalance.loadbalancer;

import top.zy_finn.zRPC.registry.zookeeper.loadbalance.AbstractLoadBalance;
import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 *通过random方法生成随机数，实现负载均衡策略
 *
 * @author Finn
 * @create 2021/11/21 20:45
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
