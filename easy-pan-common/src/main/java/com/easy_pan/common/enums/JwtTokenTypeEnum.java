package com.easy_pan.common.enums;

import lombok.Getter;

@Getter
public enum JwtTokenTypeEnum {
    // AccessToken
    AccessToken(0, "AccessToken"),
    RefreshToken(1, "RefreshToken"),
    ;

    private final int code;
    private final String msg;
    JwtTokenTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
