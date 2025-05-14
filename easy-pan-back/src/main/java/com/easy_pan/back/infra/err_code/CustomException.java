package com.easy_pan.back.infra.err_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ErrCodeEnum errCodeEnum;
    private String exceptionMessage;
    private int exceptionCode;

    public CustomException(ErrCodeEnum errCodeEnum) {
        this.errCodeEnum = errCodeEnum;
    }
    public CustomException(int exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
}
