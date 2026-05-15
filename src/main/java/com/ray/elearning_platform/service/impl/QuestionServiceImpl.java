package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.QuestionCreateReq;
import com.ray.elearning_platform.req.QuestionUpdateReq;
import com.ray.elearning_platform.resp.QuestionDetailResp;
import com.ray.elearning_platform.resp.QuestionListResp;
import com.ray.elearning_platform.resp.StudentQuestionResp;
import com.ray.elearning_platform.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    /**
     * 创建题目。
     *
     * @param req 题目创建请求体，必填；quizId、questionType、questionText、marks 为核心字段，
     *            SINGLE_CHOICE 使用 optionA-D 和 correctOption，
     *            FILL_BLANK / SHORT_ANSWER 使用 referenceAnswer，
     *            questionImage、explanation、topic 可选
     * @return 默认空题目详情；后续实现时返回 QuestionDetailResp
     */
    @Override
    public QuestionDetailResp createQuestion(QuestionCreateReq req) {
        return null;
    }

    /**
     * 修改题目。
     *
     * @param req 题目修改请求体，必填；questionId 必填，其余字段为待更新题目信息
     */
    @Override
    public void updateQuestion(QuestionUpdateReq req) {

    }

    /**
     * 删除题目。
     *
     * @param questionId 题目ID，必填；要删除的题目ID
     */
    @Override
    public void deleteQuestion(Integer questionId) {

    }

    /**
     * 查询题目详情。
     *
     * @param questionId 题目ID，必填；用于查询完整题目信息、答案和解析
     * @return 默认空题目详情；后续实现时返回 QuestionDetailResp
     */
    @Override
    public QuestionDetailResp detail(Integer questionId) {
        return null;
    }

    /**
     * 教师端查询题目列表。
     *
     * @param quizId 测验ID，必填；用于查询该测验下所有题目，包含答案和解析
     * @return 默认空列表；后续实现时返回 QuestionListResp 列表
     */
    @Override
    public List<QuestionListResp> listForTeacher(Integer quizId) {
        return Collections.emptyList();
    }

    /**
     * 学生端查询题目列表。
     *
     * @param quizId 测验ID，必填；用于查询该测验下所有题目
     * @param attemptId 作答记录ID，可为空；不为空时回显学生已保存答案
     * @param showAnswer 是否显示答案，可为空；true 表示返回正确答案、参考答案和解析，false 表示隐藏
     * @return 默认空列表；后续实现时返回 StudentQuestionResp 列表
     */
    @Override
    public List<StudentQuestionResp> listForStudent(Integer quizId, Integer attemptId, Boolean showAnswer) {
        return Collections.emptyList();
    }
}
