package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswer {

    private Integer answerId; // 答案记录ID，主键

    private Integer attemptId; // 测验提交记录ID，关联 quiz_attempt.attempt_id

    private Integer questionId; // 题目ID，关联 question.question_id

    private String selectedOption; // 学生选择的答案：A / B / C / D

    private Boolean isCorrect; // 是否答对

    private Integer awardedMarks; // 本题得分
}