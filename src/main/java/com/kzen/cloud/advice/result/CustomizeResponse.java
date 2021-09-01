package com.kzen.cloud.advice.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 3:02 下午
 */
@Data
public class CustomizeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private Object data;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime currentTime = LocalDateTime.now();

    private CustomizeResponse() {
    }

    public CustomizeResponse(CustomizeCode customizeCode, Object data) {
        this.code = customizeCode.code();
        this.message = customizeCode.message();
        this.data = data;
    }

    private void setResultCode(CustomizeCode customizeCode) {
        this.code = customizeCode.code();
        this.message = customizeCode.message();
    }

    // 返回成功
    public static CustomizeResponse success() {
        CustomizeResponse result = new CustomizeResponse();
        result.setResultCode(CustomizeCode.SUCCESS);
        return result;
    }
    // 返回成功
    public static CustomizeResponse success(Object data) {
        CustomizeResponse result = new CustomizeResponse();
        result.setResultCode(CustomizeCode.SUCCESS);
        result.setData(data);
        return result;
    }

    // 返回失败
    public static CustomizeResponse fail(Integer code, String message) {
        CustomizeResponse result = new CustomizeResponse();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    // 返回失败
    public static CustomizeResponse fail(CustomizeCode customizeCode) {
        CustomizeResponse result = new CustomizeResponse();
        result.setResultCode(customizeCode);
        return result;
    }
}