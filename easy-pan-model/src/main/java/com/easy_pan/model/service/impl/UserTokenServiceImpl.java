package com.easy_pan.model.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.easy_pan.model.converter.UserTokenConverter;
import com.easy_pan.model.pojo.dto.QueryTokenDTO;
import com.easy_pan.model.pojo.dto.SaveTokenDTO;
import com.easy_pan.model.pojo.entity.UserTokenDO;
import com.easy_pan.model.mapper.UserTokenMapper;
import com.easy_pan.model.service.IUserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储用户refreshToken数据 服务实现类
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserTokenDO> implements IUserTokenService {
    @Resource
    private UserTokenMapper userTokenMapper;

    @Override
    public long saveUserToken(SaveTokenDTO dto) {
        UserTokenDO userToken = UserTokenConverter.INSTANCE.saveTokenDto2UserTokenDO(dto);
        LambdaQueryWrapper<UserTokenDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserTokenDO::getUserId, dto.getUserId());
        UserTokenDO token = this.userTokenMapper.selectOne(wrapper);
        if (token != null) {
            userToken.setId(token.getId());
        }
        this.userTokenMapper.insertOrUpdate(userToken);
        return userToken.getId();
    }

    @Override
    public UserTokenDO queryUserToken(QueryTokenDTO dto) {
        LambdaQueryWrapper<UserTokenDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dto.getUserId() != null, UserTokenDO::getUserId, dto.getUserId());
        return this.userTokenMapper.selectOne(wrapper);
    }

    @Override
    public boolean updateUserToken(SaveTokenDTO dto) {
        LambdaUpdateWrapper<UserTokenDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(dto.getUserId() != null, UserTokenDO::getUserId, dto.getUserId())
                .set(dto.getRefreshToken() != null, UserTokenDO::getRefreshToken, dto.getRefreshToken())
                .set(dto.getAccessToken() != null, UserTokenDO::getAccessToken, dto.getAccessToken())
                .set(dto.getRefreshTokenStatus() != null, UserTokenDO::getRefreshTokenStatus, dto.getRefreshTokenStatus())
                .set(dto.getExpireTime() != null, UserTokenDO::getExpireTime, dto.getExpireTime());
        return this.userTokenMapper.update(wrapper) > 0;
    }
}
