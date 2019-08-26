package com.github.mracoyc.common.exception.runtime;

import com.github.mracoyc.common.errormessage.BaseErrorMessage;

/**
 * 错误请求异常
 *
 * @author CaoYongCheng
 */
public class BadRequestException extends BaseRuntimeException {
    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     */
    public BadRequestException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     * @param throwable    具体异常
     */
    public BadRequestException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    /**
     * 构造函数
     *
     * @param code    错误码
     * @param message 错误消息
     */
    public BadRequestException(int code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param code      错误码
     * @param message   错误消息
     * @param throwable 具体异常
     */
    public BadRequestException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
