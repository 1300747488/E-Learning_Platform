package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import com.ray.elearning_platform.service.AttemptService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;

@Service
public class AttemptServiceImpl implements AttemptService {

    /**
     * 开始或继续作答。
     *
     * @param quizId 测验ID，必填；用于定位要作答的测验
     * @param studentId 学生ID，必填；用于查询或创建该学生的作答记录
     * @return 默认成功响应；后续实现时返回作答记录和 StudentQuestionResp 列表
     */
    @Override
    public JsonData startOrContinue(Integer quizId, Integer studentId) {
        return JsonData.buildSuccess();
    }

    /**
     * 保存作答进度。
     *
     * @param req 保存答案请求体，必填；attemptId、quizId、studentId、durationSeconds 和 answers 用于保存草稿
     * @return 默认成功响应；后续实现时返回保存结果
     */
    @Override
    public JsonData saveAnswers(QuizAnswerSaveReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 提交测验。
     *
     * @param req 提交请求体，必填；attemptId、quizId、studentId、durationSeconds 和 answers 用于最终提交
     * @return 默认成功响应；后续实现时返回 QuizResultResp
     */
    @Override
    public JsonData submit(QuizSubmitReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验结果。
     *
     * @param attemptId 作答记录ID，必填；用于查询一次提交的主体结果和每题详情
     * @return 默认成功响应；后续实现时返回 QuizResultResp
     */
    @Override
    public JsonData result(Integer attemptId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询学生历史作答记录。
     *
     * @param studentId 学生ID，必填；用于查询该学生所有历史测验记录
     * @return 默认成功响应；后续实现时返回 QuizHistoryResp 列表
     */
    @Override
    public JsonData history(Integer studentId) {
        return JsonData.buildSuccess();
    }
}
