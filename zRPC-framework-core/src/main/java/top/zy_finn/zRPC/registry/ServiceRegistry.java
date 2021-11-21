package top.zy_finn.zRPC.registry;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 服务注册接口
 *
 * @author Finn
 * @create 2021/11/19 20:51
 */
public interface ServiceRegistry {

    /**
     * 服务注册
     *
     * @param serviceName 完整服务名 class name + group + version
     * @param inetSocketAddress 远程服务地址
     * */
    void registerService(String serviceName, InetSocketAddress inetSocketAddress);
}
