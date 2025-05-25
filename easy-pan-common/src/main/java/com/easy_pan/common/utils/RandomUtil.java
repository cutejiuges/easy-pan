package com.easy_pan.common.utils;

import java.util.Random;

public class RandomUtil {
    // 生成随机字符串
    public static String randomStr(int length) {
        String source = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXZY";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(source.charAt((int)(Math.random() * source.length())));
        }
        return sb.toString();
    }

    // 生成区间内的随机整数数字
    public static Integer randomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
