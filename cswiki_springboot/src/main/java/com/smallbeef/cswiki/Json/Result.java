package com.smallbeef.cswiki.Json;

/**
 * 统一后端接口方法的返回格式
 */
public class Result {

    private int code; // 状态码
    private String message; // 对于该状态码的解释信息
    private Object data; // 后端传递给前端的数据对象

    public Result() {
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
