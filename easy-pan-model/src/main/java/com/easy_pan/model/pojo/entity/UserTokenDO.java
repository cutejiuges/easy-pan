package com.easy_pan.model.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 存储用户refreshToken数据
 * </p>
 *
 * @author cutejiuge
 * @since 2025-06-02
 */
@Getter
@Setter
@TableName("tb_user_token")
public class UserTokenDO {

    /**
     * token的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户accessToken
     */
    private String accessToken;

    /**
     * refresh_token内容
     */
    private String refreshToken;

    /**
     * token状态，0 - 未知，1 - 在线，2 - 下线
     */
    private Integer refreshTokenStatus;

    /**
     * 当前refresh_token的过期时间
     */
    private LocalDateTime expireTime;
}
