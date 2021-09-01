package com.kzen.cloud.advice;

import com.kzen.cloud.advice.result.CustomizeCode;
import com.kzen.cloud.advice.result.CustomizeError;
import com.kzen.cloud.advice.result.CustomizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

/**
 * @Description: 异常全局处理(来源于网络 非原创,修改)
 * @Author: kzen
 * @Date: 2021/4/27 4:30 下午
 */
@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(CustomizeException.class)
    public CustomizeError customizeExceptionHandler(CustomizeException e, HttpServletRequest request) {
        log.error("业务异常,异常原因:{}", e.getMessage());
        return CustomizeError.fail(e.getCode(), e.getMessage());
    }

    // 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public CustomizeError handlerThrowable(Throwable e, HttpServletRequest request) {
        log.error("发生未知异常！原因是: ", e);
        return CustomizeError.fail(CustomizeCode.DATA_IS_WRONG, e);
    }

    // 参数校验异常
    @ExceptionHandler(BindException.class)
    public CustomizeError handleBindException(BindException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：",e);
        return CustomizeError.fail(CustomizeCode.PARAM_IS_INVALID, e, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomizeError handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("发生参数校验异常！原因是：",e);
        return CustomizeError.fail(CustomizeCode.PARAM_IS_INVALID,e,e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
