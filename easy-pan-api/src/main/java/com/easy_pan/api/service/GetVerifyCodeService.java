package com.easy_pan.api.service;

import com.easy_pan.account.GetVerifyCodeRequest;
import com.easy_pan.account.GetVerifyCodeResponse;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.server.EasyPanService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetVerifyCodeService {
    @Resource
    private RpcClient Client;

    public GetVerifyCodeResponse processBusiness(GetVerifyCodeRequest request) throws Exception {
        try {
            EasyPanService.Client rpcClient = this.Client.getRpcClient();
            return rpcClient.GetVerifyCode(request);
        } catch (Exception e) {
            log.error("GetVerifyCodeService processBusiness exception", e);
            throw e;
        }
    }
}
