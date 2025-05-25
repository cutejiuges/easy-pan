package com.easy_pan.common.utils;

public class StringUtil {
    public static String generateEmailVerifyCodeKey(String email) {
        return "{easyPan:Email}:" + email;
    }
}
