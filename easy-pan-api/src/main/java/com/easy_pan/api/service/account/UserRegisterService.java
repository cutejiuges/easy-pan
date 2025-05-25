package com.easy_pan.api.service.account;

import com.easy_pan.account.UserRegisterRequest;
import com.easy_pan.account.UserRegisterResponse;
import com.easy_pan.account.VerifyType;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.result.ResponseResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegisterService {
    @Resource
    private RpcClient client;

    public ResponseResult processUserRegister(HttpSession session, UserRegisterRequest req) {
        if (!req.getImgCheckCode().equalsIgnoreCase((String) session.getAttribute(VerifyType.LoginAndRegister.name()))) {
            return ResponseResult.errorResult(ErrCodeEnum.IMG_CODE_VERIFY_FAILED);
        }
        try {
            UserRegisterResponse resp = this.client.getRpcClient().UserRegister(req);
            if (resp.getBaseResp().getStatusCode() != 0) {
                return ResponseResult.errorResult(resp.getBaseResp().getStatusCode(), resp.getBaseResp().getStatusMessage());
            }
            return ResponseResult.okResult(resp.getData());
        } catch (TException e) {
            log.error("UserRegisterService.processUserRegister exception", e);
            return ResponseResult.errorResult(ErrCodeEnum.SERVER_ERROR, e.getMessage());
        } finally {
            session.removeAttribute(VerifyType.LoginAndRegister.name());
        }
    }
}
