include "account.thrift"

namespace java com.easy_pan.server

service EasyPanService {
    // 账户相关接口
    // 获取验证码
    account.GetVerifyCodeResponse GetVerifyCode(1: account.GetVerifyCodeRequest req)
}