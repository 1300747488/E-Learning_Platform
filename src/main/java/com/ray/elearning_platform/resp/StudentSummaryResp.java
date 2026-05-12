package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSummaryResp {

    private Integer studentId; // 学生ID

    private String studentName; // 学生姓名

    private Integer totalAttempts; // 参加测验次数

    private Double averageScore; // 平均分

    private Integer highestScore; // 最高分

    private Integer lowestScore; // 最低分

    private Double passRate; // 通过率
}