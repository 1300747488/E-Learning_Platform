package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.StudentAnalyticsQueryReq;
import com.ray.elearning_platform.req.TeacherAnalyticsQueryReq;
import com.ray.elearning_platform.util.JsonData;

public interface AnalyticsService {

    /**
     * 查询学生成绩概览。
     *
     * @param req 学生分析查询请求，包含学生ID和可选课程ID
     * @return 学生成绩概览 StudentSummaryResp
     */
    JsonData studentSummary(StudentAnalyticsQueryReq req);

    /**
     * 查询学生成绩趋势。
     *
     * @param req 学生分析查询请求，包含学生ID和可选课程ID
     * @return 学生成绩趋势列表，元素为 StudentProgressResp
     */
    JsonData studentProgress(StudentAnalyticsQueryReq req);

    /**
     * 查询学生薄弱知识点。
     *
     * @param req 学生分析查询请求，包含学生ID和可选课程ID
     * @return 薄弱知识点列表，元素为 WeakTopicResp
     */
    JsonData weakTopics(StudentAnalyticsQueryReq req);

    /**
     * 查询排行榜。
     *
     * @param courseId 课程ID，可为空
     * @param quizId 测验ID，可为空
     * @return 排行榜列表，元素为 LeaderboardResp
     */
    JsonData leaderboard(Integer courseId, Integer quizId);

    /**
     * 教师查询课程成绩。
     *
     * @param req 教师分析查询请求，包含教师ID、课程ID和测验ID
     * @return 教师课程成绩列表，元素为 TeacherCourseScoreResp
     */
    JsonData teacherCourseScores(TeacherAnalyticsQueryReq req);
}
