package com.ray.elearning_platform.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaterialTypeEnum {

    PDF("PDF", "PDF文档"),
    VIDEO("VIDEO", "视频"),
    NOTE("NOTE", "笔记"),
    PPT("PPT", "课件"),
    OTHER("OTHER", "其他");

    private final String code; // 类型编码
    private final String desc; // 类型说明
}