package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import com.ray.elearning_platform.util.JsonData;

public interface AttemptService {

    /**
     * 学生开始或继续作答。
     *
     * @param quizId 测验ID
     * @param studentId 学生ID
     * @return 作答记录 QuizAttempt 和题目列表
     */
    JsonData startOrContinue(Integer quizId, Integer studentId);

    /**
     * 保存作答进度。
     *
     * @param req 保存答案请求体，包含作答记录ID、测验ID、学生ID、用时和答案列表
     * @return 保存结果
     */
    JsonData saveAnswers(QuizAnswerSaveReq req);

    /**
     * 提交测验。
     *
     * @param req 提交请求体，包含作答记录ID、测验ID、学生ID、用时和答案列表
     * @return 提交结果，可返回 QuizResultResp
     */
    JsonData submit(QuizSubmitReq req);

    /**
     * 查询测验结果。
     *
     * @param attemptId 作答记录ID
     * @return 测验结果 QuizResultResp
     */
    JsonData result(Integer attemptId);

    /**
     * 查询学生历史作答记录。
     *
     * @param studentId 学生ID
     * @return 历史作答列表，元素为 QuizHistoryResp
     */
    JsonData history(Integer studentId);
}
