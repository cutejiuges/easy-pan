package com.easy_pan.model.mapper;

import com.easy_pan.model.pojo.entity.UserInfoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author cutejiuge
 * @since 2025-05-29
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {

}
