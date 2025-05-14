include "account.thrift"

namespace java com.easy_pan.server

service EasyPanService {
    // 账户相关接口
    // 获取验证码
    account.ImgVerifyCodeResponse ImgVerifyCode(1: account.ImgVerifyCodeRequest req);
    // 获取邮箱验证码
    account.EmailVerifyCodeResponse EmailVerifyCode(1: account.EmailVerifyCodeRequest req);
}