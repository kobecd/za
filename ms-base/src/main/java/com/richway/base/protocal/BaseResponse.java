package com.richway.base.protocal;

/**
 * Created by Boao on 2018/6/13.
 */
public class BaseResponse {

    // 返回码
    private int code = 200;

    // 返回消息
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
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
}
