package com.easy_pan.model.pojo.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmailVerifyCodeBO {
    private long code;
    private int status;
}
