package top.zy_finn.zRPC.registry.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import top.zy_finn.zRPC.enums.RpcErrorMessageEnum;
import top.zy_finn.zRPC.execption.RpcException;
import top.zy_finn.zRPC.registry.ServiceDiscovery;
import top.zy_finn.zRPC.registry.zookeeper.loadbalance.LoadBalance;
import top.zy_finn.zRPC.registry.zookeeper.loadbalance.loadbalancer.RandomLoadBalance;
import top.zy_finn.zRPC.registry.zookeeper.utils.CuratorUtil;
import top.zy_finn.zRPC.remotinig.dto.RpcRequest;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * 基于zookeeper的服务发现
 *
 * @author Finn
 * @create 2021/11/21 20:30
 */
@Slf4j
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {
    private LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl() {
        this.loadBalance = new RandomLoadBalance();
    }

    @Override
    public InetSocketAddress findService(RpcRequest rpcRequest) {
        String serviceName = rpcRequest.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtil.getZkClient();
        List<String> serviceUrlList = CuratorUtil.getChildrenNodes(zkClient, serviceName);
        if (serviceUrlList.size() == 0 || serviceUrlList == null) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, serviceName);
        }

        //负载均衡策略
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcRequest);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
