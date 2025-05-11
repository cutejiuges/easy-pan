package com.easy_pan.back.infra.utils;

public class StringUtils {
    // 生成随机字符串
    public static String randomStr(int length) {
        String source = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXZY";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(source.charAt((int)(Math.random() * source.length())));
        }
        return sb.toString();
    }
}
