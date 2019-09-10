package com.github.mrcaoyc.web.filter;

import com.github.mrcaoyc.common.errormessage.ErrorMessage;
import com.github.mrcaoyc.common.exception.runtime.*;
import com.github.mrcaoyc.web.constant.GlobalErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.text.MessageFormat;
import java.util.stream.Collectors;

/**
 * @author CaoYongCheng
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 方法参数类型不匹配异常(400)
     * url参数类型不匹配时出现的异常
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public HttpEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        LOGGER.warn("方法参数类型不匹配，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(
                GlobalErrorMessage.PARAMETER_VALID_ERROR.getCode(),
                MessageFormat.format("参数{0}类型不匹配", e.getName())
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * body参数转换失败异常(400)
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public HttpEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        LOGGER.warn("请求参数绑定失败，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.PARAMETER_VALID_ERROR);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 通过@valid注解进行参数校验失败的异常（400）
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.warn("参数验证失败，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        String errorText = e.getBindingResult().getAllErrors().stream().map(error ->
                error.getObjectName() + ":" + error.getDefaultMessage()
        ).collect(Collectors.joining("\n"));
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.PARAMETER_VALID_ERROR.getCode(), errorText);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 业务异常(400)
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public HttpEntity<?> businessException(BusinessException e) {
        LOGGER.warn("业务异常,错误码:{},错误消息:{}.", e.getCode(), e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 业务异常(400)
     */
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    public HttpEntity<?> badRequestException(BadRequestException e) {
        LOGGER.warn("业务异常,错误码:{},错误消息:{}.", e.getCode(), e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * 身份无效异常(401)
     */
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public HttpEntity<?> unauthorizedException(UnauthorizedException e) {
        LOGGER.warn("身份无效异常,错误码:{},错误消息:{}.堆栈信息:{}.", e.getCode(), e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 未授权异常(403)
     */
    @ResponseBody
    @ExceptionHandler(ForbiddenException.class)
    public HttpEntity<?> credentialsInvalidException(ForbiddenException e) {
        LOGGER.warn("未授权异常,错误码:{},错误消息:{}.堆栈信息:{}.", e.getCode(), e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
    }

    /**
     * 数据不存异常(404)
     */
    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    public HttpEntity<?> dataNotFoundException(DataNotFoundException e) {
        LOGGER.warn("数据不存在,错误码:{},错误消息:{}.", e.getCode(), e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    /**
     * Http请求方法不支持异常(405)
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public HttpEntity<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LOGGER.warn("Http请求方法不支持，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public HttpEntity<?> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        LOGGER.warn("不支持的媒体类型，错误信息：{}，堆栈信息：{}", e.getMessage(), e);
        ErrorMessage errorMessage = new ErrorMessage(GlobalErrorMessage.UNSUPPORTED_MEDIA_TYPE);
        return new ResponseEntity<>(errorMessage, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
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