package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEnrollment {

    private Integer enrollmentId; // 选课记录ID，主键

    private Integer courseId; // 课程ID，关联 course.course_id

    private Integer studentId; // 学生ID，关联 account.account_id

    private String status; // 选课状态：ACTIVE / LEFT

    private LocalDateTime enrolledAt; // 加入课程时间

    private LocalDateTime updatedAt; // 更新时间
}
