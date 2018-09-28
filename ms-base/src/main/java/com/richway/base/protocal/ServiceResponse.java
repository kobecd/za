package com.richway.base.protocal;

import com.richway.base.exception.BaseException;
import com.richway.base.exception.ExceptionEnums;

/**
 * Created by Boao on 2018/6/13.
 */
public class ServiceResponse<T> extends BaseResponse {

    // 返回范型
    T data;

    // 是否为业务异常
    boolean isBizError = false;

    public ServiceResponse() {
    }

    public ServiceResponse(T data) {
        this.data = data;
    }

    public ServiceResponse(T data, ExceptionEnums exEnum) {
        this.data = data;
        this.setCode(exEnum.getCode());
        this.setMessage(exEnum.getCode() == 500 ? "网络错误" : exEnum.getMessage());
    }

    public ServiceResponse(ExceptionEnums exEnum) {
        this.setCode(exEnum.getCode());
        this.setMessage(exEnum.getCode() == 500 ? "网络错误" : exEnum.getMessage());
    }

    public ServiceResponse(BaseException ex) {
        this.setCode(ex.getErrCode());
        this.setMessage(ex.getErrMsg());
    }

    public ServiceResponse(ExceptionEnums exEnum, boolean isBizError) {
        this.setCode(exEnum.getCode());
        this.setMessage(exEnum.getCode() == 500 ? "网络错误" : exEnum.getMessage());
        this.isBizError = isBizError;
    }

    public ServiceResponse<T> isBizError(boolean isBizError) {
        this.setBizError(isBizError);
        return this;
    }

    public ServiceResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isBizError() {
        return isBizError;
    }

    public void setBizError(boolean bizError) {
        isBizError = bizError;
    }

    public Long getSystemTimeL() {
        return System.currentTimeMillis();
    }
}
