package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OssUploadBizTypeEnum {

    MATERIAL("MATERIAL", "课程资料"),
    QUESTION_IMAGE("QUESTION_IMAGE", "题干图片"),
    ANSWER_IMAGE("ANSWER_IMAGE", "解答题图片答案"),
    AVATAR("AVATAR", "用户头像");

    private final String code; // 业务类型编码
    private final String desc; // 业务类型说明
}
