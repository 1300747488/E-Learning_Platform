package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreateReq {

    private Integer courseId; // 课程ID

    private String title; // 测验标题

    private String description; // 测验说明

    private Integer timeLimit; // 答题时长，单位分钟

    private Integer totalMarks; // 测验总分

    private LocalDateTime startTime; // 开始时间

    private LocalDateTime endTime; // 结束时间

    private Integer createdBy; // 创建者ID
}