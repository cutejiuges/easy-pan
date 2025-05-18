package com.easy_pan.back.biz.service.users.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy_pan.back.biz.mapper.users.UserMapper;
import com.easy_pan.back.biz.service.users.UserService;
import com.easy_pan.back.infra.constants.SpaceSize;
import com.easy_pan.back.infra.constants.UserInfoStatus;
import com.easy_pan.back.model.converter.UserConverter;
import com.easy_pan.back.model.dto.QueryUserDTO;
import com.easy_pan.back.model.dto.SaveUserDTO;
import com.easy_pan.back.model.entity.UserInfoDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfoDO> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Long countUser(QueryUserDTO dto) {
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dto.getEmail() != null, UserInfoDO::getEmail, dto.getEmail());
        return this.userMapper.selectCount(queryWrapper);
    }

    @Override
    public Long createUser(SaveUserDTO dto) {
        UserInfoDO userInfo = UserConverter.INSTANCE.SaveUserDTO2UserInfoDO(dto);
        userInfo.setStatus(UserInfoStatus.USER_STATUS_ENABLE);
        userInfo.setTotalSpace(SpaceSize.DEFAULT_TOTAL_SIZE);
        this.userMapper.insert(userInfo);
        return userInfo.getId();
    }
}
