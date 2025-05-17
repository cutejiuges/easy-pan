package com.easy_pan.api.service.account;

import com.easy_pan.account.EmailVerifyCodeRequest;
import com.easy_pan.account.EmailVerifyCodeResponse;
import com.easy_pan.account.VerifyType;
import com.easy_pan.api.infra.result.ResponseResult;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.back.infra.err_code.ErrCodeEnum;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailVerifyCodeService {
    @Resource
    private RpcClient client;

    public ResponseResult processBusiness(HttpSession session, EmailVerifyCodeRequest req) {
        try {
            if (!req.getCheckCode().equalsIgnoreCase((String) session.getAttribute(VerifyType.EmailVerification.name()))) {
                return ResponseResult.errorResult(ErrCodeEnum.IMG_CODE_VERIFY_FAILED);
            }
            EmailVerifyCodeResponse resp = this.client.getRpcClient().EmailVerifyCode(req);
            if (resp.getBaseResp().getStatusCode() != 0) {
                return ResponseResult.errorResult(resp.getBaseResp().getStatusCode(), resp.getBaseResp().getStatusMessage());
            }
            return ResponseResult.okResult(null);
        } catch (Exception e) {
            log.error("EmailVerifyCodeService.processBusiness exception: ", e);
            return ResponseResult.errorResult(ErrCodeEnum.SERVER_ERROR, e.getMessage());
        } finally {
            session.removeAttribute(VerifyType.EmailVerification.name());
        }
    }
}
