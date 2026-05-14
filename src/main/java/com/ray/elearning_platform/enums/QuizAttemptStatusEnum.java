package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuizAttemptStatusEnum {

    IN_PROGRESS("IN_PROGRESS", "作答中"),
    SUBMITTED("SUBMITTED", "已提交");

    private final String code; // 状态编码
    private final String desc; // 状态说明
}
