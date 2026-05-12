package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardResp {

    private Integer rank; // 排名

    private Integer studentId; // 学生ID

    private String studentName; // 学生姓名

    private String avatar; // 学生头像地址

    private Integer score; // 单次测验得分

    private Double averageScore; // 平均分

    private Integer totalAttempts; // 参加测验次数
}