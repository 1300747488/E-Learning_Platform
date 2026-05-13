package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.StudentAnswer;
import com.ray.elearning_platform.resp.QuizResultResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerMapper {

    int insertStudentAnswer(StudentAnswer studentAnswer); // 新增学生答案

    int batchInsertStudentAnswer(@Param("answerList") List<StudentAnswer> answerList); // 批量保存学生答案

    List<StudentAnswer> selectByAttemptId(@Param("attemptId") Integer attemptId); // 根据提交记录ID查询答案

    List<QuizResultResp.AnswerResult> selectAnswerResultByAttemptId(@Param("attemptId") Integer attemptId); // 查询测验结果中的每道题详情
}