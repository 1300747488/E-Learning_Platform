package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.StudentAnalyticsQueryReq;
import com.ray.elearning_platform.req.TeacherAnalyticsQueryReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    /**
     * 学生成绩概览接口。
     *
     * @param req 学生分析查询参数
     * @return 默认成功响应，后续开发时返回 StudentSummaryResp
     */
    @GetMapping("/student/summary")
    public JsonData studentSummary(@ModelAttribute StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生成绩趋势接口。
     *
     * @param req 学生分析查询参数
     * @return 默认成功响应，后续开发时返回 StudentProgressResp 列表
     */
    @GetMapping("/student/progress")
    public JsonData studentProgress(@ModelAttribute StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生薄弱知识点接口。
     *
     * @param req 学生分析查询参数
     * @return 默认成功响应，后续开发时返回 WeakTopicResp 列表
     */
    @GetMapping("/student/weak-topics")
    public JsonData weakTopics(@ModelAttribute StudentAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 排行榜接口。
     *
     * @param courseId 课程ID，可为空
     * @param quizId 测验ID，可为空
     * @return 默认成功响应，后续开发时返回 LeaderboardResp 列表
     */
    @GetMapping("/leaderboard")
    public JsonData leaderboard(@RequestParam(required = false) Integer courseId,
                                @RequestParam(required = false) Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 教师课程成绩接口。
     *
     * @param req 教师分析查询参数
     * @return 默认成功响应，后续开发时返回 TeacherCourseScoreResp 列表
     */
    @GetMapping("/teacher/course-scores")
    public JsonData teacherCourseScores(@ModelAttribute TeacherAnalyticsQueryReq req) {
        return JsonData.buildSuccess();
    }
}
