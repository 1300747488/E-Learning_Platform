package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.Question;
import com.ray.elearning_platform.resp.QuestionDetailResp;
import com.ray.elearning_platform.resp.QuestionListResp;
import com.ray.elearning_platform.resp.StudentQuestionResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    // 新增题目
    int insertQuestion(Question question);

    // 修改题目
    int updateQuestion(Question question);

    // 删除题目
    int deleteQuestion(@Param("questionId") Integer questionId);

    // 根据ID查询题目，评分时需要正确答案
    Question selectById(@Param("questionId") Integer questionId);

    // 查询题目详情
    QuestionDetailResp selectQuestionDetail(@Param("questionId") Integer questionId);

    // 教师端查询题目列表，包含正确答案
    List<QuestionListResp> selectQuestionList(@Param("quizId") Integer quizId);

    // 学生端查询题目列表，不包含正确答案
    List<StudentQuestionResp> selectStudentQuestionList(@Param("quizId") Integer quizId);

    // 根据测验ID查询题目实体，自动评分时使用
    List<Question> selectByQuizId(@Param("quizId") Integer quizId);
}
