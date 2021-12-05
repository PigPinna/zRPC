package top.zy_finn.zRPC.config;

import lombok.*;

/**
 * @author Finn
 * @create 2021/12/5 18:09
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RpcServiceConfig {

    private String version ="";

    private String group = "";

    private Object service;

    public String getRpcServiceName(){
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }

    public String getServiceName(){
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }

}
