package com.easy_pan.common.result;

import com.easy_pan.common.errcode.ErrCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用结果返回类
 * @param <T>
 */
@Data
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
        this.code = 200;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 创建错误结果
     * @param code 错误码
     * @param msg 错误信息
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> errorResult(int code, String msg) {
        return new ResponseResult<>(code, msg, null);
    }

    /**
     * 创建成功结果，仅包含状态码和消息
     * @param code 状态码
     * @param msg 消息
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> okResult(int code, String msg) {
        return new ResponseResult<T>(code, msg, null);
    }

    /**
     * 创建成功结果，包含数据
     * @param data 数据
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> okResult(T data) {
        return new ResponseResult<>(ErrCodeEnum.SUCCESS.getCode(), ErrCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 创建错误结果，根据ErrCodeEnum
     * @param enums 错误码枚举
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> errorResult(ErrCodeEnum enums) {
        return new ResponseResult<>(enums.getCode(), enums.getMessage(), null);
    }

    /**
     * 创建错误结果，根据ErrCodeEnum和自定义错误信息
     * @param enums 错误码枚举
     * @param errorMessage 自定义错误信息
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> errorResult(ErrCodeEnum enums, String errorMessage) {
        return new ResponseResult<>(enums.getCode(), errorMessage, null);
    }

    /**
     * 根据ErrCodeEnum设置结果
     * @param enums 错误码枚举
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    public static <T> ResponseResult<T> setErrCodeEnum(ErrCodeEnum enums) {
        return new ResponseResult<>(enums.getCode(), enums.getMessage(), null);
    }

    /**
     * 根据ErrCodeEnum和自定义错误信息设置结果
     * @param enums 错误码枚举
     * @param errorMessage 自定义错误信息
     * @param <T> 数据类型
     * @return ResponseResult对象
     */
    private static <T> ResponseResult<T> setErrCodeEnum(ErrCodeEnum enums, String errorMessage) {
        return new ResponseResult<>(enums.getCode(), errorMessage, null);
    }

    /**
     * 设置错误状态
     * @param code 错误码
     * @param msg 错误信息
     * @return ResponseResult对象自身，方便链式调用
     */
    public ResponseResult<T> error(Integer code, String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }

    /**
     * 设置成功状态，仅包含状态码和数据
     * @param code 状态码
     * @param data 数据
     * @return ResponseResult对象自身，方便链式调用
     */
    public ResponseResult<T> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    /**
     * 设置成功状态，包含状态码、数据和消息
     * @param code 状态码
     * @param data 数据
     * @param msg 消息
     * @return ResponseResult对象自身，方便链式调用
     */
    public ResponseResult<T> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
        return this;
    }

    /**
     * 设置成功状态，仅包含数据
     * @param data 数据
     * @return ResponseResult对象自身，方便链式调用
     */
    public ResponseResult<T> ok(T data) {
        this.data = data;
        return this;
    }
}