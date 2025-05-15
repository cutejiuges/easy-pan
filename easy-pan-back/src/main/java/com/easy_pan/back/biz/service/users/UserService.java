package com.easy_pan.back.biz.service.users;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy_pan.back.model.dto.QueryUserDTO;
import com.easy_pan.back.model.entity.UserInfoDO;

public interface UserService extends IService<UserInfoDO> {
    Long countUser(QueryUserDTO dto);
}
