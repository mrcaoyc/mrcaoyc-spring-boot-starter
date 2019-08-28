package com.github.mrcaoyc.common.errormessage;

import com.github.mrcaoyc.common.exception.runtime.BaseRuntimeException;

/**
 * 所有异常信息接口
 *
 * @author CaoYongCheng
 */
public interface BaseErrorMessage {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    String getMessage();

    /**
     * 手动指定错误码和错误消息
     *
     * @param code    错误码
     * @param message 错误消息
     * @return 错误信息
     */
    static BaseErrorMessage of(int code, String message) {
        return new BaseErrorMessage() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    /**
     * 从异常信息中获取错误信息
     *
     * @param e 异常信息
     * @return 错误信息
     */
    static BaseErrorMessage of(BaseRuntimeException e) {
        if (e == null) {
            throw new IllegalArgumentException("param is null.");
        }
        return new BaseErrorMessage() {
            @Override
            public int getCode() {
                return e.getCode();
            }

            @Override
            public String getMessage() {
                return e.getMessage();
            }
        };
    }
}
