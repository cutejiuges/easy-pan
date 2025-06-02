package com.easy_pan.model.service;

import com.easy_pan.model.pojo.dto.QueryTokenDTO;
import com.easy_pan.model.pojo.dto.SaveTokenDTO;
import com.easy_pan.model.pojo.entity.UserTokenDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 存储用户refreshToken数据 服务类
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
public interface IUserTokenService extends IService<UserTokenDO> {
    // 存储token数据
    long saveUserToken(SaveTokenDTO dto);
    // 查找token信息
    UserTokenDO queryUserToken(QueryTokenDTO dto);
    // 更新token信息
    boolean updateUserToken(SaveTokenDTO dto);
}
