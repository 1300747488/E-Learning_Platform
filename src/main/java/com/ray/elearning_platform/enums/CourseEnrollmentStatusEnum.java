package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CourseEnrollmentStatusEnum {

    ACTIVE("ACTIVE", "已加入"),
    LEFT("LEFT", "已退出");

    private final String code; // 状态编码
    private final String desc; // 状态说明
}
