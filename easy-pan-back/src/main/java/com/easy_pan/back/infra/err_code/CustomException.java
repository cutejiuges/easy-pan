package com.easy_pan.back.infra.err_code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private ErrCodeEnum errCodeEnum;

    @Override
    public String getMessage() {
        return "{\"code: \"" + this.errCodeEnum.getCode() + "\", \"message: \"" + this.errCodeEnum.getMessage() + "\"}";
    }
}
