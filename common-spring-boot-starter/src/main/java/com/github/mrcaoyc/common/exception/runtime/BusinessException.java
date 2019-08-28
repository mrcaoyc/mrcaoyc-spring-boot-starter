package com.github.mrcaoyc.common.exception.runtime;

import com.github.mrcaoyc.common.errormessage.BaseErrorMessage;

/**
 * 业务异常
 *
 * @author CaoYongCheng
 */
public class BusinessException extends BaseRuntimeException {
    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     */
    public BusinessException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     * @param throwable    具体异常
     */
    public BusinessException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    /**
     * 构造函数
     *
     * @param code    错误码
     * @param message 错误消息
     */
    public BusinessException(int code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param code      错误码
     * @param message   错误消息
     * @param throwable 具体异常
     */
    public BusinessException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
