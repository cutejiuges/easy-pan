package com.easy_pan.back.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SaveUserDTO {
    private Long userID;
    private String email;
    private String nickName;
    private String avatar;
    private String salt;
    private String password;
    private String emailVerifyCode;
    private Integer status;
    private Long usedSpace;
    private Long totalSpace;
}
