package top.zy_finn.zRPC.remotinig.dto;

import java.io.Serializable;

/**
 * @author Finn
 * @create 2021/11/17 11:50
 */
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
}
