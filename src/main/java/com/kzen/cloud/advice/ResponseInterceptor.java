package com.kzen.cloud.advice;

import com.kzen.cloud.advice.annotation.IgnoreResponseAdvice;
import com.kzen.cloud.advice.result.CustomizeError;
import com.kzen.cloud.advice.result.CustomizeResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @Description: 返回结果统一封装
 * @Author: kzen
 * @Date: 2021/4/27 4:44 下午
 */
@RestControllerAdvice
public class ResponseInterceptor implements ResponseBodyAdvice<Object> {

    private KzenDefaultProperties kzenDefaultProperties;
    public ResponseInterceptor(KzenDefaultProperties defaultProperties) {
        this.kzenDefaultProperties = defaultProperties;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return filterMethodParameter(methodParameter);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //异常检测
        if (body instanceof CustomizeError) {
            CustomizeError result = (CustomizeError) body;
            return CustomizeError.fail(result.getCode(), result.getMessage());
        }
        //正常情况
        return CustomizeResponse.success(body);
    }

    /**
     * 非过滤项
     * @param methodParameter method-param
     * @return is_filter
     */
    private boolean filterMethodParameter(MethodParameter methodParameter) {
        Class<?> declaringClass = methodParameter.getDeclaringClass();
        if (kzenDefaultProperties.getAdviceFilterPackage().stream().anyMatch(unFilter -> declaringClass.getName().contains(unFilter))) {
            return false;
        }
        if (kzenDefaultProperties.getAdvicefilterClass().contains(declaringClass.getName())) {
            return false;
        }
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return !Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(IgnoreResponseAdvice.class);
    }
}
