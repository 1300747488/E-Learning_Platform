package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.CourseCreateReq;
import com.ray.elearning_platform.req.CourseUpdateReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    /**
     * 创建课程接口。
     *
     * @param req 创建课程请求体
     * @return 默认成功响应，后续开发时返回 CourseDetailResp
     */
    @PostMapping
    public JsonData createCourse(@RequestBody CourseCreateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改课程接口。
     *
     * @param req 修改课程请求体
     * @return 默认成功响应
     */
    @PutMapping
    public JsonData updateCourse(@RequestBody CourseUpdateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除课程接口。
     *
     * @param courseId 课程ID
     * @return 默认成功响应
     */
    @DeleteMapping("/{courseId}")
    public JsonData deleteCourse(@PathVariable("courseId") Integer courseId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询课程详情接口。
     *
     * @param courseId 课程ID
     * @return 默认成功响应，后续开发时返回 CourseDetailResp
     */
    @GetMapping("/{courseId}")
    public JsonData detail(@PathVariable("courseId") Integer courseId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询课程列表接口。
     *
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 默认成功响应，后续开发时返回 CourseListResp 列表
     */
    @GetMapping
    public JsonData listCourses(@RequestParam(value = "category", required = false) String category,
                                @RequestParam(value = "keyword", required = false) String keyword) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生端查询课程列表接口。
     *
     * @param studentId 学生ID
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 默认成功响应，后续开发时返回 CourseListResp 列表
     */
    @GetMapping("/student-list")
    public JsonData listCoursesForStudent(@RequestParam("studentId") Integer studentId,
                                          @RequestParam(value = "category", required = false) String category,
                                          @RequestParam(value = "keyword", required = false) String keyword) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询教师创建的课程接口。
     *
     * @param teacherId 教师ID
     * @return 默认成功响应，后续开发时返回课程列表
     */
    @GetMapping("/teacher/{teacherId}")
    public JsonData listTeacherCourses(@PathVariable("teacherId") Integer teacherId) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生加入课程接口。
     *
     * @param courseId 课程ID
     * @param studentId 学生ID
     * @return 默认成功响应
     */
    @PostMapping("/{courseId}/students/{studentId}/join")
    public JsonData joinCourse(@PathVariable("courseId") Integer courseId,
                               @PathVariable("studentId") Integer studentId) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生退出课程接口。
     *
     * @param courseId 课程ID
     * @param studentId 学生ID
     * @return 默认成功响应
     */
    @PostMapping("/{courseId}/students/{studentId}/leave")
    public JsonData leaveCourse(@PathVariable("courseId") Integer courseId,
                                @PathVariable("studentId") Integer studentId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询课程学生接口。
     *
     * @param courseId 课程ID
     * @param status 选课状态，可为空
     * @return 默认成功响应，后续开发时返回 CourseStudentResp 列表
     */
    @GetMapping("/{courseId}/students")
    public JsonData listCourseStudents(@PathVariable("courseId") Integer courseId,
                                       @RequestParam(value = "status", required = false) String status) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询学生课程接口。
     *
     * @param studentId 学生ID
     * @param status 选课状态，可为空
     * @return 默认成功响应，后续开发时返回 StudentCourseResp 列表
     */
    @GetMapping("/by-student/{studentId}")
    public JsonData listStudentCourses(@PathVariable("studentId") Integer studentId,
                                       @RequestParam(value = "status", required = false) String status) {
        return JsonData.buildSuccess();
    }
}
