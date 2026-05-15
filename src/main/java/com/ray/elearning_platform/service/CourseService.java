package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.CourseCreateReq;
import com.ray.elearning_platform.req.CourseUpdateReq;
import com.ray.elearning_platform.resp.CourseDetailResp;
import com.ray.elearning_platform.resp.CourseListResp;

import java.util.List;

public interface CourseService {

    /**
     * 创建课程。
     *
     * @param req 创建课程请求体
     * @return 创建后的课程详情
     */
    CourseDetailResp createCourse(CourseCreateReq req);

    /**
     * 修改课程。
     *
     * @param req 修改课程请求体
     */
    void updateCourse(CourseUpdateReq req);

    /**
     * 删除课程。
     *
     * @param courseId 课程ID
     */
    void deleteCourse(Integer courseId);

    /**
     * 查询课程详情。
     *
     * @param courseId 课程ID
     * @return 课程详情
     */
    CourseDetailResp detail(Integer courseId);

    /**
     * 查询课程列表。
     *
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 课程列表
     */
    List<CourseListResp> listCourses(String category, String keyword);

    /**
     * 学生端查询课程列表，包含是否已加入。
     *
     * @param studentId 学生ID
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 课程列表
     */
    List<CourseListResp> listCoursesForStudent(Integer studentId, String category, String keyword);

    /**
     * 查询教师创建的课程。
     *
     * @param teacherId 教师ID
     * @return 课程列表
     */
    List<CourseListResp> listTeacherCourses(Integer teacherId);
}
