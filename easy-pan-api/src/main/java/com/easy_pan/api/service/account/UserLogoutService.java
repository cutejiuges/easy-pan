package com.easy_pan.api.service.account;

import com.easy_pan.account.UserLogoutRequest;
import com.easy_pan.account.UserLogoutResponse;
import com.easy_pan.api.infra.utils.JwtTokenHolder;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.result.ResponseResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLogoutService {
    @Resource
    private RpcClient client;

    public ResponseResult<?> processUserLogout(Long userId) {
        UserLogoutRequest userLogoutRequest = new UserLogoutRequest();
        userLogoutRequest.setUserID(userId);
        userLogoutRequest.setAccessToken(JwtTokenHolder.getToken());
        try {
            UserLogoutResponse resp = this.client.getRpcClient().UserLogout(userLogoutRequest);
            if (resp.getBaseResp().getStatusCode() != 0) {
                return ResponseResult.errorResult(resp.getBaseResp().getStatusCode(), resp.getBaseResp().getStatusMessage());
            }
            return ResponseResult.okResult(null);
        } catch (Exception e) {
            log.error("UserLogoutService.processUserLogout exception: ", e);
            return ResponseResult.errorResult(ErrCodeEnum.SERVER_ERROR, e.getMessage());
        }
    }
}
