package com.easy_pan.back.infra.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsCheckUtil {
    public static boolean isValidEmail(String email) {
        // 邮箱格式匹配
        String pattern = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        return Pattern.matches(pattern, email);
    }

    public static boolean isValidPassword(String password) {
        // 密码位数大于8,需要包含数字、大小写字母和特殊字符
        String pattern = "^(?![0-9A-Za-z]+$)(?![0-9A-Z\\W]+$)(?![0-9a-z\\W]+$)(?![A-Za-z\\W]+$)[0-9A-Za-z~!@#$%^&*()_+`\\-={}|\\[\\]\\\\:\";'<>?,./]{8,}$";
        return Pattern.matches(pattern, password);
    }
}
