package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.ImgVerifyCodeService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import com.easy_pan.account.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ImgVerifyCodeHandler implements BackHandler {
    @Resource
    private ImgVerifyCodeService imgVerifyCodeService;
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

    public Object processBusiness(Object req) throws IOException {
        ImgVerifyCodeResponse resp = new ImgVerifyCodeResponse();
        resp.data = new ImgVerifyCodeData();
        this.imgVerifyCodeService.randomVerifyCode();
        resp.data.setCode(this.imgVerifyCodeService.getVerifyCode());
        resp.data.setImg(this.imgVerifyCodeService.writeImg());
        return resp;
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        Exception exception = null;
        ImgVerifyCodeResponse resp = new ImgVerifyCodeResponse();
        try {
            this.checkParams(req);
            this.checkPermission(req);
            resp = (ImgVerifyCodeResponse) this.processBusiness(req);
        } catch (Exception e) {
            log.error("GetImgVerifyCodeHandler.Process exception: ", e);
            exception = e;
        } finally {
            resp.baseResp = new BaseResp();
            this.packResponse(exception, resp.baseResp);
        }
        return resp;
    }
}
