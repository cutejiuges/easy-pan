package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.ImgVerifyCodeService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import com.easy_pan.account.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ImgVerifyCodeHandler implements BackHandler {
    private Exception exception;
    private ImgVerifyCodeResponse getVerifyCodeResponse;

    @Override
    public void checkParams(Object req) {
        try {
            if (!(req instanceof ImgVerifyCodeRequest)) {
                throw new CustomException(ErrCodeEnum.PARAM_INVALID);
            }
        } catch (Exception e) {
            log.error("GetImgVerifyCodeHandler.checkParams exception: ", e);
            throw e;
        }
    }

    @Override
    public void checkPermission(Object req) {
    }

    public void processBusiness(Object req) throws IOException {
        ImgVerifyCodeService imgVerifyCodeService = new ImgVerifyCodeService(130, 40, 5, 10);
        this.getVerifyCodeResponse = new ImgVerifyCodeResponse();
        this.getVerifyCodeResponse.data = new ImgVerifyCodeData();
        this.getVerifyCodeResponse.data.setCode(imgVerifyCodeService.getVerifyCode());
        this.getVerifyCodeResponse.data.setImg(imgVerifyCodeService.writeImg());
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        try {
            this.checkParams(req);
            this.checkPermission(req);
            this.processBusiness(req);
        } catch (Exception e) {
            log.error("GetImgVerifyCodeHandler.Process exception: ", e);
            this.exception = e;
        } finally {
            this.getVerifyCodeResponse.baseResp = new BaseResp();
            this.packResponse(this.exception, this.getVerifyCodeResponse.baseResp);
        }
        return this.getVerifyCodeResponse;
    }
}
