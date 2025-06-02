package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.EmailVerifyCodeRequest;
import com.easy_pan.account.EmailVerifyType;
import com.easy_pan.back.infra.utils.MailUtil;
import com.easy_pan.back.infra.utils.RedisOpsUtil;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.utils.RandomUtil;
import com.easy_pan.common.utils.RedisKeyUtil;
import com.easy_pan.model.pojo.bo.EmailVerifyCodeBO;
import com.easy_pan.model.pojo.dto.QueryUserDTO;
import com.easy_pan.model.service.IUserInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class EmailVerifyCodeService {
    @Resource
    private RedisOpsUtil redisOpsUtil;
    @Resource
    private MailUtil mailUtil;
    @Resource
    private IUserInfoService userService;

    public void sendEmailVerifyCode(EmailVerifyCodeRequest request) throws Exception {
        // 如果是新用户注册，检查是否已经注册过
        if (request.getEmailVerifyType() == EmailVerifyType.Register.getValue()) {
            if (this.userService.countUser(new QueryUserDTO().setEmail(request.getEmail())) > 0){
                throw new CustomException(ErrCodeEnum.USER_DATA_REPLICATE);
            }
        }
        // 获取6位数验证码
        long code = RandomUtil.randomInt(100000, 999999);
        log.info("email verify code : {}", code);
        // 发送验证码
        processSendCode(request.getEmail(), code, request.getEmailVerifyType());
        // 数据验证码数据存储到redis中
        this.redisOpsUtil.cacheEmailVerifyCode(request.getEmail(), code);
    }

    private void processSendCode(String email, long code, int type) throws Exception {
        try {
            if (type == EmailVerifyType.Register.getValue()) {
                this.mailUtil.sendRegisterCode(email, code);
            } else {
                this.mailUtil.sendPasswordResetCode(email, code);
            }
        } catch (Exception e) {
            log.error("EmailVerifyCodeService.processSendCode exception: ", e);
            throw new CustomException(ErrCodeEnum.SEND_EMAIL_CODE_ERR);
        }
    }
}
