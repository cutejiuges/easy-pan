package com.easy_pan.api.controller;

import com.easy_pan.account.*;
import com.easy_pan.api.infra.result.ResponseResult;
import com.easy_pan.api.service.account.EmailVerifyCodeService;
import com.easy_pan.api.service.account.ImgVerifyCodeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Resource
    private ImgVerifyCodeService imgVerifyCodeService;
    @Resource
    private EmailVerifyCodeService emailVerifyCodeService;

    @GetMapping("/img_verify_code")
    public void GetImgVerifyCode(HttpServletResponse response, HttpSession session, Integer type) throws Exception {
        this.imgVerifyCodeService.processBusiness(response, session, new ImgVerifyCodeRequest(type.byteValue()));
    }

    @PostMapping("/email_verify_code/send")
    public ResponseResult sendEmailVerifyCode(HttpSession session, @RequestBody EmailVerifyCodeRequest req) {
        return this.emailVerifyCodeService.processBusiness(session, req);
    }
}
