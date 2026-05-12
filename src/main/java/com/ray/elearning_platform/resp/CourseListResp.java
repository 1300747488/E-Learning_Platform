package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseListResp {

    private Integer courseId; // 课程ID

    private String title; // 课程标题

    private String category; // 课程分类

    private Integer teacherId; // 教师ID

    private String teacherName; // 教师姓名

    private String status; // 课程状态

    private LocalDateTime createdAt; // 创建时间
}