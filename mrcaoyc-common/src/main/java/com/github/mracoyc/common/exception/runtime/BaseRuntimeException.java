package com.github.mracoyc.common.exception.runtime;

import com.github.mracoyc.common.errormessage.BaseErrorMessage;

import java.util.Objects;

/**
 * @author CaoYongCheng
 */
public class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private BaseErrorMessage errorMessage;

    public BaseRuntimeException(BaseErrorMessage errorMessage) {
        if (Objects.nonNull(errorMessage)) {
            this.errorMessage = errorMessage;
            this.code = errorMessage.getCode();
            this.message = errorMessage.getMessage();
        }
    }

    public BaseRuntimeException(BaseErrorMessage errorMessage, Throwable throwable) {
        super(throwable);
        if (Objects.nonNull(errorMessage)) {
            this.errorMessage = errorMessage;
            this.code = errorMessage.getCode();
            this.message = errorMessage.getMessage();
        }
    }

    public BaseRuntimeException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseRuntimeException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BaseErrorMessage getErrorMessage() {
        if (Objects.isNull(errorMessage)) {
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
        } else {
            return errorMessage;
        }
    }
}
