package com.easy_pan.model.service;

import com.easy_pan.model.pojo.dto.QueryUserDTO;
import com.easy_pan.model.pojo.dto.SaveUserDTO;
import com.easy_pan.model.pojo.entity.UserInfoDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
public interface IUserInfoService extends IService<UserInfoDO> {
    // 用户计数
    Long countUser(QueryUserDTO dto);
    // 向数据库中插入一条用户记录
    Long createUser(SaveUserDTO dto);
    // 查询单条用户记录
    UserInfoDO queryOneUser(QueryUserDTO dto);
}
