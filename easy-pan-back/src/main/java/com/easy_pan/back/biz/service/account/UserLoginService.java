package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.UserLoginData;
import com.easy_pan.account.UserLoginRequest;
import com.easy_pan.back.biz.service.users.UserService;
import com.easy_pan.back.model.converter.UserConverter;
import com.easy_pan.back.model.dto.QueryUserDTO;
import com.easy_pan.back.model.entity.UserInfoDO;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLoginService {
    @Resource
    private UserService userService;

    public UserLoginData login(UserLoginRequest loginRequest) {
        UserLoginData userLoginData = new UserLoginData();
        // 根据邮箱查询用户数据
        UserInfoDO user = this.userService.queryOneUser(new QueryUserDTO().setEmail(loginRequest.getEmail()));
        if (user == null) {
            throw new CustomException(ErrCodeEnum.USER_DATA_NOT_EXIST);
        }
        // 按照存储数据校验密码
        String secretPassword = user.getPassword(), salt = user.getSalt();
        if (!secretPassword.equals(DigestUtils.sha256Hex(loginRequest.getPassword() + salt))) {
            throw new CustomException(ErrCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        userLoginData = UserConverter.INSTANCE.UserInfoDO2UserLoginData(user);
        // 生成jwtToken
        String jwtToken = null;
        return userLoginData;
    }
}
