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

// 用户注册请求
struct UserRegisterRequest {
    1: string email;
    2: string nickName;
    3: string password;
    4: string imgCheckCode;
    5: i64 emailVerifyCode;
    255: optional base.Base base;
}

// 用户注册返回数据
struct UserRegisterData {
    1: i64 userID;
}

// 用户注册返回
struct UserRegisterResponse {
    1: UserRegisterData data;
    255: optional base.BaseResp baseResp;
}

// 用户登陆请求
struct UserLoginRequest {
    1: required string email;
    2: required string password;
    255: optional base.Base base;
}

// 用户登陆返回数据
struct UserLoginData {
    1: i64 userID;
    2: string nickName;
    3: i64 totalSpace;
    4: i64 usedSpace;
    5: string jwtToken;
}

// 用户登录返回
struct UserLoginResponse {
    1: UserLoginData data;
    255: base.BaseResp baseResp;
}
