package com.easy_pan.back;

import com.easy_pan.back.biz.handler.account.GetImgVerifyCodeHandler;
import com.easy_pan.server.EasyPanService;
import com.easy_pan.account.GetVerifyCodeRequest;
import com.easy_pan.account.GetVerifyCodeResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EasyPanHandler implements EasyPanService.Iface {
    @Resource
    private GetImgVerifyCodeHandler getVerifyCodeService;

    @Override
    public GetVerifyCodeResponse GetVerifyCode(GetVerifyCodeRequest req) throws TException {
        return (GetVerifyCodeResponse) this.getVerifyCodeService.handle(req);
    }
}
