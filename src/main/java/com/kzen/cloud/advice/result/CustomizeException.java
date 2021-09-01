package com.kzen.cloud.advice.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 3:02 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomizeException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomizeException() {
        super();
    }
    public CustomizeException(CustomizeCode customizeCode) {
        super(customizeCode.message());
        this.code = customizeCode.code();
        this.message = customizeCode.message();
    }
    public CustomizeException(CustomizeCode customizeCode, Throwable cause) {
        super(customizeCode.message(), cause);
        this.code = customizeCode.code();
        this.message = customizeCode.message();
    }
    public CustomizeException(String message) {
        super(message);
        this.code = -1;
        this.message = message;
    }
    public CustomizeException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public CustomizeException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
