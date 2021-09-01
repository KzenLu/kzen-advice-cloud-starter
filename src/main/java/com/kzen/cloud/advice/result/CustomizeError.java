package com.kzen.cloud.advice.result;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 3:02 下午
 */
@Data
public class CustomizeError {

    private boolean flag = false;
    private Integer code;
    private String message;
    private String exception;

    public static CustomizeError fail(CustomizeCode customizeCode, Throwable e, String message) {
        CustomizeError customizeError = CustomizeError.fail(customizeCode, e);
        customizeError.setMessage(message);
        return customizeError;
    }

    public static CustomizeError fail(CustomizeCode customizeCode, Throwable e) {
        CustomizeError customizeError = new CustomizeError();
        customizeError.setCode(customizeCode.code());
        customizeError.setMessage(customizeCode.message());
        customizeError.setException(e.getClass().getName());
        return customizeError;
    }
    public static CustomizeError fail(Integer code, String message) {
        CustomizeError customizeError = new CustomizeError();
        customizeError.setCode(code);
        customizeError.setMessage(message);
        return customizeError;
    }
}
