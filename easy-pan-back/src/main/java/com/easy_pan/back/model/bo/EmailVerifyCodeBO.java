package com.easy_pan.back.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmailVerifyCodeBO {
    private Integer code;
    private Integer status;
}
