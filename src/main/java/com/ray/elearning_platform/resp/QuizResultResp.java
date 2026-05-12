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

    private LocalDateTime submittedAt; // 提交时间

    private Integer durationSeconds; // 答题用时，单位秒

    private List<AnswerResult> answers; // 每道题作答结果

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnswerResult {

        private Integer questionId; // 题目ID

        private String questionText; // 题干

        private String selectedOption; // 学生选择的答案

        private String correctOption; // 正确答案

        private Boolean isCorrect; // 是否答对

        private Integer awardedMarks; // 本题得分

        private Integer marks; // 本题总分
    }
}