package top.zy_finn.zRPC.remotinig.dto;

import lombok.*;
import top.zy_finn.zRPC.enums.RpcResponseEnums;

import java.io.Serializable;

/**
 * @author Finn
 * @create 2021/11/17 11:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcResponse<T> implements Serializable {

    private static final long serialVersionUID = 715745410605631233L;
    private String requestId;
    /**
     * response 状态码
     */
    private Integer code;
    /**
     * response 状态消息
     */
    private String message;
    /**
     * response 返回结果
     */
    private T data;

    public static <T> RpcResponse<T> success(T data, String requestId) {

        RpcResponse<T> rpcResponse = new RpcResponse();
        rpcResponse.setCode(RpcResponseEnums.SUCCESS.getCoed());
        rpcResponse.setMessage(RpcResponseEnums.SUCCESS.getMessage());
        rpcResponse.setRequestId(requestId);
        if (null != data) {
            rpcResponse.setData(data);
        }

        return rpcResponse;
    }

    public static <T> RpcResponse<T> fail(RpcResponseEnums rpcResponseEnums) {

        RpcResponse<T> rpcResponse = new RpcResponse<>();
        rpcResponse.setCode(rpcResponseEnums.getCoed());
        rpcResponse.setMessage(rpcResponseEnums.getMessage());

        return rpcResponse;
    }
}
