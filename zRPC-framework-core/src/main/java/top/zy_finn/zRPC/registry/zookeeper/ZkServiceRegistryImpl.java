package top.zy_finn.zRPC.registry.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import top.zy_finn.zRPC.registry.ServiceRegistry;
import top.zy_finn.zRPC.registry.zookeeper.utils.CuratorUtil;

import java.net.InetSocketAddress;

/**
 * 基于zookeeper实现服务注册
 *
 * @author Finn
 * @create 2021/11/21 20:24
 */
@Slf4j
public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String serviceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtil.ZK_REGISTER_ROOT_PATH + "/" + serviceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtil.getZkClient();
        CuratorUtil.createPersistentNode(zkClient, servicePath);
    }
}
