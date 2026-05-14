package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import com.ray.elearning_platform.util.JsonData;

public interface QuizService {

    /**
     * 创建测验。
     *
     * @param req 创建测验请求体
     * @return 创建结果，可返回 QuizDetailResp
     */
    JsonData createQuiz(QuizCreateReq req);

    /**
     * 修改测验。
     *
     * @param req 修改测验请求体
     * @return 修改结果
     */
    JsonData updateQuiz(QuizUpdateReq req);

    /**
     * 发布或关闭测验。
     *
     * @param req 发布状态请求体
     * @return 状态修改结果
     */
    JsonData publish(QuizPublishReq req);

    /**
     * 删除测验。
     *
     * @param quizId 测验ID
     * @return 删除结果
     */
    JsonData deleteQuiz(Integer quizId);

    /**
     * 查询测验详情。
     *
     * @param quizId 测验ID
     * @return 测验详情 QuizDetailResp
     */
    JsonData detail(Integer quizId);

    /**
     * 查询测验列表。
     *
     * @param courseId 课程ID，可为空
     * @param status 测验状态，可为空
     * @return 测验列表，元素为 QuizListResp
     */
    JsonData list(Integer courseId, String status);
}
