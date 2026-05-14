package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerReq {

    private Integer questionId; // 题目ID

    private String selectedOption; // 学生选择的答案：A / B / C / D

    private String answerText; // 填空题或解答题答案

    private String answerImage; // 解答题图片答案地址

    private String answerStatus; // 作答状态：ANSWERED / UNANSWERED
}
