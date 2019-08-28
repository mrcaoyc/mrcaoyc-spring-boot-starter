package com.github.mrcaoyc.web.filter;

import com.github.mrcaoyc.common.errormessage.ErrorMessage;
import com.github.mrcaoyc.common.exception.runtime.*;
import com.github.mrcaoyc.web.constant.GlobalErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.text.MessageFormat;

/**
 * @author CaoYongCheng
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 方法参数类型不匹配异常(400)
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public HttpEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        LOGGER.error("方法参数类型不匹配，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(
                GlobalErrorMessage.PARAMETER_VALID_ERROR.getCode(),
                MessageFormat.format("参数{0}类型不匹配", e.getName())
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 业务异常(400)
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public HttpEntity<?> businessExceptionHandler(BusinessException e) {
        LOGGER.debug("业务异常,错误码:{},错误消息:{}.", e.getCode(), e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 身份无效异常(401)
     */
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public HttpEntity<?> unauthorizedException(UnauthorizedException e) {
        LOGGER.debug("身份无效异常,错误码:{},错误消息:{}.堆栈信息:{}.", e.getCode(), e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 未授权异常(403)
     */
    @ResponseBody
    @ExceptionHandler(ForbiddenException.class)
    public HttpEntity<?> credentialsInvalidException(ForbiddenException e) {
        LOGGER.debug("未授权异常,错误码:{},错误消息:{}.堆栈信息:{}.", e.getCode(), e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 数据不存异常(404)
     */
    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    public HttpEntity<?> dataNotFoundException(DataNotFoundException e) {
        LOGGER.debug("数据不存在,错误码:{},错误消息:{}.", e.getCode(), e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    /**
     * Http请求方法不支持异常(405)
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public HttpEntity<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LOGGER.error("Http请求方法不支持，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 未识别的运行基类异常(500)
     */
    @ResponseBody
    @ExceptionHandler(BaseRuntimeException.class)
    public HttpEntity<?> baseRuntimeException(BaseRuntimeException e) {
        LOGGER.error("未识别的运行基类异常,错误码:{},错误消息:{},堆栈信息:{}.", e.getCode(), e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 内部服务器错误异常（500）
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public HttpEntity<?> exception(Exception e) {
        LOGGER.error("内部服务器错误，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}