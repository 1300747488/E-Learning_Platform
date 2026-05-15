package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import com.ray.elearning_platform.resp.QuizDetailResp;
import com.ray.elearning_platform.resp.QuizListResp;

import java.util.List;

public interface QuizService {

    /**
     * 创建测验。
     *
     * @param req 创建测验请求体
     * @return 创建后的测验详情
     */
    QuizDetailResp createQuiz(QuizCreateReq req);

    /**
     * 修改测验。
     *
     * @param req 修改测验请求体
     */
    void updateQuiz(QuizUpdateReq req);

    /**
     * 发布或关闭测验。
     *
     * @param req 发布状态请求体
     */
    void publish(QuizPublishReq req);

    /**
     * 删除测验。
     *
     * @param quizId 测验ID
     */
    void deleteQuiz(Integer quizId);

    /**
     * 查询测验详情。
     *
     * @param quizId 测验ID
     * @return 测验详情
     */
    QuizDetailResp detail(Integer quizId);

    /**
     * 查询测验列表。
     *
     * @param courseId 课程ID，可为空
     * @param status 测验状态，可为空
     * @return 测验列表
     */
    List<QuizListResp> list(Integer courseId, String status);
}
