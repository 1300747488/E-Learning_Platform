package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Integer courseId; // 课程ID，主键

    private String title; // 课程标题

    private String description; // 课程描述

    private String category; // 课程分类

    private Integer teacherId; // 教师ID，关联 account.account_id

    private String status; // 课程状态

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}