package com.easy_pan.model.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInfoVO {
    private long userID;
    private String nickName;
    private long totalSpace;
    private long usedSpace;
}
