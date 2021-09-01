package com.kzen.cloud.advice;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 3:02 下午
 */
@Configuration
@EnableConfigurationProperties(KzenDefaultProperties.class)
@PropertySource(value = "classpath:kzen.properties", encoding = "utf-8")
public class KzenDefaultConfiguration {

    @Bean
    public ResponseInterceptor responseInterceptor(KzenDefaultProperties kzenDefaultProperties) {
        return new ResponseInterceptor(kzenDefaultProperties);
    }
    @Bean
    public ExceptionInterceptor exceptionInterceptor() {
        return new ExceptionInterceptor();
    }
}
