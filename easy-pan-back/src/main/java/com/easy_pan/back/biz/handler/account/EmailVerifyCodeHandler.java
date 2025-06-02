package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.account.EmailVerifyCodeRequest;
import com.easy_pan.account.EmailVerifyCodeResponse;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.EmailVerifyCodeService;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailVerifyCodeHandler implements BackHandler {
    @Resource
    private EmailVerifyCodeService emailVerifyCodeService;

    @Override
    public void checkParams(Object req)  {
        try {
            if (!(req instanceof EmailVerifyCodeRequest emailVerifyCodeRequest)) {
                throw new CustomException(ErrCodeEnum.PARAM_INVALID);
            }
            if ((emailVerifyCodeRequest.getEmail() == null) ||
                    (emailVerifyCodeRequest.getEmail().trim().isEmpty()) ||
                    emailVerifyCodeRequest.getCheckCode() == null ||
                    emailVerifyCodeRequest.getCheckCode().trim().isEmpty()) {
                throw new CustomException(ErrCodeEnum.PARAM_REQUIRE);
            }
        } catch (Exception e) {
            log.error("GetEmailVerifyCodeHandler.checkParams exception: ", e);
            throw e;
        }
    }

    @Override
    public void checkPermission(Object req) {
    }

    @Override
    public Object processBusiness(Object req) throws Exception {
        this.emailVerifyCodeService.sendEmailVerifyCode((EmailVerifyCodeRequest) req);
        return new EmailVerifyCodeResponse();
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        Exception exception = null;
        EmailVerifyCodeResponse getEmailVerifyCodeResponse = new EmailVerifyCodeResponse();
        try {
            this.checkParams(req);
            this.checkPermission(req);
            getEmailVerifyCodeResponse = (EmailVerifyCodeResponse) this.processBusiness(req);
        } catch (Exception e) {
            log.error("EmailVerifyCodeHandler.handle exception: ", e);
            exception = e;
        } finally {
            getEmailVerifyCodeResponse.baseResp = new BaseResp();
            this.packResponse(exception, getEmailVerifyCodeResponse.baseResp);
        }
        return getEmailVerifyCodeResponse;
    }
}
