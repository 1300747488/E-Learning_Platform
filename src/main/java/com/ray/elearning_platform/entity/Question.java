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

    private String questionType; // 题型：SINGLE_CHOICE / FILL_BLANK / SHORT_ANSWER

    private String questionText; // 题干

    private String questionImage; // 题干图片地址

    private String optionA; // 选项A

    private String optionB; // 选项B

    private String optionC; // 选项C

    private String optionD; // 选项D

    private String correctOption; // 正确答案：A / B / C / D

    private String referenceAnswer; // 填空题或解答题参考答案

    private String explanation; // 题目解析

    private Integer marks; // 题目分值

    private String topic; // 知识点，用于薄弱知识点分析

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}
