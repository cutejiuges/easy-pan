package com.easy_pan.back.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class QueryUserDTO {
    private String email;
}
