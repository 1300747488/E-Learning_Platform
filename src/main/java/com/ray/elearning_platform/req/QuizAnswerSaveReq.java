package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswerSaveReq {

    private Integer attemptId; // 作答记录ID

    private Integer quizId; // 测验ID

    private Integer studentId; // 学生ID

    private Integer durationSeconds; // 当前答题用时，单位秒

    private List<AnswerReq> answers; // 已保存的学生答案列表
}
