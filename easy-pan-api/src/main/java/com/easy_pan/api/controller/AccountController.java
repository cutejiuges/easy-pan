package com.easy_pan.api.controller;

import com.easy_pan.account.GetVerifyCodeRequest;
import com.easy_pan.account.GetVerifyCodeResponse;
import com.easy_pan.account.VerifyType;
import com.easy_pan.api.service.GetVerifyCodeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Resource
    private GetVerifyCodeService getVerifyCodeService;

    @RequestMapping("/verify_code")
    public void GetVerifyCode(HttpServletResponse response, HttpSession session, Integer type) throws Exception {
        GetVerifyCodeResponse resp = this.getVerifyCodeService.processBusiness(new GetVerifyCodeRequest(type.byteValue()));
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        response.getOutputStream().write(resp.getData().getImg());
        response.getOutputStream().close();
        if (type == 0) {
            session.setAttribute(VerifyType.LoginAndRegister.name(), resp.getData().getCode());
        } else {
            session.setAttribute(VerifyType.EmailVerification.name(), resp.getData().getCode());
        }
    }
}
