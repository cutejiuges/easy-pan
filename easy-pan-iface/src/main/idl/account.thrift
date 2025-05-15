include "base.thrift"

namespace java com.easy_pan.account

//枚举，0登陆注册，1邮箱验证码
enum VerifyType {
    LoginAndRegister = 0;
    EmailVerification = 1;
}

//验证码请求结构
struct ImgVerifyCodeRequest {
    1: i8 verifyType;
    255: optional base.Base base;
}

//验证码请求返回数据
struct ImgVerifyCodeData {
    1: binary img;
    2: string code;
}

//验证码返回结构
struct ImgVerifyCodeResponse {
    1: ImgVerifyCodeData data;
    255: optional base.BaseResp baseResp;
}

// 邮箱验证码请求类型
enum EmailVerifyType {
    Register = 0;
    Retrieve = 1;
}

// 邮箱验证码请求
struct EmailVerifyCodeRequest {
    1: string email;
    2: string checkCode;
    3: i8 emailVerifyType;
    255: optional base.Base base;
}

// 邮箱验证码返回结构
struct EmailVerifyCodeResponse {
    255: base.BaseResp baseResp;
}
