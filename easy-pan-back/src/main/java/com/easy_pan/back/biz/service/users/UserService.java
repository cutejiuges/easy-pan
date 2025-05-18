package com.easy_pan.back.biz.service.users;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy_pan.back.model.dto.QueryUserDTO;
import com.easy_pan.back.model.dto.SaveUserDTO;
import com.easy_pan.back.model.entity.UserInfoDO;

public interface UserService extends IService<UserInfoDO> {
    // 用户计数
    Long countUser(QueryUserDTO dto);
    // 向数据库中插入一条用户记录
    Long createUser(SaveUserDTO dto);
}
