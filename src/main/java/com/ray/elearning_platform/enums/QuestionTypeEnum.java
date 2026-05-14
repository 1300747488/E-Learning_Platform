package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionTypeEnum {

    SINGLE_CHOICE("SINGLE_CHOICE", "单选题"),
    FILL_BLANK("FILL_BLANK", "填空题"),
    SHORT_ANSWER("SHORT_ANSWER", "解答题");

    private final String code; // 题型编码
    private final String desc; // 题型说明
}
