package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BizCodeEnum {

    SUCCESS(0, "success"),
    PARAM_ERROR(400, "参数错误"),
    ACCOUNT_REPEAT(1001, "账号已存在"),
    ACCOUNT_NOT_EXIST(1002, "账号不存在"),
    PASSWORD_ERROR(1003, "密码错误"),
    ACCOUNT_DISABLED(1004, "账号已禁用"),
    NO_LOGIN(2001, "用户未登录"),
    NO_PERMISSION(2002, "没有权限"),
    SERVER_ERROR(500, "服务器错误");

    private final Integer code; // 状态码
    private final String msg; // 提示信息

}