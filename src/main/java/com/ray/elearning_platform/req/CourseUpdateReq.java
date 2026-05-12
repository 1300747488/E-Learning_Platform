package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpdateReq {

    private Integer courseId; // 课程ID

    private String title; // 课程标题

    private String description; // 课程描述

    private String category; // 课程分类

    private String status; // 课程状态
}