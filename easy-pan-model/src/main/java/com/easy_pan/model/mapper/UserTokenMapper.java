package com.easy_pan.model.mapper;

import com.easy_pan.model.pojo.entity.UserTokenDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 存储用户refreshToken数据 Mapper 接口
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
@Mapper
public interface UserTokenMapper extends BaseMapper<UserTokenDO> {

}
