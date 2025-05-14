package com.easy_pan.api.service.account;

import com.alibaba.fastjson2.JSON;
import com.easy_pan.account.ImgVerifyCodeRequest;
import com.easy_pan.account.ImgVerifyCodeResponse;
import com.easy_pan.account.VerifyType;
import com.easy_pan.api.rpc.RpcClient;
import com.easy_pan.server.EasyPanService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImgVerifyCodeService {
    @Resource
    private RpcClient Client;

    public void processBusiness(HttpServletResponse response, HttpSession session, ImgVerifyCodeRequest request) throws Exception {
        try {
            ImgVerifyCodeResponse resp = this.Client.getRpcClient().ImgVerifyCode(request);
            if (resp.getBaseResp() != null && resp.getBaseResp().getStatusCode() == 0) {
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                response.getOutputStream().write(resp.getData().getImg());
                response.getOutputStream().close();
                if (request.getVerifyType() == 0) {
                    session.setAttribute(VerifyType.LoginAndRegister.name(), resp.getData().getCode());
                } else {
                    session.setAttribute(VerifyType.EmailVerification.name(), resp.getData().getCode());
                }
            } else {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().println(JSON.toJSONString(resp.getBaseResp()));
                response.getWriter().close();
            }
        } catch (Exception e) {
            log.error("ImgVerifyCodeService processBusiness exception: ", e);
            throw e;
        }
    }
}
