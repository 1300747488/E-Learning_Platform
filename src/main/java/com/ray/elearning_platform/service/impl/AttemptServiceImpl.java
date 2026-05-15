package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import com.ray.elearning_platform.resp.AttemptStartResp;
import com.ray.elearning_platform.resp.QuizHistoryResp;
import com.ray.elearning_platform.resp.QuizResultResp;
import com.ray.elearning_platform.service.AttemptService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService {

    /**
     * 开始或继续作答。
     *
     * @param quizId 测验ID，必填；用于定位要作答的测验
     * @param studentId 学生ID，必填；用于查询或创建该学生的作答记录
     * @return 默认空作答信息；后续实现时返回作答记录和 StudentQuestionResp 列表
     */
    @Override
    public AttemptStartResp startOrContinue(Integer quizId, Integer studentId) {
        return null;
    }

    /**
     * 保存作答进度。
     *
     * @param req 保存答案请求体，必填；attemptId、quizId、studentId、durationSeconds 和 answers 用于保存草稿
     */
    @Override
    public void saveAnswers(QuizAnswerSaveReq req) {

    }

    /**
     * 提交测验。
     *
     * @param req 提交请求体，必填；attemptId、quizId、studentId、durationSeconds 和 answers 用于最终提交
     * @return 默认空结果；后续实现时返回 QuizResultResp
     */
    @Override
    public QuizResultResp submit(QuizSubmitReq req) {
        return null;
    }

    /**
     * 查询测验结果。
     *
     * @param attemptId 作答记录ID，必填；用于查询一次提交的主体结果和每题详情
     * @return 默认空结果；后续实现时返回 QuizResultResp
     */
    @Override
    public QuizResultResp result(Integer attemptId) {
        return null;
    }

    /**
     * 查询学生历史作答记录。
     *
     * @param studentId 学生ID，必填；用于查询该学生所有历史测验记录
     * @return 默认空列表；后续实现时返回 QuizHistoryResp 列表
     */
    @Override
    public List<QuizHistoryResp> history(Integer studentId) {
        return Collections.emptyList();
    }
}
