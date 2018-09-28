package com.richway.base.exception;

/**
 * 异常包装类
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ExceptionEnums errEnum;

    private String errMsg;

    private Integer errCode = 200;

    public BaseException(ExceptionEnums openServiceErrEnum) {
        this.errEnum = openServiceErrEnum;
        this.errMsg = openServiceErrEnum.getMessage();
        this.errCode = openServiceErrEnum.getCode();
    }

    public BaseException(ExceptionEnums openServiceErrEnum, String errMsg) {
        this.errEnum = openServiceErrEnum;
        this.errMsg = errMsg;
        this.errCode = openServiceErrEnum.getCode();
    }

    public BaseException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ExceptionEnums getOpenServiceErrEnum() {
        return errEnum;
    }

    public void setOpenServiceErrEnum(ExceptionEnums openServiceErrEnum) {
        this.errEnum = openServiceErrEnum;
    }

    public ExceptionEnums getErrEnum() {
        return errEnum;
    }

    public void setErrEnum(ExceptionEnums errEnum) {
        this.errEnum = errEnum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
