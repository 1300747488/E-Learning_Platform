package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import com.ray.elearning_platform.resp.AttemptStartResp;
import com.ray.elearning_platform.resp.QuizHistoryResp;
import com.ray.elearning_platform.resp.QuizResultResp;

import java.util.List;

public interface AttemptService {

    /**
     * 学生开始或继续作答。
     *
     * @param quizId 测验ID
     * @param studentId 学生ID
     * @return 作答记录和题目列表
     */
    AttemptStartResp startOrContinue(Integer quizId, Integer studentId);

    /**
     * 保存作答进度。
     *
     * @param req 保存答案请求体，包含作答记录ID、测验ID、学生ID、用时和答案列表
     */
    void saveAnswers(QuizAnswerSaveReq req);

    /**
     * 提交测验。
     *
     * @param req 提交请求体，包含作答记录ID、测验ID、学生ID、用时和答案列表
     * @return 提交后的测验结果
     */
    QuizResultResp submit(QuizSubmitReq req);

    /**
     * 查询测验结果。
     *
     * @param attemptId 作答记录ID
     * @return 测验结果
     */
    QuizResultResp result(Integer attemptId);

    /**
     * 查询学生历史作答记录。
     *
     * @param studentId 学生ID
     * @return 历史作答列表
     */
    List<QuizHistoryResp> history(Integer studentId);
}
