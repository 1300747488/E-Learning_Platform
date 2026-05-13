package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.resp.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnalyticsMapper {

    // 查询学生成绩概览
    StudentSummaryResp selectStudentSummary(@Param("studentId") Integer studentId,
                                            @Param("courseId") Integer courseId);

    // 查询学生成绩趋势
    List<StudentProgressResp> selectStudentProgress(@Param("studentId") Integer studentId,
                                                    @Param("courseId") Integer courseId);

    // 查询薄弱知识点
    List<WeakTopicResp> selectWeakTopic(@Param("studentId") Integer studentId,
                                        @Param("courseId") Integer courseId);

    // 查询排行榜
    List<LeaderboardResp> selectLeaderboard(@Param("courseId") Integer courseId,
                                            @Param("quizId") Integer quizId);

    // 教师查询课程成绩
    List<TeacherCourseScoreResp> selectTeacherCourseScore(@Param("teacherId") Integer teacherId,
                                                          @Param("courseId") Integer courseId,
                                                          @Param("quizId") Integer quizId);
}