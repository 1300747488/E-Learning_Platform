package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseResp {

    private Integer enrollmentId; // 选课记录ID

    private Integer courseId; // 课程ID

    private String title; // 课程标题

    private String description; // 课程描述

    private String category; // 课程分类

    private Integer teacherId; // 教师ID

    private String teacherName; // 教师姓名

    private String courseStatus; // 课程状态

    private String enrollmentStatus; // 选课状态

    private LocalDateTime enrolledAt; // 加入课程时间
}
