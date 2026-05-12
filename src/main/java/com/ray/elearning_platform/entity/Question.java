package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private Integer questionId; // 题目ID，主键

    private Integer quizId; // 测验ID，关联 quiz.quiz_id

    private String questionText; // 题干

    private String optionA; // 选项A

    private String optionB; // 选项B

    private String optionC; // 选项C

    private String optionD; // 选项D

    private String correctOption; // 正确答案：A / B / C / D

    private Integer marks; // 题目分值

    private String topic; // 知识点，用于薄弱知识点分析

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}