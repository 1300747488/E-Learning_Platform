package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.CourseCreateReq;
import com.ray.elearning_platform.req.CourseUpdateReq;
import com.ray.elearning_platform.resp.CourseDetailResp;
import com.ray.elearning_platform.resp.CourseListResp;
import com.ray.elearning_platform.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    /**
     * 创建课程。
     *
     * @param req 课程创建请求体，必填；包含 title、description、category 和 teacherId
     * @return 默认空课程详情；后续实现时返回 CourseDetailResp
     */
    @Override
    public CourseDetailResp createCourse(CourseCreateReq req) {
        return null;
    }

    /**
     * 修改课程。
     *
     * @param req 课程修改请求体，必填；courseId 必填，title、description、category、status 为待更新字段
     */
    @Override
    public void updateCourse(CourseUpdateReq req) {

    }

    /**
     * 删除课程。
     *
     * @param courseId 课程ID，必填；要删除的课程ID
     */
    @Override
    public void deleteCourse(Integer courseId) {

    }

    /**
     * 查询课程详情。
     *
     * @param courseId 课程ID，必填；用于查询课程详细信息和教师姓名
     * @return 默认空课程详情；后续实现时返回 CourseDetailResp
     */
    @Override
    public CourseDetailResp detail(Integer courseId) {
        return null;
    }

    /**
     * 查询课程列表。
     *
     * @param category 课程分类，可为空；为空时不按分类筛选
     * @param keyword 搜索关键词，可为空；用于匹配课程标题或描述
     * @return 默认空列表；后续实现时返回 CourseListResp 列表
     */
    @Override
    public List<CourseListResp> listCourses(String category, String keyword) {
        return Collections.emptyList();
    }

    /**
     * 学生端查询课程列表。
     *
     * @param studentId 学生ID，必填；用于返回 joined 字段
     * @param category 课程分类，可为空；为空时不按分类筛选
     * @param keyword 搜索关键词，可为空；用于匹配课程标题或描述
     * @return 默认空列表；后续实现时返回 CourseListResp 列表
     */
    @Override
    public List<CourseListResp> listCoursesForStudent(Integer studentId, String category, String keyword) {
        return Collections.emptyList();
    }

    /**
     * 查询教师课程列表。
     *
     * @param teacherId 教师ID，必填；用于查询该教师创建的课程
     * @return 默认空列表；后续实现时返回课程列表
     */
    @Override
    public List<CourseListResp> listTeacherCourses(Integer teacherId) {
        return Collections.emptyList();
    }
}
