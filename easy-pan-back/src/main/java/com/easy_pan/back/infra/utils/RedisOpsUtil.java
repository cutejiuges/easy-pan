package com.easy_pan.back.infra.utils;

import com.easy_pan.common.constants.Constants;
import com.easy_pan.common.utils.JwtUtil;
import com.easy_pan.common.utils.RedisKeyUtil;
import com.easy_pan.model.pojo.bo.EmailVerifyCodeBO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class RedisOpsUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 向redis中存储邮箱验证码
     * @param email 邮箱
     * @param code 此邮箱对应的验证码
     */
    public void cacheEmailVerifyCode(String email, long code) {
        EmailVerifyCodeBO verifyCodeBO = new EmailVerifyCodeBO()
                .setCode(code)
                .setStatus(Constants.EmailVerifyCode_Enable);
        this.redisTemplate.opsForValue().set(RedisKeyUtil.generateEmailVerifyCodeKey(email), verifyCodeBO, Duration.ofMinutes(3));
    }

    /**
     * 从redis中取出邮箱对应的验证码
     * @param email 邮箱
     * @return 此邮箱对应的验证码
     */
    public EmailVerifyCodeBO getEmailVerifyCode(String email) {
        String emailKey = RedisKeyUtil.generateEmailVerifyCodeKey(email);
        return (EmailVerifyCodeBO) this.redisTemplate.opsForValue().get(emailKey);
    }

    /**
     * 将邮箱验证码设置为已使用
     * @param email 邮箱
     */
    public void setEmailVerifyCodeUsed(String email) {
        String emailKey = RedisKeyUtil.generateEmailVerifyCodeKey(email);
        Long expire = this.redisTemplate.getExpire(emailKey, TimeUnit.MILLISECONDS);
        // 如果这个邮箱验证码已经过期了直接返回
        if (expire == null || expire < 0) {
            return;
        }
        EmailVerifyCodeBO verifyCode = this.getEmailVerifyCode(email);
        verifyCode.setStatus(Constants.EmailVerifyCode_Used);
        this.redisTemplate.opsForValue().set(emailKey, verifyCode, expire, TimeUnit.MILLISECONDS);
    }

    /**
     * 将退出登陆的用户token写入redis
     * @param userId 用户id
     * @param token 当前登陆的token
     */
    public void cacheLogoutUserToken(long userId, String token) {
        String logoutKey = RedisKeyUtil.generateLogoutKey(userId, token);
        this.redisTemplate.opsForValue().set(logoutKey, token, JwtUtil.getAccessExpirationTime(), TimeUnit.MILLISECONDS);
    }

    /**
     * 判断用户的token是否已经退出登陆
     * @param userId 用户id
     * @param token token字符串
     * @return 退出为true，在线为false
     */
    public boolean isLogoutUserToken(long userId, String token) {
        return Boolean.TRUE.equals(this.redisTemplate.hasKey(RedisKeyUtil.generateLogoutKey(userId, token)));
    }
}
