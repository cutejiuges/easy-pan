package com.easy_pan.model.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.model.converter.UserConverter;
import com.easy_pan.model.pojo.dto.QueryUserDTO;
import com.easy_pan.model.pojo.dto.SaveUserDTO;
import com.easy_pan.model.pojo.entity.UserInfoDO;
import com.easy_pan.model.mapper.UserInfoMapper;
import com.easy_pan.model.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements IUserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Long countUser(QueryUserDTO dto) {
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dto.getEmail() != null, UserInfoDO::getEmail, dto.getEmail());
        return this.userInfoMapper.selectCount(queryWrapper);
    }

    @Override
    public Long createUser(SaveUserDTO dto) {
        UserInfoDO userInfo = UserConverter.INSTANCE.SaveUserDTO2UserInfoDO(dto);
        userInfo.setStatus(Constants.USER_STATUS_ENABLE);
        userInfo.setTotalSpace(Constants.DEFAULT_TOTAL_SIZE_5G);
        this.userInfoMapper.insert(userInfo);
        return userInfo.getId();
    }

    @Override
    public UserInfoDO queryOneUser(QueryUserDTO dto) {
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dto.getEmail() != null, UserInfoDO::getEmail, dto.getEmail());
        return this.userInfoMapper.selectOne(queryWrapper);
    }
}
