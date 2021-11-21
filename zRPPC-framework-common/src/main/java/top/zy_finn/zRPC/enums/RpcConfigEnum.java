package top.zy_finn.zRPC.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Finn
 * @create 2021/11/21 19:56
 */
@AllArgsConstructor
@Getter
public enum RpcConfigEnum {

    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;
}
