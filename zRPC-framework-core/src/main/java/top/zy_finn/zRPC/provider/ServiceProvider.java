package top.zy_finn.zRPC.provider;

import top.zy_finn.zRPC.config.RpcServiceConfig;

/**
 *  store and provide service object
 *
 * @author Finn
 * @create 2021/12/5 18:06
 */
public interface ServiceProvider {

    /**
     * @param rpcServiceConfig
     */
    void addService(RpcServiceConfig rpcServiceConfig);

    /**
     * get service by name
     * @param rpcServiceName
     * @return
     */
    Object getService(String rpcServiceName);

    /**
     *
     * @param rpcServiceConfig
     */
    void publishService(RpcServiceConfig rpcServiceConfig);
}
