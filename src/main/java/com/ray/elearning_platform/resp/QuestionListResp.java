package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionListResp {

    private Integer questionId; // 题目ID

    private Integer quizId; // 测验ID

    private String questionText; // 题干

    private String optionA; // 选项A

    private String optionB; // 选项B

    private String optionC; // 选项C

    private String optionD; // 选项D

    private String correctOption; // 正确答案，学生端返回时应隐藏

    private Integer marks; // 分值

    private String topic; // 知识点
}