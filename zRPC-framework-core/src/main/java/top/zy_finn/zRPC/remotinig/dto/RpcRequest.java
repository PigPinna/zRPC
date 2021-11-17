package top.zy_finn.zRPC.remotinig.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Finn
 * @create 2021/11/17 11:48
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private String version;
    private String group;

    public String getRpcServiceName() {
        return this.getInterfaceName() + this.getGroup() + this.getVersion();
    }
}
