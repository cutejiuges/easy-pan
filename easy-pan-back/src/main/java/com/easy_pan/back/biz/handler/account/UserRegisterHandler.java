package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.account.UserRegisterRequest;
import com.easy_pan.account.UserRegisterResponse;
import com.easy_pan.back.annotation.ArgsLogging;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.UserRegisterService;
import com.easy_pan.back.infra.err_code.CustomException;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import com.easy_pan.back.infra.utils.ParamsCheckUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegisterHandler implements BackHandler {
    @Resource
    private UserRegisterService userRegisterService;

    @Override
    public void checkParams(Object req) throws Exception {
        // 校验请求参数类型
        if (!(req instanceof UserRegisterRequest registerRequest)) {
            throw new CustomException(ErrCodeEnum.PARAM_INVALID);
        }
        // 校验邮箱地址格式
        if (!ParamsCheckUtil.isValidEmail(registerRequest.getEmail())) {
            throw new CustomException(ErrCodeEnum.EMAIL_INVALID);
        }
        // 校验密码数据
        if (!ParamsCheckUtil.isValidPassword(registerRequest.getPassword())) {
            throw new CustomException(ErrCodeEnum.PASSWORD_INVALID);
        }
        // 校验昵称
        if (Strings.isBlank(registerRequest.getNickName())) {
            throw new CustomException(ErrCodeEnum.NICKNAME_BLANK);
        }
        // 校验邮箱验证码
        if (registerRequest.getEmailVerifyCode() == 0) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_BLANK);
        }
    }

    @Override
    public void checkPermission(Object req) throws Exception {
    }

    @Override
    @ArgsLogging
    public Object handle(Object req) {
        Exception exception = null;
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        try {
            checkParams(req);
            checkPermission(req);
            userRegisterResponse = (UserRegisterResponse) processBusiness(req);
        } catch (Exception e) {
            log.error("UserRegisterHandler.handle exception:", e);
            exception = e;
        } finally {
            userRegisterResponse.baseResp = new BaseResp();
            this.packResponse(exception, userRegisterResponse.baseResp);
        }
        return userRegisterResponse;
    }

    @Override
    public Object processBusiness(Object req) throws Exception {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setData(this.userRegisterService.userRegister((UserRegisterRequest) req));
        return userRegisterResponse;
    }
}
