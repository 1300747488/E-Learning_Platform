package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import com.ray.elearning_platform.resp.QuizDetailResp;
import com.ray.elearning_platform.resp.QuizListResp;
import com.ray.elearning_platform.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    /**
     * 创建测验。
     *
     * @param req 测验创建请求体，必填；包含 courseId、title、description、timeLimit、totalMarks、
     *            startTime、endTime 和 createdBy
     * @return 默认空测验详情；后续实现时返回 QuizDetailResp
     */
    @Override
    public QuizDetailResp createQuiz(QuizCreateReq req) {
        return null;
    }

    /**
     * 修改测验。
     *
     * @param req 测验修改请求体，必填；quizId 必填，其余字段为待更新测验信息
     */
    @Override
    public void updateQuiz(QuizUpdateReq req) {

    }

    /**
     * 发布或关闭测验。
     *
     * @param req 测验发布请求体，必填；quizId 为测验ID，status 可选值 PUBLISHED / CLOSED
     */
    @Override
    public void publish(QuizPublishReq req) {

    }

    /**
     * 删除测验。
     *
     * @param quizId 测验ID，必填；要删除的测验ID
     */
    @Override
    public void deleteQuiz(Integer quizId) {

    }

    /**
     * 查询测验详情。
     *
     * @param quizId 测验ID，必填；用于查询测验、课程和创建者信息
     * @return 默认空测验详情；后续实现时返回 QuizDetailResp
     */
    @Override
    public QuizDetailResp detail(Integer quizId) {
        return null;
    }

    /**
     * 查询测验列表。
     *
     * @param courseId 课程ID，可为空；为空时不按课程筛选
     * @param status 测验状态，可为空；可选值 DRAFT / PUBLISHED / CLOSED
     * @return 默认空列表；后续实现时返回 QuizListResp 列表
     */
    @Override
    public List<QuizListResp> list(Integer courseId, String status) {
        return Collections.emptyList();
    }
}
