package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudentAnswerStatusEnum {

    ANSWERED("ANSWERED", "已作答"),
    UNANSWERED("UNANSWERED", "未作答");

    private final String code; // 状态编码
    private final String desc; // 状态说明
}
