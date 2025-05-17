package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.account.EmailVerifyCodeRequest;
import com.easy_pan.account.EmailVerifyCodeResponse;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.EmailVerifyCodeService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailVerifyCodeHandler implements BackHandler {
    @Resource
    private EmailVerifyCodeService emailVerifyCodeService;
    private EmailVerifyCodeResponse getEmailVerifyCodeResponse;
    private Exception exception;

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
    public void processBusiness(Object req) throws Exception {
        this.getEmailVerifyCodeResponse = new EmailVerifyCodeResponse();
        this.emailVerifyCodeService.sendEmailVerifyCode((EmailVerifyCodeRequest) req);
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        try {
            this.checkParams(req);
            this.checkPermission(req);
            this.processBusiness(req);
        } catch (Exception e) {
            log.error("EmailVerifyCodeHandler.handle exception: ", e);
            this.exception = e;
        } finally {
            this.getEmailVerifyCodeResponse.baseResp = new BaseResp();
            this.packResponse(this.exception, this.getEmailVerifyCodeResponse.baseResp);
        }
        return this.getEmailVerifyCodeResponse;
    }
}
