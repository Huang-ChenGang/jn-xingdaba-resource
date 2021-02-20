package com.jn.xingdaba.resource.infrastructure.exception;

public enum ResourceSystemError implements ResourceError {
    BAD_REQUEST(400, "请求参数错误"),
    MANAGEMENT_SYSTEM_ERROR(500, "资源服务系统异常")
    ;

    private final int errorCode;
    private final String errorMessage;

    ResourceSystemError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
