package com.easy_pan.back.biz.service.account_impl;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.back.biz.service.BackService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import com.easy_pan.back.infra.utils.VerifyCode;
import com.easy_pan.account.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class GetVerifyCodeServiceImpl implements BackService {
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

    @Override
    public void packResponse(Exception e, BaseResp baseResp) {
        if (e == null) {
            baseResp.setStatusCode(ErrCodeEnum.SUCCESS.getCode());
            baseResp.setStatusMessage(ErrCodeEnum.SUCCESS.getMessage());
        } else if (e instanceof CustomException) {
            ErrCodeEnum errCodeEnum = ((CustomException) e).getErrCodeEnum();
            baseResp.setStatusCode(errCodeEnum.getCode());
            baseResp.setStatusMessage(errCodeEnum.getMessage());
        } else {
            baseResp.setStatusCode(ErrCodeEnum.SERVER_ERROR.getCode());
            baseResp.setStatusMessage(ErrCodeEnum.SERVER_ERROR.getMessage());
        }
    }

    @Override
    public Object Process(Object req) {
        try {
            this.checkParams(req);
            this.checkPermission(req);
            this.processBusiness((GetVerifyCodeRequest) req);
        } catch (Exception e) {
            log.error("GetVerifyCodeServiceImpl.Process error: ", e);
            this.exception = e;
        } finally {
            this.getVerifyCodeResponse.baseResp = new BaseResp();
            this.packResponse(this.exception, this.getVerifyCodeResponse.baseResp);
        }
        return this.getVerifyCodeResponse;
    }

    private void processBusiness(GetVerifyCodeRequest req) throws IOException {
        this.getVerifyCodeResponse = new GetVerifyCodeResponse();
        this.getVerifyCodeResponse.data = new GetVerifyCodeData();
        VerifyCode verifyCode = new VerifyCode(130, 40, 5, 10);
        this.getVerifyCodeResponse.data.setCode(verifyCode.getVerifyCode());
        this.getVerifyCodeResponse.data.setImg(verifyCode.writeImg());
    }
}
