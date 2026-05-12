package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseScoreResp {

    private Integer courseId; // 课程ID

    private String courseTitle; // 课程标题

    private Integer quizId; // 测验ID

    private String quizTitle; // 测验标题

    private Integer studentId; // 学生ID

    private String studentName; // 学生姓名

    private Integer score; // 学生得分

    private Integer totalMarks; // 测验总分

    private LocalDateTime submittedAt; // 提交时间
}