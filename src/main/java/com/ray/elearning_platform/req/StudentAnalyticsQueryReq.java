package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnalyticsQueryReq {

    private Integer studentId; // 学生ID

    private Integer courseId; // 课程ID，可用于按课程筛选

    private Integer quizId; // 测验ID，可用于按测验筛选
}