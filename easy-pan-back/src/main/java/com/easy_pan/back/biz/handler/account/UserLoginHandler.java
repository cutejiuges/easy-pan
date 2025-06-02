package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.account.UserLoginRequest;
import com.easy_pan.account.UserLoginResponse;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.UserLoginService;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLoginHandler implements BackHandler {
    @Resource
    private UserLoginService userLoginService;

    @Override
    public void checkParams(Object req) throws Exception {
        if (! (req instanceof UserLoginRequest)) {
            throw new CustomException(ErrCodeEnum.PARAM_INVALID);
        }
    }

    @Override
    public void checkPermission(Object req) throws Exception {
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        Exception exception = null;
        UserLoginResponse resp = new UserLoginResponse();
        try {
            this.checkParams(req);
            this.checkPermission(req);
            resp = (UserLoginResponse) this.processBusiness(req);
        } catch (Exception e) {
            log.error("UserLoginHandler.handle exception", e);
            exception = e;
        } finally {
            resp.baseResp = new BaseResp();
            this.packResponse(exception, resp.baseResp);
        }
        return resp;
    }

    @Override
    public Object processBusiness(Object req) throws Exception {
        UserLoginResponse resp = new UserLoginResponse();
        resp.setData(this.userLoginService.login((UserLoginRequest) req));
        return resp;
    }
}
