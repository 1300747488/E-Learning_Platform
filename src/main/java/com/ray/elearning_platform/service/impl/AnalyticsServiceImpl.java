package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.StudentAnalyticsQueryReq;
import com.ray.elearning_platform.req.TeacherAnalyticsQueryReq;
import com.ray.elearning_platform.service.AnalyticsService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    /**
     * 查询学生成绩概览。
     *
     * @param req 学生分析查询请求，必填；studentId 必填，courseId 可选，quizId 当前方法通常不使用
     * @return 默认成功响应；后续实现时返回 StudentSummaryResp
     */
    @Override
    public JsonData studentSummary(StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询学生成绩趋势。
     *
     * @param req 学生分析查询请求，必填；studentId 必填，courseId 可选，按提交时间生成趋势
     * @return 默认成功响应；后续实现时返回 StudentProgressResp 列表
     */
    @Override
    public JsonData studentProgress(StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询学生薄弱知识点。
     *
     * @param req 学生分析查询请求，必填；studentId 必填，courseId 可选，用于按知识点 topic 统计
     * @return 默认成功响应；后续实现时返回 WeakTopicResp 列表
     */
    @Override
    public JsonData weakTopics(StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询排行榜。
     *
     * @param courseId 课程ID，可为空；为空时不按课程筛选
     * @param quizId 测验ID，可为空；为空时不按测验筛选
     * @return 默认成功响应；后续实现时返回 LeaderboardResp 列表
     */
    @Override
    public JsonData leaderboard(Integer courseId, Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 教师查询课程成绩。
     *
     * @param req 教师分析查询请求，必填；teacherId 必填，courseId 和 quizId 可选
     * @return 默认成功响应；后续实现时返回 TeacherCourseScoreResp 列表
     */
    @Override
    public JsonData teacherCourseScores(TeacherAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }
}
