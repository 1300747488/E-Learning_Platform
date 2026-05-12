package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    private Integer quizId; // 测验ID，主键

    private Integer courseId; // 课程ID，关联 course.course_id

    private String title; // 测验标题

    private String description; // 测验说明

    private Integer timeLimit; // 答题时长，单位分钟

    private Integer totalMarks; // 测验总分

    private LocalDateTime startTime; // 测验开始时间

    private LocalDateTime endTime; // 测验结束时间

    private String status; // 测验状态：DRAFT / PUBLISHED / CLOSED

    private Integer createdBy; // 创建者ID，关联 account.account_id

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}