package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {

    private Integer attemptId; // 提交记录ID，主键

    private Integer quizId; // 测验ID，关联 quiz.quiz_id

    private Integer studentId; // 学生ID，关联 account.account_id

    private Integer score; // 学生得分

    private Integer totalMarks; // 测验总分

    private Integer correctCount; // 答对题数

    private Integer wrongCount; // 答错题数

    private String status; // 作答状态：IN_PROGRESS / SUBMITTED

    private LocalDateTime startedAt; // 开始作答时间

    private LocalDateTime submittedAt; // 提交时间

    private Integer durationSeconds; // 答题用时，单位秒
}
