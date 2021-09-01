package com.kzen.cloud.advice.annotation;

import com.kzen.cloud.advice.KzenDefaultConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 2:48 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(KzenDefaultConfiguration.class)
public @interface EnableResponseAdvice {
}
