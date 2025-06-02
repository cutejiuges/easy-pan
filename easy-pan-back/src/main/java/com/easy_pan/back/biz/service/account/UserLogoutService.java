package com.easy_pan.back.biz.service.account;

import com.easy_pan.account.UserLogoutRequest;
import com.easy_pan.back.infra.utils.RedisOpsUtil;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.model.pojo.dto.SaveTokenDTO;
import com.easy_pan.model.service.IUserTokenService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserLogoutService {
    @Resource
    private RedisOpsUtil redisOpsUtil;
    @Resource
    private IUserTokenService userTokenService;

    public void userLogout(UserLogoutRequest req) {
        // 如果已经退出了，直接返回即可
        if (redisOpsUtil.isLogoutUserToken(req.getUserID(), req.getAccessToken())) {
            return;
        }
        // 退出登陆时，将refreshToken置为下线状态，并将accessToken存储进redis
        this.userTokenService.updateUserToken(
                SaveTokenDTO.builder()
                        .userId(req.getUserID())
                        .refreshTokenStatus(Constants.TOKEN_STATUS_DISABLE)
                        .build()
        );
        this.redisOpsUtil.cacheLogoutUserToken(req.getUserID(), req.getAccessToken());
    }
}
