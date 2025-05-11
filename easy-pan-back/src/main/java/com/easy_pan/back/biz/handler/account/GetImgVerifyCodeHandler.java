package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.GetImgVerifyCodeService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import com.easy_pan.account.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class GetImgVerifyCodeHandler implements BackHandler {
    private Exception exception;
    private GetVerifyCodeResponse getVerifyCodeResponse;

    @Override
    public void checkParams(Object req) {
        try {
            if (!(req instanceof GetVerifyCodeRequest)) {
                throw new CustomException(ErrCodeEnum.PARAM_INVALID);
            }
        } catch (Exception e) {
            log.error("GetVerifyCodeServiceImpl.checkParams error: ", e);
            throw e;
        }
    }

    @Override
    public void checkPermission(Object req) {
    }

    public void processBusiness(Object req) throws IOException {
        GetImgVerifyCodeService getImgVerifyCodeService = new GetImgVerifyCodeService(130, 40, 5, 10);
        this.getVerifyCodeResponse = new GetVerifyCodeResponse();
        this.getVerifyCodeResponse.data = new GetVerifyCodeData();
        this.getVerifyCodeResponse.data.setCode(getImgVerifyCodeService.getVerifyCode());
        this.getVerifyCodeResponse.data.setImg(getImgVerifyCodeService.writeImg());
    }

    @Override
    public Object handle(Object req) {
        try {
            this.checkParams(req);
            this.checkPermission(req);
            this.processBusiness(req);
        } catch (Exception e) {
            log.error("GetVerifyCodeServiceImpl.Process error: ", e);
            this.exception = e;
        } finally {
            this.getVerifyCodeResponse.baseResp = new BaseResp();
            this.packResponse(this.exception, this.getVerifyCodeResponse.baseResp);
        }
        return this.getVerifyCodeResponse;
    }
}
