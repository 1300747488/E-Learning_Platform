package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.Quiz;
import com.ray.elearning_platform.resp.QuizDetailResp;
import com.ray.elearning_platform.resp.QuizListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuizMapper {

    // 新增测验
    int insertQuiz(Quiz quiz);

    // 修改测验
    int updateQuiz(Quiz quiz);

    // 修改测验状态
    int updateStatus(@Param("quizId") Integer quizId,
                     @Param("status") String status);

    // 删除测验
    int deleteQuiz(@Param("quizId") Integer quizId);

    // 根据ID查询测验
    Quiz selectById(@Param("quizId") Integer quizId);

    // 查询测验详情
    QuizDetailResp selectQuizDetail(@Param("quizId") Integer quizId);

    // 查询测验列表
    List<QuizListResp> selectQuizList(@Param("courseId") Integer courseId,
                                      @Param("status") String status);
}