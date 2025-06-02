package com.easy_pan.model.pojo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SaveTokenDTO {
    private Long userId;
    private String accessToken;
    private String refreshToken;
    private Integer refreshTokenStatus;
    private LocalDateTime expireTime;
}
