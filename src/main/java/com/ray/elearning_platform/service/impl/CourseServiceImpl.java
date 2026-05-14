package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.CourseCreateReq;
import com.ray.elearning_platform.req.CourseUpdateReq;
import com.ray.elearning_platform.service.CourseService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    /**
     * 创建课程。
     *
     * @param req 课程创建请求体，必填；包含 title、description、category 和 teacherId
     * @return 默认成功响应；后续实现时返回 CourseDetailResp
     */
    @Override
    public JsonData createCourse(CourseCreateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改课程。
     *
     * @param req 课程修改请求体，必填；courseId 必填，title、description、category、status 为待更新字段
     * @return 默认成功响应；后续实现时返回修改结果
     */
    @Override
    public JsonData updateCourse(CourseUpdateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除课程。
     *
     * @param courseId 课程ID，必填；要删除的课程ID
     * @return 默认成功响应；后续实现时返回删除结果
     */
    @Override
    public JsonData deleteCourse(Integer courseId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询课程详情。
     *
     * @param courseId 课程ID，必填；用于查询课程详细信息和教师姓名
     * @return 默认成功响应；后续实现时返回 CourseDetailResp
     */
    @Override
    public JsonData detail(Integer courseId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询课程列表。
     *
     * @param category 课程分类，可为空；为空时不按分类筛选
     * @param keyword 搜索关键词，可为空；用于匹配课程标题或描述
     * @return 默认成功响应；后续实现时返回 CourseListResp 列表
     */
    @Override
    public JsonData listCourses(String category, String keyword) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生端查询课程列表。
     *
     * @param studentId 学生ID，必填；用于返回 joined 字段
     * @param category 课程分类，可为空；为空时不按分类筛选
     * @param keyword 搜索关键词，可为空；用于匹配课程标题或描述
     * @return 默认成功响应；后续实现时返回 CourseListResp 列表
     */
    @Override
    public JsonData listCoursesForStudent(Integer studentId, String category, String keyword) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询教师课程列表。
     *
     * @param teacherId 教师ID，必填；用于查询该教师创建的课程
     * @return 默认成功响应；后续实现时返回课程列表
     */
    @Override
    public JsonData listTeacherCourses(Integer teacherId) {
        return JsonData.buildSuccess();
    }
}
