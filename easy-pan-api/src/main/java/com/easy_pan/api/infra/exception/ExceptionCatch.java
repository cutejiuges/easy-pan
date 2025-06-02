package com.easy_pan.api.infra.exception;

import com.easy_pan.common.errcode.CustomException;
import com.easy_pan.common.errcode.ErrCodeEnum;
import com.easy_pan.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
// 控制器增强类
public class ExceptionCatch {
    /**
     * 处理不可控异常
     * @param e 不可控异常
     * @return 按照格式化处理的异常信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult<?> exception(Exception e) {
        log.error("catch exception: {}", e.getMessage());
        return ResponseResult.errorResult(ErrCodeEnum.SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult<?> exception(CustomException e) {
        log.error("catch customException: {}", e.getMessage());
        return ResponseResult.errorResult(e.getErrCodeEnum());
    }
}
