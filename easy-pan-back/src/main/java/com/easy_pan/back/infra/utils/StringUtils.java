package com.easy_pan.back.infra.utils;

public class StringUtils {
    public static String generateEmailVerifyCodeKey(String email) {
        return "{Email}:" + email;
    }
}
