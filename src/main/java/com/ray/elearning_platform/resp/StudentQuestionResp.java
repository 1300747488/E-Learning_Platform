package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQuestionResp {

    private Integer questionId; // 题目ID

    private Integer quizId; // 测验ID

    private String questionType; // 题型

    private String questionText; // 题干

    private String questionImage; // 题干图片地址

    private String optionA; // 选项A

    private String optionB; // 选项B

    private String optionC; // 选项C

    private String optionD; // 选项D

    private String selectedOption; // 学生已保存或已提交的答案

    private String answerText; // 填空题或解答题答案

    private String answerImage; // 解答题图片答案地址

    private String answerStatus; // 作答状态：ANSWERED / UNANSWERED

    private String correctOption; // 正确答案，提交或截止后返回

    private String referenceAnswer; // 填空题或解答题参考答案，提交或截止后返回

    private String explanation; // 题目解析，提交或截止后返回

    private Boolean isCorrect; // 是否答对，提交或截止后返回

    private Integer awardedMarks; // 本题得分，提交或截止后返回

    private Integer marks; // 分值

    private String topic; // 知识点
}
