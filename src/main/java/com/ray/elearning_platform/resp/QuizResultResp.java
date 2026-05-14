package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultResp {

    private Integer attemptId; // 提交记录ID

    private Integer quizId; // 测验ID

    private String quizTitle; // 测验标题

    private Integer studentId; // 学生ID

    private String studentName; // 学生姓名

    private Integer score; // 学生得分

    private Integer totalMarks; // 测验总分

    private Integer correctCount; // 答对题数

    private Integer wrongCount; // 答错题数

    private String status; // 作答状态

    private LocalDateTime startedAt; // 开始作答时间

    private LocalDateTime submittedAt; // 提交时间

    private Integer durationSeconds; // 答题用时，单位秒

    private List<AnswerResult> answers; // 每道题作答结果

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnswerResult {

        private Integer questionId; // 题目ID

        private String questionType; // 题型

        private String questionText; // 题干

        private String questionImage; // 题干图片地址

        private String optionA; // 选项A

        private String optionB; // 选项B

        private String optionC; // 选项C

        private String optionD; // 选项D

        private String selectedOption; // 学生选择的答案

        private String answerText; // 填空题或解答题答案

        private String answerImage; // 解答题图片答案地址

        private String answerStatus; // 作答状态

        private String correctOption; // 正确答案

        private String referenceAnswer; // 填空题或解答题参考答案

        private String explanation; // 题目解析

        private Boolean isCorrect; // 是否答对

        private Integer awardedMarks; // 本题得分

        private Integer marks; // 本题总分
    }
}
