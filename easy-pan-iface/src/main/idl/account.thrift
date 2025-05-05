include "base.thrift"

namespace java com.easy_pan.account

//枚举，0登陆注册，1邮箱验证码
enum VerifyType {
    LoginAndRegister = 0;
    EmailVerification = 1;
}

//验证码请求结构
struct GetVerifyCodeRequest {
    1: i8 verifyType;
    255: optional base.Base base;
}

//验证码请求返回数据
struct GetVerifyCodeData {
    1: binary img;
    2: string code;
}

//验证码返回结构
struct GetVerifyCodeResponse {
    1: GetVerifyCodeData data;
    255: optional base.BaseResp baseResp;
}
