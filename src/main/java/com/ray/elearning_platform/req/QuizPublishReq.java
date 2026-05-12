package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizPublishReq {

    private Integer quizId; // 测验ID

    private String status; // 发布状态：PUBLISHED / CLOSED
}