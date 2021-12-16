package top.zy_finn.zRPC.remotinig.transport.netty.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.zy_finn.zRPC.config.RpcServiceConfig;
import top.zy_finn.zRPC.facotry.SingletonFactory;
import top.zy_finn.zRPC.provider.Impl.ZkServiceProvider;
import top.zy_finn.zRPC.provider.ServiceProvider;

/**
 * @author Finn
 * @create 2021/12/5 17:58
 */
@Slf4j
@Component
public class NettyRpcServer {

    public static final int PORT = 9996;

    private ServiceProvider serviceProvider = SingletonFactory.getInstance(ZkServiceProvider.class);

    public void registerService(RpcServiceConfig rpcServiceConfig) {
        serviceProvider.publishService(rpcServiceConfig);
    }



}
