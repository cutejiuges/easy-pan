package com.easy_pan.api.service.account;

import com.easy_pan.account.UserLoginRequest;
import com.easy_pan.account.UserLoginResponse;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.result.ResponseResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLoginService {
    @Resource
    private RpcClient client;

    public ResponseResult<?> processUserLogin(UserLoginRequest userLoginRequest) {
        try {
            UserLoginResponse resp = client.getRpcClient().UserLogin(userLoginRequest);
            if (resp.getBaseResp().getStatusCode() != 0) {
                return ResponseResult.errorResult(resp.getBaseResp().getStatusCode(), resp.getBaseResp().getStatusMessage());
            }
            return ResponseResult.okResult(resp.getData());
        } catch (Exception e) {
            log.error("UserLoginService.processUserLogin", e);
            return ResponseResult.errorResult(ErrCodeEnum.SERVER_ERROR, e.getMessage());
        }
    }
}
