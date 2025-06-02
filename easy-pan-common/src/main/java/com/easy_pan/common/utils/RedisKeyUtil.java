package com.easy_pan.common.utils;

public class RedisKeyUtil {
    /**
     * 用于生成redis中邮箱验证码的key
     * @param email 邮箱地址
     * @return 对应该邮箱地址验证码的key
     */
    public static String generateEmailVerifyCodeKey(String email) {
        return "{easyPan:Email}:" + email;
    }

    /**
     * 用于生成redis中退出登陆用户的key
     * @param userId 用户的userId
     * @return 退出登陆的用户
     */
    public static String generateLogoutKey(long userId, String token) {
        return "{easyPan:LogoutUser}:" + userId + ":" + token;
    }
}
