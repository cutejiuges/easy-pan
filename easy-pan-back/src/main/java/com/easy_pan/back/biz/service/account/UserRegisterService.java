package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.UserRegisterData;
import com.easy_pan.account.UserRegisterRequest;
import com.easy_pan.back.infra.utils.RedisOpsUtil;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.utils.RandomUtil;
import com.easy_pan.model.pojo.bo.EmailVerifyCodeBO;
import com.easy_pan.model.pojo.dto.QueryUserDTO;
import com.easy_pan.model.pojo.dto.SaveUserDTO;
import com.easy_pan.model.service.IUserInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UserRegisterService {
    @Resource
    private IUserInfoService userService;
    @Resource
    private RedisOpsUtil redisOpsUtil;

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
        EmailVerifyCodeBO cachedVerifyCode = this.redisOpsUtil.getEmailVerifyCode(email);
        if (cachedVerifyCode == null) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_EXPIRED);
        }
        if (!Objects.equals(cachedVerifyCode.getStatus(), Constants.EmailVerifyCode_Enable)) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_USED);
        }
        if (!Objects.equals(cachedVerifyCode.getCode(), code)) {
            throw new CustomException(ErrCodeEnum.EMAIL_VERIFY_CODE_INCORRECT);
        }
        // 一致说明通过校验，将验证码置为已使用
        this.redisOpsUtil.setEmailVerifyCodeUsed(email);
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
