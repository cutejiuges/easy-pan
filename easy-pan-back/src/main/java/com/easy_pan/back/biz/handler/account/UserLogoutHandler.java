package com.easy_pan.back.biz.handler.account;

import com.cutejiuge.base.BaseResp;
import com.easy_pan.account.UserLogoutRequest;
import com.easy_pan.account.UserLogoutResponse;
import com.easy_pan.back.biz.handler.BackHandler;
import com.easy_pan.back.biz.service.account.UserLogoutService;
import com.easy_pan.common.enums.JwtTokenTypeEnum;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.utils.JwtUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserLogoutHandler implements BackHandler {
    @Resource
    private UserLogoutService userLogoutService;

    @Override
    public void checkParams(Object req) throws Exception {
        if (!(req instanceof UserLogoutRequest request)) {
            throw new CustomException(ErrCodeEnum.PARAM_INVALID);
        }
        if (request.getAccessToken().isBlank()) {
            throw new CustomException(ErrCodeEnum.TOKEN_REQUIRE);
        }
        if (JwtUtil.invalidJwtToken(request.getAccessToken(), JwtTokenTypeEnum.AccessToken.getCode())) {
            throw new CustomException(ErrCodeEnum.TOKEN_INVALID);
        }
        if (JwtUtil.expiredJwtToken(request.getAccessToken())) {
            throw new CustomException(ErrCodeEnum.TOKEN_EXPIRE);
        }
    }

    @Override
    public void checkPermission(Object req) throws Exception {
        UserLogoutRequest request = (UserLogoutRequest) req;
        Map<String, Object> claims = JwtUtil.parseJwtToken(request.getAccessToken());
        long payloadUserId = Long.parseLong(claims.get("userID").toString());
        if (payloadUserId != request.getUserID()) {
            throw new CustomException(ErrCodeEnum.NON_PERSONAL_RESOURCES);
        }
    }

    @Override
    public Object handle(Object req) {
        UserLogoutResponse resp = new UserLogoutResponse();
        Exception exception = null;
        try {
            this.checkParams(req);
            this.checkPermission(req);
            resp = (UserLogoutResponse) this.processBusiness(req);
        } catch (Exception e) {
            log.error("UserLogoutHandler.handle exception", e);
            exception = e;
        } finally {
            resp.baseResp = new BaseResp();
            this.packResponse(exception, resp.baseResp);
        }
        return resp;
    }

    @Override
    public Object processBusiness(Object req) throws Exception {
        UserLogoutResponse response = new UserLogoutResponse();
        this.userLogoutService.userLogout((UserLogoutRequest) req);
        return response;
    }
}
