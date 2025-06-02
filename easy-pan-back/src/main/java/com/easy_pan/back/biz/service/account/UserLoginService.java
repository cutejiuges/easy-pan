package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.UserLoginData;
import com.easy_pan.account.UserLoginRequest;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.common.enums.JwtTokenTypeEnum;
import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.utils.JwtUtil;
import com.easy_pan.model.converter.UserConverter;
import com.easy_pan.model.pojo.dto.QueryUserDTO;
import com.easy_pan.model.pojo.dto.SaveTokenDTO;
import com.easy_pan.model.pojo.entity.UserInfoDO;
import com.easy_pan.model.pojo.vo.UserInfoVO;
import com.easy_pan.model.service.IUserInfoService;
import com.easy_pan.model.service.IUserTokenService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Slf4j
@Service
public class UserLoginService {
    @Resource
    private IUserInfoService userService;
    @Resource
    private IUserTokenService userTokenService;

    @Transactional(rollbackFor = Exception.class)
    public UserLoginData login(UserLoginRequest loginRequest) {
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
        // 隐去隐私数据，转换简易结构供前端展示
        UserLoginData userLoginData = UserConverter.INSTANCE.UserInfoDO2UserLoginData(user);
        // 生成jwtToken
        UserInfoVO userInfoVO = UserConverter.INSTANCE.UserInfoDO2UserInfoVO(user);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(userInfoVO, new TypeReference<>() {});
        String accessToken = JwtUtil.generateJwtToken(map, JwtTokenTypeEnum.AccessToken.getCode());
        String refreshToken = JwtUtil.generateJwtToken(map, JwtTokenTypeEnum.RefreshToken.getCode());
        userLoginData.setAccessToken(accessToken);
        userLoginData.setRefreshToken(refreshToken);
        // 存储登陆信息到数据库
        saveLoginInfo(user, refreshToken, accessToken);
        return userLoginData;
    }

    private void saveLoginInfo(UserInfoDO user, String refreshToken, String accessToken) {
        // 将refresh_token和用户信息存储到数据库
        this.userTokenService.saveUserToken(SaveTokenDTO.builder()
                .userId(user.getId())
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .refreshTokenStatus(Constants.TOKEN_STATUS_ENABLE)
                .expireTime(LocalDateTime.now().plus(JwtUtil.getRefreshExpirationTime(), ChronoUnit.MILLIS))
                .build()
        );
        // 更新用户的最后登录时间
        user.setLastLoginTime(LocalDateTime.now());
        this.userService.updateById(user);
    }
}
