package com.github.mrcaoyc.common.exception.runtime;

import com.github.mrcaoyc.common.errormessage.BaseErrorMessage;

/**
 * 数据未找到异常
 *
 * @author CaoYongCheng
 */
public class DataNotFoundException extends BaseRuntimeException {
    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     */
    public DataNotFoundException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }

    /**
     * 构造函数
     *
     * @param errorMessage 错误信息
     * @param throwable    具体异常
     */
    public DataNotFoundException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    /**
     * 构造函数
     *
     * @param code    错误码
     * @param message 错误消息
     */
    public DataNotFoundException(int code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param code      错误码
     * @param message   错误消息
     * @param throwable 具体异常
     */
    public DataNotFoundException(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
