package top.zy_finn.zRPC.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Finn
 * @create 2021/11/17 11:55
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseEnums {

    SUCCESS(200, "The remote call is successful"),
    FAIL(500, "The remote call is fail");

    private final int coed;
    private final String message;
}
