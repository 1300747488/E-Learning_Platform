package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttemptStartResp {

    private Integer attemptId; // 作答记录ID

    private Integer quizId; // 测验ID

    private Integer studentId; // 学生ID

    private String status; // 作答状态：IN_PROGRESS / SUBMITTED

    private LocalDateTime startedAt; // 开始作答时间

    private LocalDateTime submittedAt; // 提交时间

    private Integer durationSeconds; // 已用时，单位秒

    private List<StudentQuestionResp> questions; // 题目列表，包含已保存答案
}
