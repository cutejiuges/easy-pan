package com.easy_pan.back.biz.handler;

import com.easy_pan.back.biz.service.account_impl.GetVerifyCodeServiceImpl;
import com.easy_pan.server.EasyPanService;
import com.easy_pan.account.GetVerifyCodeRequest;
import com.easy_pan.account.GetVerifyCodeResponse;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EasyPanHandler implements EasyPanService.Iface {
    @Resource
    private GetVerifyCodeServiceImpl getVerifyCodeService;

    @Override
    public GetVerifyCodeResponse GetVerifyCode(GetVerifyCodeRequest req) throws TException {
        return (GetVerifyCodeResponse) this.getVerifyCodeService.Process(req);
    }
}
