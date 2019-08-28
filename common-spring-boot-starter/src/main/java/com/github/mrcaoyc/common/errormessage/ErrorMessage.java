package com.github.mrcaoyc.common.errormessage;

/**
 * 异常实体类
 *
 * @author CaoYongCheng
 */
public class ErrorMessage {
    private Integer code;
    private String message;

    /**
     * 无参构造
     */
    public ErrorMessage() {
    }

    /**
     * 构造方法
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造方法
     *
     * @param baseErrorMessage 错误信息
     */
    public ErrorMessage(BaseErrorMessage baseErrorMessage) {
        if (baseErrorMessage == null) {
            throw new IllegalArgumentException("BaseErrorMessage must not be null.");
        }
        this.code = baseErrorMessage.getCode();
        this.message = baseErrorMessage.getMessage();
    }

    /**
     * 通过静态方法构建错误信息类
     *
     * @param baseErrorMessage 错误信息
     */
    public static ErrorMessage of(BaseErrorMessage baseErrorMessage) {
        return new ErrorMessage(baseErrorMessage);
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public String getMessage() {
        return message;
    }
}
