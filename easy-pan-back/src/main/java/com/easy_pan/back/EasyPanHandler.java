package com.easy_pan.back;

import com.easy_pan.account.*;
import com.easy_pan.back.biz.handler.account.EmailVerifyCodeHandler;
import com.easy_pan.back.biz.handler.account.ImgVerifyCodeHandler;
import com.easy_pan.back.biz.handler.account.UserRegisterHandler;
import com.easy_pan.server.EasyPanService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EasyPanHandler implements EasyPanService.Iface {
    @Resource
    private ImgVerifyCodeHandler imgVerifyCodeHandler;
    @Resource
    private EmailVerifyCodeHandler emailVerifyCodeHandler;
    @Resource
    private UserRegisterHandler userRegisterHandler;

    @Override
    public ImgVerifyCodeResponse ImgVerifyCode(ImgVerifyCodeRequest req) throws TException {
        return (ImgVerifyCodeResponse) this.imgVerifyCodeHandler.handle(req);
    }

    @Override
    public EmailVerifyCodeResponse EmailVerifyCode(EmailVerifyCodeRequest req) throws TException {
        return (EmailVerifyCodeResponse) this.emailVerifyCodeHandler.handle(req);
    }

    @Override
    public UserRegisterResponse UserRegister(UserRegisterRequest req) throws TException {
        return (UserRegisterResponse) this.userRegisterHandler.handle(req);
    }

    @Override
    public UserLoginResponse UserLogin(UserLoginRequest req) throws TException {
        return null;
    }
}
