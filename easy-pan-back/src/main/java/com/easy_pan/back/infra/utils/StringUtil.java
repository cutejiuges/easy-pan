package com.easy_pan.back.infra.utils;

public class StringUtil {
    public static String generateEmailVerifyCodeKey(String email) {
        return "{Email}:" + email;
    }
}
