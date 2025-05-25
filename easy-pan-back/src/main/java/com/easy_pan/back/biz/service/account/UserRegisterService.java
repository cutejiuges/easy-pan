package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.UserRegisterData;
import com.easy_pan.account.UserRegisterRequest;
import com.easy_pan.back.biz.service.users.UserService;
import com.easy_pan.back.infra.constants.EmailVerifyCodeStatus;
import com.easy_pan.back.model.bo.EmailVerifyCodeBO;
import com.easy_pan.back.model.dto.QueryUserDTO;
import com.easy_pan.back.model.dto.SaveUserDTO;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.utils.RandomUtil;
import com.easy_pan.common.utils.StringUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserRegisterService {
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 执行用户注册动作
    public UserRegisterData userRegister(UserRegisterRequest req) {
        UserRegisterData data = new UserRegisterData();

        // 1. 检查邮箱是否已经注册过
        if (this.userService.countUser(new QueryUserDTO().setEmail(req.getEmail())) > 0) {
            throw new CustomException(ErrCodeEnum.USER_DATA_REPLICATE);
        }
        // 2. 检查邮箱验证码
        checkEmailVerifyCode(req.getEmail(), req.getEmailVerifyCode());
        // 3. 向db中写入用户信息数据
        long userId = this.saveUserInfo(req);

        data.setUserID(userId);
        return data;
    }

    // 检查邮箱验证码信息
    private void checkEmailVerifyCode(String email, Long code) {
        // 先检查验证码和redis存储是否一致
        String emailKey = StringUtil.generateEmailVerifyCodeKey(email);
        EmailVerifyCodeBO cachedVerifyCode = (EmailVerifyCodeBO) this.redisTemplate.opsForValue().get(emailKey);
        if (cachedVerifyCode == null) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_EXPIRED);
        }
        if (!Objects.equals(cachedVerifyCode.getStatus(), EmailVerifyCodeStatus.EmailVerifyCode_Enable)) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_USED);
        }
        if (!Objects.equals(cachedVerifyCode.getCode(), code)) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_INCORRECT);
        }
        // 一致说明通过校验，将验证码置为已使用
        Long expire = this.redisTemplate.getExpire(emailKey, TimeUnit.MILLISECONDS);
        cachedVerifyCode.setStatus(EmailVerifyCodeStatus.EmailVerifyCode_Used);
        if (expire != null && expire > 0) {
            this.redisTemplate.opsForValue().set(emailKey, cachedVerifyCode, expire, TimeUnit.MILLISECONDS);
        }
    }

    // 保存用户信息
    private long saveUserInfo(UserRegisterRequest req) {
        // 加盐处理密码
        String salt = RandomUtil.randomStr(10);
        String secretPassword = DigestUtils.sha256Hex(req.getPassword() + salt);
        SaveUserDTO userDTO = new SaveUserDTO().setNickName(req.getNickName())
                .setSalt(salt)
                .setPassword(secretPassword)
                .setEmail(req.getEmail());
        return this.userService.createUser(userDTO);
    }
}
