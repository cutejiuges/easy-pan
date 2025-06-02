package com.easy_pan.api.infra.utils;


import java.util.Optional;

public class JwtTokenHolder {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getToken() {
        return Optional.ofNullable(threadLocal.get())
                .map(String::trim)
                .orElse("");
    }
}
