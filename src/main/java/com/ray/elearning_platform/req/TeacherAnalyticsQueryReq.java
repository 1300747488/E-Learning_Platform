package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherAnalyticsQueryReq {

    private Integer teacherId; // 教师ID

    private Integer courseId; // 课程ID

    private Integer quizId; // 测验ID
}