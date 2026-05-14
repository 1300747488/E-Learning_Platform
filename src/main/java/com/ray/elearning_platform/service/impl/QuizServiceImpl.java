package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import com.ray.elearning_platform.service.QuizService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    /**
     * 创建测验。
     *
     * @param req 测验创建请求体，必填；包含 courseId、title、description、timeLimit、totalMarks、
     *            startTime、endTime 和 createdBy
     * @return 默认成功响应；后续实现时返回 QuizDetailResp
     */
    @Override
    public JsonData createQuiz(QuizCreateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改测验。
     *
     * @param req 测验修改请求体，必填；quizId 必填，其余字段为待更新测验信息
     * @return 默认成功响应；后续实现时返回修改结果
     */
    @Override
    public JsonData updateQuiz(QuizUpdateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 发布或关闭测验。
     *
     * @param req 测验发布请求体，必填；quizId 为测验ID，status 可选值 PUBLISHED / CLOSED
     * @return 默认成功响应；后续实现时返回状态修改结果
     */
    @Override
    public JsonData publish(QuizPublishReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除测验。
     *
     * @param quizId 测验ID，必填；要删除的测验ID
     * @return 默认成功响应；后续实现时返回删除结果
     */
    @Override
    public JsonData deleteQuiz(Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验详情。
     *
     * @param quizId 测验ID，必填；用于查询测验、课程和创建者信息
     * @return 默认成功响应；后续实现时返回 QuizDetailResp
     */
    @Override
    public JsonData detail(Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验列表。
     *
     * @param courseId 课程ID，可为空；为空时不按课程筛选
     * @param status 测验状态，可为空；可选值 DRAFT / PUBLISHED / CLOSED
     * @return 默认成功响应；后续实现时返回 QuizListResp 列表
     */
    @Override
    public JsonData list(Integer courseId, String status) {
        return JsonData.buildSuccess();
    }
}
