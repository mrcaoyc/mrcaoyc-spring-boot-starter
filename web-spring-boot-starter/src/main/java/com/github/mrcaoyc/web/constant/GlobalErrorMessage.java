package com.github.mrcaoyc.web.constant;

import com.github.mrcaoyc.common.errormessage.BaseErrorMessage;

/**
 * 全局异常信息
 *
 * @author CaoYongCheng
 */
public enum GlobalErrorMessage implements BaseErrorMessage {
    /**
     *
     */
    INTERNAL_SERVER_ERROR(1, "您的请求暂时无法处理，请稍后再试！"),
    PARAMETER_VALID_ERROR(2, "参数验证失败！"),
    UNSUPPORTED_MEDIA_TYPE(3, "不支持的媒体类型"),
    METHOD_NOT_ALLOWED(4, "不支持的方法");

    private int code;
    private String message;

    GlobalErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
