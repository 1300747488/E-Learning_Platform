package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentResp {

    private Integer enrollmentId; // 选课记录ID

    private Integer courseId; // 课程ID

    private Integer studentId; // 学生ID

    private String username; // 用户名

    private String fullName; // 学生姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 学生头像地址

    private String status; // 选课状态

    private LocalDateTime enrolledAt; // 加入课程时间
}
