package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeakTopicResp {

    private String topic; // 知识点

    private Integer totalCount; // 答题总数

    private Integer wrongCount; // 错题数量

    private Double accuracy; // 正确率
}