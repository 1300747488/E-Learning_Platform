package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDetailResp {

    private Integer questionId; // 题目ID

    private Integer quizId; // 测验ID

    private String questionText; // 题干

    private String optionA; // 选项A

    private String optionB; // 选项B

    private String optionC; // 选项C

    private String optionD; // 选项D

    private String correctOption; // 正确答案

    private Integer marks; // 分值

    private String topic; // 知识点

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}