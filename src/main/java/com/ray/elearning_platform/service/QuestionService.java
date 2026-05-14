package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.QuestionCreateReq;
import com.ray.elearning_platform.req.QuestionUpdateReq;
import com.ray.elearning_platform.util.JsonData;

public interface QuestionService {

    /**
     * 创建题目。
     *
     * @param req 创建题目请求体
     * @return 创建结果，可返回 QuestionDetailResp
     */
    JsonData createQuestion(QuestionCreateReq req);

    /**
     * 修改题目。
     *
     * @param req 修改题目请求体
     * @return 修改结果
     */
    JsonData updateQuestion(QuestionUpdateReq req);

    /**
     * 删除题目。
     *
     * @param questionId 题目ID
     * @return 删除结果
     */
    JsonData deleteQuestion(Integer questionId);

    /**
     * 查询题目详情。
     *
     * @param questionId 题目ID
     * @return 题目详情 QuestionDetailResp
     */
    JsonData detail(Integer questionId);

    /**
     * 教师端查询题目列表。
     *
     * @param quizId 测验ID
     * @return 题目列表，元素为 QuestionListResp
     */
    JsonData listForTeacher(Integer quizId);

    /**
     * 学生端查询题目列表。
     *
     * @param quizId 测验ID
     * @param attemptId 作答记录ID
     * @param showAnswer 是否显示正确答案、参考答案和解析
     * @return 题目列表，元素为 StudentQuestionResp
     */
    JsonData listForStudent(Integer quizId, Integer attemptId, Boolean showAnswer);
}
