package com.easy_pan.common.constants;

public class Constants {
    // 用户状态常量
    public static final int USER_STATUS_ENABLE = 1; // 正常
    public static final int USER_STATUS_FORBIDDEN = 2; // 封禁
    public static final int USER_STATUS_DISABLE = 3; // 注销

    // 邮箱验证码状态常量
    public static int EmailVerifyCode_Enable = 1; // 可用
    public static int EmailVerifyCode_Used = 2; // 已使用

    // Authorization的前缀，JWT验证类型
    public static final String BEARER = "Bearer"; // Bearer
    public static final String JWT = "JWT"; //JWT

    // 用户磁盘空间大小
    public static final long DEFAULT_TOTAL_SIZE_5G = 5000000000L; // 默认大小为5G

    // refreshToken的状态
    public static final int TOKEN_STATUS_UNKNOWN = 0; //未知状态
    public static final int TOKEN_STATUS_ENABLE = 1; // 上线状态
    public static final int TOKEN_STATUS_DISABLE = 2; // 下线状态
}
