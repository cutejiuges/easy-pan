package com.easy_pan.back.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author cutejiuge
 * @since 2025-05-18
 */
@Getter
@Setter
@TableName("tb_user_info")
public class UserInfoDO {

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 用户头像路径
     */
    private String avatar;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 用户状态, 1-正常 2-封禁 3-注销
     */
    private Integer status;

    /**
     * 用户已使用空间，单位byte
     */
    private Long usedSpace;

    /**
     * 用户总空间，单位byte
     */
    private Long totalSpace;
}
