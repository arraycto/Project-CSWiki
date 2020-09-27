package com.smallbeef.cswiki.Json;


/**
 * 统一构建返回值 Result
 */
public class ResultFactory {

    public static Result buildResult(int resultCode, String message, Object data){
        return new Result(resultCode, message, data);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildSuccessResult(String message, Object data) {
        return buildResult(ResultCode.SUCCESS, message, data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }


}
