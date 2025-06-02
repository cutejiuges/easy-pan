package com.easy_pan.model.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class QueryUserDTO {
    private String email;
}
