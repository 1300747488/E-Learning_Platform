package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatusEnum {

    ACTIVE("ACTIVE", "正常"),
    DISABLED("DISABLED", "禁用"),
    DELETED("DELETED", "已删除");

    private final String code; // 状态编码
    private final String desc; // 状态说明
}