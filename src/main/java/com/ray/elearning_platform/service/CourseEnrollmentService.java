package com.ray.elearning_platform.service;

import com.ray.elearning_platform.util.JsonData;

public interface CourseEnrollmentService {

    /**
     * 学生加入课程。
     *
     * @param courseId 课程ID
     * @param studentId 学生ID
     * @return 加入结果，可返回 CourseEnrollment
     */
    JsonData joinCourse(Integer courseId, Integer studentId);

    /**
     * 学生退出课程。
     *
     * @param courseId 课程ID
     * @param studentId 学生ID
     * @return 退出结果
     */
    JsonData leaveCourse(Integer courseId, Integer studentId);

    /**
     * 查询课程下的学生列表。
     *
     * @param courseId 课程ID
     * @param status 选课状态，可为空：ACTIVE / LEFT
     * @return 学生列表，元素为 CourseStudentResp
     */
    JsonData listCourseStudents(Integer courseId, String status);

    /**
     * 查询学生加入的课程列表。
     *
     * @param studentId 学生ID
     * @param status 选课状态，可为空：ACTIVE / LEFT
     * @return 课程列表，元素为 StudentCourseResp
     */
    JsonData listStudentCourses(Integer studentId, String status);
}
