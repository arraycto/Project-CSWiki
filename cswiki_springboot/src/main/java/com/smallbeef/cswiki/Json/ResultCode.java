package com.smallbeef.cswiki.Json;

/**
 * 状态码，对应 Result.code
 */
public enum ResultCode {

    SUCCESS(200),
    FAIL(400);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
