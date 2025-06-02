package com.easy_pan.back.biz.handler;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;


public interface BackHandler {
    void checkParams(Object req) throws Exception;
    void checkPermission(Object req) throws Exception;
    Object handle(Object req) throws Exception;
    Object processBusiness(Object req) throws Exception;
    default void packResponse(Exception e, BaseResp baseResp) {
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
}
