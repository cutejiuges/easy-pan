package com.easy_pan.back.biz.mapper.users;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy_pan.back.model.entity.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserInfoDO> {
}
