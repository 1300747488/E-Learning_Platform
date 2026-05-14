package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.QuizAttempt;
import com.ray.elearning_platform.resp.QuizHistoryResp;
import com.ray.elearning_platform.resp.QuizResultResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuizAttemptMapper {

    int insertAttempt(QuizAttempt quizAttempt); // 新增测验提交记录

    int updateAttempt(QuizAttempt quizAttempt); // 修改测验提交记录

    int updateStatus(@Param("attemptId") Integer attemptId,
                     @Param("status") String status); // 修改作答状态

    QuizAttempt selectById(@Param("attemptId") Integer attemptId); // 根据提交记录ID查询

    QuizAttempt selectByQuizAndStudent(@Param("quizId") Integer quizId,
                                       @Param("studentId") Integer studentId); // 根据测验ID和学生ID查询作答记录

    QuizResultResp selectQuizResult(@Param("attemptId") Integer attemptId); // 查询测验结果

    List<QuizHistoryResp> selectHistoryByStudentId(@Param("studentId") Integer studentId); // 查询学生历史成绩

    List<QuizAttempt> selectByQuizId(@Param("quizId") Integer quizId); // 查询某个测验的提交记录
}
