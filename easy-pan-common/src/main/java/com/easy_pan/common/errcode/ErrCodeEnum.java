package com.easy_pan.common.errcode;

import lombok.Getter;

@Getter
public enum ErrCodeEnum {
    // 成功错误码为0
    SUCCESS(0, "SUCCESS"),
    // 登陆段错误码 1-50
    NEED_LOGIN(1,"需要登录后操作"),
    LOGIN_PASSWORD_ERROR(2,"密码错误"),
    // TOKEN50~100
    TOKEN_INVALID(50,"无效TOKEN"),
    TOKEN_EXPIRE(51,"TOKEN已过期"),
    TOKEN_REQUIRE(52,"TOKEN是必须的"),
    // SIGN验签 100~120
    SIGN_INVALID(100,"无效的SIGN"),
    SIG_TIMEOUT(101,"SIGN已过期"),
    // 参数错误 500~1000
    PARAM_REQUIRE(500,"缺少参数"),
    PARAM_INVALID(501,"无效参数"),
    PARAM_IMAGE_FORMAT_ERROR(502,"文件格式有误"),
    EMAIL_INVALID(503, "邮箱无效，地址不合法"),
    PASSWORD_INVALID(504, "密码必须包含数字、大小写字母和特殊字符，长度至少8位"),
    NICKNAME_BLANK(505, "未输入有效用户昵称"),
    EMAIL_VERIFY_CODE_BLANK(506, "邮箱验证码为空"),
    SERVER_ERROR(550,"服务器内部错误"),
    // 数据错误 1000~2000
    DATA_EXIST(1000,"数据已经存在"),
    USER_DATA_NOT_EXIST(1001,"User数据不存在"),
    USER_DATA_REPLICATE(1002, "该用户已注册"),
    DATA_NOT_EXIST(1003,"数据不存在"),
    EMAIL_VERIFY_CODE_EXPIRED(1004, "邮箱验证码已过期"),
    EMAIL_VERIFY_CODE_USED(1005, "邮箱验证码已使用"),
    EMAIL_VERIFY_CODE_INCORRECT(1006, "邮箱验证码不正确"),
    // 权限拦截错误 3000~3500
    NO_OPERATOR_AUTH(3000,"无权限操作"),
    NEED_ADMIN(3001,"需要管理员权限"),
    NON_PERSONAL_RESOURCES(3002, "非本人资源不可操作"),
    // 操作段错误
    SEND_EMAIL_CODE_ERR(4000, "发送邮箱验证码异常"),
    IMG_CODE_VERIFY_FAILED(4001, "图形验证码校验失败"),
    ;

    private final int code; //错误码
    private final String message;
    ErrCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
